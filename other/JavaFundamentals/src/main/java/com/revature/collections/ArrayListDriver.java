package com.revature.collections;

import java.util.*;

public class ArrayListDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Write a Java program to create a new array list, add some colors (string) and print out the collection.
        ArrayList<String> colors = new ArrayList<String>(); //Declaring and initializing an arraylist
        colors.add("red");
        colors.add("orange");
        colors.add("yellow");
        colors.add("green");
        colors.add("blue");
        colors.add("indigo");
        colors.add("violet");
        System.out.println(colors);

        // 2. Write a Java program to iterate through all elements in an array list
        Iterator<String> it = colors.iterator();
        while (it.hasNext()){
            String color = it.next();
            System.out.println(color);
        }

        // 3. Write a Java program to insert an element into the array list at the first position
        System.out.println("What color would you like to add to the start of the list?");
        String choice = sc.nextLine();
        colors.add(0, choice);
        System.out.println(colors);

        // 4. Write a Java program to retrieve an element (at a specified index) from a given array list
        System.out.println("What index would you like to retrieve a color from?");
        int c2 = Integer.parseInt(sc.nextLine());
        System.out.println(colors.get(c2));

        // 5. Write a Java program to remove the third element from an array list.
        System.out.println("Colors so far: " + colors);
        colors.remove(2);
        System.out.println("Colors after removal of third element: " + colors);

        // 6. Write a Java program to search an element in an array list.
        System.out.println("What color would you like to search for?");
        String c3 = sc.nextLine();
        if (colors.contains(c3)){
            System.out.println("Color is present");
        } else{
            System.out.println("Color is not present");
        }

        // 7. Write a Java program to sort a given array list.
        Collections.sort(colors);
        for (String i : colors){
            System.out.println(i);
        }
    }
}
