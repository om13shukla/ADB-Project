package convsql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import convsql.project2.ConnectionProvider;

public class createSchema {
	
	
	
	public createSchema() throws SQLException, IOException {
		// TODO Auto-generated constructor stub
	int uid;
	String t1="u",t2="u0",t3="u00",t4="0",t5="00",tname=null,fname=null;
		
		FindPlaces sp1= new FindPlaces();
	
		for(uid=2;uid<53;uid++){          // have allready created table u000 and u001 for testing !
			uid=(1000*uid)/1000;
			if(uid<=9){tname=t3+uid; fname=t5+uid; }
			else if (uid>9 && uid<=99) {tname=t2+uid; fname=t4+uid; }
			else if(uid>99){tname=t1+uid; fname=""+uid;}
			//FindPlaces.FindPlaces(fname, tname);
			//System.out.println("Passing: "+tname+" & "+fname);
			
		}
		sp1.con.close();
		System.out.println("Done..!");
	}
	

}
