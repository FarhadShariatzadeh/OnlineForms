import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneValidatorTest {

  PhoneValidator phone;

  @Before
  public void setUp() throws Exception {

    phone = new PhoneValidator(10);
  }

  @Test
  public void isValidateTrue() {
    assertTrue(phone.isValid("2067653498"));
  }

  @Test
  public void isValidateFalse() {
    assertFalse(phone.isValid("206763498"));
  }

  @Test
  public void isValidateFalse1() {
    assertFalse(phone.isValid("20676349843"));
  }

  @Test
  public void isValidateFalse2() {
    assertFalse(phone.isValid("206-7634-9899"));
  }

  @Test
  public void isValidateFalse3() {
    assertFalse(phone.isValid("ab3463498"));
  }
}