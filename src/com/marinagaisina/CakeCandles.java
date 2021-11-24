package com.marinagaisina;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//    Returns
//    int: the number of candles that are tallest
//
//    Input Format
//    The first line contains a single integer, n, the size of candles[n].
//    The second line contains  space-separated integers, where each integer i describes the height of candles[i].
//
//    Explanation 0
//    Candle heights are [3,2,1,3]. The tallest candles are 3 units, and there are 2 of them.

public class CakeCandles {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = com.marinagaisina.CakeCandles.birthdayCakeCandles(candles);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 4,2,1,3,4,4);
        System.out.println(birthdayCakeCandles(list));
    }
    public static int birthdayCakeCandles(List<Integer> candles) {
        int maxHeight = candles.get(0);
        for (Integer num : candles) {
            if (num > maxHeight) {
                maxHeight = num;
            }
        }
        int count = 0;
        for (Integer num : candles) {
            if (num == maxHeight) {
                count++;
            }
        }
        return count;
    }
}
