package FunctionalProgrammingProject;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiFunction;

public interface GradeApplications {


    Function<Student, Double> calculateAverage = student -> student.getGrades().stream()
            .mapToDouble(Double::doubleValue).average().orElse(0.0);

    Function<Double, String> getLetterGrade = grade -> {


        if(grade >= 90) return "A";
        if(grade >= 80) return "B";
        if(grade >= 70) return "C";
        if(grade >= 60) return "D";

        return "f";

    };

    Function<Student, String> getStudentLetterGrade = calculateAverage.andThen(getLetterGrade);


     BiFunction<Student,Student, Double> compareAverages = (studentOne, studentTwo) -> {

        double studentOneAvg = calculateAverage.apply(studentOne);
        double studentTwoAvg = calculateAverage.apply(studentTwo);

        return Math.max(studentOneAvg, studentTwoAvg);


    };

     //Function to apply a 5 point curve to a grade
    Function<Double,Double> applyCurve =  grade -> Math.min(100, grade +5);


    //Apply curve to all grades
    Function<Student, Student> applyCurveToGrades = student -> new Student(
            student.getName(),
            student.getId(),
            student.getEmail(),
            student.getAge(),
            student.getGrades().stream().map(grades -> applyCurve.apply(grades)).toList(),
            student.getMajor()
    );

    class AsycGradeProcessing {

        //Call back method
        static void processGradeAsync(
                List<Double> grades,
                Consumer<Double> onSuccess,
                Consumer<String> onError) {


            new Thread(() -> {

                try {
                    for (Double grade : grades) {

                        double processedGrade = grade * 1.1;

                        // Simulate delay
                        Thread.sleep(100);


                        onSuccess.accept(processedGrade);
                    }

                }

                catch (Exception e) {

                    onError.accept("Error processing grades: " + e.getMessage());
                }

            }).start();






        }



    }

}
