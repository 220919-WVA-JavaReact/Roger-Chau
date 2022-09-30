package com.revature.Arrays;

public class Array{
    public static void main(String[] args){
        // The syntax to declare an array is as follows:
        // datatype[] arrayname;
        // Or you can do:
        // datatype arrayname[];
        // However this syntax is highly discouraged
        // Declaring does not actually CREATE/INITIALIZE an array, it only tells the computer "hey this variable will hold an array"

        // Declares an array of integers
        int[] array;

        // Allocates memory for 10 integers and also initializes the array
        array = new int[10];

        // Initialize first element
        array[0] = 100;
        // Initialize second element
        array[1] = 200;
        // Etc.
        array[2] = 300;
        array[3] = 400;
        array[4] = 500;
        array[5] = 600;
        array[6] = 700;
        array[7] = 800;
        array[8] = 900;
        array[9] = 1000;

        System.out.println("Element at index 0: " + array[0]);
        System.out.println("Element at index 1: " + array[1]);
        System.out.println("Element at index 2: " + array[2]);
        System.out.println("Element at index 3: " + array[3]);
        System.out.println("Element at index 4: " + array[4]);
        System.out.println("Element at index 5: " + array[5]);
        System.out.println("Element at index 6: " + array[6]);
        System.out.println("Element at index 7: " + array[7]);
        System.out.println("Element at index 8: " + array[8]);
        System.out.println("Element at index 9: " + array[9]);

    }
}
