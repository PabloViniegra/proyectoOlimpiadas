/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.io.FileWriter;
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
        byte numusuario;
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
            numusuario = sc.nextByte();

            switch (numusuario) {
                case 1:
                   
                    break;
                case 2:
                    System.out.println("Lorem Ipsum");
                    break;
                case 3:
                    System.out.println("Lorem Ipsum");
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
        System.out.print("¿Cuántas medallas tiene?: ");
        d1.setNumMedallas(sc.nextShort());
        if (d1.getNumMedallas()>0) {
            Medalla miMedalla = new Medalla ();
            Formulario miFormulario = new Formulario ();
            miMedalla= miFormulario.pideDatosMedalla();
        }
        System.out.println("____________________________");
        
        try {
            File archivo = new File(d1.getNombre()+".olimpiadas");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe");
            }
            
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(d1.getNombre());
            escribir.write(d1.getPais());
            escribir.write(d1.getNumMedallas());
            System.out.println("Se ha escrito el fichero con éxito");
        } catch (IOException e) {
            System.out.println("Un error ha ocurrido de tipo IOException");
            Formulario form = new Formulario();
            form.pideDatosDeportista();
        }
        return d1;
    }

    public Medalla pideDatosMedalla() {
        Medalla m1 = new Medalla();
        Scanner sc = new Scanner(System.in);
        int aux;
        System.out.println("_______Menú de medallas_______");
        System.out.print("País de la Olimpiada: ");
        m1.setPais(sc.nextLine());
        System.out.print("Introduce el año: ");
        m1.setAnio(sc.nextShort());
        System.out.print("¿Qué tipo de medalla es? Marque su numero");
        System.out.println("1. ORO");
        System.out.println("2. PLATA");
        System.out.println("3. BRONCE");
        aux = sc.nextInt();
        switch (aux) {
            case 1:
                {
                    Tipo tipo = Tipo.ORO;
                    System.out.println("Has seleccionado " + tipo.toString());
                    break;
                }
            case 2:
                {
                    Tipo tipo = Tipo.PLATA;
                    System.out.println("Has seleccionado " + tipo.toString());
                    break;
                }
            case 3:
                {
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
    public void muestraDatos ( Deportista d, Medalla m) {
        System.out.println("________Datos Introducidos________");
        System.out.println("Nombre deportista: " + d.getNombre());
        System.out.println("País del deportitsa: " + d.getPais());
        System.out.println("Número de medallas: " + d.getNumMedallas());
        System.out.println("Ahora la medalla:");
        System.out.println("País de la Olimpiada: " + m.getPais());
        System.out.println("Año: " + m.getAnio());
        System.out.println("Tipo de medalla: " + tipo.toString);
        System.out.println("____________________________");
    }
}
