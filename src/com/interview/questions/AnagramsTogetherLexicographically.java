package com.interview.questions;

import java.util.Collections;
import java.util.*;

/**
 * Created by raja on 13/10/15.
 */
public class AnagramsTogetherLexicographically {
    /**
     * Takes an array of String {@param s} and prints anagrams in groups where the groups
     * are arranged lexicographically and the strings within each group are also arranged
     * lexicographically.
     *
     * @param s
     */
    public static void printAnagramsTogether(String[] s) {

        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        TreeSet<List<String>> treeSet = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof List<?> && o2 instanceof List<?>) {
                    return ((List<String>) o1).get(0).compareTo(((List<String>) o2).get(0));
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < s.length; i++) {
            String removeSpaces = s[i].replaceAll("\\s+", "");
            char[] chars = removeSpaces.toCharArray();
            Arrays.sort(chars);

            List<Integer> indexes = hashMap.get(String.valueOf(chars));
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            hashMap.put(String.valueOf(chars), indexes);
        }

        for (Map.Entry<String, List<Integer>> entry : hashMap.entrySet()) {

            List<String> anagrams = new ArrayList<>();

            for (int i = 0; i < entry.getValue().size(); i++) {
                anagrams.add(s[entry.getValue().get(i)]);
            }

            Collections.sort(anagrams); // arrange anagrams lexicographically within a single line
            treeSet.add(anagrams); // sort the entire output lexicographically
        }

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Take list of strings from console and print anagrams in groups.
     *
     * @param a
     */
    public static void main(String a[]) {
        Scanner in = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        String s;
        // you should use in.hasNextLine()
        while (!(s = in.nextLine()).trim().equals("")) {
            strings.add(s);
        }
        printAnagramsTogether(strings.toArray(new String[0]));
    }
}
