package com.marinagaisina;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

 /***
  * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 * Example:
 * s = mom
  * The list of all anagrammatic pairs is [m,m],[mo,om] at positions [[0],[2]], [[0,1],[1,2]] respectively.
 * Function Description:
 * Complete the function sherlockAndAnagrams in the editor below.
 * sherlockAndAnagrams has the following parameter(s):
 * string s: a string
 * Returns:
 * int: the number of unordered anagrammatic pairs of substrings in s
 * Input Format:
 * The first line contains an integer q, the number of queries.
 * Each of the next q lines contains a string s to analyze.
 * Constraints:
 * 1<=q<=10
 * 2<=length of s<=100
 * s contains only lowercase letters in the range ascii[a-z].
 *
 * Sample Input 0:
 * 2
 * abba
 * abcd
 * Sample Output 0:
 * 4
 * 0
 * Explanation 0:
 * The list of all anagrammatic pairs is [a,a], [ab, ba], [b,b] and [abb, bba] at positions [[0],[3]], [[0,1],[2,3]], [[1],[2]] and [[0,1,2],[1,2,3]] respectively.
 * No anagrammatic pairs exist in the second query as no character repeats.
 * Sample Input 1:
 * 2
 * ifailuhkqq
 * kkkk
 * Sample Output 1:
 * 3
 * 10
 * Explanation 1:
 * For the first query, we have anagram pairs [i,i],[q,q] and [ifa, fai] at positions [[0],[3]], [[8],[9]] and [[0,1,2],[1,2,3]] respectively.
 * For the second query:
 * There are 6 anagrams of the form [k,k] at positions [[0],[1]],[[0],[2]],[[0],[3]],[[1],[2]],[[1],[3]] and [[2],[3]].
 * There are 3 anagrams of the form [kk,kk] at positions [[0,1],[1,2]],[[0,1],[2,3]] and [[1,2],[2,3]].
 * There is 1 anagram of the form [kkk,kkk] at position [[0,1,2],[1,2,3]].
 * Sample Input 2:
 * 1
 * cdcd
 * Sample Output 2:
 * 5
 * Explanation 2:
 * There are two anagrammatic pairs of length 1: [c,c] and [d,d].
 * There are three anagrammatic pairs of length 2: [cd,dc],[cd,cd],[dc,cd] at positions [[0,1],[1,2]],[[0,1],[2,3]],[[1,2],[2,3]] respectively.
 */
public class Sherlock {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        List<String> strArr = Arrays.asList(s.split(""));
        List<String[]> pairs = new ArrayList<>();
        for (int i=0; i<strArr.size(); i++) {
            for (int j=strArr.size()-1; j>i; j--) {
                if (strArr.get(i).equals(strArr.get(j))) {
                    //if (j==i+1) {
                    //    pairs.add(new String[]{strArr.get(i), strArr.get(j)});
                    //} else {
                        if (i==0 && j == strArr.size()-1) {
                            pairs.add(new String[]{strArr.get(i), strArr.get(j)});
                        } else if (j-i == 2) {
                            pairs.add(new String[]{strArr.get(i), strArr.get(j)});
                        }
                        String[] newSubStrLeft = s.substring(i, j).split("");
                        String[] newSubStrRight = s.substring(i+1, j+1).split("");
                        System.out.println("newSubStrLeft: "+ Arrays.toString(newSubStrLeft));
                        System.out.println("newSubStrRight: "+ Arrays.toString(newSubStrRight));
                        Map<String, Integer> mapLeft = new HashMap<>();
                        Map<String, Integer> mapRight = new HashMap<>();

                        for (String letter: newSubStrLeft) {
                            if (!mapLeft.containsKey(letter)) {
                                mapLeft.put(letter, 1);
                            } else {
                                mapLeft.put(letter, mapLeft.get(letter)+1);
                            }
                        }
                        for (String letter: newSubStrRight) {
                            if (!mapRight.containsKey(letter)) {
                                mapRight.put(letter, 1);
                            } else {
                                mapRight.put(letter, mapRight.get(letter)+1);
                            }
                        }
                        if (compareMaps(mapLeft, mapRight)) {
                            pairs.add(new String[]{String.join("",newSubStrLeft), String.join("",newSubStrRight)});
                        }
                        String[] secondCheck = checkSubString(s.split(""));
                        if (secondCheck != null) {
                            pairs.add(secondCheck);
                        }
                    //}
                }
            }
        }
        pairs.forEach(e-> {
            System.out.println("Pairs: "+Arrays.toString(e));
        });

        return pairs.size();
    }

    public static boolean compareMaps(Map<String, Integer> mapLeft, Map<String, Integer> mapRight) {
        for (Map.Entry<String, Integer> entry: mapLeft.entrySet()) {
            if (!mapRight.containsKey(entry.getKey())) {
                return false;
            } else if (!mapRight.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static String[] checkSubString(String[] subStrArr) {
        int count;
        if (subStrArr.length%2 > 0) {
            count = subStrArr.length/2;
        } else {
            count = subStrArr.length/2-1;
        }
        StringBuilder matchLength = new StringBuilder();
        for (int i=0; i<count; i++) {
            for (int j = subStrArr.length-1; j > count; j--) {
                if(subStrArr[i].equals(subStrArr[j])) {
                    matchLength.append(subStrArr[i]);
                    i++;
                } else {
                    return null;
                }
            }
        }
        return new String[]{matchLength.toString(),matchLength.reverse().toString()};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
