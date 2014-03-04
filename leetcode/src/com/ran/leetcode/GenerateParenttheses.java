package com.ran.leetcode;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author taor
 * @date Dec 9, 2013
 */

public class GenerateParenttheses {

    public ArrayList<String> generateParenthesis(int n) {

        ArrayList<String> arrList = new ArrayList<String>();
        if (n == 0) {
            arrList.add("");
            return arrList;
        }

        if (n == 1) {
            arrList.add("()");
            return arrList;
        }

        arrList = generateParenthesis(n - 1);
        int tempSize = arrList.size();
        ArrayList<String> tempArrList = new ArrayList<String>();
        for (int j = 0; j < tempSize; j++) {
            String tempStr = arrList.get(j);
            StringBuffer sb = new StringBuffer(tempStr);
            int size = sb.length();
            tempArrList = new ArrayList<String>();
            for (int i = 0; i < size; ++i) {
                String str = sb.insert(i, "()").toString();
                if (!arrList.contains(str)) {
                    tempArrList.add(str);
                }
            }
        }
        arrList.addAll(tempArrList);
        return arrList;
    }

    public static void main(String[] args) {
        GenerateParenttheses gp = new GenerateParenttheses();
        ArrayList<String> arrList = gp.generateParenthesis(3);
        for (String s : arrList) {
            System.out.println(s);
        }
    }
}
