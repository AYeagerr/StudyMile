/**
 * Constants class for StudyMile application
 */
public class Constants {
    
    // Age validation constants
    public static final int MIN_AGE = 16;
    public static final int MAX_AGE = 50;
    
    // Credit hours constants
    public static final int CREDIT_HOURS_2 = 2;
    public static final int CREDIT_HOURS_3 = 3;
    
    // Grade constants
    public static final float NO_GRADE = -1.0f;
    public static final float MIN_GRADE = 0.0f;
    public static final float MAX_GRADE = 100.0f;
    
    // Phone number constants
    public static final int PHONE_NUMBER_LENGTH = 11;
    
    // Study level constants
    public static final float WEAK_LEVEL_MAX = 50.0f;
    public static final float MEDIUM_LEVEL_MAX = 75.0f;
    
    // Density adjustment factors
    public static final double ENTRY_LEVEL_FACTOR = 1.5;
    public static final double WEAK_LEVEL_FACTOR = 1.5;
    public static final double MEDIUM_LEVEL_FACTOR = 1.2;
    public static final double EXPERT_LEVEL_FACTOR = 1.0;
    
    // File names
    public static final String USER_INFO_FILE = "User's Info.txt";
    public static final String COURSES_FILE = "Student's courses.txt";
    public static final String PLAN_FILE = "Student Plane.txt";
    public static final String TODO_FILE = "To Do List.txt";
    
    // Color codes
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String RED_COLOR = "\u001B[31m";
    public static final String GREEN_COLOR = "\u001B[32m";
    public static final String YELLOW_COLOR = "\u001B[33m";
    public static final String BLUE_COLOR = "\u001B[34m";
    public static final String BOLD_RED_COLOR = "\u001B[1;31m";
    public static final String BOLD_GREEN_COLOR = "\u001B[1;32m";
    public static final String BOLD_YELLOW_COLOR = "\u001B[1;33m";
    
    // Menu options
    public static final int PROFILE_OPTION = 1;
    public static final int UPDATE_COURSES_OPTION = 2;
    public static final int GRADE_TRACKER_OPTION = 3;
    public static final int GPA_CALCULATOR_OPTION = 4;
    public static final int PLAN_GENERATOR_OPTION = 5;
    public static final int TODO_LIST_OPTION = 6;
    public static final int EXIT_OPTION = 7;
    
    // Sub-menu options
    public static final int VIEW_PROFILE_OPTION = 1;
    public static final int UPDATE_PROFILE_OPTION = 2;
    public static final int RETURN_OPTION = 3;
    
    public static final int GPA_4_SCALE_OPTION = 1;
    public static final int GPA_5_SCALE_OPTION = 2;
    
    public static final int GENERATE_PLAN_OPTION = 1;
    public static final int TRACK_PROGRESS_OPTION = 2;
    
    public static final int ADD_TODO_OPTION = 1;
    public static final int MARK_DONE_OPTION = 2;
    public static final int CHECK_PROGRESS_OPTION = 3;
    
    // Choice constants
    public static final int YES = 1;
    public static final int NO = 0;
    
    // Add/Remove course options
    public static final int ADD_COURSE_OPTION = 1;
    public static final int REMOVE_COURSE_OPTION = 2;
}
