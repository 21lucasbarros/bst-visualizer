package com.lucasbarros.view;

import com.lucasbarros.model.BinarySearchTree;
import com.lucasbarros.model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreePrinter {

    private static final int GAP = 2;

    public static String render(BinarySearchTree tree) {
        if (tree.isEmpty()) return "(árvore vazia)\n";
        Block block = build(tree.getRoot());
        StringBuilder sb = new StringBuilder();
        for (String line : block.lines) {
            sb.append(line.stripTrailing()).append('\n');
        }
        return sb.toString();
    }

    private static Block build(Node node) {
        String label = String.valueOf(node.getValue());

        Block left = node.getLeft() != null ? build(node.getLeft()) : null;
        Block right = node.getRight() != null ? build(node.getRight()) : null;

        //folha só o número
        if (left == null && right == null) {
            return new Block(List.of(label), label.length(), label.length() / 2);
        }

        //posicao dos filhos
        int leftOffset = 0;
        int rightOffset = left != null ? left.width + GAP : 0;
        int childrenWidth = right != null ? rightOffset + right.width : left.width;
        int leftRoot = left != null ? leftOffset + left.rootCol : -1;
        int rightRoot = right != null ? rightOffset + right.rootCol : -1;

        //coluna onde o pai fica
        int mid;
        if (left != null && right != null) mid = (leftRoot + rightRoot) / 2;
        else if (left != null) mid = leftRoot + 2;
        else mid = rightRoot - 2;

        //se o numero do pai vaza pela esquerda, empurra tudo para a direita
        int labelStart = mid - label.length() / 2;
        int shift = Math.max(0, -labelStart);
        mid += shift;
        labelStart += shift;
        leftOffset += shift;
        rightOffset += shift;
        if (left != null) leftRoot += shift;
        if (right != null) rightRoot += shift;

        int width = Math.max(childrenWidth + shift, labelStart + label.length());

        //linha 0 vai ser o valor do pai
        char[] labelLine = blank(width);
        label.getChars(0, label.length(), labelLine, labelStart);

        //linha 1 é conectores
        char[] connector = blank(width);
        if (left != null && right != null) {
            connector[leftRoot] = '┌';
            for (int i = leftRoot + 1; i < rightRoot; i++) connector[i] = '─';
            connector[rightRoot] = '┐';
            connector[mid] = '┴';
        } else if (left != null) {
            connector[leftRoot] = '┌';
            for (int i = leftRoot + 1; i < mid; i++) connector[i] = '─';
            connector[mid] = '┘';
        } else {
            connector[mid] = '└';
            for (int i = mid + 1; i < rightRoot; i++) connector[i] = '─';
            connector[rightRoot] = '┐';
        }

        List<String> lines = new ArrayList<>();
        lines.add(new String(labelLine));
        lines.add(new String(connector));

        //as outras linhas sao os filhos lado a lado
        int rows = Math.max(left != null ? left.lines.size() : 0,
                right != null ? right.lines.size() : 0);
        for (int r = 0; r < rows; r++) {
            char[] row = blank(width);
            if (left != null && r < left.lines.size()) {
                String text = left.lines.get(r);
                text.getChars(0, text.length(), row, leftOffset);
            }
            if (right != null && r < right.lines.size()) {
                String text = right.lines.get(r);
                text.getChars(0, text.length(), row, rightOffset);
            }
            lines.add(new String(row));
        }

        return new Block(lines, width, mid);
    }

    private static char[] blank(int width) {
        char[] chars = new char[width];
        Arrays.fill(chars, ' ');
        return chars;
    }
}
