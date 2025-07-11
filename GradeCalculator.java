import java.util.ArrayList;

public class GradeCalculator {

  static ArrayList<Double> computeFinalGrades(ArrayList<Student> StudentList) {
    ArrayList<Double> finalGrades = new ArrayList<>();
    for (Student st : StudentList) {
      for (Course co : st.getCourses()) {
        finalGrades.add(co.calculateFinalGrade());
      }
    }
    return finalGrades;
  }
}
