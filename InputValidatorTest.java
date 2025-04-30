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
        assertTrue(InputValidator.validateNameField("Maddie")); // non-empty string should return valid
        assertFalse (InputValidator.validateNameField("")); // empty string should be invalid
    }
    

    public void testTitleIsNotEmpty()
    {
        assertTrue(InputValidator.validateTitle("Red Picture")); //Should 
        assertFalse(InputValidator.validateTitle("")); //Should fail

    }
    public void testTitleLength()
    {
        assertTrue(InputValidator.validateTitleLength(10)); //Pass
        assertFalse(InputValidator.validateTitleLength(0)); // Fail
        assertFalse(InputValidator.validateTitleLength(1001)); // Fail
    }

    public void testImage()
    {
        asserTrue(InputValidator.validateImage("ArtWork.JPG", )); //Pass
        asserTrue(InputValidator.validateImage("painting.PNG", )); //Pass
        asserFalse(InputValidator.validateImage("painting.png", )); //Fail
        asserFalse(InputValidator.validateImage("painting.jpg", )); //Fail
    }

    public void testDimensions ()
    {
        
    }
    // CREATE MORE TESTS HERE
    
}