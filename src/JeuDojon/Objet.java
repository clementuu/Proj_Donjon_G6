package JeuDojon;

import java.util.*;

public class Objet extends Personnage {
	
	//Attribut
	
	private char objet = 'o';
	
	//Constructeur
	public Objet(List<Objet>inventaire) throws ExceptionJeu {
		super(inventaire);
	}
	public Objet(char objet,List<Objet>inventaire) throws ExceptionJeu {
		super(inventaire);
		setObjet(objet);
	}
	public Objet(char objet, int vie, int attaque) throws ExceptionJeu {
		super(vie,attaque);
		setObjet(objet);
	}
	
	//Geters et seters
	
	public char getObjet() {
		return objet;
	}
	
	//P pour une potion, � pour un pi�ge et # pour un mur
	public void setObjet(char objet) throws ExceptionJeu {
		if(objet == 'P' || objet == '�' || objet =='#') {
			this.objet = objet;
		}
		else 
			throw new ExceptionJeu("Objet inconnu");
		
	}
	
	
	
}
