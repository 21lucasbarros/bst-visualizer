package com.lucasbarros;

import com.lucasbarros.model.BinarySearchTree;
import com.lucasbarros.view.TreePrinter;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final BinarySearchTree tree = new BinarySearchTree();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = ask("Escolha: ");
            System.out.println();

            switch (choice) {
                case "1" -> insert();
                case "2" -> search();
                case "3" -> remove();
                case "4" -> printList("In-Order", tree.inOrder());
                case "5" -> printList("Pre-Order", tree.preOrder());
                case "6" -> printList("Post-Order", tree.postOrder());
                case "7" -> System.out.println("Altura: " + tree.height() + " (vazia = -1)");
                case "8" -> minMax();
                case "9" -> showTree();
                case "0" -> {
                    System.out.println("Até mais!");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("=== ÁRVORE BINÁRIA DE BUSCA ===");
        System.out.println("1 - Inserir (um ou vários: 13 23 32)");
        System.out.println("2 - Buscar (passo a passo)");
        System.out.println("3 - Remover");
        System.out.println("4 - In-Order");
        System.out.println("5 - Pre-Order");
        System.out.println("6 - Post-Order");
        System.out.println("7 - Altura");
        System.out.println("8 - Menor / Maior");
        System.out.println("9 - Mostrar árvore");
        System.out.println("0 - Sair");
    }

    private static void insert() {
        String line = ask("Valores: ");
        for (String token : line.split("\\s+")) {
            if (token.isEmpty()) continue;
            try {
                int value = Integer.parseInt(token);
                if (!tree.insert(value)) {
                    System.out.println(value + " já existe, ignorado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("'" + token + "' não é um inteiro, ignorado.");
            }
        }
        showTree();
    }

    private static void search() {
        Integer target = askInt("Buscar: ");
        if (target == null) return;

        List<Integer> path = tree.searchPath(target);
        if (path.isEmpty()) {
            System.out.println("A árvore está vazia.");
            return;
        }

        for (int node : path) {
            if (target == node) {
                System.out.println(target + " encontrado!");
            } else if (target > node) {
                System.out.println("Comparando " + target + " com " + node
                        + "... " + target + " > " + node + " → direita");
            } else {
                System.out.println("Comparando " + target + " com " + node
                        + "... " + target + " < " + node + " → esquerda");
            }
        }

        int last = path.get(path.size() - 1);
        if (last != target) {
            System.out.println("Chegou a um ponto vazio: " + target + " não está na árvore.");
        }
    }

    private static void remove() {
        Integer value = askInt("Remover: ");
        if (value == null) return;

        if (tree.remove(value)) {
            System.out.println(value + " removido.");
            showTree();
        } else {
            System.out.println(value + " não está na árvore.");
        }
    }

    private static void minMax() {
        if (tree.isEmpty()) {
            System.out.println("A árvore está vazia.");
            return;
        }
        System.out.println("Menor: " + tree.min());
        System.out.println("Maior: " + tree.max());
    }

    private static void showTree() {
        System.out.println();
        System.out.print(TreePrinter.render(tree));
    }

    private static void printList(String title, List<Integer> values) {
        System.out.println(title + ":");
        System.out.println(values.isEmpty() ? "(árvore vazia)" : values);
    }

    private static String ask(String prompt) {
        System.out.print(prompt);
        return in.hasNextLine() ? in.nextLine().trim() : "0";
    }

    private static Integer askInt(String prompt) {
        try {
            return Integer.parseInt(ask(prompt));
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
            return null;
        }
    }
}
