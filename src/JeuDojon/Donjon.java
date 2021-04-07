package JeuDojon;

public class Donjon {
	
	//Attributs
	
	private int longueur;
	private int largeur;
	private char[][]donjon;
	
	//Constructeur
	
	public Donjon(int longueur,int largeur) {
		setLongueur(longueur);
		setLargeur(largeur);
		donjon=new char[longueur][largeur];
	
	
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				donjon[i][j]=' ';
			}
		}
	}	
	
	//Seters et geters
	
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
	
	//Fonctions
	
	public void afficher() {

		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				System.out.print(" "+ donjon[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void vueClient(Personnage P) {

		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				if (donjon[i-1][j]== P.getPerso()) {
					System.out.print(" "+ donjon[i][j-1] + " "+ donjon[i][j] + " "+ donjon[i][j+1]);
						}
				if (donjon[i][j]== P.getPerso()) {
					System.out.print(" "+ donjon[i][j-1] + " "+ donjon[i][j] + " "+ donjon[i][j+1]);
					}
				if (donjon[i+1][j]== P.getPerso()) {
					System.out.print(" "+ donjon[i][j-1] + " "+ donjon[i][j] + " "+ donjon[i][j+1]);
					}
				else
					System.out.print(" "+ '~');
			}		
			System.out.println();
		}
		System.out.println();
	}
	
	public void placerObj(int x, int y, Objet p) {
		
		x = x-1; //�a permet placer les objets et perso en (1,1) au lieu de (0,0) c'est plus intuitif
		y = y-1;
		
		
		if(p.getObjet()=='#') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]==' ') {
				donjon[x][y]='#';
			}
		}
		
		if(p.getObjet()=='P') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]==' ') {
				donjon[x][y]='P';
			}
		}
		
		if(p.getObjet()=='�') {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				System.err.print("Hors map");
			}
			if(donjon[x][y]==' ') {
				donjon[x][y]='�';
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
			if(donjon[x][y]==' ') {
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
					//On anticipe le d�placement et on regarde si la case sur laquelle on veut aller n'est pas un mur
					if (donjon[i][j]== P.getPerso()) {
						if(i-1>=0 && donjon[i-1][j]!='#') {
							donjon[i][j] = ' ';
							donjon[i-1][j] = P.getPerso();
						}

					}
				
				}	
			}
		}
		if(direction.equalsIgnoreCase("Down")) {
			boolean b=true;
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					if (donjon[i][j]== P.getPerso() && b==true) {
						if(i+1<=longueur && donjon[i+1][j]!='#') {
							donjon[i][j] = ' ';
							donjon[i+1][j] = P.getPerso();
						}
						
						b=false;
						
					}
				
				}	
			}
		}
		if(direction.equalsIgnoreCase("Right")) {
			boolean b =true;
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					if (donjon[i][j]== P.getPerso() && b==true) {
						if(j+1<=largeur && donjon[i][j+1]!='#') {
							donjon[i][j] = ' ';
							donjon[i][j+1] = P.getPerso();
						}
						
						b=false;
				
					}
				
				}	
			}
		}
		if(direction.equalsIgnoreCase("Left")) {
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					if (donjon[i][j]== P.getPerso()) {
						if(j-1>=0 && donjon[i][j-1]!='#') {
							donjon[i][j] = ' ';
							donjon[i][j-1] = P.getPerso();
						}
			
					}
				
				}	
			}
		}
		
	}
	
	//Essayez de rajouter des fonctions pour soigner quand on recupere un potion, infliger des degats quand on tombe dans un piege etc 
	
}