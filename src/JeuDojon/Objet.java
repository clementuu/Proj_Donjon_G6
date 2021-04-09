package JeuDojon;

import java.util.*;

public class Objet extends Personnage {
	
	//Attribut
	
	private char objet = 'o';
	
	//Constructeur
	public Objet(List<Objet>inventaire) {
		super(0, 0, inventaire);
	}
	public Objet(char objet,List<Objet>inventaire) {
		super(0, 0, inventaire);
		setObjet(objet);
	}
	public Objet(char objet, int vie, int attaque) {
		super(vie, 0, 0);
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
