// Overloading happening here (Constructors)

import java.io.FileWriter;
import java.util.ArrayList;

public class OutputWriter {
  private String outputPath;

  OutputWriter() {
    this.outputPath = "";
  }

  OutputWriter(String outputPath) {
    this.outputPath = outputPath;
  }

  void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }

  void writeOutputFile(ArrayList<Student> studentList, ArrayList<Course> courseList) throws Exception {
    ArrayList<Double> stGrades; //Sets up the list of grades students have in their courses
    int i;//List index for the grades
    try {
      FileWriter myWriter = new FileWriter(this.outputPath);
      for (Student st: studentList){
        i = 0; //Sets the inital index to 0 for all students
        stGrades = GradeCalculator.computeFinalGrades(st); //runs computeFinalGrades to initalize the student's grades
        for (Course co: st.getCourses){
          myWriter.write(st.getStudentID() + ", " + st.getStudentName() + ", " + co.getCourseID() + ", " +String.format( "%.1f",stGrades.get(i)) +"\n");
          i++; //increases the index to access the correct grades for the course
        }
      }
      myWriter.close();
    } catch (Exception e) {
      throw e;
    }
  }
}
