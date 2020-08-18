import java.util.Objects;

/**
 * Validates a string password with initial specifications of
 * minimal length of 6 characters and maximal length of 12 characters.
 */
public class PasswordValidator implements IValidator<String>{
    protected String password;
    protected final Integer MIN_LENGTH = 6;
    protected final Integer MAX_LENGTH = 12;
    protected Integer minLowercase;
    protected Integer minUppercase;
    protected Integer minDigits;

    /**
     * Constructor for a password validator with default requirements.
     */
    public PasswordValidator() {
        this.minLowercase = 0;
        this.minUppercase = 0;
        this.minDigits = 0;
    }

    /**
     * Validates password according to set specifications.
     * @return True if password meets all specifications, false otherwise.
     */
    @Override
    public Boolean isValid(String input){
        this.password = input;
        return lengthCheck() && caseCheck() && digitCheck() && spaceCheck();
    }

    private boolean lengthCheck() {
        Boolean minCheck = this.password.length() >= this.MIN_LENGTH;
        Boolean maxCheck = this.password.length() <= this.MAX_LENGTH;
        return minCheck && maxCheck;
    }

    private boolean caseCheck() {
        int upperCount = 0;
        int lowerCount = 0;
        for (int i = 0; i < this.password.length(); i++) {
            if (Character.isLowerCase(this.password.charAt(i))) {
                lowerCount += 1;
            }
            if (Character.isUpperCase(this.password.charAt(i))) {
                upperCount += 1;
            }
        }
        Boolean lowerCheck = this.minLowercase <= lowerCount;
        Boolean UpperCheck = this.minUppercase <= upperCount;
        return lowerCheck && UpperCheck;
    }

    private boolean digitCheck() {
        int numCount = 0;
        for (int i = 0; i < this.password.length(); i++) {
            if (Character.isDigit(this.password.charAt(i))) {
                numCount += 1;
            }
        }
        return this.minDigits <= numCount;
    }

    private boolean spaceCheck() {
        for (int i = 0; i < this.password.length(); i++) {
            if (Character.isWhitespace(this.password.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets minimum requirement for lowercase letters.
     * @param minLowercase - Number of required lowercase letters
     */
    protected void setMinLowercase(Integer minLowercase) {
        this.minLowercase = minLowercase;
    }

    /**
     * Sets minimum requirement for uppercase letters.
     * @param minUppercase - Number of required uppercase letters.
     */
    protected void setMinUppercase(Integer minUppercase) {
        this.minUppercase = minUppercase;
    }

    /**
     * Sets minimum requirement for number of digits.
     * @param minDigits - Number of required digit characters.
     */
    protected void setMinDigits(Integer minDigits) {
        this.minDigits = minDigits;
    }

    /**
     * Returns whether or not the given object is the same as this object.
     *
     * @param o The object to be compared to for equality.
     * @return Whether or not the given object is the same as this object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordValidator that = (PasswordValidator) o;
        return Objects.equals(MIN_LENGTH, that.MIN_LENGTH) &&
                Objects.equals(MAX_LENGTH, that.MAX_LENGTH) &&
                Objects.equals(minLowercase, that.minLowercase) &&
                Objects.equals(minUppercase, that.minUppercase) &&
                Objects.equals(minDigits, that.minDigits) &&
                Objects.equals(password, that.password);
    }

    /**
     * Returns the hash value of this object.
     *
     * @return The hash value of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(MIN_LENGTH, MAX_LENGTH, minLowercase, minUppercase, minDigits, password);
    }



}
