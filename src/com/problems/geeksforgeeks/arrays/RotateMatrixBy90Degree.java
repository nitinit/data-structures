package com.problems.geeksforgeeks.arrays;

/**
 * Created by raja on 27/06/15.
 */
public class RotateMatrixBy90Degree {


    public static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first; // savetop
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String [] args){
        int matrix[][] = new int[4][4];
        int n=1;
        for (int i = 0 ; i<4;i++){
            for (int j = 0 ; j<4;j++){
                matrix[i][j]= n++;
            }
        }

        for (int i = 0 ; i<4;i++){
            for (int j = 0 ; j<4;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        rotate(matrix,4);
        System.out.println();System.out.println();

        for (int i = 0 ; i<4;i++){
            for (int j = 0 ; j<4;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
