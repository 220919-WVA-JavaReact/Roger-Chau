package com.revature.collections;

import java.util.LinkedList;

public class ListedListDriver {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("red");
        colors.add("orange");
        colors.add("yellow");
        System.out.println(colors);

        // 1. Write a Java program to append the specified element to the end of a linked list. Add several values.
        colors.addLast("green");
        colors.addLast("blue");
        System.out.println(colors);

        // 2. Write a Java program to iterate through all elements in a linked list.


        // 3. Write a Java program to iterate a linked list in reverse order


        // 4.  Write a Java program to insert the specified element at the front of a linked list


        // 5. Write a Java program to insert some elements at the specified position into a linked list.


        // 6. Write a Java program to get the first and last occurrence of the specified elements in a linked list.


        // 7. Write a Java program to check if a particular element exists in a linked list.


        // 8. Write a Java program to convert a linked list to array list.


    }
}
