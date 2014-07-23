package com.ran.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 *
 */

// two pointers
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		char[] array = s.toCharArray();
		int begin = 0;
		int end = array.length-1;
		
		while(begin < end){
			if(isAlphanumeric(array[begin])){
				if(isAlphanumeric(array[end])){
					if(array[begin] == array[end]){
						begin++;
						end--;
					}else{
						return false;
					}
				}else{
					end--;
				}
			}else{
				begin++;
			}
		}
		
		return true;
		
	
    }
	
	public boolean isAlphanumeric(char c){
		
		if(c < 'a' || c >'z'){
			if(c < '0' || c >'9'){
				return false;
			}
			return true;
		}
		return true;
			
		
	}
}
