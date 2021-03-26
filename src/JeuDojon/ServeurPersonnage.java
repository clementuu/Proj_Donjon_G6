package JeuDojon;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServeurPersonnage extends Thread{
		

		private Socket socket;
		private PrintStream out;
		private BufferedReader in;
		
		public ServeurPersonnage(Socket s){
			this.socket = s;
		}
		
		
		public void run(){
			try {
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
				for(int i=3; i<=4; i++) {
					d.placerObj(i,3,mur);
				}
				for(int i=7; i<=11; i++) {
					d.placerObj(i,5,mur);
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
				d.placerObj(12,8,piege);
				d.placerObj(3,6,piege);
				d.placerObj(14,4,potion);
				
				System.out.println("Rï¿½gles du jeu : 4 dï¿½placements maximum par tout autorisï¿½s \nLï¿½gende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \nï¿½ = Piï¿½ge \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \n");
				
				d.afficher();
				
				//System.out.println( "Test getter getCase() : " + d.getCase(0,0) + "\nDone\n");
				
				boolean b=false;
				
				for (int manche=0;manche<=10;manche++) {
					
					if(b==false) {
						
						System.out.println("Veuillez communiquer vos 4 prochains dï¿½placements : ");
						Scanner sc = new Scanner(System.in);
						String com = sc.next();
						System.out.println("Vous avez tapï¿½ : " + com + "\n");
						
						if(com.length() <= 4 ) {
							for(int j=0;j<=com.length()-1;j++) {
								if(com.charAt(j) != 'q' && com.charAt(j) != 'd' && com.charAt(j) != 's' && com.charAt(j) != 'z') {
									System.err.print("Mauvaise commande, veuillez rï¿½ï¿½ssayer \n");
								}
							}
							
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
								
							}
							
						}
												
						}
						
						else System.err.print("Contentez vous de 4 dï¿½placements maximum par tour \n");
				
						d.afficher();
						
					}
							
				}
			
			
			socket.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
				
   }		
				
}
