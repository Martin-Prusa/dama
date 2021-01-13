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

    public static boolean jeKladne(int a ) {
        return a == Math.abs(a);
    }

    public static int[] xyB(int x, int y, int x1, int y1) {
        var cisloX = ((x1-x)/2)+x;
        var cisloY = ((y1-y)/2)+y;
        int[] a = {cisloX, cisloY};
        return a;
    }

    public static boolean overreniMoznostiTahu(int x, int y, int[][] pole) {
        try {
            if(pole[y+1][x+1] == 0) return true;
            else if(pole[y+1][x-1] == 0) return true;
            else if(pole[y-1][x+1] == 0) return true;
            else if(pole[y-1][x-1] == 0) return true;
            return false;
        } catch (Exception e) {
            try {
                if(pole[y+1][x-1] == 0) return true;
                else if(pole[y-1][x+1] == 0) return true;
                else if(pole[y-1][x-1] == 0) return true;
                return false;
            } catch (Exception f) {
                try {
                    if(pole[y-1][x+1] == 0) return true;
                    else if(pole[y-1][x-1] == 0) return true;
                    return false;
                } catch (Exception g) {
                    try {
                        if(pole[y-1][x-1] == 0) return true;
                        return false;
                    } catch (Exception h) {
                        return false;
                    }
                }
            }
        }
    }
}