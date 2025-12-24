package FunctionalProgrammingProject;
import java.util.ArrayList;
import java.util.List;
public class Student {

    String name;
    String id;
    String email;
    int age;
    List<Double> grades;
    String major;

    /**
     * @param name
     * @param id
     * @param email
     * @param age
     * @param grades
     * @param major
     */
    public Student(String name, String id, String email,
                   int age, List<Double> grades, String major) {


        this.name = name;
        this.id = id;
        this.email = email;
        this.age = age;
        this.grades = new ArrayList<>(grades);
        this.major = major;


    }

    //Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public List<Double> getGrades() { return new ArrayList<>(grades); }
    public String getMajor() { return major; }



}


enum Validation {

    SUCCESS,
    INVALID_EMAIL,
    INVALID_AGE,
    INVALID_GRADES,
    INVALID_NAME;

    public boolean isSuccess() {
        return this == SUCCESS;
    }


}