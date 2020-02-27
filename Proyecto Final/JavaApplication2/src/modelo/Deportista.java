/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *La clase Deportista implementa sus atributos y métodos junto con el arraylist
 * de Medallas. Tiene getters and setter, así como dos constructores.
 * @author pablo
 */   
public class Deportista implements Serializable {
    
    //Declaración de atributos de la clase Deportista
    private String nombre;
    private String pais;
    private short numMedallas;
    //ArrayList de medallas
    private ArrayList<Medalla> arrMedalla = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public Deportista() {
        nombre = "vacío";
        pais = "vacío";
        numMedallas = 0;
        arrMedalla=null;
    }

    /**
     * Constructor con parámetros que construye un objeto de la clase Deportista
     * con sus atributos.
     * @param nombre
     * @param pais
     * @param numMedallas
     * @param arrMedalla 
     */
    public Deportista(String nombre, String pais, short numMedallas, ArrayList
            <Medalla> arrMedalla) {
        this.nombre = nombre;
        this.pais = pais;
        this.numMedallas = numMedallas;
        this.arrMedalla = arrMedalla;
    }

    //Getters and Setters
    /**
     * Devuelve el atributo nombre de un objeto Deportista.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el atributo nombre de un objeto Deportista.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el atributo pais de un objeto Deportista.
     * @return 
     */
    public String getPais() {
        return pais;
    }
    /**
     * Establece el atributo pais de un objeto Deportista.
     * @param pais 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Devuelve el atributo numero de medallas de un objeto Deportista.
     * @return 
     */
    public short getNumMedallas() {
        return numMedallas;
    }
    /**
     * Establece el atributo numero de medallas de un objeto Deportista.
     * @param numMedallas 
     */
    public void setNumMedallas(short numMedallas) {
        this.numMedallas = numMedallas;
    }
    /**
     * Devuelve el arraylist de medallas de un objeto Deportista.
     * @return 
     */
    public ArrayList<Medalla> getArrMedalla() {
        return arrMedalla;
    }
    /**
     * Establece el arraylist de medallas de un objeto Deportista.
     * @param arrMedalla 
     */
    public void setArrMedalla(ArrayList<Medalla> arrMedalla) {
        this.arrMedalla = arrMedalla;
    }

}
