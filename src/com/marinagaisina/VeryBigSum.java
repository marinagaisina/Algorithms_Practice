package com.marinagaisina;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


//    Function Description
//
//    Complete the aVeryBigSum function in the editor below. It must return the sum of all array elements.
//
//        aVeryBigSum has the following parameter(s):
//
//        int ar[n]: an array of integers .
//------------Return---------------------------
//
//        long: the sum of all array elements
//------------Input Format---------------------
//
//        The first line of the input consists of an integer .
//        The next line contains  space-separated integers contained in the array.
//
//------------Output Format----------------------------------
//
//        Return the integer sum of the elements in the array.

public class VeryBigSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long result = VeryBigSum.getAVeryBigSum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static long getAVeryBigSum(List<Long> ar) {
        long sum = 0;
        for (Long num : ar) {
            sum += num;
        }
        return sum;
    }
}
