package JeuDojon;

import java.util.*;

public class Tests {
	
	public static void main(String[] args) throws ExceptionJeu {
		
		Personnage X = new Personnage(15,10,10,5,'X'); 
		Donjon d = new Donjon(15,10);
		Objet mur = new Objet("#",0,0);
		Objet potion = new Objet("P",5,0);
		Objet piege = new Objet("�",0,5);
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
		

		System.out.println("R�gles du jeu : 4 d�placements maximum par tout autoris�s \nL�gende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n� = Pi�ge \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \n");
		

		System.out.println("R�gles du jeu : 4 d�placements maximum par tout autoris�s \nL�gende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n� = Pi�ge \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \n");
	
		X.affInventaire();
	    System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso());
		X.soin(X,X.getInventaire());
		 System.out.println(X.getVie()+" : Vie du Joueur "+X.getPerso());

		d.afficher();
		X.affInventaire();
		
		//X.afficherVueJ(d,X);
		
		//System.out.println( "Test getter getCase() : " + d.getCase(0,0) + "\nDone\n");
		
		boolean b=false;
		
		
		for (int manche=0;manche<=20;manche++) {
			
			if(b==false) {
				
				System.out.println("Veuillez communiquer au maximum 4 d�placements : ");
				Scanner sc = new Scanner(System.in);
				String com = sc.next();
				System.out.println("Vous avez tap� : " + com + "\n");
				
				if(com.length() <= 5 ) {

					boolean ramasse=true;

					for(int j=0;j<com.length()-1;j++) {
						if(com.charAt(j) != 'q' && com.charAt(j) != 'd' && com.charAt(j) != 's' && com.charAt(j) != 'z' && com.charAt(j) != 'y' && com.charAt(j) != 'n') {
							System.err.print("Mauvaise commande, veuillez r��ssayer \n");
						}
					}					
					
					for(int i=0;i<com.length();i++) {
						boolean ramasser=false;
						if (com.charAt(i)=='e') {
							X.affInventaire();
						}						
						if(com.charAt(i) == 'z' && ramasser==false) {
							for(int c=0;c<d.getLongueur();c++) {
								for(int co=0;co<d.getLargeur();co++) {
									if (d.getCase(c,co)== X.getPerso()) {
										if(c-1>=0 && d.getCase(c-1, co)=='P') {
											Objet p = new Objet("P",5,0);
											System.out.println("Vous avez trouv� une potion, voulez vous la ramasser ? \ny : Oui\nn : Non");
											if(com=="y") {
												X.ramasser(d,X,p);
												System.out.println("Potion ajout� � votre inventaire!");
												ramasser=true;
											}	
										}
									}
								}
							}
							d.move(d,X,"Up");							
						}

						if(com.charAt(i) == 's' && ramasse==true) {

						if(com.charAt(i) == 's' && ramasser==false) {

							for(int ae=0;ae<d.getLongueur();ae++) {
								for(int z=0;z<d.getLargeur();z++) {
									if (d.getCase(ae,z)== X.getPerso()) {
										if(ae+1<=d.getLongueur() && d.getCase(ae+1,z)=='P') {
											Objet p = new Objet("P",5,0);
											System.out.println("Vous avez trouv� une potion, voulez vous la ramasser ? \ny : Oui\nn : Non");
											if(com=="y") {
												X.ramasser(d,X,p);

												System.out.println("Potion ajout� � votre inventaire!");
											}
											else 
												ramasse=false;

												System.out.println("Potion ajout� � votre inventaire!");
												ramasser=true;
											}									

										}
									}
								}
							}
							
							d.move(d,X,"Down");
						}
						if(com.charAt(i) == 'd') {
							for(int e=0;e<d.getLongueur();e++) {
								for(int f=0;f<d.getLargeur();f++) {
									if (d.getCase(e,f)== X.getPerso()) {
										if(f+1<=d.getLargeur() && d.getCase(e,f+1)=='P') {
											Objet p = new Objet("P",5,0);
											System.out.println("Vous avez trouv� une potion, voulez vous la ramasser ? \ny : Oui\nn : Non");
											if(com=="y") {
												X.ramasser(d,X,p);
												System.out.println("Potion ajout� � votre inventaire!");
												ramasser=true;
											}									
										}
									}
								}
							}
							d.move(d,X,"Right");
						}
						if(com.charAt(i) == 'q') {
							for(int j=0;j<d.getLongueur();j++) {
								for(int k=0;k<d.getLargeur();k++) {
									if (d.getCase(j,k)== X.getPerso()) {
										if(k-1<=d.getLongueur() && d.getCase(j,k-1)=='P') {
											Objet p = new Objet("P",5,0);
											System.out.println("Vous avez trouv� une potion, voulez vous la ramasser ? \ny : Oui\nn : Non");
											if(com=="y") {
												X.ramasser(d,X,p);
												System.out.println("Potion ajout� � votre inventaire!");
												ramasser=true;
											}									
										}
									}
								}
							}
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
						
						System.out.println("F�licitations! Niveau termin� \n");				
						sc.close();
					}
					
				}
										
				}
				
				else System.err.print("Contentez vous de 4 d�placements maximum par tour \n");
		
				d.afficher();
				X.afficherVueJ(d,X);
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

