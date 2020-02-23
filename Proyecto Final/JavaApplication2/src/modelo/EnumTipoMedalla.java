/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *El enumerado del tipo de Medalla para poder elegir el tipo de la medalla.
 * @author pablo
 */
public enum EnumTipoMedalla {
    ORO, PLATA, BRONCE;

    public static EnumTipoMedalla getORO() {
        return ORO;
    }

    public static EnumTipoMedalla getPLATA() {
        return PLATA;
    }

    public static EnumTipoMedalla getBRONCE() {
        return BRONCE;
    }


}
