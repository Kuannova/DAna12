package Week8;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex17_1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> Addlist = new ArrayList<>();
        File file = new File("Exercise17_01.txt");
        try (
                Scanner forIn = new Scanner(file); ) {
            while (forIn.hasNext()) {
                Addlist.add(forIn.nextLine());
            }
        }

        for (int i = 0; i < 100; i++) {
            Addlist.add(((int)(Math.random() * 100)) + " ");
        }

        try (PrintWriter forOut = new PrintWriter(file);
        ) {
            for (String addWord: Addlist) {
                forOut.println(addWord);
            }
        }
    }
}
