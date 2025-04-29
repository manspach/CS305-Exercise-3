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
    
    // CREATE MORE TESTS HERE
    
}