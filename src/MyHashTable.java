public class MyHashTable<K, V> {
    private HashNode[] lst;
    private int[] counter;
    private final int capacity;
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
        capacity = 11;
        lst = new HashNode[capacity];
        counter = new int[capacity];
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        lst = new HashNode[capacity];
        counter = new int[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        HashNode newNode = new HashNode(key, value);
        int index = hash(key);

        if (lst[index] == null) {
            lst[index] = newNode;
        } else {
            HashNode currentNode = lst[index];

            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

        counter[index]++;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode currentNode = lst[index];

        while (currentNode != null) {
            if (currentNode.key == key) {
                return (V) currentNode.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode currentNode = lst[index];
        HashNode previousNode = null;

        if (currentNode.next == null) {
            lst[index] = null;
            size--;
            return (V) currentNode;
        }

        while (currentNode != null) {
            if (currentNode.key == key) {
                if (previousNode == null) {
                    lst[index] = null;
                    size--;
                    counter[index]--;
                    return (V) currentNode.value;
                }

                previousNode.next = currentNode.next;
                size--;
                counter[index]--;
                return (V) currentNode;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

//    public V delete(K key) {
//        int index = hash(key);
//
//        if (lst[index] == null) {
//            return null;
//        }
//
//        HashNode currentNode = lst[index];
//        HashNode previousNode;
//
//        while (currentNode != null) {
//            if (currentNode.key == key) {
//                previousNode.next = currentNode.next;
//                return (V) currentNode.value;
//            }
//
//            previousNode = currentNode;
//            currentNode = currentNode.next;
//        }
//
//        return null;
//    }


    public boolean contains(V value) {
        return yeuxdef(value) != null;
    }

    public K getKey(V value) {
        HashNode foundNode = yeuxdef(value);
        return foundNode == null ? null: (K) foundNode.key;
    }

    private HashNode yeuxdef(V value) {
        for (HashNode head: lst) {
            HashNode currentNode = head;

            while (currentNode != null) {
                if (currentNode.value == value) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            }
        }

        return null;
    }

    public void number_chains_in_buckets() {
        for (int i = 0; i < capacity; i++) {
            System.out.printf("The number of chains in %d bucket is %d\n", i, counter[i]);
        }
    }

    public double getLoadFactor() {
        return (double) size / capacity;
    }

    public double averageDeviation() {
        double sum = 0;
        double loadFactor = getLoadFactor();

        for (int i = 0; i < capacity; i++) {
            sum += Math.abs(counter[i] - loadFactor);
        }
        return sum / capacity;
    }


    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }
}
