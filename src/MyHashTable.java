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
        lst = new HashNode[capacity];
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        lst = new HashNode[capacity];
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
                previousNode.next = currentNode.next;
                size--;
                return (V) currentNode;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

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
}
