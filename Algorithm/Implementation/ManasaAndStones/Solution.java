/***
Problem description:
Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail and notices that two consecutive stones have a difference of either a or b. Legend has it that there is a treasure trove at the end of the trail and if Manasa can guess the value of the last stone, the treasure would be hers. Given that the number on the first stone was 0, find all the possible values for the number on the last stone.

Note: The numbers on the stones are in increasing order.

Input Format 
The first line contains an integer T, i.e. the number of test cases. T test cases follow; each has 3 lines. The first line contains n (the number of stones). The second line contains a, and the third line contains b.

Output Format 
Space-separated list of numbers which are the possible values of the last stone in increasing order.

Constraints 
1<=T<=10 
1<=n,a,b<=10^3

Key Point:

Missing the case a == b

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
            int l = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int x = Math.max(a, b);
            int y = Math.min(a, b);
            if(x == y){
                System.out.println(x * (l-1));
            }else{
                for(int j = 0; j < l; j++){
                    System.out.print(x*j + y*(l-1-j) + " ");
                }
                System.out.println();
            }
        }
    }
}