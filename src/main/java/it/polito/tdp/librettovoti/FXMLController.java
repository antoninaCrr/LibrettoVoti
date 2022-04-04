package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model; // sarebbe sbagliato nel patter MVC creare qui il model su cui il controller lavora

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti; // all'interno della tendina appaiono dei numeri interi tra 18 e 30

    @FXML
    private TextField txtNome;
    
    @FXML
    private Label txtStatus;

    @FXML
    private TextArea txtVoti;

    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	// FASE 1. Acquisizione e controllo dati
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();
    	// controlli di validità
        if(nome.equals("") || punti == null) { // punti è un integer e quindi per lui esiste il null
        	// errore, non posso eseguire l'operazione
        	txtStatus.setText("ERRORE: Occorre inserire nome e voto\n"); 
        	return; // esco dal gestore dell'evento
        }
    	
    	// FASE 2. Esecuzione dell'operazione (chiedo al model di eseguire)
        // Dopo i controlli so che i campi che passo a Voto sono corretti
    	boolean ok = model.add(new Voto(nome,punti, LocalDate.now()));
    	
    	// FASE 3. Visualizzazione/aggiornamento del risultato
    	if(ok == true) {
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato "+voti.size()+" esami\n");
    	for(Voto v:voti) {
    		txtVoti.appendText(v.toString()+"\n");
    	}
    	 
    	txtNome.clear();
    	cmbPunti.setValue(null); // setValue -- valore attualmente selezionato
    	txtStatus.setText("");
    	}else {
    		txtStatus.setText("ERRORE: esame già presente"); // se l'add non è andato a buon fine è perchè vi è o un conflitto o 
    		                                                 // un duplicato
    	}
    }
    
    public void setModel(Libretto model) {  // il Controller si ricorda qual è la classe model su cui lavorare
    	this.model = model;
    	// appena settato il modello, inizializzo l'interfaccia per la visualizzazione preliminare
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato "+voti.size()+" esami\n");
    	for(Voto v:voti) {
    		txtVoti.appendText(v.toString()+"\n");
    	}
    }

    @FXML
    void initialize() { // viene chiamato prima del setModel
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        // gli assert controllano che le variabili ci siano
        // il codice a seguire viene eseguito prima delle azioni lasciate agli utenti
        
        cmbPunti.getItems().clear(); // la comboBox contiene una lista di oggetti del tipo che mi è utile
        for(int p = 18; p <= 30; p++) {
        	cmbPunti.getItems().add(p);
        }
        
    }

}

