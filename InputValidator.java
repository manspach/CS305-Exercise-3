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
}