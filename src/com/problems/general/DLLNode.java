package com.problems.general;

/**
 * Created by raja on 14/06/15.
 */
public class DLLNode {

    public String url;
    public DLLNode next;
    public DLLNode previous;

    public DLLNode(String url) {

        this.url = url;
        next = null;
        previous = null;

    }
}
