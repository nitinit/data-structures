package com.problems.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * 
 * @author raja
 *
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abecbegeh"));
	}



	public static int lengthOfLongestSubstring(String s) {
		if(s.isEmpty()){
			return 0;
		}
		int max = 1;
		int prevIndex = 0;
		int currentLen = 1;
		int[] visited = new int[256];
		for (int i = 0; i < 256; i++) {
			visited[i] = -1;
		}
		visited[s.charAt(0)] = 0;
		for (int j = 1; j < s.length(); j++) {
			prevIndex = visited[s.charAt(j)];

			if (prevIndex == -1 || j - currentLen > prevIndex) {
				currentLen++;
			} else {
				if (currentLen > max) {
					max = currentLen;
				}
				currentLen = j - prevIndex;
			}
			visited[s.charAt(j)] = j; // update the index of current character

		}
		if (currentLen > max) {
			max = currentLen;
		}

		return max;
	}
}
