package com.arsatapathy.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LeftViewTree {

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

        /* Given below tree :
        *          3
        *         / \
        *        2   5
        *           / \
        *          4   6
        *
        * left view would be
        *
        * */

        System.out.println(leftView(three, 0, new HashSet<>(), new ArrayList<>()));
    }


    public static ArrayList<Integer> leftView(Node root, int level, Set<Integer> visited, ArrayList<Integer> list) {


        if (root == null) return list;

        if (!visited.contains(level)) {
            list.add(root.data);
            visited.add(level);
        }

        leftView(root.left, level + 1, visited, list);
        leftView(root.right, level + 1, visited, list);

        return list;
    }

}


