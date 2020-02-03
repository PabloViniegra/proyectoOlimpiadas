/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pablo
 */
public class Deportista {
    //Declaración de atributos de la clase Deportista
    private String nombre;
    private String pais;
    private short numMedallas;
 
    
    //Constructor por defecto
    public Deportista () {
        nombre = "";
        pais = "";
        numMedallas = 0;
       
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
