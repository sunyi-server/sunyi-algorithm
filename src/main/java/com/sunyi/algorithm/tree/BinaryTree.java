package com.sunyi.algorithm.tree;

import lombok.Data;

/**
 * <p>
 * 二叉树
 * </p>
 *
 * @author sunyi
 * @date 20200611
 */
public class BinaryTree {

    @Data
    static class Node {

        private int data;
        private Node leftChild;
        private Node rightChild;
    }
}
