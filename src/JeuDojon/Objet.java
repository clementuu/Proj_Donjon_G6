package JeuDojon;

public class Objet {
	
	//Attribut
	
	private String objet = "o";
	private int soin;
	private int degats;
	
	//Constructeur

	public Objet(String objet, int soin, int degats) throws ExceptionJeu {
		setObjet(objet);
		setSoin(soin);
		setDegats(degats);
	}
	
	//Geters et seters
	
	public String getObjet() {
		return objet;
	}
	
	//P pour une potion, § pour un piège et # pour un mur
	public void setObjet(String objet) throws ExceptionJeu {
		if(objet == "P" || objet == "§" || objet =="#" || objet==" " && objet.length()<2) {
			this.objet = objet;
		}
		else 
			throw new ExceptionJeu("Objet inconnu");
		}

	public int getSoin() {
		return soin;
	}

	public void setSoin(int soin) throws ExceptionJeu {
		if(soin>=0 && soin<=10) {
			this.soin = soin;
		}
		else
			throw new ExceptionJeu("Non Obelix la potion est déjà assez forte comme ça ! ");
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) throws ExceptionJeu {
		if(degats>=0 && degats<=10) {
			this.degats = degats;
		}
		else
			throw new ExceptionJeu("La bombe nucléaire n'est pas autorisée dans ce jeu ! ");
	}
	
}
