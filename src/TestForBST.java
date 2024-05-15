public class TestForBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree();
        tree.put(3, 4);
        tree.put(4, 4);
        tree.put(5, 5);
        tree.put(2, 2);
        tree.inOrder();
        System.out.println(tree.get(3));
        tree.delete(3);
        tree.inOrder();
        System.out.println(tree.size());
    }
}

