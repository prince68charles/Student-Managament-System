package FunctionalProgrammingProject;
import java.util.List;
import java.util.stream.Collectors;


public class GradeProcessor {


    public static List<Student> getTopStudents(List<Student> students) {


        return students.stream()
                .filter(student -> student.getGrades().
                        stream().mapToDouble(Double :: doubleValue)
                        .average()
                        .orElse(0.0) >= (85)).toList();
    }

    public static List<String> getQualifedStudents(List<Student> students) {


        return students.stream()
                .filter(student -> student.getAge() <22)
                .filter(student -> student.getGrades()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average().orElse(0.0) >= 80.0)
                .map(Student::getName)
                .sorted()
                .toList();
    }

}
