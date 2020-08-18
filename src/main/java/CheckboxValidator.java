import java.util.Objects;

/**
 * Validator for check boxes.
 */
public class CheckboxValidator implements IValidator<Boolean> {
    protected Boolean checkValue;

    /**
     * Given a Boolean, return valid checkValue as true
     * @return true
     */
    @Override
    public Boolean isValid(Boolean checkValue){
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckboxValidator that = (CheckboxValidator) o;
        return Objects.equals(checkValue, that.checkValue);
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(checkValue);
    }
}
