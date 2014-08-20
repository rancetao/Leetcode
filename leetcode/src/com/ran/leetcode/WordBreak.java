package com.ran.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author RanceTao
 * 
 */

public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {

        if (dict.contains(s) == true)
            return true;

        int length = s.length();
        for (int i = 1; i < length; i++) {

            String firstPart = s.substring(0, i);
            if (dict.contains(firstPart) == true) {

                String remainPart = s.substring(i, length);

                boolean result = wordBreak(remainPart, dict);
                if (result == true) {
                    return true;
                }
            }
        }

        return false;
    }

    // DP
    public boolean wordBreak2(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null)
            return true;

        int length = s.length();

        // dp[i] is true when the substring from i to the end can be partitioned
        boolean[] dp = new boolean[length + 1];
        for (boolean b : dp)
            b = false;

        // empty string can be partitioned for sure
        dp[length] = true;

        // bottom up dp, start from the end
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                String sub = s.substring(i, j + 1);
                if (dict.contains(sub) == true && dp[j + 1] == true) {
                    dp[i] = true;
                    break; // break, just jump out current level of loop
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "abcd";
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("abc");
        dict.add("b");
        dict.add("cd");
        System.out.println(wb.wordBreak(s, dict));
    }
}
