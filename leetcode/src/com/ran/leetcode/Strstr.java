package com.ran.leetcode;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 * @author RanceTao
 * 
 */
public class Strstr {

	// brute force
	public String strStr(String s1, String s2) {

		if (s2 == null)
			return null;

		int s1Len = s1.length();
		int s2Len = s2.length();

		if (s1Len == 0 && s2Len == 0)
			return s2;

		if (s2Len > s1Len)
			return null;

		for (int i = 0; i < s1Len - s2Len + 1; i++) {
			int temp = i;
			boolean flag = true;
			for (int j = 0; j < s2Len; j++) {
				if (s1.charAt(i + j) != s2.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				return s1.substring(temp);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Strstr s = new Strstr();
		s.strStr("mississippi", "a");
	}
}
