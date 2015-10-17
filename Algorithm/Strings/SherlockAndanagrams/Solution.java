/***
Problem description:
Given a string S, find the number of unordered anagramic pairs of substrings.

Input Format

First line contains T, the number of testcases. Each testcase consists of string S in one line.

Constraints 
1<=T<=10 
2<=length(S)<=100 
String S contains only the lowercase letters of the English alphabet.

Output Format

For each testcase, print the required answer in one line.
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static boolean pandgram (String s1, String s2){
        int[] alphabets1 = new int[26];
        int[] alphabets2 = new int[26];
        Arrays.fill(alphabets1, 0);
        Arrays.fill(alphabets2, 0);
        for(int i = 0; i < s1.length(); i++){
            alphabets1[(int)s1.charAt(i)-97]++;
            alphabets2[(int)s2.charAt(i)-97]++;
        }
        for(int i = 0; i < 26; i++){
            if(alphabets1[i] != alphabets2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String input = in.next();
            int num = 0;
            /** for each length of pandgram**/
            for(int l = 1; l < input.length(); l++){
                for(int m = 0; m < input.length()-l; m++){
                    for(int n = m+1; n < input.length()-l+1; n++){
                        if(pandgram(input.substring(m, m+l), input.substring(n, n+l))){
                            num++;
                        }
                    }
                }
            }
            System.out.println(num);
            
        }
    }
}