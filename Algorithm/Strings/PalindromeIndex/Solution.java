/***
Problem description:
You are given a string of lower case letters. Your task is to figure out the index of the character on whose removal it will make the string a palindrome. There will always be a valid solution. 

In case the string is already a palindrome, then -1 is also a valid answer along with possible indices.

Input Format

The first line contains T, i.e. the number of test cases.
T lines follow, each containing a string.

Output Format

Print the position (0 index) of the letter by removing which the string turns into a palindrome. For a string, such as

bcbc
we can remove b at index 0 or c at index 3. Both answers are accepted.

Constraints 
1<=T<=20 
1<= length of string <=100005 
All characters are Latin lower case indexed.
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static boolean palindrome(String input){
        for(int i = 0; i < input.length()/2; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        read:
        for(int i = 0; i < t; i++){
            String s = in.next();
            for(int j = 0; j < s.length()/2; j++){
                if(s.charAt(j) != s.charAt(s.length()-j-1)){
                    if(palindrome(s.substring(j+1, s.length()-j)))
                        System.out.println(j);
                    else
                        System.out.println(s.length()-j-1);
                    continue read;
                }
            }
            System.out.println(-1);
        }
    }
}
