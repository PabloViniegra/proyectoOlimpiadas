/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Deportista implements Serializable {

    //Declaración de atributos de la clase Deportista
    private String nombre;
    private String pais;
    private short numMedallas;
    
    //ArrayList de medallas
    ArrayList<Medalla> arrMedallas = new ArrayList<>();

    //Constructor por defecto
    public Deportista() {
        nombre = "vacío";
        pais = "vacío";
        numMedallas = 0;
    }

    //Constructor con parámetros
    public Deportista(String nombre, String pais, short numMedallas) {
        this.nombre = nombre;
        this.pais = pais;
        this.numMedallas = numMedallas;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public short getNumMedallas() {
        return numMedallas;
    }

    public void setNumMedallas(short numMedallas) {
        this.numMedallas = numMedallas;
    }

}
