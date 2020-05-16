package homework.Tree;


public class TestBTree {

    public static void main(String[] args) {
        /*BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);

        binaryTree.remove(4);

        binaryTree.add(8);

        System.out.println(binaryTree.getSize());
        binaryTree.midIterator(binaryTree.getRoot());*/

     /* BalanceBinaryTree<Integer> balanceBinaryTree = new BalanceBinaryTree<>();
        balanceBinaryTree.add(1);
        balanceBinaryTree.add(2);
        balanceBinaryTree.add(3);
        balanceBinaryTree.add(4);
        balanceBinaryTree.add(5);
        balanceBinaryTree.add(6);
        balanceBinaryTree.add(7);

        balanceBinaryTree.remove(4);

        System.out.println(balanceBinaryTree.getSize());

        balanceBinaryTree.midIterator(balanceBinaryTree.getRoot());*/


        BinaryTreeForBalance<Integer> balanceBinaryTree = new BinaryTreeForBalance<>();
        balanceBinaryTree.add(1);
        balanceBinaryTree.add(2);
        balanceBinaryTree.add(3);
        balanceBinaryTree.add(4);
        balanceBinaryTree.add(5);
        balanceBinaryTree.add(6);
        balanceBinaryTree.add(7);

        System.out.println(balanceBinaryTree.getSize());

        balanceBinaryTree.remove(4);

        System.out.println(balanceBinaryTree.getSize());

        balanceBinaryTree.midIterator(balanceBinaryTree.getRoot());
    }

}
