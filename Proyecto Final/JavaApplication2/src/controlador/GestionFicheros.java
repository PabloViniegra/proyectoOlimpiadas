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
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Deportista;
import modelo.Medalla;
import vista.Formulario;

/**
 *
 * @author pablo La clase GestionFicheros se encarga de administrar y gestionar
 * todas las operaciones relacionadas con la creacion, escritura y lectura de
 * ficheros desde el controlador
 */
public class GestionFicheros {

    /**
     * El método crearTablas se encarga de crear la parte estática del fichero
     * SQL, es decir, el bloque que solo se genera una vez y no va a variar como
     * son las instrucciones para crear la BBDD y sus tablas.
     */
    public void crearTablas() {
        FileWriter escritor = null;
        try {
            File ficherosql = new File("olimpiadas.sql");
            escritor = new FileWriter(ficherosql, true);
            escritor.write("-- CREACION DE TABLAS \n");
            escritor.write("CREATE DATABASE MisOlimpiadas \n");
            escritor.write("USE MisOlimpiadas \n");
            escritor.write("CREATE TABLE Deportistas (IdDeportista int identity"
                    + " (1,1) CONSTRAINT pk_Deportistas PRIMARY KEY,nombre"
                    + " varchar(30) DEFAULT 'vacio', pais varchar (40) DEFAULT"
                    + " 'vacio', numMedallas int DEFAULT 0 CONSTRAINT"
                    + " ck_numeromedallas CHECK (numMedallas >= 0), ); \n");
            escritor.write("CREATE TABLE Medallas (IdMedalla int identity (1,1)"
                    + " CONSTRAINT pk_Medallas PRIMARY KEY, IdDeportista int"
                    + " CONSTRAINT fk_idDeportista FOREIGN KEY REFERENCES"
                    + " Deportistas (IdDeportista),"
                    + " paisOlimpiada varchar (30) DEFAULT 'vacio', anio int"
                    + " DEFAULT 0 CONSTRAINT ck_anio CHECK (anio >1900),"
                    + " tipoMedalla varchar (20) DEFAULT 'vacio' CONSTRAINT"
                    + " ck_tipomedalla CHECK (tipoMedalla='Oro' OR tipoMedalla"
                    + "='Plata' OR tipoMedalla='Bronce')); \n");
            escritor.write("-- FIN CREACION DE TABLAS \n");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de tipo IOException. "
                    + e.getMessage());
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
                System.out.println("Flujo de datos cerrado");
            } catch (IOException e) {
                System.out.println("Error de tipo IOException en el cierre del"
                        + " flujo de datos " + e.getMessage());
            }
        }
    }

    /**
     * El método ficheroSQL administra la generación del bloque dinámico del
     * fichero SQL, básicamente las instrucciones de inserción de deportistas y
     * medallas.
     *
     * @param d
     */
    public void ficheroSQL(Deportista d) {
        FileWriter escritor = null;
        try {
            File ficherosql = new File("olimpiadas.sql");
            escritor = new FileWriter(ficherosql, true);
            escritor.write("-- COMIENZO DE INSERCIONES PARA " + d.getNombre()
                    + "\n");
            escritor.write("INSERT INTO Deportistas (nombre,pais,numMedallas)"
                    + " VALUES (" + "\'" + d.getNombre() + "\'" + ", " + "\'"
                    + d.getPais() + "\'" + ", "
                    + d.getNumMedallas() + ") \n");

            for (Medalla m : d.getArrMedalla()) {
                escritor.write("INSERT INTO Medallas (paisOlimpiada,anio,"
                        + "tipoMedalla) VALUES (" + m.toSQLString() + " ) \n");
            }
            escritor.write("-- FIN DE INSERCIONES PARA " + d.getNombre() + "\n");
            escritor.flush();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de tipo IOException. "
                    + e.getMessage());
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
                System.out.println("Flujo de datos cerrado");
            } catch (IOException e) {
                System.out.println("Error de tipo IOException en el cierre del"
                        + " flujo de datos " + e.getMessage());
            }
        }

    }

    /**
     * El método agregarFicheroOlimpiadas recibe un parámetro de objeto
     * Deportista y genera un fichero con extension .olimpiadas por cada objeto
     * creado.
     *
     * @param d
     */
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
            System.out.println("Un error ha ocurrido de tipo IOException. "
                    + e.getMessage());
            Formulario form = new Formulario();
            form.pideDatosDeportista();
        } finally {
            try {
                if (canal != null) {
                    canal.close();
                }
                System.out.println("Flujo de datos cerrado");
            } catch (IOException e) {
                System.out.println("Error de tipo IOException en el cierre del"
                        + " flujo de datos. " + e.getMessage());
            }
        }
    }

    /**
     * El método consultaDeportista recibe un parámetro String que introduce el
     * usuario y busca el fichero.olimpiadas deseado mostrándolo en consola.
     *
     * @param deportista
     */
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
                    + "en el directorio. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de tipo IOException. "
                    + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Ha ocurrido un error de tipo"
                    + " ClassNotFoundException. " + e.getMessage());
        } finally {
            try {
                if (canal != null) {
                    canal.close();
                }
            } catch (IOException e) {
                System.out.println("Error de tipo IOException al cerrar el"
                        + " fichero. " + e.getMessage());
            }
        }

    }

    /**
     * El método generarFicherosHTML se encarga de generar un fichero .html de
     * un deportista por cada fichero .olimpiadas que encuentra en el directorio
     * . Por lo tanto, es importante que exista previamente el fichero
     * .olimpiadas.
     *
     */
    public void generarFicherosHTML() {
        FileInputStream canalOlimpiadas = null;
        FileWriter escribir = null;
        File dir = new File(".");
        Deportista d;

        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".olimpiadas");
            }
        });
        for (File ficheroOlimpiadas : files) {

            try {
                canalOlimpiadas = new FileInputStream(ficheroOlimpiadas);
                ObjectInputStream ficheroOlimpiadasLeido = new
                ObjectInputStream(canalOlimpiadas);
                d = (Deportista) ficheroOlimpiadasLeido.readObject();

                File html = new File(d.getNombre() + ".html");
                escribir = new FileWriter(html);
                escribir.write("<!DOCTYPE html> <html lang=\"es\">");

                escribir.write("<head>"
                        + " <title>" + d.getNombre() + "</title> <meta charset"
                        + " = \"UTF-8\"> </head> <style> body"
                        + " { font-family: Times New Roman;"
                        + " font-size:16px; background-color:black;"
                        + "color:white;margin:auto;text-align:center;}"
                        + " </style> <body> <br><br><br> <h4>Nombre:"
                        + " " + d.getNombre() + "</h4> <br> <h4> Pais:"
                        + " " + d.getPais() + "</h4> <br> <h4>"
                        + " Número de medallas: "
                        + d.getNumMedallas() + "</h4> <br>");
                for (Medalla m : d.getArrMedalla()) {
                    escribir.write("<h4> Medallas:" + m.toString() +
                            "</h4> <br>");
                }

                escribir.write("</body> </html>");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error de tipo IOException. "
                        + e.getMessage());

            } catch (ClassNotFoundException e) {
                System.out.println("Ha ocurrido un error de tipo"
                        + " ClassNotFoundException. " + e.getMessage());

            } finally {
                try {
                    if (canalOlimpiadas != null) {
                        canalOlimpiadas.close();
                    }

                    if (escribir != null) {
                        escribir.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error de tipo IOException al cerrar el "
                            + "fichero. " + e.getMessage());
                }
            }
        }
    }

}
