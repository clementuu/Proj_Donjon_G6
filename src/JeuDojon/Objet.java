package JeuDojon;

import java.util.*;

public class Objet extends Personnage {
	
	//Attribut
	
	private String objet = "o";
	
	//Constructeur

	public Objet(ArrayList<Objet>inventaire) throws ExceptionJeu{
		super(0, 0, inventaire);
	}

	public Objet(String objet,ArrayList<Objet>inventaire) throws ExceptionJeu {
		super(0, 0, inventaire);
		setObjet(objet);
	}

	public Objet(String objet, int vie, int attaque) throws ExceptionJeu {
		super(0,vie, attaque);
		setObjet(objet);
	}
	
	//Geters et seters
	
	public String getObjet() {
		return objet;
	}
	
	//P pour une potion, ï¿½ pour un piï¿½ge et # pour un mur
	public void setObjet(String objet) throws ExceptionJeu {
		if(objet == "P" || objet == "§" || objet =="#" && objet.length()<2) {
			this.objet = objet;
		}
		else 
			throw new ExceptionJeu("Objet inconnu");
		}
	
}
