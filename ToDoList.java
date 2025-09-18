import java.util.ArrayList;

public class ToDoList {
    private ArrayList<String> tasks;
    //private int initialTaskCount;
    private int numberofTasks;
    private int numberOfTasksAfterRemove;

    public ToDoList(FileOperations f) {
        this.tasks = f.ReadToDoList();
        numberofTasks = FileOperations.LineCounter(f);
        numberOfTasksAfterRemove = 0;
        //this.initialTaskCount = tasks.size();
    }
    public ToDoList() {
        this.tasks = new ArrayList<>();
        //this.initialTaskCount = 0;
    }

    // Method to add a task to the to-do list
    public void addTask(String task) {
        tasks.add(task);
        numberofTasks++;
        //initialTaskCount++;
    }

    // Method to remove a task from the to-do list
    public void removeTask(int index) {
        tasks.remove(index);
        numberOfTasksAfterRemove++;
        
    }

    
    public int getNumberofTasks() {
        return this.numberofTasks;
    }
    
    public int getNumberOfTasksAfterRemove() {
        return this.numberOfTasksAfterRemove;
    }

    // Method to get the list of tasks
    public String getTasks(int i ) {
        return tasks.get(i);
    }
    public ArrayList<String> getTasks() {
        return tasks;
    }

    // Method to print the tasks in the to-do list
    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\u001B[33mNo tasks in your to-do list.\u001B[0m");
            return;
        }
        
        System.out.println("\u001B[32m=== Your To-Do List ===\u001B[0m");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\u001B[33m" + (i + 1) + ". " + tasks.get(i) + "\u001B[0m");
        }
        System.out.println("------------------------");
    }

    // Method to check if the to-do list is empty
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}