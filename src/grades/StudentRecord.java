package grades;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this is a concrete class that represents a Student record.
 */
public class StudentRecord {
  private final String firstName;
  private final String lastName;
  private final List<Double> percentagePoints;

  /**
   * This is the constructor that creates a student record.
   */
  public StudentRecord(String fName, String lName, double[] points) {
    this.firstName = fName;
    this.lastName = lName;
    this.percentagePoints =
            Arrays.stream(points).boxed().collect(Collectors.toList());
  }

  /**
   * this method returns the first name of the student.
   *
   * @return the first name of the student in String form.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * this method returns the last name of the student.
   *
   * @return the last name of the student in String form.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * This method takes in the weights and returns the grade.
   *
   * @param weights weights on each assignments
   * @return the grade.
   * @throws IllegalArgumentException if number of weights is not equal to number of assignment.
   */
  public double getGrade(List<Double> weights) throws IllegalArgumentException {
    if (weights.size() != percentagePoints.size()) {
      throw new IllegalArgumentException("Number of weights is not equal to "
              + "number of assignments");
    }
    double score = 0;
    for (int i = 0; i < weights.size(); i++) {
      score += weights.get(i) * percentagePoints.get(i);
    }
    return score / 100;
  }


}
