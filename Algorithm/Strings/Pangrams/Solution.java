/***
Problem description:
Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Input Format Input consists of a line containing s.

Constraints 
Length of s can be at most 103 (1<=|s|<=10^3) and it may contain spaces, lower case and upper case letters. Lower case and upper case instances of a letter are considered the same.

Output Format Output a line containing pangram if s is a pangram, otherwise output not pangram.
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
        String input = in.nextLine().replaceAll("\\s+", "");
        boolean[] alphabet = new boolean[26];
        Arrays.fill(alphabet, false);
        for(int i = 0; i < input.length(); i++){
            int ascii = (int) input.charAt(i);
            if(ascii < 97 ) ascii += 32;
            alphabet[ascii-97] = true;
        }
        
        for(int i = 0; i < alphabet.length; i++){
            if(!alphabet[i]){
                System.out.println("not pangram");
                System.exit(0);
            }
        }
        System.out.println("pangram");
    }
}