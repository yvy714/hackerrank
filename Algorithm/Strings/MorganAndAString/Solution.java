/***
Problem description:
Jack and Daniel are friends. Both of them like letters, especially upper-case ones. 
They are cutting upper-case letters from newspapers, and each one of them has their collection of letters stored in separate stacks. 
One beautiful day, Morgan visited Jack and Daniel. He saw their collections. Morgan wondered what is the lexicographically minimal string, made of that two collections. He can take a letter from a collection when it is on the top of the stack. 
Also, Morgan wants to use all the letters in the boys' collections.

Input Format

The first line contains the number of test cases, T. 
Every next two lines have such format: the first line contains string A, and the second line contains string B.

Constraints 
1<=T<=5 
1<=|A|<=10^5 
1<=|B|<=10^5 
A and B contain upper-case letters only.

Output Format

Output the lexicographically minimal string S for each test case in new line.


Key point:

Case analysis

merge [X|Xs] [Y|Ys] Zs

if X < Y merge Xs [Y|Ys] append(Zs, X)
if X > Y merge [X|Xs] Ys append(Zs, Y)
if X == Y
    If BD BD, check D D append(Zs, [B|B])
    If BA BA, continue
    If BA BC, break;

    If BA BC, merge A BC
    If BC BA, merge BC A
    If B  BD, merge B D
     

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
            String x = in.next();
            String y = in.next();
            int indexx = 0;
            int indexy = 0;
            StringBuffer output = new StringBuffer();
            while(indexx < x.length() && indexy < y.length()){
                if(x.charAt(indexx) < y.charAt(indexy))
                    output.append(x.charAt(indexx++));
                else if(x.charAt(indexx) > y.charAt(indexy))
                    output.append(y.charAt(indexy++));
                else{
                    int tempx = indexx;
                    int tempy = indexy;
                    
                    while(tempx < x.length() && tempy < y.length()){
                        if(x.charAt(tempx) != y.charAt(tempy))
                            break;
                        else if(x.charAt(tempx) > x.charAt(indexx)){
                            output.append(x.substring(indexx, tempx)).append(y.substring(indexy, tempy));
                            indexx = tempx; 
                            indexy = tempy;
                        }
                        tempx++;
                        tempy++;
                    }
                    
                    if(tempx == x.length())
                        output.append(y.charAt(indexy++));
                    else if(tempy == y.length())
                        output.append(x.charAt(indexx++));
                    else{
                        if(x.charAt(tempx) > y.charAt(tempy))
                            output.append(y.charAt(indexy++));
                        else
                            output.append(x.charAt(indexx++));
                    }
                }
            }
            output.append(x.substring(indexx)).append(y.substring(indexy));
            System.out.println(output);
        }
    }
}