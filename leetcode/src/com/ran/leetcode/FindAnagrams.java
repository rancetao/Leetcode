package com.ran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author RanceTao
 * 
 */
public class FindAnagrams {


    public List<String> FindAnagrams(String[] strs) {

        List<String> list = new ArrayList<String>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            Set<String> keySet = map.keySet();
            ArrayList<String> tempList = map.get(key);
            if (keySet.contains(key)) {

                tempList.add(s);
            } else {
                tempList = new ArrayList<String>();
                tempList.add(s);

            }
            map.put(key, tempList);
        }

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            if (map.get(s).size() > 1) {
                list.addAll(map.get(s));
            }
        }
        return list;
    }

    public static void main(String args[]) {
        FindAnagrams fa = new FindAnagrams();
        String[] strs = {"", ""};
        fa.FindAnagrams(strs);
    }

}
