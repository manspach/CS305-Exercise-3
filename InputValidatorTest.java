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
    

    public void testTitleIsNotEmpty()
    {
        assertTrue(InputValidator.validateTitle("Red Picture")); //Valid Title test will return true
        assertFalse(InputValidator.validateTitle("")); //Test empty title should return true
        assertFalse(InputValidator.validateTitle(null)); //Should fail test empty title again should return true

    }
    public void testTitleLength()
    {
        assertTrue(InputValidator.validateTitleLength(10)); //Pass
        assertFalse(InputValidator.validateTitleLength(0)); // Fail
        assertFalse(InputValidator.validateTitleLength(1001)); // Fail
    }
    public void testDescription()
    {
        assertTrue(InputValidator.validateDescription("The painting is of the authors mother")); //Valid description fits all criteria should return true
        assertFalse(InputValidator.validateDescription("")); //Invalid becasue there is no description should return false 
        assertFalse(InputValidator.validateDescription(null));//nvalid becasue there is no description should return false 
    }
    
    public void testDescriptionLength()
    {
        assertTrue(InputValidator.validateDescriptionLength(100)); //Vaild length should return true
        assertFalse(InputValidator.validateDescriptionLength(0)); //Invalid description length is not long enough should return false
        assertFalse(InputValidator.validateDescriptionLength(null)); //Invalid description length is not long enough should return false
    }

    public void testImage()
    {
        asserTrue(InputValidator.validateImage("ArtWork.JPG", 3)); //Matches what we want should return true
        asserTrue(InputValidator.validateImage("painting.PNG", 3)); //Matches what we want should return true
        assertTrue(InputValidator.validateImage("painting.JPG", 2.67)); //Within limits should return true 
        assertFalse(InputValidator.validateImage("painting.PNG", 5)) //The MB is over the limt should return false
        asserFalse(InputValidator.validateImage("painting.JPG", 10)); //Extenstion is right, but the size is too big
        asserFalse(InputValidator.validateImage("painting.png", 4)); //The extension is wrong should return false
        

    }

    public void testDimensions ()
    {
        assertTrue(InputValidator.isValidDimensions("24x36 inches")); //Has all requirements of width adn height
        assertFalse(InputValidator.isValidDimensions("24x inches")); //Missing height int should return false
        assertFalse(InputValidator.isValidDimensions("x36inches")); //Missing width should return false
        assertFalse(InputValidator.isValidDimensions("")); // Missing dimensions should return false

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