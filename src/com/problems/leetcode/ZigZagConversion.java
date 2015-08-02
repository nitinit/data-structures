package com.problems.leetcode;

import com.sun.deploy.util.StringUtils;

/**
 * Created by raja on 01/08/15.
 */
public class ZigZagConversion {

    public static void main(String[] args) {
    System.out.println(convert("ABC", 2));
    }

    public static String convert(String s, int numRows) {
        if(s.isEmpty() || numRows==1){
            return s;
        }

        String[][] table = new String[numRows][s.length()];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                table[i][j]="";
            }
        }
        int row = 0;
        int col=0;
        boolean moveDown = true;
        for(int i = 0;i<s.length();i++){
                if(moveDown){
                    table[row][col] = s.charAt(i) + "";
                    row++;
                }else{
                    col++;
                    row--;
                    table[row][col] = s.charAt(i) + "";

                }
//            int rowTemp = row;
            if(row >=numRows){
                moveDown = false;
                row--;
            }
            if(row <=0){
                moveDown = true;
                row++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                if(!"".equals(table[i][j])){
                    sb.append(table[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
