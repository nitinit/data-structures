package com.problems.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightTourProblem {

	public static int SIZE = 7;
	public static int[][] maze = new int[SIZE][SIZE];
	 public static int m = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Point> path = new ArrayList<Point>();
		int moves = 1;
		maze[0][0] = 1;
		// maze = {{0,1,0},{0,1,1},{0,0,0}};
		boolean success = getPath(0, 0, moves, path, maze);
		System.out.println(path);
		 for (int i = 0; i < SIZE; i++)
		    {
		        for (int j = 0; j < SIZE; j++)
		            System.out.print(" "+maze[i][j]);
		        System.out.println();
		    }

	}

	private static boolean getPath(int x, int y, int move, List<Point> path,
			int[][] maze) {

		Point point = new Point(x, y);

		// if (cache.containsKey(point)) {
		// return cache.get(point);
		// }

		if (move == SIZE * SIZE) {
			return true;
		}

		if (path.size() == SIZE * SIZE) {
			return true;
		}

		boolean success = false;
		m++;
		if (!success && x + 2 < SIZE && y + 1 < SIZE && isFree(x + 2, y + 1)) {
			maze[x + 2][y + 1] = move;
			success = getPath(x + 2, y + 1, move + 1, path, maze);
			if(!success){
				maze[x + 2][y + 1] = 0;
			}
		}

		if (!success && x + 1 < SIZE && y + 2 < SIZE && isFree(x + 1, y + 2)) {
			maze[x + 1][y + 2] = move;
			success = getPath(x + 1, y + 2, move + 1, path, maze);
			if(!success){
			maze[x + 1][y + 2] = 0;
			}
		}
		if (!success && x - 1 >= 0 && y + 2 < SIZE && isFree(x - 1, y + 2)) {
			maze[x - 1][y + 2] = move;
			success = getPath(x - 1, y + 2, move + 1, path, maze);
			if(!success){
			maze[x - 1][y + 2] = 0;
			}
		}
		if (!success && x - 2 >= 0 && y + 1 < SIZE && isFree(x - 2, y + 1)) {
			maze[x - 2][y + 1] = move;
			success = getPath(x - 2, y + 1, move + 1, path, maze);
			if(!success){
			maze[x - 2][y + 1] = 0;
			}
		}
		if (!success && x - 2 >= 0 && y - 1 >= 0 && isFree(x - 2, y - 1)) {
			maze[x - 2][y - 1] = move;
			success = getPath(x - 2, y - 1, move + 1, path, maze);
			if(!success){
			maze[x - 2][y - 1] = 0;
			}
		}
		if (!success && x - 1 >= 0 && y - 2 >= 0 && isFree(x - 1, y - 2)) {
			maze[x - 1][y - 2] = move;
			success = getPath(x - 1, y - 2, move + 1, path, maze);
			if(!success){
			maze[x - 1][y - 2] = 0;
			}
		}

		if (!success && x + 1 < SIZE && y - 2 >= 0 && isFree(x + 1, y - 2)) {
			maze[x + 1][y - 2] = move;
			success = getPath(x + 1, y - 2, move + 1, path, maze);
			if(!success){
			maze[x + 1][y - 2] = 0;
			}
		}

		if (!success && x + 2 < SIZE && y - 1 >= 0 && isFree(x + 2, y - 1)) {
			maze[x + 2][y - 1] = move;
			success = getPath(x + 2, y - 1, move + 1, path, maze);
			if(!success){
			maze[x + 2][y - 1] = 0;
			}
		}

		if (success) {
			path.add(point);
		}
		return success;
	}

	private static boolean isFree(int x, int y) {

		if (maze[x][y] == 0) {
			return true;
		}
		return false;
	}

}
