package com.problems.leetcode;

import java.util.LinkedList;

/**
 * Created by raja on 05/08/15.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"bare","area","arean"}));
    }

    public static String longestCommonPrefix(String[] words) {
        if(words==null || words.length==0){
            return "";
        }
        PrefixTrie dict = new PrefixTrie();
        for (String word : words){
            dict.insert(word);
        }
        PrefixTrieNode current = dict.root;

        StringBuilder sb = new StringBuilder("");
        while(!current.isLeaf &&current.childList!=null && current.childList.size()==1){
            sb.append(current.ch);
            current = current.childList.get(0);
        }
        sb.append(current.ch);
        return sb.toString().trim();
    }

}
