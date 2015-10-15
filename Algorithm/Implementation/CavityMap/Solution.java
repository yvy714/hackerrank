/***
Problem description:
You are given a square map of size n×n. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, n, denoting the size of the map. Each of the following n lines contains n positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints 
1<=n<=100
Output Format

Output n lines, denoting the resulting map. Each cavity should be replaced with character X.
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
        int t = in.nextInt();
        StringBuffer[] map = new StringBuffer[t];
        for(int i = 0; i < t; i++){
            map[i] = new StringBuffer(in.next());
        }
        for(int i =1; i < t-1; i++){
            for(int j = 1; j < t-1; j++){
                if((int)map[i].charAt(j) - (int)map[i].charAt(j-1) <= 0) continue;
                if((int)map[i].charAt(j) - (int)map[i].charAt(j+1) <= 0) continue;
                if((int)map[i].charAt(j) - (int)map[i-1].charAt(j) <= 0) continue;
                if((int)map[i].charAt(j) - (int)map[i+1].charAt(j) <= 0) continue;
                map[i].setCharAt(j, 'X');
            }
        }
        for(int i = 0; i < t; i++){
            System.out.println(map[i]);
        }
        
    }
}