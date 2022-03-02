package com.arsatapathy.tree;

public class MyTree {

    public static void main(String[] args) {
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        three.left = two;
        five.left = four;
        five.right = six;
        three.right = five;

        Tree tree = new Tree();

        tree.leftView(three, 1);
    }
}

class Tree {

    private int maxLevel = 0;

    public void leftView(Node root, int level) {
        if (root == null) return;

        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }

        leftView(root.left, level + 1);
        leftView(root.right, level + 1);

    }
}

/*
*           3
*        2    5
*           4    6
* */

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
