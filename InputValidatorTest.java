
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