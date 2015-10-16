/***
Problem description:
You are given two strings, A and B. Find if there is a substring that appears in both A and B.

Input Format

Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

Output Format

For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

Constraints

All the strings contain only lowercase Latin letters.
1<=T<=10
1<=|A|,|B|<=105
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
        read:
        for(int j = 0; j < t; j++){
            String s1 = in.next();
            String s2 = in.next();
            int[] alphabet = new int[26];
            Arrays.fill(alphabet, 0);
            for(int i = 0; i < s1.length(); i++){
                if(alphabet[(int)s1.charAt(i)-97] == 0)
                    alphabet[(int)s1.charAt(i)-97]++;
            }
            for(int i = 0; i < s2.length(); i++){
                if(alphabet[(int)s2.charAt(i)-97] == 1){
                    System.out.println("YES");
                    continue read;
                }
                   
            }
            System.out.println("NO");
        }
    }
}