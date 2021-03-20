package JeuDojon;

import java.util.*;

public class Tests {
	
	public static void main(String[] args) {
		
		Personnage X = new Personnage(10,10,'X'); 
		Donjon d = new Donjon(15,10);
		Objet mur = new Objet('#');
		Objet potion = new Objet('P');
		Objet piege = new Objet('§');
		Personnage M = new Monstres(5,5,'M'); 
		d.placerPerso(2,8,X);
		
		d.placerPerso(14,9,M);
		
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
		
		d.placerObj(2,7,mur);
		d.placerObj(3,7,mur);
		d.placerObj(12,2,piege);
		d.placerObj(6,9,potion);
		d.placerObj(10,6,piege);
		d.placerObj(11,2,piege);
		d.placerObj(5,3,potion);
		d.placerObj(2,5,mur);
		d.placerObj(2,4,mur);
		d.placerObj(4,6,mur);
		
		System.out.println("Légende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n§ = Piège \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \n");
		
		d.afficher();
		
		//System.out.println( "Test getter getCase(4,7) : " + d.getCase(4,7) + "\nDone\n");
		
		for (int manche=0;manche<=50;manche++) {
			System.out.println("Veuillez communiquer vos 4 prochains déplacements : ");
			Scanner sc = new Scanner(System.in);
			String com = sc.next();
			System.out.println("Vous avez tapé : " + com + "\n");
			
			if(com.length() == 4) {
				for(int i=0;i<=com.length()-1;i++) {
					if(com.charAt(i) == 'z') {
						d.move(X,"Up");
					}
					if(com.charAt(i) == 's') {
						d.move(X,"Down");
					}
					if(com.charAt(i) == 'd') {
						d.move(X,"Right");
					}
					if(com.charAt(i) == 'q') {
						d.move(X,"Left");
					}
			}
			
			}
			else System.err.print("On a dit 4 \n");
			
			d.afficher();
			
		}
		
		/*d.moveUp(X);
		d.afficher();
		d.moveLeft(X);
		d.moveLeft(X);
		d.afficher();
		d.moveDown(X);
		d.afficher();
		d.moveRight(X); */
	}
}
