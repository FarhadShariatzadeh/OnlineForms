public class InvalidInputException extends RuntimeException{

  /**
   * Invalid input exception throw message
   * @param message the message thrown when exception called
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
