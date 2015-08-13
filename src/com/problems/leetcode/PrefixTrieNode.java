package com.problems.leetcode;

import java.util.LinkedList;

/**
 * Created by raja on 05/08/15.
 */
public class PrefixTrieNode {

    public char ch;
    LinkedList<PrefixTrieNode> childList;
    boolean isLeaf;
    int count;

    public PrefixTrieNode(char ch) {

        this.ch = ch;
        childList = new LinkedList<PrefixTrieNode>();
        isLeaf = false;
        count = 0;

    }

    public PrefixTrieNode subNode(char ch) {

        if (childList != null) {

            for (PrefixTrieNode node : childList) {

                if (node.ch == ch) {
                    return node;
                }

            }

        }

        return null;

    }
}
