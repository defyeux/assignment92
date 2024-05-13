import java.util.Random;

public class TestForHashTable2 {
    public static void main(String[] args) {
        MyHashTable<Transiction, Integer> lst = new MyHashTable<>();
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            lst.put(new Transiction(RandomString.randomString(7), rand.nextInt(100000000)),
                    rand.nextInt(1000000));
        }

        lst.number_chains_in_buckets();
        System.out.println();
        System.out.println("The load factor is " + lst.getLoadFactor());
        System.out.println("The average deviation is " + lst.averageDeviation());
    }
}
