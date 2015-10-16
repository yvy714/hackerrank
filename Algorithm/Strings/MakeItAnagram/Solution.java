/***
Problem description:
Alice recently started learning about cryptography and found that anagrams are very useful. Two strings are anagrams of each other if they have same character set and same length. For example strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.

Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. She need your help in finding out this number.

Given two strings (they can be of same or different length) help her in finding out the minimum number of character deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.

Input Format 
Two lines each containing a string.

Constraints 
1 <= Length of A,B <= 10000 
A and B will only consist of lowercase latin letter.

Output Format 
A single integer which is the number of character deletions.
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
        String s1 = in.next();
        String s2 = in.next();
        int[] alphabetfors1 = new int[26];
        int[] alphabetfors2 = new int[26];
        Arrays.fill(alphabetfors1, 0);
        Arrays.fill(alphabetfors2, 0);
        
        for(int i = 0; i < s1.length(); i++){
            alphabetfors1[(int)s1.charAt(i)-97]++;
        }
        for(int i = 0; i < s2.length(); i++){
            alphabetfors2[(int)s2.charAt(i)-97]++;
        }
        int deletion = 0;
        for(int i = 0; i < 26; i++){
            deletion += Math.abs(alphabetfors1[i] - alphabetfors2[i]);
        }
        System.out.println(deletion);
    }
}