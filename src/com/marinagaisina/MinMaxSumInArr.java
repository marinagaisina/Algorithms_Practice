package com.marinagaisina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MinMaxSumInArr {
    //    Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
//    Then print the respective minimum and maximum values as a single line of two space-separated long integers.
//    Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
//
//    Input Format
//
//    A single line of five space-separated integers.
//    Output Format
//
//    Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers.
//        (The output can be greater than a 32 bit integer.)
        public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MinMaxSumInArr.miniMaxSum(arr);
        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        long min = arr.get(0);
        long max = arr.get(0);
        long sum = 0;

        if ((arr.get(0).equals(arr.get(1))) && (arr.get(1).equals(arr.get(2))) && (arr.get(2).equals(arr.get(3))) && (arr.get(3).equals(arr.get(4)))) {
            System.out.println(arr.get(0)*4 + arr.get(0)*4);
            return;
        }

        for (Integer num : arr) {
            if (num > max) {
                max = num;
            } else if (num < max) {
                min = num;
            }
            sum += num;
        }
        System.out.println(sum-max + sum-min);
    }
}
