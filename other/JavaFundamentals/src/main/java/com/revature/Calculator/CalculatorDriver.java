package com.revature.Calculator;

import java.util.Scanner;

public class CalculatorDriver {
    public static void main(String[] args) {

        boolean running = true;
        Scanner input = new Scanner(System.in);

        double num1;
        double num2;
        double sum;

        while (running){
            // Prompts user what operator they want to use
            System.out.println("What are you trying to do?: a = add, s = subtract, m = multiply, d = divide, q = quit");
            // User inputs decision
            String choice = input.nextLine();

            // Loops for the decisions
            if (choice.equals("a")){
                System.out.println("What's the first number?");
                num1 = input.nextDouble();
                System.out.println("What would you like to add to " + num1 + " ?");
                num2 = input.nextDouble();
                sum = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + sum);
            }
        }
    }
}
