package com.ran.leetcode;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false "2e10" => true
 * 
 * @author RanceTao
 * 
 */
public class isNumeric {

    public boolean isNumber(String s) {
        if (s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        isNumeric is = new isNumeric();

    }
}
