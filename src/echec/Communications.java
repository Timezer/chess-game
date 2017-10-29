package echec;

import java.util.Scanner;

import piece.Piece;

public class Communications {

	Scanner sc;

	public Communications() {
		sc = new Scanner(System.in);
	}

	public Deplacement demanderDeplacement(boolean joueur) {
		int x0, y0, x1, y1;
		if (joueur == Piece.blanc)
			System.out.println("Cher joueuer blanc");
		else
			System.out.println("Cher joueur noir");
		System.out.println("Piece de depart:");
		System.out.println("Colonne:");
		x0 = sc.nextInt() - 1;
		System.out.println("Ligne: ");
		y0 = sc.nextInt() - 1;
		System.out.println("Case d'arrive:");
		System.out.println("Colonne:");
		x1 = sc.nextInt() - 1;
		System.out.println("Ligne: ");
		y1 = sc.nextInt() - 1;
		return new Deplacement(x0, y0, x1, y1);
		
	}

}
