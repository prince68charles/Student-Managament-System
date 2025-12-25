package FunctionalProgrammingProject;
import java.util.List;
import java.util.stream.Collectors;


public class GradeProcessor {


    public static List<Student> getTopStudents(List<Student> students) {



        List<Student> topStudents = students.stream()
                .filter(student -> student.getGrades().
                        stream().mapToDouble(Double :: doubleValue)
                        .average()
                        .orElse(0.0) >= (85)).toList();


        return topStudents;
    }

}
