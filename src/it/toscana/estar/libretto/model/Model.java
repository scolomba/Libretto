package it.toscana.estar.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private List<Esame> esami;
	
	public Model() {
		this.esami = new ArrayList<Esame>();
		
	}
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non ci sia già
	 * @param e
	 * @return true se l'hai inserito, false se esisteva già e quindi non inserisci
	 */
	public boolean addEsame(Esame e) {
		if(!esami.contains(e)) {
		    esami.add(e);
		    return true;
		}else {
			return false;
		}
			
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato
	 * Se esiste lo restituisce
	 * altrimenti restituisce null
	 * @param codice
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice) {
		int pos = this.esami.indexOf(new Esame(codice, null,null));
		if(pos== -1) {
			return null;
	    }else {
	    	return esami.get(pos);
	    }
		
	}
	

}
