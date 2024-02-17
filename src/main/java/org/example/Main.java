package org.example;

import org.Utils.NumbersReader;
import org.ui.SortMethods;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean leave = false;
        SortMethods sort = new SortMethods(scanner);

        while (!leave){
            System.out.println(" ---- ALGORITMOS DE EXERCÍCIO ----");
            System.out.println(" ---- Selecione qual categoria deseja utilizar ----");
            System.out.println("1 - Sort Methods");
            System.out.println("0 - Leave");
            int op = NumbersReader.readInteger("Digite sua opção",0, 1, scanner);
            switch (op) {
                case 1 -> sort.Execute();
                case 0 -> leave = true;
            }
        }
        System.out.println("Obrigada por utilizar a aplicação!");

    }
}