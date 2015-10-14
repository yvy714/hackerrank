/***
Problem description:
You are given N sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

Suppose we have six sticks of the following lengths:
5 4 4 2 2 8
Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following:
3 2 2 6
The above step is repeated until no sticks are left.

Given the length of N sticks, print the number of sticks that are left before each subsequent cut operations.
Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).

Input Format 
The first line contains a single integer N. 
The next line contains N integers: a0, a1,...aN-1 separated by space, where ai represents the length of ith stick.

Output Format 
For each operation, print the number of sticks that are cut, on separate lines.

Constraints 
1 <= N <= 1000 
1 <= ai <= 1000
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
        int[] sticks = new int[t];
        for(int i = 0; i < t; i++){
            sticks[i] = in.nextInt();
        }
        
        int num = t;
        int cutlength = 1000;
        for(int i = 0; i < t; i++){
            if(sticks[i] < cutlength) cutlength = sticks[i];
        }
        
        while(num > 0){
            System.out.println(num);
            int count = 0;
            int smallest = 1000;
            for(int i = 0; i < t; i++){
                if(sticks[i] - cutlength > 0){
                    count++;
                    if(sticks[i] -cutlength < smallest)
                        smallest = sticks[i] - cutlength;
                }
            }
            cutlength = cutlength + smallest;
            num = count;
        }
       
    }
}