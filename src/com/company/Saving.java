package com.company;

import java.io.*;

public class Saving {
    public static void save(int[][] pole) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            for (int i = 0; i < pole.length; i++) {
                for (int i1 = 0; i1 < pole.length; i1++) {
                    bw.write(pole[i][i1]+"");
                    bw.newLine();
                }
            }
            bw.close();
            System.out.println("Uloženo");
        } catch (IOException e) {
            System.out.println("Hra nelze uložit");
        }
    }

    public static int[][] load() {
        int[][] pole = new int[8][8];
        try{
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            for (int i = 0; i < pole.length; i++) {
                for (int i1 = 0; i1 < pole.length; i1++) {
                    pole[i][i1] = Integer.parseInt(br.readLine());
                }
            }
            br.close();
            System.out.println("Nahráno");
        } catch (IOException e) {
            System.out.println("Hra nelze načíst");
        }
        return pole;
    }
}
