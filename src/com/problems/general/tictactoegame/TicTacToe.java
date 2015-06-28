package com.problems.general.tictactoegame;

import java.util.Random;

/**
 * Created by raja on 28/06/15.
 */
public class TicTacToe {

    public static void main(String[] args) {
        Board b = new Board();
        Random rand = new Random();

        b.displayBoard();

        System.out.println("Select turn:\n\n1. Computer 2. User: ");
        int choice = b.scan.nextInt();
        if(choice == 1){
            Point p = new Point(rand.nextInt(3), rand.nextInt(3));
            b.placeAMove(p, 1);
            b.displayBoard();
        }

        while (!b.isGameOver()) {
            System.out.println("Your move: ");
            Point userMove = new Point(b.scan.nextInt(), b.scan.nextInt());

            b.placeAMove(userMove, 2); //2 for O and O is the user
            b.displayBoard();
            if (b.isGameOver()) break;

            b.miniMax(0, 1);

            b.placeAMove(b.computersMove, 1);
            b.displayBoard();
        }
        if (b.hasXWon())
            System.out.println("Unfortunately, you lost!");
        else if (b.hasOWon())
            System.out.println("You win!"); //Can't happen
        else
            System.out.println("It's a draw!");
    }
}
