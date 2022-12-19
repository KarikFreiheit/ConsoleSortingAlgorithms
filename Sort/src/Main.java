import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import static java.lang.Integer.MAX_VALUE;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        Integer[] values = generateImperfectArray(15);
        drawArray(values);
        selectionSort(values);




    }
    //ALGORITHMS=======================================================================

    //Bubble Sort
    public static void bubbleSort(Integer[] array) throws InterruptedException {
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-i-1; j++){
                int a = array[j];
                int b = array[j + 1];
                if(a>b) {
                    swap(array, j, j + 1);
                }
                 // Will output each step of the process
                drawArray(array);
            }
        }
        //Outputs only the finished array
        drawArray(array);
    }

    //Insertion Sort

    public static void insertionSort(Integer[] array){
        int n = array.length;
        for(int i = 1; i < n; ++i){

                int k = array[i];
                int j = i - 1;

                while( j >= 0 && array[j] > k){
                    array[j + 1] = array[j];
                    j -= 1;
                }
                array[j + 1] = k;
            // Will output each step of the process
            drawArray(array);

        }
        drawArray(array);


    }

    //Selection Sort
    public static void selectionSort(Integer[] array){

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
        drawArray(array);

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
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}