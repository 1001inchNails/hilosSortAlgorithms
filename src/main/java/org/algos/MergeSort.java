package org.algos;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class MergeSort extends Thread {

    int[] listaNumeros;

    public MergeSort(int[] arrayNums) {
        listaNumeros = arrayNums;
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }


    @Override
    public void run() {
        
        Instant inicio = Instant.now();

        System.out.println("Merge Sort - Inicio");

        mergeSort(listaNumeros);

        Instant fin = Instant.now();

        Duration duration = Duration.between(inicio, fin);
        System.out.println("Merge Sort - Fin: " + duration.toMillis() + " ms");


    }

}
