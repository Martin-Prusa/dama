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

    public static boolean overreniMoznostiTahuNormalniho(int x, int y, int[][] pole, char ch) {
        int cislo, souradnice, souradnice2;
        if(ch == 'b') {
            cislo = 2;
            souradnice = y-1;
            souradnice2 = y-2;
        } else {
            cislo = 1;
            souradnice = y+1;
            souradnice2 = y+2;
        }

        try {
            if(pole[souradnice][x+1] == 0 || pole[souradnice][x+1] == cislo) {
                if(pole[souradnice][x+1] == 0) return true;
                else if(pole[souradnice][x+1] == 2) return pole[souradnice2][y+2] == 0;
            } else {
                if(pole[souradnice][x - 1] == 0) return true;
                else if(pole[souradnice][x-1] == cislo) return pole[souradnice2][x-2] == 0;
            }
        } catch (Exception e) {
            System.out.print("");
        }
        try {
            if(pole[souradnice][x - 1] == 0) return true;
            else if(pole[souradnice][x-1] == cislo) return pole[souradnice2][x-2] == 0;
        } catch (Exception f) {
            return false;
        }
        return false;
    }

    public static boolean overeniMoznostiTahuDamy(int x, int y, int[][] pole, char ch) {
        return true;
    }

}