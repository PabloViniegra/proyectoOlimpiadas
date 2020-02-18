/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author pablo.viniegra
 */
public class Medalla implements Serializable {
    //Atributos de la clase Medalla
    private String pais;
    private short anio;
    public enum Tipo {
        ORO,PLATA,BRONCE
        
    }
    
    //Constructor por defecto
    public Medalla () {
        pais = "vacio";
        anio = 0;
        
    }
    
    //Constructor con parámetros
    public Medalla (String pais, short anio, Tipo tipo) {
        this.pais=pais;
        this.anio=anio;
        
    }
    
    //Getters and Setters
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    
}
