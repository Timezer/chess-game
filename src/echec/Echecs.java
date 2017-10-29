package echec;

import plateau.*;
import piece.*;

public class Echecs {
	private Plateau plateau;
	private Communications com;

	public Echecs() {
		plateau = new Plateau();
		com = new Communications();
	}

	public String afficher() {
		return plateau.afficher();
	}

	public Case getCase(int x, int y) {
		return plateau.getCase(x, y);
	}

	private boolean jouerTour(Deplacement d, boolean joueur) {
		Piece pieDep = plateau.getCase(d.getX0(), d.getY0()).getPiece();
		Piece pieArr = getCase(d.getX1(), d.getY1()).getPiece();
		if (plateau.peutManger(d, joueur)) {
			plateau.getCase(d.getX1(), d.getY1()).enleverPiece();
			plateau.getCase(d.getX1(), d.getY1()).remplirCase(pieDep);
			plateau.getCase(d.getX0(), d.getY0()).enleverPiece();
			if (joueur == Piece.blanc)
				System.out.println("Le joueur blanc mange une pièce noire");
			else
				System.out.println("Le joueur noir mange une pièce blanche");
			if (pieArr instanceof Roi) {
				if (joueur == Piece.blanc)
					System.out.println("Le joueur blanc gagne");
				else{
					System.out.println(d.toString());
					System.out.println("Le joueur noir gagne");
				}
				return false;
			}
		} else if (plateau.peutJouer(d, joueur)) {
			plateau.getCase(d.getX1(), d.getY1()).remplirCase(pieDep);
			plateau.getCase(d.getX0(), d.getY0()).enleverPiece();
		} else
			System.out.println("Le coup n'est pas correct");
		System.out.println(plateau.afficher());
		return true;
	}

	private boolean jouerTour(boolean joueur) {
		Deplacement d = com.demanderDeplacement(joueur);
		return jouerTour(d, joueur);
	}

	private static void jouerPartie() {
		Echecs e = new Echecs();
		boolean joueurA, joueurB, joueur;
		joueurA = Piece.blanc;
		joueurB = Piece.noir;
		joueur = joueurA;
		System.out.println(e.afficher());
		while (e.jouerTour(joueur)) {
			if (joueur == joueurA)
				joueur = joueurB;
			else
				joueur = joueurA;
		}

	}

	public static void main(String[] args) {
		Echecs.jouerPartie();
		/**
		 * Echecs e = new Echecs(); System.out.println(e.afficher());
		 *
		 * Piece a,b; a = new Pion(Piece.blanc); b = new Pion(Piece.noir);
		 * e.getCase(1, 1).remplirCase(a); e.getCase(1, 2).remplirCase(a);
		 * Deplacement d = new Deplacement(1,1,1,2); e.jouerTour(d,
		 * Piece.blanc);
		 */

	}

}
