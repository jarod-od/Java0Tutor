package by.java_intro.basics_of_software_code_development_1.loop8;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа. 
 */
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        long a = 0, b = 0;
        
        while (true) {
            try {
                System.out.println("Input a, b: ");
                Scanner s = new Scanner(System.in);
                a = s.nextLong();
                b = s.nextLong();
                System.out.println("a = " + a + ", b = " + b);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        //get numerals
        int sizeA = (int)Math.log10(a);
        long[] A = new long[sizeA + 1];
        int kA = 0;
        while (a > 0) {
            A[kA] = a % 10;
            a = a / 10;
            kA++;
        }
        kA--;

        int sizeB = (int)Math.log10(b);
        long[] B = new long[sizeB + 1];
        int kB = 0;
        while (b > 0) {
            B[kB] = b % 10;
            b = b / 10;
            kB++;
        }
        kB--;

        Arrays.sort(A);
        Arrays.sort(B);

        //remove dubs
        long[] A1 = new long[sizeA + 1];
        int kA1 = 0;
        int i = 0;
        while (i <= kA) {
            A1[kA1] = A[i];
            kA1++;

            while (i < kA && A[i] == A[i + 1]) {
                i++;
            }
            i++;
        }
        kA1--;

        long[] B1 = new long[sizeB + 1];
        int kB1 = 0;
        i = 0;
        while (i <= kB) {
            B1[kB1] = B[i];
            kB1++;

            while (i < kB && B[i] == B[i + 1]) {
                i++;
            }
            i++;
        }
        kB1--;

        //find equals
        long[] C = new long[a>b?sizeA + 1:sizeB + 1];
        int kC = 0;

        for (int a1 = 0; a1 <= kA1; a1++) {
            for (int b1 = 0; b1 <= kB1; b1++) {
                if (A1[a1] == B1[b1]) {
                    C[kC] = A1[a1];
                    kC++;
                }
            }
        }
        kC--;

        System.out.println("Result: ");
        int iC = 0;
        while (iC <= kC) {
            System.out.print(C[iC] + " ");
            iC++;
        }
        System.out.println();
    }
}