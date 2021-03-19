package JeuDojon;

public class Tests {
	
	public static void main(String[] args) {
		
		Personnage X = new Personnage(10); 
		Donjon d = new Donjon(15,10);
		Objet mur = new Objet('#');
		Objet potion = new Objet('P');
		Objet piege = new Objet('§');
		
		d.placerPerso(4,7,X);
		
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
		
		d.placerObj(2,7,mur);
		d.placerObj(12,2,piege);
		d.placerObj(6,9,potion);
		d.placerObj(10,6,piege);
		d.placerObj(11,2,piege);
		d.placerObj(5,3,potion);
		d.placerObj(2,5,mur);
		d.placerObj(2,4,mur);
		d.placerObj(4,6,mur);
		
		
		System.out.println("X = Joueur \n# = Mur \nP = Potion \n§ = Piège \n");
		
		d.afficher();
		
		System.out.println( "Test getter getCase(4,7) : " + d.getCase(4,7) + "\n");
		
		d.moveUp(X);
		d.moveUp(X);
		d.afficher();
		d.moveLeft(X);
		d.moveLeft(X);
		d.afficher();
		d.moveDown(X);
		d.afficher();
	}
}
