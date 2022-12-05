import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {



        Integer[] values = GeneratePerfectArray(15);
        DrawArray(values);
        bubbleSort(values);




    }
    //ALGORITHMS=======================================================================

    //Bubble Sort
    public static void bubbleSort(Integer[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-i-1; j++){
                int a = array[j];
                int b = array[j + 1];
                if(a>b) {
                    swap(array, j, j + 1);
                }
                //DrawArray(array); - Will output each step of the process
            }
        }
        //Outputs only the finished array
        DrawArray(array);
    }

    //Other=======================================================================

    public static void swap(Integer[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //Generates an array with no repeats
    //Generates an array with no repeats
    public static Integer[] GeneratePerfectArray(int n){
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(array));
        return array;
    }

    //Drawing=======================================================================

    //Outputs Array as a visual from the left side of console to the right
    public static void DrawWallArray(Integer[] array){

        for(int i = 0; i < array.length; i++){
            int height  = array[i];
            for(int j = 0; j < height; j++){
                System.out.print("\u2588");
            }
            System.out.println();
        }
    }

    //Outputs Array as a visual from the bottom of console to the top
    public static void DrawArray(Integer[] array){
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