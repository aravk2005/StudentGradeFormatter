// Overloading happening here (Constructors)

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
  private String studentFilePath;
  private String courseFilePath;

  InputHandler() {
    this.studentFilePath = "";
    this.courseFilePath = "";
  }

  InputHandler(String studentFilePath, String courseFilePath) {
    this.studentFilePath = studentFilePath;
    this.courseFilePath = courseFilePath;
  }

  void setStudentFilePath(String studentFilePath) {
    this.studentFilePath = studentFilePath;
  }

  void setCourseFilePath(String courseFilePath) {
    this.courseFilePath = courseFilePath;
  }

  void readNameFile(ArrayList<Student> studentList) throws Exception {
    try {
      File studentFile = new File(this.studentFilePath);
      Scanner myReader = new Scanner(studentFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] studentInfo = data.split(",");
        studentList.add(new Student(studentInfo[0], studentInfo[1]));
      }
      myReader.close();
    } catch (Exception e) {
      throw e;
    }
  }

  void readCourseFile(ArrayList<Course> courseList) throws Exception {
    try {
      File courseFile = new File(this.courseFilePath);
      Scanner myReader = new Scanner(courseFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] courseInfo = data.split(",");
        courseList
            .add(new Course(courseInfo[0].trim(), courseInfo[1], Integer.parseInt(courseInfo[2].trim()),
                Integer.parseInt(courseInfo[3].trim()), Integer.parseInt(courseInfo[4].trim()),
                Integer.parseInt(courseInfo[5].trim())));
      }
      myReader.close();
    } catch (Exception e) {
      throw e;
    }
  }
}
