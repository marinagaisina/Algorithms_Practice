package com.marinagaisina;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/***
 * In this challenge, you will determine whether a string is funny or not. To determine whether a string is funny, create a copy of the string in reverse e.g. abc->cba.
 * Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end.
 * If the list of absolute differences is the same for both strings, they are funny.
 *
 * Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.
 *
 * Example
 * s = 'lmnop'
 * The ordinal values of the charcters are [108, 109, 110, 111, 112]. s(reverse) = 'ponml' and the ordinals are [112, 111, 110, 109, 108].
 * The absolute differences of the adjacent elements for both strings are [1, 1, 1, 1], so the answer is Funny.
 *
 * Function Description
 *
 * Complete the funnyString function in the editor below.
 *
 * funnyString has the following parameter(s):
 *
 * string s: a string to test
 * Returns
 *
 * string: either Funny or Not Funny
 * Input Format
 *
 * The first line contains an integer q, the number of queries.
 * The next q lines each contain a string, s.
 *
 * Constraints
 * 1<=q<=10
 * 2<=length of s<=10000
 * Sample Input
 *
 * STDIN   Function
 * -----   --------
 * 2       q = 2
 * acxz    s = 'acxz'
 * bcxz    s = 'bcxz'
 * Sample Output
 *
 * Funny
 * Not Funny
 * Explanation
 *
 * Let r be the reverse of s.
 *
 * Test Case 0:
 * s=acxz, r=zxca
 * Corresponding ASCII values of characters of the strings:
 * s=[97, 99, 120, 122] and r=[122, 120, 99, 97]
 * For both the strings the adjacent difference list is [2, 21, 2].
 *
 * Test Case 1:
 * s='bcxz', r='zxcb'
 * Corresponding ASCII values of characters of the strings:
 * s=[98, 99, 120, 122] and r=[122, 120, 99, 98]
 * The difference list for string  is [1, 21, 2] and for string  is [2, 21, 1].
 */
public class FunnyString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return "Not Funny";
        }
        int[] diff = new int[chars.length-1];
        int[] diffReversed = new int[chars.length-1];
        for (int i=0; i<chars.length-1; i++) {
            diff[i] = Math.abs((int)chars[i] - (int)chars[i+1]);
            System.out.print((int)chars[i]+" ");
            if (i==chars.length-2) {
                System.out.println((int)chars[i+1]);
            }
        }
        System.out.println("chars diff: "+ Arrays.toString(diff));
        int i = 0;
        for (int j=chars.length-1; j>0; j--) {
            diffReversed[i] = Math.abs((int)chars[j]-(int)chars[j-1]);
            i++;
            System.out.print((int)chars[j]+" ");
            if (j==1) {
                System.out.println((int)chars[j-1]);
            }
        }
        System.out.println("charsReversed diff: "+ Arrays.toString(diffReversed));
        boolean flag;
        for (int k=0; k<diff.length; k++) {
            if (diff[k] != diffReversed[k]) {
                return "Not Funny";
            }
        }
        return "Funny";
    }
}