package model.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConnection {
	private static String URL = "jdbc:mysql://localhost/lorann?autoReconnect=true&useSSL=false";
	private static String LOGIN = "User";
	private static String PASSWORD = "password";
	private Connection connection;
	
	public BDDConnection(){
		this.connection = null;
		if(!open()){
			System.err.println("Erreur de la connection de la base de données");
		}
	}
	
	private boolean open(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public boolean close(){
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public Connection getConnection(){
		return connection;
		
	}

	
}
