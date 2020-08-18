public interface IValidator<T> {

  /**
   * The method gets an input as an argument and validates it.
   * @param input - The input is given to the method.
   * @return - Returns true if the input is valid, false otherwise.
   */
  Boolean isValid(T input);

}
