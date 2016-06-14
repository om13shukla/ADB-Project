/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convsql;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.TabableView;

import convsql.project2.ConnectionProvider;


public class LoadDB {
	
	String[] st = null;
	

   
	public static void LoadData() {
           String j;
           
        Double i=0.0;
    
        String fileName ="010.CSV";
        //String tablename=tname;
        
        
        String line = null;
        String[] st = null;
        try {
        	
            FileReader fileReader1 = new FileReader(fileName);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            
            Connection con= ConnectionProvider.getConn();    
           
            for(int j1=0;j1<807674  ;j1++){line = bufferedReader1.readLine();}
            System.out.println("Loading file "+fileName+" into DB ");
            while ((line = bufferedReader1.readLine()) != null) {
            	
            	st = line.replace("","").split(",");
        		
        		
        		
        		System.out.println("INSERT INTO u010 VALUES(" 
									+st[0]+", "+st[1]+ ", " +st[2]+", "+st[3]+", "
											+st[4]+", "+st[5]+", "+st[6]+");");    
            	
            	
			/*		PreparedStatement ps = con.prepareStatement("insert into u010 values(?,?,?,?,?,?,?)");
            	ps.setString(1, st[0]);
            	ps.setString(2, st[1]);
				ps.setString(3, st[2]);
				ps.setString(4, st[3]);
				ps.setString(5, st[4]);
				ps.setString(6, st[5]);
				ps.setString(7, st[6]);
				
                  ps.execute();     */
                  i=i+1;
            
            }
            System.out.println("File loaded to DB");
            j= i.toString(); 
            	
             	System.out.println("no of lines= " + j );
              	
            con.close();
            bufferedReader1.close();
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
          
        } catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
}
