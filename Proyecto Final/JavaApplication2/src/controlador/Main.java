/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import vista.Formulario;

/**
 *La clase encargada de ejecutar la aplicación.
 * @author pablo
 */
public class Main {

    /**
     * El método main llama al menú de la vista instanciando la clase Formulario.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Formulario f1 = new Formulario();
        f1.menu();
            
            
        
        
    }
    
}
