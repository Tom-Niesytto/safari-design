package students;

import java.util.*;

public class Student {
  private String name;
  private int grade;
  private List<String> courses;

  protected Student(String name, int grade, String ... courses) {
    this.name = name;
    this.grade = grade;
    this.courses = Arrays.asList(courses);
  }

  private static HashMap<Student, Student> existing = new HashMap<>();

  public static Student ofNameGradeCourses(String name, int grade, String ... courses) {
    Student candidate;
    if (name == null || grade < 0 || grade > 100) throw new IllegalArgumentException();
    if (grade > 75) {
      candidate =  new VIPStudent(name, grade, courses);
    } else {
      candidate = new Student(name, grade, courses);
    }
    boolean newStudent = !existing.containsKey(candidate);
    if (newStudent) {
      existing.put(candidate, candidate);
      return candidate;
    }
    else return existing.get(candidate);
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    Student student = (Student) o;
    return Objects.equals(getName(), student.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
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
