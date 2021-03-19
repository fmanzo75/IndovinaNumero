package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;

public class Model {
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public void nuovaPartita() {
    	//gestione inizio nuova partita
    	this.segreto = (int) (Math.random() * NMAX) +1;
    	this.tentativiFatti = 0;
    	this.inGioco = true;
	}
	
	public int tentativo(int tentativo) {
		// controllo la partita è in gioco
		if(!inGioco) {
			throw new IllegalStateException("HAI PERSO, IL SEGRETO ERA: " + this.segreto);
		}
		// controllo dell'input
		if(!tentaivoValido(tentativo)) {
			throw new InvalidParameterException("Devi inserre un numero tra 1 e NMAX");
		}
		// il tentativo è valido
		this.tentativiFatti ++;
		if(this.tentativiFatti == TMAX) {
			this.inGioco = false;
			return 0;
		}else if(tentativo< this.segreto) {
			return -1;
		}else {
			return 1;
		}
						
	}
	
	private boolean tentaivoValido(int tentativo) {
		if(tentativo < 1 || tentativo > NMAX)
			return false;
		else
			return true;		
	}
	
	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}
	
	
}
