package it.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	// la connessione al DB avviene mediante questo metodo.
	// In questo modo evito di inserire questa parte in ogni metodo delle classi DAO
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=Antonina10";
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
