package by.java_intro.algorithmization_2.one_dim9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final int SEQ_SIZE = 20;
    public static void main(String[] args) {
        int[] A = new int[SEQ_SIZE];
        
        Map<Integer, Integer> m = new HashMap<>();

        System.out.println("Array A: ");
        for (int i = 0; i < SEQ_SIZE; i++) {
            A[i] = (int)(Math.random() * 10);
            System.out.print(A[i] + " ");
            if (!m.containsKey(A[i])) {
                m.put(A[i], 1);
            } else {
                m.put(A[i], m.get(A[i]) + 1);
            }
        }
        System.out.println();

        int maxCount = Integer.MIN_VALUE;
        for(int key : m.keySet()) {
            if (m.get(key) > maxCount) {
                maxCount = m.get(key);
            }
        }

        List<Integer> l = new ArrayList<>();

        for(int key : m.keySet()) {
            if (m.get(key) == maxCount) {
                l.add(key);
            }
        }

        if (l.size() == 1) {
            System.out.println("Max repeating: " + l.get(0));
        } else {
            int min = Integer.MAX_VALUE;
            for(int v : l) {
                if (v < min) {
                    min = v;
                }
            }
            System.out.println("Max repeating: " + min);
        }
    }
}