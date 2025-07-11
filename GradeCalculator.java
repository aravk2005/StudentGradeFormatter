import java.util.ArrayList;

public class GradeCalculator{

    static ArrayList<Double> computeFinalGrades(Student st){
        ArrayList<Double> finalGrades = new ArrayList<>();
        for (Course co : st.getCourses()){
            finalGrades.add(co.calculateFinalGrade());
        }
        return finalGrades;
    }
}
