package piece;

import echec.Deplacement;
import plateau.Plateau;

public class Roi extends Piece {

	public Roi(boolean couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if (this.couleur == blanc)
			return "r";
		return "R";
	}
	@Override
	public boolean estValide(Deplacement d, Plateau p){
		if (d.distance() == 1 && p.getCase(d.getX1(), d.getY1()).estVide()
				&& (!p.getCase(d.getX1(), d.getY1()).estVide()
						&& !deMemeCouleur(p.getCase(d.getX1(), d.getY1()).getPiece())))
			return true;		
		return false;
	}
}
