import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int bars = 1000;
        Scanner sc = new Scanner(System.in);
        Integer[] values;
        System.out.print("Input 1 for an Imperfect Array or Input 2 for a perfect Array: ");
        if(sc.nextInt() == 1){
             values = generateImperfectArray(bars);

        }else{
            values = generatePerfectArray(bars);

        }
        System.out.print("Generated Array: ");
        drawArray(values);
        System.out.println("Choose your sorting algorithm: ");
        System.out.println("1 : Selection Sort");
        System.out.println("2 : Bubble Sort");
        System.out.println("3 : Insertion Sort");
        switch (sc.nextInt()){
            case 1:
                selectionSort(values);
                break;
            case 2:
                bubbleSort(values);
                break;
            case 3: insertionSort(values);
                break;
        }






    }
    //ALGORITHMS=======================================================================

    //Bubble Sort
    public static void bubbleSort(Integer[] array) throws InterruptedException {
        final long startTime = System.currentTimeMillis();

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-i-1; j++){
                int a = array[j];
                int b = array[j + 1];
                if(a>b) {
                    swap(array, j, j + 1);
                }

            }
        }
        final long endTime = System.currentTimeMillis();

        drawArray(array);
        System.out.print("Time: " + (endTime - startTime)  + "ms");

    }

    //Insertion Sort

    public static void insertionSort(Integer[] array){
        final long startTime = System.currentTimeMillis();
        int n = array.length;
        for(int i = 1; i < n; ++i){

                int k = array[i];
                int j = i - 1;

                while( j >= 0 && array[j] > k){
                    array[j + 1] = array[j];
                    j -= 1;
                }
                array[j + 1] = k;
        }
        final long endTime = System.currentTimeMillis();
        drawArray(array);
        System.out.print("Time: " + (endTime - startTime) + "ms");



    }

    //Selection Sort
    public static void selectionSort(Integer[] array){
        final long startTime = System.currentTimeMillis();

        int j = array.length;
        for(int i = 0; i < j - 1; i++){
            int index = i;
            for(int k = i+1; k < j; k++){
                if(array[k] < array[index])
                {
                    index = k;
                }
            }

            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        final long endTime = System.currentTimeMillis();
        drawArray(array);
        System.out.println("Time: " + (endTime - startTime)  + "ms");

    }



    //Other=======================================================================

    public static void swap(Integer[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Generates an array with no repeats
    public static Integer[] generatePerfectArray(int n){
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(array));
        return array;
    }
    public static Integer[] generateImperfectArray(int n){
        Integer[] array = new Integer[n];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(0, n + 1);
        }
        return array;
    }

    //Drawing=======================================================================

    //Outputs Array as a visual from the left side of console to the right
    public static void drawWallArray(Integer[] array){

        for(int i = 0; i < array.length; i++){
            int height  = array[i];
            for(int j = 0; j < height; j++){
                System.out.print("\u2588");
            }
            System.out.println();
        }
    }

    //Outputs Array as a visual from the bottom of console to the top
    public static void drawArray(Integer[] array){
        for(int i = 0; i < array.length; i++) {
            for (int j = array.length; j > 0; j--) {
                if (array[j - 1] <= i + 1) {
                    System.out.print("\u2588 ");

                }
                else{
                    System.out.print("  ");

                }

            }
            System.out.println();


        }
    }
}