import java.util.ArrayList;
import java.util.Collections;

public class Ex13_3 {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(999);
        list.add(21);
        list.add(4);
        list.add(7);
        list.add(12.2);
        list.add(12.5);
        System.out.println(list.toString() + " - original");

        sort(list);
        System.out.println(list.toString() + " - sort list");
    }
    public static void sort(ArrayList<Number> list) {
        for (int i = 0; i < list.size(); i++) {                                     //selection
            Number posledny = list.get(i);
            int a = i;

            for (int j = i; j < list.size(); j++) {
                if (posledny.intValue() > list.get(j).intValue()) {
                    posledny = list.get(j);
                    a = j;
                }
            }
            if (a != i) {
                list.set(a, list.get(i));
                list.set(i, posledny);
            }
        }
    }
}
