package code.ui;

import code.OrderAlgortihms.*;
import code.Utils.NumbersReader;

import java.util.Arrays;
import java.util.Scanner;

public class SortMethods {
    private Scanner scanner;
    public SortMethods(Scanner scanner){ this.scanner = scanner; }

    public void Execute(){
        boolean leave = false;

        while(!leave){
            System.out.println(" ---- SORT METHODS ----");
            System.out.println("1 - Quick Sort");
            System.out.println("2 - Bubble Sort");
            System.out.println("3 - Insertion Sort");
            System.out.println("4 - Merge Sort");
            System.out.println("5 - Executar todos e comparar tempo");
            System.out.println("0 - Leave");
            int op = NumbersReader.readInteger("Digite sua opção", 0, 5, scanner);

            switch (op) {
                case 1 -> execute(new QuickSort());
                case 2 -> execute(new BubbleSort());
                case 3 -> execute(new InsertionSort());
                case 4 -> execute(new MergeSort());
                case 5 -> executeAll();
                case 0 -> leave = true;
            }
        }
    }

    private void execute(ISort sortMethod){
        int[] array = NumbersReader.readIntegerArraySpaceSeparated("Digite seu array de inteiros a ser ordenado.\n" +
                "Os números devem estar separados por um espaço.", scanner);
        long begin = System.currentTimeMillis();
        sortMethod.sort(array);
        long end = System.currentTimeMillis();

        System.out.println("Tempo que a ordenação com método " + sortMethod.getName() + " levou: " + (end - begin) + "ms");
        System.out.println("Array ordenado:");
        for(int n : array){
            System.out.print(n + " ");
        }
        System.out.println("");
    }
    private void executeAll(){
        int[] array = NumbersReader.readIntegerArraySpaceSeparated("Digite seu array de inteiros a ser ordenado.\n" +
                "Os números devem estar separados por um espaço.", scanner);

        int[] arrayToBeSorted =  Arrays.copyOf(array, array.length);

        long begin = System.currentTimeMillis();
        new BubbleSort().sort(arrayToBeSorted);
        long end = System.currentTimeMillis();

        long bubbleTime = end - begin;

        arrayToBeSorted =  Arrays.copyOf(array, array.length);

        begin = System.currentTimeMillis();
        new InsertionSort().sort(arrayToBeSorted);
        end = System.currentTimeMillis();

        long insertionTime = end - begin;

        arrayToBeSorted =  Arrays.copyOf(array, array.length);

        begin = System.currentTimeMillis();
        new MergeSort().sort(arrayToBeSorted);
        end = System.currentTimeMillis();

        long mergeTime = end - begin;

        arrayToBeSorted =  Arrays.copyOf(array, array.length);

        begin = System.currentTimeMillis();
        new QuickSort().sort(arrayToBeSorted);
        end = System.currentTimeMillis();

        long quickTime = end - begin;


        System.out.print("Array ordenado: ");

        for(int n : arrayToBeSorted){
            System.out.print(n + " ");
        }
        System.out.println("\nBUBBLE SORT: " + bubbleTime + "ns |  INSERTION SORT: " + insertionTime + "ns");
        System.out.println("MERGE SORT: " + mergeTime + "ns |  QUICK SORT: " + quickTime + "ns");
    }
}
