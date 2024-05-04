public class MyHashTable<K, V> {
    private HashNode[] lst;
    private int capacity = 11;
    private int size;

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashTable() {

    }

    public MyHashTable(int capacity) {

    }

    private int hash(K key) {
        return - 1;
    }

    public void put(K key, V value) {

    }

    public V get(K key) {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    public boolean contains(V value) {
        return false;
    }

    public K getKey(V value) {
        return null;
    }
}
