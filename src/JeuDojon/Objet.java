package JeuDojon;

import java.util.ArrayList;

public class Objet extends Personnage {
	
	//Attribut
	
	private char objet = 'o';
	
	//Constructeur
	public Objet(ArrayList<Objet>[]inventaire) {
		super(inventaire);
	}
	public Objet(char objet,ArrayList<Objet>[]inventaire) {
		super(inventaire);
		setObjet(objet);
	}
	public Objet(char objet, int vie, int attaque) {
		super(vie,attaque);
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
