package piece;

import echec.Deplacement;
import plateau.Plateau;

public class Dame extends Piece {

	public Dame(boolean couleur) {
		super(couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if (this.couleur == blanc)
			return "d";
		return "D";
	}

	public boolean estValide(Deplacement d, Plateau p) {
		if ((d.type() == 'x') || (!p.getCase(d.getX1(), d.getY1()).estVide())
				|| (p.getCase(d.getX1(), d.getY1()).estVide()
						&& deMemeCouleur(p.getCase(d.getX1(), d.getY1()).getPiece())))
			return false;
		return true;
	}

}
