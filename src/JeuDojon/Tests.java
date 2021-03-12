package JeuDojon;

public class Tests {
	
	public static void main(String[] args) {
		
		Donjon d = new Donjon(15,10);
		
		
		d.placer(4, 7,'X');
		d.placer(13,2,'#');
		d.placer(13,3,'#');
		d.placer(13,4,'#');
		d.placer(13,5,'#');
		d.afficher();
	}
}
