package model.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConnection {
	private static String URL = "jdbc:mysql://localhost/wbuiyx_lorann?autoReconnect=true&useSSL=false";
	private static String LOGIN = "User";
	private static String PASSWORD = "";
	private Connection connection;
	
	public BDDConnection(){
		this.connection = null;
		if(!open()){
			System.err.println("Erreur de la connection de la base de données");
		}
	}
	
	private boolean open(){
 
	}

	public boolean close(){

	}

	public Connection getConnection(){
		return connection;
		
	}

	
}
