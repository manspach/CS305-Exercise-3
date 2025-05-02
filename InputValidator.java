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
 * @authour with assistance from Dr. Vargas-Perez
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
    public static boolean validatePasswordField(String password) {
        return password != null
            && password.length() >= 8
            && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d!*.\\-]{8,}$");
    }    
    
    public static boolean validatePhoneNumberField(String phonenumber) {
        if (phonenumber == null || phonenumber.isEmpty()) return true; // empty allowed
        return phonenumber.replaceAll("[\\s\\-]", "").matches("^\\d{10}$");
    }
    
    public static boolean validateDateOfBirthField(String dateofbirth) {
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

    public static boolean validatePostalCodeField(String postalcode) {
        if (postalcode == null || postalcode.isEmpty()) return true; // assume non-US is okay
        return postalcode.matches("^\\d{5}$");
    }    

 
     //Checks if the tile is empty 
     public static boolean validateTitle(String title)
     {
           return title != null 
           && !title.trim().isEmpty()
           && title.trim().length() < 100;
     }
 
     //Checks if description is empty 
     public static boolean validateDescription(String description)
     {
         //return description != null && !description.trim().isEmpty();
         return description != null &&
            !description.trim().isEmpty() &&
            description.trim().length() < 1000;
     }
 
     //Checks if the image has the proper extension (".JPG" or ".PNG") and if the file size is less the 4 MB
     public static boolean validateImage(String fileName, double fileSize)
     {
         if (fileName == null || fileSize > 4) return false;
         
         return fileName.endsWith(".JPG") || fileName.endsWith(".PNG");
     }
 
     //Checks if there is a valid dimention of the art (width, height) and there is a valid unit of measure of the art (meter, inch, feet, etc)
     public static boolean isValidDimensions(String width, String height, String unit)
     {
         if(width.isEmpty() || height.isEmpty() || unit.isEmpty()) return false; 
         return true; 
     }
 
    public static boolean validateCurrencyField(String currency)
    {
        return false;
    }
} 