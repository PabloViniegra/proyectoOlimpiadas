/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *La clase Medalla implementa sus atributos y métodos junto con el numerado para
 * definir el tipo de medalla. Tiene getters and setters, así como dos
 * constructores.
 * @author pablo.viniegra
 */
public class Medalla implements Serializable {

    //Atributos de la clase Medalla
    private String pais;
    private short anio;
    private EnumTipoMedalla tipo;

    /**
     * Constructor por defecto.
     */
    public Medalla() {
        pais = "vacio";
        anio = 0;
        tipo=null;

    }

    /**
     * Constructor con parámetros para construir un objeto de tipo Medalla.
     * @param pais
     * @param anio
     * @param tipo 
     */
    public Medalla(String pais, short anio, EnumTipoMedalla tipo) {
        this.pais = pais;
        this.anio = anio;
        this.tipo = tipo;

    }

    //Getters and Setters
    /**
     * Devuelve el atributo pais de un objeto Medalla.
     * @return 
     */
    public String getPais() {
        return pais;
    }
    /**
     * Establece el atributo pais de un objeto Medalla.
     * @param pais 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Devuelve el atributo año de un objeto Medalla.
     * @return 
     */
    public short getAnio() {
        return anio;
    }
    /**
     * Establece el atributo año de un objeto Medalla.
     * @param anio 
     */
    public void setAnio(short anio) {
        this.anio = anio;
    }
    /**
     * Devuelve el atributo tipo de medalla de un objeto Medalla.
     * @return 
     */
    public EnumTipoMedalla getTipo() {
        return tipo;
    }
    /**
     * Establece el atributo tipo de medalla de un objeto Medalla.
     * @param tipo 
     */
    public void setTipo(EnumTipoMedalla tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "{" + this.pais + ", " + this.anio + ", " + this.tipo.name() + "}";
    }

    public String toSQLString() {
        return "\'" + this.pais + "\', " 
                + "\'" + this.anio + "\', " 
                + "\'" + this.tipo.name() + "\'";
    }
    
}
