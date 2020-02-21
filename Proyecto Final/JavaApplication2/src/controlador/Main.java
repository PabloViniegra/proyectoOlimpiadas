/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import vista.Formulario;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Formulario f1 = new Formulario();
        boolean validacion = false;
        while (!validacion) {
            f1.menu();
            validacion= true;
        }
            
        
        
    }
    
}
