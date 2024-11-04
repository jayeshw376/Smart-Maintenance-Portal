package com.smart.working;
import java.sql.*;
public class ConnetDB 
	{
		static Connection con=null;
		public static  Connection getConnect()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maintainanceportal","root","");
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return con;
	}

}
