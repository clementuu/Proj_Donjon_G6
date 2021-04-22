package JeuDojon;

import java.io.*;
import java.net.*;

public class ServeurPersonnage extends Thread {
		

		private Socket socket;
		private BufferedReader in;
		private PrintStream out;
		
		public ServeurPersonnage(Socket s){
			this.socket = s;
		}
		
		
		public void run(){
			try {
				in = new BufferedReader(
				          new InputStreamReader(socket.getInputStream())
				          );
					
					out = new PrintStream(socket.getOutputStream());
					
					//envoi du premier message
					out.println("Escape The Donjon \n");
				
				
					
				Personnage X = new Personnage(15,10,10,5,"X"); 
				Donjon d = new Donjon(15,10);
				Objet mur = new Objet("#",0,0);
				
				
				Objet potion = new Objet("P",5,0);

				Objet potionSup = new Objet("P",10,0);
				Objet piege = new Objet("§",1,5);
				Objet piegeDemoniaque = new Objet("§",5,10);

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
				
				X.afficherVueJV2(d, X,out);
				
				boolean b=false;
				
				for (int manche=0;manche<=50;manche++) {
					
					if(b==false) {
											
						String a = "";

						for(int i=0;i<d.getLongueur();i++) {
							for(int j=0;j<d.getLargeur();j++) {
								a = a +" "+  X.getCaseJ(i, j);
							}
							a = a + "@";
						}
						a = a + "@";
						
						out.println(a);
						
						out.println("Veuillez communiquer vos 4 prochains dï¿½placements : ");
						out.flush();
						String com = in.readLine();
						out.println("Vous avez tapï¿½ : " + com );
						out.flush();
						
						if(com.length() <= 4 ) {
							for(int j=0;j<=com.length()-1;j++) {
								if(com.charAt(j) != 'q' && com.charAt(j) != 'd' && com.charAt(j) != 's' && com.charAt(j) != 'z' && com.charAt(j) != 'y' && com.charAt(j) != 'n' && com.charAt(j) != 'a' && com.charAt(j) != 'e' && com.charAt(j) != 'x') {
									out.println("Mauvaise commande, veuillez rï¿½ï¿½ssayer \n");
								}
							}
							
							for(int i=0;i<=com.length()-1;i++) {
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
								
								out.println("Fï¿½licitations! Niveau terminï¿½ \n");				
								
							}
							
						}
												
						}
						
						else out.println("Contentez vous de 4 dï¿½placements maximum par tour \n");
				
						d.afficher();
					
						
					}
												
				}
			
			
			socket.close();
			
			
		} catch (IOException | ExceptionJeu e) {
			e.printStackTrace();
		}
					
		
					
						
   }		
				
}
