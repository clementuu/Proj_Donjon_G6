package JeuDojon;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Serveur {

	private static int PORT = 6112;
	
	public Serveur(){
		
	}
	
	public static void main(String[] args) {
		// Premier message
		// Premier message
				System.out.println("Serveur démarré");
				ServerSocket s = null;
				try {
					
					//Creation socket serveur
					s = new ServerSocket(PORT);
				}
				catch(IOException e){
					e.printStackTrace();
				}
				int clientNo=0;
				while(true){
					try {
						//en attente d'une connexion avec un client:  
						Socket client = s.accept();
						clientNo++;
						
						//création du nouveau thread en passant le socket comme parametre
						ServeurPersonnage game = new ServeurPersonnage(client);
						//démarrage 
						game.start();
						System.out.println("client "+clientNo+" servi");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}

		}