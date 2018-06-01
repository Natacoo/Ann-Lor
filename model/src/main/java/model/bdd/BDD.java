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
		
	}
	
	public ResultSet query(String sql, int id){

	} 

	public ResultSet query(String sql){

	}

	public ResultSet query(String sql, String[] params){

	}

	public ResultSet query(String sql, String param){

	}

}
