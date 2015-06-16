package com.problems.general;

/**
 * Created by raja on 14/06/15.
 */
public class FindUniqueURL {

    public static void main(String[] args) {

        String[] urls = new String[]{ "http://www.google.com/",
                "http://www.yahoo.com/",
                "http://www.amazon.com/",
                "http://www.apache.com/",
                "http://www.google.com/",
                "http://www.mycar.com/",
                "http://www.microsoft.com/",
                "http://www.casandra.com/",
                "http://www.apache.com/",
                "http://www.google.com/",
                "http://www.oracle.com/",
                "http://www.yahoo.com/",
                "http://www.oracle.com/",
                "http://www.facebook.com/",
                "http://www.pandora.com/",
                "http://www.microsoft.com/",
                "http://www.google.com/",
                "http://www.mycar.com/",
                "http://www.amazon.com/",
                "http://www.apple.com/",
        };

        UTrie uTrie = new UTrie();

        for (String url : urls) {
            uTrie.insert(url);
        }

        System.out.println("\nFinal unique list is -: ");
        uTrie.list.printList();

    }
}
