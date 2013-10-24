package com.ran.leetcode;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author taor
 * @since Oct 22, 2013
 */
public class PalindromePartition {

    public ArrayList<ArrayList<String>> partition(String s) {

        return null;
    }

    public Boolean isPalindrome(String s) {

        if (s.length() == 1) {

            return true;
        }
        int begin = 0;
        int end = s.length() - 1;
        while (begin <= end) {
            if (s.charAt(begin) != s.charAt(end)) {

                return false;
            }
            else {

                ++begin;
                --end;
            }
        }
        return true;
    }
}
