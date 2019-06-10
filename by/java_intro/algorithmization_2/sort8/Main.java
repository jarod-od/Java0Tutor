package by.java_intro.algorithmization_2.sort8;

/**
 *  8.Даны дроби  p1/q1, p2/q2, ... , pn/qn  ( pi, qi - натуральные). 
 * Составить программу, которая приводит эти дроби к общему  знаменателю и упорядочивает их в порядке возрастания.  
 */
public class Main {

    public static void main(String[] args) {

        final int N = 5;
        
        int[] p = new int[N];
        int[] q = new int[N];
        
        for (int i = 0; i < p.length; i++) {
            p[i] = (int)(Math.random() * 10 + 1);
        }

        for (int i = 0; i < q.length; i++) {
            q[i] = (int)(Math.random() * 10 + 1);
        }

        System.out.println("Fractions: ");
        for (int i = 0; i < N; i++) {
            System.out.print(p[i] + "/" + q[i] + " ");
        }
        System.out.println();

        int nok = q[0];
        for (int i = 1; i < N; i++) {
            nok = getNOK(nok, q[i]);
        }

        for (int i = 0; i < N; i++) {
            p[i] = p[i] * (nok / q[i]);
        }

        System.out.println("New fractions: ");
        for (int i = 0; i < N; i++) {
            System.out.print(p[i] + "/" + nok + " ");
        }
        System.out.println();

        sort(p);

        System.out.println("New sorted fractions: ");
        for (int i = 0; i < N; i++) {
            System.out.print(p[i] + "/" + nok + " ");
        }
        System.out.println();

    }

    private static int getNOK(int a, int b) {
        return a * b / getNOD(a, b);
    }

    private static int getNOD(int a, int b) {
        if (a == 0) {
            return b; 
        } else if (b == 0 || a == b) {
            return a;
        } else if (a == 1 || b == 1) {
            return 1;
        } else if (a % 2 == 0 && b % 2 == 0) {
            return 2 * getNOD(a / 2, b / 2);
        } else if (a % 2 == 0) {
            return getNOD(a / 2, b);
        } else if (b % 2 == 0) {
            return getNOD(a, b / 2);
        } else if (b > a) {
            return getNOD((b - a) / 2, a);
        } else {
            return getNOD((a - b) / 2, b);
        }
    } 

    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }
}