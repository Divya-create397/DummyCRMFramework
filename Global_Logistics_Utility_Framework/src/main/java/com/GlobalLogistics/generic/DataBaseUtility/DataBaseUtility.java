package com.GlobalLogistics.generic.DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection c;
	public void getDBConnection(String url,String username,String password) throws Throwable
	{
		try
		{
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		c=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void getDBConnection() throws Throwable
	{
		try
		{
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
	
	public void closeDBConnection() throws Throwable
	{
		try
		{
		c.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	public ResultSet executeSelectQuery(String query) throws Throwable
	{
		ResultSet r=null;
		try
		{
		Statement s=c.createStatement();
		r=s.executeQuery(query);
		}
		catch(Exception e)
		{
			
		}
		return r;
		
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try 
		{
			Statement s=c.createStatement();
			result=s.executeUpdate(query);
		}
		catch(Exception e)
		{
			
		}
		return result;
	}

}
