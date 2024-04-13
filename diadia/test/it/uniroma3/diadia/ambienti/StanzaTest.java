package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	Stanza s = new Stanza("test");
	Stanza s2 = new Stanza("test2");
	Attrezzo a = new Attrezzo("spada", 10);
	Attrezzo b = new Attrezzo("bastone",0);

	@Test
	public void TestGetStanzaAdiacente() {
		assertNull(s.getStanzaAdiacente("est"));
	}
	
	@Test
	public void TestGetStanzaAdiacente_stanzaPresente() {
		s.impostaStanzaAdiacente("est", s2);
		assertNotNull(s.getStanzaAdiacente("est"));
	}

	@Test
	public void TestImpostaStanzaAdiacente() {
		s.impostaStanzaAdiacente("est", s2);
		assertEquals(s.getStanzaAdiacente("est"), s2);
	}

	@Test
	public void TestAddAttrezzo() {
		assertNotNull(s.addAttrezzo(a));
	}

	@Test
	public void TestGetAttrezzo_vuoto() {
		assertNull(s.getAttrezzo("vuoto"));
	}
	
	@Test
	public void TestGetAttrezzo_nontrovato() {
		s.addAttrezzo(a);
		assertNull(s.getAttrezzo("test"));
	}
	
	@Test
	public void TestGetAttrezzo_attrezzoEsistente() {
		s.addAttrezzo(a);
		assertNotNull(s.getAttrezzo("spada"));
	}

	@Test
	public void TestHasAttrezzo() {
		s.addAttrezzo(a);
		assertTrue(s.hasAttrezzo("spada"));
	}
	
	@Test
	public void TestremoveAttrezzo() {
		s.addAttrezzo(a);
		assertTrue(s.removeAttrezzo(a));
	}
	
	@Test
	public void TestremuveAttrezzo_piuOggetti() {
		s.addAttrezzo(a);
		s.addAttrezzo(b);
	    assertTrue(s.removeAttrezzo(b));
	}

}
