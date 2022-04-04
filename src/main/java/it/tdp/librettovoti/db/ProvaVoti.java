package it.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaVoti {
	
	public void aggiungiVoto(String nome, int punti) {
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=Antonina10";
		
		try {
			Connection conn = DriverManager.getConnection(url);
			String sql = "INSERT INTO voti (nome, punti) VALUES (?,?)"; // MAI FARE CONCATENAZIONI DI STRINGHE
			PreparedStatement st = conn.prepareStatement(sql); // new
			
			st.setString(1, nome); // al posto del primo ? inserisci il valore di nome
			st.setInt(2, punti);
			
			int res = st.executeUpdate(); // NON devo più passare la stringa sql come parametro. Per come è fatta la libreria accetterebbe una stringa come par.
			if(res ==1) {
				System.out.println("Dato correttamente inserito");
			}
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProvaVoti pV = new ProvaVoti();
		pV.aggiungiVoto("Economia Aziendale", 30);
		
			String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=Antonina10"; // stringa di connessione
			
			try {
				Connection conn = DriverManager.getConnection(url); // ho stabilito una connessione con il DB
				
				Statement st = conn.createStatement(); // la connessione mi costituisco un oggetto Statement, il quale porta al DB la mia onterrogazione
				                                       // e mi riporta indietro i risultati
				String sql = "SELECT * FROM voti";     // la mia query
				
				ResultSet res = st.executeQuery(sql);  // st mi restituisce l'insieme dei risultati della query inviata
				                                       // non è altro che un meccanismo per accedere ai dati mediante lo spostamento del cursore
				
				while (res.next()) { // metodo per spostare il cursore lungo le righe del risultato
					String nome = res.getString("nome"); // metodi per estrarre i dati
					int voto = res.getInt("punti");
					System.out.println(nome+" "+voto);
				}
				st.close(); // ha senso chiuderlo quando non mi serve più esequire la query
				conn.close(); // è buona norma ricordarsi di chiudere la connessione per non tenere occupata una risorsa che non ci serve
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
