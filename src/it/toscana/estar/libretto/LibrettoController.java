


/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package it.toscana.estar.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.toscana.estar.libretto.model.Esame;
import it.toscana.estar.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	Model model;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessaggi"
    private TextArea txtMessaggi; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<5) {
    		txtMessaggi.appendText("Codice non valido\n");
    		return;
    	}
    	
    	Esame e = model.trovaEsame(codice); 
    	
    	if(e==null) {
    		txtMessaggi.appendText("Codice " + codice + " non trovato\n");
    	}else {
    		txtMessaggi.appendText("Codice " + codice + " trovato\n");
    		
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	
        // recupera i dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	// Verifica la validit� dei dati
    	if(codice.length()<5 || titolo.length() == 0 || docente.length() == 0) {
    		txtMessaggi.appendText("Dati esame insufficienti\n");
    		return ;
    	}
    	 
    	// chiedi al Model di effettuare l'operazione
    	Esame e = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(e);
    	
    	// aggiorna la vista con il risulato dell'operazione
    	if(result) {
    		txtMessaggi.appendText("Esame aggiunto corretamente\n");
    	}else {
    		txtMessaggi.appendText("Esame NON AGGIUNTO (codice duplicato)\n");
    	}
    	

    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtCodice.setText("");
    	txtTitolo.setText("");
    	txtDocente.setText("");
    	txtMessaggi.setText("");

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}

