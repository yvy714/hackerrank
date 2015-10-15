/***
Problem description:
Given the time in numerals we may convert it into words, as shown below:

5:00 -> five o' clock
5:01 -> one minute past five
5:10 -> ten minutes past five
5:30 -> half past five
5:40 -> twenty minutes to six
5:45 -> quarter to six

Write a program which prints the time in words for the input given in the format mentioned above.

Input Format

There will be two lines of input:
H, representing the hours
M, representing the minutes

Constraints
1<=H<12
0<=M<60
Output Format

Display the time in words.
 ***/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static String convert(int a){
        String output = "";
        switch(a){
            case 1 : output = "one"; break;
            case 2 : output = "two"; break;
            case 3 : output = "three"; break;
            case 4 : output = "four"; break;
            case 5 : output = "five"; break;
            case 6 : output = "six"; break;
            case 7 : output = "seven"; break;
            case 8 : output = "eight"; break;
            case 9 : output = "night"; break;
            case 10 : output = "ten"; break;
            case 11 : output = "eleven"; break;
            case 12 : output = "twelve"; break;
            case 13 : output = "thirteen"; break;
            case 14 : output = "fourteen"; break;
            case 15 : output = "quarter"; break;
            case 16 : output = "sixteen"; break;
            case 17 : output = "seventeen"; break;
            case 18 : output = "eighteen"; break;
            case 19 : output = "nineteen"; break;
            case 20 : output = "twenty"; break;
            case 21 : output = "twenty one"; break;
            case 22 : output = "twenty two"; break;
            case 23 : output = "twenty three"; break;
            case 24 : output = "twenty four"; break;
            case 25 : output = "twenty five"; break;
            case 26 : output = "twenty six"; break;
            case 27 : output = "twenty seven"; break;
            case 28 : output = "twenty eight"; break;
            case 29 : output = "twenty nine"; break;
        }
        return output;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int minute = in.nextInt();
        String hourS =  convert(hour);
        String minuteS;
        
        if(minute == 0){
            System.out.println(hourS + " o' clock");
        }
        else if(minute == 30){
            System.out.println("half past " + hourS);
        }
        else if(minute < 30){
            minuteS = convert(minute);
            String s;
            if(minute == 1) 
                s = " minute";
            else if (minute == 15)
                s = "";
            else
                s = " minutes";
            System.out.println(minuteS + s + " past " + hourS);
        }
        else{
            hour++;
            if(hour > 12) hour-=12;
            hourS = convert(hour);
            minuteS = convert(60 - minute);
            String s;
            if(minute == 59) 
                s = " minute";
            else if (minute == 45)
                s = "";
            else
                s = " minutes";
            System.out.println(minuteS + s + " to " + hourS);
        }
        
    }
}