package com.problems.general;

/**
 * Created by raja on 14/06/15.
 */
public class UTrie {

    public UTrieNode root;
    DLList list = new DLList();

    public UTrie() {

        root = new UTrieNode(' ');

    }

    public void insert(String url) {
        UTrieNode node;
        if ((node = search(url)) != null) {
            System.out.println("Already present - " + url);
            if (node.dllNode == null) {
                System.out.println("dllNode is null");
            } else {
                System.out.println("dllNode is present");
                list.deleteFromList(node.dllNode);
                node.dllNode = null;
            }
        } else {

            System.out.println("Creating new Trie for " + url);

            UTrieNode current = root;

            for (char ch : url.toCharArray()) {

                UTrieNode subNode = current.subNode(ch);

                if (subNode == null) {
                    current.childNodes.add(new UTrieNode(ch));
                    current = current.subNode(ch);
                } else {
                    current = subNode;
                }

                current.count++;

            }

            current.isLeaf = true;
            current.dllNode = list.addToList(url);

        }
        list.printList();
        System.out.println("\n");
    }

    public UTrieNode search(String url) {

        UTrieNode current = root;

        for (char ch : url.toCharArray()) {

            UTrieNode subNode = current.subNode(ch);

            if (subNode == null) {
                return null;
            } else {
                current = subNode;
            }

        }

        if (current.isLeaf) {
            return current;
        } else {
            return null;
        }

    }
}
