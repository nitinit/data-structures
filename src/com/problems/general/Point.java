package com.problems.general;

public class Point {
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;

		if (p.x == x && p.y == y) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return x + y;
	}

	@Override
	public String toString() {
		return "( " + x + "," + y + " )";
	}
}
