package JeuDojon;

import java.util.*;

public class Personnage extends Donjon{
	
	//Attributs
	
	private char perso = 'X';
	private int vie;
	private ArrayList<Objet> inventaire = new ArrayList<Objet>();
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
	

	public Personnage(int longueur, int largeur, ArrayList<Objet> inventaire) throws ExceptionJeu {
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

	public ArrayList<Objet> getInventaire() {
		return inventaire;
	}

	public void setInventaire(ArrayList<Objet> inventaire) {
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
	

	public void ramasser(Donjon d, Personnage P, Objet p) throws ExceptionJeu {
		if(p.getObjet()=="P") {
			inventaire.add(p);
		}
		else throw new ExceptionJeu("Objet inconnu");
	}
	
	public void afficherVueJ(Donjon d) {

		for(int i=0;i<d.getLongueur();i++) {
			for(int j=0;j<d.getLargeur();j++) {
				System.out.print(" "+ vueJoueur[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public ArrayList<Objet>affInventaire() {
		System.out.println("Inventaire : ");
		for (int i=0;i<inventaire.size();i++) {
			System.out.print(inventaire.get(i).getObjet() + " ");
		}
		System.out.println();
		return inventaire;
		
		
		
	}
	
}

	
