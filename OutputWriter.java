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
    try {
      FileWriter myWriter = new FileWriter(this.outputPath);
      for (Student st: studentList){
        for (Course co: courseList){
          if (st.getStudentID().equals(co.getStudentID())){
            myWriter.write(st.getStudentID() + ", " + st.getStudentName() + ", " + co.getCourseID() + ", " +String.format( "%.1f",co.calculateFinalGrade() )+"\n");
          }
        }
      }
      myWriter.close();
    } catch (Exception e) {
      throw e;
    }
  }
}
