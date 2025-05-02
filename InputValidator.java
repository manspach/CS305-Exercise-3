/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValidator 
{
    public static boolean validateNameField(String name)
    {
        // regex explanation:
        // ^\\p{L}+ : starts with one or more letters
        // ( \\p{L}+)? : optionally followed by one space and more letters
        // $ : end of string
        return name != null
            && name.length() >= 2
            && name.matches("^\\p{L}+( \\p{L}+)?$");
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
}