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
}
