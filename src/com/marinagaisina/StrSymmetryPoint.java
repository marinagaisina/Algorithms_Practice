package com.marinagaisina;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/***
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.
 *
 * Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.
 *
 * For example, given a string:
 *
 * "racecar"
 *
 * the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".
 *
 * Given a string:
 *
 * "x"
 *
 * the function should return 0, because both substrings are empty.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * the length of string S is within the range [0..2,000,000].
 */
public class StrSymmetryPoint {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> s_arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(""))
                .collect(toList());
        int result = symetryPoint(s_arr);
        System.out.println("Symetry point: "+result);
        bufferedWriter.write(String.valueOf(result));

        //startMidEnd(s_arr);

        bufferedReader.close();
        bufferedWriter.close();
    }
//hellodifjskfnvlsollehkdjkdjdjndndkh
//helglehjjjh

    public static int symetryPoint(List<String> s_arr) {
        StringBuilder subStr= new StringBuilder();
        for(int i=0; i<s_arr.size()-1; i++) {
            for (int j=s_arr.size()-1; j>1; j--) {
                if (j <= i) {
                    if (subStr.length() > 1) {
                        System.out.println("Case: j==i");
                        System.out.println("Substring: " + subStr);
                        return j;
                    } else {
                        System.out.println("Case: j==i, no substring found");
                        System.out.println("Substring: " + subStr);
                        return -1;
                    }
                }
                if ((!(s_arr.get(i).equals(s_arr.get(j)))) && (subStr.length() > 1)) {
                    //System.out.println("Index of match: " + j);
                    System.out.println("Case: subString ended");
                    System.out.println("Substring: " + subStr);
                    return j;
                }
                if (s_arr.get(i).equals(s_arr.get(j))) {
                    subStr.append(s_arr.get(i));
                    i++;
                } else {
                    if (subStr.length() > 0) {
                        subStr.delete(0, subStr.length());
                        i=0;
                    }
                }
            }
        }
        if (subStr.length() <2) {
            System.out.println("Case 'Only one letter-substring found'");
            System.out.println("Substring: " + subStr);
            return -1;
        }
        System.out.println("Substring: " + subStr);
        return 0;
    }

    public static String startMidEnd(List<String> s_arr) {
        System.out.println("Beginning character: "+s_arr.get(0));
        System.out.println("Ending character: "+s_arr.get(s_arr.size()-1));
        System.out.println("Middle character: "+s_arr.get(s_arr.size()/2));
        return s_arr.toString();
    }
}
