package Week11;

import java.util.*;

public class Exe21_1 {
    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");


        LinkedHashSet<String> unionSet = new LinkedHashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union: " + unionSet);

        LinkedHashSet<String> difference = new LinkedHashSet<>(set1);
        difference.removeAll(set2);

        System.out.println("Difference of sets: " + difference);

        LinkedHashSet<String> intersection = (LinkedHashSet<String>) set1.clone();
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
    }
}
