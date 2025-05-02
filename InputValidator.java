/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */

public class InputValidator
{
    //return in format of(valid symbol(currencySymbol))(valid numbers at least 1(dollars))(period .(period))(2 digits(cents)) or empty
    public static boolean validateCurrencyField(String currency)
    {
        if ((currency == "" || currency == null)){
            return true;
        }

    //pattern for currency validation
    // ^               - start of string
    // [$€₱₿]          - currency symbols (Dollar, Euro, Peso, Bitcoin)
    // [1-9][0-9]*     - first digit can't be 0, followed by any number of digits
    // \.              - decimal point
    // [0-9]{2}        - exactly 2 digits for cents
    // $               - end of string
    String pattern = "^[$€₱₿][1-9][0-9]*\\.[0-9]{2}$";

    return currency.matches(pattern);
        
    }




//YYYY/MM/DD format, must be a valid date, must not be empty
    public static boolean validateCreationDateField(String creationDate)
    {
        // Check if empty or null
    if (creationDate == null || creationDate == "") {
        return false;
    }

    // Check format: YYYY/MM/DD where each part has exact digits
    if (!creationDate.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
        return false;
    }
    
    
        // Parse the date parts
        int year = Integer.parseInt(creationDate.substring(0, 4));
        int month = Integer.parseInt(creationDate.substring(5, 7));
        int day = Integer.parseInt(creationDate.substring(8, 10));

        // Check year range (1900-2025)
        if (year < 1900 || year > 2025) {
            return false;
        }

        // Check month range (1-12)
        if (month < 1 || month > 12) {
            return false;
        }

        // Check day range (1-31)
        if (day < 1 || day > 31) {
            return false;
        }

        return true;
    }

    
        




    //Only 4 valid mediums
    public static boolean validateMediumField(String medium)
    {
        //4 valid mediums return true
        if (medium == "Oil Painting"){
            return true;
        }
        else if (medium == "Water Color"){
            return true;
        }
        else if (medium == "Digital Photography"){
            return true;
        }
        else if (medium == "Sculpture"){
            return true;
        }
        //anything else is false
        else{
            return false;
        }
    }
}