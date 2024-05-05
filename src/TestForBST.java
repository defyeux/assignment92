public class TestForBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree();
        tree.put(3, 3);
        tree.put(4, 4);
        tree.put(5, 5);
        System.out.println(tree.root.key);
        System.out.println(tree.root.left.key);
        System.out.println(tree.root.right.key);
    }
}
