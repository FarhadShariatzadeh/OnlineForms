import java.security.InvalidKeyException;

public interface IField<T> {

  /**
   * A method updates a value, that takes a input, and validates it, and then updates the value
   * if it is valid.
   * @param input - The given input to update the value.
   * @throws InvalidInputException - Throws invalid input exception if the input is not valid.
   */
  void updateValue(T input) throws InvalidInputException;


  /**
   * A method which checks the field to figure out if it is required and filled, or it is optional.
   * @return True if it is required and is filed, or it is optional and return false if it is
   * required and it is null.
   */
  boolean isFilled();

}
