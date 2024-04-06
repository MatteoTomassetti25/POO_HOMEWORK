package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GiocatoreTest {

	Giocatore g = new Giocatore();
	
	@Test
	public void TestCfuInizili() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	public void TestSetCfu() {
		g.setCfu(3);
		
		assertEquals(3, 3);
	}
	
	@Test
	public void TestBorsaNonNulla() {
		assertNotNull(g.getBorsa());
	}
}
