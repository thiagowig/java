package br.com.ithiago.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HamTest {

    @Test
    public void testFalse() {
        boolean a = false;
        boolean b = false;

        assertThat(a, is(b));
        assertThat(a, equalTo(b));
        assertThat(a, is(equalTo(b)));
    }

    @Test
    public void testDifferent() {
        boolean a = false;
        boolean b = true;

        assertThat(a, is(not(b)));
    }

    @Test
    public void testChain() {
        assertThat("testing", anyOf(is("thiago"), containsString("ing")));
        assertThat("testing", allOf(is("testing"), containsString("ing")));
    }

    @Test
    public void testInstanceOf() {
        assertThat(Integer.valueOf("1"), instanceOf(Integer.class));
    }

    @Test
    public void testLists() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, hasSize(3));
        assertThat(list, not(not(notNullValue())));
        assertThat(list, contains(5, 2, 4));
        assertThat(list, containsInAnyOrder(2, 4, 5));
        assertThat(list, everyItem(greaterThan(1)));
    }
}
