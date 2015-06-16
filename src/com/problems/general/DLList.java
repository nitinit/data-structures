package com.problems.general;

/**
 * Created by raja on 14/06/15.
 */
public class DLList {

    public DLLNode head;

    public DLList() {
        head = null;
    }

    public DLLNode addToList(String url) {

        if (head == null) {
            head = new DLLNode(url);
        } else {
            DLLNode temp;
            temp = head;
            head = new DLLNode(url);
            head.next = temp;
            temp.previous = head;
        }

        return head;

    }

    public void deleteFromList(DLLNode node) {

        if (node.previous != null && node.next != null) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            return;
        }
        //When the last Node is to be deleted
        else if (node.previous != null) {
            node.previous.next = null;
            return;
        }
        //will only happen when the first node is to be deleted
        else if (node.next != null) {
            head = node.next;
            node.next.previous = null;
            return;
        }
        //Only Node present
        else {
            head = null;
        }
    }

    public void printList() {

        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.url + " ");
            temp = temp.next;
        }

    }
}
