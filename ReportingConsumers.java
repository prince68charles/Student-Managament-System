package FunctionalProgrammingProject;
import java.util.function.Consumer;

public class ReportingConsumers implements GradeApplications {


    static Consumer<Student> printStudentReport = student -> System.out.println("Student: " + student.getName()
                    + " \nEmail: " + student.getEmail()
                    + "  \nAverage: " + calculateAverage.apply(student)
    );



}
