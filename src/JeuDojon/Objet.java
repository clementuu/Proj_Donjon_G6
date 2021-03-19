package JeuDojon;

public class Objet {
	
	private char objet = 'o';
	
	public Objet(char objet) {
		setObjet(objet);
	}

	public char getObjet() {
		return objet;
	}

	public void setObjet(char objet) {
		if(objet == 'P' || objet == '§') {
			this.objet = objet;
		}
		
	}
	
	
	
}
