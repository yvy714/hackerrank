/***
Problem description:
An English text needs to be encrypted using the following encryption scheme. 
First, the spaces are removed from the text. Let L be the length of this text. 
Then, characters are written into a grid, whose rows and columns have the following constraints:

floor(sqrt(L) <= rows <= column <= ceil(sqrt(L)))
For example, the sentence if man was meant to stay on the ground god would have given us roots after removing spaces is 54 characters long, so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots
Ensure that rows×columns≥L
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rows×columns.
The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:

imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

You will be given a message in English with no spaces between the words. The maximum message length can be 81 characters. Print the encoded message.

Here are some more examples:
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
        String inputplus = in.nextLine();
        inputplus.replace("\\s+","");
        StringBuffer input = new StringBuffer(inputplus);
        
        long l = input.length();
        long x = (long) Math.floor(Math.sqrt(l));
        long y = (long) Math.ceil(Math.sqrt(l));
        
        long a = -1; long b = -1;
        
        for(long i = y; i >= x; i--){
            long row = (long) Math.ceil((double)l/y);
            if(y >= row && row >= x){
                a=row;
                b=i;
                break;
            }
        }
        
        for(int i = 0; i < b; i++){
            StringBuffer output = new StringBuffer("");
            int index = i;
            while(index <= l-1){
                output.append(input.charAt(index));
                index+=b;
            }
            System.out.print(output+" ");
        }
        System.out.println();
        
    }
}