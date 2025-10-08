package org.algos;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class BogoSort extends Thread {

    int[] listaNumeros;

    public BogoSort(int[] arrayNums) {
        listaNumeros = arrayNums;
    }

    public static void bogoSort(int[] array) {
        Random rand = new Random();
        while (!estaOrdenado(array)) {
            shuffle(array, rand);
        }
    }

    // chequea si está ordenado en orden ascendente
    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // ordena al azar
    public static void shuffle(int[] array, Random rand) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    @Override
    public void run() {
        
        Instant inicio = Instant.now();

        System.out.println("Bogo Sort - Inicio");

        bogoSort(listaNumeros);

        Instant fin = Instant.now();

        Duration duration = Duration.between(inicio, fin);
        System.out.println("Bogo Sort - Fin: " + duration.toMillis() + " ms");


    }

}
