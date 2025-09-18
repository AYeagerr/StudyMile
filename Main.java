import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            try {
                FileOperations sFile = new FileOperations("User's Info.txt");
                FileOperations coursesFile = new FileOperations("Student's courses.txt");
                FileOperations planeFile = new FileOperations("Student Plane.txt");
                FileOperations toDOList = new FileOperations("To Do List.txt");
                User s = new Student(toDOList);

                System.out.print("\u001B[2J");
                typewriterPrint("\u001B[32mWelcome to StudyMile - Your Personal Study Companion!\u001B[0m");
                typewriterPrint("\u001B[32mLet's embark on a journey of academic success together.\u001B[0m");
                
                //! Account Checking
                Student s1 = (Student) s;
                
                if (sFile.check()) {
                    System.out.println(); //space
                    System.out.println("\u001B[31mWelcome back again!\u001B[0m");
                    System.out.println(); //space
                    if (!coursesFile.check()) {
                        System.out.println("\u001B[33mDo you want to enter your courses ? (y/n)\u001B[0m");
                        char choice = sc.nextLine().charAt(0);
                        if (choice == 'y' || choice == 'Y') {
                            System.out.println(); //space
                            s1.inputSubjects(coursesFile);
                        } else {
                            System.exit(-1);

                        }
                    }
                } else {
                    System.out.println(); // Clear space
                    System.out.println("\u001B[31mWe first need to register!\u001B[0m");
                    System.out.println(); // clear space
                    s1.Register(sFile);
                    System.out.println("\u001B[33mDo you want to enter your courses ? (y/n)\u001B[0m");
                    char choice = sc.nextLine().charAt(0);
                    if (choice == 'y' || choice == 'Y') {
                        s1.inputSubjects(coursesFile);
                    } else {
                        System.exit(-1);
                    }

                }
            
            while (true) {
                System.out.println("\u001B[31mPlease choose an option:\u001B[0m");
                System.out.println("\u001B[33m1- My profile");
                System.out.println("2- Update my courses");
                System.out.println("3- Grade tracker");
                System.out.println("4- GPA calculator");
                System.out.println("5- Plan generator");
                System.out.println("6- To-Do-list");
                System.out.println("7- Exit\u001B[0m");
            

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                    System.out.println("--------------------------------------");
                        System.out.println("Please choose an option:");
                        System.out.println("1- View profile");
                        System.out.println("2- Update profile");
                        System.out.println("3- Return to main menu");
                        System.out.println("--------------------------------------"); 
                        int subChoicee = sc.nextInt();
                        switch (subChoicee) {
                            case 1:
                                s1.viewProfile(sFile);
                                break;
                            case 2:
                                s1.UpdateProfile(sFile);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid Choice, Please try again.");
                        }
                        break;
                    case 2:
                        System.out.println("--------------------------------------");
                        s1.updateCourses(coursesFile ,"Student's courses.txt" );
                        break;
                    case 3:
                        System.out.println("(-1) means no assigned grade !");
                        s1.trackGrades(coursesFile);
                        break;
                    case 4:
                        System.out.println("--------------------------------------");
                        System.out.println("Please choose an option:");
                        System.out.println("1- 4.0 GPA Scale");
                        System.out.println("2- 5.0 GPA Scale");
                        System.out.println("3- Return to main menu");
                        System.out.println("--------------------------------------");
                        int subChoice1 = sc.nextInt();
                        switch (subChoice1) {
                            case 1:
                                s1.calculateGPA4(coursesFile);
                                break;
                            case 2:
                                s1.calculateGPA5(coursesFile);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid Choice, Please try again.");
                        }
                        break;
                    case 5:
                        System.out.println("--------------------------------------");
                        System.out.println("Please choose an option:");
                        System.out.println("1- Generate Plan");
                        System.out.println("2- Track progress");
                        System.out.println("3- Return to main menu");
                        System.out.println("--------------------------------------");
                        int subChoice2 = sc.nextInt();
                        switch (subChoice2) {
                            case 1:
                                s1.generatePlan(planeFile, coursesFile);
                                break;
                            case 2:
                                s1.Trackprogress(planeFile);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose a valid option.");
                        }
                        break;
                    case 6:
                        System.out.println("--------------------------------------");
                        System.out.println("Please choose an option:");
                        System.out.println("1- Add to To-Do-List");
                        System.out.println("2- Mark done");
                        System.out.println("3- Check progress");
                        System.out.println("4- Return to main menu");
                        System.out.println("--------------------------------------");
                        int subChoice5 = sc.nextInt();
                        switch (subChoice5) {
                            case 1:
                                s1.creatToDoList(toDOList);
                                
                                break;
                            case 2:
                                s1.checkTasks(toDOList);
                                
                                break;
                            case 3:
                                s1.toDoListProgress(toDOList);
                            
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose a valid option.");
                        }
                        break;
                    case 7:
                        typewriterPrint("\u001B[32mThanks for using StudyMile! Best of luck with your studies, and feel free to return anytime. Have a great day!\u001B[0m");
                        System.exit(0);
                    default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    }
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mAn unexpected error occurred: " + e.getMessage() + "\u001B[0m");
                e.printStackTrace();
            } finally {
                sc.close();
            }
        }

        // !---------------------------------------------------------------------------------
        private static void typewriterPrint(String text) {
            try {
                for (char c : text.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(25);
                }
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }