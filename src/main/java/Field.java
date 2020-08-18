import java.util.Objects;

/**
 * Represents the Field class. Every Field tracks the label, value, required and validation.
 * @param <T> The type which is passed in to this class.
 */
public class Field<T> implements IField <T> {

  private String label;
  private T value;
  private boolean required;
  private IValidator<T> validator;

  /**
   * Constructs a new Field object and initializes it with the given label, vaLue, required, and validator.
   * @param label - The label associated with the form Field.
   * @param required - The boolean indicating whether a particular Field must be completed before the form
   * can be submitted.
   * @param validator - The validator performs input validation.
   */
  public Field(String label, boolean required, IValidator<T> validator) {
    this.label = label;
    this.value = null;
    this.required = required;
    this.validator = validator;
  }


  /**
   * A method updates the value, and validates it.
   * @param input - The input given to update the value.
   * @throws InvalidInputException - throw invalid input exception if the input is not valid.
   */
  @Override
  public void updateValue(T input) throws InvalidInputException {

      if (this.validator.isValid(input)) {
        this.value = input;
      }
      else {
        throw new InvalidInputException("The input is not valid");
      }

  }

  /**
   * A method checks if the Field is required and filled, or it is optional.
   * @return true if it is required and is filled or it is optional. Returns false if it is
   * required and is null.
   */
  @Override
  public boolean isFilled() {

    if (this.required == false || this.value != null) {
      return true;
    }
    return false;
  }

  /**
   * Returns the value of the Field.
   * @return the value of the Field.
   */
  public T getValue() {
    return value;
  }

  /**
   * Return the label of the Field.
   * @return the label of the Field.
   */
  public String getLabel() {
    return label;
  }

  public boolean isRequired() {
    return required;
  }

  public IValidator<T> getValidator() {
    return validator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Field)) {
      return false;
    }
    Field<?> field = (Field<?>) o;
    return isRequired() == field.isRequired() &&
        Objects.equals(getLabel(), field.getLabel()) &&
        Objects.equals(getValue(), field.getValue()) &&
        Objects.equals(getValidator(), field.getValidator());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLabel(), getValue(), isRequired(), getValidator());
  }

  @Override
  public String toString() {
    return "Field{" +
        "label='" + label + '\'' +
        ", value=" + value +
        ", required=" + required +
        ", validator=" + validator +
        '}';
  }
}
