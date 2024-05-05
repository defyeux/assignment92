public class BinarySearchTree<K extends Comparable<K>, V> {
    Node root;

    class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public BinarySearchTree() {
        root = null;
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);

        if (root == null) root = newNode;
        else {
            Node currentNode = root;
            Node parentNode;
            int n;

            while (true) {
                parentNode = currentNode;
                n = key.compareTo(currentNode.key);

                if (n > 0) {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        System.out.println(1);
                        parentNode.right = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.left;
                    if(currentNode == null) {
                        System.out.println(2);
                        parentNode.left = newNode;
                        return;
                    }
                }
            }
        }
    }


    public V get(K key) {
        return null;
    }

    public void delete(K key) {

    }

    public Iterable<K> iterator() {
        return null;
    }
}
