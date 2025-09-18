public class Subject {
    private String name;
    private float grade;
    private int creditHours;
    private double studyHours;


    public Subject() {
        
    }

    

    public Subject(String name, float grade, int creditHours) {
        this.name = name;
        this.grade = grade;
        this.creditHours = creditHours;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return this.grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }


    public double getStudyHours() {
        return this.studyHours;
    }

    public void setStudyHours(double studyHours) {
        this.studyHours = studyHours;
    }
}