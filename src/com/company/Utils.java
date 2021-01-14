package com.company;

import java.util.Scanner;

public class Utils {

    public static int dalsiCislo() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String str = sc.nextLine();
                int a = Integer.parseInt(str);
                if(jeVRozsahu(a)) return a;
                else System.out.println("Číslo musí být v rozsahu 1-8");
            } catch (Exception e) {
                System.out.println("Toto není číslo, zkus to znovu.");
            }
        }
    }

    public static boolean jeVRozsahu(int a) {
        return a > 0 && a <= 8;
    }

    public static int[] xyB(int x, int y, int x1, int y1) {
        var cisloX = ((x1-x)/2)+x;
        var cisloY = ((y1-y)/2)+y;
        int[] a = {cisloX, cisloY};
        return a;
    }

    public static boolean overreniMoznostiTahuNormalnihoBileho(int x, int y, int[][] pole) {
        try {
            if(pole[y-1][x+1] == 0) return true;
            else return pole[y - 1][x - 1] == 0;
        } catch (Exception e) {
            try {
                return pole[y - 1][x - 1] == 0;
            } catch (Exception f) {
                return false;
            }
        }
    }

    public static boolean overreniMoznostiTahuNormalnihoCerneho(int x, int y, int[][] pole) {
        try {
            if(pole[y+1][x+1] == 0) return true;
            else return pole[y+1][x-1] == 0;
        } catch (Exception e) {
            try {
                return pole[y+1][x-1] == 0;
            } catch (Exception f) {
                return false;
            }
        }
    }
}