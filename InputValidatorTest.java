/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest
{
    //Must not be empty. At least 8 characters long. At least one uppercase letter, one lowercase 
    //letter, and one digit. Can use the special characters !, -, *, and ..
    @Test
    public void testPasswordField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validatePasswordField("Abcdef1!"));// non-empty string with requirmeents should return true (test should pass)
        assertTrue(InputValidator.validatePasswordField("A1bc-def"));// non-empty string with requirements should return true (test should pass)
        assertTrue(InputValidator.validatePasswordField("ABcd12*-"));// non-empty string with requirements should return true (test should pass)
        assertTrue(InputValidator.validatePasswordField("ABCDefgh1234"));// non-empty string with requirements should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validatePasswordField(""));// empty string should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("Ab1!c"));// less than 8 characters should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("abcdefg1!"));// no uppercase letter should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("ABCDEFG1!"));// no lowercase letter string should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("Abcdefg!"));// no digit should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("Abcdef1@"));// contains an invalid special character should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("null"));// null string should return false (test should pass)
    }

    //Must contain 10 digits, may include dashes or spaces. Can be empty.
    @Test
    public void testPhoneNumberField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validatePhoneNumberField(""));// empty input should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("1234567890"));// exactly 10 digits should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("7734567890"));// exactly 10 digits should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("3124567890"));// exactly 10 digits should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("123-456-7890"));// exactly 10 digits with dashes should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("773-456-7890"));// exactly 10 digits with dashes should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("312-456-7890"));// exactly 10 digits with dashes should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("123 456 7890"));// exactly 10 digits with spaces should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("773 456 7890"));// exactly 10 digits with spaces should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("312 456 7890"));// exactly 10 digits with spaces should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validatePhoneNumberField("123456789"));// less than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("123456"));// less than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("123"));// less than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("12345678901"));// more than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("123456789012345"));// more than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("12345678901234567"));// more than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("12345abc90"));// contains letters should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("abcdefghij"));// contains letters should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("!@#$%^&*()"));// contains special characters should return true (test should pass)
    }

    //Must be a valid date in the format yyyy-MM-dd, and user must be 18+ years old. Should not be empty.
    @Test
    public void testDateOfBirthField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validateDateOfBirthField("2007-05-01"));// valid format and user is exactly 18 years old should return true (test should pass)
        assertTrue(InputValidator.validateDateOfBirthField("2001-05-01"));// valid format and user is > 18 years old should return true (test should pass)
        assertTrue(InputValidator.validateDateOfBirthField("2002-05-01"));// valid format and user is > 18 years old should return true (test should pass)
        assertTrue(InputValidator.validateDateOfBirthField("2004-05-01"));// valid format and user is > 18 years old should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validateDateOfBirthField(""));// empty input should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2009-05-01"));// valid format but user is < 18 years old should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2010-05-01"));// valid format but user is < 18 years old should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2012-05-01"));// valid format but user is < 18 years old should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("05-01-2001"));// invalid format should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("05-01-2002"));// invalid format should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("05-01-2010"));// invalid format should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2025-02-30"));// nonexistent date should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2025-07-00"));// nonexistent date should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2025-03-32"));// nonexistent date should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("not-a-date"));// non-date string should return false (test should pass)
    }

    //Must be exactly 5 digits (only for the U.S.A.). Can be empty if the postal code is from another country.
    @Test
    public void testPostalCodeField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validatePostalCodeField(""));// empty input should return true (test should pass)
        assertTrue(InputValidator.validatePostalCodeField("12345"));// exactly 5 digits should return true (test should pass)
        assertTrue(InputValidator.validatePostalCodeField("13579"));// exactly 5 digits should return true (test should pass)
        assertTrue(InputValidator.validatePostalCodeField("24680"));// exactly 5 digits should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validatePostalCodeField("1234"));// less than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("123"));// less than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12"));// less than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("123456"));// more than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("1234567"));// more than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12345678"));// more than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12a45"));// contains letters should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("abcde"));// contains letters should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12-45"));// contains special characters should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12-*!"));// contains special characters should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("-----"));// contains special characters should return false (test should pass)
    }

    // CREATE MORE TESTS HERE
}