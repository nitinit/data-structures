package com.problems.general;

/**
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 *
 * Created by raja on 21/07/15.
 */
public class PrintMatrixInSpiralForm {

    public static void main(String[] args){

    }

    public static void print(int[][] m, int row, int col, int currentRow, int currentCol){
        if (currentRow<row && currentCol<col){
            System.out.println(m[currentRow][currentCol] + " ");
            print(m, row, col, currentRow, currentCol + 1);
        }else if (currentCol==col-1 && currentRow<row){
            System.out.println(m[currentRow][currentCol] + " ");
            print(m,row,col,currentRow+1,currentCol);
        }else if (currentRow==row-1 && currentCol<col){
            System.out.println(m[currentRow][currentCol] + " ");
            print(m,row,col,currentRow,currentCol-1);
        }else if (currentCol>=0 && currentRow<row && currentRow>=0){
            System.out.println(m[currentRow][currentCol] + " ");
            print(m,row,col,currentRow-1,currentCol);
        }
    }

}
