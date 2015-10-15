/***
Problem description:
Little Bob loves chocolate, and he goes to a store with $N in his pocket. The price of each chocolate is $C. The store offers a discount: for every M wrappers he gives to the store, he gets one chocolate for free. How many chocolates does Bob get to eat?

Input Format: 
The first line contains the number of test cases, T. 
T lines follow, each of which contains three integers, N, C, and M.

Output Format: 
Print the total number of chocolates Bob eats.

Constraints: 
1<=T<=1000 
2<=N<=105 
1<=C<=N 
2<=M<=N
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
         //Write code to solve each of the test over here
        int num = N / C;
        int wrappers = num;
        while(wrappers / M > 0){
            int num2 = wrappers / M;
            num += num2;
            wrappers -= num2 * (M-1);
        }
        return num;
    }
    
    
}
