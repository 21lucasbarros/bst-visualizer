package com.lucasbarros.model;

public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
