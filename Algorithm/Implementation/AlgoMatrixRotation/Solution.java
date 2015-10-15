/***
Problem description:
Problem Statement

You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times and print the resultant matrix. Rotation should be in anti-clockwise direction.

Rotation of a 4x5 matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only (refer sample tests for more clarity).

matrix-rotation

It is guaranteed that the minimum of M and N will be even.

Input 
First line contains three space separated integers, M, N and R, where M is the number of rows, N is number of columns in matrix, and R is the number of times the matrix has to be rotated. 
Then M lines follow, where each line contains N space separated positive integers. These M lines represent the matrix.

Output 
Print the rotated matrix.

Constraints 
2 <= M, N <= 300 
1 <= R <= 109 
min(M, N) % 2 == 0 
1 <= aij <= 108, where i ∈ [1..M] & j in [1..N]
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int rotation = in.nextInt();
        
        int[][] matrix = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        
        int num = Math.min(row,col) / 2;
        
       for(int i = 0; i < row; i++){
           for(int j = 0; j < col; j++){
               
               int x = Math.min(Math.min(row - i - 1, i), Math.min(col - j - 1, j));
               int offset = rotation % ((row + col - 4*x) * 2 - 4);
               int currentx = i; 
               int currenty = j;
               while(offset > 0){
                   int w;
                   if(currentx == x){
                       w = Math.min(col-1-x, offset + currenty);
                       if(w - currenty > 0){
                            offset = offset - (w - currenty);
                            currenty = w;
                            continue;
                       }
                      
                   }
                   if(currentx == row-1-x){
                       w = Math.max(x, currenty - offset);
                       if(currenty - w > 0){
                           offset = offset - (currenty - w);
                           currenty = w;
                           continue;
                       }
                       
                   }
                   if(currenty == x){
                       w = Math.max(x, currentx - offset);
                       if(currentx - w > 0){
                           offset = offset - (currentx - w);
                           currentx = w;
                           continue;
                       }
                       
                   }
                   if(currenty == col-1-x){
                       w = Math.min(row-1-x, offset + currentx);
                       if(w - currentx > 0){
                           offset = offset - (w - currentx);
                           currentx = w;
                           continue;
                       }
                       
                   }
               }
               System.out.print(matrix[currentx][currenty] + " ");
           }
           System.out.println();
       }
        
    }
}