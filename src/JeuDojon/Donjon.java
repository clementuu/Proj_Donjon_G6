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
				donjon[i][j]='?';
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
				System.out.print(" "+ donjon[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void placer(int x, int y, char p) {
		x = x-1;
		y = y-1;
		
		if(p=='X') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]=='?') {
				donjon[x][y]='X';
			}
		}
		
		if(p=='#') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]=='?') {
				donjon[x][y]='#';
			}
		}		
		
	
	}
	
	public char getCase(int x, int y) {
		return donjon[x][y];
	}
	
	public void moveUp() {
		
		char m;
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				if (donjon[i][j]=='X') {
					if(i-1>=0 && donjon[i-1][j]!='#') {
						m = donjon[i][j];
						donjon[i][j] = ' ';
						donjon[i-1][j] = m;
					}
					else donjon[i-1][j] ='#';
					
				}
			
			}	
		}
		
	}
	
	public void moveDown() {
		
		char m;
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				if (donjon[i][j]=='X') {
					if(i+1<longueur && donjon[i+1][j]!='#') {
						m = donjon[i][j];
						donjon[i][j] = ' ';
						donjon[i+1][j] = m;
					}
					else donjon[i+1][j] ='#';
					
				}
			
			}	
		}
		
	}
	
	public void moveRight() {
		
		char m;
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				if (donjon[i][j]=='X') {
					if(j+1<largeur && donjon[i][j+1]!='#') {
						m = donjon[i][j];
						donjon[i][j] = ' ';
						donjon[i][j+1] = m;
					}
					else donjon[i][j+1] ='#';
					
				}
			
			}	
		}
		
	}
	
	public void moveLeft() {
		
		char m;
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				if (donjon[i][j]=='X') {
					if(j-1>=0 && donjon[i][j-1]!='#') {
						m = donjon[i][j];
						donjon[i][j] = ' ';
						donjon[i][j-1] = m;
					}
					else donjon[i][j-1] ='#';
					
				}
			
			}	
		}
		
	}
	
}