/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest
{
    
    /*
     * Example test method for a possible Name field validator method in your
     * InputValidator class.
     * For more information about assertion tests check:
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */
    @Test
    public void testNameFieldIsNotEmpty()
    {
        // passing tests
        assertTrue(InputValidator.validateNameField("Maddie")); // non-empty string should return true (test should pass)
        assertFalse(InputValidator.validateNameField("")); // empty string should return false (test should pass)
        assertFalse(InputValidator.validateNameField(null)); // null string should return false (test should pass)

        // failing tests
        // assertFalse(InputValidator.validateNameField("Mae")); // non-empty string should return true (test should fail)
        // assertTrue(InputValidator.validateNameField("")); // empty string should return false (test should fail)
        // assertTrue(InputValidator.validateNameField(null)); // null string should return false (test should fail)
    }

    @Test
    public void testNameFieldLength()
    {
        // passing tests
        assertTrue(InputValidator.validateNameField("Madison")); // name longer than 2 characters should return true (test should pass)
        assertFalse(InputValidator.validateNameField("M")); // name less than two characters should return false (test should pass)
        assertFalse(InputValidator.validateNameField("")); // empty name should return false (test should pass)

        // failing tests
        // assertFalse(InputValidator.validateNameField("Anspach")); // name longer than 2 characters should return true (test should pass)
        // assertTrue(InputValidator.validateNameField("A")); // name less than two characters should return false (test should pass)
        // assertTrue(InputValidator.validateNameField("")); // empty name should return false (test should pass)
    }

    @Test
    public void testNameFieldCharacters()
    {
        // passing tests

        // valid names
        assertTrue(InputValidator.validateNameField("Ferrari")); // name with capital letter should return true
        assertTrue(InputValidator.validateNameField("haas")); // name with no capital letters should return true
        assertTrue(InputValidator.validateNameField("McLaren")); // name with multiple capital letters should return true
        assertTrue(InputValidator.validateNameField("Zoltán")); // name with diacritic mark
        assertTrue(InputValidator.validateNameField("Lando Norris")); // name with letters and a space should return true
        assertTrue(InputValidator.validateNameField("Sergio Pérez")); // name with letters, a space, and diacritic should return true
        assertTrue(InputValidator.validateNameField("Αλεξάνδρα")); // Alexandra in Greek, name in other languages should return true

        // invalid names
        assertFalse(InputValidator.validateNameField("Charles Marc Hervé Perceval Leclerc")); // names with multiple spaces should return false (people don't have more than two first names)
        assertFalse(InputValidator.validateNameField("Alpine!")); // name with punctuation should return false
        assertFalse(InputValidator.validateNameField("Lewis_Hamilton")); // name with special characters should return false
        assertFalse(InputValidator.validateNameField("Max33")); // name with numbers should return false
        assertFalse(InputValidator.validateNameField("  ")); // name containing only spaces should return false
        assertFalse(InputValidator.validateNameField(" Williams")); // name with leading space should return false
        assertFalse(InputValidator.validateNameField("Mercedes ")); // name with trailing space should return false

        // assertFalse(InputValidator.validateNameField("Williams")); // name with capital letter should return true
    }

    @Test
    public void testPasswordField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validatePasswordField("Abcdef1!"));// non-empty string should return true (test should pass)
        assertTrue(InputValidator.validatePasswordField("A1bc-def"));// non-empty string should return true (test should pass)
        assertTrue(InputValidator.validatePasswordField("ABcd12*-"));// non-empty string should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validatePasswordField(""));// empty string should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("Ab1!c"));// less than 8 characters should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("abcdefg1!"));// no uppercase letter should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("ABCDEFG1!"));// no lowercase letter string should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("Abcdefg!"));// no digit should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("Abcdef1@"));// contains an invalid special character should return false (test should pass)
        assertFalse(InputValidator.validatePasswordField("null"));// null string should return false (test should pass)
    }

    @Test
    public void testPhoneNumberField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validatePhoneNumberField(""));// empty input should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("1234567890"));// exactly 10 digits should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("123-456-7890"));// exactly 10 digits with dashes should return true (test should pass)
        assertTrue(InputValidator.validatePhoneNumberField("123 456 7890"));// exactly 10 digits with spaces should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validatePhoneNumberField("123456789"));// less than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("12345678901"));// more than 10 digits should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("12345abc90"));// contains letters should return false (test should pass)
        assertFalse(InputValidator.validatePhoneNumberField("123-456789@"));// contains special characters should return true (test should pass)
    }

    @Test
    public void testDateOfBirthField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validateDateOfBirthField("2007-05-01"));// valid format and user is exactly 18 years old should return true (test should pass)
        assertTrue(InputValidator.validateDateOfBirthField("2001-05-01"));// valid format and user is > 18 years old should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validateDateOfBirthField(""));// empty input should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2009-05-01"));// valid format but user is < 18 years old should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("05-01-2001"));// invalid format should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("2025-02-30"));// nonexistent date should return false (test should pass)
        assertFalse(InputValidator.validateDateOfBirthField("not-a-date"));// non-date string should return false (test should pass)
    }

    @Test
    public void testPostalCodeField()
    {
        //passing tests
        //valid passwords
        assertTrue(InputValidator.validatePostalCodeField(""));// empty input should return true (test should pass)
        assertTrue(InputValidator.validatePostalCodeField("12345"));// exactly 5 digits should return true (test should pass)

        //invalid passwords
        assertFalse(InputValidator.validatePostalCodeField("1234"));// less than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("123456"));// more than 5 digits should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12a45"));// contains letters should return false (test should pass)
        assertFalse(InputValidator.validatePostalCodeField("12-45"));// contains special characters should return false (test should pass)
    }

    // CREATE MORE TESTS HERE
}