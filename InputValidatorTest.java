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
    public void testLastNameFieldIsNotEmpty()
    {
        // passing tests

        // valid last name
        assertTrue(InputValidator.validateLastNameField("Anspach"));

        // invalid last name
        assertFalse(InputValidator.validateLastNameField(""));
        assertFalse(InputValidator.validateLastNameField(null));
    }

    @Test
    public void testLastNameFieldLength()
    {
        assertTrue(InputValidator.validateLastNameField("Anspach")); // last name more than 2 character
        assertTrue(InputValidator.validateLastNameField("An")); // last name exactly 2 characters
        assertFalse(InputValidator.validateLastNameField("A")); // last name exactly 1 character
        assertFalse(InputValidator.validateLastNameField("")); // last name empty string
    }

    @Test
    public void testLastNameFieldCharacters()
    {
        // valid names
        assertTrue(InputValidator.validateLastNameField("Gasly")); // one last name, no diacritics, no hyphens, no spaces
        assertTrue(InputValidator.validateLastNameField("Hülkenberg")); // one last name with diacritics
        assertTrue(InputValidator.validateLastNameField("Smith-Jones")); // one last name with hyphen
        assertTrue(InputValidator.validateLastNameField("O'connor")); // one last name with apostrophe
        assertTrue(InputValidator.validateLastNameField("Nelson Piquet")); // two last names no diacritics or hyphens
        assertTrue(InputValidator.validateLastNameField("Pérez Reverte")); // two last names with diacritcs, no hyphens
        assertTrue(InputValidator.validateLastNameField("García-López")); // two last names with diacritics and hyphens
        assertTrue(InputValidator.validateLastNameField("Sainz Vázquez de Castro")); // more than two last names
                
        //invalid names
        assertFalse(InputValidator.validateLastNameField("Anspach--Dimmick")); // last name with consecutive hyphens
        assertFalse(InputValidator.validateLastNameField("Anspach -Dimmick")); // last name with space then hyphen
        assertFalse(InputValidator.validateLastNameField("Anspach ʻ'-Dimmick")); // last name with space then 'okina then apostrophe then hyphen
        assertFalse(InputValidator.validateLastNameField("-Anspach")); // last name with leading hyphen
        assertFalse(InputValidator.validateLastNameField("Anspach-")); // last name with trailing hyphen
        assertFalse(InputValidator.validateLastNameField("O''connor")); // last name with consecutive apostrophes
        assertFalse(InputValidator.validateLastNameField("Anspach1")); // last name with numbers
        assertFalse(InputValidator.validateLastNameField("Anspach!")); // last name with punctuation
        assertFalse(InputValidator.validateLastNameField("  ")); // last name with only spaces
        assertFalse(InputValidator.validateLastNameField(" Anspach")); // last name with leading space
        assertFalse(InputValidator.validateLastNameField("Anspach ")); // last name with trailing space
    }
    
    @Test
    public void testEmailFieldIsEmpty()
    {
        // valid emails
        assertTrue(InputValidator.validateEmailField("username@domain.com")); // example email

        // invalid emails
        assertFalse(InputValidator.validateEmailField("")); // empty email should reject
        assertFalse(InputValidator.validateEmailField(null)); // null should reject
    }
}