import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GpaCalculator implements GpaCalc {
    @Override
    public void GPA4(ArrayList<Subject> subjects) {
        Scanner sc = new Scanner(System.in);
        double totalGradePoints = 0;
        int totalCreditHours = 0;
        for (Subject subject : subjects) {

            double grade;
            while (true) {
                try {
                    System.out.print("Enter " + subject.getName() + " final grade: ");
                    grade = sc.nextDouble();
                    sc.nextLine();

                    if (grade >= 0 && grade <= 100) {
                        break;
                    } else {
                        System.out.println(
                                "\u001B[31mInvalid input. Please enter a valid grade between 0 and 100! \u001B[0m");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number for the grade! \u001B[0m");
                    sc.next(); // Consume the invalid input to avoid an infinite loop
                }
            }

            

            double gradePoints;
            if (grade >= 95) {
                gradePoints = 4.0;
            } else if (grade >= 90) {
                gradePoints = 3.7;
            } else if (grade >= 85) {
                gradePoints = 3.3;
            } else if (grade >= 80) {
                gradePoints = 3.0;
            } else if (grade >= 75) {
                gradePoints = 2.7;
            } else if (grade >= 70) {
                gradePoints = 2.3;
            } else if (grade >= 65) {
                gradePoints = 2.0;
            } else if (grade >= 60) {
                gradePoints = 1.7;
            } else if (grade >= 55) {
                gradePoints = 1.3;
            } else if (grade >= 50) {
                gradePoints = 1.0;
            } else if (grade >= 45) {
                gradePoints = 0.7;
            } else {
                gradePoints = 0.0;
            }
            totalGradePoints += gradePoints * subject.getCreditHours();
            totalCreditHours += subject.getCreditHours();
        }
        System.out.println("--------------------------------------------------");
        typewriterPrint("\u001B[31mCalculating GPA.....\u001B[0m");
        System.out.println("\u001B[33mYour total GPA is: \u001B[1;31m" + Math.round((totalGradePoints / totalCreditHours) * 100.0) / 100.0 + "\u001B[0m");
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void GPA5(ArrayList<Subject> subjects) {
        Scanner sc = new Scanner(System.in);
        double totalGradePoints = 0;
        int totalCreditHours = 0;

        for (Subject subject : subjects) {
            double grade;
            while (true) {
                try {
                    System.out.print("Enter " + subject.getName() + " final grade: ");
                    grade = sc.nextDouble();
                    sc.nextLine();

                    if (grade >= 0 && grade <= 100) {
                        break;
                    } else {
                        System.out.println(
                                "\u001B[31mInvalid input. Please enter a valid grade between 0 and 100! \u001B[0m");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number for the grade! \u001B[0m");
                    sc.next(); // Consume the invalid input to avoid an infinite loop
                }
            }


            double gradePoints;
            if (grade >= 90) {
                gradePoints = 5.0; // A+
            } else if (grade >= 85) {
                gradePoints = 4.0; // A
            } else if (grade >= 80) {
                gradePoints = 3.0; // A-
            } else if (grade >= 75) {
                gradePoints = 2.0; // B+
            } else if (grade >= 70) {
                gradePoints = 1.0; // B
            } else if (grade >= 65) {
                gradePoints = 0.7; // B-
            } else if (grade >= 60) {
                gradePoints = 0.0; // C+
            } else if (grade >= 55) {
                gradePoints = 0.0; // C
            } else if (grade >= 50) {
                gradePoints = 0.0; // C-
            } else if (grade >= 45) {
                gradePoints = 0.0; // D+
            } else if (grade >= 40) {
                gradePoints = 0.0; // D
            } else {
                gradePoints = 0.0; // D- and F
            }
            totalGradePoints += gradePoints * subject.getCreditHours();
            totalCreditHours += subject.getCreditHours();
        }
        System.out.println("--------------------------------------------------");
        typewriterPrint("\u001B[31mCalculating GPA.....\u001B[0m");
        System.out.println("\u001B[33mYour total GPA is: \u001B[1;31m" + Math.round((totalGradePoints / totalCreditHours) * 100.0) / 100.0 + "\u001B[0m");
        System.out.println("--------------------------------------------------");
    }

    // !---------------------------------------------------------------------------------
    private static void typewriterPrint(String text) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(50);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }
}