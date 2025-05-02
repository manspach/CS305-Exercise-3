/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */

public class InputValidator
{
    /**
     * Validates a currency field input.
     *
     * This validation ensures that:
     * <ul>
     *   <li>The currency field starts with a valid symbol</li>
     *   <li>The currency field symbol is followed by a number of any length that doesn't stats with a "0"</li>
     *   <li>The currency field number is then followed by a "." which is followed by 2 digits</li>
     * </ul>
     *
     * @param currency the currency string to validate
     * @return {@code true} if the currency is valid, {@code false} otherwise
     **/
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




/**
     * Validates a creation date input.
     *
     * This validation ensures that:
     * <ul>
     *   <li>The creation date follows a YYYY/MM/DD format</li>
     *   <li>The creation date is a valid date</li>
     *   <li>The creation date field must be filled</li>
     * </ul>
     *
     * @param creationDate the creationDate string to validate
     * @return {@code true} if the creation date is valid, {@code false} otherwise
     **/
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

    
        




    /**
     * Validates a medium input.
     *
     * This validation ensures that:
     * <ul>
     *   <li>The medium is either "Oil Painting", "Water Color", "Digital Photography", "Sculpture"</li>
     * </ul>
     *
     * @param medium the creationDate string to validate
     * @return {@code true} if the medium is valid, {@code false} otherwise
     **/
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