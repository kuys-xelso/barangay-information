/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author gardh
 */


public class modelOfficialcard {

  
    public String getTitle() {
        return name;
    }

   
    public void setTitle(String title) {
        this.name = title;
    }

    
    public String getValues() {
        return position;
    }

    public void setValues(String values) {
        this.position = values;
    }

  public ImageIcon getImage() {
        return image;
    }

    public void setImage( ImageIcon image) {
        this.image = image;
    }
 
   
    
    public modelOfficialcard(String title, String values,ImageIcon image){
    
        this.name = title;
        this.position = values;
        this.image = image;
    }
    
     private String name;
    private String position;
    private ImageIcon image;
}
