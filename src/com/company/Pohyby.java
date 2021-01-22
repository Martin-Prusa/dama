package com.company;

public class Pohyby {
    //2-cerna
//1-bila
    public static int[][] pohyb(int[][] pole, char ch) {
        int[] cisla = ch=='b' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        boolean a = true;
        while (a) {
            if(ch=='b') System.out.println("Zadej souřadnice bílé figurky, se kterou chceš pohnout: ");
            else System.out.println("Zadej souřadnice černé figurky, se kterou chceš pohnout: ");
            System.out.print("x:");
            int x = Utils.dalsiCislo(0,8) - 1;
            System.out.print("y:");
            int y = Utils.dalsiCislo(0,8);
            y = 8 - y;
            if (pole[y][x] == cisla[0]) {
                pole[y][x] = cisla[1];
                Vykresleni.vykresliPole(pole);
                pole[y][x] = cisla[0];
                if(Over.overreniMoznostiTahuNormalniho(x, y, pole, ch)) {
                    a = false;
                    pohybOvereniNormalni(x, y, pole, ch);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else if(pole[y][x] == cisla[2]) {
                pole[y][x] = cisla[3];
                Vykresleni.vykresliPole(pole);
                pole[y][x] = cisla[2];
                if(Over.overeniMoznostiTahuDamy(x, y, pole, ch)) {
                    a = false;
                    pohybOvereniDamy(x, y, pole, ch);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else {
                if(ch=='b') System.out.println("Neplatný výběr. Hraje bílý hráč.  Zkus to znovu.");
                else System.out.println("Neplatný výběr. Hraje černý hráč.  Zkus to znovu.");
            }
        }
        return pole;
    }

    public static int[][] pohybOvereniNormalni(int x, int y, int[][] pole, char ch) {
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
            if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (souradnice==y1) && (x+1==x1 || x-1==x1)){
                pole[y][x] =0;
                if(Pole.pole[y1][x1] == cisla[4]) pole[y1][x1] = cisla[2];
                else pole[y1][x1] = cisla[0];
                a = false;
            } else if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && ((x+2==x1 || x-2==x1)||(x+4==x1 || x-4==x1) ||(x+6==x1 || x-6==x1))) {
                int[]b=preskoceni(x,y,x1,y1,pole,cisla,cisla2);
                if(b[2]==0) a=false;
            } else {
                System.out.println("Nesprávný výběr. Zkus to znovu.");
            }
        }
        return pole;
    }

    public static int[][] pohybOvereniDamy(int x, int y, int[][] pole, char ch) {
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


    public static int[] preskoceni(int x, int y, int x1, int y1, int[][] pole, int[] cisla, int[] cisla2){
        if(Math.abs(x-x1) != 2) {
            int[]a = preskoceni(x,y, x-((x-x1)-(((x-x1)/Math.abs(x-x1))*2)), y-((y-y1)-(((y-y1)/Math.abs(y-y1))*2)), pole, cisla, cisla2);
            x = a[0];
            y=a[1];
        }
        int[] xy = Utils.xyB(x, y, x1, y1);
        int cisloX = xy[0];
        int cisloY = xy[1];
        if(pole[cisloY][cisloX] == cisla2[0] || pole[cisloY][cisloX] == cisla2[2]) {
            pole[y][x] =0;
            if(Pole.pole[y1][x1] == cisla[4]) pole[y1][x1] = cisla[2];
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
}
