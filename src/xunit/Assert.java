package xunit;

public class Assert {

    public static void assertEquals(final Object expected, final Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected <" + expected + "> but was <" + actual + ">");
        }
    }
}
