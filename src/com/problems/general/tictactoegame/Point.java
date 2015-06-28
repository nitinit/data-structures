package com.problems.general.tictactoegame;

/**
 * Created by raja on 28/06/15.
 */
public class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
