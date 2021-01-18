package com.company;

public class Main {

    public static void main(String[] args) {
        while (true) {
//            int[][] hraciPole = {
//                    {0, 2, 0, 2, 0, 2, 0, 2},
//                    {2, 0, 2, 0, 2, 0, 2, 0},
//                    {0, 2, 0, 2, 0, 2, 0, 2},
//                    {0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0},
//                    {1, 0, 1, 0, 1, 0, 1, 0},
//                    {0, 1, 0, 1, 0, 1, 0, 1},
//                    {1, 0, 1, 0, 1, 0, 1, 0}
//            };
            int[][] hraciPole = {
                    {0, 0, 0, 6, 0, 2, 0, 0},
                    {1, 0, 0, 0, 2, 0, 0, 0},
                    {0, 0, 0, 0, 0, 2, 0, 0},
                    {0, 0, 0, 0, 2, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 5, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0}
            };

            System.out.println("1) Nová hra");
            System.out.println("2) Ukončit");
            int volba = Utils.dalsiCislo(0, 2);
            if (volba == 2) System.exit(0);
            else {
                Vykresleni.vykresliPole(hraciPole);
                boolean a = true;
                while (a) {
                    int[] aaa = Utils.pocet(hraciPole);
                    System.out.println("Bílé: " + aaa[0] + "    Černé: " + aaa[1]);
                    if (aaa[0] == 0 || aaa[1] == 0) break;
                    hraciPole = Pohyby.pohyb(hraciPole, 'b');
                    Vykresleni.vykresliPole(hraciPole);

                    aaa = Utils.pocet(hraciPole);
                    System.out.println("Bílé: " + aaa[0] + "    Černé: " + aaa[1]);
                    if (aaa[0] == 0 || aaa[1] == 0) break;
                    hraciPole = Pohyby.pohyb(hraciPole, 'c');
                    Vykresleni.vykresliPole(hraciPole);
                }
                int[] aaa = Utils.pocet(hraciPole);
                if (aaa[0] == 0) System.out.println("Konec hry. Černý vyhrál.");
                else System.out.println("Konec hry. Bílý vyhrál");

            }
        }
    }
}
