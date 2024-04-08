package it.uniroma3.diadia.giocatore;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		borsa = new Borsa(10);
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
