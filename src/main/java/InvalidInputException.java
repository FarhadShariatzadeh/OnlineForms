public class InvalidInputException extends RuntimeException{

  /**
   * Invalid input exception throw message.
   * @param message The message thrown when exception is called.
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
