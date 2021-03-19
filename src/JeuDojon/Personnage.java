package JeuDojon;

import java.util.*;

public class Personnage {
	
	private char perso = 'X';
	private int vie;
	private ArrayList<Objet>[] inventaire;
	private int attaque;
	
	public Personnage(int vie) {
		setVie(vie);
	}
	
	public Personnage(int vie,int attaque) {
		setVie(vie);
		setAttaque(attaque);
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public ArrayList<Objet>[] getInventaire() {
		return inventaire;
	}

	public void setInventaire(ArrayList<Objet>[] inventaire) {
		this.inventaire = inventaire;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public char getPerso() {
		return perso;
	}

	public void setPerso(char perso) {
		this.perso = perso;
	}

	
}
