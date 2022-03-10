package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti ; // all'interno del libretto vi sono una serie di voti
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
	
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	public Libretto filtraPunti(int punti) {  // crea un nuovo libretto a partire da quello esistente 
		                                      // filtrando sui punti
		Libretto result = new Libretto() ;
		for(Voto v: this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result ;
	}
	
	// PUNTO 3
	/**
	 * Restituisce il punteggio ottenuto all'esame di cui 
	 * specifico il nome
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure {@code null} se l'esame non esiste
	 */ // sintassi del JavaDoc, la quale viene fuori ogni volta che viene chiamato il metodo
	    // battere /**
	public Integer puntiEsame(String nome) {
		for(Voto v: this.voti) {
			if( v.getNome().equals(nome) ) { // MAI confrontare stringhe con =
				return v.getPunti() ;
			}
		}
//		return -1; // dà maggiore responsabilità al chiamante. Se non vuole errare deve fare dei controlli
		return null; // per ritornare null devo modificare il tipo di val di ritorno: da int a Integer
//		throw new IllegalArgumentException("Corso non trovato") ; // il programma si bloccherebbe ma con avviso
	}
	
	// PUNTO 4
	public boolean isDuplicato(Voto v) {
		for(Voto v1: this.voti) {
			if(v1.equals(v)) // delego all'equals di voto e non controllo io singolarmente
							 // i campi che ne definiscono l'esistenza
				return true ;
		}
		return false ;
	}
	
	// PUNTO 5
	public boolean isConflitto(Voto v) {
		Integer punti = this.puntiEsame(v.getNome()) ; 
		if (punti != null && punti != v.getPunti())
			return true; // se c'è già il voto ed ha punteggio diverso allora c'è un conflitto
		else
			return false;
	}
	
	
	public String toString() {        
		return this.voti.toString() ; // "CHIEDO" all'array list di voti di stamparsi
		                              // senza toString nella classe voto, otterrei solo il riferimento all'oggetto
	}
}
