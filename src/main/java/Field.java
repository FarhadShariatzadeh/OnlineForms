import java.util.Objects;

/**
 * Represent the Field class. Every field track the label, value, required and validation.
 * @param <T> The type whick is passed in to this class
 */
public class Field<T> implements IField <T> {

  private String label;
  private T value;
  private boolean required;
  private IValidator<T> validator;

  /**
   * Construct a new field object and initialize it with the given label, vaLue, required, and
   * validator
   * @param label - The label associate with the form field
   * @param required - The boolean indicating whether a particular field must be completed before
   * the form can be submitted.
   * @param validator - The validator perform input validation.
   */
  public Field(String label, boolean required, IValidator<T> validator) {
    this.label = label;
    this.value = null;
    this.required = required;
    this.validator = validator;
  }


  /**
   * A method update value, that takes a input, and validate it, and then update the value
   * @param input - The input given to the update value
   * @throws InvalidInputException - throw invalid input exception if the input is not valid
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
   * A method is filled return true if the field is required and filled or it is optional
   * @return true if it is required and is filed or it is optional and return false if it is
   * required and it is null.
   */
  @Override
  public boolean isFilled() {

    if (this.required == false || this.value != null) {
      return true;
    }
    return false;
  }

  /**
   * return the value of the field
   * @return the value
   */
  public T getValue() {
    return value;
  }

  /**
   * Return the label of the field
   * @return the label of the field
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
