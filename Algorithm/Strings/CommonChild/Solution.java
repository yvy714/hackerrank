/***
Problem description:
Given two strings a and b of equal length, what's the longest string (S) that can be constructed such that it is a child of both? 

A string x is said to be a child of a string y if x can be formed by deleting 0 or more characters from y. 

For example, ‘‘abcd" and ‘‘abdc" has two children with maximum length 3, ‘‘abc" and ‘‘abd". Note that we will not consider ‘‘abcd" as a common child because ′c′ doesn't occur before ′d′ in the second string.

Input format

Two strings, a and b, with a newline separating them.

Constraints

All characters are upper cased and lie between ASCII values 65-90. The maximum length of the strings is 5000.

Output format

Length of string S.


Key Point:

commonchild([x | xs], [x | ys]) = commonchild(xs, ys) + 1;
commonchild([x | xs], [y | ys]) = max(commonchild(xs, [y|ys]), commonchild([x|xs], ys));

use two dimensioinal array to represent substrings
int[length][length]
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
        String x = in.next();
        String y = in.next();
        
        // using suffix array
        int[][] sarray = new int[x.length()+1][y.length()+1];
        for(int i = 0; i < x.length()+1; i++){
            sarray[0][i] = sarray[i][0] = 0;
        }
        
        for(int i = 0; i < x.length(); i++){
            for(int j = 0; j < x.length(); j++){
                if(x.charAt(i) == y.charAt(j))
                    sarray[i+1][j+1] = sarray[i][j] + 1;
                else
                    sarray[i+1][j+1] = Math.max(sarray[i][j+1], sarray[i+1][j]);
            }
        }
        System.out.println(sarray[x.length()][x.length()]);
    }
    
}
