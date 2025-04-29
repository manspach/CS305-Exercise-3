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
        // check if the name is in the language of strings that only contains letters (of all languages) and spaces only
        // \p{L} is characters of any language, the space after is allowing spaces in the string, all closed in [] with + ensures there's at least one character (because the string can't be empty)
        return name != null && !name.isEmpty() && name.length() >= 2 && name.matches("[\\p{L} ]+");
    }

}