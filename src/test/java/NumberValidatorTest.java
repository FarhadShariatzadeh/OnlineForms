import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberValidatorTest {
  private NumberValidator testCheck1;

  @Before
  public void setUp() throws Exception {
    testCheck1 = new NumberValidator(5,1000, 4);

  }

  @Test
  public void isValid() {
    Assert.assertTrue(testCheck1.isValid("400.75"));
    Assert.assertFalse(testCheck1.isValid("2.01"));
    Assert.assertFalse(testCheck1.isValid("5000.087"));
    Assert.assertFalse(testCheck1.isValid("1000.08989"));
  }
  @Test
  public void testEquals() {
    Assert.assertTrue(testCheck1.equals(testCheck1));

    Assert.assertFalse(testCheck1.equals(true));

    Assert.assertTrue(testCheck1.equals(new NumberValidator(5,1000, 4 )));
    Assert.assertFalse(testCheck1.equals(new NumberValidator(3, 1000, 4)));
    Assert.assertFalse(testCheck1.equals(new NumberValidator(5, 4000, 4)));
    Assert.assertFalse(testCheck1.equals(new NumberValidator(5, 1000, 5)));

  }

  @Test
  public void testHashCode() {
    int value = testCheck1.hashCode();
    Assert.assertTrue(testCheck1.hashCode() == value);
  }
}