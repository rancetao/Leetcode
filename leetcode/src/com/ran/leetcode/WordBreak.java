package com.ran.leetcode;

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

    public Boolean solution(String s, Set<String> dict) {
        for (String temp : dict) {
            if (s.contains(temp)) {
                s = s.replace(temp, "");
            }
        }
        if (s.equalsIgnoreCase(""))
            return true;
        else
            return false;
    }

}
