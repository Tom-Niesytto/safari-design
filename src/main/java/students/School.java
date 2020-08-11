package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {
  // Separation of concerns
  // Know where to look (should be only one place I solve each problem)
  // Don't Repeat Yourself

  public static <E> void showStudents(List<E> ls) {
    for (E s : ls) {
      System.out.println(s);
    }
  }

  // previous form forces duplication
  // imagine we want to send smart students over a network, or to a database
  // do less => more reusable
  // If something must VARY at RUNTIME... It MUST BE A VARIABLE/EXPRESSION...
  public static <E> List<Student> getSmartStudents(List<Student> students, int threshold) {
    List<Student> result = new ArrayList<>();
    for (Student s : students) {
      if (s.getGrade() > threshold) {
        result.add(s);
      }
    }
    return result;
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
        Student.ofNameGradeCourses("Jim", 55, "Art"),
        Student.ofNameGradeCourses("Sheila", 92, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showSmartStudents(roster, 65);
    System.out.println("Two jims are one object? " + (roster.get(1) == roster.get(2)));
  }
}
