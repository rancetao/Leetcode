package com.ran.leetcode;

/**
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * <p>
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1,000
 *
 * @author taor
 * @since Oct 18, 2013
 */
public class IntegerToRoman {

    // not a common solution
    public String intToRoman(int num) {

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int times = num / nums[i];
            num -= nums[i] * times;
            while (times > 0) {
                result.append(symbols[i]);
                --times;
            }
            ++i;
        }
        return result.toString();
    }

    // common solution
    public String commonIntToRoman(int num) {

        return null;
    }
}
