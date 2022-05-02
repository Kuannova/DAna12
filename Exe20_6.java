package Week10;

import java.util.*;
public class Exe20_6 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i);
        }
        long start = System.currentTimeMillis();
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("traverse the list using an iterator " + (end - start) + " mls");



        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            linkedList.add(i);
            linkedList.get(i);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("get(index) method :" + (end2 - start2) + " mls");
    }
}