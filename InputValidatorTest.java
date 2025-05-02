/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.InputMismatchException;

/**
 * <p>
 * This class contains test cases for validating various inputs using {@code InputValidator}.
 * Each test verifies expected behavior when given valid and invalid inputs.
 * <\p>
 * 
 * <p>
 * This class uses JUnit
 * <\p>
 * 
 * @author Maddie Anspach
 * @author with assistance from Benjamin
 * 
 * @version 01 May 2025
 * {@link InputValidator}
 */
public class InputValidatorTest
{
    
    /*
     * For more information about assertion tests check:
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */

    /**
     * Tests the {@code validateNameField} method of {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>A non-empty string is considered valid and returns {@code true}.</li>
     *   <li>An empty string returns {@code false}.</li>
     *   <li>A {@code null} value returns {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testNameFieldIsNotEmpty()
    {
        // valid name
        assertTrue(InputValidator.validateNameField("Maddie")); // non-empty string should return true

        // invalid name
        assertFalse(InputValidator.validateNameField("")); // empty string should return false
        assertFalse(InputValidator.validateNameField(null)); // null string should return false
    }

    /**
     * Tests the length validation logic in the {@code validateNameField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>Names with two or more characters are considered valid and return {@code true}.</li>
     *   <li>Names with fewer than two characters (including empty strings) return {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testNameFieldLength()
    {
        // valid names
        assertTrue(InputValidator.validateNameField("Madison")); // name longer than 2 characters should return true
        assertTrue(InputValidator.validateNameField("Ma")); // name equal to 2 characters should return true


        // invalid names
        assertFalse(InputValidator.validateNameField("M")); // name less than two characters should return false
        assertFalse(InputValidator.validateNameField("")); // empty name should return false
    }

    /**
     * Tests allowed characters logic in {@code validateNameField} method in {@link InputValidator}.
     * Tests a variety of valid and invalid name formats, including support for:
     * <ul>
     *   <li>Capitalization<\li>
     *   <li>Diacritics<\li>
     *   <li>Spaces (limited to one space)<\li>
     *   <li>Non-Latin characters<\li>
     *   <li>Combining marks<\li>
     * </ul>
     * 
     * Also tests rejection of:
     * <ul>
     *   <li>Multiple spaces<\li>
     *   <li>Punctuation or special characters<\li>
     *   <li>Numbers<\li>
     *   <li>Leading/trailing spaces<\li>
     * </ul>
     **/
    @Test
    public void testNameFieldCharacters()
    {
        // valid names
        assertTrue(InputValidator.validateNameField("Ferrari")); // name with capital letter should return true
        assertTrue(InputValidator.validateNameField("haas")); // name with no capital letters should return true
        assertTrue(InputValidator.validateNameField("McLaren")); // name with multiple capital letters should return true
        assertTrue(InputValidator.validateNameField("Zoltán")); // name with diacritic mark
        assertTrue(InputValidator.validateNameField("Lando Norris")); // name with letters and a space should return true
        assertTrue(InputValidator.validateNameField("Sergio Pérez")); // name with letters, a space, and diacritic should return true
        assertTrue(InputValidator.validateNameField("Αλεξάνδρα")); // Alexandra in Greek, name in other languages should return true
        assertTrue(InputValidator.validateNameField("hellō")); // name with combining marks (thanks Benjamin for this test)
        
        // invalid names
        assertFalse(InputValidator.validateNameField("Charles Marc Hervé Perceval Leclerc")); // names with multiple spaces should return false (people don't have more than two first names)
        assertFalse(InputValidator.validateNameField("Alpine!")); // name with punctuation should return false
        assertFalse(InputValidator.validateNameField("Lewis_Hamilton")); // name with special characters should return false
        assertFalse(InputValidator.validateNameField("Max33")); // name with numbers should return false
        assertFalse(InputValidator.validateNameField("  ")); // name containing only spaces should return false
        assertFalse(InputValidator.validateNameField(" Williams")); // name with leading space should return false
        assertFalse(InputValidator.validateNameField("Mercedes ")); // name with trailing space should return false
    }
    
    /**
     * Tests the {@code validateLastNameField} method of {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>A non-empty string is considered valid and returns {@code true}.</li>
     *   <li>An empty string returns {@code false}.</li>
     *   <li>A {@code null} value returns {@code false}.</li>
     * </ul>
     **/
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

    /**
     * Tests the length validation logic in the {@code validateLastNameField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>Names with two or more characters are considered valid and return {@code true}.</li>
     *   <li>Names with fewer than two characters (including empty strings) return {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testLastNameFieldLength()
    {
        assertTrue(InputValidator.validateLastNameField("Anspach")); // last name more than 2 character
        assertTrue(InputValidator.validateLastNameField("An")); // last name exactly 2 characters
        assertFalse(InputValidator.validateLastNameField("A")); // last name exactly 1 character
        assertFalse(InputValidator.validateLastNameField("")); // last name empty string
    }

    /**
     * Tests allowed characters logic in {@code validateLastNameField} method in {@link InputValidator}.
     * Tests a variety of valid and invalid name formats, including support for:
     * <ul>
     *   <li>Diacritics<\li>
     *   <li>Hyphens (if used correctly)<\li>
     *   <li>Apostrophes (if used correctly)<\li>
     *   <li>Multiple last names separated by spaces<\li>
     *   <li>Non-Latin characters<\li>
     *   <li>Combining marks<\li>
     * </ul>
     * 
     * Also tests rejection of:
     * <ul>
     *   <li>Consecutive or improperly spaced hyphens/apostrophes<\li>
     *   <li>Punctuation or special characters<\li>
     *   <li>Numbers<\li>
     *   <li>Leading/trailing spaces<\li>
     * </ul>
     **/
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
        assertTrue(InputValidator.validateNameField("hellō")); // name with combining marks (thanks Benjamin for this test)
        assertTrue(InputValidator.validateNameField("Αλεξάνδρα")); // Alexandra in Greek, name in other languages should return true
     
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
        assertFalse(InputValidator.validateNameField("Alpine!")); // name with punctuation should return false
        assertFalse(InputValidator.validateNameField("Lewis_Hamilton")); // name with special characters should return false
        assertFalse(InputValidator.validateNameField("Max33")); // name with numbers should return false
    }
    
    /**
     * Tests the {@code validateEmailField} method of {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>A non-empty string is considered valid and returns {@code true}.</li>
     *   <li>An empty string returns {@code false}.</li>
     *   <li>A {@code null} value returns {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testEmailFieldIsEmpty()
    {
        // valid emails
        assertTrue(InputValidator.validateEmailField("username@domain.com")); // example email

        // invalid emails
        assertFalse(InputValidator.validateEmailField("")); // empty email should reject
        assertFalse(InputValidator.validateEmailField(null)); // null should reject
    }

    /**
     * Tests the format validation logic in the {@code validateEmailField} method in {@link InputValidator}.
     * Verifies a variety of valid and invalid email address formats based on the format {@code string1@string2.string3}
     * 
     * Valid email formats include:
     * <ul>
     *   <li>Exactly one {@code @} symbol separating string1 and string 2</li>
     *   <li>A period separating string2 and string3</li>
     *   <li>Support for any characters in substrings, except additional {@code @} symbols and spaces</li>
     * </ul>
     * 
     * Invalid email formats include:
     * <ul>
     *   <li>Addresses with spaces in any part</li>
     *   <li>Multiple or misplaced {@code @} symbols</li>
     *   <li>Missing string1, string2, or string3</li>
     *   <li>Missing periods</li>
     * </ul>
     */
    @Test
    public void testEmailFieldFormat()
    {
        // valid emails
        assertTrue(InputValidator.validateEmailField("LewisHamilton44@ferrari.com")); // email with numbers in username
        assertTrue(InputValidator.validateEmailField("Max_Verstappen@redbull.org")); // email with underscore in username
        assertTrue(InputValidator.validateEmailField("FernandoAlonso!@aston-martin.edu")); // email with punctuation and dash in domain
        assertTrue(InputValidator.validateEmailField("Nico.Rosberg@mercedes.net")); // email with period
        assertTrue(InputValidator.validateEmailField("Michael-Schumacher@ferrari.com")); // email with dash in username
        assertTrue(InputValidator.validateEmailField("driver@f1.co.uk")); // multiple domain suffix parts
        assertTrue(InputValidator.validateEmailField("a@b.c")); // shortest possible email following specifications

        // invalid emails

        // space testing
        assertFalse(InputValidator.validateEmailField("lando norris@mclaren.com")); // email with space in string 1
        assertFalse(InputValidator.validateEmailField(" landonorris@mclaren.com")); // email with space at beginning of string 1
        assertFalse(InputValidator.validateEmailField("landonorris @mclaren.com")); // email with space at end of string 1
        assertFalse(InputValidator.validateEmailField("charlesleclerc@ferr ari.com")); // email with space in string 2
        assertFalse(InputValidator.validateEmailField("charlesleclerc@ ferrari.com")); // email with space at beginning of string 2
        assertFalse(InputValidator.validateEmailField("charlesleclerc@ferrari .com")); // email with space at end of string 2
        assertFalse(InputValidator.validateEmailField("georgerussell@mercedes.n et")); // email with space in string 3
        assertFalse(InputValidator.validateEmailField("georgerussell@mercedes. net")); // email with space at beginning of string 3
        assertFalse(InputValidator.validateEmailField("georgerussell@mercedes.net ")); // email with space at end of string 3

        // @ testing
        assertFalse(InputValidator.validateEmailField("olliebearman@@hass.com")); // double @
        assertFalse(InputValidator.validateEmailField("ollie@bearman@hass.com")); // extra @
        assertFalse(InputValidator.validateEmailField("olliebearman@hass.c@om")); // extra @
        assertFalse(InputValidator.validateEmailField("olliebearmanhass.com")); // no @

        // string2.string3 testing
        assertFalse(InputValidator.validateEmailField("isackhadjar@racingbullsorg")); // missing .

        // character length of each substring
        assertFalse(InputValidator.validateEmailField("@mercedes.net")); // missing string 1
        assertFalse(InputValidator.validateEmailField("andreakimiantonelli@.net")); // missing string 2
        assertFalse(InputValidator.validateEmailField("andreakimiantonelli@mercedes.")); // missing string 3
    }

    /**
     * Tests the {@code validateUsernameField} method of {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>A non-empty string is considered valid and returns {@code true}.</li>
     *   <li>An empty string returns {@code false}.</li>
     *   <li>A {@code null} value returns {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testUsernameFieldIsEmpty()
    {
        // valid username
        assertTrue(InputValidator.validateUsernameField("maddie")); // non-empty string should return true

        // invalid username
        assertFalse(InputValidator.validateUsernameField("")); // empty string should return false
        assertFalse(InputValidator.validateUsernameField(null)); // null string should return false
    }

    /**
     * Tests the length validation logic in the {@code validateUsernameField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>Usernames with 1-20 characters are considered valid and return {@code true}.</li>
     *   <li>Names with fewer than 1 character (including empty strings) return {@code false}.</li>
     *   <li>Names with more than 20 characters return {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testUsernameFieldLength()
    {
        // valid usernames
        assertTrue(InputValidator.validateUsernameField("m")); // username with one character should be accepted
        assertTrue(InputValidator.validateUsernameField("madisonmaeanspach444")); // username with 20 characters should be accepted

        // invalid usernames
        assertFalse(InputValidator.validateUsernameField("")); // empty string is too short
        assertFalse(InputValidator.validateUsernameField("madisonmaeanspach1144")); // username with 21 characters should be rejected
    }

    /**
     * 
     **/
    @Test
    public void testUsernameFieldCharacters()
    {
        // valid usernames
        assertTrue(InputValidator.validateUsernameField("SergioPérez")); // username with diacritics
        assertTrue(InputValidator.validateUsernameField("Αλεξάνδρα")); // username in other language
        assertTrue(InputValidator.validateUsernameField("madisonanspach04")); // username with numbers
        assertTrue(InputValidator.validateUsernameField("madison_anspach")); // username with underscores
        assertTrue(InputValidator.validateUsernameField("madison.anspach")); // username with period
        assertTrue(InputValidator.validateUsernameField("2004")); // username of only numbers
        assertTrue(InputValidator.validateUsernameField("___")); // username of only underscores
        assertTrue(InputValidator.validateUsernameField("..")); // username of only periods

        //invalid usernames
        assertFalse(InputValidator.validateUsernameField("madison anspach")); // username with space
        assertFalse(InputValidator.validateUsernameField("madison!")); // username with punctuation (other than period)
        assertFalse(InputValidator.validateUsernameField("madison-anspach")); // username with hyphen
        assertFalse(InputValidator.validateUsernameField("madisonanspach$")); // username with special character
    }
}