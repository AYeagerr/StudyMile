import java.util.ArrayList;
import java.util.Scanner;

public class Progress {

    // ! Method to calculate the completion percentage(based on to do list)
    public void calculateCompletionPercentage(ToDoList toDoList) {
        int totalTasks = toDoList.getNumberofTasks();
        int completedTasks = toDoList.getNumberOfTasksAfterRemove();
        int remainingTasks = totalTasks - completedTasks;
        
        System.out.println("\u001B[32m=== To-Do List Progress ===\u001B[0m");
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + completedTasks);
        System.out.println("Remaining tasks: " + remainingTasks);
        
        double percentage;
        if (totalTasks > 0) {
            percentage = ((double) completedTasks / totalTasks) * 100;
        } else {
            percentage = 100.0; // If there are no tasks, consider the completion percentage as 100%
        }

        if (percentage == 100.0) {
            System.out.println("\u001B[32mCongratulations! You have completed all your tasks.\u001B[0m");
        } else {
            String doubleOutput = String.format("%.1f", percentage);
            System.out.println("\u001B[33mYou have completed " + doubleOutput + "% of your tasks.\u001B[0m");
        }
        
        System.out.println("----------------------------------------");
        toDoList.printTasks();
    }

    
    // ! Check study hours
    public void checkStudyProgress(ArrayList<Subject> subjects) {
        Scanner sc = new Scanner(System.in);
            System.out.println("\u001B[32m=== Study Progress Tracker ===\u001B[0m");
            
            for (Subject subject : subjects) {
                System.out.println("\u001B[33mSubject: " + subject.getName() + "\u001B[0m");
                System.out.println("Assigned study hours: " + subject.getStudyHours());

                double hoursStudied = -1;
                while (hoursStudied < 0) {
                    System.out.print("\u001B[33mEnter the number of hours you studied for " + subject.getName() + ": \u001B[0m");
                    if (sc.hasNextDouble()) {
                        hoursStudied = sc.nextDouble();
                        if (hoursStudied < 0) {
                            System.out.println("\u001B[31mInvalid input. Please enter a non-negative number.\u001B[0m");
                        }
                    } else {
                        System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                        sc.next(); // Consume the invalid input
                    }
                }

                if (hoursStudied >= subject.getStudyHours()) {
                    System.out.println("\u001B[32mCongratulations! You have completed all the assigned study hours for "
                            + subject.getName() + ".\u001B[0m");
                } else {
                    System.out.println("\u001B[31mYou have not completed all the assigned study hours for " + subject.getName() + ".\u001B[0m");
                    System.out.println("\u001B[33mKeep going and study " + String.format("%.2f", (subject.getStudyHours() - hoursStudied))
                            + " more hours for " + subject.getName() + ".\u001B[0m");
                }
                System.out.println("---------------------------------------------------------");
            }
    }

    // ! Grades comparison
    public void updateAndCompareGrades(ArrayList<Subject> subjects, FileOperations myfile) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\u001B[32m=== Grade Tracker ===\u001B[0m");
            
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println("------------------------------------------");
                System.out.println("\u001B[33mSubject: " + subjects.get(i).getName() + "\u001B[0m");
                if (subjects.get(i).getGrade() == -1.0) {
                    System.out.println("Current grade: Not assigned");
                } else {
                    System.out.println("Current grade: " + subjects.get(i).getGrade() + "%");
                }
                System.out.println("------------------------------------------");

                int s = -1; // Initialize to an invalid value
                while (s != 0 && s != 1) {
                    System.out.println("\u001B[33mDo you have a new grade for this subject? (1 for yes and 0 for no)\u001B[0m");
                    if (scanner.hasNextInt()) {
                        s = scanner.nextInt();
                    } else {
                        System.out.println("\u001B[31mInvalid input. Please enter 1 or 0.\u001B[0m");
                        scanner.next(); // Consume the invalid input
                    }
                }

                if (s == 1) {
                    float newGrade = -1;
                    while (newGrade < 0 || newGrade > 100) {
                        System.out.print("\u001B[33mEnter new grade in percentage (between 0 and 100): \u001B[0m");
                        if (scanner.hasNextFloat()) {
                            newGrade = scanner.nextFloat();
                            if (newGrade < 0 || newGrade > 100) {
                                System.out.println("\u001B[31mInvalid input. Grade must be between 0 and 100.\u001B[0m");
                            }
                        } else {
                            System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                            scanner.next(); // Consume the invalid input
                        }
                    }
                    
                    float oldGrade = subjects.get(i).getGrade();
                    if (oldGrade != -1.0) {
                        if (newGrade > oldGrade) {
                            System.out.println("\u001B[32mGreat job! Your grade has increased from " + oldGrade + "% to " + newGrade + "%.\u001B[0m");
                        } else if (newGrade < oldGrade) {
                            System.out.println("\u001B[31mYour grade has decreased from " + oldGrade + "% to " + newGrade + "%. You need to work harder.\u001B[0m");
                        } else {
                            System.out.println("\u001B[33mYour grade is the same. Keep going!\u001B[0m");
                        }
                    } else {
                        System.out.println("\u001B[32mGrade recorded: " + newGrade + "%\u001B[0m");
                    }
                    subjects.get(i).setGrade(newGrade);
                }
            }

            // Update file with new grades
            for (int k = 0; k < subjects.size(); k++) {
                FileOperations.removeRow(myfile.getFilePath(), 1);
            }

            for (int j = 0; j < subjects.size(); j++) {
                myfile.appendData(subjects.get(j).getName() + "\t" + subjects.get(j).getGrade() + "\t"
                        + subjects.get(j).getCreditHours());
            }

            System.out.println("------------------------------------------");
            System.out.println("\u001B[32mGrades updated successfully!\u001B[0m");
    }

}

