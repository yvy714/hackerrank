/***
Problem description:
John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.

Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format

The first line consists of an integer, N, the number of rocks. 
Each of the next N lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Constraints 
1<=N<=100 
Each composition consists of only lower-case Latin letters ('a'-'z'). 
1<= length of each composition <=100
Output Format

Print the number of gem-elements that are common in these rocks. If there are none, print 0.
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
        int[] element = new int[26];
        Arrays.fill(element, 0);
        for(int i = 0; i < t; i++){
            String stone = in.next();
            boolean[] elementx = new boolean[26];
            Arrays.fill(elementx, false);
            for(int j = 0; j < stone.length(); j++){
                elementx[(int)stone.charAt(j) - 97] = true;
            }
            for(int j = 0; j < elementx.length; j++){
                if(elementx[j]) element[j]++;
            }
            
        }
        
        int num = 0;
        for(int i = 0; i < element.length; i++){
            if(element[i] == t) num++;
        }
        System.out.println(num);
        in.close();
    }
}