package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.time.Month;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto() ;
		// PUNTO 1
		lib.add(new Voto("Analisi 1", 30,LocalDate.of(2022, Month.APRIL, 4))); // nel libretto ho inserito un voto di analisi 1 con punti pari a 30
		lib.add(new Voto("Informatica", 25,LocalDate.parse("2022-04-05")));
		lib.add(new Voto("Fisica 1", 18,LocalDate.of(2021, Month.MARCH, 14)));
		lib.add(new Voto("Algebra lineare", 25,LocalDate.parse("2021-07-20")));
		
		System.out.println(lib) ; // scrivendo SOLO questa istruzione, mi viene stampato solo il riferimento all'oggetto
		                          // dopo aver implementato i metodi toString nelle classi Voto e Libretto 
		                          // con questa istruzione ottengo in console le info desiderate
		
	/*	// PUNTO 2
		System.out.println("Voti pari a 25");
		Libretto lib25 = lib.filtraPunti(25);
		System.out.println(lib25) ;*/
		
	}

}
