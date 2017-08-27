package HelloWorld;
/**
 * This program prints "Hello, World!" 100 times, each one on its own line, signing each string with its number.
 */
public class Hello {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("\nHello, World! #" + i);
        }
    }
}