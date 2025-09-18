import java.util.Scanner;

/**
 * Utility class for input validation
 */
public class InputValidator {
    
    /**
     * Validates and gets a positive integer from user input
     */
    public static int getPositiveInt(Scanner scanner, String prompt) {
        int value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("\u001B[31mInvalid input. Please enter a positive number.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Consume the invalid input
            }
        }
        return value;
    }
    
    /**
     * Validates and gets a non-negative integer from user input
     */
    public static int getNonNegativeInt(Scanner scanner, String prompt) {
        int value = -1;
        while (value < 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("\u001B[31mInvalid input. Please enter a non-negative number.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Consume the invalid input
            }
        }
        return value;
    }
    
    /**
     * Validates and gets a float within a range from user input
     */
    public static float getFloatInRange(Scanner scanner, String prompt, float min, float max) {
        float value = -1;
        while (value < min || value > max) {
            System.out.print(prompt);
            if (scanner.hasNextFloat()) {
                value = scanner.nextFloat();
                if (value < min || value > max) {
                    System.out.println("\u001B[31mInvalid input. Please enter a number between " + min + " and " + max + ".\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Consume the invalid input
            }
        }
        return value;
    }
    
    /**
     * Validates and gets a double within a range from user input
     */
    public static double getDoubleInRange(Scanner scanner, String prompt, double min, double max) {
        double value = -1;
        while (value < min || value > max) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value < min || value > max) {
                    System.out.println("\u001B[31mInvalid input. Please enter a number between " + min + " and " + max + ".\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Consume the invalid input
            }
        }
        return value;
    }
    
    /**
     * Validates and gets a yes/no choice from user input
     */
    public static int getYesNoChoice(Scanner scanner, String prompt) {
        int choice = -1;
        while (choice != 0 && choice != 1) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice != 0 && choice != 1) {
                    System.out.println("\u001B[31mInvalid input. Please enter 0 or 1.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter 0 or 1.\u001B[0m");
                scanner.next(); // Consume the invalid input
            }
        }
        return choice;
    }
    
    /**
     * Validates phone number format (11 digits)
     */
    public static String getValidPhoneNumber(Scanner scanner, String prompt) {
        String phoneNumber = "";
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(prompt);
            phoneNumber = scanner.nextLine();
            
            if (phoneNumber.matches("\\d{11}")) {
                validInput = true;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter exactly 11 digits.\u001B[0m");
            }
        }
        return phoneNumber;
    }
    
    /**
     * Validates gender input (male/female)
     */
    public static String getValidGender(Scanner scanner, String prompt) {
        String gender = "";
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(prompt);
            gender = scanner.nextLine();
            
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                validInput = true;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter either 'male' or 'female'.\u001B[0m");
            }
        }
        return gender;
    }
    
    /**
     * Validates age input (16-50)
     */
    public static int getValidAge(Scanner scanner, String prompt) {
        int age = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (age >= 16 && age <= 50) {
                    validInput = true;
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter an age between 16 and 50.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return age;
    }
    
    /**
     * Validates major name (letters only)
     */
    public static String getValidMajor(Scanner scanner, String prompt) {
        String major = "";
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(prompt);
            major = scanner.nextLine();
            
            if (major.matches("[a-zA-Z\\s]+") && !major.trim().isEmpty()) {
                validInput = true;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter only letters for your major.\u001B[0m");
            }
        }
        return major.trim();
    }
}
