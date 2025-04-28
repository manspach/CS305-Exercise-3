/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */

public class InputValidator 
{
    public static boolean validateNameField(String name)
    {
        // check if name is not empty/null
        // check if name is longer than 2 characters
        return name != null && !name.isEmpty() && name.length() >= 2;
    }

}