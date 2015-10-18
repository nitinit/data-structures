package com.problems.general;


import com.problems.geeksforgeeks.trees.*;
import com.problems.geeksforgeeks.trees.TreeNode;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by raja on 18/10/15.
 */
public class PrintSpecificNodesAtEveryLevelCalculatedByGivenFunction {


    public static void main(String[] args) {

        //                      100
        //           50                  150
        //               \
        // 25              75     140         200
        //      30      70    80
        //          35
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(150);

        root.right.right = new TreeNode(200);
        root.right.left = new TreeNode(140);
        root.left.right = new TreeNode(75);
        root.left.right.left = new TreeNode(70);
        root.left.right.right = new TreeNode(80);

        root.left.left = new TreeNode(25);
        root.left.left.right = new TreeNode(30);
        root.left.left.right.right = new TreeNode(35);

        print(root, 3, 3);

        // or
        print(root, 3, fn(3));

    }

    public static int fn(int level) {

        if (level == 1) {
            return 1;
        }
        if (level == 2) {
            return 2;
        }
        int squareOfFn1 = fn(level - 1);
        int squareOfFn2 = fn(level - 2);
        return squareOfFn1 * squareOfFn1 - squareOfFn2 * squareOfFn2;
    }

    /**
     * @param root
     * @param level
     * @param n     calculated using function f(n)
     *              f(n)= square(f(n-1)) - square(f(n-2)); for n>2
     *              f(1) = 1;
     *              f(2) = 2;
     *              Here n is the level of an n-array tree. f(n)=1,2,3,5,16...
     */
    public static void print(com.problems.geeksforgeeks.trees.TreeNode root, int level, int n) {

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root);

        int currentLevel = 1;
        while (!q1.isEmpty() || !q2.isEmpty()) {

            if (deleteNode(level, n, q1, currentLevel)) return;

            while (!q1.isEmpty()) {
                TreeNode node = q1.remove();
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            currentLevel++;
            if (deleteNode(level, n, q2, currentLevel)) return;
            while (!q2.isEmpty()) {
                TreeNode node = q2.remove();
                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
            }
            currentLevel++;

        }

    }

    private static boolean deleteNode(int level, int n, Queue<TreeNode> q, int currentLevel) {
        if (currentLevel == level) {
            if (q.size() >= n) {
                for (int i = 1; i < n; i++) {
                    q.remove();
                }
                TreeNode node = q.remove();
                System.out.println("deleted : " + node.value);
                node.deleted = true;
                return true;
            } else {
                int nodeNumberToBeDeleted = q.size() % n;
                for (int i = 1; i < nodeNumberToBeDeleted; i++) {
                    q.remove();
                }
                TreeNode node = q.remove();
                System.out.println("deleted : " + node.value);
                node.deleted = true;
                return true;
            }
        }
        return false;
    }
}
