package plateau;

import piece.Piece;

public class Case {
	
	public static final boolean blanc = true;
	public static final boolean noir = false;
	protected boolean couleur;
	private Piece piece;

	public Case(boolean couleur) {
		this.couleur = couleur;
		this.piece = null;
	}
	
	protected void setCouleur(boolean couleur){
		this.couleur = couleur;
	}
	
	public Piece getPiece(){
		return this.piece;
	}
	
	public boolean estVide(){
		if (this.piece == null)
			return true;
		return false;
	}
	
	public void remplirCase(Piece p){
		this.piece=p;
	}
	
	public void enleverPiece(){
		this.piece = null;
	}
	
	@Override
	public String toString(){
		if(estVide()){
			if(this.couleur == blanc)
				return ".";
			else
				return "*";
		}
		else
			return this.piece.toString();
	}
}
