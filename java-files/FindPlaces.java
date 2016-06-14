package convsql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.ResultSet;



import convsql.project2.ConnectionProvider;

public class FindPlaces {
	
	public static Connection con= ConnectionProvider.getConn();  
   
	@SuppressWarnings("deprecation")
	public static void FindPlaces(String filenm, String tname) throws SQLException, IOException {
        
           
        Double i=0.0,lt,lg,ts1,ts2;
        int n=0;
        Date dt1,dt2;
        Time t1,t2=new Time(00,57,35); 
        
       String fileName ="Places-"+filenm+".csv";
       FileWriter fileWriter1 = new FileWriter(fileName,true);
       BufferedWriter brw= new BufferedWriter(fileWriter1);
        
        
        StringBuffer line=new StringBuffer();
       
        
         
	
		
		PreparedStatement ps = con.prepareStatement("select latitude,longitude,date,time from "+ tname+ ";");
		ResultSet rs1=ps.executeQuery();
		
		System.out.println(tname +" into- " +fileName +" ");
		
		
		if(rs1!=null ){
			rs1.previous();
			
		while (rs1.next()) {
			
			
			dt1=rs1.getDate("date");
			t1=rs1.getTime("time");
			long diff=t1.getTime()-t2.getTime();
				 diff= (diff/1000);
				 										//	 System.out.println("seconds:" +diff);
				if(diff>=600 && diff<=3600 ){    		//(|| t1.getHours()!=t2.getHours())
					n=n+1;
														//System.out.println(t1.getMinutes()+ "- "+t2.getMinutes()+"=" +(t1.getMinutes()-t2.getMinutes()));
				
					lt=rs1.getDouble("latitude");
					lg=rs1.getDouble("longitude");
				
			
					line.append(lt.toString());
					line.append(", ");
					line.append(lg.toString());   // System.out.println(line.toString());
				
					line.append(", ");
					line.append(dt1.toString());
					line.append(", ");
					line.append(t1.toString());  					
					brw.write(line.toString());
					brw.write('\n');
					
					line.delete(0, line.length()); 
					}       
			
			
			dt2=rs1.getDate("date");
			t2=rs1.getTime("time");
			
						
			i=i+1;  
			} 
		System.out.println("No of Places found: "+n);
		System.out.println("No of Rows processed: "+i);   
		} 
			rs1.close();
	       
	       brw.close();
        	
        }
        
	}


