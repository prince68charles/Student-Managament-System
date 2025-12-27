package FunctionalProgrammingProject;
import com.sun.net.httpserver.Authenticator;

import java.util.function.Predicate;


public class DataApplications implements GradeApplications{


    static Predicate<Student> hasValidEmail = student->
            student.getEmail().endsWith(".com")
            && student.getEmail().contains("@");


    static Predicate<Student> isAdult = student ->
            student.getAge()>=18;


    static Predicate<Student> hasPassingGrades = student ->
            calculateAverage.apply(student) >= 60;

    static Predicate<Student> isHonoursStudent = student ->
            calculateAverage.apply(student) >= 85;

    static Predicate<Student> isValidStudent = hasValidEmail.and(isAdult).and(hasPassingGrades);

    static Predicate<Student> specialCase = isHonoursStudent.or(student -> student.getAge() <20);


}
