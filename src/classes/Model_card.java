/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author gardh
 */


public class Model_card {

  
    public String getTitle() {
        return title;
    }

   
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

  
 
   
    
    public Model_card(String title, String values){
    
        this.title = title;
        this.values = values;
      
    }
    
     private String title;
    private String values;
    
}
