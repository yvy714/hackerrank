/***
Problem description:
Given a string, S, we define some operations on the string as follows:

a. reverse(S) denotes the string obtained by reversing string S. E.g.: reverse("abc") = "cba"

b. shuffle(S) denotes any string that's a permutation of string S. E.g.: shuffle("god") ∈ ['god', 'gdo', 'ogd', 'odg', 'dgo', 'dog']

c. merge(S1,S2) denotes any string that's obtained by interspersing the two strings S1 & S2, maintaining the order of characters in both. 
E.g.: S1 = "abc" & S2 = "def", one possible result of merge(S1,S2) could be "abcdef", another could be "abdecf", another could be "adbecf" and so on.

Given a string S such that S∈ merge(reverse(A), shuffle(A)), for some string A, can you find the lexicographically smallest A?

Input Format

A single line containing the string S.

Constraints: 
S contains only lower-case English letters.
The length of string S is less than or equal to 10000.

Output Format

A string which is the lexicographically smallest valid A.


Key point:
1. construct A from right to left
2. Greedy.


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
        String input = in.next();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        // record the number of each alphabet appears in the input string
        for(int i = 0; i < input.length();i++){
            alphabet[(int)input.charAt(i) - 97]++;
        }
        // number of times each alphabet should appears in A and shuffle(A)
        int[] alphabet1 = new int[26];
        int[] alphabet2 = new int[26];
        for(int i = 0; i < alphabet.length; i++){
            alphabet1[i] = alphabet[i]/2;
            alphabet2[i] = alphabet[i]/2;
        }
        // construct A and shuaffle(A)
        StringBuffer sample = new StringBuffer();
        StringBuffer sample2 = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        int a1 = 0;
        int s1 = input.length()-1;
        
        while(s1 >= 0 && a1 <= 25 && sample.length() < input.length()/2){
            while(alphabet1[a1] > 0){
                // if current char is the smallest
                if((int)input.charAt(s1) - 97 == a1){
                    sample.append(input.charAt(s1));
                    sample2.append(temp);
                    temp = new StringBuffer();
                    alphabet1[a1]--;
                }else{
                    // if there is not enough char remain
                    if(alphabet2[(int)input.charAt(s1) - 97] == 0){
                        temp.append(input.charAt(s1));
                        int x = 0;
                        char smallest = '|';
                        for(int m = 0; m < temp.length(); m++){
                            if((int)temp.charAt(m) - (int)smallest < 0 && alphabet1[(int)temp.charAt(m)-97] > 0){
                                x = m;
                                smallest = temp.charAt(m);
                            }
                        }
                        sample.append(temp.charAt(x));
                        alphabet1[(int)smallest - 97]--;
                        sample2.append(temp.substring(0, x));
                        for(int m = x; m <temp.length()-1; m++){
                            alphabet2[(int)temp.charAt(m) - 97]++;
                        }
                        if(x != temp.length()){
                            s1 = s1 + temp.length() - x - 1;
                        }
                        
                        temp = new StringBuffer();
                        
                    }else{
                        temp.append(input.charAt(s1));
                        alphabet2[(int)input.charAt(s1) - 97]--;
                    }
                }
                s1--;
            }
           
            a1++;
        }
        
        System.out.println(sample);
        
    }
}