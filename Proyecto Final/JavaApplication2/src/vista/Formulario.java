/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionFicheros;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Deportista;
import modelo.EnumTipoMedalla;
import modelo.Medalla;

/**
 *La clase Formulario implementa la vista, esto es, todas las interacciones que
 * va a realizar el usuario con la aplicación.
 * @author pablo
 */
public class Formulario {
    /**
     * El método menu dibuja el menú de la aplicación.
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        Formulario f1 = new Formulario();
        GestionFicheros gestor = new GestionFicheros();
        gestor.crearTablas();
        
        byte numusuario = 0;
        do {
            System.out.println("________MENÚ________");
            System.out.println("");
            System.out.println("1. Insertar deportista");
            System.out.println("2. Consultar deportista");
            System.out.println("3. Generar HTML");
            System.out.println("4. Salir");
            System.out.println("____________________");
            System.out.print("Para elegir una opción introduzca su número"
                    + " correspondiente: ");
            boolean validacion = false;
            while (!validacion) {
                try {
                    numusuario = sc.nextByte();
                    validacion = true;
                } catch (InputMismatchException e) {
                    System.out.println("Introduce el número de la opción del"
                            + " menú");                    
                } finally{
                    sc.nextLine();
                }
            }
            switch (numusuario) {
                
                case 1:
                    f1.pideDatosDeportista();
                    System.out.println("Deportista agregado con éxito");
                    break;
                case 2:
                    System.out.print("Introduzca nombre del deportista a "
                            + "consultar: ");
                    String nombre = sc.nextLine();
                    File fich = gestor.consulta(nombre);
                    gestor.consultaDeportista(fich);
                    break;
                case 3:
                    System.out.println("¿Cómo quieres generar el HTML?");
                    System.out.println("1. Generar un solo fichero HTML");
                    System.out.println("2. Generar todos los ficheros");
                    int aux=0;
                    boolean check = false;
                    while (!check) {
                        try {
                          aux = sc.nextInt();
                          check = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese un número");
                        } finally {
                            sc.nextLine();
                        }
                    }
                    if (aux==1) {
                        System.out.print("Introduzca el nombre del deportista: ");
                        String name = sc.nextLine();
                        File miFichero = gestor.consulta(name);
                        gestor.generarFicheroHTMLsolo(miFichero);
                        System.out.println("HTML generado en el directorio");
                    } else if (aux==2) {
                        gestor.generarFicherosHTML();
                        System.out.println("Ficheros HTML generados");
                    }
                    
                    break;
                case 4:
                    System.out.println("Cerrando la aplicación");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
            
        } while (numusuario != 4);
    }
    /**
     * El método pideDatosDeportista rellena de información un objeto Deportista
     * a través del usuario.
     */
    public void pideDatosDeportista() {
        Deportista d1 = new Deportista();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el nombre del deportista: ");
        d1.setNombre(sc.nextLine());
        
        System.out.print("Introduce su país: ");
        d1.setPais(sc.nextLine());
        boolean validacion = false;
        while (!validacion) {
            try {
                System.out.print("¿Cuántas medallas tiene?: ");
                d1.setNumMedallas(sc.nextShort());
                validacion = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Ha habido un error de tipo"
                        + " InputMismatchException. Introduce un dato válido");
                sc.nextLine();
            }
        }
        
        if (d1.getNumMedallas() > 0) {
            ArrayList<Medalla> arrMedalla = new ArrayList<>();
            for (int i = 0; i < d1.getNumMedallas(); i++) {
                Medalla miMedalla = new Medalla();
                Formulario miFormulario = new Formulario();
                miMedalla = miFormulario.pideDatosMedalla();
                arrMedalla.add(miMedalla);
            }
            d1.setArrMedalla(arrMedalla);
            
        }
        GestionFicheros gestor = new GestionFicheros();
        gestor.ficheroSQL(d1);
        gestor.agregarFicheroOlimpiadas(d1);
        System.out.println("____________________________");
    }
    /**
     * El método pideDatosMedalla rellena un objeto de la clase Medalla y lo
     * devuelve, dado que se la invoca dentro de pideDatosDeportista.
     * @return 
     */
    public Medalla pideDatosMedalla() {
        Medalla m1 = new Medalla();
        Scanner sc = new Scanner(System.in);
        byte aux = 0;
        System.out.println("_______Menú de medallas_______");
        System.out.print("País de la Olimpiada: ");
        m1.setPais(sc.nextLine());
        boolean validacion = false;
        while (!validacion) {
            try {
                System.out.print("Introduce el año: ");
                m1.setAnio(sc.nextShort());
                validacion = true;
            } catch (InputMismatchException e) {
                System.out.println("Ha habido un error de tipo"
                        + " InputMismatchException. Introduce un dato válido");
                sc.nextLine();
            }
        }
        System.out.println("¿Qué tipo de medalla es? Marque su numero");
        System.out.println("1. Oro");
        System.out.println("2. Plata");
        System.out.println("3. Bronce");
        boolean check = false;
        while (!check) {
            try {
                aux = sc.nextByte();
                check = true;
            } catch (InputMismatchException e) {
                System.out.println("Introduce un numero del tipo de medalla"
                        + " que quieres");
                sc.nextLine();
            }
        }
        
        switch (aux) {
            case 1: {
                m1.setTipo(EnumTipoMedalla.ORO);
                System.out.println("Has seleccionado " + m1.getTipo().toString());
                break;
            }
            case 2: {
                m1.setTipo(EnumTipoMedalla.PLATA);
                System.out.println("Has seleccionado " + m1.getTipo().toString());
                break;
            }
            case 3: {
                m1.setTipo(EnumTipoMedalla.BRONCE);
                System.out.println("Has seleccionado " + m1.getTipo().toString());
            }
            default:
                System.out.println("Dato Incorrecto");
                break;
        }
        System.out.println("____________________________");
        
        return m1;
    }
    

}
