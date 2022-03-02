package com.arsatapathy.tree;

public class BST {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        three.left = two;
        three.right = five;
        two.left = one;
        five.left = four;
        five.right = six;

        /* Given below tree :
         *          3
         *         / \
         *        2   5
         *       /    / \
         *      1    4   6
         *
         * */

        System.out.println(isBST(three));
    }

    public static boolean isBST(Node root)
    {
        return healper(root,Integer.MAX_VALUE, Integer.MIN_VALUE);

    }

    public static boolean healper(Node root, int max, int min) {
        if (root == null) return true;
        if (root.data >= max || root.data <= min) return false;

        return healper(root.left, root.data, min) && healper(root.right, max, root.data);
    }


}
