package JeuDojon;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	

	private static BufferedReader in;
	private static PrintStream out;
	
	public static void main(String args[]) throws UnknownHostException, IOException{
		
		Socket socket= new Socket ("127.0.0.1", 6112);
		
		System.out.println("Bienvenue");
		System.out.println("Règles du jeu : 4 déplacements maximum par tout autorisés \nLégende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n§ = Piège \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \n");
		
		in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		out = new PrintStream(socket.getOutputStream());
		Scanner scanner = new Scanner (System.in);
		
		System.out.println(in.readLine());
		
		for(int i=0;i<5;i++){
			out.println(scanner.nextLine());
			System.out.println(in.readLine());
		}
		
		scanner.close();
		socket.close();
	}
	
	
	
}
	

