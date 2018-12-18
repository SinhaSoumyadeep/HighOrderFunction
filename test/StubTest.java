import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import grades.Gradebook;
import grades.StudentRecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This Test Class is used to test the implementation of the Gradebook.
 */
public class StubTest {

  private Gradebook records;
  private List<Double> weights;
  private List<Double> weights1;
  private List<Double> finalScores;
  private List<String> letterGrades;
  private List<String> firstNames, lastNames, fullNames;
  private final int NumAssignments = 4;
  private List<String> letters;
  private List<Double> thresholds;
  private String []input = {"Amit"
          , "Shesh"
          , "0.920833333"
          , "0.8"
          , "0.656410256"
          , "0.218181818"
          , "70.8548951"
          , "C-"
          , "Clark"
          , "Freifeld"
          , "1"
          , "0.888888889"
          , "0.9"
          , "0.987012987"
          , "92.53679654"
          , "A-"
          , "Aniruddha"
          , "Tapas"
          , "0.891666667"
          , "0.566666667"
          , "0.711111111"
          , "0.566233766"
          , "68.94011544"
          , "D+"
          , "Aditya"
          , "Sathyanarayan"
          , "0.783333333"
          , "0.8"
          , "0.333333333"
          , "0"
          , "53"
          , "F"
          , "Ritika"
          , "Nair"
          , "1"
          , "0.911111111"
          , "0.955555556"
          , "0.92987013"
          , "94.85425685"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Aniruddha"
          , "Tapas"
          , "0.891666667"
          , "0.566666667"
          , "0.711111111"
          , "0.566233766"
          , "68.94011544"
          , "D+"
          , "Aniruddha"
          , "Tapas"
          , "0.891666667"
          , "0.566666667"
          , "0.711111111"
          , "0.566233766"
          , "68.94011544"
          , "D+"
          , "Clark"
          , "Freifeld"
          , "1"
          , "0.888888889"
          , "0.9"
          , "0.987012987"
          , "92.53679654"
          , "A-"
          , "Clark"
          , "Freifeld"
          , "0.933333333"
          , "1"
          , "0.9"
          , "0.987012987"
          , "94.53679654"
          , "A"
          , "Clark"
          , "Tapas"
          , "1"
          , "0.888888889"
          , "0.9"
          , "0.987012987"
          , "92.53679654"
          , "A-"
          , "Clark"
          , "Freifeld"
          , "0.891666667"
          , "1"
          , "0.9"
          , "0.987012987"
          , "93.7034632"
          , "A"
          , "Clark"
          , "Chitnis"
          , "1"
          , "0.888888889"
          , "0.9"
          , "0.987012987"
          , "92.53679654"
          , "A-"
          , "Clark"
          , "Freifeld"
          , "1"
          , "0.85"
          , "0.9"
          , "0.987012987"
          , "91.37012987"
          , "A-"
          , "Aniruddha"
          , "Tapas"
          , "0.891666667"
          , "1"
          , "0.711111111"
          , "0.566233766"
          , "81.94011544"
          , "B-"
          , "Aniruddha"
          , "Tapas"
          , "0.891666667"
          , "0.566666667"
          , "0.711111111"
          , "0.566233766"
          , "68.94011544"
          , "D+"
          , "Aniruddha"
          , "Tapas"
          , "0.891666667"
          , "0.566666667"
          , "0.711111111"
          , "0.566233766"
          , "68.94011544"
          , "D+"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Amit"
          , "Shesh"
          , "0.920833333"
          , "0.8"
          , "0.656410256"
          , "0.218181818"
          , "70.8548951"
          , "C-"
          , "Amit"
          , "Shesh"
          , "0.920833333"
          , "0.8"
          , "0.656410256"
          , "0.218181818"
          , "70.8548951"
          , "C-"
          , "Amit"
          , "Shesh"
          , "0.920833333"
          , "0.8"
          , "0.656410256"
          , "0.218181818"
          , "70.8548951"
          , "C-"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Rohan"
          , "Chitnis"
          , "0.933333333"
          , "1"
          , "0.977777778"
          , "0.745454545"
          , "95.23232323"
          , "A"
          , "Dasha"
          , "Kukhot"
          , "1"
          , "1"
          , "1"
          , "1"
          , "100"
          , "A"
          , "A"
          , "Sinha"
          , "0.93"
          , "0.93"
          , "0.93"
          , "0.93"
          , "93"
          , "A"
          , "Aminus"
          , "Sinha"
          , "0.9"
          , "0.9"
          , "0.9"
          , "0.9"
          , "90"
          , "A-"
          , "Bplus"
          , "Sinha"
          , "0.86"
          , "0.86"
          , "0.86"
          , "0.86"
          , "86"
          , "B+"
          , "B"
          , "Sinha"
          , "0.83"
          , "0.83"
          , "0.83"
          , "0.83"
          , "83"
          , "B"
          , "Bminus"
          , "Sinha"
          , "0.8"
          , "0.8"
          , "0.8"
          , "0.8"
          , "80"
          , "B-"
          , "Cplus"
          , "Sinha"
          , "0.76"
          , "0.76"
          , "0.76"
          , "0.76"
          , "76"
          , "C+"
          , "C"
          , "Sinha"
          , "0.73"
          , "0.73"
          , "0.73"
          , "0.73"
          , "73"
          , "C"
          , "Cminus"
          , "Sinha"
          , "0.7"
          , "0.7"
          , "0.7"
          , "0.7"
          , "70"
          , "C-"
          , "Dplus"
          , "Sinha"
          , "0.66"
          , "0.66"
          , "0.66"
          , "0.66"
          , "66"
          , "D+"
          , "D"
          , "Sinha"
          , "0.63"
          , "0.63"
          , "0.63"
          , "0.63"
          , "63"
          , "D"
          , "Dminus"
          , "Sinha"
          , "0.6"
          , "0.6"
          , "0.6"
          , "0.6"
          , "60"
          , "D-"
          , "F"
          , "Sinha"
          , "0.59"
          , "0.59"
          , "0.59"
          , "0.59"
          , "59"
          , "F"
          , "Zero"
          , "Sinha"
          , "0.0"
          , "0.0"
          , "0.0"
          , "0.0"
          , "0"
          , "F"
  };


  /**
   * This method is used to initialize the Gradebook and added Student Record.
   */
  @Before
  public void setup() {

    letters = Arrays.asList(new String[]{"F", "D-", "D", "D+", "C-", "C", "C+",
            "B-", "B", "B+", "A-", "A"});
    thresholds = Arrays.asList(new Double[]{60.0, 63.0, 66.0, 70.0, 73.0, 76.0,
            80.0, 83.0, 86.0, 90.0, 93.0, 100.0});
    records = new Gradebook(letters, thresholds);
    finalScores = new ArrayList<Double>();
    letterGrades = new ArrayList<String>();
    firstNames = new ArrayList<String>();
    lastNames = new ArrayList<String>();
    fullNames = new ArrayList<String>();
    int i = 0;


    while (i < input.length) {
      String fName = input[i];
      String lName = input[i + 1];

      double[] points = new double[NumAssignments];
      for (int j = 0; j < NumAssignments; j++) {
        points[j] = 100 * Double.parseDouble(input[i + 2 + j]);
      }


      finalScores.add(Double.parseDouble(input[i + 2 + NumAssignments]));
      letterGrades.add(input[i + 2 + NumAssignments + 1]);
      firstNames.add(fName);
      lastNames.add(lName);
      fullNames.add(fName + " " + lName);

      i = i + 4 + NumAssignments;
      records.addStudent(new StudentRecord(fName, lName, points));
    }

    weights = new ArrayList<Double>();
    weights.add(20.0);
    weights.add(30.0);
    weights.add(40.0);
    weights.add(10.0);

    weights1 = new ArrayList<Double>();
    weights1.add(20.0);
    weights1.add(30.0);
    weights1.add(40.0);


  }

  /**
   * This method tests individual grades of all students present in grade book.
   */
  @Test
  public void testIndividualGrades() {
    List<Double> finals = records.getFinalScores(weights);

    for (int i = 0; i < finalScores.size(); i++) {
      assertEquals(finalScores.get(i), finals.get(i), 0.001);
    }
  }

  /**
   * This method tests names of all students present in grade book.
   */
  @Test
  public void testAllNames() {
    List<String> fullNameList = records.getStudentNames();

    for (int i = 0; i < firstNames.size(); i++) {
      assertEquals(fullNames.get(i), fullNameList.get(i));
    }

    Gradebook recordsEmpty = new Gradebook(letters, thresholds);
    assertEquals(true, recordsEmpty.getStudentNames().isEmpty());

  }

  /**
   * This method tests How many students received a particular grade who are present in the grade
   * book.
   */
  @Test
  public void testLetterGrades() {

    assertEquals(14, records.countLetterGrade("A", weights));
    assertEquals(6, records.countLetterGrade("A-", weights));
    assertEquals(1, records.countLetterGrade("B+", weights));
    assertEquals(1, records.countLetterGrade("B", weights));
    assertEquals(2, records.countLetterGrade("B-", weights));
    assertEquals(1, records.countLetterGrade("C+", weights));
    assertEquals(1, records.countLetterGrade("C", weights));
    assertEquals(5, records.countLetterGrade("C-", weights));
    assertEquals(6, records.countLetterGrade("D+", weights));
    assertEquals(1, records.countLetterGrade("D", weights));
    assertEquals(1, records.countLetterGrade("D-", weights));
    assertEquals(3, records.countLetterGrade("F", weights));
    assertEquals(0, records.countLetterGrade("Z", weights));
    assertEquals(0, records.countLetterGrade("A++", weights));

    Gradebook recordsEmpty = new Gradebook(letters, thresholds);
    assertEquals(0, recordsEmpty.countLetterGrade("A", weights));

    try {
      records.countLetterGrade("A", weights1);
      fail();
    }
    catch (Exception e){
      assertEquals("Number of weights is not equal to number of assignments",e.getMessage());
    }

  }

  /**
   * This method tests How many students, present in the grade book, received above average grades.
   */
  @Test
  public void testCountAboveAvg() {
    long countAboveAverage = records.countAboveAverage(weights);
    assertEquals(23.0, countAboveAverage, 0.001);

    Gradebook recordsEmpty = new Gradebook(letters, thresholds);
    assertEquals(0, recordsEmpty.countAboveAverage(weights));

  }

  /**
   * This method tests the average score of students, present in the grade book having same first
   * name.
   */
  @Test
  public void testAverageScoreForName() {
    assertEquals(71.106, records.averageScoreForName("Aniruddha", weights), 0.001);
    assertEquals(70.854, records.averageScoreForName("Amit", weights), 0.001);
    assertEquals(100.0, records.averageScoreForName("Dasha", weights), 0.001);
    assertEquals(0.0, records.averageScoreForName("Soumyadeep", weights), 0.001);
    assertEquals(0.0, records.averageScoreForName("", weights), 0.001);
    Gradebook recordsEmpty = new Gradebook(letters, thresholds);
    assertEquals(0, records.averageScoreForName("", weights), 0.001);
  }


}