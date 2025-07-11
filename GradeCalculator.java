import java.util.ArrayList;

public class GradeCalculator{

    static ArrayList<Double> computeFinalGrades(ArrayList<Course> courses){
        ArrayList<Double> finalGrades = new ArrayList<Double>();
        for (Course co : courses){
            finalGrades.add(co.calculateFinalGrade());
        }
        return finalGrades;
    }
}