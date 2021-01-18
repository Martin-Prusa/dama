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
            int x = Utils.dalsiCislo() - 1;
            System.out.print("y:");
            int y = Utils.dalsiCislo();
            y = 8 - y;
            if (pole[y][x] == cisla[0]) {
                pole[y][x] = cisla[1];
                Vykresleni.vykresliPole(pole);
                pole[y][x] = cisla[0];
                if(Utils.overreniMoznostiTahuNormalniho(x, y, pole, ch)) {
                    a = false;
                    pole = pohybOvereniNormalni(x, y, pole, ch);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else if(pole[y][x] == cisla[2]) {
                pole[y][x] = cisla[3];
                Vykresleni.vykresliPole(pole);
                pole[y][x] = cisla[2];
                if(Utils.overeniMoznostiTahuDamy(x, y, pole, ch)) {
                    a = false;
                    pole = pohybOvereniDamy(x, y, pole, ch);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else {
                if(ch=='b') System.out.println("Neplatný výběr. Hraje bílý hráč.  Zkus to znovu.");
                else System.out.println("Neplatný výběr. Hraje černý hráč.  Zkus to znovu.");
            }
        }
        return pole;
    }

    public static int[][] pohybOvereniNormalni(int x, int y, int[][] pole, char ch) {
        int souradnice, souradnice2;
        if(ch == 'b') {
            souradnice = y-1;
            souradnice2 = y-2;
        } else {
            souradnice = y+1;
            souradnice2 = y+2;
        }
        int[] cisla = ch=='b' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        int[] cisla2 = ch=='c' ? new int[]{1, 3, 5, 7} : new int[]{2, 4, 6, 8};
        boolean a = true;
        while(a) {
            System.out.println("Zadej souřadnice, kam chceš figurku posunout: ");
            System.out.print("x:");
            int x1 = Utils.dalsiCislo()-1;
            System.out.print("y:");
            int y1 = Utils.dalsiCislo();
            y1 = 8 - y1;
            if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (souradnice==y1) && (x+1==x1 || x-1==x1)){
                pole[y][x] =0;
                if(Pole.pole[y1][x1] == cisla[1]) pole[y1][x1] = cisla[2];
                else pole[y1][x1] = cisla[0];
                a = false;
            } else if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (souradnice2==y1) && (x+2==x1 || x-2==x1)) {
                int[] xy = Utils.xyB(x, y, x1, y1);
                int cisloX = xy[0];
                int cisloY = xy[1];
                if(pole[cisloY][cisloX] == cisla2[0]) {
                    pole[y][x] =0;
                    pole[y1][x1] = cisla[0];
                    pole[cisloY][cisloX] = 0;
                    a = false;
                } else{
                    System.out.println("Nesprávný výběr. Zkus to znovu.");
                }
            } else {
                System.out.println("Nesprávný výběr. Zkus to znovu.2");
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
            int x1 = Utils.dalsiCislo()-1;
            System.out.print("y:");
            int y1 = Utils.dalsiCislo();
            y1 = 8 - y1;
            if(Math.abs(x-x1) == Math.abs(y-y1) && pole[y1][x1] == 0) {
                boolean b = true;
                int[][] tmpPole = pole;
                for (int i = 1; i <= Math.abs(x-x1); i++) {
                    tmpPole = pole;
                    int ax = (i*((x1-x) / Math.abs(x1-x))) + x;
                    int ay = (i*((y1-y) / Math.abs(y1-y))) + y;
                    if(pole[ay][ax] == 0 ||pole[ay][ax] == cisla2[0] || pole[ay][ax] == cisla[2]) {
                        tmpPole[ay][ax] = 0;
                    } else b=false;
                }
                if(b) {
                    pole[y][x] = 0;
                    pole[y1][x1] = cisla[2];
                    a=false;
                    pole = tmpPole;

                }
            } else {
                System.out.println("Nesprávný výběr.");
            }

        }
        return pole;
    }
}
