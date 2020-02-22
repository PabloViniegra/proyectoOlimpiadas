/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import modelo.Deportista;
import modelo.Medalla;
import vista.Formulario;

/**
 *
 * @author pablo
 */
public class GestionFicheros {

    public void ficheroSQL(Deportista d) {
        try {
            File ficherosql = new File("olimpiadas.sql");
            if (ficherosql.createNewFile()) {
                System.out.println("Fichero SQL creado: " + ficherosql.getName());
            } else {
                System.out.println("El fichero SQL ya existe");
            }
            FileWriter escritor = new FileWriter(ficherosql);
            escritor.write("CREATE DATABASE MisOlimpiadas");
            escritor.write("USE MisOlimpiadas");
            escritor.write("CREATE TABLE Deportistas (IdDeportista int identity"
                    + " (1,1) CONSTRAINT pk_Deportistas PRIMARY KEY,nombre"
                    + " varchar(30) DEFAULT 'vacio', pais varchar (40) DEFAULT"
                    + " 'vacio', numMedallas int DEFAULT 0 CONSTRAINT"
                    + " ck_numeromedallas CHECK (numMedallas >= 0), );");
            escritor.write("CREATE TABLE Medallas (IdMedalla int identity (1,1)"
                    + " CONSTRAINT pk_Medallas PRIMARY KEY, IdDeportista int"
                    + " CONSTRAINT fk_idDeportista FOREIGN KEY REFERENCES"
                    + " Deportistas (IdDeportista),"
                    + " paisOlimpiada varchar (30) DEFAULT 'vacio', anio int"
                    + " DEFAULT 0 CONSTRAINT ck_anio CHECK (anio >1900),"
                    + " tipoMedalla varchar (20) DEFAULT 'vacio' CONSTRAINT"
                    + " ck_tipomedalla CHECK (tipoMedalla='Oro' OR tipoMedalla"
                    + "='Plata' OR tipoMedalla='Bronce'));");
            escritor.write("INSERT INTO Deportistas (nombre,pais,numMedallas)"
                    + " VALUES (" + d.getNombre() + ", " + d.getPais() + ", "
                    + d.getNumMedallas() + ")");
            escritor.write("INSERT INTO Medallas (paisOlimpiada,anio,"
                    + "tipoMedalla) VALUES (" + d.getArrMedalla() + " )");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de tipo IOException");
        }

    }

    public void agregarFicheroOlimpiadas(Deportista d) {
        FileOutputStream canal = null;
        try {
            File archivo = new File(d.getNombre() + ".olimpiadas");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe");
            }
            canal = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(canal);
            escribir.writeObject(d);
            System.out.println("Se ha escrito el fichero correctamente");

        } catch (IOException e) {
            System.out.println("Un error ha ocurrido de tipo IOException");
            Formulario form = new Formulario();
            form.pideDatosDeportista();
        } finally {
            try {
                canal.close();
                System.out.println("Flujo de datos cerrado");
            } catch (IOException e) {
                System.out.println("Error de tipo IOException en el cierre del"
                        + " flujo de datos");
            }
        }
    }

    public void consultaDeportista(String deportista) {
        Deportista temporal;
        deportista = deportista.concat(".olimpiadas");
        File lectura = new File(deportista);
        FileInputStream canal = null;
        try {
            Scanner teclado = new Scanner(System.in);
            canal = new FileInputStream(lectura);
            ObjectInputStream ficheroleido = new ObjectInputStream(canal);
            File f = new File(deportista);
            if (f.exists()) {
                temporal = (Deportista) ficheroleido.readObject();
                System.out.println("Nombre: " + temporal.getNombre());
                System.out.println("Pais: " + temporal.getPais());
                System.out.println("Número de medallas: "
                        + temporal.getNumMedallas());
                System.out.println("Medallas: " + temporal.getArrMedalla());

            } else {
                System.out.println("No se ha encontrado el nombre del"
                        + " Deportista. Prueba otra vez");
                GestionFicheros gestor = new GestionFicheros();
                gestor.consultaDeportista(deportista);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo. Quizás no exista "
                    + "en el directorio");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de tipo IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("Ha ocurrido un error de tipo"
                    + " ClassNotFoundException");
        } finally {
            try {
                canal.close();
            } catch (IOException e) {
                System.out.println("Error de tipo IOException al cerrar el"
                        + " fichero");
            }
        }

    }
    
    public void generarFicherosHTML (Deportista d) {
        String aux = d.getNombre();
        aux = aux.concat(".olimpiadas");
        File fichero = new File(aux);
        if (fichero.exists()) {
            File html = new File(d.getNombre() + ".html");
            FileOutputStream canal= null;
            
            try {
                canal = new FileOutputStream(html);
                ObjectOutputStream escribir = new ObjectOutputStream(canal);
                escribir.writeUTF("<!DOCTYPE html> <html lang=\"es\"> <head>"
                        + " <title>" + d.getNombre()+ "</title> <meta charset"
                                + " = \"UTF-8\"> </head> <style> body"
                                + " { font-family: Times New Roman;"
                                + " font-size:16px; background-color:lightgray;"
                                + "color:white;} <body> <br><br><br> <h4>Nombre:"
                                + " " + d.getNombre() + "</h4> <br> <h4> Pais:"
                                        + " " + d.getPais() + "</h4> <br> <h4>"
                                                + " Número de medallas: "
                        + d.getNumMedallas() + "</h4> <br> <h4> Medallas:"
                                + " " + d.getArrMedalla() + "</h4> <br>"
                                        + " </body> </html>");
            }catch (IOException e) {
                System.out.println("Ha ocurrido un error de tipo IOException");
            } finally {
                try {
                    canal.close();
                } catch (IOException e) {
                    System.out.println("Error de tipo IOException al cerrar el "
                            + "fichero");
                }
            }
        } else {
            System.out.println("No existen los archivos");
        }
    }

}
