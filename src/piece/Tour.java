package piece;

import echec.Deplacement;
import plateau.Plateau;

public class Tour extends Piece {

	public Tour(boolean couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if (this.couleur == blanc)
			return "t";
		return "T";
	}

	@Override
	public boolean estValide(Deplacement d, Plateau p) {
		if ((d.type() == 'h' || d.type() == 'v') && p.getCase(d.getX1(), d.getY1()).estVide()
				&& (!p.getCase(d.getX1(), d.getY1()).estVide()
						&& !deMemeCouleur(p.getCase(d.getX1(), d.getY1()).getPiece())))
			return true;
		return false;
	}
}
