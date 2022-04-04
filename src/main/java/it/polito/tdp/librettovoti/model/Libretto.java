package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

import it.tdp.librettovoti.db.LibrettoDAO;

public class Libretto {

	private List<Voto> voti ; // all'interno del libretto vi sono una serie di voti
	
	public Libretto() {
		this.voti = new ArrayList<Voto>() ;
	}
	
	public boolean add(Voto v) {
	/*	// PUNTO 6
		if(!isDuplicato(v) && !isConflitto(v)) {
			this.voti.add(v);
			return true;
		}else {
			return false;
		}*/
		LibrettoDAO dao = new LibrettoDAO();
		boolean result = dao.creaVoto(v);
		return result;
		
	}
	
	/*public Libretto filtraPunti(int punti) {  // crea un nuovo libretto a partire da quello esistente 
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
	/*public Integer puntiEsame(String nome) {
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
	}*/
	
	public List<Voto> getVoti(){
		//return this.voti;
		LibrettoDAO dao = new LibrettoDAO();
		return dao.readAllVoto();
	}
	
	// PUNTO 7
	/*public Libretto votiMigliorati() {
		Libretto nuovo = new Libretto(); // esempio di factory: ho un metodo intelligente per creare un oggetto con determinate car.
		for(Voto v : this.voti) {
			int punti = v.getPunti();
			if (punti >= 24)
				punti += 2;
			else
				punti += 1; // so per certo che i punti sono almeno pari a 18, altrimenti non sarebbero nel libretto
			if(punti > 30)
				punti = 30;
			// v.setPunti(punti); così non va bene perchè andrei a modificare i punti del voto v presente nel libretto originale
			nuovo.add(new Voto(v.getNome(),punti)); 
		}
		return nuovo;
	}
	
	// PUNTO 9
	public void cancellaVotiMinori(int punti) {
		for(Voto v : this.voti) {
			if(v.getPunti()<punti)
			this.voti.remove(v);	
		}	
	}*/
	
	
	/*public String toString() {        
		return this.voti.toString() ; // "CHIEDO" all'array list di voti di stamparsi
		                              // senza toString nella classe voto, otterrei solo il riferimento all'oggetto
	}*/
}
