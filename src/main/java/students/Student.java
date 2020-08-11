package students;

import java.util.Arrays;
import java.util.List;

public class Student {
  private String name;
  private int grade;
  private List<String> courses;

  protected Student(String name, int grade, String ... courses) {
    this.name = name;
    this.grade = grade;
    this.courses = Arrays.asList(courses);
  }

  public static Student ofNameGradeCourses(String name, int grade, String ... courses) {
    if (name == null || grade < 0 || grade > 100) throw new IllegalArgumentException();
    if (grade > 75) {
      return new VIPStudent(name, grade, courses);
    } else {
      return new Student(name, grade, courses);
    }
  }

  public String getName() {
    return name;
  }

  public int getGrade() {
    return grade;
  }

  public List<String> getCourses() {
    return courses;
  }

  public long getDonation() {
    return 0;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", grade=" + grade +
        ", courses=" + courses +
        '}';
  }
}
