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

        ArrayList<ArrayList<String>> resultArrLists = new ArrayList<ArrayList<String>>();

        if (s == null)
            return null;
        int length = s.length();
        if (length == 0) {
            return resultArrLists;
        }
        if (length == 1) {
            ArrayList<String> arrLista = new ArrayList<String>();
            arrLista.add(s);
            resultArrLists.add(arrLista);
            return resultArrLists;
        }

        String lastChar = s.substring(length - 1);
        ArrayList<ArrayList<String>> arrLists = partition(s.substring(0, length - 1));
        int arrListsSize = arrLists.size();

        for (int i = 0; i < arrListsSize; ++i) {
            ArrayList<String> arrayList = arrLists.get(i);

            int arrayListSize = arrayList.size();
            for (int j = 0; j < arrayListSize; ++j) {

                String str = arrayList.get(j).concat(lastChar);
                if (isPalindrome(str)) {
                    arrayList.set(j, str);
                    arrLists.set(i, arrayList);
                }
            }

        }
        return arrLists;
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
        System.out.println("done");
    }
}
