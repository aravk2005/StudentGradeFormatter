public class Course {
  private String studentID;
  private String courseID;
  private double test1;
  private double test2;
  private double test3;
  private double finalExam;

  public Course(String studentID, String courseID, double test1, double test2, double test3, double finalExam) {
    this.studentID = studentID;
    this.courseID = courseID;
    this.test1 = test1;
    this.test2 = test2;
    this.test3 = test3;
    this.finalExam = finalExam;
  }

  public Course() {
  }

  double calculateFinalGrade() {
    return (test1 + test2 + test3) * 0.2 + finalExam * 0.4;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getCourseID() {
    return courseID;
  }

  public void setCourseID(String courseID) {
    this.courseID = courseID;
  }

  public double getTest1() {
    return test1;
  }

  public void setTest1(double test1) {
    this.test1 = test1;
  }

  public double getTest2() {
    return test2;
  }

  public void setTest2(double test2) {
    this.test2 = test2;
  }

  public double getTest3() {
    return test3;
  }

  public void setTest3(double test3) {
    this.test3 = test3;
  }

  public double getFinalExam() {
    return finalExam;
  }

  public void setFinalExam(double finalExam) {
    this.finalExam = finalExam;
  }
}
