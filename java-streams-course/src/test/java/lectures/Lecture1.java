package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;


public class Lecture1 {

  private final Integer MAXIMUM_AGE = 18;

  private final Integer RECORDS_NUMBER = 10;

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> tenFirstPeople = new ArrayList<>();

    for (Person person : people) {
      if (person.getAge() <= MAXIMUM_AGE) {
        tenFirstPeople.add(person);

        if (tenFirstPeople.size() == RECORDS_NUMBER) {
          break;
        }
      }
    }

    System.out.println(tenFirstPeople);
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    people.stream()
            .filter(person -> person.getAge() <= MAXIMUM_AGE)
            .limit(RECORDS_NUMBER)
            .collect(Collectors.toList())
            .forEach(System.out::println);
  }
}
