/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convsql.project2;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class ConnectionProvider implements Provider 
{
	private static Connection con=null;
	
	static
	{
		
		try 
		{
			Class.forName(DRIVER);
			con=DriverManager.getConnection(CONNECTION,USERNAME,PASS);
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
                    e.printStackTrace();
		}
		
	}
	
	public static Connection getConn()
	{
		return con;
	}


}
