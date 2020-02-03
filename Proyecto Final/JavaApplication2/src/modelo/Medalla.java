/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pablo.viniegra
 */
public class Medalla {
    //Atributos de la clase Medalla
    private String pais;
    private short anio;
    private String tipoMedalla;
    
    //Constructor por defecto
    public Medalla () {
        pais = "";
        anio = 0;
        tipoMedalla = "";
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

    public String getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(String tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }
    
}
