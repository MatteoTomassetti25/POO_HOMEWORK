package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(this.attrezzi[i] != null)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		
		Attrezzo a = null;
		
		if(isEmpty()) {
			return a;
		}
		
		else{
			for(int i = 0; i<attrezzi.length; i++) {
				a = attrezzi[i];
				if(a.getNome().equals(nomeAttrezzo)) {
					attrezzi[i]=null;
					numeroAttrezzi--;
					return a;
				}
			}
		}
		return a;
	}
	
	
//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//
//		if(nomeAttrezzo!=null){
//			int i = 0;
//			for(Attrezzo att : this.attrezzi) {
//				if(att != null) {
//					if(att.getNome().equals(nomeAttrezzo)) {
//						a = att;
//						this.attrezzi[i] = null;
//						this.numeroAttrezzi--;
//					}
//				}
//				i++;
//
//			}
//		}
//		return a;
//	}
	
//	public Attrezzo removeAttrezzo1(String nome) {
//		if (nome == null) {
//			return null;
//		}
//		for (int ind = 0; ind < this.numeroAttrezzi; ind++) {
//			Attrezzo corrente = attrezzi[ind];
//			if (corrente == null) {
//				continue;
//			}
//			if (corrente.getNome() != null && corrente.getNome().equals(nome)) {
//				Attrezzo eliminato = new Attrezzo(corrente.getNome(), corrente.getPeso());
//				attrezzi[ind] = null;
//				this.numeroAttrezzi--;
//				return eliminato;	
//			}
//		}
//		return null;
//	}
	

	//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	//		Attrezzo a = null;
	//		if(nomeAttrezzo != null) {
	//			int i=0;
	//			for(Attrezzo elemento : attrezzi) {
	//				if(elemento != null)
	//				if(elemento.getNome().equals(nomeAttrezzo)) {
	//					attrezzi[i]= null;
	//					numeroAttrezzi--;
	//				}i++;
	//			}return a;
	//		}return a;
	//	}

//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo attrezzo = null;
//		if(nomeAttrezzo != null) {
//			for(int i =0; i<attrezzi.length; i++) {
//				attrezzo = attrezzi[i];
//				Attrezzo elimina = attrezzi[i];
//				if(attrezzi[i] != null && attrezzi[i].getNome().equals(nomeAttrezzo)) {
//					attrezzi[i] = attrezzi[i+1];
//					numeroAttrezzi--;
//					elimina = null;
//					return attrezzo;
//				}
//
//			}
//		}return attrezzo;
//	}
	
//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//		int i=0;
//
//		// ---> TODO (implementare questo metodo) <---
//		if (isEmpty()) {
//			System.out.println("La borsa è vuota!!!");
//		}	
//		else {
//			a = getAttrezzo(nomeAttrezzo); //mi salvo il riferimento dell'attrezzo qui 
//			//ora devo rimuovere l'attrezzo dalla borsa
//			if (a != null) {
//				//io devo entrare nel while sia quando è null sia quando non è uguale
//				while(attrezzi[i] == null || !attrezzi[i].getNome().equals(a.getNome())) {
//					i++;
//				}
//				this.attrezzi[i] = null;
//				this.numeroAttrezzi--;
//
//			}
//			else 
//				System.out.println("L'attrezzo non c'è!!");
//		}
//
//		return a;
//	}
	

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	//test matteo
	public void stampaAttrezzi(){
		Attrezzo attrezzo;
		for(int i=0; i<numeroAttrezzi;i++){
			attrezzo=this.attrezzi[i];
			if(attrezzo != null){
				System.out.println("attrezzo nella borsa: "+attrezzo);
			}
		}
	}

}