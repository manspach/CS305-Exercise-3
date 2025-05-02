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
    public void testTitleIsNotEmpty()
    {
        //Passing
        assertTrue(InputValidator.validateTitle("Red Picture")); //Valid Title test will return true
        assertTrue(InputValidator.validateTitle("h")); //Single letter titles are allowed should return true
        //Within the title character limit (99 characters)
        assertTrue(InputValidator.validateTitle("ipsumdolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est s"));
        

        //Failing
        assertFalse(InputValidator.validateTitle("")); //Test empty title should return true
        assertFalse(InputValidator.validateTitle(null)); //Should fail test empty title again should return true
        assertFalse(InputValidator.validateTitle(" ")); //Single letter titles are allowed should return true
        //Outside the title character limt (100 characters)
        assertFalse(InputValidator.validateTitle("ipsum dolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est s"));
    }
    
    @Test
    public void testDescription()
    {
        //Passing
        assertTrue(InputValidator.validateDescription("The painting is of the authors mother")); //Valid description fits all criteria should return true
        assertTrue(InputValidator.validateDescription("The ")); //Valid description fits all criteria should return true
        assertTrue(InputValidator.validateDescription("Boat")); //Valid description fits all criteria should return true
        //Within the character limit (999 characters)
        assertTrue(InputValidator.validateDescription("Loremipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est laborum"));

        //Failing
        assertFalse(InputValidator.validateDescription("")); //Invalid becasue there is no description should return false 
        assertFalse(InputValidator.validateDescription(null));//nvalid becasue there is no description should return false 
        assertFalse(InputValidator.validateDescription(" ")); //Invalid becasue there is no description should return false 
        //Outside character limit (1000 characters)
        assertFalse(InputValidator.validateDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborumLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do equi officia deserunt mollit anim id est laborum" )); 
    }

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
    @Test
    public void testDimensions ()
    {
        //Passing
        assertTrue(InputValidator.isValidDimensions("24", "36", "inches")); //Has all requirements of width adn height
       
       //Failing
        assertFalse(InputValidator.isValidDimensions("24", "", "inches")); //Missing height int should return false
        assertFalse(InputValidator.isValidDimensions("", "36", "inches")); //Missing width should return false
        assertFalse(InputValidator.isValidDimensions("", "", "")); // Missing dimensions and units should return false

    }
    // CREATE MORE TESTS HERE

    //price
    public void testCurrencyIsValid()
    {
        //valid currencies

        //invalid currencies
    }
    public void testCurrencyCanBeEmpty()
    {
        //empty tests (should be accepted)
    }

    //creation date
    public void testCreationDateIsNotEmpty()
    {
        //empty tests (Should not be accepted)
    }
    public void testDateIsValidFormat()
    {
        //valid date formats

        //invalid date formats
    }
    public void testDateIsValid()
    {
        //valid date

        //invalid date
    }

    //medium
    public void testMediumIsAccepted()
    {
        //valid mediums

        //invalid mediums
    }
    public void testMediumIsNotEmpty()
    {
        //empty tests (should not be accepted)
    }

    
}