package com.ran.leetcode;

/**
 * Implement strStr().
 * <p>
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of
 * haystack.
 *
 * @author RanceTao
 */
public class Strstr {

    public static void main(String[] args) {

        Strstr s = new Strstr();
        s.strStr("mississippi", "a");
    }

    // brute force
    public String strStr(String haystack, String needle) {

        int needleLen = needle.length();
        int haystackLen = haystack.length();

        if (needleLen == haystackLen && needleLen == 0) {
            return "";
        }

        if (needleLen == 0) {
            return haystack;
        }

        for (int i = 0; i < haystackLen; i++) {
            // make sure in boundary of needle
            if (haystackLen - i + 1 < needleLen) {
                return null;
            }

            int k = i;
            int j = 0;

            while (j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needleLen) {
                    return haystack.substring(i);
                }
            }
        }

        return null;
    }


    public String strStr2(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 < len2) {
            return null;
        }
        if (len1 == len2) {
            return s1;
        }

        for (int i = 0; i < len1; i++) {
            if (len1 - i + 1 < len2) {
                return null;
            }
            int k = i;
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    k++;
                }
                if (j == len2 - 1) {
                    return s1.substring(i);
                }
            }
        }
        return null;
    }
}
