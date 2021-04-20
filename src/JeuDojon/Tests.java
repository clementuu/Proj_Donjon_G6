package JeuDojon;

import java.util.*;

public class Tests {
	
	public static void main(String[] args) throws ExceptionJeu {
		
		Personnage X = new Personnage(15,10,10,5,"X"); 
		Donjon d = new Donjon(15,10);
		Objet mur = new Objet("#",0,0);
		Objet potion = new Objet("P",5,0);
		Objet potionSup = new Objet("P",10,0);
		Objet piege = new Objet("§",1,5);
		Objet piegeDemoniaque = new Objet("§",5,10);

		//Monstres M = new Monstres(5,5,'M'); 
		d.placerPerso(2,8,X);
		
		//d.placerPerso(14,9,M);
		
		for(int i=1; i<=10; i++) {
			d.placerObj(i,1,mur);
		}
		for(int i=15; i>=12; i--) {
			d.placerObj(i,1,mur);
		}
		for(int i=1; i<=15; i++) {
			d.placerObj(i,10,mur);
		}
		for(int j=2; j<=5; j++) {
			d.placerObj(13,j,mur);
		}
		for(int j=1; j<=10; j++) {
			d.placerObj(1,j,mur);
		}
		for(int j=2; j<=9; j++) {
			d.placerObj(15,j,mur);
		}
		for(int i=11; i<15; i++) {
			d.placerObj(i,7,mur);
		}
		for(int i=8; i<=11; i++) {
			d.placerObj(i,8,mur);
		}
		for(int i=2; i<=5; i++) {
			d.placerObj(i,7,mur);
		}
		for(int i=9; i<=12; i++) {
			d.placerObj(i,3,mur);
		}
		for(int j=2; j<=5; j++) {
			d.placerObj(6,j,mur);
		}
		for(int i=3; i<=4; i++) {
			d.placerObj(i,3,mur);
		}
		for(int i=7; i<=11; i++) {
			d.placerObj(i,5,mur);
		}
		//X.ramasser(X, potion);
		d.placerObj(2,7,mur);
		d.placerObj(3,7,mur);
		d.placerObj(12,2,piegeDemoniaque);
		d.placerObj(6,9,potionSup);
		d.placerObj(10,6,piege);
		d.placerObj(11,2,piege);
		d.placerObj(5,3,potion);
		d.placerObj(2,5,mur);
		d.placerObj(2,4,mur);
		d.placerObj(4,6,mur);
		d.placerObj(12,8,piege);
		d.placerObj(3,6,piege);
		d.placerObj(14,4,potion);
		

		System.out.println("Rï¿½gles du jeu : 4 dï¿½placements maximum par tout autorisï¿½s \nLï¿½gende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \nï¿½ = Piï¿½ge \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \ne = afficher l'inventaire \na = soin \nx = afficher stats joueur");
		
	
		X.affInventaire();
	    System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso());
		X.soin(X,X.getInventaire());
		System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso());
		X.degat(X, d, piege);
		System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso()+"\n");
		d.afficher();
		X.affInventaire();
		
		X.afficherVueJV2(d,X);
		
		//System.out.println( "Test getter getCase() : " + d.getCase(0,0) + "\nDone\n");
		
		boolean b=false;
		
		
		for (int manche=0;manche<=20;manche++) {
			
			if(b==false) {
				
				System.out.println("Veuillez communiquer au maximum 4 dï¿½placements : ");
				Scanner sc = new Scanner(System.in);
				String com = sc.next();
				System.out.println("Vous avez tapï¿½ : " + com + "\n");
				
				if(com.length() < 5 ) {

					for(int j=0;j<com.length()-1;j++) {
						if(com.charAt(j) != 'q' && com.charAt(j) != 'd' && com.charAt(j) != 's' && com.charAt(j) != 'z' && com.charAt(j) != 'y' && com.charAt(j) != 'n') {
							System.err.print("Mauvaise commande, veuillez rï¿½ï¿½ssayer \n");
						}
					}					
					
					for(int i=0;i<com.length();i++) {
						if (com.charAt(i)=='a') {
							X.soin(X,X.getInventaire());
						}
						if (com.charAt(i)=='x') {
							System.out.println(X.toString());
						}
						if (com.charAt(i)=='e') {
							X.affInventaire();
						}						
						if(com.charAt(i) == 'z') {
							d.move(d,X,"Up");							
						}

						if(com.charAt(i) == 's') {							
							d.move(d,X,"Down");
						}
						if(com.charAt(i) == 'd') {
							d.move(d,X,"Right");
						}
						if(com.charAt(i) == 'q') {							
							d.move(d,X,"Left");
						}
						
							
						}
						
					if(b==false) {
						for(int x=0;x<d.getLongueur()-1;x++) {
							for(int y=0;y<d.getLargeur()-1;y++) {
								if(d.getCase(0, y)==X.getPerso() || d.getCase(d.getLongueur()-1, y)==X.getPerso() || d.getCase(x, 0)==X.getPerso() || d.getCase(x, d.getLargeur()-1)==X.getPerso()){
									b=true;	
								}
							}
						}
					}
					
					if(b==true) {
						
						System.out.println("Fï¿½licitations! Niveau terminï¿½ \n");				
						sc.close();
					}
					
				
				}					
				
				
				else System.err.print("Contentez vous de 4 dï¿½placements maximum par tour \n");
		
				//d.afficher();
				X.afficherVueJ(d,X);
			}

		}
	}
}
		
		/*d.moveUp(X);
		d.afficher();
		d.moveLeft(X);
		d.moveLeft(X);
		d.afficher();
		d.moveDown(X);
		d.afficher();
		d.moveRight(X); */


