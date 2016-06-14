package com.fileUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import convsql.*;
public class FileUtility1 {

	public static void listDirectory(String dirPath, int level) {
	    File dir = new File(dirPath);
	    File[] firstLevelFiles = dir.listFiles();
	    if (firstLevelFiles != null && firstLevelFiles.length > 0) {
	        for (File aFile : firstLevelFiles) {
	        	if(level==0){
	        	 System.out.println("User ID:"+aFile.getName()); 
	        	 CreateFile.setUserID(aFile);
	        	}
	            
	            if (aFile.isDirectory()) { 
	               // System.out.println("[" + aFile.getName() + "]");
	                listDirectory(aFile.getAbsolutePath(), level + 1);
	            } else {
	                //System.out.println(aFile.getName());
	               // System.out.println("Read function call for filr: "+aFile.getName());
	                CreateFile.LoadData(aFile.toString());
	               
	                
	            }
	        }
	    }
	}
	
	public static void processFile(String dirPath, String filename) {
		
	}
	
	public static void main(String args[]) throws SQLException, IOException{
		
		String s1,path;
		
		
		//new CreateFile();			//All the files are created. 
		//LoadDB.LoadData();		//Load data to database	
		
		//new createSchema();		//to create all tables
		
		//ExtraSpace.LoadData();	//little optimization on LoadDB.LoadData()
		
		//FindPlaces.FindPlaces();
		
		ClusterPlace.clusterPlace();
		
	/*	
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a Absolute path:- "+'\n');
		path=scn.next();
		System.out.println(path);
		listDirectory(path, 0);
	*/	
	}
	

}
