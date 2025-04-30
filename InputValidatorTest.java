/*
 * These are the libraries from JUnit that allows you to test
 * Java applications. For more information check the complete tutorial
 * here: https://www.tutorialspoint.com/junit/index.htm
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
    
    /*
     * Example test method for a possible Name field validator method in your 
     * InputValidator class.
     * For more information about assertion tests check: 
     * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
     */
    @Test
    public void testNameFieldIsNotEmpty() {
        // assertTrue(InputValidator.validateNameField("..."));
        // assertFalse (InputValidator.validateNameField("..."));
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