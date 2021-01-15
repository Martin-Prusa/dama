package com.company;

public class Pohyby {
    //2-cerna
//1-bila
    public static int[][] pohybB(int[][] pole) {
        boolean a = true;
        while (a) {
            System.out.println("Zadej souřadnice bílé figurky, se kterou chceš pohnout: ");
            System.out.print("x:");
            int x = Utils.dalsiCislo() - 1;
            System.out.print("y:");
            int y = Utils.dalsiCislo();
            y = 8 - y;
            if (pole[y][x] == 1) {
                pole[y][x] = 3;
                Vykresleni.vykresliPole(pole);
                pole[y][x] = 1;
                if(Utils.overreniMoznostiTahuNormalnihoBileho(x, y, pole)) {
                    a = false;
                    pole = pohybOvereniNormalniB(x, y, pole);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else if(pole[y][x] == 5) {
                pole[y][x] = 7;
                Vykresleni.vykresliPole(pole);
                pole[y][x] = 5;
                if(Utils.overeniMoznostiTahuDamyB(x, y, pole)) {
                    a = false;
                    pole = pohybOvereniDamyB(x, y, pole);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else System.out.println("Neplatný výběr. Hraje bílý hráč.  Zkus to znovu.");
        }
        return pole;
    }

    public static int[][] pohybC(int[][] pole) {
        boolean a = true;
        while (a) {
            System.out.println("Zadej souřadnice černé figurky, se kterou chceš pohnout:  ");
            System.out.print("x:");
            int x = Utils.dalsiCislo() - 1;
            System.out.print("y:");
            int y = Utils.dalsiCislo();
            y = 8 - y;
            if (pole[y][x] == 2) {
                pole[y][x] = 4;
                Vykresleni.vykresliPole(pole);
                pole[y][x] = 2;
                if(Utils.overreniMoznostiTahuNormalnihoCerneho(x, y, pole)){
                    a = false;
                    pole = pohybOvereniNormalniC(x, y, pole, 'c');
                }else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else if(pole[y][x] == 6) {
                pole[y][x] = 8;
                Vykresleni.vykresliPole(pole);
                pole[y][x] = 6;
                if(Utils.overeniMoznostiTahuDamyC(x, y, pole)){
                    a = false;
                    pole = pohybOvereniDamyC(x, y, pole);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else System.out.println("Neplatný výběr. Hraje černý hráč. Zkus to znovu.");
        }
        return pole;
    }

    public static int[][] pohybOvereniNormalniB(int x, int y, int[][] pole) {
        boolean a = true;
        while(a) {
            System.out.println("Zadej souřadnice, kam chceš figurku posunout: ");
            System.out.print("x:");
            int x1 = Utils.dalsiCislo()-1;
            System.out.print("y:");
            int y1 = Utils.dalsiCislo();
            y1 = 8 - y1;
            if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (y-1==y1) && (x+1==x1 || x-1==x1)){
                pole[y][x] =0;
                if(Pole.pole[y1][x1] == 3) pole[y1][x1] = 5;
                else pole[y1][x1] = 1;
                a = false;
            } else if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (y-2==y1) && (x+2==x1 || x-2==x1)) {
                int[] xy = Utils.xyB(x, y, x1, y1);
                int cisloX = xy[0];
                int cisloY = xy[1];
                if(pole[cisloY][cisloX] == 2) {
                    pole[y][x] =0;
                    pole[y1][x1] = 1;
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

    public static int[][] pohybOvereniNormalniC(int x, int y, int[][] pole, char c) {
        boolean a = true;
        while(a) {
            System.out.println("Zadej souřadnice, kam chceš figurku posunout: ");
            System.out.print("x:");
            int x1 = Utils.dalsiCislo()-1;
            System.out.print("y:");
            int y1 = Utils.dalsiCislo();
            y1 = 8 - y1;
            if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (y+1==y1) && (x+1==x1 || x-1==x1)){
                pole[y][x] =0;
                if(Pole.pole[y1][x1] == 2) pole[y1][x1] = 6;
                else pole[y1][x1] = 2;
                a = false;
            } else if((pole[y1][x1] == 0 && (Pole.pole[y1][x1] == 1 || Pole.pole[y1][x1] == 2|| Pole.pole[y1][x1] == 3)) && (y+2==y1) && (x+2==x1 || x-2==x1)) {
                    int[] xy = Utils.xyB(x, y,x1, y1);
                    int cisloX = xy[0];
                    int cisloY = xy[1];
                    if(pole[cisloY][cisloX] == 1) {
                        pole[y][x] =0;
                        pole[y1][x1] = 2;
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

    private static int[][] pohybOvereniDamyB(int x, int y, int[][] pole) {
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
                    if(pole[ay][ax] == 0 ||pole[ay][ax] == 2 || pole[ay][ax] == 6) {
                        tmpPole[ay][ax] = 0;
                    } else b=false;
                }
                if(b) {
                    pole[y][x] = 0;
                    pole[y1][x1] = 5;
                    a=false;
                    pole = tmpPole;
                    
                }
            } else {
                System.out.println("Nesprávný výběr.");
            }

        }
        return pole;
    }

    private static int[][] pohybOvereniDamyC(int x, int y, int[][] pole) {
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
                    if(pole[ay][ax] == 0 ||pole[ay][ax] == 1 || pole[ay][ax] == 5) {
                        tmpPole[ay][ax] = 0;
                    } else b=false;
                }
                if(b) {
                    pole[y][x] = 0;
                    pole[y1][x1] = 6;
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
