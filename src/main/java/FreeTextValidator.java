import java.lang.*;
import java.util.Objects;

/**
 * Validator for a Free Text
 */
public class FreeTextValidator implements IValidator<String> {

  protected int maxNumberOfLines;
  protected int maxNumberOfCharactersPerLine;


  /** Constructor for the Free Text Validator
   * @param maxNumberOfLines
   * @param maxNumberOfCharactersPerLine
   */
  public FreeTextValidator(int maxNumberOfLines, int maxNumberOfCharactersPerLine) {
    this.maxNumberOfLines = maxNumberOfLines;
    this.maxNumberOfCharactersPerLine = maxNumberOfCharactersPerLine;
  }

  /** Validates Free Text according to set specifications
   * @param input
   * @return true if Free Text meets all specifications, else returns false
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
   * Return whether or not the given object is the same as this object.
   *
   * @param o the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
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
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(maxNumberOfCharactersPerLine, maxNumberOfLines);
  }
}

