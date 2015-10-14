/*** 
Problem description:
You are given an integer N. Find the digits in this number that exactly divide N (division that leaves 0 as remainder) and display their count. For N=24, there are 2 digits (2 & 4). Both of these digits exactly divide 24. So our answer is 2.

Note

If the same number is repeated twice at different positions, it should be counted twice, e.g., For N=122, 2 divides 122 exactly and occurs at ones' and tens' position. So for this case, our answer is 3.
Division by 0 is undefined.
Input Format

The first line contains T (the number of test cases), followed by T lines (each containing an integer N).

Constraints 
1<=T<=15 
0<N<1010
Output Format

For each test case, display the count of digits in N that exactly divide N in a separate line.
***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int digits(long num){
        long remain = num;
        int count = 0;
        while(remain > 0){
            long digit = remain % 10;
            if(digit != 0 && num % digit == 0) count++;
            remain = remain / 10;
        }
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            long num = in.nextLong();
            System.out.println(digits(num));
        }
        
    }
}