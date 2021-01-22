package com.company;

public class Move {
    public static int[][] move(int[][] pole, char ch) {
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
                Gui.drawField(pole);
                pole[y][x] = cisla[0];
                if(Normal.validNormalSelect(x, y, pole, ch)) {
                    a = false;
                    Normal.validNormalMove(x, y, pole, ch);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else if(pole[y][x] == cisla[2]) {
                pole[y][x] = cisla[3];
                Gui.drawField(pole);
                pole[y][x] = cisla[2];
                if(King.validKingSelect(x, y, pole, ch)) {
                    a = false;
                    King.validKingMove(x, y, pole, ch);
                } else System.out.println("Touto figurkou by nešlo táhnout. Vyber prosím jinou figurku.");
            } else {
                if(ch=='b') System.out.println("Neplatný výběr. Hraje bílý hráč.  Zkus to znovu.");
                else System.out.println("Neplatný výběr. Hraje černý hráč.  Zkus to znovu.");
            }
        }
        return pole;
    }
}
