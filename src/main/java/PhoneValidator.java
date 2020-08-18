/**
 * Validates a string phone with initial specifications of
 * length and being digits
 */
public class PhoneValidator implements IValidator<String>{


  final String PHONE_REGEX = "([0-9]+)";
  protected int phoneNumberLength;

  /**
   * Construct a new phoneValidator with the phone number length
   * @param phoneNumberLength - The phone number length to validate
   */
  public PhoneValidator(int phoneNumberLength) {
    this.phoneNumberLength = phoneNumberLength;
  }
  /**
   * The method get an input as an argument and validate it
   * @param input - The input is given to the is validate
   * @return - return true if the input is validate and return false if it is not.
   */
  @Override
  public Boolean isValid(String input) {

    if (input.matches(PHONE_REGEX) && input.length() == this.phoneNumberLength) {
      return true;
    }
   return false;

  }


}
