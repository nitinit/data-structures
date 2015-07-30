package com.problems.general;

import java.util.ArrayList;

public class NQueensProblem {

	public static final int SIZE = 8;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[SIZE];
		placeQeen(0, columns, results);
		for(Integer[] i : results){
			
			for(Integer j : i){
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
					placeQeen(row +1, columns, results);
				}
			}
		}

	}

	public static boolean checkValid(Integer[] columns, int rowl, int columnl) {
		for (int row2 = 0; row2 < rowl; row2++) {
			int column2 = columns[row2];
			/*
			 * Check if (row2, column2) invalidates (rowl, columnl) as a queen
			 * spot.
			 */

			/* Check if rows have a queen in the same column */
			if (columnl == column2) {
				return false;
			}

			/*
			 * Check diagonals: if the distance between the columns  * equals
			 * the distance between the rows, then they're in the  * same
			 * diagonal.
			 */
			int columnDistance = Math.abs(column2 - columnl);

			/* rowl > row2, so no need for abs */
			int rowDistance = rowl - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

}
