package com.ran.leetcode;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of
 * haystack.
 * 
 * @author RanceTao
 * 
 */
public class Strstr {

    // brute force
    public String strStr(String haystack, String needle) {

        if (needle == null)
            return null;

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (haystackLen == 0 && needleLen == 0)
            return needle;

        if (needleLen > haystackLen)
            return null;

        for (int i = 0; i < haystackLen - needleLen + 1; i++) {
            int temp = i;
            boolean flag = true;
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return haystack.substring(temp);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Strstr s = new Strstr();
        s.strStr("mississippi", "a");
    }
}
