/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */

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

    public static boolean validateLastNameField(String lastName)
    {
        // check if lastName is not null and not empty
        return lastName != null && !lastName.isEmpty();
    }

}