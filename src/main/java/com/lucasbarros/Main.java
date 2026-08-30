package com.lucasbarros;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            showMenu();
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Inserir");
                    break;

                case 2:
                    System.out.println("Buscar");
                    break;

                case 3:
                    System.out.println("Remover");
                    break;

                case 4:
                    System.out.println("In-Order");
                    break;

                case 5:
                    System.out.println("Pre-Order");
                    break;

                case 6:
                    System.out.println("Post-Order");
                    break;

                case 7:
                    System.out.println("Altura");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (escolha != 0);

        sc.close();
    }

    static void showMenu() {
        System.out.println("\n=== ÁRVORE BINÁRIA ===");
        System.out.println("1 - Inserir");
        System.out.println("2 - Buscar");
        System.out.println("3 - Remover");
        System.out.println("4 - In-Order");
        System.out.println("5 - Pre-Order");
        System.out.println("6 - Post-Order");
        System.out.println("7 - Altura");
        System.out.println("0 - Sair");
        System.out.print("\nEscolha: ");
    }
}