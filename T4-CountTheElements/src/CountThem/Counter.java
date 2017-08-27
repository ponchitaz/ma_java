package CountThem;

import java.util.Scanner;
import java.lang.String;

/**
 * The program asks to enter some text and counts the amount of letters and words in the text.
 */
public class Counter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Tell me a story: ");
        String story = in.nextLine();
        int plot = story.length();
        in.useDelimiter("\\W\\s\\.");

        int numberOfSymbols = 0;
        int numberOfWords = 0;
        boolean singleWord = false;
        int storyEnd = plot - 1;

        for (int i=0; i<plot; i++) {
            if (Character.isLetterOrDigit(story.charAt(i))) {
                numberOfSymbols = numberOfSymbols +1;}
            else {
                numberOfSymbols = numberOfSymbols + 0;}
        }

        for (int j=0; j<plot; j++) {
            if (Character.isLetterOrDigit(story.charAt(j)) && j != storyEnd) {
                singleWord = true;}
            else if (!Character.isLetterOrDigit(story.charAt(j)) && singleWord) {
                numberOfWords = numberOfWords +1;
                singleWord = false;}
            else if (Character.isLetterOrDigit(story.charAt(j)) && j == storyEnd) {
                numberOfWords = numberOfWords +1;}

        }

        System.out.println("There are " + numberOfSymbols + " letters in your story.");
        System.out.println("Which are combined in " + numberOfWords + " words.");
    }
}
