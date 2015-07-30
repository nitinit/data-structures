package com.problems.general;

import java.util.ArrayList;

public class ChessKnightProblem {

	public static final int SIZE = 4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[SIZE];
		placeQeen(0, columns, results);
		for (Integer[] i : results) {

			for (Integer j : i) {
				System.out.print(j + ", ");
			}
			System.out.println();
		}
	}

	public static void placeQeen(int row, Integer[] columns,
			ArrayList<Integer[]> results) {

		if (row == SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < SIZE; col++) {
				if (checkValid(columns, row, col)) {

					columns[row] = col;
					placeQeen(row + 1, columns, results);
				}
			}
		}

	}

	public static boolean checkValid(Integer[] columns, int rowl, int columnl) {
		if (rowl - 1 >= 0
				&& columnl - 2 >= 0
				&& (columns[rowl - 1] == columnl - 2 || columns[rowl - 1] == columnl + 2)) {
			return false;
		}

		if (rowl - 2 >= 0
				&& columnl - 1 >= 0
				&& (columns[rowl - 2] == columnl - 1 || columns[rowl - 2] == columnl + 1)) {
			return false;
		}

		return true;
	}

}
