/***
Problem description:

Sherlock Holmes is getting paranoid about Professor Moriarty, his arch-enemy. All his efforts to subdue Moriarty have been in vain. These days Sherlock is working on a problem with Dr. Watson. Watson mentioned that the CIA has been facing weird problems with their supercomputer, 'The Beast', recently. This afternoon, Sherlock received a note from Moriarty, saying that he has infected 'The Beast' with a virus. Moreover, the note had the number N printed on it. After doing some calculations, Sherlock figured out that the key to remove the virus is the largest Decent Number having N digits.

A Decent Number has the following properties:

3, 5, or both as its digits. No other digit is allowed.
Number of times 3 appears is divisible by 5.
Number of times 5 appears is divisible by 3.
Meanwhile, the counter to the destruction of 'The Beast' is running very fast. Can you save 'The Beast', and find the key before Sherlock?

Input Format
The 1st line will contain an integer T, the number of test cases. This is followed by T lines, each containing an integer N. i.e. the number of digits in the number. 

Output Format
Largest Decent Number having N digits. If no such number exists, tell Sherlock that he is wrong and print −1.

Constraints
1<=T<=20
1<=N<=100000

Key Point:
Constructing a long string using repeated string concatenation is slow. As String is immutable, every concatenation has to create a new string with a copy of the original string and also a copy of the additional string. The performance of string concatenation is O(N^2). When you're looping to build up a large block of character data, try using StringBuffer instead. 
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    /* Gnerate sequence of 5 and 3*/
    static String build53(int x, int y){
        StringBuffer output = new StringBuffer();
        for(int i = 0; i < x; i++){
            output.append("5");
        }
        for(int i = 0; i < y; i++){
            output.append("3");
        }
        return output.toString();
    }
    
    public static void main(String[] args) {
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in  = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            String output = "";
            
            for(int j = n; j >=0; j--){
                if(j % 3 == 0 && (n-j) % 5 == 0){
                    output = build53(j, n-j); 
                    break;
                }
            }
            
            if(output.isEmpty()) 
                System.out.println(-1);
            else
                System.out.println(output);
        }
    }    
    
}