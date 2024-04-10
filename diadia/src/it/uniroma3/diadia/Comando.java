/*
 * M: La classe Comando rappresenta un comando nel gioco. Un comando consiste al massimo di due parole: il nome del comando e un parametro su cui si applica il comando. Ecco una descrizione dettagliata delle parti principali:

    nome, parametro: Questi sono i campi privati che rappresentano rispettivamente il nome del comando e il parametro del comando.

    Comando(String istruzione): Questo è il costruttore della classe. Prende una stringa di istruzione come input, la suddivide in parole utilizzando uno Scanner, e imposta il nome e il parametro del comando in base alle parole estratte.

    getNome(), getParametro(): Questi sono i metodi getter per il nome e il parametro del comando.

    sconosciuto(): Questo metodo restituisce true se il nome del comando è null, cioè se il comando è sconosciuto.

 */
package it.uniroma3.diadia;



import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

	private String nome;
	private String parametro;

	public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())  //se ho stringa vuota non entra
			this.nome = scannerDiParole.next(); //se non entro nome rimane null come è iniz NNPPEE

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext()) //se ho stringa vuota non entra
			this.parametro = scannerDiParole.next(); //param resta null NNPPEE
	}

	public String getNome() {
		return this.nome;
	}

	public String getParametro() {
		return this.parametro;
	}

	public boolean sconosciuto() {
		return (this.nome == null);
	}
}