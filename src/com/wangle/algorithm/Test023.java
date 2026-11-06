package com.huawei.alm.swbomtree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转二叉树
 */
public class Test023 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("===== 翻转前 =====");
        printBinaryTree(root);

        TreeNode flipped = invertTreeStack(root);

        System.out.println();
        System.out.println("===== 翻转后 =====");
        printBinaryTree(flipped);
    }

    /**
     * 树形打印（右子树用 └── 结尾，缩进清晰）
     */
    private static void printBinaryTree(TreeNode root) {
        printBinaryTree(root, "", true);
    }

    private static void printBinaryTree(TreeNode node, String prefix, boolean isRight) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + (isRight ? "└── " : "├── ") + node.val);
        printBinaryTree(node.left, prefix + (isRight ? "    " : "│   "), false);
        printBinaryTree(node.right, prefix + (isRight ? "    " : "│   "), true);
    }
    /**
     * 二叉树节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 翻转二叉树（递归版，LeetCode 226）
     * 交换当前节点左右子树后，递归翻转左右子树
     */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 翻转二叉树（栈版，等价递归但不受调用栈深度限制）
     */
    private static TreeNode invertTreeStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
