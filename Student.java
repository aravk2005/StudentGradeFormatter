/*
studentID (String or long): Identifier for every individual student
studentName: Full name of student
Courses (ArrayList<Course>): Full list of Course objects student is currently enrolled in
 */

import java.util.ArrayList;

// Method Overloading here. (Constructors)
public class Student {
  private String studentID;
  private String studentName;
  private ArrayList<Course> courses;

  Student(String studentID, String studentName) {
    this.studentID = studentID;
    this.studentName = studentName;
  }

  Student(String studentID, String studentName, ArrayList<Course> courses) {
    this.studentID = studentID;
    this.studentName = studentName;
    this.courses = courses;
  }

  // get studentID
  String getStudentID() {
    return this.studentID;
  }

  // get Stundent Name
  String getStudentName() {
    return this.studentName;
  }

  // get Course list
  ArrayList<Course> getCourses() {
    return this.courses;
  }

  // Add a course to student courselist
  void setCourse(Course course) {
    this.courses.add(course);
  }

}
