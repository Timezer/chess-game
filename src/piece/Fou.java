package piece;

import echec.Deplacement;
import plateau.Plateau;

public class Fou extends Piece {

	public Fou(boolean couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		if (this.couleur == blanc)
			return "f";
		return "F";
	}
	
	@Override
	public boolean estValide(Deplacement d, Plateau p){
		if (d.type() == 'd'	&& p.getCase(d.getX1(), d.getY1()).estVide()
				&& (!p.getCase(d.getX1(), d.getY1()).estVide()
						&& !deMemeCouleur(p.getCase(d.getX1(), d.getY1()).getPiece())))
			return true;		
		return false;
	}

}
