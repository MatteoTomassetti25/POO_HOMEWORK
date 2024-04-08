package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	Stanza s = new Stanza("test");
	Stanza s2 = new Stanza("test2");
	Attrezzo a = new Attrezzo("spada", 10);

	@Test
	public void TestGetStanzaAdiacente() {
		assertNull(s.getStanzaAdiacente("est"));
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
	public void TestGetAttrezzo() {
		s.addAttrezzo(a);
		assertNotNull(s.getAttrezzo("spada"));
		assertEquals(s.getAttrezzo("spada"), a);
	}
	
//	@Test
//	public void TestHasAttrezzo() {
//		s.addAttrezzo(a);
//		assertTrue(s.hasAttrezzo("spada"));
//	}
}
