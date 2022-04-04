package it.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettovoti.model.Voto;

public class LibrettoDAO {
	// conterrà una serie di metodi che permetteranno di accedere i dati contentuti nel DB
	// tipicamente metodi CRUD: Create Read Update Delete
	
    public boolean creaVoto(Voto v) {
    	// faccio la insert	
    	try {
    	   	Connection conn = DBConnect.getConnection();
    	   	String sql = "INSERT INTO voti (nome, punti) VALUES (?,?)"; // MAI FARE CONCATENAZIONI DI STRINGHE
			PreparedStatement st = conn.prepareStatement(sql); // new
			
			st.setString(1, v.getNome()); // al posto del primo ? inserisci il valore di nome prendendolo dall'arg vero e proprio
			st.setInt(2, v.getPunti());
			
			int res = st.executeUpdate(); // NON devo più passare la stringa sql come parametro. Per come è fatta la libreria accetterebbe una stringa come par.
			if(res ==1) {
				System.out.println("Dato correttamente inserito");
			}
			st.close();
    	   	conn.close();
    	   	
    	   	return (res==1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
    }
    
    public List<Voto> readAllVoto() {
    	try {
    		Connection conn = DBConnect.getConnection();
    		String sql = "SELECT * FROM voti";     // la mia query
    		PreparedStatement st = conn.prepareStatement(sql); // la connessione mi costituisco un oggetto Statement, il quale porta al DB la mia onterrogazione
    														   // e mi riporta indietro i risultati
    		

            ResultSet res = st.executeQuery();  // st mi restituisce l'insieme dei risultati della query inviata
            									// non è altro che un meccanismo per accedere ai dati mediante lo spostamento del cursore

           List<Voto> result = new ArrayList<>();
           while (res.next()) { // metodo per spostare il cursore lungo le righe del risultato
        	   String nome = res.getString("nome"); // metodi per estrarre i dati
        	   int voto = res.getInt("punti");
        	   LocalDate dataEsame = res.getDate("data").toLocalDate(); // ricordare il .toLocalDate()
        	   result.add(new Voto(nome,voto,dataEsame));
           }
           st.close(); // ha senso chiuderlo quando non mi serve più esequire la query
           conn.close(); // RICORDA: VA CHIUSA LA CONNESSIONE
           return result; // il return va messo dopo la restituzione della conn al DB
    		
    	}catch(SQLException e) {
    		System.out.println(e);
			e.printStackTrace();
			return null;
    	}
    	
    }
    
    /*public Voto readVotoByName(String nome) {
    	
    }*/
    
    // l'oggetto Voto in questo esercizio funziona da Transfer Object
}
