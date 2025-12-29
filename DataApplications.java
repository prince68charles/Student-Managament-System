package FunctionalProgrammingProject;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.stream.Collectors;


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

    static Predicate<Student> specialCase = isHonoursStudent.or(student -> student.getAge() < 20);


    public class DataSuppliers {

        static Supplier<Double> randomGrade = () -> ThreadLocalRandom.current().nextDouble(1,101);


    }

    public class StudentQueries {


        static List<Student> getTopPerformers(List<Student> students) {

            return students.stream().filter(
                    student -> calculateAverage.apply(student) >= 80).toList();


        };


        static double getClassAverage(List<Student> students) {

            return students.stream().mapToDouble(calculateAverage::apply).average().orElse(0.0);

        };



        static Map<String,List<Student>> groupByLetterGrade(List<Student> students) {


            return students.stream().collect(Collectors.groupingBy(getStudentLetterGrade::apply));
        }

        static List<Student> getTop3(List<Student> students) {


            return students.stream().sorted(

                    Comparator.comparingDouble(calculateAverage::apply).reversed()

            ).limit(3).toList();


        }

        static List<Double> getAllUniuqeGrades(List<Student> students) {

            return students.stream()
                    .flatMap(student -> student.getGrades().stream())
                    .distinct().sorted().toList();

        }


        static List<Student> getStudentsWithExcellence(List<Student> students) {

            return students.stream().filter(student ->

                    student.getGrades().stream().anyMatch(grade -> grade>=95)

                    ).toList();

        }


    }


    public class OptionalQueries{

        static Optional<Student> findStudentByID(List<Student> students, String ID) {

            return students.stream()
                    .filter(student -> student.getId().equals(ID)).findFirst();
        }


        static Optional<Double> findHighestGrade(List<Student> students) {

           return students.stream().flatMap(student ->
                   student.getGrades().stream()).max(Double::compare);



        }
    }


}
