package JeuDojon;

import java.util.*;

public class Tests {
	
	public static void main(String[] args) throws ExceptionJeu {
		
		Personnage X = new Personnage(15,10,15,5,"X"); 
		Donjon d = new Donjon(15,10);
		Objet mur = new Objet("#",0,0);
		Objet potion = new Objet("P",5,0);
		Objet potionSup = new Objet("P",10,0);
		Objet piege = new Objet("§",1,5);
		Objet piegeDemoniaque = new Objet("§",5,10);
		Monstres M = new Monstres(0,5,5,"M");
		
		d.placerPerso(7,8,X);
		
		d.placerPerso(14,9,M);
		d.placerPerso(5,2,M);
		
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
		d.placerObj(2,5,mur);
		d.placerObj(2,4,mur);
		d.placerObj(4,6,mur);
		

		d.placerAlea(potionSup);
		
		d.placerAlea(piegeDemoniaque);
		d.placerAlea(potion);
		d.placerAlea(piege);
		//d.placerAlea(piege);
		//d.placerAlea(piege);
		d.placerAlea(piege);
		d.placerAlea(potion);
		d.placerAlea(potion);
		

		System.out.println("Règles du jeu : 4 déplacements maximum par tout autorisés \nLégende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n§ = Piège \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \ne = afficher l'inventaire \na = soin \nx = afficher stats joueur \n");

		/*
		 * X.affInventaire();
	    System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso());
		X.soin(X,X.getInventaire());
		System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso());
		X.degat(X, d, piege);
		System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso()+"\n");
		d.afficher();
		X.affInventaire();
		 */
		
		
		
		X.afficherVueJ(d,X);
		
		//System.out.println( "Test getter getCase() : " + d.getCase(0,0) + "\nDone\n");
		
	    boolean b=false;
	    boolean gameOver=false;
		
		
		for (int manche=0;manche<=40;manche++) {
			
			while(b==false && gameOver==false) {
				
				System.out.println("Veuillez communiquer au maximum 4 déplacements : ");
				Scanner sc = new Scanner(System.in);
				String com = sc.next();
				System.out.println("Vous avez tapé : " + com + "\n");
				
				if(com.length() < 5 ) {

					for(int j=0;j<com.length()-1;j++) {
						if(com.charAt(j) != 'q' && com.charAt(j) != 'd' && com.charAt(j) != 's' && com.charAt(j) != 'z' && com.charAt(j) != 'a' && com.charAt(j) != 'e' && com.charAt(j) != 'x') {
							System.err.print("Mauvaise commande, veuillez rééssayer \n");
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
										
					for(int x=0;x<d.getLongueur()-1;x++) {
						for(int y=0;y<d.getLargeur()-1;y++) {
							if(d.getCase(0, y)==X.getPerso() || d.getCase(d.getLongueur()-1, y)==X.getPerso() || d.getCase(x, 0)==X.getPerso() || d.getCase(x, d.getLargeur()-1)==X.getPerso() && b==false){
								System.out.println("Félicitations! Partie terminée \n");
								sc.close();
								b=true;									
							}
						}
					}
					
					if(X.getVie()<=0 && gameOver==false) {
						System.out.println("Vous êtes mort, fin de partie ");
						sc.close();
						gameOver=true;
					}
			
				
				}					
				
				
				else System.err.print("Contentez vous de 4 déplacements maximum par tour \n");
		
				//d.afficher();
				if(b==false && gameOver==false) {
					X.afficherVueJ(d,X);
				}
				
			}

		}
		if(b==false && gameOver==false) {
			System.out.println("Vous avez passé trop de temps dans le donjon... \nVous commencez à sombrer dans la folie... \nGame Over ");
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


