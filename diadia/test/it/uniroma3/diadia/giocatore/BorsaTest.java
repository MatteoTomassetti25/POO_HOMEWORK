package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo a = new Attrezzo("spada", 5);
	Attrezzo c = new Attrezzo("cannone", 20);

	@Test
	public void TestAddAttrezzoMinoreDiPesoMax() {
		assertTrue(b.addAttrezzo(a));
	}

	@Test
	public void TestAddAttrezzoMaggioreDiPesoMax() {
		assertFalse(b.addAttrezzo(c));
	}

	@Test
	public void TestGetAttrezzo() {
		b.addAttrezzo(a);
		assertEquals(a, b.getAttrezzo("spada"));
	}
	
	@Test
	public void TestGetAttrezzo_vuoto() {
		assertNull(b.getAttrezzo("spada"));
	}
	
	@Test
	public void TestGetAttrezzo_Attrezzo_non_presente() {
		b.addAttrezzo(a);
		assertNull(b.getAttrezzo("vuoto"));
	}

	@Test
	public void TestGetPeso() {
		b.addAttrezzo(a);
		assertEquals(5, b.getPeso());
	}

	@Test
	public void TestIsEmpty() {
		assertTrue(b.isEmpty());
	}

	@Test
	public void TestRemoveAttrezzo() {
		b.addAttrezzo(a);
		b.removeAttrezzo("spada");
		assertTrue(b.isEmpty());
	}

}
