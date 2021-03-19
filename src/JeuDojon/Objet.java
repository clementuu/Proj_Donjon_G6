package JeuDojon;

public class Objet {
	
	private char objet = 'o';
	
	public Objet(char objet) {
		setObjet(objet);
	}

	public char getObjet() {
		return objet;
	}
	
	//P pour une potion, § pour un piège et # pour un mur
	public void setObjet(char objet) {
		if(objet == 'P' || objet == '§' || objet =='#') {
			this.objet = objet;
		}
		else 
			System.err.print("Objet inconnu");
		
	}
	
	
	
}
