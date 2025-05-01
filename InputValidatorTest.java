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

    //*****PRICE*****
    public void testCurrencyFormatIsValid()
    {
        //valid currency format

        //invalid currency format
    }
    public void testCurrencyTypeIsValid()
    {
        //valid currency type

        //invalid currency type
    }
    public void testCurrencyCanBeEmpty()
    {
        //empty tests (should be accepted)

        //not empty test (should also be accepted)
    }

    //*****CREATION DATE*****
    public void testCreationDateIsNotEmpty()
    {
        //empty tests (Should NOT be accepted)

        //not empty tests (SHOULD be accepted)
    }
    public void testCreationDateIsValidFormat()
    {
        //valid date formats

        //invalid date formats
    }
    public void testCreationDateIsValid()
    {
        //valid date

        //invalid date
    }

    //***MEDIUM***
    public void testMediumIsAccepted()
    {
        //valid mediums

        //invalid mediums
    }
    public void testMediumIsNotEmpty()
    {
        //empty tests (should NOT be accepted)

        //not empty tests (SHOULD be accepted)
    }

    
}