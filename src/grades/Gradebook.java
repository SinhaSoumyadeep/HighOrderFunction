package grades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this is a concrete class that represents Grade Book.
 */
public class Gradebook {
  private List<StudentRecord> gradebook;
  private List<String> letterGrades;
  private List<Double> minThresholds;

  /**
   * Create a new grade book with the given thresholds for letter grades
   *
   * @param letterGrades the various letter grades
   * @param thresholds   the minimum final score for the corresponding letter grade in the above
   *                     list. This list is assumed to be in ascending order
   */
  public Gradebook(List<String> letterGrades, List<Double> thresholds) {
    gradebook = new ArrayList<StudentRecord>();
    this.letterGrades = new ArrayList<String>();
    this.letterGrades.addAll(letterGrades);
    this.minThresholds = new ArrayList<Double>();
    this.minThresholds.addAll(thresholds);
  }

  /**
   * Add a new student to this gradebook.
   *
   * @param g the new student record to be added
   */
  public void addStudent(StudentRecord g) {
    gradebook.add(g);
  }

  /**
   * Given a set of weights, compute the final score of each student and return as a list.
   *
   * @param weights the list of weights. The size of this list must be equal to the number of
   *                assignments in each student's record
   * @return the final scores of all students as a list
   */
  public List<Double> getFinalScores(List<Double> weights) {
    return gradebook.stream().map(student -> student.getGrade(weights)).collect(Collectors.toList());
  }

  /**
   * Compute and return the number of students who get the specific letter grade, when computed
   * using the given weights and the grading scheme in this grade book.
   *
   * @param grade   the specific letter grade whose frequency is to be counted
   * @param weights the weights used to compute the final score which maps into the letter grade
   * @return the number of students who get the specific letter grade
   */
  public int countLetterGrade(String grade, List<Double> weights) {

    return (int) gradebook.stream().filter(student -> grade
            .equalsIgnoreCase(lettergrade(student.getGrade(weights)))).count();

  }

  /**
   * Get a list of all student names.
   *
   * @return a list of all student names. Each element of this list must be a string that contains
   * the first name and last name, separated by a single space
   */
  public List<String> getStudentNames() {
    return gradebook.stream().map(student -> student.getFirstName() + " " + student.getLastName())
            .collect(Collectors.toList());
  }

  /**
   * Given a first name, find the average final score for all students with this first name,
   * computed using the given weights.
   *
   * @param name    the first name in question
   * @param weights the weights used to compute the final scores
   * @return the average final score of all students with the given first name
   */
  public Double averageScoreForName(String name, List<Double> weights) {

    return gradebook.stream().filter(student -> name.equalsIgnoreCase(student.getFirstName()))
            .collect(Collectors.toList()).
                    stream().mapToDouble(filterStudent -> filterStudent.getGrade(weights)).average()
            .orElse(0.0);

  }

  /**
   * Return the number of students whose final score is above the overall average final score. The
   * given weights are used to compute the final score.
   *
   * @param weights the weights to be used to compute the final scores
   * @return the number of students whose final score is above the overall average
   */
  public long countAboveAverage(List<Double> weights) {

    return gradebook.stream().filter(student1 -> student1.getGrade(weights) >
            gradebook.stream().mapToDouble(student -> student.getGrade(weights)).average()
                    .orElseThrow(IllegalStateException::new)).count();

  }

  /**
   * This method takes in a score and determines the letter grade against that grade.
   *
   * @param score this method takes in score.
   * @return the letter Grade.
   */
  private String lettergrade(Double score) {
    for (int i = 0; i < letterGrades.size(); i++) {
      if (score < minThresholds.get(i)) {
        return letterGrades.get(i);
      }
    }
    if (score >= minThresholds.get(minThresholds.size() - 1)) {
      return letterGrades.get(letterGrades.size() - 1);
    }
    return "";
  }
}
