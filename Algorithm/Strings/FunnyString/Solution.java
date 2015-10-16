/***
Problem description:
Suppose you have a string S which has length N and is indexed from 0 to N−1. String R is the reverse of the string S. The string S is funny if the condition |Si−Si−1|=|Ri−Ri−1| is true for every i from 1 to N−1.

(Note: Given a string str, stri denotes the ascii value of the ith character (0-indexed) of str. |x| denotes the absolute value of an integer x)

Input Format

First line of the input will contain an integer T. T testcases follow. Each of the next T lines contains one string S.

Constraints

1<=T<=10
2<=length of S<=10000
Output Format

For each string, print Funny or Not Funny in separate lines.
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String isFunny(String input){
        int l = input.length();
        boolean funny = true;
        for(int i = 0; i < l-1; i++){
            int x1 = Math.abs((int)input.charAt(i) - (int)input.charAt(i+1));
            int x2 = Math.abs((int)input.charAt(l-1-i) - (int)input.charAt(l-2-i));
            if(x1 != x2){
                funny = false;
                break;
            }
        }
        if(funny)
            return "Funny";
        else
            return "Not Funny";
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String input = in.next();
            System.out.println(isFunny(input));
        }
    }
}