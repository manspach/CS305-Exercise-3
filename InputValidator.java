/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

/**
 * This is a class for validating various input fields.
 * 
 * @author Maddie Anspach
 * @author Harry Spark
 * @author Collin Russell
 * @author Junior Matuza
 * @author with assistance from Benjamin
 * @author with assistance from Dr. Vargas-Perez
 * 
 * @version 02 May 2025
 */

public class InputValidator
{
    /**
     * Validates a first name input.
     *
     * This validation ensures that:
     * <ul>
     *   <li>The name is not {@code null} and has a minimum length of 2 characters.</li>
     *   <li>The name contains only letters (Unicode) and optionally one space separating two names.</li>
     * </ul>
     *
     * @param name the first name string to validate
     * @return {@code true} if the name is valid, {@code false} otherwise
     **/
    public static boolean validateNameField(String name)
    {
        // regex explanation:
        // ^ : start
        // \\p{L}+ : starts with one or more letters
        // ( \\p{L}+)? : optionally followed by one space and more letters
        // $ : stop
        return name != null
            && name.length() >= 2
            && name.matches("^[\\p{L}\\p{M}]+( [\\p{L}\\p{M}]+)?$");
    }

    /**
     * Validates a last name input.
     *
     * This validation ensures that:
     * <ul>
     *   <li>The last name is not {@code null} and has a minimum length of 2 characters.</li>
     *   <li>The name allows for compound structures including spaces, apostrophes, and hyphens.</li>
     *   <li>Only letters (Unicode), spaces, apostrophes, and hyphens are allowed in specific positions.</li>
     * </ul>
     *
     * @param lastName the last name string to validate
     * @return {@code true} if the last name is valid, {@code false} otherwise
     **/
    public static boolean validateLastNameField(String lastName)
    {
        // regex explanation:
        // ^ : start
        // [\\p{L}]+ : at least one letter
        // [ '\\-]? : optionally followed by one space, one apostrophe, or one hypen
        // [\\p{L}]+ : must be followed by at least one letter
        // ([ '\\-]?[\\p{L}]+)* : entire second statement happening zero or more times
        // $ : stop
        return lastName != null
            && lastName.length() >= 2
            && lastName.matches("^[\\p{L}\\p{M}]+([ '\\-]?[\\p{L}\\p{M}]+)*$");
    }

    /**
     * Validates an email address input.
     * <p>
     * This validation ensures that:
     * <ul>
     *   <li>The email is not {@code null} or empty.</li>
     *   <li>The email conforms to a common pattern: example@domain, supporting multiple domain extensions.</li>
     *   <li>Disallows whitespace and multiple {@code @} symbols.</li>
     * </ul>
     *
     * @param email the email address string to validate
     * @return {@code true} if the email is valid, {@code false} otherwise
     **/
    public static boolean validateEmailField(String email)
    {
        // regex explanation:
        // ^ : start
        // [^\\s@]+ : string with at least one character, but no spaces and no @
        // @ : followed by exactly one @
        // [^\\s@]+ : followed by a string with at least one character, no spaces and no @
        // \\. : followed by one period
        // [^\\s@]+ : followed by a string with at least one character, no spaces and no @
        // (\\.[^\\s@]+)+ : entire expression can be repeated (consider emails with a country code)
        // $ : stop
        return email != null
            && !email.isEmpty()
            && email.matches("^[^\\s@]+@[^\\s@]+(\\.[^\\s@]+)+$");
    }

    /**
     * Validates a username input based on character rules and optional uniqueness.
     * <p>
     * This validation ensures that:
     * <ul>
     *   <li>The username is not {@code null} or empty.</li>
     *   <li>The username has a length between 1 and 20 characters.</li>
     *   <li>The username contains only Unicode letters, numbers, underscores, and periods.</li>
     *   <li>If a set of existing usernames is provided, the username must not already exist in it.</li>
     * </ul>
     *
     * @param username the username string to validate
     * @param usernameData a set of existing usernames to check for uniqueness; may be {@code null} if uniqueness is not required
     * @return {@code true} if the username is valid and unique (if applicable), {@code false} otherwise
     **/
    public static boolean validateUsernameField(String username, HashSet<String> usernameData)
    {
        
        return username != null
            && !username.isEmpty()
            && username.length() >= 1
            && username.length() <= 20
            && username.matches("[\\p{L}\\p{M}\\p{N}._]+")
            && (usernameData == null || !usernameData.contains(username));
    }

    /**
     * Validates a password input.
     * <p>
     * This validation ensures that:
     * <ul>
     * <li> The password is not {@code null} or empty.</li>
     * <li> The password has a minimum length of 8 characters.</li>
     * <li> The password must include at least 1 uppercase letter, 1 lowercase letter, and 1 digit.</li>
     * <li> Can use special characters !, -, *, and .</li>
     * <iul>
     * 
     * @param password the password string to validate
     * @return {@code true} if the password is valid, {@code false} otherwise
     **/
    //Must not be empty. At least 8 characters long. At least one uppercase letter, one lowercase 
    //letter, and one digit. Can use the special characters !, -, *, and ..
    public static boolean validatePasswordField(String password) 
    {
        return password != null
            && password.length() >= 8
            && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d!*.\\-]{8,}$");
    }
    
    /**
     * Validates a phone number input.
     * <p>
     * This validation ensures that:
     * <ul>
     * <li> The phone number is not {@code null}.</li>
     * <li> The phone number must have exactly 10 digits.</li>
     * <li> The phone number can be empty.</li>
     * <li> Only dashes and spaces are allowed in specific positions.</li>
     * <iul>
     * 
     * @param phonenumber the phonenumber string to validate
     * @return {@code true} if the phonenumber is valid, {@code false} otherwise
     **/
    //Must contain 10 digits, may include dashes or spaces. Can be empty.
    public static boolean validatePhoneNumberField(String phonenumber) 
    {
        if (phonenumber == null || phonenumber.isEmpty()) return true; // empty allowed
        return phonenumber.replaceAll("[\\s\\-]", "").matches("^\\d{10}$");
    }
    
    /**
     * Validates a date of birth input.
     * <p>
     * This validation ensures that:
     * <ul>
     * <li> The date of birth is not {@code null} or empty.</li>
     * <li> The date of birth must be be in the format yyyy-MM-dd.</li>
     * <li> The date of birth must show that the user is at least 18 years old.</li>
     * <iul>
     * 
     * @param dateofbirth the dateofbirth string to validate
     * @return {@code true} if the dateofbirth is valid, {@code false} otherwise
     **/
    //Must be a valid date in the format yyyy-MM-dd, and user must be 18+ years old. Should not be empty.
    public static boolean validateDateOfBirthField(String dateofbirth) 
    {
        if (dateofbirth == null || dateofbirth.trim().isEmpty()) {
            return false;
        }
    
        try {
            LocalDate dob = LocalDate.parse(dateofbirth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate today = LocalDate.now();
    
            if (dob.isAfter(today)) return false;
    
            int age = Period.between(dob, today).getYears();
            return age >= 18;
    
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Validates a postal code input.
     * <p>
     * This validation ensures that:
     * <ul>
     * <li> The postal code is not {@code null}.</li>
     * <li> The postal code must have exactly 5 digits, or a length of 5 characters.</li>
     * <li> The postal code can be empty (if the postal code is not from the U.S.A.).</li>
     * <iul>
     * 
     * @param postalcode the postalcode string to validate
     * @return {@code true} if the postalcode is valid, {@code false} otherwise
     **/
    //Must be exactly 5 digits (only for the U.S.A.). Can be empty if the postal code is from another country.
    public static boolean validatePostalCodeField(String postalcode) 
    {
        if (postalcode == null || postalcode.isEmpty()) return true; // assume non-US is okay
        return postalcode.matches("^\\d{5}$");
    }

    /**
     * Validates the title input from user 
     * 
     * The validation ensures: 
     *     The title does not have a {@code null}, has a length longer than 0, and its length is not longer than 100 characters.
     * 
     * @param title is the title validated
     * @return {@code true} the title is within limits, {@code false} the title is not within limits.
     */

    //Checks if the tile is empty 
    public static boolean validateTitle(String title)
    {
        return title != null
            && !title.trim().isEmpty()
            && title.trim().length() < 100;
    }


    /**
     * Validates the description input from user 
     * 
     * The validation ensures: 
     *     The description does not have a {@code null}, has a length longer than 0, and its length is not longer than 100 characters.
     * 
     * @param description is the description validated
     * @return {@code true} the description is within limits, {@code false} the description is not within limits.
     */
    //Checks if description is empty 
    public static boolean validateDescription(String description)
    {
         //return description != null && !description.trim().isEmpty();
        return description != null &&
            !description.trim().isEmpty() &&
            description.trim().length() < 1000;
    }

    /**
     * Validates the image given to the system
     * 
     * The validation ensures: 
     *      The image has an extension of ".JPG" or ".PNG"
     *      Ensures the fileSeize is not more than 4MB
     * 
     * @param fileName the name of the file that is is checked for the extention. 
     * @param fileSize the size of the file given to they system. 
     * @return {@code true} the Image has the right extention and less than file size limit.
     *         {@code false} the Image has the wrong extention and/or has a file size over the limit.
     */
    //Checks if the image has the proper extension (".JPG" or ".PNG") and if the file size is less the 4 MB
    public static boolean validateImage(String fileName, double fileSize)
    {
        if (fileName == null || fileSize > 4) return false;
    
        return fileName.endsWith(".JPG") || fileName.endsWith(".PNG");
    }


    /**
     * Validates the dimentions of the work 
     * 
     * The validation ensures: 
     *      The dimensions given include a width, height, and unit. 
     * 
     * @param width the first number of the dimensions given 
     * @param height the second number of the dimensions given 
     * @param unit the unit of measure of the dimentions (i.e meter, inch, feelt, etc)
     * @return {@code true} the dimentions has a value in all fields.
     *         {@code false} the dimentions does not have all of the fields filled. 
     */
    //Checks if there is a valid dimention of the art (width, height) and there is a valid unit of measure of the art (meter, inch, feet, etc)
    public static boolean isValidDimensions(String width, String height, String unit)
    {
        if(width.isEmpty() || height.isEmpty() || unit.isEmpty()) return false; 
        return true; 
    }
 
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

//YYYY/MM/DD format, must be a valid date, must not be empty



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