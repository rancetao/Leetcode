package com.ran.leetcode;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation
 * sequence from start to end, such that:
 * <p>
 * Only one letter can be changed at a time Each intermediate word must exist in the dictionary For
 * example,
 * <p>
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As one shortest
 * transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * <p>
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All
 * words contain only lowercase alphabetic characters.
 *
 * @author rantao
 */
public class WordLadder {

    // native
    public int ladderLength(String start, String end, Set<String> dict) {

        if (null == dict || dict.size() == 0) {
            return 0;
        }
        char[] startArr = start.toCharArray();

        List<String> res = new ArrayList<>();

        for (char i = 'a'; i < 'z'; i++) {
            for (int j = 0; j < startArr.length; j++) {
                String temp = start.substring(0, j) + i + start.substring(j + 1);
                if (dict.contains(temp)) {
                    res.add(temp);
                    dict.remove(temp);
                } else {
                    continue;
                }
                if (temp.equals(end)) {
                    return res.size();
                }
            }
        }
        return 0;
    }

    // better way
    public int ladderLength2(String start, String end, Set<String> dict) {

        if (null == dict || dict.size() == 0) {
            return 0;
        }
        int len = start.length();
        Queue<String> workQ = new LinkedList<>();
        Queue<Integer> distanceQ = new LinkedList<>();

        workQ.add(start);
        distanceQ.add(1);

        while (workQ.size() > 0) {

            String node = workQ.poll();
            int distance = distanceQ.poll();
            if (node.equals(end)) {
                return distance;
            }

            for (char i = 'a'; i < 'z'; i++) {
                for (int j = 0; j < len; j++) {
                    String temp = node.substring(0, j) + i + node.substring(j + 1);
                    if (dict.contains(temp)) {
                        distanceQ.add(distance + 1);
                        workQ.add(temp);
                        dict.remove(temp);
                    }
                }
            }
        }

        return 0;
    }
}
