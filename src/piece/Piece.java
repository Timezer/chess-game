package piece;

import echec.Deplacement;
import plateau.Plateau;

public class Piece {

	public static final boolean blanc = true;
	public static final boolean noir = false;
	protected boolean couleur;

	public Piece(boolean couleur) {
		this.couleur = couleur;
	}
	
	public boolean getCouleur(){
		return couleur;
	}

	@Override
	public String toString() {
		if (this.couleur == blanc)
			return "p";
		return "P";
	}

	public boolean deMemeCouleur(Piece p) {
		return p.couleur == couleur;
	}

	public boolean estValide(Deplacement d, Plateau p) {
		if ((d.distance() == 1) && (d.type() == 'h')
				&& (p.getCase(d.getX1(), d.getY1()).estVide())
				&& (!p.getCase(d.getX1(), d.getY1()).estVide()
						&& !deMemeCouleur(p.getCase(d.getX1(), d.getY1()).getPiece())))
			return true;
		return false;
	}

}
