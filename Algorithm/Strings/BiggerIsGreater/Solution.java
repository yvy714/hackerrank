/***
Problem description:
Given a word w, rearrange the letters of w to construct another word s in such a way that s is lexicographically greater than w. In case of multiple possible answers, find the lexicographically smallest one.

Input Format

The first line of input contains t, the number of test cases. Each of the next t lines contains w.

Constraints 
1<=t<=10^5 
1<=|w|<=100 
w will contain only lower-case English letters and its length will not exceed 100.

Output Format

For each testcase, output a string lexicographically bigger than w in a separate line. In case of multiple possible answers, print the lexicographically smallest one, and if no answer exists, print no answer.
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static String rearrange(String input){
        if(input.length() <=1){
            return "no answer";
        }
        for(int i = 0; i < input.length()-1; i++){
            if((int)input.charAt(input.length()-1-i) - (int)input.charAt(input.length()-2-i) > 0){
                StringBuffer output = new StringBuffer();
                output.append(input.substring(0, input.length()-2-i));
                StringBuffer tail = new StringBuffer(input.substring(input.length()-i-2));
                output.append(ordered(tail));
                return output.toString();
            }
        }
        return "no answer";
    }
    
    static String ordered(StringBuffer input){
        StringBuffer output = new StringBuffer();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        int head = (int)input.charAt(0)-97;
        
        for(int i = 0; i < input.length(); i++){
            alphabet[(int)input.charAt(i) - 97]++;
        }
        
        for(int i = head+1; i <26;i++){
            if(alphabet[i] > 0){
                alphabet[i]--;
                head = i;
                break;
            }
        }
        
        for(int i = 0; i < alphabet.length; i++){
            while(alphabet[i] > 0){
                output.append((char)(i+97));
                alphabet[i]--;
            }
        }
       
        
        return (char)(head + 97) + output.toString();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String input = in.next();
            System.out.println(rearrange(input));
        }
    }
}