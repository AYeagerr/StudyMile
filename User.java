public abstract class User{
    
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String gender;


    public User() {
    }


    public User(String name, int age, String phoneNumber, String gender) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getGender() {
        return this.gender;
    }

     public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            "}";
    }

    //!---------------------------------
    public abstract void Register(FileOperations f);
    //!---------------------------------



}