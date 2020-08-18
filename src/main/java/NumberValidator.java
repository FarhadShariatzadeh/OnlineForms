import java.util.Objects;

/**
 * Validator for a number
 */
public class NumberValidator implements IValidator<String> {


  private double minValue;
  private double maxValue;
  private int maxDecimalPlaces;

  /** Constructor for the Number Validator
   * @param minValue
   * @param maxValue
   * @param maxDecimalPlaces
   */
  public NumberValidator(double minValue, double maxValue, int maxDecimalPlaces) {
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.maxDecimalPlaces = maxDecimalPlaces;

   /**  If the maximum decimal place is less than 0, then convert it to 0 */
    if (maxDecimalPlaces < 0) {
      this.maxDecimalPlaces = 0;
    }
  }

  /** Validates number according to set specifications
   * @param input
   * @return true if number meets all specifications, else returns false
   */
  @Override
  public Boolean isValid(String input) {

    double example = Double.parseDouble(input); //Convert string to double
    String text = Double.toString(Math.abs(example)); //Absolute value
    int integerPlaces = text.indexOf('.'); //Decimal point
    int decimalPlaces = text.length() - integerPlaces - 1; //
    if (decimalPlaces == text.length()) {
      decimalPlaces = -1;
    }

    return example >= minValue && example <= maxValue && decimalPlaces <= maxDecimalPlaces;
  }

  /**
   * Return whether or not the given object is the same as this object.
   *
   * @param o the object to be compared to for equality.
   * @return whether or not the given object is the same as this object.
   */

  /*
  testCheck1: 5 1000 4
  new NumberValidator: 5 250 3
   */
  @Override
  public boolean equals(Object o) {

    if (this == o)  {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberValidator that = (NumberValidator) o;
    return Objects.equals(minValue, that.minValue) &&
        Objects.equals(maxValue, that.maxValue) &&
        Objects.equals(maxDecimalPlaces, that.maxDecimalPlaces);
  }

  /**
   * Return the hash value of this object.
   *
   * @return the hash value of this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue, maxDecimalPlaces);
  }
}