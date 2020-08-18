/**
 * Validates a string representing a phone number with initial specifications of
 * length and being digits.
 */
public class PhoneValidator implements IValidator<String>{


  final String PHONE_REGEX = "([0-9]+)";
  protected int phoneNumberLength;

  /**
   * Constructs a new phoneValidator object with the given phone number length.
   * @param phoneNumberLength - The phone number length to validate.
   */
  public PhoneValidator(int phoneNumberLength) {
    this.phoneNumberLength = phoneNumberLength;
  }
  /**
   * The method gets an input as an argument and validates it.
   * @param input - The input is given to the method.
   * @return - Returns true if the input is valid, false otherwise.
   */
  @Override
  public Boolean isValid(String input) {

    if (input.matches(PHONE_REGEX) && input.length() == this.phoneNumberLength) {
      return true;
    }
   return false;

  }


}
