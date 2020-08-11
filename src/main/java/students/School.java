package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// This is effectively Predicate
//interface Criterion<E> {
//  boolean test(E s);
//}
//
//class SmartStudentCriterion implements Criterion<Student> {
//  @Override
//  public boolean test(Student s) {
//    return s.getGrade() > 65;
//  }
//}

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
  // Not only "command" but also one variant of "higher order function"
  // Example sort("behavior that orders two items")
  public static <E> List<E> filter(List<E> students, Predicate<E> crit) {
    List<E> result = new ArrayList<>();
    for (E s : students) {
      if (crit.test(s)) {
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

    // "Command" pattern -- pass argument primarily for its behavior (not its state)
    showStudents(filter(roster, s -> s.getGrade() > 65));
    System.out.println("Two jims are one object? " + (roster.get(1) == roster.get(2)));
  }
}
