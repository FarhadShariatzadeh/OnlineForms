public interface IValidator<T> {

  /**
   * The method get an input as an argument and validate it
   * @param input - The input is given to the is validate
   * @return - return true if the input is validate and return false if it is not.
   */
  Boolean isValid(T input);

}