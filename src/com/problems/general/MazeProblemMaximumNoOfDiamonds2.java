package com.problems.general;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raja on 09/08/15.
 */
public class MazeProblemMaximumNoOfDiamonds2 {


    //    public static int max=0;
    public static int rows = 5;
    public static int columns = 5;
    public static int[][] maze = {
            {1,  0,  1,  1,  1, 0},
            {0, -1, 1, -1, -1, 1},
            {1, -1, 1, -1, -1, 1},
            {0, -1,  0, 1, -1, 1},
            {-1, -1,-1, 1, -1, 0},
            {0,  1,  0,  0,  0, 0}};

    /**
     * @param args
     */
    public static void main(String[] args) {

        Map<Point, Integer[]> cache = new HashMap<Point, Integer[]>();

        List<Point> path = new ArrayList<Point>();

        long start = System.currentTimeMillis();
        int[] maxNoOfDiamonds = getPath(0, 0, cache, path);
        System.out.println("Time taken in milli seconds : " + (System.currentTimeMillis() - start));
        System.out.println(maxNoOfDiamonds[0] + " , " + maxNoOfDiamonds[1]);

    }

    private static int[] getPath(int x, int y, Map<Point, Integer[]> cache, List<Point> path) {

        Point point = new Point(x, y);
        if (cache.containsKey(point)) {
            return new int[]{cache.get(point)[0], cache.get(point)[1]};
        }
        int[] right = new int[2];
        if (!isBlocked(x, y + 1, point)) {
            right[0] = maze[x][y] + getPath(x, y + 1, cache, path)[0];
            right[1] = maze[x][y] + getPath(x, y + 1, cache, path)[1];
        }
        int[] down = new int[2];
        if (!isBlocked(x + 1, y, point)) {
            down[0] = maze[x][y] + getPath(x + 1, y, cache, path)[0];
            down[1] = maze[x][y] + getPath(x + 1, y, cache, path)[1];
        }
        int[] noOfDiamonds = new int[2];
        noOfDiamonds[0] = Math.max(down[0], right[0]);
        noOfDiamonds[1] = down[0] > right[0] ? Math.max(right[0], down[1]) : Math.max(down[0], right[1]);
        if (isBlocked(x, y + 1, point) && isBlocked(x + 1, y, point)) {
            noOfDiamonds[0] = noOfDiamonds[0] + maze[x][y];
            noOfDiamonds[1] = noOfDiamonds[1] + maze[x][y];
        }
        cache.put(point, new Integer[]{noOfDiamonds[0], noOfDiamonds[1]});
        return noOfDiamonds;

    }

    private static boolean isBlocked(int x, int y, Point point) {

        if (x > rows || x < 0 || y > columns || y < 0 || maze[x][y] == -1) {
            return true;
        }
        return false;
    }
}
