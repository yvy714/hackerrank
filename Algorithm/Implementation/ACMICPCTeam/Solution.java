/***
Problem description:
You are given a list of N people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.

Note Suppose a, b, and c are three different people, then (a,b) and (b,c) are counted as two different teams.

Input Format

The first line contains two integers, N and M, separated by a single space, where N represents the number of people, and M represents the number of topics. N lines follow.
Each line contains a binary string of length M. If the ith line's jth character is 1, then the ith person knows the jth topic; otherwise, he doesn't know the topic.

Constraints 
2<=N<=500 
1<=M<=500

Output Format

On the first line, print the maximum number of topics a 2-person team can know. 
On the second line, print the number of 2-person teams that can know the maximum number of topics.
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
        int n = in.nextInt();
        int m = in.nextInt();
        String[] knows = new String[n];
        for(int i = 0; i < n; i++){
            knows[i] = in.next();
        }
        
        int max = 0; int num = 1;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int temp = 0;
                for(int l =0; l < m; l++){
                    if(knows[i].charAt(l) == '1' || knows[j].charAt(l) =='1'){
                        temp++;
                    }
                }
                if(temp > max){
                    max = temp;
                    num = 1;
                }else if(temp == max){
                    num++;
                }
            }
        }
        System.out.println(max);
        System.out.println(num);
    }
}