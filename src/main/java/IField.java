import java.security.InvalidKeyException;

public interface IField<T> {

  /**
   * A method update value, that takes a input, and validate it, and then update the value
   * @param input - The input given to the update value
   * @throws InvalidInputException - throw invalid input exception if the input is not valid
   */
  void updateValue(T input) throws InvalidInputException;


  /**
   * A method is filled return true if the field is required and filled or it is optional
   * @return true if it is required and is filed or it is optional and return false if it is
   * required and it is null.
   */
  boolean isFilled();

}
