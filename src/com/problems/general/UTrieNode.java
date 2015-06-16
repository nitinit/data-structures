package com.problems.general;

import java.util.LinkedList;

/**
 * Created by raja on 14/06/15.
 */
public class UTrieNode {

    public LinkedList<UTrieNode> childNodes;
    public DLLNode dllNode;
    char content;
    boolean isLeaf;
    int count;

    public UTrieNode(char content) {

        this.content = content;
        isLeaf = false;
        count = 0;
        childNodes = new LinkedList<UTrieNode>();
        dllNode = null;

    }

    /**
     *  Returns the sub node of current node which contains character 'c'
     *
     * @param content
     * @return
     */
    public UTrieNode subNode(char content) {

        if (childNodes != null) {

            for (UTrieNode uTrieNode : childNodes) {

                if (uTrieNode.content == content) {
                    return uTrieNode;
                }

            }

        }

        return null;
    }
}
