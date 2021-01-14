package com.company;

public class Vykresleni {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void vykresliPole(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if(j==0) {
                    System.out.print(8-i+" ");
                }

                if(pole[i][j] == 0) {
                    if(Pole.pole[i][j] == 1) {
                        System.out.print("⬛️");
                    } else {
                        System.out.print("⬜️");
                    }
                }else if(pole[i][j] == 1)System.out.print("◉ ");
                else if(pole[i][j] == 2) System.out.print("◎ ");
                else if (pole[i][j] == 3) System.out.print(ANSI_RED+"◉ "+ANSI_RESET);
                else if(pole[i][j] == 4) System.out.print(ANSI_RED+"◎ "+ANSI_RESET);
                else if(pole[i][j] == 5) System.out.print("♜ ");
                else if(pole[i][j] == 6) System.out.print("♖ ");
                else if(pole[i][j] == 7) System.out.print(ANSI_RED+"♜ "+ANSI_RESET);
                else if(pole[i][j] == 8) System.out.print(ANSI_RED+"♖ "+ANSI_RESET);
            }

            System.out.println();
        }
        System.out.println("  1  2 3  4 5  6 7  8");
    }
}
