import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * This class converts file to string array.
 */
public class FileToStringArray {
  public static void main(String[] args) {
    Scanner sc=null;

    try {
      sc = new Scanner(new FileInputStream("examples1.txt"));
    }
    catch (FileNotFoundException e) {

    }

    StringBuilder sb = new StringBuilder();
    sb.append("String []input = {");
    boolean started = false;
    while (sc.hasNext()) {
      String next = sc.next();

      if (started) {
        sb.append(", ");
      }
      else {
        started = true;
      }
      sb.append("\""+next+"\""+System.lineSeparator());
    }
    sb.append("};");
    sc.close();
    System.out.println(sb.toString());

    List<Integer> a = Arrays.stream(new int[]{1, 2, 3, 4}).boxed().collect(Collectors.toList());

    FileToStringArray.convertToString((g) -> {
      Integer num = (Integer) g;
      num = num + 10;
      return num.toString();
    }, a);
  }

  /**
   * This method is a map implementation.
   * @param convert is the function passed.
   * @param b is the list of integer.
   * @return list of string
   */
  public static List<String> convertToString(Function convert, List<Integer> b) {

    List<String> res = new ArrayList<String>();

    for (int i = 0; i < b.size(); i++) {
      res.add(convert.apply(b.get(i)).toString());
    }

    return res;
  }

}
