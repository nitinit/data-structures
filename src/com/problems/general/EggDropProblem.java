package com.problems.general;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 *
 * Created by raja on 19/06/15.
 */
public class EggDropProblem {

    public static void main(String[] args){
        System.out.println(find(2,36));
    }

    public static int find(int eggs, int floors){

        if (floors == 1 || floors == 0) {
            return floors;
        }

        if(eggs ==1){
            return floors;
        }

        int min = Integer.MAX_VALUE, floorNumber, res;

        // Consider all droppings from 1st floor to kth floor and
        // return the minimum of these values plus 1.
        for (floorNumber = 1; floorNumber <= floors; floorNumber++)
        {
            res = Math.max(find(eggs - 1, floorNumber - 1), find(eggs, floors - floorNumber));
            if (res < min){
                min = res;
            }
        }

        return min + 1;
    }

    public static int eggDropDPSolution(int eggs, int floors){

        return 0;
    }
}
