/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht7.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jonat
 */
public class Controlador {
    private final Key key1 = new Key<String, Traducciones>();
    private final Comparator comparator1 = new Comparator<String, Traducciones>();
    private ArbolBinarioBusqueda treeEn = new ArbolBinarioBusqueda<String, Traducciones>(comparator1, key1);
    private ArbolBinarioBusqueda treeEsp = new ArbolBinarioBusqueda<String, Traducciones>(comparator1, key1);
    private ArbolBinarioBusqueda treeFr = new ArbolBinarioBusqueda<String, Traducciones>(comparator1, key1);
    private String[] translateText;

    
    public Controlador(){
        
    }
    
    public void separarPalabras(String line){

        String[] separate = line.split(",");
        String esp = separate[1];
        String en = separate[0];
        String fr = separate[2];
        
        Traducciones tradEn = new Traducciones("en", esp, en, fr);
        Traducciones tradEsp = new Traducciones("esp", esp, en, fr);
        Traducciones tradFr = new Traducciones("fr", esp, en, fr);
        
        treeEn.Insert(en, tradEn);
        treeEsp.Insert(esp, tradEsp);
        treeFr.Insert(fr, tradFr);
        
        //return treeEn._raiz._key.toString(); Test Unitario
        
    }
    public String[] getTranslateText(File f) throws FileNotFoundException{
        Scanner line = new Scanner(f);
        String text = "";
        
        while(line.hasNextLine()){     
            String transString = (line.nextLine()).toLowerCase();
            
            if(transString.contains(".")) {
            	transString = transString.replace(".", " ");
            }
            
            text = text + " " + transString;
            System.out.println(text);
        }
       
        
        String[] finalText = text.split(" ");
        this.translateText  = finalText;
        
        return finalText;
    }
    public void InOrder(){
        Visit vis = new Visit<String,Traducciones>();
        treeEn.InOrder(vis, treeEn._raiz);
    }
    
    public String Translate(int x, int y){
        String[] id = {"en", "esp", "fr"};
        ArbolBinarioBusqueda[] array = {treeEn, treeEsp, treeFr};
        String result = "";
        
        for(int i = 0; i < translateText.length; i++){
            Traducciones temp = (Traducciones)array[x].Find2(translateText[i], array[x]._raiz);
            if(temp == null){
                 if(translateText[i].equals(".")){
                    result = result +".";
                }else if(translateText[i].equals(" ") || translateText[i].equals("")  ){
                	result = result;
                }
                else {
                	result = result +" *"+translateText[i]+"*";
                }
            }else{
                result = result +" "+temp.translate(id[y].toString()); 

            }
        }
        
        return result;
    }
    
    
    
    
   
}
