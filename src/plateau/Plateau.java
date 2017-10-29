package plateau;

import echec.*;
import piece.*;

public class Plateau {

	private int largeur;
	private int hauteur;
	private Case[][] cases;

	public Plateau(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		cases = new Case[largeur][hauteur];
		for (int i = 0; i < largeur; i++)
			for (int j = 0; j < hauteur; j++) {
				if ((i == 0 && j == 0) || ((i + j) % 2 == 0))
					cases[i][j] = new Case(Case.noir);
				else
					cases[i][j] = new Case(Case.blanc);
			}
	}

	public Plateau() {
		this(8, 8);
		initEchiquier();
	}

	public Case getCase(int x, int y) {
		return cases[x][y];
	}

	public String afficher() {
		String s = new String();
		char c = 'a';
		for (int j = hauteur - 1; j >= 0; j--) {
			String tmp = String.format("%3d", j + 1) + " ";
			for (int i = 0; i < largeur; i++)
				tmp += cases[i][j].toString() + "  ";
			tmp += "\n \n";
			s += tmp;
		}
		s += "  ";
		for (int i = 1; i <= largeur; i++)
			s += String.format("%3c", (c++));
		return s;
	}

	public boolean horsLimite(int i, int j) {
		if (i >= 0 && j >= 0 && i < largeur && j < hauteur)
			return false;
		return true;
	}

	public boolean horsLimite(Deplacement d) {
		return horsLimite(d.getX1(), d.getY1());
	}

	public boolean peutJouer(Deplacement d, boolean joueur) {
		if (horsLimite(d))
			return false;
		Piece pieDep = getCase(d.getX0(), d.getY0()).getPiece();
		if (pieDep.getCouleur() == joueur)
			return true;
		return false;
	}

	public boolean peutManger(Deplacement d, boolean joueur) {
		if (horsLimite(d))
			return false;
		Piece pieDep = getCase(d.getX0(), d.getY0()).getPiece();
		Piece pieArr = getCase(d.getX1(), d.getY1()).getPiece();
		if (pieDep != null && pieArr != null && !pieDep.deMemeCouleur(pieArr) && peutJouer(d, joueur))
			return true;
		return false;
	}

	// fonctionne si et seulement si l'échiquer est de taille 8 x 8
	private void initEchiquier() {
		for (int i = 0; i < 8; i++) {
			cases[i][1].remplirCase(new Pion(Piece.blanc));
			cases[i][6].remplirCase(new Pion(Piece.noir));
		}
		initPieces();
	}

	private void initPieces() {
		//Pieces Blanches
		cases[0][0].remplirCase(new Tour(Piece.blanc));
		cases[7][0].remplirCase(new Tour(Piece.blanc));
		cases[1][0].remplirCase(new Cavalier(Piece.blanc));
		cases[6][0].remplirCase(new Cavalier(Piece.blanc));
		cases[2][0].remplirCase(new Fou(Piece.blanc));
		cases[5][0].remplirCase(new Fou(Piece.blanc));
		cases[3][0].remplirCase(new Dame(Piece.blanc));
		cases[4][0].remplirCase(new Roi(Piece.blanc));
		//Pieces Noires
		cases[0][7].remplirCase(new Tour(Piece.noir));
		cases[7][7].remplirCase(new Tour(Piece.noir));
		cases[1][7].remplirCase(new Cavalier(Piece.noir));
		cases[6][7].remplirCase(new Cavalier(Piece.noir));
		cases[2][7].remplirCase(new Fou(Piece.noir));
		cases[5][7].remplirCase(new Fou(Piece.noir));
		cases[3][7].remplirCase(new Dame(Piece.noir));
		cases[4][7].remplirCase(new Roi(Piece.noir));
	}

}
