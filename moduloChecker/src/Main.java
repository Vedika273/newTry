import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a number and base, separated by space
        System.out.println("Please enter a number and a base, separated by space");
        int num = scanner.nextInt();  // Read the number
        int base = scanner.nextInt(); // Read the base

        // Check if the number is divisible by 3 and print the result
        System.out.printf("%d %s %d%n", num, isDivisible(num) ? "is divisible by" : "is not divisible by", 3);

        // Check if the number is divisible by the provided base and print the result
        System.out.printf("%d %s %d%n", num, isDivisible(num, base) ? "is divisible by" : "is not divisible by", base);
        System.out.println(); // Add a blank line for readability

        // Prompt user to enter an English letter
        System.out.println("Please enter an English letter:");
        char letter = scanner.nextLine().charAt(0); // Read the letter as a character

        // Prompt user to enter a number base and an English letter, separated by space
        System.out.println("Please enter a number base and an English letter separated by space");
        int numberBase = scanner.nextInt(); // Read the number base
        char EnglishBase = scanner.next().charAt(0); //I think it is next because we don;t need it to read the entire line
        // Read the base letter    nextInt, nextDouble, next() don't go to next line
        //if we write nextLine() after it there will be problems. //the newLine character is left in the user buffer,


        // Check if the letter is divisible by 3 and print the result
        System.out.printf("'%s' %s %d%n", letter, isDivisible(letter) ? "is divisible by" : "is not divisible by", 3);

        // Check if the letter is divisible by the provided base number and print the result
        System.out.printf("'%s' %s %d%n", letter, isDivisible(letter, numberBase) ? "is divisible by" : "is not divisible by", numberBase);

        // Check if the letter is divisible by the provided base letter and print the result
        System.out.printf("'%s' %s '%s'%n", letter, isDivisible(letter, EnglishBase) ? "is divisible by" : "is not divisible by", EnglishBase);
    }

    // Method to convert a letter to a number (its position in the alphabet)
    public static int lettertoNumber(char c) {
        return Character.toLowerCase(c) - 'a';  // Returns index of letter in alphabet (0 for 'a', 1 for 'b', etc.)
    }

    // Method to check if an integer is divisible by 3
    public static boolean isDivisible(int num) {
        return num % 3 == 0;  // Returns true if num is divisible by 3, false otherwise
    }

    // Method to check if an integer is divisible by a given base
    public static boolean isDivisible(int num, int base) {
        return num % base == 0;  // Returns true if num is divisible by base, false otherwise
    }

    // Method to check if a letter is divisible by a given base
    public static boolean isDivisible(char letter, int base) {
        int number = lettertoNumber(letter);  // Convert the letter to its numeric value
        return number % base == 0;  // Returns true if number is divisible by base, false otherwise
    }

    // Method to check if one letter is divisible by another letter (based on their numeric values)
    public static boolean isDivisible(char letter, char base) {
        int number = lettertoNumber(letter);  // Convert the letter to its numeric value
        int intBase = lettertoNumber(base);   // Convert the base letter to its numeric value
        return number % intBase == 0;  // Returns true if number is divisible by the base's numeric value, false otherwise
    }
}
