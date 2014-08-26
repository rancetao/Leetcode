package com.ran.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author taor
 * @date Dec 9, 2013
 */

public class GenerateParenttheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
            return result;
        }

        if (n == 1) {
            result.add("()");
            return result;
        }

        result = generateParenthesis(n - 1);
        ArrayList<String> returnList = new ArrayList<String>();

        int tempSize = result.size();
        for (int j = 0; j < tempSize; j++) {
            String tempStr = result.get(j);
            StringBuffer sb = new StringBuffer(tempStr);
            int size = sb.length();
            for (int i = 0; i < size; ++i) {
                String str = sb.insert(i, "()").toString();
                sb = new StringBuffer(tempStr);
                if (!returnList.contains(str)) {
                    returnList.add(str);
                }
            }
        }

        return returnList;
    }



    public static ArrayList<String> generateParenthesis2(int n) {
        ArrayList<String> list = new ArrayList<String>();
        rec(n, 0, 0, "", list);
        return list;
    }

    public static void rec(int n, int left, int right, String s, ArrayList<String> list) {
        // invariant必须满足左括号数目要大等于右括号数目
        if (left < right) {
            return;
        }

        // 如果左右括号数目相等则添加到list
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        // 左括号已满，只能添加右括号
        if (left == n) {
            rec(n, left, right + 1, s + ")", list);
            return;
        }

        rec(n, left + 1, right, s + "(", list); // 继续添加左括号
        rec(n, left, right + 1, s + ")", list); // 继续添加右括号
    }

    public static void main(String[] args) {
        GenerateParenttheses gp = new GenerateParenttheses();
        List<String> arrList = gp.generateParenthesis(2);
        for (String s : arrList) {
            System.out.println(s);
        }
    }
}
