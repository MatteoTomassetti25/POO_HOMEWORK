package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	Labirinto l = new Labirinto();
	Stanza s = new Stanza("test1");


	@Test
	public void TestSetStanzaCorrente() {
		l.setStanzaCorrente(s);
		assertEquals(s.getNome(), l.getStanzaCorrente().getNome());
	}

	@Test
	public void TestGetStanzaCorrente() {
		l.init();
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

	@Test
	public void TestGetStanzaVincente() {
		l.init();
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}

}
