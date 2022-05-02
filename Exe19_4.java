package Week9;

public class Exe19_4 {
    public static void main(String[] args) {
                        //0,1,2,3,4,5
        Integer[] list = {1,3,5,6,7,8};
        System.out.println(linearSearch(list, 1)); //0
        System.out.println(linearSearch(list, 3));  //1
        System.out.println(linearSearch(list, 6));  //3
        System.out.println(linearSearch(list, 8));  //5
    }
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i<list.length; i++) {
            if (list[i].equals(key)) {
                return i;
            }
        }
        return 0;
    }
}
