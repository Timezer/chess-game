package echec;

import java.lang.Math;

public class Deplacement {
	private int x0;
	private int y0;
	private int x1;
	private int y1;

	public Deplacement(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	public int getX0() {
		return x0;
	}

	public int getY0() {
		return y0;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}
	

	public char type() {
		if (Math.abs(x1 - x0) == Math.abs(y0 - y1))
			return 'd';
		if (this.distance() == 3)
			return 'c';
		if (x0 == x1)
			return 'v';
		if (y0 == y1)
			return 'h';
		else
			return 'x';
	}

	public int distance() {
		return Math.abs(x1 - x0) + Math.abs(y0 - y1);
	}
}
