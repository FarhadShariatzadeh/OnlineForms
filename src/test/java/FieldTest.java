import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {

  private Field<String> testFieldPw, testFieldPw2, testFieldPw3;
  private Field<Boolean> testFieldCheckBox;
  private IValidator<String> pwValidator;
  private IValidator<Boolean> checkBoxValidator;

  Field<String> fieldSame;
  Field<String> fieldSame2;
  Field<String> fieldSame3;
  Field<String> fieldDifferent1;
  Field<Boolean> fieldDifferent2;
  Field<String> fieldDifferent3;
  PhoneValidator phoneValidator;
  RadioButtonValidator radioButtonValidator;

  @Before
  public void setUp() throws Exception {
    // PW
    pwValidator = new PasswordValidator();
    testFieldPw = new Field<String>("testLabel", true, pwValidator);
    // Checkbox
    checkBoxValidator = new CheckboxValidator();
    testFieldCheckBox = new Field<Boolean>("testCheckBox", false, checkBoxValidator);

    phoneValidator = new PhoneValidator(10);
    radioButtonValidator = new RadioButtonValidator();
    fieldSame = new Field<String>("phone", true, phoneValidator);
    fieldSame2 = new Field<String>("phone", true, phoneValidator);
    fieldSame3 = new Field<String>("phone", true, phoneValidator);
    fieldDifferent1 = new Field<String>("password", true, phoneValidator);
    fieldDifferent2 = new Field<Boolean>("phone", true, radioButtonValidator);
    fieldDifferent1 = new Field<String>("phone", false, phoneValidator);


  }

  @Test
  public void updateValuePW() {
    // PW
    String newValue = "setNewPW";
    testFieldPw.updateValue(newValue);
    Assert.assertTrue(testFieldPw.getValue().equals(newValue));

    testFieldCheckBox.updateValue(true);
    Assert.assertTrue(testFieldCheckBox.getValue().equals(true));
    testFieldCheckBox.updateValue(null);
    Assert.assertTrue(testFieldCheckBox.getValue() == null);
    testFieldCheckBox.updateValue(false);
    Assert.assertTrue(testFieldCheckBox.getValue().equals(false));
  }

  // Does not meet minimum password length requirement
  @Test(expected = InvalidInputException.class)
  public void minLengthUpdateValue() {
    String newValue = "setN";
    testFieldPw.updateValue(newValue);
  }

  // Does not meet maximum password length requirement
  @Test(expected = InvalidInputException.class)
  public void maxLengthUpdateValue() {
    String newValue = "setNsetNsetNsetNn";
    testFieldPw.updateValue(newValue);
  }

  @Test
  public void updateValue() {
    // Phone
    fieldSame.updateValue("2062323678");
    assertEquals("2062323678",fieldSame.getValue());
  }

  @Test
  public void isFilled() {
    // PW
    String newValue = "setNewPW";
    Assert.assertFalse(testFieldPw.isFilled());
    testFieldPw.updateValue(newValue);
    Assert.assertTrue(testFieldPw.getValue().equals(newValue));
    Assert.assertTrue(testFieldPw.isFilled());
    // Checkbox
    Assert.assertTrue(testFieldCheckBox.isFilled());
    testFieldCheckBox.updateValue(false);
    Assert.assertTrue(testFieldCheckBox.isFilled());
    testFieldCheckBox.updateValue(true);
    Assert.assertTrue(testFieldCheckBox.isFilled());
    // Phone
    fieldSame.updateValue("2062323678");
    assertTrue(fieldSame.isFilled());
  }

  @Test
  public void testEqualsReflexive(){
    TestCase.assertTrue(fieldSame.equals(fieldSame2));
    // PW
    Assert.assertTrue(testFieldPw.equals(testFieldPw));
  }


  @Test
  public void testEqualsTransitive(){
    TestCase.assertTrue(fieldSame.equals(fieldSame2));
    TestCase.assertTrue(fieldSame2.equals(fieldSame3));
    TestCase.assertTrue(fieldSame.equals(fieldSame3));

    // pw
    testFieldPw2 = testFieldPw;
    Assert.assertTrue(testFieldPw.equals(testFieldPw2));
    testFieldPw3 = testFieldPw2;
    Assert.assertTrue(testFieldPw3.equals(testFieldPw2));
    Assert.assertTrue(testFieldPw.equals(testFieldPw3));

  }

  @Test
  public void testEqualsSymmetric(){
    TestCase.assertTrue(fieldSame.equals(fieldSame2));
    TestCase.assertTrue(fieldSame2.equals(fieldSame));

    // pw
    testFieldPw2 = testFieldPw;
    Assert.assertTrue(testFieldPw.equals(testFieldPw2));
    Assert.assertTrue(testFieldPw2.equals(testFieldPw));
  }

  @Test
  public void testEqualsConsistent(){
    testFieldPw2 = testFieldPw;
    for (int i = 0; i < 10; i ++) {
      TestCase.assertTrue(fieldSame.equals(fieldSame2));
      Assert.assertTrue(testFieldPw.equals(testFieldPw2));
    }
  }

  @Test
  public void testEqualsNull(){
    TestCase.assertFalse(fieldSame.equals(null));
    // PW
    Assert.assertFalse(testFieldPw.equals(null));
  }

  @Test
  public void testEqualsClass(){
    TestCase.assertFalse(fieldSame.equals(new Object()));
    Assert.assertFalse(testFieldPw.equals("string"));

  }

  @Test
  public void testEqualsDifferent1() {
    TestCase.assertFalse(fieldSame.equals(fieldDifferent1));
  }

  @Test
  public void testEqualsDifferent2() {
    TestCase.assertFalse(fieldSame.equals(fieldDifferent2));
  }

  @Test
  public void testEqualsDifferent3() {
    TestCase.assertFalse(fieldSame.equals(fieldDifferent3));
  }

  @Test
  public void testHashCode() {
    TestCase.assertEquals(fieldSame.hashCode(), fieldSame2.hashCode());
    int value = testFieldCheckBox.hashCode();
    Assert.assertEquals(testFieldCheckBox.hashCode(), value);
    Assert.assertNotEquals(testFieldCheckBox.hashCode(), (testFieldPw.hashCode()));
  }

  @Test
  public void testToString() {
    String value = testFieldCheckBox.toString();
    Assert.assertTrue(testFieldCheckBox.toString().equals(value));
  }

}