package students;

import java.util.Arrays;
import java.util.List;

public class School {
  public static void showSmartStudents(List<Student> students) {
    for (Student s : students) {
      if (s.getGrade() > 65) {
        System.out.println(s);
      }
    }
  }

  // KNOW WHERE TO LOOK
  // Could you just...
  // Where in that million lines
  // Modules -- "groupings of related stuff"
  // Objects/classes -- same idea!
  // Everything about the essential concept should be in the "one class"
  // DISTINGUISH "this is how a student is, in it's ESSENCE" from
  // "this is how our business domain handles students"

  // Some changes can be "IDE refactoring"
  // BUT, many changes, create merge conflicts on checkin

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        Student.ofNameGradeCourses("Fred", 70, "Math", "Physics"),
        Student.ofNameGradeCourses("Jim", 55, "Art"),
        Student.ofNameGradeCourses("Sheila", 92, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showSmartStudents(roster);
  }
}
