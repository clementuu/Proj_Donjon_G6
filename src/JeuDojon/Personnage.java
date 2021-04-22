package JeuDojon;

import java.io.*;
import java.util.*;

public class Personnage extends Donjon{
	
	//Attributs
	
	private String perso;
	private int vie;
	private static int VIEMAX=30;
	private ArrayList<Objet> inventaire = new ArrayList<Objet>();
	private int attaque;
	private String[][]vueJoueur;
	
	
	//Constructeurs
		
	public Personnage(int longueur, int vie,int attaque) throws ExceptionJeu {
		super(longueur);
		setVie(vie);
		setAttaque(attaque);
	}		
	
	public Personnage(int longueur, int vie,int attaque, String perso) throws ExceptionJeu {
		super(longueur);
		setVie(vie);
		setAttaque(attaque);
		setPerso(perso);
	}		
	
	public Personnage(int longueur, int largeur, int vie, int attaque) throws ExceptionJeu {
		super(longueur,largeur);
		setVie(vie);
		setAttaque(attaque);
		vueJoueur=new String[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]="~";
			}
		}
	}
	
	public Personnage(int longueur, int largeur, int vie, int attaque, String perso) throws ExceptionJeu  {
		super(longueur,largeur);
		setVie(vie);
		setAttaque(attaque);
		setPerso(perso);
		vueJoueur=new String[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]="~";
			}
		}
	}
	

	public Personnage(int longueur, int largeur, ArrayList<Objet> inventaire) throws ExceptionJeu {
		super(longueur,largeur);
		setInventaire(inventaire);
		vueJoueur=new String[longueur][largeur];
		
		
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				vueJoueur[i][j]="~";
			}
		}
	}
		
	
	//Geters et seters

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		if(vie>=0 && vie<=VIEMAX) {
			this.vie = vie;
		}
		else
			System.err.print("Vie du personnage trop faible ou trop ï¿½levï¿½e \n");
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

	public String getPerso() {
		return perso;
	}

	public void setPerso(String perso) {
		if(perso.length()<2) {
			this.perso = perso;
		}
		else
			System.err.print("Personnage inconnu \n");
	}

	public static int getVIEMAX() {
		return VIEMAX;
	}



	public static void setVIEMAX(int vIEMAX) {
		VIEMAX = vIEMAX;
	}



	public String[][] getVueJoueur() {
		return vueJoueur;
	}

	public void setVueJoueur(String[][] vueJoueur) {
		this.vueJoueur = vueJoueur;
	}
	

	public void ramasser(Personnage P,Objet p) throws ExceptionJeu {
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
	
	public void afficherVueJV2(Donjon d,Personnage P, PrintStream out) {
		
		String a = "";

		for(int i=0;i<d.getLongueur();i++) {
			for(int j=0;j<d.getLargeur();j++) {
				if(d.getCase(i, j)==P.getPerso()) {
					vueJoueur[i][j]=P.getPerso();
				}
				a = a +" "+ vueJoueur[i][j];
			}
			a = a + "@";
		}
		a = a + "@";
		
		out.println(a);
	}
	
	public void recupVueJV2(Donjon d,Personnage P,BufferedReader in) throws IOException {
		
		String newView="";
		
		for(int j=0;j<in.readLine().length();j++) {
			if(in.readLine().charAt(j)!='@') {
				newView += in.readLine().charAt(j);
			}
			if(in.readLine().charAt(j)=='@') {
				newView += "\n";
			}
		}
		System.out.println(newView);
	}
	
	public String getCaseJ(int x, int y) {
		return vueJoueur[x][y];
	}
	
	public ArrayList<Objet>affInventaire() throws ExceptionJeu {
		if(inventaire.size()==0){
			System.out.println("L'inventaire est vide");
		} 
		else
			System.out.println("Inventaire : ");
			for (int i=0;i<inventaire.size();i++) {
				System.out.print(inventaire.get(i).getObjet() + " ");
			}
			System.out.println();
			return inventaire;
	}
	
	public String toString() {
		return "Vie : " + getVie() + "\nAttaque : " + getAttaque()+"\n";
	}
	
	public void laisserPotion(int x, int y) throws ExceptionJeu{
		if(vueJoueur[x][y]=="~") {
			vueJoueur[x][y]="P";
		}
	}
	
	public void remplacerCase(int x,int y,Donjon d) throws ExceptionJeu {
		
		if(d.getCase(x, y)=="#") {
			if(x<0 || y<0 || x>d.getLongueur() || y>d.getLargeur()) {
				throw new ExceptionJeu("Hors map");
			}
			if(vueJoueur[x][y]=="~" || vueJoueur[x][y]==getPerso()) {
				vueJoueur[x][y]="#";
			}
		}
		
		if(d.getCase(x, y)==" " || d.getCase(x, y)=="P" || d.getCase(x,y)=="§") {
			if(x<0 || y<0 || x>d.getLongueur() || y>d.getLargeur()) {
				throw new ExceptionJeu("Hors map");
			}
			if(vueJoueur[x][y]=="~" || vueJoueur[x][y]==getPerso()) {
				vueJoueur[x][y]=" ";
			}
		}
			
	}
	
	
	public void soin(Personnage P,ArrayList<Objet> inventaire) throws ExceptionJeu {
		boolean soin=false;
		while(soin==false) {
			for (int i=0;i<inventaire.size();i++) {
				if(inventaire.get(i).getObjet()=="P" && P.getVie()+inventaire.get(i).getVie()<Personnage.getVIEMAX()) {
					P.vie=P.vie+inventaire.get(i).getVie();
					System.out.println("Soins terminï¿½s \n +" + inventaire.get(i).getVie()+" PV ! \nVie : " + P.getVie());
					inventaire.remove(i);
					soin=true;
				}
				if( P.getVie()+inventaire.get(i).getVie()>=Personnage.getVIEMAX() && soin==false) {
					P.vie=Personnage.getVIEMAX();
					System.out.println("Soins terminï¿½s \nVotre vie est au maximum \nVie : " + P.getVie());
					inventaire.remove(i);
					soin=true;
				}
				if(inventaire.size()==0 && soin==false) {
					System.out.println("Vous n'avez pas de potion dans votre inventaire ! ");
				}
			}
		}
		
	}

	//u
	
	public void degat(Personnage P, Donjon d, Objet o) throws ExceptionJeu {
		P.vie=P.vie-o.getAttaque();
		System.out.println("Degat \n -" + o.getAttaque()+" PV !");				
	}
	
	public void atkSurprise(Personnage P, Monstres M) {
		
		int minX = 1;
		int maxX = 5;	
		
		int alea_X = (int)Math.floor(Math.random()*(maxX-minX)+1);
		P.vie=P.vie-alea_X;
		System.out.println("Degat \n -" + alea_X + " PV ! ");
		
	}
	
}
