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
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0) {

            return result;
        }

        int start = 0;
        ArrayList<String> partition = new ArrayList<String>();

        buildResult(s, start, partition, result);

        return result;
    }

    private void buildResult(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String tempStr = s.substring(start, i);
            if (isPalindrome(tempStr)) {
                partition.add(tempStr);
                buildResult(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
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
            } else {

                ++begin;
                --end;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        PalindromePartition pp = new PalindromePartition();
        ArrayList<ArrayList<String>> resultArrLists = pp.partition("aab");
        for (ArrayList<String> arrList : resultArrLists) {
            for (String temStr : arrList) {
                System.out.print(temStr + ", ");
            }
            System.out.print("\r\n");
        }
    }
}
