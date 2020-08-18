import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckboxValidatorTest {
    private Boolean test1, test2, test3;
    private CheckboxValidator testCheck1, testCheck2, testCheck3;


    @Before
    public void setUp() throws Exception {
        test1 = null;
        test2 = true;
        test3 = false;
        testCheck1 = new CheckboxValidator();
        testCheck2 = new CheckboxValidator();
        testCheck3 = new CheckboxValidator();
    }

    @Test
    public void isValid() {
        Assert.assertTrue(testCheck1.isValid(test1));
        Assert.assertTrue(testCheck2.isValid(test2));
        Assert.assertTrue(testCheck3.isValid(test3));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(testCheck1.equals(testCheck1));

        Assert.assertFalse(testCheck1.equals(null));
        Assert.assertFalse(testCheck1.equals(true));
        Assert.assertFalse(testCheck1.equals(false));

        Assert.assertTrue(testCheck1.equals(new CheckboxValidator()));
        Assert.assertTrue(testCheck2.equals(new CheckboxValidator()));
        Assert.assertTrue(testCheck3.equals(new CheckboxValidator()));
    }

    @Test
    public void testHashCode() {
        int value = testCheck1.hashCode();
        Assert.assertTrue(testCheck1.hashCode() == value);
    }
}