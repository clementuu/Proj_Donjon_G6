package JeuDojon;



public class Donjon {
	
	//Attributs
	
	private int longueur;
	private int largeur;
	private String[][]donjon;
	
	//Constructeur
	
	public Donjon(int longueur) {
		setLongueur(longueur);
	}
	
	public Donjon(int longueur,int largeur) throws ExceptionJeu  {
		setLongueur(longueur);
		setLargeur(largeur);
		donjon=new String[longueur][largeur];
	
	
		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				donjon[i][j]=" ";
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
	
	/*
	 * public void vueClient(Personnage P) {
	 * 
		boolean b=false;
		boolean ok=false;

		for(int i=0;i<longueur;i++) {
			for(int j=0;j<largeur;j++) {
				if(i>=1 && j>=1 && i<longueur-1 && j<largeur-1) {
					b=true;
				}
				if (b==true && donjon[i][j]== P.getPerso()) {
					for(int a=i;a<i+3;a++) {
						for(int c=j;c<j+3;c++) {
							System.out.print(" "+ donjon[a][c]);
						}
						System.out.println();
					}
					System.out.println();
					ok=true;
				}
				//if(ok==false) {
					System.out.print(" "+ "~");
				//}
				//b=false;
			}
			System.out.println();
		}
		System.out.println();
	}
				
	 */
						
	public void placerAlea(Objet p) {
		
	int minX = 0;
	int maxX = longueur-1;
	
	
	int minY = 0;
	int maxY = largeur-1;
	
	
	int alea_X = (int)Math.floor(Math.random()*(maxX-minY+1)+minX);
	
	int alea_Y = (int)Math.floor(Math.random()*(maxY-minY+1)+minY);
	
	if(donjon[alea_X][alea_Y]==" ") {
		
		if(p.getObjet()=="P") {

			if(donjon[alea_X][alea_Y]==" ") 
				donjon[alea_X][alea_Y]="P";
			}
		
		if(p.getObjet()=="§") {
		
			if(donjon[alea_X][alea_Y]==" ") {
				donjon[alea_X][alea_Y]="§";
			 }
		  }
	}
	
	if(donjon[alea_X][alea_Y]!=" ") {
		
		boolean occupe =true;
		while(occupe==true) {
			
			int x = (int)Math.floor(Math.random()*(maxX-minY+1)+minX);
			
			int y = (int)Math.floor(Math.random()*(maxY-minY+1)+minY);
			
			if(donjon[x][y]==" ") {
				if(p.getObjet()=="P") {

					if(donjon[x][y]==" ") 
						donjon[x][y]="P";
					}
				
				if(p.getObjet()=="§") {
				
					if(donjon[x][y]==" ") {
						donjon[x][y]="§";
					 }
				  }
				occupe=false;
			}
			
		}
	}
	
	}
	
	
	public void placerObj(int x, int y, Objet p) throws ExceptionJeu{
		
		x = x-1; //ï¿½a permet placer les objets et perso en (1,1) au lieu de (0,0) c'est plus intuitif
		y = y-1;
		
		
		if(p.getObjet()=="#") {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				throw new ExceptionJeu("Hors map");
			}
			if(donjon[x][y]==" ") {
				donjon[x][y]="#";
			}

		if(p.getObjet()=="P") {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				throw new ExceptionJeu("Hors map");
			}
			if(donjon[x][y]==" ") {
				donjon[x][y]="P";
			}
		}
		
		if(p.getObjet()=="§") {
			if(x<0 || y<0 || x>longueur || y>largeur) {
				throw new ExceptionJeu("Hors map");
			}
			if(donjon[x][y]==" ") {
				donjon[x][y]="§";
			}
		}	
		}

	
	}
	
	public void placerPerso(int x, int y, Personnage p) throws ExceptionJeu {
		
		x = x-1;
		y = y-1;
		
		if(x<0 || y<0 || x>longueur || y>largeur) {
			throw new ExceptionJeu("Hors map");
		}
		if(donjon[x][y]==" ") {
			donjon[x][y]=p.getPerso();
		}
	}
			
	
	
	public String getCase(int x, int y) {
		return donjon[x][y];
	}
	
	public void move(Donjon d, Personnage P, String direction) throws ExceptionJeu {
		
		
		
		if(direction.equalsIgnoreCase("Up")) {
			//On cherche l'avatar dans le tableau
			for(int i=0;i<longueur;i++) {
				for(int j=0;j<largeur;j++) {
					//On anticipe le dï¿½placement et on regarde si la case sur laquelle on veut aller n'est pas une potion, on demande si le joueur veut la ramasser
					if (donjon[i][j]== P.getPerso()) {
						if(i-1>=0 && donjon[i-1][j]!="#") {  //On anticipe le déplacement et on regarde si la case sur laquelle on veut aller n'est pas un mur
							if(donjon[i-1][j]=="§") {
								Objet piege = new Objet("§",5,5);
								System.out.println("Vous êtes tombé(e) dans un piège !");
								P.degat(P,d,piege);
								d.placerAlea(piege);
							}
							if(donjon[i-1][j]=="M") {
								Monstres monstre = new Monstres(0,5,5,"M");
								System.out.println("Vous avez combattu un monstre !");
								P.atkSurprise(P,monstre);
							}
							if(donjon[i-1][j]=="P") {
								Objet potion = new Objet("P",5,0);
								System.out.println("Vous avez trouvé une potion ! ");
								P.ramasser(P,potion);
								System.out.println("Potion ajoutée à l'inventaire ! ");
								d.placerAlea(potion);
							}
							donjon[i][j] = " ";
							P.remplacerCase(i, j, d);
							donjon[i-1][j] = P.getPerso();
						}
						if(i-1>=0 && donjon[i-1][j]=="#") {
							P.remplacerCase(i-1, j, d);
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
						if(i+1<=longueur && donjon[i+1][j]!="#") {
							if(donjon[i+1][j]=="M") {
								Monstres monstre = new Monstres(0,5,5,"M");
								System.out.println("Vous avez combattu un monstre !");
								P.atkSurprise(P,monstre);
							}
							if(donjon[i+1][j]=="§") {	
								Objet piege = new Objet("§",5,5);
								System.out.println("Vous êtes tombé(e) dans un piège !");
								P.degat(P, d, piege);
								d.placerAlea(piege);
							}
							if(donjon[i+1][j]=="P") {
								Objet potion = new Objet("P",5,0);
								System.out.println("Vous avez trouvé une potion ! ");
								P.ramasser(P,potion);
								System.out.println("Potion ajoutée à l'inventaire ! ");
								d.placerAlea(potion);
							}
							donjon[i][j] = " ";
							P.remplacerCase(i, j, d);
							donjon[i+1][j] = P.getPerso();
						}
						if(i+1<=longueur && donjon[i+1][j]=="#") {
							P.remplacerCase(i+1, j, d);
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
						if(j+1<=largeur && donjon[i][j+1]!="#") {
							if(donjon[i][j+1]=="M") {
								Monstres monstre = new Monstres(0,5,5,"M");
								System.out.println("Vous avez combattu un monstre !");
								P.atkSurprise(P,monstre);
							}
							if(donjon[i][j+1]=="§") {	
								Objet piege = new Objet("§",5,5);
								System.out.println("Vous êtes tombé(e) dans un piège !");
								P.degat(P, d, piege);
								d.placerAlea(piege);
							}
							if(donjon[i][j+1]=="P") {
								Objet potion = new Objet("P",5,0);
								System.out.println("Vous avez trouvé une potion ! ");
								P.ramasser(P,potion);
								System.out.println("Potion ajoutée à l'inventaire ! ");
								d.placerAlea(potion);
							}
							donjon[i][j] = " ";
							P.remplacerCase(i, j, d);
							donjon[i][j+1] = P.getPerso();
						}
						if(j+1<=largeur && donjon[i][j+1]=="#") {
							P.remplacerCase(i, j+1, d);
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
						if(j-1>=0 && donjon[i][j-1]!="#") {
							if(donjon[i][j-1]=="M") {
								Monstres monstre = new Monstres(0,5,5,"M");
								System.out.println("Vous avez combattu un monstre !");
								P.atkSurprise(P,monstre);
							}
							if(donjon[i][j-1]=="§") {
								Objet piege = new Objet("§",5,5);
								System.out.println("Vous êtes tombé(e) dans un piège !");
								P.degat(P,d,piege);
								d.placerAlea(piege);
							}
							if(donjon[i][j-1]=="P") {
								Objet potion = new Objet("P",5,0);
								System.out.println("Vous avez trouvé une potion ! ");
								P.ramasser(P,potion);
								System.out.println("Potion ajoutée à l'inventaire ! ");
								d.placerAlea(potion);
							}
							donjon[i][j] = " ";
							P.remplacerCase(i, j, d);
							donjon[i][j-1] = P.getPerso();
						}
						if(j-1>=0 && donjon[i][j-1]=="#") {
							P.remplacerCase(i, j-1, d);
						}
						
			
					}
				
				}	
			}
		}
		
	}
	
	//Essayez de rajouter des fonctions pour soigner quand on recupere un potion, infliger des degats quand on tombe dans un piege etc 
	
}