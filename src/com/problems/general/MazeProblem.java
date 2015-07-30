package com.problems.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author Raja Jain
 * 
 */
public class MazeProblem {

	public static int[][] maze = { { 0, 0, 1, 0, 0, 0 }, 
								   { 1, 0, 1, 0, 0, 0 },
								   { 1, 0, 1, 0, 1, 0 }, 
								   { 1, 0, 1, 0, 1, 0 }, 
								   { 1, 0, 1, 0, 1, 0 },
								   { 1, 0, 0, 0, 1, 0 } };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Point, Boolean> cache = new HashMap<Point, Boolean>();
		Map<Point, Boolean> visited = new HashMap<Point, Boolean>();

		List<Point> path = new ArrayList<Point>();
		

		// maze = {{0,1,0},{0,1,1},{0,0,0}};
		boolean success = getPath(5, 5, cache, path, visited);
		System.out.println(path);

	}

	private static boolean getPath(int x, int y, Map<Point, Boolean> cache,
			List<Point> path, Map<Point, Boolean> visited) {

		Point point = new Point(x, y);

		if (cache.containsKey(point)) {
			return cache.get(point);
		}

		if (x == 0 && y == 0) {
			return true;
		}
		
		boolean success = false;
		if (x > 0 && isFree(x - 1, y, visited)) {		
			visited.put(point, true);
			success = getPath(x - 1, y, cache, path, visited);
			visited.remove(point);
		}	
				

		if (!success && y >= 0 && isFree(x, y - 1, visited)) {
			visited.put(point, true);
			success = getPath(x, y - 1, cache, path,visited);
			visited.remove(point);
		}
		
		if (!success && x >= 0 && x < 5 && isFree(x + 1, y, visited)) {		
			visited.put(point, true);
			success = getPath(x + 1, y, cache, path, visited);
			visited.remove(point);
		}
		
		if (!success && y >= 0 && y < 5 && isFree(x, y+1, visited)) {
			visited.put(point, true);
			success = getPath(x, y + 1, cache, path, visited);
			visited.remove(point);
		}	
		
//		
		
		
		if (success) {
			path.add(point);
		}
		cache.put(point, success);
		return success;
	}

	private static boolean isFree(int x, int y, Map<Point, Boolean> visited) {

		if (maze[x][y] == 1 || visited.containsKey(new Point(x, y))) {
			return false;
		}
		return true;
	}

}
