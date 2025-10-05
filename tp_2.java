package les_tp;

import java.util.Stack;

public class tp_2 {

    public static int longueurPlusLongueSousSuiteCroissante(int[] t) {
        int n = t.length;
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] < t[i] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void pivots(int[] t) {
        int n = t.length;
        int[] maxGauche = new int[n];
        int[] minDroite = new int[n];
        maxGauche[0] = t[0];
        for (int i = 1; i < n; i++) maxGauche[i] = Math.max(maxGauche[i - 1], t[i]);
        minDroite[n - 1] = t[n - 1];
        for (int i = n - 2; i >= 0; i--) minDroite[i] = Math.min(minDroite[i + 1], t[i]);
        for (int i = 0; i < n; i++) {
            if (maxGauche[i] == t[i] && minDroite[i] == t[i]) System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    public static void remplissageSpirale(int n) {
        int[][] matrice = new int[n][n];
        int val = 1, ligne = 0, colonne = 0, direction = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (val <= n * n) {
            matrice[ligne][colonne] = val++;
            int nextLigne = ligne + dx[direction];
            int nextColonne = colonne + dy[direction];
            if (nextLigne < 0 || nextLigne >= n || nextColonne < 0 || nextColonne >= n || matrice[nextLigne][nextColonne] != 0) {
                direction = (direction + 1) % 4;
                nextLigne = ligne + dx[direction];
                nextColonne = colonne + dy[direction];
            }
            ligne = nextLigne;
            colonne = nextColonne;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(matrice[i][j] + " ");
            System.out.println();
        }
    }

    public static void plusGrandRectangle1(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] hauteur = new int[m];
        int maxArea = 0, maxLigne = 0, maxColonne = 0, maxHauteur = 0, maxLargeur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) hauteur[j] = (mat[i][j] == 0) ? 0 : hauteur[j] + 1;
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            while (j < m) {
                if (stack.isEmpty() || hauteur[stack.peek()] <= hauteur[j]) stack.push(j++);
                else {
                    int top = stack.pop();
                    int largeur = stack.isEmpty() ? j : j - stack.peek() - 1;
                    int area = hauteur[top] * largeur;
                    if (area > maxArea) {
                        maxArea = area; maxHauteur = hauteur[top]; maxLargeur = largeur;
                        maxLigne = i; maxColonne = stack.isEmpty() ? 0 : stack.peek() + 1;
                    }
                }
            }
            while (!stack.isEmpty()) {
                int top = stack.pop();
                int largeur = stack.isEmpty() ? j : j - stack.peek() - 1;
                int area = hauteur[top] * largeur;
                if (area > maxArea) {
                    maxArea = area; maxHauteur = hauteur[top]; maxLargeur = largeur;
                    maxLigne = i; maxColonne = stack.isEmpty() ? 0 : stack.peek() + 1;
                }
            }
        }
        System.out.println("Surface max: " + maxArea);
        System.out.println("Coin haut gauche : (" + (maxLigne - maxHauteur + 1) + ", " + maxColonne + ")");
        System.out.println("Coin bas droite : (" + maxLigne + ", " + (maxColonne + maxLargeur - 1) + ")");
    }

    public static boolean estPermutationCirculaire(int[] t) {
        int n = t.length;
        boolean[] present = new boolean[n + 1];
        for (int val : t) {
            if (val < 1 || val > n) return false;
            if (present[val]) return false;
            present[val] = true;
        }
        int pos1 = -1;
        for (int i = 0; i < n; i++) if (t[i] == 1) {pos1 = i; break;}
        for (int i = 0; i < n; i++) {
            int expected = i + 1;
            int idx = (pos1 + i) % n;
            if (t[idx] != expected) return false;
        }
        return true;
    }

    public static int sommeMaxSousSuite(int[] t) {
        int currentSum = t[0], maxSum = t[0];
        for (int i = 1; i < t.length; i++) {
            currentSum = Math.max(t[i], currentSum + t[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static int elementMajoritaire(int[] t) {
        int candidate = -1, compteur = 0;
        for (int val : t) {
            if (compteur == 0) {candidate = val; compteur = 1;}
            else if (val == candidate) compteur++;
            else compteur--;
        }
        compteur = 0;
        for (int val : t) if (val == candidate) compteur++;
        return (compteur > t.length / 2) ? candidate : -1;
    }

    public static void elementsManquants(int[] t) {
        int n = t.length;
        boolean[] present = new boolean[n];
        for (int val : t) if (val >= 1 && val <= n) present[val - 1] = true;
        for (int i = 0; i < n; i++) if (!present[i]) System.out.print((i + 1) + " ");
        System.out.println();
    }

    public static int diffDiagonales(int[][] matrice) {
        int n = matrice.length, sommePrincipale = 0, sommeSecondaire = 0;
        for (int i = 0; i < n; i++) {
            sommePrincipale += matrice[i][i];
            sommeSecondaire += matrice[i][n - 1 - i];
        }
        return Math.abs(sommePrincipale - sommeSecondaire);
    }

    public static boolean estCarreMagique(int[][] mat) {
        int n = 3;
        int sommeRef = 0;
        for (int j = 0; j < n; j++) sommeRef += mat[0][j];
        for (int i = 1; i < n; i++) {
            int sommeLigne = 0;
            for (int j = 0; j < n; j++) sommeLigne += mat[i][j];
            if (sommeLigne != sommeRef) return false;
        }
        for (int j = 0; j < n; j++) {
            int sommeCol = 0;
            for (int i = 0; i < n; i++) sommeCol += mat[i][j];
            if (sommeCol != sommeRef) return false;
        }
        int sommeDiag1 = 0, sommeDiag2 = 0;
        for (int i = 0; i < n; i++) {
            sommeDiag1 += mat[i][i];
            sommeDiag2 += mat[i][n - 1 - i];
        }
        return sommeDiag1 == sommeRef && sommeDiag2 == sommeRef;
    }

    public static void main(String[] args) {
        int[] t1 = {2, 1, 4, 2, 3, 5, 1, 7};
        System.out.println(longueurPlusLongueSousSuiteCroissante(t1));

        int[] t2 = {2, 4, 3, 5, 6};
        pivots(t2);

        remplissageSpirale(3);

        int[][] mat4 = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };
        plusGrandRectangle1(mat4);

        int[] t5 = {4, 5, 1, 2, 3};
        System.out.println(estPermutationCirculaire(t5));

        int[] t6 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sommeMaxSousSuite(t6));

        int[] t7 = {1, 2, 3, 2, 2, 2, 5, 2};
        System.out.println(elementMajoritaire(t7));

        int[] t8 = {1, 3, 3, 5};
        elementsManquants(t8);

        int[][] mat9 = {
            {11, 2, 4},
            {4, 5, 6},
            {10, 8, -12}
        };
        System.out.println(diffDiagonales(mat9));

        int[][] mat10 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };
        System.out.println(estCarreMagique(mat10));
    }
}
