package org.algos;

import java.time.Duration;
import java.time.Instant;

public class QuickSort extends Thread {
    int[] listaNumeros;

    public QuickSort(int[] arrayNums) {
        listaNumeros = arrayNums;
    }

    public static void quickSort(int[] array, int menor, int mayor) {
        if (menor < mayor) {
            // hace particion y coje pivote
            int pivotIndex = particion(array, menor, mayor);

            // ordena nmediante recursión antes y después de la partición
            quickSort(array, menor, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, mayor);
        }
    }

    private static int particion(int[] array, int menor, int mayor) {
        int pivot = array[mayor];  // coje el ultimo elemento como pivote
        int i = menor - 1;          // indice del elemento menor

        for (int j = menor; j < mayor; j++) {
            if (array[j] < pivot) {
                i++;

                // cambio
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // cambio de pivote a posicion correcta
        int temp = array[i + 1];
        array[i + 1] = array[mayor];
        array[mayor] = temp;

        return i + 1;  // devuelve indice de pivote
    }

    @Override
    public void run() {

        Instant inicio = Instant.now();
        System.out.println("Quick Sort - Inicio");

        quickSort(listaNumeros, 0, listaNumeros.length - 1);

        Instant fin = Instant.now();

        Duration duration = Duration.between(inicio, fin);
        System.out.println("Quick Sort - Fin: " + duration.toMillis() + " ms");


    }

}
