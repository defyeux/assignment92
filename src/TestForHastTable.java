public class TestForHastTable {
    public static void main(String[] args) {
        MyHashTable<Integer, String> lst = new MyHashTable<>(13);
        lst.put(10, "333-333");
        lst.put(7, "444-444");
        lst.put(23, "555-555");
        System.out.println(lst.get(7));
        System.out.println(lst.contains("333-333"));
        System.out.println(lst.getKey("333-333"));
        System.out.println(lst.getKey("10000000"));
    }
}
