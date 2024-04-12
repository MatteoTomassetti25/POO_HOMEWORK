package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita p = new Partita();
	Stanza s = new Stanza("test");





	@Test
	public void TestVinta() {  //alcune delle funzioni vanno testae al contrario, qua non posso settare la stanza vinente qindi testo che la partita non finisce
		assertFalse(p.vinta());
	}

	@Test
	public void TestGetStanzaCorrente() {
		p.getLab().setStanzaCorrente(s);
		assertEquals("test", p.getLab().getStanzaCorrente().getNome()); //ATTENZIONE: confrontare sempre lo stesso tipo di ritorno
	}
	

	@Test
	public void TestGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLab().getStanzaVincente().getNome());
	}

	@Test 
	public void TestGetStanzaCorrente_Vuota() {
		assertNull(p.getStanzaCorrente());
	}

}
