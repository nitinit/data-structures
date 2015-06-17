package com.problems.general;

/**
 * Created by raja on 16/06/15.
 */
public class CloneLinkedListWithNextAndRandomPointer {

    public static void main(String[] args){

        LinkedList original = new LinkedList(1);
        original.next = new LinkedList(2);
        original.next.next = new LinkedList(3);

        original.next.next.next = new LinkedList(4);

        original.next.next.next.next = new LinkedList(5);

        original.arbitrary = original.next.next.next;
        original.next.arbitrary = original.next.next.next.next;
        original.next.next.arbitrary = original;
        original.next.next.next.arbitrary = original.next.next;
        original.next.next.next.next.arbitrary = original.next;

        LinkedList header = original;
        while(header!=null){
            LinkedList copyOfOriginal = new LinkedList(header.value);
            copyOfOriginal.next = header.next;
            header.next = copyOfOriginal;
            header=header.next.next;
        }
        header = original;
        while(header!=null && header.next!=null){
            header.next.arbitrary = header.arbitrary.next;
            header=header.next.next;
        }
        header = original;
        LinkedList copy = original.next;
        LinkedList copy1 = original.next;
        while(header.next!=null && copy.next!=null){
            header.next = header.next.next;
            copy.next = copy.next.next;

        }

        while (copy1!=null){
            System.out.println(copy1.value);
//            System.out.println(copy1.arbitrary.value);
//            System.out.println(copy1.next.value);
            copy1=copy1.next;
        }

        while (original!=null){
            System.out.println(original.value);
//            System.out.println(original.arbitrary.value);
//            System.out.println(original.next.value);
            original = original.next;
        }

    }
}

class LinkedList {
    int value;
    LinkedList next;
    LinkedList arbitrary;

    LinkedList(int val){
        value=val;
    }
}
