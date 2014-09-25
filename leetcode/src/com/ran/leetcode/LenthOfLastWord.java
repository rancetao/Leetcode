package com.ran.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * For example, Given s = "Hello World", return 5.
 *
 * @author taor
 * @date Mar 17, 2014
 */
public class LenthOfLastWord {

    public int lengthOfLastWord(String s) {

        if (s == null) {
            return 0;
        }

        if (s.equals(" ")) {
            return 0;
        }

        String[] arrStr = s.split(" ");
        if (arrStr.length == 0) {
            return 0;
        } else {
            return arrStr[arrStr.length - 1] == " " ? 0 : arrStr[arrStr.length - 1].length();
        }

    }
}
