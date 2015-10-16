/***
Problem description:
Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books. He chooses strings S1 and S2 in such a way that |len(S1)−len(S2)|≤1.

Your task is to help him find the minimum number of characters of the first string he needs to change to enable him to make it an anagram of the second string.

Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.

Input Format 
The first line will contain an integer, T, representing the number of test cases. Each test case will contain a string having length len(S1)+len(S2), which will be concatenation of both the strings described above in the problem.The given string will contain only characters from a to z.

Output Format 
An integer corresponding to each test case is printed in a different line, i.e. the number of changes required for each test case. Print −1 if it is not possible.

Constraints

1<=T<=100 
1<=len(S1)+len(S2)<=10^4
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
        for(int i = 0; i < t; i++){
            String input = in.next();
            if(input.length() % 2 == 1){
                System.out.println(-1);
            }else{
                String s1 = input.substring(0, input.length()/2);
                String s2 = input.substring(input.length()/2);
                int[] alphabets1 = new int[26];
                int[] alphabets2 = new int[26];
                Arrays.fill(alphabets1, 0);
                Arrays.fill(alphabets2, 0);
                for(int j = 0; j < s1.length(); j++){
                    alphabets1[(int)s1.charAt(j)-97]++;
                    alphabets2[(int)s2.charAt(j)-97]++;
                }
                int same = 0;
                for(int j = 0; j < 26; j++){
                    same += Math.min(alphabets1[j], alphabets2[j]);
                }
                System.out.println(s1.length()-same);
            }
        }
    }
}