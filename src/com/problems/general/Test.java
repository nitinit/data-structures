package com.problems.general;

import com.problems.thread.Thread1;

/**
 * Created by raja on 18/08/15.
 */
public class Test extends Thread1{

    public static Entry[] table = new Entry[16];

    public static void main(String[] args) {

        Test t = new Test();
        t.put("1", "One");
        t.put("2", "two");
        t.put("3", "three");
        t.put("4", "Four");
        System.out.println(t.get("1"));
        System.out.println(t.get("2"));
        System.out.println(t.get("3"));
        System.out.println(t.get("4"));

        t.remove("4");
        System.out.println(t.get("4"));


    }

    public Object get(Object key) {
        System.out.println(i);
//        Thread1 t1 = new Thread1();
//        t1.pri;
        print();
        if (key == null) {

        }
        int hash = key.hashCode();

        hash = hash & 15;
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (e.equals(key)) {
                return e.val;
            }
        }
        return null;
    }


    public void put(Object key, Object value) {

        int hash = key.hashCode();
        hash = hash & 15;
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (e.equals(key)) {
                e.val = value;
            }
        }
        // create new entry
        Entry e = table[hash];
        if (e == null) {
            table[hash] = new Entry(value, null, hash, key);
        } else {
            Entry newEntry = new Entry(value, null, hash, key);
            newEntry.next = e;
            table[hash] = newEntry;
        }
    }

    public void remove(Object key) {

        int hash = key.hashCode();
        hash = hash & 15;
        Entry start = table[hash];
        Entry previous = start;
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (e.equals(key)) {
                if (previous == e) {
                    table[hash] = e.next;
                } else {
                    previous.next = e.next;
                }
                break;
            }
            previous = e;
        }
    }


    class Entry {

        Object val;
        Entry next;
        int hashCode;
        Object key;

        Entry(Object val, Entry next, int hashCode, Object key) {
            this.val = val;
            this.next = next;
            this.hashCode = hashCode;
            this.key = key;

        }

        @Override
        public boolean equals(Object obj) {
            return obj.equals(key);
        }
    }
}
