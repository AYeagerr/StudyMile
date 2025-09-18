import java.util.ArrayList;
import java.util.Scanner;

public class Plane {
    private double hoursPerWeek = -1;
    private int cridet2Counter ;
    private int cridet3Counter ;
    private double density2;
    private double density3;
    private ArrayList<Subject> subjects;

    public int cridet2Count() {
        int cridet2Count = 0;
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCreditHours() == 2) {
                cridet2Count++;
            }
        }
        return cridet2Count;
    }

    public int cridet3Count() {
         int cridet3Count = 0;
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCreditHours() == 3) {
                cridet3Count++;
            }
        }
        return cridet3Count;
    }

    public Plane(ArrayList<Subject> s) {
        this.subjects = s;
        this.cridet2Counter = cridet2Count();
        this.cridet3Counter = cridet3Count();
    }

    // ?-------------------------------------------------------------------------------------
    public void getDensity() {
        Scanner sc = new Scanner(System.in);
            while (hoursPerWeek < 0) {
                System.out.println("\u001B[33mHow many hours are you free this week?\u001B[0m");
                if (sc.hasNextDouble()) {
                    hoursPerWeek = sc.nextDouble();
                    if (hoursPerWeek < 0) {
                        System.out.println("\u001B[31mInvalid input. Please enter a non-negative number.\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                    sc.next(); // Consume the invalid input
                }
            }
            
            double sum = ((cridet2Counter * 2) + (cridet3Counter * 3));
            if (sum > 0) {
                density2 = (2.0 / sum) * hoursPerWeek;
                density3 = (3.0 / sum) * hoursPerWeek;
            } else {
                System.out.println("\u001B[31mNo subjects found. Please add subjects first.\u001B[0m");
                return;
            }
    }

    // ?-------------------------------------------------------------------------------------
    public void display(FileOperations MyFile) {
        if (subjects == null || subjects.isEmpty()) {
            System.out.println("\u001B[31mNo subjects found. Please add subjects first.\u001B[0m");
            return;
        }

        //! deleting the previous plan when generating a new one
        if (MyFile.check()) {
            int lineCount = FileOperations.LineCounter(MyFile);
            for (int i = 0; i < lineCount; i++) {
                FileOperations.removeRow(MyFile.getFilePath(), 1);
            }
        }

        System.out.println("\u001B[32m=== Your Personalized Study Plan ===\u001B[0m");
        System.out.println("Available hours this week: " + hoursPerWeek);
        System.out.println("----------------------------------------");

        ArrayList<String> levels = new ArrayList<>();
        double totalDensity = 0;
        
        // Calculate densities for each subject
        for (int i = 0; i < subjects.size(); i++) {
            double creditHours = subjects.get(i).getCreditHours();
            String level = checkLevel(i);
            levels.add(level);
            
            if (creditHours == 3) {
                double adjustedDensity3 = adjustDensityBasedOnLevel(density3, level);
                totalDensity += adjustedDensity3;
            } else if (creditHours == 2) {
                double adjustedDensity2 = adjustDensityBasedOnLevel(density2, level);
                totalDensity += adjustedDensity2;
            } else {
                System.out.println("\u001B[31mInvalid credit hours system!");
                System.out.println("Credit hours should be 2 or 3!\u001B[0m");
            }
        }

        // Display and save the study plan
        for (int i = 0; i < subjects.size(); i++) {
            double creditHours = subjects.get(i).getCreditHours();
            String level = levels.get(i);
            double finalStudyHours = 0;
            
            if (creditHours == 3) {
                double adjustedDensity3 = adjustDensityBasedOnLevel(density3, level);
                finalStudyHours = (adjustedDensity3 / totalDensity) * hoursPerWeek;
            } else if (creditHours == 2) {
                double adjustedDensity2 = adjustDensityBasedOnLevel(density2, level);
                finalStudyHours = (adjustedDensity2 / totalDensity) * hoursPerWeek;
            }
            
            subjects.get(i).setStudyHours(finalStudyHours);
            String doubleOutput = String.format("%.2f", finalStudyHours);
            
            System.out.println("\u001B[33mStudy " + subjects.get(i).getName() + " for " + doubleOutput + " Hours / Week\u001B[0m");
            System.out.println("   Level: " + level + " | Credit Hours: " + (int)creditHours);
            
            MyFile.appendData(subjects.get(i).getName() + "\t" + doubleOutput);
        }
        
        System.out.println("----------------------------------------");
        System.out.println("\u001B[32mStudy plan saved successfully!\u001B[0m");
    }

    // ?-----------------------------------------------------------------------------------------------------------------

    public String checkLevel(int i) {
        if(subjects.get(i).getGrade() >= 0){
            if (subjects.get(i).getGrade() <= 50) {
                return "Weak";
            } else if (subjects.get(i).getGrade() > 50 && subjects.get(i).getGrade() <= 75) {
                return "Medium";
            } else {
                return "Expert";
            }
        } else {
            return "Entry level";
        }
    }

    // ?-------------------------------------------------------------------------------------
    public double adjustDensityBasedOnLevel(double density, String level) {
        switch (level) {
            case "Entry level":
                return density * 1.5;
            case "Weak":
                return density * 1.5;
            case "Medium":
                return density * 1.2;
            case "Expert":
                return density;
            default:
                return density;
        }
    }
}