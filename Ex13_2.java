import java.util.ArrayList;
import java.util.Collections;

public class Ex13_2 {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(0.005);
        list.add(1);
        list.add(3);
        list.add(130);
        list.add(6);
        list.add(7);
        System.out.println(list.toString() + " - первочальный лист");

        shuffle(list);
        System.out.println(list.toString() + " - shuffled list ");
    }

    public static void shuffle(ArrayList<Number> list) {
        Collections.shuffle(list);
    }
}

