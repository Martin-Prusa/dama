package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("   ___ _           _              \n" +
                "  / __| |_  ___ __| |_____ _ _ ___\n" +
                " | (__| ' \\/ -_) _| / / -_) '_(_-<\n" +
                "  \\___|_||_\\___\\__|_\\_\\___|_| /__/\n" +
                "                                  \n" +
                "\n");
        while (true) {
            int[][] hraciPole = {
                    {0, 2, 0, 2, 0, 2, 0, 2},
                    {2, 0, 2, 0, 2, 0, 2, 0},
                    {0, 2, 0, 2, 0, 2, 0, 2},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0}
            };
//            int[][] hraciPole = {
//                    {0, 0, 0, 6, 0, 2, 0, 0},
//                    {2, 0, 0, 0, 2, 0, 2, 0},
//                    {0, 1, 0, 0, 0, 1, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 1, 0, 0, 0, 0},
//                    {2, 0, 2, 0, 0, 0, 0, 0},
//                    {0, 1, 0, 2, 0, 1, 0, 0},
//                    {0, 0, 5, 0, 0, 0, 0, 0}
//            };

            System.out.println("1) Nová hra");
            System.out.println("2) Ukončit");
            int volba = Utils.dalsiCislo(0, 2);
            if (volba == 2) System.exit(0);
            else {
                Gui.drawField(hraciPole);
                while (true) {
                    int[] aaa = Utils.pocet(hraciPole);
                    System.out.println("Bílé: " + aaa[0] + "    Černé: " + aaa[1]);
                    if (aaa[0] == 0 || aaa[1] == 0) break;
                    hraciPole = Move.move(hraciPole, 'b');
                    Gui.drawField(hraciPole);

                    aaa = Utils.pocet(hraciPole);
                    System.out.println("Bílé: " + aaa[0] + "    Černé: " + aaa[1]);
                    if (aaa[0] == 0 || aaa[1] == 0) break;
                    hraciPole = Move.move(hraciPole, 'c');
                    Gui.drawField(hraciPole);
                }
                int[] aaa = Utils.pocet(hraciPole);
                if (aaa[0] == 0) System.out.println("Konec hry. Černý vyhrál.");
                else System.out.println("Konec hry. Bílý vyhrál");

            }
        }
    }
}
