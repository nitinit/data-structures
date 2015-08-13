package com.problems.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Raja Jain
 */
public class MazeProblemMaximumNoOfDiamonds {

    //    public static int max=0;
    public static int rows = 5;
    public static int columns = 5;
    public static int[][] maze = {
            {1, 0,  1,  1,  1, 0},
            {0, -1, -1, 1, -1, 1},
            {0, -1, -1, 1, -1, 1},
            {0, -1,  0, 1, -1, 1},
            {0, -1, -1, 1, 1,  0},
            {1,  1,  1, 1, 1,  -1}};

    /**
     * @param args
     */
    public static void main(String[] args) {

        Map<Point, Integer> cache = new HashMap<Point, Integer>();

        List<Point> path = new ArrayList<Point>();

        long start = System.currentTimeMillis();
        int maxNoOfDiamonds = getPath(0, 0, cache, path);
        System.out.println("End time in mili seconds : " + (System.currentTimeMillis() - start));
        System.out.println(maxNoOfDiamonds);
        for(Point p : path){
            System.out.print(p + " , ");
        }
    }

    private static int getPath(int x, int y, Map<Point, Integer> cache, List<Point> path) {

        Point point = new Point(x, y);
        if (cache.containsKey(point)) {
            return cache.get(point);
        }
        int right = 0;
        if (!isBlocked(x, y + 1, point)) {
            right = maze[x][y] + getPath(x, y + 1, cache, path);
        }
        int down = 0;
        if (!isBlocked(x + 1, y, point)) {
            down = maze[x][y] + getPath(x + 1, y, cache, path);
        }
        int noOfDiamonds = Math.max(down, right);
        if (isBlocked(x, y + 1, point) && isBlocked(x + 1, y, point)) {
            noOfDiamonds = noOfDiamonds + maze[x][y];
        }
        path.add(point);
//        if(down>right){
//            path.add(new Point(x,y+1));
//        }else{
//            path.add(new Point(x+1,y));
//        }
        cache.put(point, noOfDiamonds);
        return noOfDiamonds;

    }

//    private static void getPath2(int x, int y, Map<Point, Integer> cache,
//                               List<Point> path, Map<Point, Boolean> visited, int sum) {
//
//        Point point = new Point(x, y);
////        if (isBlocked(x, y, visited, point)) {
////            return 0;
////        }
//        if (cache.containsKey(point)) {
//            max = max > cache.get(point) ? max : cache.get(point);
//            return;
//        }
//        if (!isBlocked(x, y + 1, visited, point)) {
//            visited.put(point, true);
//            max = max > (maze[x][y]+sum) ? max : maze[x][y]+sum;
//            getPath2(x, y + 1, cache, path, visited, max);
//            visited.remove(point);
//        }
//        if (!isBlocked(x + 1, y, visited, point)) {
//            visited.put(point, true);
//            max = max > (maze[x][y]+sum) ? max : maze[x][y]+sum;
//            getPath2(x + 1, y, cache, path, visited,max);
//            visited.remove(point);
//        }
//        cache.put(point, max);
//    }

    private static boolean isBlocked(int x, int y, Point point) {

        if (x > rows || x < 0 || y > columns || y < 0 || maze[x][y] == -1) {
            return true;
        }
        return false;
    }

}
