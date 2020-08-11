package students;

public class VIPStudent extends Student {

  public VIPStudent(String name, int grade, String... courses) {
    super(name, grade, courses);
  }

  @Override
  public long getDonation() {
    return 1_000_000;
  }
}
