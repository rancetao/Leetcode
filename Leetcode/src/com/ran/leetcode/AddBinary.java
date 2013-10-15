package com.ran.leetcode;

public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * 
     * For example, a = "11" b = "1" Return "100".
     */

    public String addBinary(String a, String b) {

        // Note: The Solution object is instantiated only once and is reused by each test case.
        int carry = 0;
        String sumStr = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int bitSum = 0;
            if (i >= 0 && j >= 0) {
                bitSum = Integer.parseInt(a.substring(i, i + 1)) + Integer.parseInt(b.substring(j, j + 1)) + carry;
                i--;
                j--;
            }
            else if (i >= 0) {
                bitSum = Integer.parseInt(a.substring(i, i + 1)) + carry;
                i--;
            }
            else {
                bitSum = Integer.parseInt(b.substring(j, j + 1)) + carry;
                j--;
            }
            carry = bitSum / 2;
            int bit = bitSum % 2;
            sumStr = bit + sumStr;
        }
        if (carry == 1) {
            sumStr = carry + sumStr;
        }
        return sumStr;
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub

    }

}
