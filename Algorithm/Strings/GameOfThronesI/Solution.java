/***
Problem description:
Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

door

But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

Input Format 
A single line which contains the input string.

Constraints 
1<= length of string <=105 
Each character of the string is a lowercase English letter.

Output Format 
A single line which contains YES or NO in uppercase.
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        
        for(int i = 0; i < inputString.length(); i++){
            alphabet[(int)inputString.charAt(i)-97]++;
        }
        
        boolean valid = true;
        boolean odd = true;
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] % 2 == 1){
                if(odd)
                    odd = false;
                else{
                    valid = false;
                    break;
                }
                    
            }
        }
        
        if(valid)
            System.out.println("YES");
        else
            System.out.println("NO");
        
        myScan.close();
    }
}
