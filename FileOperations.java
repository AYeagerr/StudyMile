import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
    private File objfile;

    public static int LineCounter(FileOperations MyFile) {
        // Specify the path to the file
        Path filePath = Paths.get(MyFile.objfile.getPath());
        try {
            int lineCount =(int) Files.lines(filePath).count();
            //System.out.println("Number of lines in the file: " + lineCount);
            return lineCount;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
}

    public String getFilePath(){
        return objfile.getPath();
    }

    public FileOperations(String FileName) {
        this.objfile = new File(FileName);
    }

    public boolean check() {
        if (objfile.exists() && objfile.length() != 0) {
            return true;
        }
        return false;
    }

    public void WriteinFIle(String str) {
        try (FileWriter myWriter = new FileWriter(objfile)) {
            myWriter.write(str);
            System.out.println("\u001B[32mData written successfully.\u001B[0m");
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while writing to file: " + e.getMessage() + "\u001B[0m");
        }
    }

    public void ReadUserInfo() {
        try (Scanner sc = new Scanner(objfile)) {
            System.out.println("\u001B[32m=== Your Profile ===\u001B[0m");
            while (sc.hasNextLine()) {
                int id = Integer.valueOf(sc.next());
                String name = sc.next();
                int age = Integer.valueOf(sc.next());
                String gender = sc.next();
                String phoneNumber = sc.next();
                String majorName = sc.next();
                int sem = Integer.valueOf(sc.next());

                sc.nextLine();

                System.out.println("\u001B[33mID: \u001B[0m" + id);
                System.out.println("\u001B[33mName: \u001B[0m" + name);
                System.out.println("\u001B[33mAge: \u001B[0m" + age);
                System.out.println("\u001B[33mGender: \u001B[0m" + gender);
                System.out.println("\u001B[33mPhone Number: \u001B[0m" + phoneNumber);
                System.out.println("\u001B[33mMajor Name: \u001B[0m" + majorName);
                System.out.println("\u001B[33mSemester: \u001B[0m" + sem);
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while reading user info: " + e.getMessage() + "\u001B[0m");
        }
    }

    public ArrayList<Subject> ReadSubjectInfo() {
        ArrayList<Subject> subject = new ArrayList<>();
        Subject s;
        try (Scanner sc = new Scanner(objfile)) {
            while (sc.hasNextLine()) {
                String Sname = sc.next();
                float grade = Float.valueOf(sc.next());
                int creditHours = Integer.valueOf(sc.nextLine().trim());
                s = new Subject(Sname, grade, creditHours);
                subject.add(s);
            }
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while reading subject info: " + e.getMessage() + "\u001B[0m");
        }
        return subject;
    }
    public ArrayList<Subject> ReadPlaneInfo() {
        ArrayList<Subject> subject = new ArrayList<>();
        Subject s;
        try (Scanner sc = new Scanner(objfile)) {
            while (sc.hasNextLine()) {
                String Sname = sc.next();
                double studyHours = Double.valueOf(sc.nextLine().trim());
                s = new Subject();
                s.setName(Sname);
                s.setStudyHours(studyHours);
                subject.add(s);
            }
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while reading plan info: " + e.getMessage() + "\u001B[0m");
        }
        return subject;
    }


    public void appendData(String s) {
        try (FileWriter myWriter = new FileWriter(objfile, true)) {
            myWriter.write(s + "\n");
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while appending data: " + e.getMessage() + "\u001B[0m");
        }
    }

    public ArrayList<String> ReadToDoList() {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(objfile)) {
            while (sc.hasNextLine()) {
                String Taskname = sc.nextLine();
                list.add(Taskname);
            }
        } catch (IOException e) {
            System.out.println("\u001B[31mAn error occurred while reading to-do list: " + e.getMessage() + "\u001B[0m");
        }
        return list;
    }
    
    public static void removeRow(String filePath, int rowToRemove) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            writer = new BufferedWriter(new FileWriter("temp.txt"));

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (lineNumber != rowToRemove) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            writer.flush();
            writer.close();
            reader.close();

            // Delete original file
            new File(filePath).delete();

            // Rename temporary file to original file
            new File("temp.txt").renameTo(new File(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
