/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmancli;

import java.util.Scanner;

public class HangManCLI {
    public static void main(String[] args) {
        String[] words = {
            "book",
            "display",
            "watch"
        };
        String choice;
        choice = words[(int)(Math.random() * words.length)];

        Scanner input = new Scanner(System.in);

        char guess = ' ';
        boolean gameOver = false;
        char[] printArray = new char[choice.length()];
        int rightCounter = 0;
        String wrongLetters = "";
        boolean AddIt;

        // set the letters in the printed word array to _ [initialize], print it out so the user knows how many letters (this is actually two loops combined)
        for (int i = 0; i < choice.length(); i++) {
            printArray[i] = '_';
            System.out.print(printArray[i]);
            System.out.print(" ");
        }

        while (!gameOver) {
            System.out.println();
            System.out.println();

            // prompt the user for a guess letter, and store in in the guess variable
            System.out.print("Enter a guess: ");
            guess = input.next().charAt(0);

            // set gameover to true and if it is not it will be set to false throughout the loop
            gameOver = true;

            AddIt = true; // varabe to see wether the guessed ar should be added to wrongs will be aded unless right if satatement sets it so it will not be added because it was in the word at least once
            for (int i = 0; i < choice.length(); i++) {
                if (choice.charAt(i) == guess) {
                    printArray[i] = guess;
                    rightCounter++; // if there are multiple of the same letters in the loop it will still work when it is checked at the end because it is icreemented every time the guess letter matches the letter in the word that is being checked at the time
                    AddIt = false;
                } else {
                    gameOver = false;
                }
            }

            // checks if the limit of letters the user can get wrong (hangman) is complete [here would be visuals if the hangman would be actually printed (hangman string variable w/ newlines that would be added body parts to and printed out)]
            if (AddIt) {
                wrongLetters += guess;
                if (wrongLetters.length() == 6) {
                    System.out.println("You got too many guesses incorrect!");
                    break;
                }
            }

            // prints ot the wrong letters (hangman) the board - the dashes and what the user has gotten right; all seperated by a tab
            System.out.println();
            System.out.print(wrongLetters + "\t");
            for (int i = 0; i < choice.length(); i++) {

                System.out.print(printArray[i]);
                System.out.print(" ");
            }

            // checks if the user got all letters right if rightcounter is equal to the number letters in the word, it cannot be more becaus it is checked after every guess loop
            // ctrl allows for class extension. How to add names to loops in case of nested
            if (rightCounter == choice.length()) {
                gameOver = true;
                System.out.println();
                System.out.println();
                System.out.println("Congatulations!");
            }
        }
    }
}
