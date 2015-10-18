package com.problems.geeksforgeeks.trees;

/**
 * Created by raja on 17/10/15.
 */
public class BoundaryTraversal2 {

    public static boolean preOrderLeft(TreeNode root, boolean rleaf) {
        if (root == null) {
            return rleaf;
        }

        if (root.right == null && root.left == null) {
            System.out.print(root.value + " ");
            rleaf = false;
            return rleaf;
        }

        if (rleaf) {
            System.out.print(root.value + " ");
        }

        rleaf = preOrderLeft(root.left, rleaf);
        rleaf = preOrderLeft(root.right, rleaf);

        return rleaf;
    }

    public static boolean postOrderRight(TreeNode root, boolean rleaf) {
        if (root == null) {
            return rleaf;
        }

        boolean rleafnow = rleaf;

        rleaf = postOrderRight(root.right, rleaf);
        rleaf = postOrderRight(root.left, rleaf);

        if (root.right == null && root.left == null) {
            System.out.print(root.value + " ");
            rleaf = false;
            return rleaf;
        }

        if (rleafnow) {
            System.out.print(root.value + " ");
        }

        return rleaf;


    }

    public static void bTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            System.out.print(root.value);
            return;
        }
        while (root.left != null || root.right != null) {
            if (root.left != null) {
                System.out.print(root.value + " ");
                preOrderLeft(root.left, true);
                postOrderRight(root.right, true);
                break;
            } else {
                System.out.print(root.value + " ");
                root = root.right;
            }
        }
    }

    public static void main(String args[]) {

        //                      100
        //           50                  150
        //               \
        // 25              75     140         200
        //      30      70    80
        //          35
        TreeNode bt = new TreeNode(100);
        bt.left = new TreeNode(50);
        bt.right = new TreeNode(150);

        bt.right.right = new TreeNode(200);
        bt.left.right = new TreeNode(75);
        bt.left.right.left = new TreeNode(70);
        bt.left.right.right = new TreeNode(80);

        bt.left.left = new TreeNode(25);
        bt.left.left.right = new TreeNode(30);
        bt.left.left.right.right = new TreeNode(35);

        bTraversal(bt);
        System.out.println(bt.hashCode());
        printBoundary(bt);
    }

    private static void printBoundary(TreeNode rootNode) {
        if (rootNode != null) {
            printRoot(rootNode);

            if (rootNode.left != null)
                printLeft(rootNode.left);

            printLeaf(rootNode);

            if (rootNode.right != null)
                printRight(rootNode.right);
        }
    }

    private static void printRoot(TreeNode rootNode) {
        System.out.print(rootNode.value + " ");
    }

    private static void printLeft(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.left == null && rootNode.right == null) {
            return;
        }

        System.out.print(rootNode.value + " ");

        if (rootNode.left == null) {
            printLeft(rootNode.right);
        } else {
            printLeft(rootNode.left);
        }
    }

    private static void printLeaf(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }

        if (rootNode.left == null && rootNode.right == null) {
            System.out.print(rootNode.value + " ");
            return;
        }
        printLeaf(rootNode.left);
        printLeaf(rootNode.right);
    }

    private static void printRight(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.left == null && rootNode.right == null) {
            return;
        }

        if (rootNode.right == null) {
            printRight(rootNode.left);
            System.out.print(rootNode.value + " ");

        } else {
            printRight(rootNode.right);
            System.out.print(rootNode.value + " ");
        }
    }
}
