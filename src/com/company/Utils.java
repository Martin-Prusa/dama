package com.company;

import java.util.Scanner;

public class Utils {

    public static int dalsiCislo(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String str = sc.nextLine();
                int a = Integer.parseInt(str);
                if (jeVRozsahu(a, min, max)) return a;
                else System.out.println("Číslo musí být v rozsahu " + (min + 1) + "-" + max);
            } catch (Exception e) {
                System.out.println("Toto není číslo, zkus to znovu.");
            }
        }
    }

    public static boolean jeVRozsahu(int a, int min, int max) {
        return a > min && a <= max;
    }

    public static int[] xyB(int x, int y, int x1, int y1) {
        var cisloX = ((x1 - x) / 2) + x;
        var cisloY = ((y1 - y) / 2) + y;
        int[] a = {cisloX, cisloY};
        return a;
    }

    public static int[] pocet(int[][] pole) {
        int bile = 0, cerne = 0;
        for (int i = 0; i < pole.length; i++) {
            for (int i1 = 0; i1 < pole[i].length; i1++) {
                if (pole[i][i1] == 1 || pole[i][i1] == 3 || pole[i][i1] == 5 || pole[i][i1] == 7) bile++;
                else if (pole[i][i1] == 2 || pole[i][i1] == 4 || pole[i][i1] == 6 || pole[i][i1] == 8) cerne++;
            }
        }
        int[] xxx = {bile, cerne};
        return xxx;
    }

}