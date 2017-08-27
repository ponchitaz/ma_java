package FactIt;

/**
 * This program asks for a number and then counts its factorial.
 */

import java.util.Scanner;

public class CountIt {
    public static void main(String[] args) {

        int theRealIt = 1;

            Scanner in = new Scanner(System.in);
            System.out.println("Tell me a number: ");
            int theIt = in.nextInt();
            if (theIt <= 0) {
                System.out.println("Oh, please! This number is undesirable. Only in positive we trust.");
            }
            else {
                for (int i = 2; i <= theIt; i++){
                    theRealIt = theRealIt * i;
                }
                System.out.println("Here is your factorial: " + theRealIt);
            }
    }
}


