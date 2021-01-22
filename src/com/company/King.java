package com.company;

public class King {
    public static int[][] validKingMove(int x, int y, int[][] pole, char ch) {
        int[] cisla = ch=='b' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        int[] cisla2 = ch=='c' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        boolean a = true;
        while(a) {
            System.out.println("Zadej souřadnice, kam chceš fugurku posunout: ");
            System.out.print("x:");
            int x1 = Utils.dalsiCislo(0,8)-1;
            System.out.print("y:");
            int y1 = Utils.dalsiCislo(0,8);
            y1 = 8 - y1;
            if(Math.abs(x-x1) == Math.abs(y-y1) && pole[y1][x1] == 0) {
                boolean b = true;
                for (int i = 1; i <= Math.abs(x-x1) && b; i++) {
                    int ax = (i*((x1-x) / Math.abs(x1-x))) + x;
                    int ay = (i*((y1-y) / Math.abs(y1-y))) + y;
                    if(pole[ay][ax] == 0 ||pole[ay][ax] == cisla2[0] || pole[ay][ax] == cisla2[2]);
                    else b=false;

                }
                if(b) {
                    pole[y][x] = 0;
                    pole[y1][x1] = cisla[2];
                    a=false;
                    //pole = tmpPole;
                    for (int i = 1; i <= Math.abs(x-x1); i++) {
                        int ax = (i*((x1-x) / Math.abs(x1-x))) + x;
                        int ay = (i*((y1-y) / Math.abs(y1-y))) + y;
                        if(pole[ay][ax] == 0 ||pole[ay][ax] == cisla2[0] || pole[ay][ax] == cisla2[2]) pole[ay][ax] = 0;
                    }

                } else System.out.println("Nesprávný výběr.");


            } else {
                System.out.println("Nesprávný výběr.");
            }

        }
        return pole;
    }

    public static boolean validKingSelect(int x, int y, int[][] pole, char ch) {
        int[] cisla = ch == 'b' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        if (validKingSelect2(x, y, 0, 0, pole, cisla)) return true;
        else if (validKingSelect2(x, y, 7, 7, pole, cisla)) return true;
        else if (validKingSelect2(x, y, 0, 7, pole, cisla)) return true;
        else return validKingSelect2(x, y, 7, 0, pole, cisla);
    }

    public static boolean validKingSelect2(int x, int y, int mx, int my, int[][] pole, int[]cisla) {
        int tmpX = x;
        int tmpY = y;
        while (tmpX != mx && tmpY != my) {
            if(mx == 7 && my == 0) {
                tmpX++;
                tmpY--;
            } else if(mx == 0 && my == 7) {
                tmpX--;
                tmpY++;
            } else if(mx == 7 && my == 7) {
                tmpX++;
                tmpY++;
            } else {
                tmpX--;
                tmpY--;
            }

            if (pole[tmpY][tmpX] == 0) return true;
            else if (pole[tmpY][tmpX] == cisla[0] || pole[tmpY][tmpX] == cisla[2]) break;

        }
        return false;
    }
}
