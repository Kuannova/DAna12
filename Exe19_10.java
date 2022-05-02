package Week9;

import java.util.ArrayList;

public class Exe19_10 {
    public static void main(String[] args) {
        ArrayList<Integer> nmList = new ArrayList<>();
        nmList.add(84);
        nmList.add(403);
        nmList.add(88);
        nmList.add(705);
        nmList.add(69);
        System.out.println("Max number is: "+ max(nmList));
    }
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E maxNum = list.get(0);
        for (E san: list){
            if(san.compareTo(maxNum)>0)
                maxNum =san;
        }
        return maxNum;
    }
}
