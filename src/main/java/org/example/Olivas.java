package org.example;

import java.util.Random;
import java.util.Scanner;

public class Olivas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int ancho = 0;
        int largo = 0;
        double totalOlivas = 0;
        double sumaHilera = 0;
        int olivoTop = 0;
        int itop = 0;
        int jtop = 0;

        System.out.println("**** BIENVENIDO AL OLIVÓMETRO ****");

        boolean tamanyo = false;

        while (!tamanyo){

            System.out.println("Introduce el tamaño de tu bancal...");
            System.out.println("Ancho:");

            if (teclado.hasNextInt()) {
                ancho = teclado.nextInt();

                if (ancho >= 0){

                    System.out.println("Alto:");

                    if (teclado.hasNextInt()) {
                        largo = teclado.nextInt();

                        if (largo >= 0) {

                            tamanyo = true;

                        }
                    }else {
                        System.out.println("Error. El alto deber ser un número.");
                        teclado.nextLine();
                    }
                }
            }else {
                System.out.println("Error. El ancho deber ser un número.");
                teclado.nextLine();
            }
        }

        System.out.println("Introduce por hileras los kg por árbol de tu bancal: ");

        int[][] kilos = new int[largo][ancho];

        teclado.nextLine();

        for (int i = 0; i < largo; i++) {
            String hilera = teclado.nextLine();
            String [] hileraV = hilera.split(" ");
            if (hileraV.length == ancho) {
                for (int j = 0; j < ancho; j++) {
                    kilos[i][j] = Integer.parseInt(hileraV[j]);
                    totalOlivas += kilos[i][j];
                }
            }else {
                System.out.println("Introduce un número de árboles correcto. (" + ancho + ").");
                i--;
            }
        }

        System.out.println("=======================");
        System.out.println("MAPA de tu bancal actual:");

        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                System.out.print(kilos[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======================");
        System.out.println("Total kg generados: " + totalOlivas + "kg");
        System.out.println("Litros totales obtenidos: " + totalOlivas/8 + " L");
        System.out.println("Litros por hilera...");
        for (int i = 0; i < ancho ; i++) {
            sumaHilera = 0;
            System.out.print("\t- Hilera " + (i + 1) + ": ");
            for (int j = 0; j < kilos[i].length; j++) {
                sumaHilera += kilos[j][i];

            }
            System.out.println(sumaHilera/8 + " L");
        }

        System.out.println("Olivos más productivos (>35kg):");

        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                if (kilos[i][j] > 35){
                    System.out.println("\t- En la pisición (" + i + "," + j + ") con " + kilos[i][j] + " kg ");
                    if (olivoTop < kilos[i][j]){
                        olivoTop = kilos[i][j];
                        itop = i;
                        jtop = j;
                    }
                }
            }
        }
        System.out.println("Olivo TOP (" + olivoTop + " kg generados) en la posición (" + itop + "," + jtop + ") del bancal.");
        System.out.println("=====================");

        System.out.println("MAPA para replantar:");

        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                if (kilos[i][j] < 5){
                    System.out.print("X ");
                }else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

        System.out.println("======================");
        System.out.println("MAPA estimación después de replantar:");
        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                if (kilos[i][j] < 5) {
                    System.out.print(random.nextInt(15,36) + " ");
                }else {
                    System.out.print(kilos[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}