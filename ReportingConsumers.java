package FunctionalProgrammingProject;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import java.util.List;
public class ReportingConsumers implements GradeApplications {


    static Consumer<Student> printStudentReport = student -> System.out.println("Student: " + student.getName()
            + " \nEmail: " + student.getEmail()
            + "  \nAverage: " + calculateAverage.apply(student)
    );

    //Logs failing students
    static Consumer<Student> logFailingStudent = student -> {

        student.getGrades().forEach(grades -> {

            if (getLetterGrade.apply(grades).equals("f"))

                System.out.println("Failed Student");


        });

        System.out.println("Passing!");
    };

    static Consumer<Student> fullStudentReport = student -> printStudentReport.andThen(logFailingStudent);


    //Outputs a warning if students average is lower than threshold
    static BiConsumer<Student, Double> warnBeloThreshold = (student, threshold) -> {
        double avg = calculateAverage.apply(student);

        if(avg>=threshold) {System.out.println("Student is above threshold");}

        else{System.out.println("WARNING: Student is below threshold");}


    };

}
