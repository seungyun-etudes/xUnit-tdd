package xunit;

import xunit.annotation.Test;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    @Test
    public static TestSuite suite() {
        TestSuite suite = new TestSuite(TestCaseTest.class);

        return suite;
    }

    @Test
    public void templateMethod() {
        TestResult result = new TestResult();
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    @Test
    public void result() {
        TestResult result = new TestResult();
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    @Test
    public void failedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void failedResult() {
        TestResult result = new TestResult();
        WasRun wasRun = new WasRun("testBrokenMethod");
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testSuite() {
        TestResult result = new TestResult();
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        suite.run(result);

        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }
}
