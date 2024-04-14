package code.ui;

import code.OrderAlgortihms.*;
import code.Utils.NumbersReader;

import java.io.IOException;
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
        long begin = System.nanoTime();
        sortMethod.sort(array);
        long end = System.nanoTime();

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

        long fastestTime;
        String fastestMethod;
        long slowestTime;
        String slowestMethod;


        long begin = System.nanoTime();
        new BubbleSort().sort(arrayToBeSorted);
        long end = System.nanoTime();

        long bubbleTime = end - begin;
        fastestMethod = "Bubble Sort";
        slowestMethod = "Bubble Sort";
        slowestTime = bubbleTime;
        fastestTime = bubbleTime;

        arrayToBeSorted =  Arrays.copyOf(array, array.length);

        begin = System.nanoTime();
        new InsertionSort().sort(arrayToBeSorted);
        end = System.nanoTime();

        long insertionTime = end - begin;

        if(insertionTime > slowestTime){
            slowestMethod = "Insertion Sort";
            slowestTime = insertionTime;
        }else if (insertionTime < fastestTime){
            fastestMethod = "Insertion Sort";
            fastestTime = insertionTime;
        }

        arrayToBeSorted =  Arrays.copyOf(array, array.length);

        begin = System.nanoTime();
        new MergeSort().sort(arrayToBeSorted);
        end = System.nanoTime();

        long mergeTime = end - begin;

        if(mergeTime > slowestTime){
            slowestMethod = "Merge Sort";
            slowestTime = mergeTime;
        }else if (mergeTime < fastestTime){
            fastestMethod = "Merge Sort";
            fastestTime = mergeTime;
        }

        arrayToBeSorted =  Arrays.copyOf(array, array.length);

        begin = System.nanoTime();
        new QuickSort().sort(arrayToBeSorted);
        end = System.nanoTime();

        long quickTime = end - begin;

        if(quickTime > slowestTime){
            slowestMethod = "Quick Sort";
            slowestTime = quickTime;
        }else if (quickTime < fastestTime){
            fastestMethod = "Quick Sort";
            fastestTime = quickTime;
        }

        System.out.print("Array ordenado: ");

        for(int n : arrayToBeSorted){
            System.out.print(n + " ");
        }
        System.out.println("\nBUBBLE SORT: " + bubbleTime + "ns |  INSERTION SORT: " + insertionTime + "ns");
        System.out.println("MERGE SORT: " + mergeTime + "ns |  QUICK SORT: " + quickTime + "ns");
        System.out.println("Execução mais rápida: " + fastestMethod + " em " + fastestTime + "ns " +
                "|  Execução mais lenta: " + slowestMethod + " em " + slowestTime + "ns");

        System.out.println("\nPressione qualquer tecla ...");
        try {
            System.in.read(); // Aguarda o pressionamento de uma tecla
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
