package JeuDojon;

import java.util.*;

public class Personnage extends Donjon{
	
	//Attributs
	
	private char perso = 'X';
	private int vie;
	private List<Objet> inventaire = new ArrayList<Objet>();
	private int attaque;
	private char[][]vueJoueur;
	
	
	//Constructeurs
	

	public Personnage(int vie, int longueur, int largeur) throws ExceptionJeu {
		super(longueur,largeur);
		setVie(vie);
		vueJoueur=new char[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]='~';
			}
		}
	}		
	

	
	public Personnage(int longueur, int largeur, int vie, int attaque) throws ExceptionJeu {
		super(longueur,largeur);
		setVie(vie);
		setAttaque(attaque);
		vueJoueur=new char[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]='~';
			}
		}
	}
	
	public Personnage(int longueur, int largeur, int vie, int attaque, char perso) throws ExceptionJeu  {
		super(longueur,largeur);
		setVie(vie);
		setAttaque(attaque);
		setPerso(perso);
		vueJoueur=new char[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]='~';
			}
		}
		
	}
	

	public Personnage(int longueur, int largeur, List<Objet> inventaire) throws ExceptionJeu {
		super(longueur,largeur);
		setInventaire(inventaire);
		vueJoueur=new char[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]='~';
			}
		}
	}
		
	
	//Geters et seters

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		if(vie>=0 && vie<=20) {
			this.vie = vie;
		}
		else
			System.err.print("Vie du personnage trop faible ou trop �lev�e \n");
	}

	public List<Objet> getInventaire() {
		return inventaire;
	}

	public void setInventaire(List<Objet> inventaire) {
		this.inventaire = inventaire;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		if(attaque>=0 && attaque<=10) {
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

	public char[][] getVueJoueur() {
		return vueJoueur;
	}

	public void setVueJoueur(char[][] vueJoueur) {
		this.vueJoueur = vueJoueur;
	}
	

	public void ramasser(Objet p) {
		if (p.getObjet()=='P') {
			inventaire.add(p);
		}
		
	}

}
