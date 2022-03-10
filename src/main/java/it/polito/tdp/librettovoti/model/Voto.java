package it.polito.tdp.librettovoti.model;

import java.util.Objects;

public class Voto {
	private String nome ; // nome del corso
	private int punti ; // risultato ottenuto
	
	public Voto(String nome, int punti) {
		super();
		this.nome = nome;
		this.punti = punti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	
	@Override
	public String toString() {
		return nome+" : "+ punti; 
	}
	// hashCode && equals sono metodi in override che vanno "a braccetto"
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + punti;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // il metodo fa prima una serie di controlli sull'oggetto
			return true; // e poi confronta le proprietà
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (punti != other.punti)
			return false;
		return true;
	}
	
	
	
		
}
