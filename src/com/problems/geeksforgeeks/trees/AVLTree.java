package com.problems.geeksforgeeks.trees;

/**
 * http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * <p/>
 * Created by raja on 18/07/15.
 */
public class AVLTree {

    public static void main(String[] args) {
        TreeNode root = null;
         /* Constructing tree given in the above figure */
//        root = insert(root, 10);
//        root = insert(root, 20);
//        root = insert(root, 30);
//        root = insert(root, 40);
//        root = insert(root, 50);
//        root = insert(root, 25);
            /* The constructed AVL Tree would be
                    30
                   /  \
                 20   40
                /  \     \
               10  25    50
          */
        root = insert(root, 9);
        root = insert(root, 5);
        root = insert(root, 10);
        root = insert(root, 0);
        root = insert(root, 6);
        root = insert(root, 11);
        root = insert(root, -1);
        root = insert(root, 1);
        root = insert(root, 2);


        /* The constructed AVL Tree would be
                    9
                   /  \
                  1    10
                /  \     \
               0    5     11
              /    /  \
             -1   2    6
         */

        System.out.printf("In order traversal of the constructed AVL tree is \n");
        TreeTraversal.inorderTraversal(root);

        System.out.println();
        System.out.printf("Level order traversal of the constructed AVL tree is \n");
        LevelOrderTreeTraversal.levelOrderTraversal(root);
        System.out.println();
        root = delete(root, 10);

            /* The AVL Tree after deletion of 10
                    1
                   /  \
                  0    9
                /     /  \
               -1    5     11
                   /  \
                  2    6
            */
        System.out.printf("In order traversal of the constructed AVL tree is \n");
        TreeTraversal.inorderTraversal(root);

        System.out.println();
        System.out.printf("Level order traversal of the constructed AVL tree is \n");
        LevelOrderTreeTraversal.levelOrderTraversal(root);
    }

    public static TreeNode delete(TreeNode node, int key) {

        if (node==null){
            return node;
        }

        if (key<node.value){
            node.left = delete(node.left,key);
        }else if (key>node.value){
            node.right = delete(node.right,key);
        }else{

            if(node.left==null || node.right==null){

                TreeNode temp = node.left==null ? node.right : node.left;
                node =temp;

            }else {
                TreeNode temp = minValueNode(node.right);
                node.value = temp.value;
                node.right = delete(node.right,temp.value);
            }

        }
        // If the tree had only one node then return
        if (node == null) {
            return node;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalanceFactor(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && getBalanceFactor(node.left) < 0)
        {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && getBalanceFactor(node.right) > 0)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * Given a non-empty binary search tree, return the node with minimum
     * key value found in that tree. Note that the entire tree does not
     * need to be searched.
     */
    private static TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;

          /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public static TreeNode insert(TreeNode node, int key) {

        if (node == null) {
            return newNode(key);
        }

        if (key < node.value) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalanceFactor(node);

        // left left case
        if (balance > 1 && node.left != null && key < node.left.value) {
            return rightRotate(node);
        }

        // right right case
        if (balance < -1 && node.right != null && key > node.right.value) {
            return leftRotate(node);
        }
        // left right case
        if (balance > 1 && node.left != null && key > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right left case
        if (balance < -1 && node.right != null && key < node.right.value) {
            node.left = rightRotate(node.left);
            return leftRotate(node);
        }

        return node;
    }

    private static TreeNode leftRotate(TreeNode node) {
        TreeNode right = node.right;
        TreeNode rightLeft = right.left;

        right.left = node;
        node.right = rightLeft;

        right.height = Math.max(right.left != null ? right.left.height : 0, right.right != null ? right.right.height : 0) + 1;
        node.height = Math.max(node.left != null ? node.left.height : 0, node.right != null ? node.right.height : 0) + 1;
        return right;
    }

    private static TreeNode rightRotate(TreeNode node) {
        TreeNode left = node.left;
        TreeNode leftRight = left.right;

        left.right = node;
        node.left = leftRight;

        left.height = Math.max(left.left != null ? left.left.height : 0, left.right != null ? left.right.height : 0) + 1;
        node.height = Math.max(node.left != null ? node.left.height : 0, node.right != null ? node.right.height : 0) + 1;
        return left;
    }

    private static TreeNode newNode(int key) {
        TreeNode node = new TreeNode(key);
        node.height = 1;
        return node;
    }

    private static int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private static int getBalanceFactor(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }
}
