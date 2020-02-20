/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Deportista;
import modelo.Medalla;

/**
 *
 * @author pabli
 */
public class GestionFicheros  {
    
    public void ficheroSQL (Deportista d) {
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
                    + " VALUES (" + d.getNombre() + ", "+ d.getPais() + ", "
                    + d.getNumMedallas() + ")");
            escritor.write("INSERT INTO Medallas (paisOlimpiada,anio,tipoMedalla) VALUES (" + d.getArrMedalla() + " )");
        } catch (IOException e) {
            System.out.println("Un error de tipo IOException");
        }
        

    }
    
}
