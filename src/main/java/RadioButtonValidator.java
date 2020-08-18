
public class RadioButtonValidator implements IValidator<Boolean> {

  public RadioButtonValidator () {

  }

  /**
   * The method gets an input as an argument and validates it.
   * @param input - The given input to validate.
   * @return - Returns true if the input is valid, false otherwise.
   */
  @Override
  public Boolean isValid(Boolean input) {
    return input.equals(true);
  }
}
