/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionFicheros;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Deportista;
import modelo.Medalla;
import modelo.Medalla.Tipo;

/**
 *
 * @author pablo
 */
public class Formulario {
    
    public void menu() {
        Scanner sc = new Scanner(System.in);
        Formulario f1 = new Formulario();
        Deportista d1 = new Deportista();
        Medalla m1 = new Medalla();
        GestionFicheros gestor = new GestionFicheros();
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
                    d1=f1.pideDatosDeportista();
                    System.out.println("Deportista agregado con éxito");
                    break;
                case 2:
                    System.out.print("Introduzca nombre del deportista a "
                            + "consultar: ");
                    String nombre = sc.nextLine();
                    gestor.consultaDeportista(nombre);
                    break;
                case 3:
                    
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
    
    public Deportista pideDatosDeportista() {
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
        return d1;
    }
    
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
                Tipo tipo = Tipo.ORO;
                System.out.println("Has seleccionado " + tipo.toString());
                break;
            }
            case 2: {
                Tipo tipo = Tipo.PLATA;
                System.out.println("Has seleccionado " + tipo.toString());
                break;
            }
            case 3: {
                Tipo tipo = Tipo.BRONCE;
                System.out.println("Has seleccionado " + tipo.toString());
                break;
            }
            default:
                System.out.println("Dato Incorrecto");
                break;
        }
        System.out.println("____________________________");
        
        return m1;
    }
    

}
