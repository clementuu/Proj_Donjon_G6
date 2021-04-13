package JeuDojon;

import java.util.*;

public class Tests {
	
	public static void main(String[] args) throws ExceptionJeu {
		
		Personnage X = new Personnage(10,10,'X'); 
		Donjon d = new Donjon(15,10);
		Objet mur = new Objet("#",0,0);
		Objet potion = new Objet("P",5,0);
		Objet piege = new Objet("§",0,5);
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
		X.ramasser(d, X, potion);
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
		d.placerObj(12,8,piege);
		d.placerObj(3,6,piege);
		d.placerObj(14,4,potion);
		
		System.out.println("Règles du jeu : 4 déplacements maximum par tout autorisés \nLégende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n§ = Piège \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \n");
		
		d.afficher();
		X.affInventaire();
		//d.vueClient(X);
		//X.afficherVueJ(d);
		
		//System.out.println( "Test getter getCase() : " + d.getCase(0,0) + "\nDone\n");
		
		boolean b=false;
		
		
		for (int manche=0;manche<=10;manche++) {
			
			if(b==false) {
				
				System.out.println("Veuillez communiquer au maximum 4 déplacements : ");
				Scanner sc = new Scanner(System.in);
				String com = sc.next();
				System.out.println("Vous avez tapé : " + com + "\n");
				
				if(com.length() <= 5 ) {
					boolean ramassé=true;
					for(int j=0;j<com.length()-1;j++) {
						if(com.charAt(j) != 'q' && com.charAt(j) != 'd' && com.charAt(j) != 's' && com.charAt(j) != 'z' && com.charAt(j) != 'y' && com.charAt(j) != 'n') {
							System.err.print("Mauvaise commande, veuillez rï¿½ï¿½ssayer \n");
						}
					}
					if (com.charAt(com.length()-1)=='e') {
						X.affInventaire();
					}
					
					
					for(int i=0;i<=com.length()-1;i++) {
						if(com.charAt(i) == 'z') {
							d.move(d,X,"Up");
							
						}
						if(com.charAt(i) == 's' && ramassé==true) {
							for(int ae=0;ae<d.getLongueur();ae++) {
								for(int z=0;z<d.getLargeur();z++) {
									if (d.getCase(ae,z)== X.getPerso()) {
										if(ae+1<=d.getLongueur() && d.getCase(ae+1,z)=='P') {
											Objet p = new Objet("P",5,0);
											System.out.println("Vous avez trouvé une potion, voulez vous la ramasser ? \ny : Oui\nn : Non");
											if(com=="y") {
												X.ramasser(d,X,p);
												System.out.println("Potion ajouté à votre inventaire!");
											}
											else 
												ramassé=false;
										}
									}
								}
							}
							d.move(d,X,"Down");
						}
						if(com.charAt(i) == 'd') {
							d.move(d,X,"Right");
						}
						if(com.charAt(i) == 'q') {
							d.move(d,X,"Left");
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
						
						System.out.println("Félicitations! Niveau terminé \n");				
						sc.close();
					}
					
				}
										
				}
				
				else System.err.print("Contentez vous de 4 déplacements maximum par tour \n");
		
				d.afficher();
				
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
	}
}
