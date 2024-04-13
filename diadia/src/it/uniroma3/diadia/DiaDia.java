/*
 * M: 

    DiaDia: Questa è la classe principale del gioco. Crea un’istanza della classe Partita e contiene il metodo gioca() per avviare il gioco.

    MESSAGGIO_BENVENUTO: Questa è una stringa statica che contiene il messaggio di benvenuto visualizzato all’inizio del gioco.

    elencoComandi: Questo è un array di stringhe che contiene l’elenco dei comandi disponibili per l’utente.

    partita: Questa è un’istanza della classe Partita che rappresenta la partita corrente.

    gioca(): Questo metodo avvia il gioco. Stampa il messaggio di benvenuto e poi entra in un ciclo, leggendo le istruzioni dell’utente da System.in e processandole fino a quando il gioco non termina.

    processaIstruzione(String istruzione): Questo metodo prende una stringa di istruzione come input e la processa. Crea un nuovo Comando basato sull’istruzione, quindi controlla quale comando è stato dato e lo esegue. Se il comando è “fine”, termina il gioco. Se il comando è “vai”, tenta di spostare il giocatore in una nuova stanza. Se il comando è “aiuto”, stampa l’elenco dei comandi disponibili. Se il comando non è riconosciuto, stampa un messaggio di errore.

    aiuto(): Questo metodo stampa l’elenco dei comandi disponibili.

    vai(String direzione): Questo metodo tenta di spostare il giocatore in una nuova stanza nella direzione specificata. Se la direzione non esiste, stampa un messaggio di errore.

    fine(): Questo metodo stampa un messaggio di ringraziamento e termina il gioco.

    main(String[] argc): Questo è il metodo principale che viene eseguito all’avvio del programma. Crea un’istanza del gioco e poi lo avvia.

 */
package it.uniroma3.diadia;



import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	/*
	 * M: messaggio di benvenuto stampato all'inizio di una nuova partita
	 */

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome()==null) {
			io.mostraMessaggio("non hai inserito nessun comando");
		}

		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciouto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLab().getStanzaCorrente().getStanzaAdiacente(direzione); //modificato
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLab().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione()+"\n"+"M: n CFU "+partita.getGiocatore().getCfu());
		partita.getGiocatore().getBorsa().stampaAttrezzi();
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	/*
	 * Metodo che prende l'oggetto dalla stanza e lo mette nella borsa
	 * 
	 * Consiglio prima mettere nella borsa poi rimuovere
	 */
	public void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("cosa vuoi prendere?");
			return;
		}


		Attrezzo a = partita.getLab().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a == null) {
			io.mostraMessaggio("L'oggetto non esiste!");
			return;
		}else {

			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLab().getStanzaCorrente().removeAttrezzo(a);
		}

	}




	/*
	 * Metodo che posa un oggetto dalla borsa e lo ripone nella stanza corrente
	 */
	public void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("cosa vuoi posare?");
			return;
		}
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

		if(a == null) {
			io.mostraMessaggio("L'oggetto non esiste!");
			return;
		}
		else {
			partita.getLab().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
	}



	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}


}