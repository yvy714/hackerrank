/***
Problem Description:
The professor is conducting a course on Discrete Mathematics to a class of N students. He is angry at the lack of their discipline, and he decides to cancel the class if there are fewer than K students present after the class starts.Given the arrival time of each student, your task is to find out if the class gets cancelled or not.

Input Format

The first line of the input contains T, the number of test cases. Each test case contains two lines. 
The first line of each test case contains two space-separated integers, N and K. 
The next line contains N space-separated integers, a1,a2,…,aN, representing the arrival time of each student.

If the arrival time of a given student is a non-positive integer (ai<=0), then the student enters before the class starts. If the arrival time of a given student is a positive integer (ai>0), the student enters after the class has started.

Output Format

For each testcase, print "YES" (without quotes) if the class gets cancelled and "NO" (without quotes) otherwise.

Constraints

1<=T<=10
1<=N<=1000
1<=K<=N
−100<=ai<=100,where i in [1,N]
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
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int count = 0;
            for(int j = 0; j < n; j++){
                int time = in.nextInt();
                if(time <= 0) count++;
            }
            if(count >= k)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}