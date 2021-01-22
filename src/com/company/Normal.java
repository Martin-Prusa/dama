package com.company;

public class Normal {
    public static int[][] validNormalMove(int x, int y, int[][] pole, char ch) {
        int souradnice;
        if(ch == 'b') {
            souradnice = y-1;
        } else {
            souradnice = y+1;
        }
        int[] cisla = ch=='b' ? new int[]{1, 3, 5, 7, 3} : new int[]{2, 4, 6, 8, 2};
        int[] cisla2 = ch=='c' ? new int[]{1, 3, 5, 7, 3} : new int[]{2, 4, 6, 8, 2};
        boolean a = true;
        while(a) {
            System.out.println("Zadej souřadnice, kam chceš figurku posunout: ");
            System.out.print("x:");
            int x1 = Utils.dalsiCislo(0,8)-1;
            System.out.print("y:");
            int y1 = Utils.dalsiCislo(0,8);
            y1 = 8 - y1;
            if((pole[y1][x1] == 0 && (Field.field[y1][x1] == 1 || Field.field[y1][x1] == 2|| Field.field[y1][x1] == 3)) && (souradnice==y1) && (x+1==x1 || x-1==x1)){
                pole[y][x] =0;
                if(Field.field[y1][x1] == cisla[4]) pole[y1][x1] = cisla[2];
                else pole[y1][x1] = cisla[0];
                a = false;
            } else if((pole[y1][x1] == 0 && (Field.field[y1][x1] == 1 || Field.field[y1][x1] == 2|| Field.field[y1][x1] == 3)) && ((x+2==x1 || x-2==x1)||(x+4==x1 || x-4==x1) ||(x+6==x1 || x-6==x1))) {
                int[]b=jump(x,y,x1,y1,pole,cisla,cisla2);
                if(b[2]==0) a=false;
            } else {
                System.out.println("Nesprávný výběr. Zkus to znovu.");
            }
        }
        return pole;
    }

    public static int[] jump(int x, int y, int x1, int y1, int[][] pole, int[] cisla, int[] cisla2){
        if(Math.abs(x-x1) != 2) {
            int[]a = jump(x,y, x-((x-x1)-(((x-x1)/Math.abs(x-x1))*2)), y-((y-y1)-(((y-y1)/Math.abs(y-y1))*2)), pole, cisla, cisla2);
            x = a[0];
            y=a[1];
        }
        int[] xy = Utils.xyB(x, y, x1, y1);
        int cisloX = xy[0];
        int cisloY = xy[1];
        if(pole[cisloY][cisloX] == cisla2[0] || pole[cisloY][cisloX] == cisla2[2]) {
            pole[y][x] =0;
            if(Field.field[y1][x1] == cisla[4]) pole[y1][x1] = cisla[2];
            else pole[y1][x1] = cisla[0];
            pole[cisloY][cisloX] = 0;
            x =x1;
            y=y1;
            return new int[]{x, y, 0};
        } else{
            System.out.println("Nesprávný výběr. Zkus to znovu.");
        }
        return new int[]{x, y, 1};
    }

    public static boolean validNormalSelect(int x, int y, int[][] pole, char ch) {
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
}
