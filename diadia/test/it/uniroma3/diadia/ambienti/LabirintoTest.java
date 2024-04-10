package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {


	Labirinto l = new Labirinto();
	Stanza s = new Stanza("test1");


	@Test
	public void TestSetStanzaCorrente() {
		l.setStanzaCorrente(s);
		assertEquals(s.getNome(), l.getStanzaIniziale().getNome());
	}

	@Test
	public void TestGetStanzaCorrente() {
		l.init();
		assertEquals("Atrio", l.getStanzaIniziale().getNome());
	}

	@Test
	public void TestGetStanzaVincente() {
		l.init();
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}

}
