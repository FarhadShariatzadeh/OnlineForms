import java.lang.*;
import java.util.Objects;

/**
 * Validator for a free text.
 */
public class FreeTextValidator implements IValidator<String> {

  protected int maxNumberOfLines;
  protected int maxNumberOfCharactersPerLine;


  /** Constructor for the FreeTextValidator.
   * @param maxNumberOfLines The maximum number of lines to validate.
   * @param maxNumberOfCharactersPerLine The maximum number of characters to validate.
   */
  public FreeTextValidator(int maxNumberOfLines, int maxNumberOfCharactersPerLine) {
    this.maxNumberOfLines = maxNumberOfLines;
    this.maxNumberOfCharactersPerLine = maxNumberOfCharactersPerLine;
  }

  /** Validates free text according to set specifications.
   * @param input The String to validate.
   * @return true if the input string meets all specifications, false otherwise.
   */
    @Override
      public Boolean isValid (String input) {
      String[] lines = input.split("\r\n|\r|\n"); //regex - regular expression

      if (lines.length > maxNumberOfLines) {
        return false;
      }

      int totalCharacters = 0;
      for (String line : lines) {
        totalCharacters += line.length();
        if (line.length() > maxNumberOfCharactersPerLine) {
          return false;
        }
      }

      if (totalCharacters > maxNumberOfCharactersPerLine * maxNumberOfLines) {
        return false;
      }

      return true;
  }
  /**
   * Returns whether or not the given object is the same as this object.
   *
   * @param o The object to be compared against for equality.
   * @return Whether the given object is the same as this object.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true; }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FreeTextValidator that = (FreeTextValidator) o;
    return Objects.equals(maxNumberOfCharactersPerLine, that.maxNumberOfCharactersPerLine) &&
        Objects.equals(maxNumberOfLines, that.maxNumberOfLines);
  }

  /**
   * Returns the hash value of this object.
   *
   * @return The hash value of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(maxNumberOfCharactersPerLine, maxNumberOfLines);
  }
}

