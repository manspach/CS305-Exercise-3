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
        // \\p{L}+ : starts with one or more letters
        // ( \\p{L}+)? : optionally followed by one space and more letters
        return name != null
            && name.length() >= 2
            && name.matches("\\p{L}+( \\p{L}+)?");
    }

    public static boolean validateLastNameField(String lastName)
    {
        // regex explanation:
        // [ʻ]? : optionally begin with one 'okina
        // [\\p{L}]+ : followed by at least one letter (could be beginning of string)
        // [ ʻ'\\-]? : optionally followed by one space, one 'okina, one apostrophe, or one hypen
        // [\\p{L}]+ : must be followed by at least one letter
        // ([ ʻ'\\-]?[\\p{L}]+)* : entire second statement happening zero or more times
        return lastName != null
            && lastName.length() >= 2
            && lastName.matches("[ʻ]?[\\p{L}]+([ ʻ'\\-]?[\\p{L}]+)*");
    }

}