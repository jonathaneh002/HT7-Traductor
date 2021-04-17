/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht7.main;

/**
 *
 * @author Jonathan Espinoza 20022
 * @version 16/4/20022
 */
public class Traducciones {
    private String id;
    private String esp;
    private String en;
    private String fr;

    public Traducciones(String id, String esp, String en, String fr) {
        this.id = id;
        this.esp = esp;
        this.en = en;
        this.fr = fr;
    }
    
    public String translate(String language){
        String translated = null;
        
        if(language.equals("en")){
            translated = en;
            
        }else if(language.equals("esp")){
            translated = esp;
            
        }else if(language.equals("fr")){
            translated = fr;
            
        }
        
        return translated;
    }
    
    public String getId(){
        String acId = null;
        
        if(("en").equals(id)){
        	acId = en;
        }
        else if(("esp").equals(id)) {
       
        	acId = esp;
        }
        else if(("fr").equals(id)) {
        
        	acId = fr;
        }
        
        return acId; 
    }
    @Override
    public String toString() {
        return "("+en+", "+esp+", "+fr+")";
    }
    
}
