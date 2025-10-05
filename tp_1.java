package les_tp;

import java.util.Scanner;

public class tp_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            System.out.print("Choisissez une option : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez deux entiers : ");
                    int a1 = sc.nextInt();
                    int b1 = sc.nextInt();
                    System.out.println("Résultat : " + addition(a1, b1));
                    break;

                case 2:
                    System.out.print("Entrez deux entiers : ");
                    int a2 = sc.nextInt();
                    int b2 = sc.nextInt();
                    System.out.println("Résultat : " + multiplication(a2, b2));
                    break;

                case 3:
                    System.out.print("Combien de valeurs ? ");
                    int n = sc.nextInt();
                    int[] valeurs = lireEntiers(sc, n, "Valeur");
                    System.out.println("Moyenne : " + moyenne(valeurs));
                    break;

                case 4:
                    System.out.print("Combien de nombres ? ");
                    int m = sc.nextInt();
                    int[] entiers = lireEntiers(sc, m, "Nombre");
                    System.out.println("Maximum : " + maximum(entiers));
                    break;

                case 0:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Option invalide !");
            }

        } while (choix != 0);

        sc.close();
    }

    
    public static int addition(int a, int b) {
        return a + b;
    }

    
    public static int multiplication(int a, int b) {
        return a * b;
    }

    
    public static double moyenne(int... valeurs) {
        int total = 0;
        for (int v : valeurs) {
            total += v;
        }
        return (double) total / valeurs.length;
    }

  
    public static int maximum(int... valeurs) {
        int max = valeurs[0];
        for (int v : valeurs) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    
    public static int[] lireEntiers(Scanner sc, int n, String label) {
        int[] tableau = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(label + " " + (i + 1) + " : ");
            tableau[i] = sc.nextInt();
        }
        return tableau;
    }

   
    public static void afficherMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Moyenne");
        System.out.println("4. Trouver le plus grand");
        System.out.println("0. Quitter");
    }
}
