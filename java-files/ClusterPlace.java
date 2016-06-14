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
import java.util.ArrayList;
import java.util.List;

import convsql.project2.ConnectionProvider;

import java.sql.ResultSet;
import java.math.*;



public class ClusterPlace {

	
	static Integer R=6371;
	static Double  lat1=0.0,lat2=0.0,long1=0.0,long2=0.0,latDiff,longDiff,a,c,dist;
	static Integer i=1,n=0,f1=0;
	public static Connection con= ConnectionProvider.getConn();  

	static List<LatLong> latlong = new ArrayList<LatLong>();
	static List<LatLong> centroid = new ArrayList<LatLong>();
	
	static Date dt1,dt2;
     static Time t1,t2=new Time(00,57,35); 
	static ResultSet rs1;
	
	static LatLong l1,l2;
	static String fileName ="places-006.csv";
	static String fileName2 ="Clustering-u006.csv";
     
     
    static StringBuffer line=new StringBuffer();
	
	
	
	
	private static Double DegtoRad(Double value) {
        return value * Math.PI / 180;
    }
	
	
	public static void clusterPlace() throws SQLException, IOException{
		
		String[] st = null;
		
		FileReader fileReader1 = new FileReader(fileName);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		
        FileWriter fileWriter1 = new FileWriter(fileName2,true);
        BufferedWriter brw= new BufferedWriter(fileWriter1);
		
		
		
		
		
			
			while ((line.append( bufferedReader1.readLine())) != null){
				st = line.toString().replace("","").split(",");
				
				if(line.length()<5){
					f1=1;
            		break;}
				//System.out.println("lat:"+st[0]+" Long:"+st[1]); 
				
				lat1= Double.parseDouble(st[0]);
				long1=Double.parseDouble(st[1]);
					
				/*	{
							l1.setLatt(lat1);
							l1.setLongt(long1);
							centroid.add(l1);
						}*/
				
				n=0;
				brw.write(i+"-> "+lat1.toString()+", "+long1.toString()+'\n');
				PreparedStatement ps = con.prepareStatement("select latitude,longitude,date,time from u006;");
				 rs1=ps.executeQuery();
				
				
				 
						while (rs1.next()) {
							
							if(f1==1){
								
			            		break;}
							
							lat2=rs1.getDouble("latitude");
							long2=rs1.getDouble("longitude");
								
							/*{
									l2.setLatt(lat2);
									l2.setLongt(long2);
									latlong.add(l2);
								}
							*/
							
							
							latDiff=DegtoRad(lat2-lat1);
							longDiff=DegtoRad(long2-long1);
							
							
							dt1=rs1.getDate("date");
							t1=rs1.getTime("time");
							long diff=t1.getTime()-t2.getTime();
								 diff= (diff/1000);
							t2=rs1.getTime("time");
							if(diff>=8  ){
								a=(Math.sin(latDiff/2) * Math.sin(latDiff/2) + Math.cos(DegtoRad(lat1))
								* Math.cos(DegtoRad(lat2)) * Math.sin(longDiff/2) * Math.sin(longDiff/2)  );
			
								c= 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
			
								dist=R*c;			
							
									if(dist<=0.35606){
										brw.write(lat2.toString()+", "+long2.toString()+'\n');
											
										n=n+1;
										}
						}
				
						}
						
			
			System.out.println(i+"-> for "+lat1+", "+long1+" No. of clustered Records="+n );
			brw.write( i+"-> for "+lat1+", "+long1+" No. of clustered Records="+n);
			brw.write('\n'+"**********************************"+'\n'); 
			i=i+1;
			rs1.close();
			line.delete(0, line.capacity());
			//System.out.println("No of CLUSTER processed:"+n+" in "+i+"th place");
			}
			
		   con.close();
		   brw.close();
		}
		
	
	
	
	
	
}
