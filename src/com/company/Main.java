package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int [][] hraciPole = {
//                {0, 2, 0, 2, 0, 2, 0, 2},
//                {2, 0, 2, 0, 2, 0, 2, 0},
//                {0, 2, 0, 2, 0, 2, 0, 2},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1, 0, 1, 0},
//                {0, 1, 0, 1, 0, 1, 0, 1},
//                {1, 0, 1, 0, 1, 0, 1, 0}
//        };
        int [][] hraciPole = {
                {0, 0, 0, 6, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 1, 0}
        };
        Vykresleni.vykresliPole(hraciPole);
        boolean a = true;
        while(a) {
            hraciPole = Pohyby.pohyb(hraciPole, 'b');
            Vykresleni.vykresliPole(hraciPole);
            hraciPole = Pohyby.pohyb(hraciPole, 'c');
            Vykresleni.vykresliPole(hraciPole);
        }


    }
}
