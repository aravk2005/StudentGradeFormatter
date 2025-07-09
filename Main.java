import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    InputHandler input = new InputHandler("./NameFile.txt", "./CourseFile.txt");
    OutputWriter output = new OutputWriter("./OutputFile");
    ArrayList<Student> studentList = new ArrayList<Student>();
    ArrayList<Course> courseList = new ArrayList<Course>();
    try {
      input.readNameFile(studentList);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    for (Student val : studentList) {
      System.out.println(val.getStudentID());
      System.out.println(val.getStudentName());

    }
    try {
      input.readCourseFile(courseList);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    for (Course val : courseList) {
      System.out.println(val.getStudentID());
      System.out.println(val.getCourseID());
      System.out.println(val.getTest1());
      System.out.println(val.getFinalExam());

    }
    try {
      output.writeOutputFile(studentList, courseList)
    } catch (Excpetion e) {
      System.out.println(e.toString());
    }
  }
}
