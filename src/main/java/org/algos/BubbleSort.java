package org.algos;

import java.security.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class BubbleSort extends Thread {
    int[] listaNumeros;

    public BubbleSort(int[] arrayNums) {
        listaNumeros = arrayNums;
    }

    @Override
    public void run() {
        Instant inicio = Instant.now();
        System.out.println("Bubble Sort - Inicio");
        int n = listaNumeros.length;
        boolean cambiado;

        // bucle principal
        for (int i = 0; i < n - 1; i++) {
            cambiado = false;
            // bucle para las comparaciones
            for (int j = 0; j < n - 1 - i; j++) {
                if (listaNumeros[j] > listaNumeros[j + 1]) {
                    // cambio de valores
                    int temp = listaNumeros[j];
                    listaNumeros[j] = listaNumeros[j + 1];
                    listaNumeros[j + 1] = temp;

                    cambiado = true;
                }
            }
            if (!cambiado) {
                break;
            }
        }
        Instant fin = Instant.now();
        Duration duration = Duration.between(inicio, fin);
        System.out.println("Bubble Sort - Fin: " + duration.toMillis() + " ms");


    }

}
