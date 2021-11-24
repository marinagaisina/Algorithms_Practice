package com.marinagaisina;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatNumbersFormats {
//    Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
//    Print the decimal value of each fraction on a new line with 6 places after the decimal.
//----------------------------Input Format-------------------------
//    The first line contains an integer, , the size of the array.
//    The second line contains  space-separated integers that describe .
//---------------------Output Format-----------------------------------
//    Print the following  lines, each to  decimals:
//    proportion of positive values
//    proportion of negative values
//    proportion of zeros
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        FloatNumbersFormats.plusMinus(arr);
//
//        bufferedReader.close();
        List<Integer> arr = new ArrayList<>();
        arr.add(-4);
        arr.add(3);
        arr.add(-9);
        arr.add(0);
        arr.add(4);
        arr.add(1);
        plusMinus(arr);
    }
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        int size = arr.size();

        for (Integer num : arr) {
            if (num >0) {
                positive += 1;
            } else if (num<0) {
                negative += 1;
            } else {
                zeros += 1;
            }
        }
        System.out.println(String.format("%.6f", ((float) positive/size)));
        System.out.println(String.format("%.6f", ((float) negative/size)));
        System.out.println(String.format("%.6f", ((float) zeros/size)));

    }
}
