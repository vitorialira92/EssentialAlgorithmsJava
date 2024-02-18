package org.Utils;

import java.util.Scanner;

public final class NumbersReader {
    private NumbersReader() { }

    public static int readInteger(Scanner scanner){
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException ex){
                System.out.println("Digite um número inteiro válido!");
            }
        }
    }
    public static int readInteger(String msg, int min, int max, Scanner scanner){
        while(true){
            try{
                System.out.println(msg);
                int number = Integer.parseInt(scanner.nextLine());
                if(number < min || number > max)
                    throw new NumberFormatException ();
                return number;
            }
            catch(NumberFormatException ex){
                System.out.println("Digite um número inteiro válido entre " + min + " e " + max);
            }
        }

    }
    public static int[] readIntegerArraySpaceSeparated(String msg, Scanner scanner){

        boolean validArray = false;
        int[] array = new int[0];

        while(!validArray){
            System.out.println(msg);
            String str = scanner.nextLine();
            String[] nmbrs = str.split(" ");

            array = new int[nmbrs.length];
            int pos = 0;
            for(String s : nmbrs){
                try{
                    int number = Integer.parseInt(s);
                    array[pos] = number;
                    pos++;
                    validArray = true;
                }
                catch(Exception ex){
                    System.out.println("Todos os números devem ser inteiros válidos! Tente novamente");
                    validArray = false;
                    break;
                }
            }

        }
        return array;
    }
    public static int[] readIntegerArray(int length, Scanner scanner){

        int[] array = new int[length];

        for(int i = 0; i < length; i ++){
            System.out.println("Digite o " + (i + 1) + " ° número");
            array[i] = readInteger(scanner);
        }
        return array;
    }

}
