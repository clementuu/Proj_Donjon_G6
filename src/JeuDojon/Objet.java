package JeuDojon;

public class Objet {
	
	//Attribut
	
	private char objet = 'o';
	
	//Constructeur
	
	public Objet(char objet) {
		setObjet(objet);
	}
	
	//Geters et seters
	
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
