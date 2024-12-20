/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author gardh
 */
public class DataModel {
     private static String data;
     private static String position;
   private static int offID;
   private static int kg_ID;
    private static int dataInt;
    private static double dataD;
    private static int dataID;
        
    
    public static int getDataoffID(){
                return offID;
        }
        
        public static void setDataoffID(int newData){
                offID = newData;
        }
        
    public static int getDatakgID(){
                return kg_ID;
        }
        
        public static void setDatakgID(int newData){
                kg_ID = newData;
        }
    public static String getDataName(){
                return data;
        }
        
        public static void setDataName(String newData){
                data = newData;
        }
    public static String getDataPos(){
                return position;
        }
        
        public static void setDataPos(String newData){
                position = newData;
        }
        
        public static int getDataInt(){
                return dataInt;
        }
          
            public static void setDataInt(int newData){
                dataInt = newData;
        }
            
              public static double getDataDouble(){
                return dataD;
        }
          
            public static void setDatDouble(double newData){
                dataD = newData;
        }
               public static int getDataID(){
                return dataID;
        }
          
            public static void setDataID(int newData){
                dataID = newData;
        }
            
}

