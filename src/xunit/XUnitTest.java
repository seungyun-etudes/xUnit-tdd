package xunit;

public class XUnitTest {

    public static void main(final String[] args) {
        TestResult result = new TestResult();
        TestSuite suite = TestCaseTest.suite();
        suite.run(result);
        System.out.println(result.getSummary());
    }
}
