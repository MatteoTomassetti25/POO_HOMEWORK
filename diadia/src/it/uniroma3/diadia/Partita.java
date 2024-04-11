/*
 * M: La classe Partita rappresenta una partita del gioco. Ecco una descrizione dettagliata delle parti principali:

    CFU_INIZIALI: Questa è una costante statica che rappresenta i CFU (Crediti Formativi Universitari) iniziali del giocatore.

    stanzaCorrente, stanzaVincente, finita, cfu: Questi sono i campi privati che rappresentano rispettivamente la stanza corrente del giocatore, la stanza vincente del gioco, se la partita è finita o meno, e i CFU attuali del giocatore.

    Partita(): Questo è il costruttore della classe. Inizializza la partita creando le stanze, impostando la partita come non finita e impostando i CFU del giocatore ai CFU iniziali.

    creaStanze(): Questo metodo privato crea tutte le stanze del gioco, gli attrezzi, collega le stanze tra loro, posiziona gli attrezzi nelle stanze e imposta la stanza corrente e la stanza vincente.

    getStanzaVincente(), setStanzaCorrente(Stanza stanzaCorrente), getStanzaCorrente(): Questi sono i metodi getter e setter per la stanza vincente e la stanza corrente.

    vinta(): Questo metodo restituisce true se la stanza corrente è la stanza vincente, cioè se il giocatore ha vinto la partita.

    isFinita(): Questo metodo restituisce true se la partita è finita, cioè se il giocatore ha vinto, se i CFU del giocatore sono 0, o se la partita è stata impostata come finita.

    setFinita(): Questo metodo imposta la partita come finita.

    getCfu(), setCfu(int cfu): Questi sono i metodi getter e setter per i CFU del giocatore.

 */
package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Stanza stanzaCorrente;
	//	private Stanza stanzaVincente;
	private boolean finita;
	private int cfu;
	private Labirinto lab;
	private Giocatore giocatore;

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Partita(){
		//		creaStanze();
		lab = new Labirinto();
		giocatore = new Giocatore();
		stanzaCorrente = this.lab.getStanzaCorrente();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
		lab.init();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	//    private void creaStanze() {

	//		/* crea gli attrezzi */
	//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
	//		Attrezzo osso = new Attrezzo("osso",1);
	//    	
	//		/* crea stanze del labirinto */
	//		Stanza atrio = new Stanza("Atrio");
	//		Stanza aulaN11 = new Stanza("Aula N11");
	//		Stanza aulaN10 = new Stanza("Aula N10");
	//		Stanza laboratorio = new Stanza("Laboratorio Campus");
	//		Stanza biblioteca = new Stanza("Biblioteca");
	//		
	//		/* collega le stanze */
	//		atrio.impostaStanzaAdiacente("nord", biblioteca);
	//		atrio.impostaStanzaAdiacente("est", aulaN11);
	//		atrio.impostaStanzaAdiacente("sud", aulaN10);
	//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
	//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
	//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
	//		aulaN10.impostaStanzaAdiacente("nord", atrio);
	//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
	//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
	//		laboratorio.impostaStanzaAdiacente("est", atrio);
	//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
	//		biblioteca.impostaStanzaAdiacente("sud", atrio);
	//
	//        /* pone gli attrezzi nelle stanze */
	//		aulaN10.addAttrezzo(lanterna);
	//		atrio.addAttrezzo(osso);
	//
	//		// il gioco comincia nell'atrio
	//        stanzaCorrente = atrio;  
	//		stanzaVincente = biblioteca;
	//    }

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	//	public Stanza getStanzaVincente() {
	//		return stanzaVincente;
	//	}
	//
	//	public void setStanzaCorrente(Stanza stanzaCorrente) {
	//		this.stanzaCorrente = stanzaCorrente;
	//	}
	//
	//	public Stanza getStanzaCorrente() {
	//		return this.stanzaCorrente;
	//	}
	//	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return lab.getStanzaCorrente()== lab.getStanzaVincente();
	}

	public Labirinto getLab() {
		return this.lab;
	}

	public void setLab(Labirinto lab) {
		this.lab = lab;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	//	public int getCfu() {
	//		return this.cfu;
	//	}

	//	public void setCfu(int cfu) {
	//		this.cfu = cfu;		
	//	}	
}
