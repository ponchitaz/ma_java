package checkTheBrackets;

import java.util.Scanner;
/**
 * The program asks for a mathematical expression
 * with parentheses and checks if they are placed correctly:
 * every opening one has to be closed,
 * the first on can't be the closing one,
 * the number of opening and closing parentheses must be equal.
 */
public class Brackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("We need to know if you're good with brackets. We expect you to type an expression using them as much as you need.");
        System.out.println("Express yourself: ");
        String expression = in.nextLine();
        char[] expressionStuff = expression.toCharArray(); //почему не работает без массива?
        int expressionLength = expression.length();

        int unpaired = 0;

        for (int j = 0; j < expressionLength; j++) {
                if (expressionStuff[j] == '(') {
                    unpaired++;
                }
                else if (expressionStuff[j] == ')'){
                    unpaired--;
                    if (unpaired < 0) {
                        break;
                    }
                }
            }

        if (unpaired == 0) {
            System.out.println("Well done!");
        }
        else {
            System.out.println("WRONG!");
        }
    }
}
