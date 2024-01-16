package com.marinagaisina;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/***
 * There is a collection of rocks where each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range ascii[a-z].
 * There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in the collection.
 * Given a list of minerals embedded in each of the rocks, display the number of types of gemstones in the collection.
 * Ex/ample
 *  arr = ['abc', 'abc', 'bc']
 * The minerals b and c appear in each rock, so there are 2 gemstones.
 * Function Description:
 * Complete the gemstones function in the editor below.
 * Gemstones has the following parameter(s):
 * string arr[n]: an array of strings
 * Returns:
 * int: the number of gemstones found
 * Input Format:
 * The first line consists of an integer n, the size of arr.
 * Each of the next n lines contains a string arr[i] where each letter represents an occurence of a mineral in the current rock.
 * Constraints:
 *  1 <= n <= 100
 *  1 <= | arr[i] | <= 100
 * Each composition arr[i] consists of only lower-case Latin letters ('a'-'z').
 * Sample Input:
 * STDIN       Function
 * -----       --------
 * 3           arr[] size n = 3
 * abcdde      arr = ['abcdde', 'baccd', 'eeabg']
 * baccd
 * eeabg
 * Sample Output:
 * 2
 * Explanation:
 * Only a and b occur in every rock.
 */
public class Gemstones {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
        // Write your code here
        int gemStoneCount = 0;
        Map<String, Integer> countLetters = new HashMap<>();
        arr.forEach(str -> {
            String[] letters = str.split("");
            List<String> noDupStrList=Arrays.stream(letters)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println("noDupStrList: "+ noDupStrList);
            for (String letter: noDupStrList) {
                if (countLetters.containsKey(letter)) {
                    countLetters.put(letter, countLetters.get(letter)+1);
                } else {
                    countLetters.put(letter, 1);
                }
            }
        });
        for (Map.Entry<String, Integer> entry: countLetters.entrySet()) {
            //System.out.println("Map.Entry key: "+entry.getKey()+", value: "+entry.getValue());
            if (entry.getValue() == arr.size()) {
                gemStoneCount++;
            }
        }
        return gemStoneCount;
    }
}
