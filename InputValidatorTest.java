
/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;

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
 * @author Harry Spark
 * @author Collin Russell
 * @author Junior Matuza
 * @author with assistance from Benjamin
 * 
 * @version 02 May 2025
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
        assertTrue(InputValidator.validateLastNameField("hellō")); // name with combining marks (thanks Benjamin for this test)
        assertTrue(InputValidator.validateLastNameField("Αλεξάνδρα")); // Alexandra in Greek, name in other languages should return true
     
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
        assertFalse(InputValidator.validateLastNameField("Alpine!")); // name with punctuation should return false
        assertFalse(InputValidator.validateLastNameField("Lewis_Hamilton")); // name with special characters should return false
        assertFalse(InputValidator.validateLastNameField("Max33")); // name with numbers should return false
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
        assertTrue(InputValidator.validateUsernameField("maddie", null)); // non-empty string should return true

        // invalid username
        assertFalse(InputValidator.validateUsernameField("", null)); // empty string should return false
        assertFalse(InputValidator.validateUsernameField(null, null)); // null string should return false
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
        assertTrue(InputValidator.validateUsernameField("m", null)); // username with one character should be accepted
        assertTrue(InputValidator.validateUsernameField("madisonmaeanspach444", null)); // username with 20 characters should be accepted

        // invalid usernames
        assertFalse(InputValidator.validateUsernameField("", null)); // empty string is too short
        assertFalse(InputValidator.validateUsernameField("madisonmaeanspach1144", null)); // username with 21 characters should be rejected
    }

    /**
     * Tests the character validation logic in the {@code validateUsernameField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>Usernames with valid characters—such as letters (including Unicode), numbers, underscores, and periods—return {@code true}.</li>
     *   <li>Usernames containing invalid characters—such as spaces, punctuation other than periods, hyphens, or special symbols—return {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testUsernameFieldCharacters()
    {
        // valid usernames
        assertTrue(InputValidator.validateUsernameField("SergioPérez", null)); // username with diacritics
        assertTrue(InputValidator.validateUsernameField("Αλεξάνδρα", null)); // username in other language
        assertTrue(InputValidator.validateUsernameField("madisonanspach04", null)); // username with numbers
        assertTrue(InputValidator.validateUsernameField("madison_anspach", null)); // username with underscores
        assertTrue(InputValidator.validateUsernameField("madison.anspach", null)); // username with period
        assertTrue(InputValidator.validateUsernameField("2004", null)); // username of only numbers
        assertTrue(InputValidator.validateUsernameField("___", null)); // username of only underscores
        assertTrue(InputValidator.validateUsernameField("..", null)); // username of only periods

        //invalid usernames
        assertFalse(InputValidator.validateUsernameField("madison anspach", null)); // username with space
        assertFalse(InputValidator.validateUsernameField("madison!", null)); // username with punctuation (other than period)
        assertFalse(InputValidator.validateUsernameField("madison-anspach", null)); // username with hyphen
        assertFalse(InputValidator.validateUsernameField("madisonanspach$", null)); // username with special character
    }

    /**
     * Tests the uniqueness validation logic in the {@code validateUsernameField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     *   <li>Usernames that are not already present in the provided dataset return {@code true}.</li>
     *   <li>Usernames that already exist in the dataset (case-sensitive comparison) return {@code false}.</li>
     * </ul>
     **/
    @Test
    public void testUsernameFieldUnique()
    {
        HashSet<String> usernameData = new HashSet<>();
        usernameData.add("maddieanspach");
        usernameData.add("lando");

        // valid unique usernames
        assertTrue(InputValidator.validateUsernameField("lewishamilton", usernameData));
        assertTrue(InputValidator.validateUsernameField("Lando", usernameData));

        // invalid not unique usernames
        assertFalse(InputValidator.validateUsernameField("lando", usernameData));
        assertFalse(InputValidator.validateUsernameField("maddieanspach", usernameData));
    }

    /**
     * Tests all validation logic in the {@code validatePasswordField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     * <li>Passwords with eight or more characters are considered valid and return {@code true}.</li>
     * <li>Passwords with fewer than eight characters (including empty strings) are considered invalid and return {@code false}.</li>
     * <li>Passwords containing one or more uppercase letters, lowercase letters, and digits are considered valid and return {@code true}.</li>
     * <li>Passwords containing no uppercase letters, lowercase letters, and digits are considered invalid and return {@code false}.</li>
     * <li>Passwords containing or not containing special characters !, -, *, and . (assuming other requirements are met) are considered valid and return {@code ture}</li>
     * </ul>
     */
    //Must not be empty. At least 8 characters long. At least one uppercase letter, one 
    //lowercase letter, and one digit. Can use the special characters !, -, *, and ..
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

    /**
     * Tests all validation logic in the {@code validatePhoneNumberField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     * <li>Phone numbers with exactly 10 digits are considered valid and retutrn {@code true}.</li>
     * <li>Phone numbers with any amount of digits other than 10 (excluding empty strings) are considered invalid and return {@code false}.</li>
     * <li>Phone number input fields with an empty string are considered valid and return {@code true}.</li>
     * <li>Phone numbers containing or not containing dashes or spaces (assuming other requirements are met) are considered valid and return {@code ture}</li>
     * <ul>
     */
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

    /**
     * Tests all validation logic in the {@code validateDateOfBirthField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     * <li>Date of birth inputs that are empty are considered invalid and return {@code false}.</li>
     * <li>Date of birth inputs that follow the format yyyy-MM-dd are considered valid and return {@code true}.</li>
     * <li>Date of birth inputs that follow any other format (other than yyyy-MM-dd) are considered invalid and return {@code false}.</li>
     * <li>Date of birth inputs that show that the user is >=18 years old are considered valid and return {@code true}.</li>
     * <li>Date of birth inputs that show that the user is <18 years old are considered invalid and return {@code false}.</li>
     * <ul>
     */
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

    /**
     * Tests all validation logic in the {@code validatePostalCodeField} method of the {@link InputValidator} class.
     * This test verifies that:
     * <ul>
     * <il>Postal codes with exactly 5 digits (for U.S.A.) are considered valid and return {@code true}.</li>
     * <li>Postal codes with any amount of digits other than 5 (excluding empty strings) are considered invalid and return {@code false}.</li>
     * <li>Postal code input fields with an empty string (if postal code is not from U.S.A.) are considered valid and return {@code true}.</li>
     * <li>Postal codes containing only digits are considered valid and return {@code true}.</li>
     * <li>Postal codes containing letters or special characters are considered invalid and return {@code false}.</li>
     * <ul>
     */
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
    
    /**
     * Test the {@code validateTitle} method of {@link InputValidator} class
     * This test varifies that:
     *      A not empty string is valid and returns {@code true}.
     *      A null string is invalid and returns {@code false}.
     *      A empty string is invalid and returns {@code false}.   
     *      A empty string with a space is invalid and returns {@code false}.
     */
    @Test
    public void testTitleIsNotEmpty()
    {
        //Passing
        assertTrue(InputValidator.validateTitle("Red Picture")); //Valid Title test will return true       

        //Failing
        assertFalse(InputValidator.validateTitle("")); //Test empty title should return true
        assertFalse(InputValidator.validateTitle(null)); //Should fail test empty title again should return true
        assertFalse(InputValidator.validateTitle(" ")); //Single letter titles are allowed should return true
        }

    /**
     * Test the {@code validateTitle} method of {@link InputValidator} class
     * This test varifies that:
     *      A string with the length 13 is valid and returns {@code true}.
     *      A string with the length 1 is valid and returns {@code true}.
     *      A string with the length 99 is valid and returns {@code true}.
     *      A string with the length 4 in spaces is invalid and returns {@code false}.
     *      A string with the length 100 is invalid and returns {@code false}.
     */
    @Test
    public void testTitleLength()
    {
        //Passing
        assertTrue(InputValidator.validateTitle("Story of Joe ")); //Valid title with in title length limits. 
        assertTrue(InputValidator.validateTitle("h")); //Single letter titles in limits. return true.
        //Within the title character limit (99 characters)
        assertTrue(InputValidator.validateTitle("ipsumdolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est s"));

        //Failing
        assertFalse(InputValidator.validateTitle("    "));//4 characters, but only spaces does not count as length. Return false.
        //Outside the title character limt (100 characters)
        assertFalse(InputValidator.validateTitle("ipsum dolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est s"));
    }
    
    /**
     * Test the {@code validateDescription} method of {@link InputValidator} class
     * This test varifies that:
     *      A not empty string is valid and returns {@code true}.
     *      A not empty string with a space at the end is valid and returns {@code true}.
     *      A not empty string with a space at the front is valid and returns {@code true}. 
     *      A empty string is invalid and returns {@code false}.
     *      A null string is invalid and returns {@code false}.
     *      A empty string with a space is invalid and returns {@code false}.   
     */
    @Test
    public void testDescription()
    {
        //Passing
        assertTrue(InputValidator.validateDescription("The painting is of the authors mother")); //Valid description fits all criteria should return true
        assertTrue(InputValidator.validateDescription("The ")); //Valid description fits all criteria should return true
        assertTrue(InputValidator.validateDescription(" Boat")); //Valid description fits all criteria should return true
        

        //Failing
        assertFalse(InputValidator.validateDescription("")); //Invalid becasue there is no description should return false 
        assertFalse(InputValidator.validateDescription(null));//nvalid becasue there is no description should return false 
        assertFalse(InputValidator.validateDescription(" ")); //Invalid becasue there is no description should return false 
        
    }

    /**
     * Test the {@code validateDescription} method of {@link InputValidator} class
     * This test varifies that:
     *      A string with the length 1 is valid and returns {@code true}.
     *      A string with the length 999 is valid and returns {@code true}.
     *      A string with the length 10 in spaces is invalid and returns {@code false}.
     *      A string with the length 1000 is invalid and returns {@code false}.
     */
    @Test
    public void testDescriptionLength()
    {
        //Passing 
        assertTrue(InputValidator.validateDescription("T")); //Valid description length. Return true
        //Within the character limit (999 characters)
        assertTrue(InputValidator.validateDescription("Loremipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est laborum"));
        
        //Failing
        assertFalse(InputValidator.validateDescription("          ")); //Invalid character length becasue spaces (10 spaces) does not count as length. Return False.
        //Outside character limit (1000 characters)
        assertFalse(InputValidator.validateDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est laborum" )); 
    }


    /**
     * Test the {@code validateImage} method of {@link InputValidator} class
     * This test varifies that:
     *      A image that is given has a extention of ".JPG" with a file size of 3 is valid and returns {@code true}.
     *      A image that is given has a extention of ".JPNG" with a file size of 3 is valid and returns {@code true}. 
     *      A image that is given has a extention of ".JPG" with a file size of 2.67 is valid and returns {@code true}.
     *      
     *      A image that is given has a extention of ".png" with a file size of 3 is invalid and returns {@code false}.
     *      A image that is given has a extention of ".PNG" with a file size of 5 is invalid and returns {@code false}.
     *      A image that is given has a extention of ".JPG" with a file size of 10 is invalid and returns {@code false}.
     *      A image that is given has a extention of ".png" with a file size of 4 is invalid and returns {@code false}.
     */
    @Test
    public void testImage()
    {
        //Passing 
        assertTrue(InputValidator.validateImage("ArtWork.JPG", 3)); //Matches criteria should return true
        assertTrue(InputValidator.validateImage("painting.PNG", 3)); //Matches criteria should return true
        assertTrue(InputValidator.validateImage("painting.JPG", 2.67)); //Within limits should return true 

        //Failing
        assertFalse(InputValidator.validateImage("photo.png", 3)); //The extension is lower case so it should pass as false
        assertFalse(InputValidator.validateImage("painting.PNG", 5)); //The MB is over the limt should return false
        assertFalse(InputValidator.validateImage("painting.JPG", 10)); //Extenstion is right, but the size is too big
        assertFalse(InputValidator.validateImage("painting.png", 4)); //The extension is wrong should return false
        

    }

    /**
     * Test the {@code isValidDimensions} method of {@link InputValidator} class
     * This test varifies that:
     *      A dimention of width: 24, height: 36, and unit: inches is valid and returns {@code true}.
     *      A dimention of width: 67, height: 100, and unit: meters is valid and returns {@code true}.
     *      A dimention of width: 5, height: 16, and unit: feet is valid and returns {@code true}.
     *      A dimention of width: , height: 36, and unit: inches is invalid and returns {@code false}.
     *      A dimention of width: 24, height: , and unit: inches is invalid and returns {@code false}.
     *      A dimention of width: , height: , and unit:  is invalid and returns {@code false}. 
     */
    @Test
    public void testDimensions ()
    {
        //Passing
        assertTrue(InputValidator.isValidDimensions("24", "36", "inches")); //Has all requirements of width, height, and unit
        assertTrue(InputValidator.isValidDimensions("67", "100", "meters")); //Has all requirements of width, height, and unit
        assertTrue(InputValidator.isValidDimensions("5", "16", "feet")); //Has all requirements of width, height, and unit
       
       //Failing
        assertFalse(InputValidator.isValidDimensions("24", "", "inches")); //Missing height int should return false
        assertFalse(InputValidator.isValidDimensions("", "36", "inches")); //Missing width should return false
        assertFalse(InputValidator.isValidDimensions("24", "", "inches")); //Missing height should return false
        assertFalse(InputValidator.isValidDimensions("", "", "")); // Missing dimensions and units should return false

    }

    //*****PRICE*****
    @Test
    public void testCurrencyFormatIsValid()
    {
        //valid currency format
        assertTrue(InputValidator.validateCurrencyField("$5.00")); // valid currency format (test should PASS)
        assertTrue(InputValidator.validateCurrencyField("€8753.97")); // valid currency format (test should PASS)

        //invalid currency format
        assertFalse(InputValidator.validateCurrencyField("€900.975")); // invalid currency format (test should PASS)
        assertFalse(InputValidator.validateCurrencyField("$.97")); // invalid currency format (test should NOT PASS)

    }
    @Test
    public void testCurrencyTypeIsValid()
    {
        //valid currency type
        assertTrue(InputValidator.validateCurrencyField("$99.99")); // valid currency type (Dollar) (test should PASS)
        assertTrue(InputValidator.validateCurrencyField("€99.99")); // valid currency type (Euro) (test should PASS)
        assertTrue(InputValidator.validateCurrencyField("₱99.99")); // valid currency type (Mexican Peso) (test should PASS)
        assertTrue(InputValidator.validateCurrencyField("₿99.99")); // valid currency type (Bit Coin) (test should PASS)


        //invalid currency type
        assertFalse(InputValidator.validateCurrencyField("&99.99")); // invalid currency type (and symbol) (test should PASS)
        assertFalse(InputValidator.validateCurrencyField("+99.99")); // invalid currency type (plus symbol) (test should PASS)


    }
    @Test
    public void testCurrencyCanBeEmpty()
    {
        //empty tests (should be accepted)
        assertTrue(InputValidator.validateCurrencyField("")); // empty (test should PASS)
        assertTrue(InputValidator.validateCurrencyField(null)); // null (test should PASS)



        //not empty test (should also be accepted)
        assertTrue(InputValidator.validateCurrencyField("$9.99")); // filled field (test should PASS)

    }

    @Test
    //*****CREATION DATE*****
    public void testCreationDateIsNotEmpty()
    {
        //empty tests (Should NOT be accepted)
        assertFalse(InputValidator.validateCreationDateField("")); // empty (test should PASS)
        assertFalse(InputValidator.validateCreationDateField(null)); // null (test should PASS)

        //not empty tests (SHOULD be accepted)
        assertTrue(InputValidator.validateCreationDateField("2005/08/14")); // null (test should PASS)

    }
    @Test
    public void testCreationDateIsValidFormat()
    {
        //valid date formats
        assertTrue(InputValidator.validateCreationDateField("2015/01/24")); // valid format (test should PASS)


        //invalid date formats
        assertFalse(InputValidator.validateCreationDateField("20015/01/24")); // invalid format (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("205/01/24")); // invalid format (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/011/24")); // invalid format (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/1/24")); // invalid format (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/01/214")); // invalid format (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/01/4")); // invalid format (test should PASS)
    }
    @Test
    public void testCreationDateIsValid()
    {
        //valid date
        assertTrue(InputValidator.validateCreationDateField("1905/03/07")); // valid date (test should PASS)


        //invalid date
        assertFalse(InputValidator.validateCreationDateField("1899/01/30")); // invalid date (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2026/01/01")); // invalid date (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/00/22")); // invalid date (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/13/22")); // invalid date (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/01/32")); // invalid date (test should PASS)
        assertFalse(InputValidator.validateCreationDateField("2015/01/00")); // invalid date (test should PASS)
    }

    @Test
    //***MEDIUM***
    public void testMediumIsAccepted()
    {
        //valid mediums
        assertTrue(InputValidator.validateMediumField("Oil Painting")); // Valid Medium (test should PASS)
        assertTrue(InputValidator.validateMediumField("Water Color")); // Valid Medium (test should PASS)
        assertTrue(InputValidator.validateMediumField("Digital Photography")); // Valid Medium (test should PASS)
        assertTrue(InputValidator.validateMediumField("Sculpture")); // Valid Medium (test should PASS)

        //invalid mediums
        assertFalse(InputValidator.validateMediumField("Cookie")); // Invalid Medium (test should PASS)
        assertFalse(InputValidator.validateMediumField("Soccer")); // Invalid Medium (test should PASS)
        assertFalse(InputValidator.validateMediumField("Chair")); // Invalid Medium (test should PASS)
        
    }
    @Test
    public void testMediumIsNotEmpty()
    {
        //empty tests (should NOT be accepted)
        assertFalse(InputValidator.validateMediumField("")); // empty (test should PASS)
        assertFalse(InputValidator.validateMediumField(null)); // null (test should PASS)


        //not empty tests (SHOULD be accepted)
        assertTrue(InputValidator.validateMediumField("Sculpture")); // Non-Empty Medium (test should PASS)

    }
}