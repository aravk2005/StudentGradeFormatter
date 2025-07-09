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
      for (student Student: studentList){
        for (course Course: courseList){
          if (Student.getStudentID() == Course.getStudentID()){
            myWriter.write(Student.getStudentID() + "," + Student.getStudentName() + "," + Course.getCourseID() + "," + Course.calculateFinalGrade());
          }
        }
      }
      myWriter.close();
    } catch (Exception e) {
      throw e;
    }
  }
}
