package com.company;

import java.util.Scanner;

public class Pohyby {
    //2-cerna
//1-bila
    public static int[][] pohybB(int[][] pole) {
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        while (a) {
            System.out.println("Zadej souřadnice bílé figurky, se kterou chceš pohnout: (x, y) ");
            int x = sc.nextInt();
            x = 8 - x;
            int y = sc.nextInt() - 1;
            if (pole[x][y] == 1) {
                pole[x][y] = 3;
                Vykresleni.vykresliPole(pole);
                pole[x][y] = 1;
                a = false;
            } else {
                System.out.println("Neplatný výběr. Hraje bílý hráč.  Zkus to znovu.");
            }
        }
        return pole;
    }

    public static int[][] pohybC(int[][] pole) {
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        while (a) {
            System.out.println("Zadej souřadnice černé figurky, se kterou chceš pohnout: (x, y) ");
            int x = sc.nextInt();
            x = 8 - x;
            int y = sc.nextInt() - 1;
            if (pole[x][y] == 2) {
                pole[x][y] = 4;
                Vykresleni.vykresliPole(pole);
                pole[x][y] = 2;
                a=false;
            } else {
                System.out.println("Neplatný výběr. Hraje černý hráč. Zkus to znovu.");
            }
        }
        return pole;
    }

}
