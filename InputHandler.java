// Overloading happening here (Constructors)

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
    private String studentFilePath;
    private String courseFilePath;

    // Default constructor
    InputHandler() {
        this.studentFilePath = "";
        this.courseFilePath = "";
    }

    // Overloaded constructor
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

                int i = 0;
                boolean added = false;

                // If the list is empty, add element to it
                if (studentList.isEmpty()) {
                    studentList.add(new Student(studentInfo[0], studentInfo[1]));
                    added = true;
                }

                // Insert in sorted order by student ID
                while (i < studentList.size() && !added) {
                    if (studentList.get(i).getStudentID().compareTo(studentInfo[0]) > 0) {
                        studentList.add(i, new Student(studentInfo[0], studentInfo[1]));
                        added = true;
                    }
                    i++;
                }

                // If still not added, append to end
                if (!added) {
                    studentList.add(new Student(studentInfo[0], studentInfo[1]));
                }
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

                i = 0;
                boolean added = false;

                Course newCourse = new Course(
                    courseInfo[0].trim(),
                    courseInfo[1],
                    Integer.parseInt(courseInfo[2].trim()),
                    Integer.parseInt(courseInfo[3].trim()),
                    Integer.parseInt(courseInfo[4].trim()),
                    Integer.parseInt(courseInfo[5].trim())
                );

                // If the list is empty, add the course
                if (courseList.isEmpty()) {
                    courseList.add(newCourse);
                    added = true;
                }

                // Insert in sorted order by course ID
                while (i < courseList.size() && !added) {
                    if (courseList.get(i).getCourseID().compareTo(courseInfo[1]) > 0) {
                        courseList.add(i, newCourse);
                        added = true;
                    }
                    i++;
                }

                // If still not added, append to end
                if (!added) {
                    courseList.add(newCourse);
                }

                // Validate that all score fields are non-negative
                for (i = 2; i <= 5; i++) {
                    if (!(courseInfo[i].trim().charAt(0) >= '0' && courseInfo[i].trim().charAt(0) <= '9')) {
                        System.out.println("Error, negative value found");
                        courseList.clear();
                        negative = true;
                        break;
                    }
                }
            }

            myReader.close();
        } catch (Exception e) {
            throw e;
        }
    }
}


