package JeuDojon;
import java.util.*;

public class Donjon {
	
	private int longueur;
	private int largeur;
	private char[][]donjon;
	
	public Donjon(int longueur,int largeur) {
		setLongueur(longueur);
		setLargeur(largeur);
		donjon=new char[longueur][largeur];
	
	
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				donjon[i][j]='-';
			}
		}
	}	
	
	public int getLargeur() {
		return largeur;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public int getLongueur() {
		return longueur;
	}
	
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	
	public void afficher() {

		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				System.out.print("  "+ donjon[i][j]);
			}
			System.out.println("\n");
		}
		System.out.println();
	}
	
	public void placerObj(int x, int y, Objet p) {
		x = x-1;
		y = y-1;
		
		
		if(p.getObjet()=='#') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]=='-') {
				donjon[x][y]='#';
			}
		}
		
		if(p.getObjet()=='P') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]=='-') {
				donjon[x][y]='P';
			}
		}
		
		if(p.getObjet()=='§') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]=='-') {
				donjon[x][y]='§';
			}
		}		
	
	}
	
	public void placerPerso(int x, int y, Personnage p) {
		x = x-1;
		y = y-1;
		
		if(p.getPerso()=='X' || p.getPerso()=='M') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]=='-') {
				donjon[x][y]=p.getPerso();
			}
		}
	}
	
	public char getCase(int x, int y) {
		return donjon[x][y];
	}
	
	public void move(Personnage P,String direction) {
		
		if(direction.equalsIgnoreCase("Up")) {
			//On cherche l'avatar dans le tableau
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					//On anticipe le déplacement et on regarde si la case sur laquelle on veut aller n'est pas un mur
					if (donjon[i][j]== P.getPerso()) {
						if(i-1>0 && donjon[i-1][j]!='#') {
							donjon[i][j] = '-';
							donjon[i-1][j] = P.getPerso();
						}
						if(i-1==0){
							System.out.println("Félicitations! Niveau terminé");
						}
						
					}
				
				}	
			}
		}
		if(direction.equalsIgnoreCase("Down")) {
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					if (donjon[i][j]== P.getPerso()) {
						if(i+1<longueur && donjon[i+1][j]!='#') {
							donjon[i][j] = '-';
							donjon[i+1][j] = P.getPerso();
						}
						if(i+1==longueur){
							System.out.println("Félicitations! Niveau terminé");
						}
					
					}
				
				}	
			}
		}
		if(direction.equalsIgnoreCase("Right")) {
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					if (donjon[i][j]== P.getPerso()) {
						if(j+1<largeur && donjon[i][j+1]!='#') {
							donjon[i][j] = '-';
							donjon[i][j+1] = P.getPerso();
						}
						if(i+1==largeur){
							System.out.println("Félicitations! Niveau terminé");
						}
					
					}
				
				}	
			}
		}
		if(direction.equalsIgnoreCase("Left")) {
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					if (donjon[i][j]== P.getPerso()) {
						if(j-1>0 && donjon[i][j-1]!='#') {
							donjon[i][j] = '-';
							donjon[i][j-1] = P.getPerso();
						}
						if(j-1==0){
							System.out.println("Félicitations! Niveau terminé");
						}
					
					}
				
				}	
			}
		}
		
	}
	
	
}