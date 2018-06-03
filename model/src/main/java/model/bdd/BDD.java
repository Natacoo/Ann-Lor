package model.bdd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDD {
	private BDDConnection bddConnection;

	public BDD(){
		bddConnection = new BDDConnection();
		
	}
	
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
