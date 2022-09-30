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
                System.out.println("What is your first number?");
                num1 = input.nextDouble();
                System.out.println("What would you like to add to " + num1 + " ?");
                num2 = input.nextDouble();
                sum = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + sum);
                break;
            } else if (choice.equals("s")){
                System.out.println("What number are you subtracting from?");
                num1 = input.nextDouble();
                System.out.println("What would you like to subtract from " + num1 + " ?");
                num2 = input.nextDouble();
                sum = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + sum);
                break;
            } else if (choice.equals("m")) {
                System.out.println("What number would you like to multiply?");
                num1 = input.nextDouble();
                System.out.println("What would you like to multiply " + num1 + " by?");
                num2 = input.nextDouble();
                sum = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + sum);
                break;
            } else if (choice.equals("d")){
                System.out.println("What number would you like to divide?");
                num1 = input.nextDouble();
                System.out.println("What number are you dividing " + num1 + " by?");
                num2 = input.nextDouble();
                sum = num1 / num2;
                System.out.println(num1 + "/" + num2 + " = " + sum);
                break;
            } else if (choice.equals("q")){
                break;
            } else {
                System.out.println("That is not a valid input");
                break;
            }
        }
    }
}
