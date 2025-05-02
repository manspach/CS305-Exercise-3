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