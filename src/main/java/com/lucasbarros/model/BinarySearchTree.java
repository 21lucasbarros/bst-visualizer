package com.lucasbarros.model;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    //inserir (la ele)
    public boolean insert(int value) {
        if(contains(value)) return false;
        root = insert(root, value);
        return true;
    }

    private Node insert(Node node, int value) {
        if(node == null) return new Node(value);
        if(value < node.value) node.left = insert(node.left, value);
        else node.right = insert(node.right, value);
        return node;
    }

    //buscar
    public boolean contains(int value) {
        Node current = root;
        while(current != null) {
            if(value == current.value) return true;
            current = value < current.value ? current.left : current.right;
        }
        return false;
    }

    //valores visitados da raiz ate o valor (ou ate onde a busca parou
    public List<Integer> searchPath(int value) {
        List<Integer> path = new ArrayList<>();
        Node current = root;
        while(current != null) {
            path.add(current.value);
            if(value == current.value) break;
            current = value < current.value ? current.left : current.right;
        }
        return path;
    }

    //remover
    public boolean remove(int value) {
        if(!contains(value)) return false;
        root = remove(root, value);
        return true;
    }

    private Node remove(Node node, int value) {
        if(value < node.value) {
            node.left = remove(node.left, value);
        } else if(value > node.value) {
            node.right = remove(node.right, value);
        } else {
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            Node successor = node.right;
            while(successor.left != null) successor = successor.left;
            node.value = successor.value;
            node.right = remove(node.right, successor.value);
        }
        return node;
    }

    //percursos
    public List<Integer> inOrder() {
        List<Integer> out = new ArrayList<>();
        inOrder(root, out);
        return out;
    }

    private void inOrder(Node node, List<Integer> out) {
        if(node == null) return;
        inOrder(node.left, out);
        out.add(node.value);
        inOrder(node.right, out);
    }

    public List<Integer> preOrder() {
        List<Integer> out = new ArrayList<>();
        preOrder(root, out);
        return out;
    }

    private void preOrder(Node node, List<Integer> out) {
        if(node == null) return;
        out.add(node.value);
        preOrder(node.left, out);
        preOrder(node.right, out);
    }

    public List<Integer> postOrder() {
        List<Integer> out = new ArrayList<>();
        postOrder(root, out);
        return out;
    }

    private void postOrder(Node node, List<Integer> out) {
        if(node == null) return;
        postOrder(node.left, out);
        postOrder(node.right, out);
        out.add(node.value);
    }

    //medidas
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    //menor valor
    public int min() {
        Node current = root;
        while(current.left != null) current = current.left;
        return current.value;
    }

    //maior valor
    public int max() {
        Node current = root;
        while (current.right != null) current = current.right;
        return current.value;
    }
}
