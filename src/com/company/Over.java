package com.company;

public class Over {
    public static boolean overreniMoznostiTahuNormalniho(int x, int y, int[][] pole, char ch) {
        int cislo, souradnice, souradnice2;
        if (ch == 'b') {
            cislo = 2;
            souradnice = y - 1;
            souradnice2 = y - 2;
        } else {
            cislo = 1;
            souradnice = y + 1;
            souradnice2 = y + 2;
        }

        try {
            if (pole[souradnice][x + 1] == 0 || pole[souradnice][x + 1] == cislo) {
                if (pole[souradnice][x + 1] == 0) return true;
                else if (pole[souradnice][x + 1] == cislo) return pole[souradnice2][x + 2] == 0;
            } else {
                if (pole[souradnice][x - 1] == 0) return true;
                else if (pole[souradnice][x - 1] == cislo) return pole[souradnice2][x - 2] == 0;
            }
        } catch (Exception e) {
            System.out.print("");
        }
        try {
            if (pole[souradnice][x - 1] == 0) return true;
            else if (pole[souradnice][x - 1] == cislo) return pole[souradnice2][x - 2] == 0;
        } catch (Exception f) {
            return false;
        }
        return false;
    }

    public static boolean overeniMoznostiTahuDamy(int x, int y, int[][] pole, char ch) {
        int[] cisla = ch == 'b' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        if(damaOvereni(x,y,0,0,pole, cisla)) return true;
        else if(damaOvereni(x,y,7,7,pole, cisla)) return true;
        else if(damaOvereni(x,y,0,7,pole, cisla)) return true;
        else return damaOvereni(x, y, 7, 0, pole, cisla);
    }

    public static boolean damaOvereni(int x, int y, int mx, int my, int[][] pole, int[]cisla) {
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
