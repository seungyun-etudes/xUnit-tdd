package xunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test {

    private final List<Test> tests = new ArrayList<>();

    public TestSuite(final Class<? extends TestCase> testClass) {
        Arrays.stream(testClass.getMethods())
                .filter(method -> method.getAnnotation(xunit.annotation.Test.class) != null)
                .forEach(method -> {
                    try {
                        add(testClass.getConstructor(String.class).newInstance(method.getName()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public TestSuite() {
    }

    public void add(final Test test) {
        tests.add(test);
    }

    public void run(final TestResult result) {
        tests.forEach(t -> {
            t.run(result);
        });
    }
}
