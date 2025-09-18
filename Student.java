import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {

    private static int id = 0;
    private String majorName;
    private int semester;
    private int numSubjects;
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ToDoList tasks  ;
    private Progress progress = new Progress();
    private GpaCalculator gpaCalculator = new GpaCalculator();
    private Plane Plane;

    //! intialize tasks , if the to to list file exist then it assigns the data to the tasks ArrayList
    //! Else creat empty one
    public Student(FileOperations todofile) {
        if (todofile.check()) {
            tasks  = new ToDoList(todofile);
        }else{
            tasks = new ToDoList();
        }
    }

    public Student(String name, int age, String phoneNumber, String gender, String majorName, int semester ) {
        super(name, age, phoneNumber, gender);
        this.majorName = majorName;
        this.semester = semester;
    }

    public String getCollegeName() {
        return this.majorName;
    }

    public void setCollegeName(String majorName) {
        this.majorName = majorName;
    }

    public int getSemester() {
        return this.semester;
    }

    public ArrayList<Subject> getsubjects() {
        return this.subjects;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getNumSubjects() {
        return this.numSubjects;
    }

    //!-------------------------------------------------------------------------------------
    public void inputSubjects(FileOperations myFile) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\u001B[32m=== Add Your Subjects ===\u001B[0m");
            
            while (true) {
                System.out.print("\u001B[33mEnter the number of subjects you have: \u001B[0m");
                if (scanner.hasNextInt()) {
                    numSubjects = scanner.nextInt();
                    if (numSubjects > 0) {
                        break; // Exit the loop if a valid number is entered
                    } else {
                        System.out.println("\u001B[31mInvalid input. Please enter a positive number.\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }
            
            System.out.println("---------------------------------------------");
            for (int i = 0; i < numSubjects; i++) {
                System.out.println("\u001B[33mEnter details for subject " + (i + 1) + ":\u001B[0m");
                System.out.print("\u001B[33mName: \u001B[0m"); //! Can be name or course code
                String name = scanner.next();
                scanner.nextLine();
            
           int s;
        while (true) {
            System.out.println("\u001B[33mDo you have a previous grade? (1 for yes and 0 for no)\u001B[0m");
            if (scanner.hasNextInt()) {
                s = scanner.nextInt();

                if (s == 1 || s == 0) {
                    break; // Exit the loop if a valid number is entered
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter either 1 or 0.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
            float grade = (float) -1.0;
            if (s == 1) {
                System.out.print("\u001B[33mGrade in percentage: \u001B[0m");

            while (!scanner.hasNextFloat()) {
                System.out.println("\u001B[33mPlease enter a valid number!\u001B[0m");
                scanner.next(); // Consume invalid input
    }

            grade = scanner.nextFloat();

    // Ensure grade is within the valid range
        while (grade < 0 || grade > 100) {
            System.out.println("\u001B[31mPlease enter a valid grade between 0 and 100 !\u001B[0m");

        while (!scanner.hasNextFloat()) {
            System.out.println("\u001B[31mPlease enter a valid number!\u001B[0m");
            scanner.next(); // Consume invalid input
        }

        grade = scanner.nextFloat();
    }
            }



            int creditHours = 0; // Declare and initialize creditHours before the loop

            while (true) {
                System.out.print("\u001B[33mCredit Hours: \u001B[0m");
    
                if (scanner.hasNextInt()) {
                    creditHours = scanner.nextInt();
    
                    if (creditHours == 2 || creditHours == 3) {
                        break;
                    } else {
                        System.out.println("\u001B[31mInvalid input. Please enter 2 or 3.\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }
            
            scanner.nextLine();
            System.out.println("-----------------------------------------------");
            Subject subject = new Subject(name, grade, creditHours);
            subjects.add(subject);
            // ---------------------------------------------------------------------------------
            myFile.appendData(subject.getName()+ "\t" + String.valueOf(subject.getGrade())+"\t" + String.valueOf(subject.getCreditHours()));
            }
            
            System.out.println("\u001B[32mSubjects added successfully!\u001B[0m");
    }

    //! ----------------------------------------------------------------------------------------

    public void updateCourses(FileOperations myFile , String FileName) {
         subjects = myFile.ReadSubjectInfo();
        Scanner scanner = new Scanner(System.in);
        int s;
        while (true) {
            System.out.println("\u001B[33mDo you want to update your courses? (1 for yes and 0 for no)\u001B[0m");
            if (scanner.hasNextInt()) {
                s = scanner.nextInt();

                if (s == 1 || s == 0) {
                    break; // Exit the loop if a valid number is entered
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter either 1 or 0.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        scanner.nextLine();
        while (s == 1) {
            System.out.println("\u001B[33mEnter 1 to add a course, 2 to remove a course\u001B[0m");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
            
                    if (choice == 1 || choice == 2) {
                        // Valid choice
                        break;
                    } else {
                        System.out.print("\u001B[33mPlease enter a valid choice (1 or 2): \u001B[0m");
                    }
                } else {
                    System.out.print("\u001B[33mPlease enter a valid choice (1 or 2): \u001B[0m");
                    scanner.nextLine(); // Consume invalid input
                }
            }

            scanner.nextLine();
            if (choice == 1) {
                subjects = myFile.ReadSubjectInfo();
                System.out.println("\u001B[97m---------------------------------------\u001B[0m");
                System.out.println("\u001B[97mMy courses:\u001B[0m");
                for (int i = 0; i < subjects.size(); i++) {
                    System.out.println(subjects.get(i).getName());
                }
                System.out.println("\u001B[97m---------------------------------------\u001B[0m");
                System.out.println("\u001B[33mEnter details for the new subject:\u001B[0m");
                System.out.print("\u001B[33mName: \u001B[0m");
                String name = scanner.next();
                int x;
                while (true) {
                System.out.println("\u001B[33mDo you have a previous grade? (1 for yes and 0 for no)\u001B[0m");
                if (scanner.hasNextInt()) {
                    x = scanner.nextInt();

                if (x == 1 || x == 0) {
                    break; // Exit the loop if a valid number is entered
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter either 1 or 0.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
                scanner.nextLine();
                float grade = (float) -1.0;
                if (x == 1) {
                    System.out.print("\u001B[33mGrade in percentage: \u001B[0m");

            while (!scanner.hasNextFloat()) {
                System.out.println("\u001B[33mPlease enter a valid number!\u001B[0m");
                scanner.next(); // Consume invalid input
    }

            grade = scanner.nextFloat();

    // Ensure grade is within the valid range
        while (grade < 0 || grade > 100) {
            System.out.println("\u001B[31mPlease enter a valid grade between 0 and 100 !\u001B[0m");

        while (!scanner.hasNextFloat()) {
            System.out.println("\u001B[31mPlease enter a valid number!\u001B[0m");
            scanner.next(); // Consume invalid input
        }

        grade = scanner.nextFloat();
    }
}
                int creditHours = 0; // Declare and initialize creditHours before the loop

            while (true) {
                System.out.print("\u001B[33mCredit Hours: \u001B[0m");
    
                if (scanner.hasNextInt()) {
                    creditHours = scanner.nextInt();
    
                    if (creditHours == 2 || creditHours == 3) {
                        break;
                    } else {
                        System.out.println("\u001B[31mInvalid input. Please enter 2 or 3.\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }
                scanner.nextLine();
                System.out.println("-----------------------------------------------");
                Subject subject = new Subject(name, grade, creditHours);
                myFile.appendData(subject.getName()+ "\t" + String.valueOf(subject.getGrade())+"\t" + String.valueOf(subject.getCreditHours()));
                
            } else if (choice == 2) {
                subjects = myFile.ReadSubjectInfo();
                System.out.println("\u001B[97m---------------------------------------\u001B[0m");
                System.out.println("\u001B[97mMy courses:\u001B[0m");
                for (int i = 0; i < subjects.size(); i++) {
                    System.out.println(subjects.get(i).getName());
                }
                System.out.println("\u001B[97m---------------------------------------\u001B[0m");
                System.out.println("\u001B[33mEnter the name of the subject you want to remove (\u001B[31mCase Sensitive!\u001B[33m):\u001B[0m ");
                String name = scanner.next();
                
                int indexOfSubjectToRemove = -1; // Default index value
                
                for (int i = 0; i < subjects.size(); i++) {
                    if (subjects.get(i).getName().equals(name)) {
                        indexOfSubjectToRemove = i;
                        
                        break; // Stop searching once found
                    }
                }
                
                if (indexOfSubjectToRemove != -1) {
                    
                    subjects.remove(indexOfSubjectToRemove);
                    //System.out.println("removed Done 1");
                    FileOperations.removeRow(FileName, indexOfSubjectToRemove + 1);
                    //System.out.println("removed Done 2");
                    System.out.println("\u001B[31mSubject \"" + name + "\" removed.\u001B[0m");
                } else {
                    //System.out.println(subjects.get(1).getName());
                    
                    System.out.println("\u001B[31mThere is no subject with the name " + name + "\u001B[0m");
                }
            }
            System.out.println("\u001B[33mDo you want to update more courses? (1 for yes and 0 for no)\u001B[0m");

            s = scanner.nextInt();
            scanner.nextLine();
        }
        this.Plane = new Plane(subjects);
    }

    // !------------------------------------------------------------------------------------------------------------
    @Override
    public void Register(FileOperations myFile) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\u001B[33mCreate a username: \u001B[0m");
        this.name = scanner.nextLine();

        while (true) {
            System.out.print("\u001B[33mEnter your age: \u001B[0m");
            if (scanner.hasNextInt()) {
                int tempAge = scanner.nextInt();
                if (tempAge >= 16 && tempAge <= 50) {
                    this.age = tempAge;
                    scanner.nextLine(); // Consume the newline character
                    break;
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid age (16 - 50).\u001B[0m");
                    scanner.nextLine(); // Consume the invalid input
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid integer for age.\u001B[0m");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        do {
            System.out.print("\u001B[33mEnter gender: \u001B[0m");
            String inputGender = scanner.nextLine();

            if (inputGender.equalsIgnoreCase("male") || inputGender.equalsIgnoreCase("female")) {
                this.gender = inputGender;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter either 'male' or 'female'.\u001B[0m");
            }
        } while (this.gender == null || (!this.gender.equalsIgnoreCase("male") && !this.gender.equalsIgnoreCase("female")));

        //! Phone num validation

        boolean validInput = false;
    
        while (!validInput) {
            System.out.print("\u001B[33mEnter your phone number: \u001B[0m");

            String input = scanner.nextLine();
    
            // Check if the input contains only numeric characters and if they are 11.
            if (input.matches("\\d{11}")) {
                this.phoneNumber = input;
                validInput = true;
            } else {
                System.out.println("\u001B[31mInvalid input.\u001B[0m");
                System.out.println("\u001B[31mMake sure it contains only numeric characters & has 11 numbers.\u001B[0m");
            }
        }



        boolean validInput2 = false;

        while (!validInput2) {
            System.out.print("\u001B[33mEnter your major: \u001B[0m");
            String input = scanner.next();

        // Check if the input contains only letters
            if (input.matches("[a-zA-Z]+")) {
                this.majorName = input;
                validInput2 = true;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter only letters for your major.\u001B[0m");
            }
        }

        scanner.nextLine(); // Add this line to consume the newline character

        boolean validInput3 = false;

    while (!validInput3) {
        System.out.print("\u001B[33mEnter semester: \u001B[0m");

        // Check if the input is an integer
        if (scanner.hasNextInt()) {
            this.semester = scanner.nextInt();
            validInput3 = true;
        } else {
            System.out.println("\u001B[31mInvalid input. Please enter an integer for the semester.\u001B[0m");
            scanner.next(); // Consume the invalid input to avoid an infinite loop
        }
    }

    System.out.println("----------------------------------------------------------");

        id++;

        //! File Operations
        myFile.appendData(String.valueOf(id) + "\t" + name + "\t" + String.valueOf(age) + "\t" + String.valueOf(gender) + "\t" +String.valueOf(phoneNumber) + "\t" + String.valueOf(majorName) + "\t" + String.valueOf(semester) );
    }

    //!--------------------------------------------------------------------------------

    public void UpdateProfile(FileOperations f) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\u001B[33mUpdate username: \u001B[0m");
        this.name = scanner.nextLine();

        while (true) {
            System.out.print("\u001B[33mEnter your age: \u001B[0m");
            if (scanner.hasNextInt()) {
                int tempAge = scanner.nextInt();
                if (tempAge >= 16 && tempAge <= 50) {
                    this.age = tempAge;
                    scanner.nextLine(); // Consume the newline character
                    break;
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid age (16 - 50).\u001B[0m");
                    scanner.nextLine(); // Consume the invalid input
                }
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter a valid integer for age.\u001B[0m");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        do {
            System.out.print("\u001B[33mEnter gender: \u001B[0m");
            String inputGender = scanner.nextLine();

            if (inputGender.equalsIgnoreCase("male") || inputGender.equalsIgnoreCase("female")) {
                this.gender = inputGender;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter either 'male' or 'female'.\u001B[0m");
            }
        } while (this.gender == null
                || (!this.gender.equalsIgnoreCase("male") && !this.gender.equalsIgnoreCase("female")));

        // ! Phone num validation

        boolean validInput = false;

        while (!validInput) {
            System.out.print("\u001B[33mEnter your phone number: \u001B[0m");

            String input = scanner.nextLine();

            // Check if the input contains only numeric characters and if they are 11.
            if (input.matches("\\d{11}")) {
                this.phoneNumber = input;
                validInput = true;
            } else {
                System.out.println("\u001B[31mInvalid input.\u001B[0m");
                System.out
                        .println("\u001B[31mMake sure it contains only numeric characters & has 11 numbers.\u001B[0m");
            }
        }

        boolean validInput2 = false;

        while (!validInput2) {
            System.out.print("\u001B[33mEnter your major: \u001B[0m");
            String input = scanner.next();

            // Check if the input contains only letters
            if (input.matches("[a-zA-Z]+")) {
                this.majorName = input;
                validInput2 = true;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter only letters for your major.\u001B[0m");
            }
        }

        scanner.nextLine(); // Add this line to consume the newline character

        boolean validInput3 = false;

        while (!validInput3) {
            System.out.print("\u001B[33mEnter semester: \u001B[0m");

            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                this.semester = scanner.nextInt();
                validInput3 = true;
            } else {
                System.out.println("\u001B[31mInvalid input. Please enter an integer for the semester.\u001B[0m");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        System.out.println("----------------------------------------------------------");

        id = 1;
         f.WriteinFIle(String.valueOf(id) + "\t" + name + "\t" + String.valueOf(age) + "\t" + String.valueOf(gender)
                + "\t" + String.valueOf(phoneNumber) + "\t" + String.valueOf(majorName) + "\t"
                + String.valueOf(semester)+"\n");
    }

    //!---------------------------------------------------------------------------------

    public void viewProfile(FileOperations f){
        f.ReadUserInfo();
    }

    // !---------------------------------------------------------------------------------

    public void generatePlan(FileOperations myFile , FileOperations subjectfile) {
        this.Plane = new Plane(subjectfile.ReadSubjectInfo());
        Plane.getDensity();
        Plane.display(myFile);
    }

    // !--------------------------------------------------------------------------------

    public void creatToDoList(FileOperations MyFile) {
        if (MyFile.check()) {
           tasks = new ToDoList(MyFile); 
        }else{
            tasks = new ToDoList();
        }
        
        Scanner sc = new Scanner(System.in);
            System.out.println("\u001B[32m=== Create To-Do List ===\u001B[0m");
            
            int num = -1;
            while (num < 0) {
                System.out.print("\u001B[33mEnter number of tasks you have: \u001B[0m");
                if (sc.hasNextInt()) {
                    num = sc.nextInt();
                    if (num < 0) {
                        System.out.println("\u001B[31mInvalid input. Please enter a non-negative number.\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                    sc.next(); // Consume the invalid input
                }
            }
            
            sc.nextLine(); // Consume the newline after the number
            
            for (int i = 0; i < num; i++) {
                System.out.print("\u001B[33mEnter task " + (i + 1) + " : \u001B[0m");
                String task = sc.nextLine();
                tasks.addTask(task);
                MyFile.appendData(task);
            }
            
            System.out.println("\u001B[32mTo-Do list created successfully!\u001B[0m");
    }   
    
    // !-----------------------------------------------------------------------------------------
    public void checkTasks(FileOperations f ) {
        Scanner sc = new Scanner(System.in);
            tasks = new ToDoList(f);
            if (tasks.isEmpty()) {
                System.out.println("\u001B[32mYaaaay! You have no tasks!\u001B[0m");
            } else {
                System.out.println("\u001B[32m=== Mark Tasks as Complete ===\u001B[0m");
                tasks.printTasks();

                int num = -1;
                while (num < 0) {
                    System.out.print("\u001B[33mEnter number of tasks you are done with: \u001B[0m");
                    if (sc.hasNextInt()) {
                        num = sc.nextInt();
                        if (num < 0) {
                            System.out.println("\u001B[31mInvalid input. Please enter a non-negative number.\u001B[0m");
                        }
                    } else {
                        System.out.println("\u001B[31mInvalid input. Please enter a valid number.\u001B[0m");
                        sc.next(); // Consume the invalid input
                    }
                }

                if (num > 0) {
                    System.out.println("\u001B[33mWrite down task numbers you are done with: \u001B[0m");
                    for (int i = 0; i < num; i++) {
                        int read = -1; // Initialize to an invalid value
                        while (read < 1 || read > tasks.getNumberofTasks()) {
                            if (sc.hasNextInt()) {
                                read = sc.nextInt();
                                if (read < 1 || read > tasks.getNumberofTasks()) {
                                    System.out.println("\u001B[31mInvalid input. Please enter a valid task number.\u001B[0m");
                                }
                            } else {
                                System.out.println("\u001B[31mInvalid input. Please enter a valid integer.\u001B[0m");
                                sc.next(); // Consume the invalid input
                            }
                        }

                        // Process the valid task number
                        tasks.removeTask(read - 1);
                        FileOperations.removeRow(f.getFilePath(), read);
                    }
                }

                if (!(tasks.isEmpty())) {
                    System.out.println("\u001B[33mRemaining tasks:\u001B[0m");
                    tasks.printTasks();
                } else {
                    System.out.println("\u001B[32mYaaaay! Now you have no tasks!\u001B[0m");
                }
            }
    }
    
    // !-------------------------------------------------------------------------------------

    public void toDoListProgress(FileOperations f) {
        //tasks = new ToDoList(f);
        progress.calculateCompletionPercentage(tasks);
    }
    

    // !-------------------------------------------------------------------------------------

    public void trackGrades(FileOperations myfile) {
        subjects = myfile.ReadSubjectInfo();
        progress.updateAndCompareGrades(subjects , myfile);
    }

    // !---------------------------------------------------------------------------------------

    public void Trackprogress(FileOperations myfile) { //? For plane
        subjects = myfile.ReadPlaneInfo();
        progress.checkStudyProgress(subjects);
    }

    // !-----------------------------------------------------------------------------------------
    public void calculateGPA4(FileOperations myfile) {
        
        subjects = myfile.ReadSubjectInfo();
        gpaCalculator.GPA4(subjects);
    }
    
    public void calculateGPA5(FileOperations myfile) {
        subjects = myfile.ReadSubjectInfo();
        gpaCalculator.GPA5(subjects);
    }
    // !-----------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Student{" +
                " majorName='" + majorName + "'" +
                ", semester='" + getSemester() + "'" +
                ", courses='" + getsubjects().toString() + "'" +
                ", id='" + id + "'" +
                "" + super.toString();
    }

}