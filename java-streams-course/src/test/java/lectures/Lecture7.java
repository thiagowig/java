package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
      long count = MockData.getPeople()
              .stream()
              .filter(person -> person.getGender().equals("Female"))
              .count();

      System.out.println(count);
  }

  @Test
  public void min() throws Exception {
      Double min = MockData.getCars()
              .stream()
              .mapToDouble(Car::getPrice)
              .min()
              .getAsDouble();

      System.out.println(min);
  }

  @Test
  public void max() throws Exception {
      Double max = MockData.getCars()
              .stream()
              .mapToDouble(Car::getPrice)
              .max()
              .orElse(0);

      System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

      Double average = cars.stream()
              .mapToDouble(Car::getPrice)
              .average()
              .getAsDouble();

      System.out.println(average);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();

      DoubleSummaryStatistics stats = cars.stream()
              .mapToDouble(Car::getPrice)
              .summaryStatistics();

      System.out.println(stats);

  }

}