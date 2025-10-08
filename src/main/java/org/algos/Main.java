package org.algos;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        int[] arrayDesordenado = new int[100001];

        for (int i = 0; i <= 100000; i++) {
            arrayDesordenado[i] = i;
        }

        shuffle(arrayDesordenado, rand);


        BubbleSort algoritmoBubble = new BubbleSort(arrayDesordenado);
        QuickSort algoritmoQuick = new QuickSort(arrayDesordenado);
        BogoSort algoritmoBogo = new BogoSort(arrayDesordenado);
        MergeSort algoritmoMerge = new MergeSort(arrayDesordenado);

        algoritmoBubble.start();
        algoritmoQuick.start();
        algoritmoBogo.start();
        algoritmoMerge.start();
    }

    public static void shuffle(int[] array, Random rand) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}