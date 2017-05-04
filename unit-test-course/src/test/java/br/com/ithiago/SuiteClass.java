package br.com.ithiago;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AssertTests.class,
        SomeJavaTest.class,
        OrderTest.class
})
public class SuiteClass {
}
