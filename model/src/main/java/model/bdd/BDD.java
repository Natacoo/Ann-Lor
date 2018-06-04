package model.bdd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 Class to execute SQL queries 


@author Tristan FOCA
@version 06/04/2018
*/

public class BDD {
	
	private BDDConnection bddConnection;
	
	/**
	 Initialize an object for connection to database
	 */
	public BDD(){
		bddConnection = new BDDConnection();
	}
	
	/**
	 Execute the SQL queries
	 
	 @param sql It's SQL query
	 @param i It's a table for params of SQL query 
	 @return The result of query
	 */
	public ResultSet query(String sql, int[] i){
		try{
			CallableStatement call = bddConnection.getConnection().prepareCall(sql);
			for(int x = 0; x < i.length; x++){
				call.setInt((x+1), i[x]);
			}
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 Execute the SQL queries
	 
	 @param sql It's SQL query
	 @param id It's a number for param of SQL query
	 @return The result of query
	 */
	public ResultSet query(String sql, int id){
		try{
			CallableStatement call = bddConnection.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 Execute the SQL queries
	 
	 @param sql It's SQL query
	 @return The result of query
	 */
	public ResultSet query(String sql){
		try{
			CallableStatement call = bddConnection.getConnection().prepareCall(sql);
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 Execute the SQL queries
	 
	 @param sql It's SQL query
	 @param params It's a table for params in SQL query
	 @return The result of query
	 */
	public ResultSet query(String sql, String[] params){
		try{
			CallableStatement call = bddConnection.getConnection().prepareCall(sql);
			for(int x = 0; x < params.length; x++){
				call.setString((x+1), params[x]);
			}
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 Execute the SQL queries
	 
	 @param sql It's SQL query
	 @param param It's a param in SQL query
	 @return The result of query
	 */
	
	public ResultSet query(String sql, String param){
		try{
			CallableStatement call = bddConnection.getConnection().prepareCall(sql);
			call.setString(1, param);
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
