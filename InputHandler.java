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

        //Start of new code, O(n)
        int i = 0;
        boolean added = false;
        //If the list is empty, add element to it
        if (studentList.isEmpty()){
          studentList.add(new Student(studentInfo[0], studentInfo[1]));
          added = true;
        }
        //Iterate until the current studentID at the point in the list where it is sorted
        while(i<studentList.size() && added == false){
          if (studentList.get(i).getStudentID().compareTo(studentInfo[0]) > 0){
            studentList.add(i, new Student(studentInfo[0], studentInfo[1]));
            added = true;
          }
          i++;
        }
        //If the element has not been added yet, put it at the end
        if(added == false){
          studentList.add(new Student(studentInfo[0], studentInfo[1]));
        }
        //End of new code

        //Old code, O(1)
        //studentList.add(new Student(studentInfo[0], studentInfo[1]));
      }
      myReader.close();
    } catch (Exception e) {
      throw e;
    }
  }

  void readCourseFile(ArrayList<Course> courseList) throws Exception {
    try {
      int i;
      boolean negative = false;
      File courseFile = new File(this.courseFilePath);
      Scanner myReader = new Scanner(courseFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] courseInfo = data.split(",");

        //Start of new code, O(n)
        i = 0;
        boolean added = false;
        //If the list is empty, add element to it
        if (courseList.isEmpty()){
          courseList.add(new Course(courseInfo[0].trim(), courseInfo[1], Integer.parseInt(courseInfo[2].trim()),
                Integer.parseInt(courseInfo[3].trim()), Integer.parseInt(courseInfo[4].trim()),
                Integer.parseInt(courseInfo[5].trim())));
          added = true;
        }

        //Iterate until the current courseID at the point in the list where it is sorted
        while(i<courseList.size() && added == false){
          if (courseList.get(i).getCourseID().compareTo(courseInfo[1]) > 0){
            courseList.add(i, new Course(courseInfo[0].trim(), courseInfo[1], Integer.parseInt(courseInfo[2].trim()),
                Integer.parseInt(courseInfo[3].trim()), Integer.parseInt(courseInfo[4].trim()),
                Integer.parseInt(courseInfo[5].trim())));
            added = true;
          }
          i++;
        }
        //If the element has not been added yet, put it at the end
        if(added == false){
          courseList.add(new Course(courseInfo[0].trim(), courseInfo[1], Integer.parseInt(courseInfo[2].trim()),
                Integer.parseInt(courseInfo[3].trim()), Integer.parseInt(courseInfo[4].trim()),
                Integer.parseInt(courseInfo[5].trim())));
        }

        for (i = 2; i<=5; i++){
          if (!(courseInfo[i].trim().charAt(0) >='0' && courseInfo[i].trim().charAt(0) <='9')){
            System.out.println("Error, negative value found");
            courseList.clear();
            negative = true;
          }
        //End of new code
        
        //Old code, just appends to end of list O(1)
        /*courseList
            .add(new Course(courseInfo[0].trim(), courseInfo[1], Integer.parseInt(courseInfo[2].trim()),
                Integer.parseInt(courseInfo[3].trim()), Integer.parseInt(courseInfo[4].trim()),
                Integer.parseInt(courseInfo[5].trim())));*/
      }
      myReader.close();
    } catch (Exception e) {
      throw e;
    }
  }
}
