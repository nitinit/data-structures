package com.problems.general;

public class KnightMove {
	 static int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
	 static int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
	
	 public static int m = 0;
	 public static void main(String args[]) {
		solveKT();
	}

	public static boolean isFree(int board[][], int x, int y, int size) {
		if (x >= 0 && y >= 0 && x < size && y < size && board[x][y] == -1) {
			return true;
		}
		return false;
	}
	
	public static void solveKT() {
		int size = 8;
		int board[][] = new int[size][size];		
		for (int x = 0; x < size; x++)
	        for (int y = 0; y < size; y++)
	        	board[x][y] = -1;
		board[0][0] = 1;
		solveKTUntil(board, size, 0, 0, 1);	
		printSolution(board, size);
		System.out.println("m = " + m);
	}
	
	public static boolean solveKTUntil(int[][] board, int size, int x, int y, int iMov) {
		int xNext;
		int yNext;
		if (iMov == size * size) {
			return true;
		}
		for (int i = 0; i < size; i++) {
			xNext = x + xMove[i];
			yNext = y + yMove[i];
			if(isFree(board, xNext, yNext , size)) {
				m++;
				board[xNext][yNext] = iMov;
				if(solveKTUntil(board, size, xNext, yNext, iMov+1)) {
					return true;
				} else {
					board[xNext][yNext] = -1;
				}				
			}
		}
		return false;		
	}
	
	public static void  printSolution(int board[][], int size)
	{
	    for (int i = 0; i < size; i++)
	    {
	        for (int j = 0; j < size; j++)
	            System.out.print(" "+board[i][j]);
	        System.out.println();
	    }
	}
}
