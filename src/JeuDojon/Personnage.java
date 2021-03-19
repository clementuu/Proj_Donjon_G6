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
	
	public Personnage(int vie,int attaque,char perso) {
		setVie(vie);
		setAttaque(attaque);
		setPerso(perso);
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		if(vie>=5 && vie<=20) {
			this.vie = vie;
		}
		else
			System.err.print("Vie du personnage trop faible ou trop �lev�e \n");
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
		if(attaque>=1 && attaque<=10) {
			this.attaque = attaque;
		}
		else
			System.err.print("Personnage trop faible ou trop puissant \n");
	}

	public char getPerso() {
		return perso;
	}

	public void setPerso(char perso) {
		if(perso == 'X' || perso == 'M') {
			this.perso = perso;
		}
		else
			System.err.print("Personnage inconnu \n");
	}

	
}