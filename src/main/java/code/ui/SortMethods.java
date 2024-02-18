package code.ui;

import code.OrderAlgortihms.BubbleSort;
import code.OrderAlgortihms.InsertionSort;
import code.OrderAlgortihms.MergeSort;
import code.Utils.NumbersReader;

import java.util.Scanner;

public class SortMethods {
    private Scanner scanner;
    public SortMethods(Scanner scanner){ this.scanner = scanner; }

    public void Execute(){
        boolean leave = false;

        while(!leave){
            System.out.println(" ---- SORT METHODS ----");
            System.out.println("1 - Quick Sort");
            System.out.println("0 - Leave");
            int op = NumbersReader.readInteger("Digite sua opção", 0, 1, scanner);

            switch (op) {
                case 1 -> {
                    int[] array = NumbersReader.readIntegerArraySpaceSeparated("Digite seu array de inteiros a ser ordenado.\n" +
                            "Os números devem estar separados por um espaço.", scanner);
                    long begin = System.currentTimeMillis();
                    InsertionSort.sort(array);
                    long end = System.currentTimeMillis();

                    System.out.println("Tempo que a ordenação levou: " + (end - begin) + "ms");
                    System.out.println("Array ordenado:");
                    for(int n : array){
                        System.out.print(n + " ");
                    }
                    System.out.println("");

                }
                case 0 -> leave = true;
            }
        }
    }
}
