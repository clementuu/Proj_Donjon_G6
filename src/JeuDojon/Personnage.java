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
	

	public Personnage(int longueur, int largeur,int vie) throws ExceptionJeu {
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
	
	public void afficherVueJ(Donjon d,Personnage P) {

		for(int i=0;i<d.getLongueur();i++) {
			for(int j=0;j<d.getLargeur();j++) {
				if(d.getCase(i, j)==P.getPerso()) {
					vueJoueur[i][j]=P.getPerso();
				}
				System.out.print(" "+ vueJoueur[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public ArrayList<Objet>affInventaire() throws ExceptionJeu {
		if(inventaire.size()<0) {
			throw new ExceptionJeu("Inventaire plus que vide \n");
		}
		else
			System.out.println("Inventaire : ");
			for (int i=0;i<inventaire.size();i++) {
				System.out.print(inventaire.get(i).getObjet() + " ");
			}
			System.out.println();
			return inventaire;
	}
	
	public void laisserPotion(int x, int y) throws ExceptionJeu{
		if(vueJoueur[x][y]=='~') {
			vueJoueur[x][y]='P';
		}
	}
	
	public void remplacerCase(int x,int y,Donjon d) throws ExceptionJeu {
		
		if(d.getCase(x, y)=='#') {
			if(x<0 || y<0 || x>d.getLongueur() || y>d.getLargeur()) {
				throw new ExceptionJeu("Hors map");
			}
			if(vueJoueur[x][y]=='~' || vueJoueur[x][y]=='X') {
				vueJoueur[x][y]='#';
			}
		}
	
		if(d.getCase(x, y)=='P') {
			if(x<0 || y<0 || x>d.getLongueur() || y>d.getLargeur()) {
				throw new ExceptionJeu("Hors map");
			}
			if(vueJoueur[x][y]=='~' || vueJoueur[x][y]=='X') {
				vueJoueur[x][y]='P';
			}
		}
		
		if(d.getCase(x,y)=='�') {
			if(x<0 || y<0 || x>d.getLongueur() || y>d.getLargeur()) {
				throw new ExceptionJeu("Hors map");
			}
			if(vueJoueur[x][y]=='~' || vueJoueur[x][y]=='X') {
				vueJoueur[x][y]='�';
			}
		}
		
		if(d.getCase(x, y)==' ') {
			if(x<0 || y<0 || x>d.getLongueur() || y>d.getLargeur()) {
				throw new ExceptionJeu("Hors map");
			}
			if(vueJoueur[x][y]=='~' || vueJoueur[x][y]=='X') {
				vueJoueur[x][y]=' ';
			}
		}
			
	}
	
	
	public void soin(Personnage P,ArrayList<Objet> inventaire) throws ExceptionJeu {
		for (int i=0;i<inventaire.size();i++) {
			if(inventaire.get(i).getObjet()=="P") {
				P.vie=P.vie+inventaire.get(i).getVie();
				System.out.println("Soins termin�s \n +" + inventaire.get(i).getVie()+" PV ! ");
				inventaire.remove(i);
			}
			else throw new ExceptionJeu("Vous n'avez pas de potion dans votre inventaire ! \n");
		}
	}

	//m
	
	public void degat(Personnage P, Donjon d) throws ExceptionJeu {
		for (int i=0;i< vie;i++) {
			if(((Objet) P).getObjet()=="�") {
				P.vie=P.vie-P.getAttaque();
				System.out.println("Degat \n +" + P.getAttaque());
				inventaire.remove(i);
				
			}
		}
	}
}
