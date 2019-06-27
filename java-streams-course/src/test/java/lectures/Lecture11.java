package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
      List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
      StringBuilder text = new StringBuilder();

      names.forEach(name -> text.append(name + ", "));

      System.out.println(text.substring(0, text.length() -2));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
      List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

      String collect = names.stream()
              .map(String::toUpperCase)
              .collect(Collectors.joining(" | "));

      System.out.println(collect);

  }
}
