/*
 * M: La classe Stanza rappresenta una stanza in un gioco di ruolo. Una stanza è un luogo fisico nel gioco, collegato ad altre stanze attraverso delle uscite. Ogni uscita è associata a una direzione.

    NUMERO_MASSIMO_DIREZIONI, NUMERO_MASSIMO_ATTREZZI: Queste sono costanti statiche che rappresentano rispettivamente il numero massimo di direzioni e il numero massimo di attrezzi che una stanza può contenere.

    nome, attrezzi, numeroAttrezzi, stanzeAdiacenti, numeroStanzeAdiacenti, direzioni: Questi sono i campi privati che rappresentano rispettivamente il nome della stanza, l’array degli attrezzi nella stanza, il numero corrente di attrezzi nella stanza, l’array delle stanze adiacenti, il numero corrente di stanze adiacenti, e l’array delle direzioni delle stanze adiacenti.

    Stanza(String nome): Questo è il costruttore della classe. Prende una stringa come input per il nome della stanza, inizializza il nome della stanza, imposta il numero di stanze adiacenti e il numero di attrezzi a zero, e inizializza gli array delle direzioni, delle stanze adiacenti, e degli attrezzi.

    impostaStanzaAdiacente(String direzione, Stanza stanza): Questo metodo imposta una stanza adiacente in una certa direzione. Se la direzione esiste già, aggiorna la stanza adiacente in quella direzione. Altrimenti, se il numero di stanze adiacenti è inferiore al numero massimo di direzioni, aggiunge la nuova direzione e la stanza adiacente.

    getStanzaAdiacente(String direzione): Questo metodo restituisce la stanza adiacente in una certa direzione.

    getNome(), getDescrizione(), getAttrezzi(): Questi sono metodi getter per il nome della stanza, la descrizione della stanza, e gli attrezzi nella stanza.

    addAttrezzo(Attrezzo attrezzo): Questo metodo aggiunge un attrezzo alla stanza. Se il numero di attrezzi è inferiore al numero massimo di attrezzi, aggiunge l’attrezzo e incrementa il numero di attrezzi.

    toString(): Questo metodo restituisce una rappresentazione stringa della stanza, includendo il nome della stanza, le uscite, e gli attrezzi contenuti nella stanza.

 */
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private Stanza[] stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private String[] direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
		for(int i=0; i<this.direzioni.length; i++)
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[numeroStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (int i = 0; i<numeroAttrezzi;i++) {  //facendo cosi itero solo la parte iniziale scritt compatta
			Attrezzo attrezzo = this.attrezzi[i];
			if(attrezzo != null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (int i = 0; i<this.numeroAttrezzi; i++) {
			Attrezzo attrezzo = this.attrezzi[i];
			if(attrezzo != null)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (int i = 0; i<numeroAttrezzi;i++) {
			Attrezzo attrezzo = this.attrezzi[i];
			if(attrezzo != null) 
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo != null) {
			int i = 0;
			for(Attrezzo elemento : attrezzi) {
				if(elemento.getNome().equals(attrezzo.getNome())){
					attrezzi[i] = null;
					numeroAttrezzi--;
				}
				return true;
			}
		}
		return false;
	}


	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}

}