package com.marinagaisina;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StringReverse {
    /*
        Write a function that reverses a string. The input string is given as an array of characters char[].
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
        memory.
        You may assume all the characters consist of printable ascii characters.
        Input Format
        Example 1 Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
        Example 2 Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
        Constraints
        Use O(1) extra memory
        Output Format
        Example 1 Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
        Example 2 Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
        Sample Input 0
        5
        "h" "e" "l" "l" "o"
        Sample Output 0
        "o" "l" "l" "e" "h"
-------------------------------------------------------------------------------------------------------------------------------
     * Complete the 'reverseString' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY s as parameter.
     */

    public static List<String> reverseString(List<String> s) {
        /*
         * Write your code here
         * Function should return a reversed array - answer
         */
//        String[] charStr = s.toArray(new String[s.size()]);
//        for (String str : charStr) {
//            System.out.print(str);
//        }
        for (int i=0; i<s.size()/2;i++) {
            String temp = s.get(i);
            s.set(i, s.get(s.size()-i-1));
            s.set(s.size()-i-1, temp);
        }
        //for (String str : s) {
        //    System.out.print(str);
        //}
        s.forEach(System.out::print);
        return s;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int string_len = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> s_arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> result = StringReverse.reverseString(s_arr);

        bufferedWriter.write(
            result.stream()
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
        /*
        List<String> s = new ArrayList<>();
        s.add("h");
        s.add("e");
        s.add("l");
        s.add("l");
        s.add("o");
        reverseString(s);*/
    }

}
