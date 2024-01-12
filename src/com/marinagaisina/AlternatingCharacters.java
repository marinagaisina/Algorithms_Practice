package com.marinagaisina;

import javax.sound.sampled.Line;
import java.io.*;
import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Given a string, remove characters until the string is made up of any two alternating characters.
 * When you choose a character to remove, all instances of that character must be removed. Determine the longest string possible that contains just two alternating letters.
 *
 *         Example
 *         s='abaacdabd'
 *
 *         Delete a, to leave bcdbd. Now, remove the character c to leave the valid string bdbd with a length of 4.
 *         Removing either b or d at any point would not result in a valid string. Return 4.
 *
 *         Given a string s, convert it to the longest possible string  made up only of alternating characters. Return the length of string t.
 *         If no string  can be formed, return 0.
 *
 *         Function Description
 *
 *         Complete the alternate function in the editor below.
 *
 *         alternate has the following parameter(s):
 *
 *         string s: a string
 *         Returns
 *         int: the length of the longest valid string, or 0 if there are none
 *         Input Format
 *
 *         The first line contains a single integer that denotes the length of s.
 *         The second line contains string s.
 *
 *         Constraints
 *         1 <= length of s <= 1000
 *         s[i] pertain ascii [a-z]
 *         Sample Input
 *
 *         STDIN       Function
 *         -----       --------
 *         10          length of s = 10
 *         beabeefeab  s = 'beabeefeab'
 *         Sample Output
 *
 *         5
 *         Explanation
 *
 *         The characters present in s are a, b, e, and f. This means that  must consist of two of those characters and we must delete two others.
 *         Our choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].
 *
 *         If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.
 *
 *         If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string .
 *
 *         Other cases are solved similarly.
 *
 *         babab is the longest string we can create.
 */
public class AlternatingCharacters {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();


        bufferedReader.close();
        bufferedWriter.close();
    }
    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    // test case: abaacdabd
    // test case: beabeefeab
    // asdcbsdcagfsdbgdfanfghbsfdab (8)
    public static int alternate(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        if (s.length() == 2) {
            if (s.endsWith(s.substring(0,1))) {
                return 0;
            } else return 2;
        }
        char[] chars = s.toCharArray();
        List<String> uniques = new ArrayList<>();
        for (char ch: chars) {
            if (!uniques.contains(Character.toString(ch))) {
                uniques.add(Character.toString(ch));
            }
        }
        int maxLength = 0;
        System.out.println("Uniques: "+uniques);
        for (int i=0; i<uniques.size()-1; i++) {
            for (int j=i+1; j<uniques.size(); j++) {
                StringBuilder regBuilder = new StringBuilder();
                for (int k=0; k<uniques.size(); k++) {
                    if (k != i && k != j) {
                        regBuilder.append(uniques.get(k));
                    }
                }
                System.out.println("RegBuilder: "+regBuilder.toString());
                String newStr = s.replaceAll("[" + regBuilder.toString() + "]", "");
                System.out.println("newStr: "+newStr);
                if (validate(newStr)) {
                    if (newStr.length() > maxLength) {
                        maxLength = newStr.length();
                        System.out.println("max length: "+maxLength);
                    }
                }
            }
        }
        return maxLength;
    }

    public static boolean validate(String s) {
        if (s.length() < 2) {
            return false;
        }
        List<String> arr_str = Arrays.asList(s.split(""));
        for (int i=0; i<arr_str.size()-1; i++) {
            if (arr_str.get(i).equals(arr_str.get(i+1))) {
                System.out.println(s+" is not valid.");
                return false;
            }
        }
        System.out.println(s+" is valid.");
        return true;
    }
}