public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
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

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }


    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        int n = key.compareTo(node.key);
        if (node == null) {
            return null;
        }
        if (n > 0) {
            return get(node.left, key);
        }
        if (n < 0) {
            return get(node.right, key);
        }

        return node.value;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        int n = key.compareTo(node.key);
        if (node == null) {
            return null;
        }
        if (n > 0) {
             node.left = delete(node.left, key);
        } else if (n < 0) {
            node.right = delete(node.right, key);
        } else if (n == 0) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node smallestValue = findSmallestValue(node.left);
            node.key = smallestValue.key;
            node.value = smallestValue.value;
            node.left = delete(node.right, key);
         }

        return node;
    }

    private Node findSmallestValue(Node node) {
        return node.right == null ? root: findSmallestValue(node.right);
    }


    public Iterable<K> iterator() {
        return null;
    }
}
