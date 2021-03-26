package JeuDojon;

import java.io.*;
import java.net.*;

public class ServeurPersonnage extends Thread{
		

		private Socket socket;
		private PrintStream out;
		private BufferedReader in;
		
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
					out.println("SERVEUR : en attente de requête");
					
					
					//5 requêtes
				for(int req=0;req<5;req++){
					
				
					String message = in.readLine();
				
					if (message.equals("z")){
						
						out.println(System.nanoTime());//+" "+req);
				
					}
					else
					{  
						
						out.println("bug");//+req);
					}
				}
				socket.close();
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

