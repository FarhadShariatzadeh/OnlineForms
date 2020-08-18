import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RadioButtonValidatorTest {

  RadioButtonValidator radioButton;

  @Before
  public void setUp() throws Exception {
    radioButton = new RadioButtonValidator();
  }

  @Test
  public void isValidateTrue() {
    assertTrue(radioButton.isValid(true));
  }

  @Test
  public void isValidateFalse() {
    assertFalse(radioButton.isValid(false));
  }

}