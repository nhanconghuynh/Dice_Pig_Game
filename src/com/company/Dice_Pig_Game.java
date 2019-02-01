package com.company;

/* A variation of the dice game Pig
Create a program that will randomly select two numbers from 1-6 (like rolling two dice). Show the dice rolls. You should also show the running score.

Prompt the user to either roll again or lose their turn.
A player scores the sum of the two dice thrown and gradually reaches a higher score as they continue to roll. If a single number 1 is thrown on either die, the score for that whole turn is lost. However a double 1 counts as 25.
When you reach a score of 100 (or more) the game ends. */


import java.util.Scanner;
import java.util.Random;


public class Dice_Pig_Game {

    private static int random_roll() {
        Random pig = new Random();
        int roll = 0;
        int dice = pig.nextInt(5);
        switch (dice) {
            case 0:
                roll = 1;
                break;
            case 1:
                roll = 2 ;
                break;
            case 2:
                roll = 3;
                break;
            case 3:
                roll = 4;
                break;
            case 4:
                roll = 5;
                break;
            case 5:
                roll = 6;
                break;
        }
        return roll;
    }

    private static int sum(int num1, int num2) {
        if ((num1 == 1) && (num2 == 1))
            return 25;
        else if ((num1 == 1) || (num2 == 1))
            return 0;
        else return (num1 + num2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String another = "y";
        int roll1 = 0;
        int roll2 = 0;
        int total_sum = 0;

        System.out.println("\nWelcome! Let's Play Roll Dice! ");

        do {
            roll1 = random_roll();
            roll2 = random_roll();

            total_sum = total_sum + sum(roll1,roll2);

            System.out.println("\nYour rolls " + roll1 + " & " + roll2);
            System.out.println ("Score: " + total_sum);

            if (total_sum >= 100) {
                System.out.println("\nYou have scored over 100.");
                another = "n";
            }
            else {
                System.out.print("\nRoll again? ");
                another = scanner.nextLine();
            }

        } while (
                (another.equals("y")) || ( another.equals("Y")) || (another.equals("yes"))
                || (another.equals("YES")) || (another.equals("Yes"))
                );

         System.out.println("\nThank you for playing!");
    }
}