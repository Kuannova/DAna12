package Week11;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Exe21_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter random integers.\n Enter 0 when finished: ");

        HashMap<Integer, Integer> tabuKerek = new HashMap<>();
        int sany;
        while ((sany = scanner.nextInt()) != 0) {
            if (!tabuKerek.containsKey(sany))
                tabuKerek.put(sany, 1);
            else
                tabuKerek.put(sany, tabuKerek.get(sany) + 1);
        }
        int max = Collections.max(tabuKerek.values());
        HashMap<Integer, Integer> occured = new HashMap<>();
        tabuKerek.forEach((key, value) -> { if (value >= max)
                occured.put(key, value);
        });
        System.out.println("Numbers with the max occurrences: ");
        occured.forEach((key, value) ->
                System.out.println(key + " occurred " + value + " times"));
    }
}