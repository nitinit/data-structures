package com.problems.leetcode;

/**
 * Created by raja on 05/08/15.
 */
public class PrefixTrie {

    public PrefixTrieNode root;

    public PrefixTrie() {

        root = new PrefixTrieNode(' ');

    }

    public void insert(String word) {

        if (search(word)) {
            System.out.println("Word has already been added");
            return;
        }

        PrefixTrieNode current = root;

        for (char ch : word.toCharArray()) {

            PrefixTrieNode subNode = current.subNode(ch);

            if (subNode != null) {
                current = subNode;
            } else {
                current.childList.add(new PrefixTrieNode(ch));
                current = current.subNode(ch);
            }

            current.count++;

        }

        current.isLeaf = true;

    }

    private boolean search(String word) {

        PrefixTrieNode current = root;

        for (char ch : word.toCharArray()) {

            PrefixTrieNode subNode = current.subNode(ch);

            if (subNode == null) {
                return false;
            } else {
                current = subNode;
            }

        }

        return current.isLeaf;


    }

    public String longestPrefixMatching(String word) {

        int maxLen = 0;
        StringBuilder utilString = new StringBuilder();
        String longestPrefix = "";

        PrefixTrieNode current = root;

        for (char ch : word.toCharArray()) {

            PrefixTrieNode subNode = current.subNode(ch);

            if (subNode == null) {
                //maxlen ==0 and subnode null only when no match
                if (maxLen == 0) {
                    return "";
                } else {
                    break;
                }

            } else {
                current = subNode;
                //utilString only to append the current node and will become prefix only if a leaf node is found
                utilString.append(ch);
                if (current.isLeaf) {
                    maxLen++;
                    longestPrefix = utilString.toString();
                }
            }

        }

        return longestPrefix;


    }

}
