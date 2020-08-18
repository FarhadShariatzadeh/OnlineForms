import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FreeTextValidatorTest {

  private FreeTextValidator testCheck1;

  @Before
  public void setUp() throws Exception {
    testCheck1 = new FreeTextValidator(5, 10);
  }


  @Test
  public void isValid() {
    Assert.assertTrue(testCheck1.isValid("dadaDAda\ndasd"));
    Assert.assertFalse(testCheck1.isValid("LoveUiusa\n132\nloudas\nOSC\n0Psd\nfgh"));
    Assert.assertFalse(testCheck1.isValid("sUper10lssaddsfzdfxfsdfda\nAloHa"));
  }
  @Test
  public void testEquals() {
    Assert.assertTrue(testCheck1.equals(testCheck1));

    Assert.assertFalse(testCheck1.equals(true));

    Assert.assertTrue(testCheck1.equals(new FreeTextValidator(5, 10)));
    Assert.assertFalse(testCheck1.equals(new FreeTextValidator(6, 10)));
    Assert.assertFalse(testCheck1.equals(new FreeTextValidator(5, 208)));
  }

  @Test
  public void testHashCode() {
    int value = testCheck1.hashCode();
    Assert.assertTrue(testCheck1.hashCode() == value);
  }
}
