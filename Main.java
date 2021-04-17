/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht7.main;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonat
 */
public class Main {
   // 
    private static JFileChooser file = new JFileChooser();
    private static JFileChooser file1 = new JFileChooser();
    private static File archivo;
    private static File traducirFile;
    private static Controlador cont = new Controlador();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        boolean hasFile = false; 
        boolean hasTrad = false;
        boolean keep = true;
        
        while (hasFile == false){
            
               System.out.println("Escoja el diccionario inicial .txt");
               file.setApproveButtonText("Guardar");
               int r = file.showSaveDialog(null);
               String path = file.getSelectedFile().getAbsolutePath();
               
               if (r == JFileChooser.APPROVE_OPTION) {
                        archivo = new File(path);
                        Scanner sc = new Scanner(archivo);
                        System.out.println(archivo);
                        hasFile = true;
                        while(sc.hasNextLine()){
                            cont.separarPalabras(sc.nextLine().toLowerCase());
                        //}
                        
                        
                    }
                System.out.println("Diccionario obtenido: \n");
                cont.InOrder();
           
            
        }
        
        
        while (keep == true){
            System.out.print("\n-----------------Menu-----------------"
                        +"\n 1. Abrir nuevo diccionario"+
                        "\n 2. Abrir archivo a traducir"+
                        "\n 3. Traducir"+
                        "\n 4. Salir"+
                        "\n----------------------------------------");
            //Lectura de ingreso
            String ingreso = JOptionPane.showInputDialog("Ingrese la opcion del menu que desee vizualizar: "); 
            if(hasFile == false && !ingreso.equals("1")){
            JOptionPane.showMessageDialog(null, "Debes escoger un diccionario antes de empezar!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                switch(ingreso){
                    case "1":
                        
                             System.out.println("Escoja el diccionario .txt");
                             file.setApproveButtonText("Guardar");
                             int r2 = file.showSaveDialog(null);

                             if (r2 == JFileChooser.APPROVE_OPTION) {
                                 archivo = new File(path);
                                 Scanner sc = new Scanner(archivo);
                                 System.out.println(archivo);
                                 hasFile = true;
                                 while(sc.hasNextLine()){
                                     cont.separarPalabras(sc.nextLine().toLowerCase());
                                 //}
                                 
                                 
                             }
                                 System.out.println("Diccionario obtenido: \n");
                                 cont.InOrder();
                                 }
                             else{
                                 JOptionPane.showMessageDialog(null, "Debes escoger un archivo!", "Warning", JOptionPane.WARNING_MESSAGE);
                             } 
                             
                       
                       break;
                    case "2":
                        
                             System.out.println("\nEscoja el archivo a traducir .txt");
                             file1.setApproveButtonText("Guardar");
                             int r1 = file1.showSaveDialog(null);

                             if (r1 == JFileChooser.APPROVE_OPTION) {
                                     hasTrad = true;
                                     traducirFile = new File(file1.getSelectedFile().getAbsolutePath());
                                     System.out.println(traducirFile);
                                     cont.getTranslateText(traducirFile);
                                     
                                 }
                             else{
                                 JOptionPane.showMessageDialog(null, "Debes escoger un archivo a traducir!", "Warning", JOptionPane.WARNING_MESSAGE);
                             } 
                       
                        break;
                    case "3":
                        if(hasTrad == false){
                            JOptionPane.showMessageDialog(null, "Debes escoger un archivo a traducir!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            boolean keep2 = true;
                             while (keep2 == true){
                                System.out.print("\n-----------------Menu-----------------"
                                        +"\n 1.Espanol a Ingles"+
                                        "\n 2. Espanol a frances"+
                                        "\n 3. Ingles a Espanol"+
                                        "\n 4. Ingles a Frances"+
                                        "\n 5. Frances a Espanol"+
                                        "\n 6. Frances a Ingles"+
                                        "\n----------------------------------------");
                                
                                String ingreso2 = JOptionPane.showInputDialog("Ingrese una opcion");
                                String result = "";
                                switch(ingreso2){
                                    case "1":
                                        result = cont.Translate(1, 0);
                                        keep2 = false;
                                        break;
                                    case "2":
                                        result = cont.Translate(1, 2);
                                        keep2 = false;
                                        break;
                                    case "3":
                                        result = cont.Translate(0, 1);
                                        keep2 = false;
                                        break;
                                    case "4":
                                        result = cont.Translate(0, 2);
                                        keep2 = false;
                                        break;
                                    case "5":
                                        result = cont.Translate(2, 1);
                                        keep2 = false;
                                        break;
                                    case "6":
                                        result = cont.Translate(2, 2);
                                        keep2 = false;
                                        break;
                                    default:
                                    	 JOptionPane.showMessageDialog(null, "Debes escoger una opcion!", "Warning", JOptionPane.WARNING_MESSAGE);
                                    	 break;
                                }
                                System.out.println("\nResultado: \n" + result);
                                result = "";
                             }
                        }
                        break;
                    case "4":
                    	System.exit(0);
                    	break;
                }
            }
        }
    }
    
    }
 }
