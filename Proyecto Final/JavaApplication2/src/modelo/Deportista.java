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
    private ArrayList<Medalla> arrMedalla = new ArrayList<>();
    //Declaración de atributos de la clase Deportista
    private String nombre;
    private String pais;
    private short numMedallas;
    //ArrayList de medallas
    

    //Constructor por defecto
    public Deportista() {
        nombre = "vacío";
        pais = "vacío";
        numMedallas = 0;
        arrMedalla=null;
    }

    //Constructor con parámetros
    public Deportista(String nombre, String pais, short numMedallas, ArrayList
            <Medalla> arrMedalla) {
        this.nombre = nombre;
        this.pais = pais;
        this.numMedallas = numMedallas;
        this.arrMedalla = arrMedalla;
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

    public ArrayList<Medalla> getArrMedalla() {
        return arrMedalla;
    }

    public void setArrMedalla(ArrayList<Medalla> arrMedalla) {
        this.arrMedalla = arrMedalla;
    }

}
