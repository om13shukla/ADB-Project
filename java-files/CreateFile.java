/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convsql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CreateFile {
	static File Uid;
	static int tog=0;
	
	public static void setUserID(File uid){
		Uid=uid;
		tog=1;
	}

    @SuppressWarnings("unused")
	public static void LoadData(String filename) {
           String j;
           
        Integer i=0;
    
        String fileName =filename;
        
        String fileName2 = Uid.getName()+".csv";  
        
        String line = null;
        String[] st = null;
        try {
        	
            FileReader fileReader1 = new FileReader(fileName);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            
            FileWriter fileWriter1 = new FileWriter(fileName2,true);
            BufferedWriter brw= new BufferedWriter(fileWriter1);
            
           
            
            for(int q=0;q<6;q++){bufferedReader1.readLine(); } //To ignore FIrst 6 Lines.
            
            while ((line = bufferedReader1.readLine()) != null) {
                    					//st = line.replace("","").split(",");
            		
            		
            		
            							//fileWriter1.write("INSERT INTO country VALUES("
                          				// +st[0]+", "+st[1]+ ", " +st[2]+", "+st[3]+");"+'\n');
            	//if(tog==1){brw.write(" for User:"+Uid.getName() +  '\n' ); tog=0;}
            	brw.write(line + '\n');	
            			
            	//System.out.println(line);
                    
                    i=i+1;
                    
                    					/*TO display no. of lines and records to TEST the result  */
                    
                    				/*  System.out.println("INSERT INTO players VALUES("
                            				+st[0]+", "+st[1]+ ", " +st[2]+ ", " +st[3]
                            				+", " +st[4]+ ", " +st[5]
                            				+");"+'\n' +"" );  */
                  
            }
            System.out.println("Written into: "+fileName2);
            j= i.toString(); 
            	
              	System.out.println("no of lines= " + j );
              	
            
            bufferedReader1.close();  
            brw.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
          
        }
    }

    
}
