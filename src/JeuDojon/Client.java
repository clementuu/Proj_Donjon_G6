package JeuDojon;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	

	private static BufferedReader in;
	private static PrintStream out;
	
	public static void main(String args[]) throws UnknownHostException, IOException{
		
		try {
			Socket socket= new Socket ("127.0.0.1", 6112);
			
			System.out.println("Bienvenue");
			System.out.println("Règles du jeu : 4 déplacements maximum par tour autorisés \nLégende : \nX = Joueur \nM = Monstre \n# = Mur \nP = Potion \n§ = Piège \nCommandes : \nz = haut \ns = bas \nd = droite \nq = gauche \ne = afficher l'inventaire \na = soin \nx = afficher stats joueur");
			
			in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
			Scanner scanner = new Scanner (System.in);
			System.out.println(in.readLine());			

			//System.out.println(in.readLine());
			
			for(int i=0;i<1000;i++){
				out.println(scanner.nextLine());
				
				String newView="";
				
				for(int j=0;j<in.readLine().length();j++) {
					if(in.readLine().charAt(j)!='@') {
						newView += in.readLine().charAt(j);
					}
					if(in.readLine().charAt(j)=='@') {
						newView += "\n";
					}
				}
				System.out.println(newView);
				
				System.out.println(in.readLine());
				System.out.println(in.readLine());
			}
			
			scanner.close();
			socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
	

