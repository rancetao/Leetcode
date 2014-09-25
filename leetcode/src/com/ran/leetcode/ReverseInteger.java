package com.ran.leetcode;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * <p>
 * Have you thought about this? Here are some good questions to ask before coding. Bonus points for
 * you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have
 * to re-design the function (ie, add an extra parameter).
 *
 * @author RanceTao
 */
public class ReverseInteger {

    public static void main(String[] args) {

        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-123));
    }

    public int reverse(int x) {

        String s = String.valueOf(x);
        String sign = "";
        if (s.substring(0, 1).equalsIgnoreCase("+") || s.substring(0, 1).equalsIgnoreCase("-")) {
            sign = s.substring(0, 1);
            s = s.substring(1, s.length());
            s = s.concat(sign);
        }

        StringBuffer sb = new StringBuffer(s);
        sb = sb.reverse();

        return Integer.parseInt(sb.toString());
    }
}
