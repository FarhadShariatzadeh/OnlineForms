import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {
    private PasswordValidator test1, test2;

    @Before
    public void setUp() throws Exception {
        String pw1 = "aAbBcCdd123";
        test1 = new PasswordValidator();
        test2 = new PasswordValidator();
        test2.setMinLowercase(3);
    }

    @Test
    public void isValid() {
        Assert.assertTrue(test1.isValid("aAbBcC"));
        //Less than 6 char length
        Assert.assertFalse(new PasswordValidator().isValid("abcde"));
        //Greater than 12 char length
        Assert.assertFalse(new PasswordValidator().isValid("aBcDeFg123456"));

        test1.setMinLowercase(6);
        Assert.assertFalse(test1.isValid("aabbcC"));
        test1.setMinLowercase(5);
        Assert.assertTrue(test1.isValid("aabbcC"));

        test1.setMinUppercase(4);
        Assert.assertFalse(test1.isValid("aabbcCCC"));
        test1.setMinUppercase(3);
        Assert.assertTrue(test1.isValid("aabbcCDD"));

        test1.setMinDigits(4);
        Assert.assertFalse(test1.isValid("aabbcCDD123"));
        test1.setMinDigits(3);
        Assert.assertTrue(test1.isValid("aabbcCDD123"));

        Assert.assertFalse(new PasswordValidator().isValid("aAbB cCdd12"));

        PasswordValidator test1Copy = new PasswordValidator();
        Assert.assertFalse(test1.equals(test1Copy));

    }

    @Test
    public void testEquals() {
        PasswordValidator test1Copy = test1;
        Assert.assertTrue(test1.equals(test1));
        Assert.assertTrue(test1.equals(new PasswordValidator()));
        Assert.assertTrue((test1.equals(test1Copy)));


        Assert.assertFalse(test1.equals(test2));
        test2.setMinUppercase(3);
        Assert.assertFalse(test1.equals(test2));
        test2.setMinUppercase(0);
        test2.setMinDigits(3);
        Assert.assertFalse(test1.equals(test2));
        Assert.assertFalse(test1.equals(null));
        Assert.assertFalse(test1.equals("aAbBcCdd123"));

    }

    @Test
    public void testHashCode() {
        int value = test1.hashCode();
        Assert.assertTrue(value == test1.hashCode());
    }
}