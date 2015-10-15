/***
Problem description:
Julius Caesar protected his confidential information from his enemies by encrypting it. Caesar rotated every letter in the string by a fixed number K. This made the string unreadable by the enemy. You are given a string S and the number K. Encrypt the string and print the encrypted string.

For example: 
If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters are encrypted while symbols like - are untouched. 
'm' becomes 'o' when letters are rotated twice, 
'i' becomes 'k', 
'-' remains the same because only letters are encoded, 
'z' becomes 'b' when rotated twice.

Input Format

Input consists of an integer N equal to the length of the string, followed by the string S and an integer K.

Constraints 
1<=N<=100 
0<=K<=100 
S is a valid ASCII string and doesn't contain any spaces.

Output Format

For each test case, print the encoded string
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String encrypt(String input, int l, int k){
        StringBuffer target = new StringBuffer(input);
        for(int i = 0; i < l; i++){
            int asc = (int)target.charAt(i);
            if(asc >= 65 && asc <= 90){
                asc+=k;
                asc = (asc - 65) % 26 + 65;
            }
            if(asc >= 97 && asc <= 122){
                asc+=k;
                asc = (asc - 97) % 26 + 97;
            }
            target.setCharAt(i, (char)asc);
        }
        return target.toString();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String target = in.next();
        int k = in.nextInt();
        System.out.println(encrypt(target, t, k));
        
    }
}