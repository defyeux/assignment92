import java.util.Random;

public class TestForHastTable1 {
    public static void main(String[] args) {
        MyHashTable<Integer, String> lst = new MyHashTable<>(13);
        lst.put(10, "333-333");
        lst.put(7, "444-444");
        lst.put(23, "555-555");
        System.out.println("The value of the element with the key = 7 is " + lst.get(7));
        System.out.printf("The element %s contain in lst\n", lst.contains("333-333") ? "does": "doesn't");
        System.out.println(lst.getKey("333-333"));
        System.out.println(lst.getKey("10000000"));
        System.out.println(lst);
        System.out.println("The value of the element with the key = 10 is " + lst.remove(10));
        System.out.println("This element after removing " + lst.get(10));
    }


}
