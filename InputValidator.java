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
        // ^ : start
        // \\p{L}+ : starts with one or more letters
        // ( \\p{L}+)? : optionally followed by one space and more letters
        // $ : stop
        return name != null
            && name.length() >= 2
            && name.matches("^[\\p{L}]+( [\\p{L}]+)?$");
    }

    public static boolean validateLastNameField(String lastName)
    {
        // regex explanation:
        // ^ : start
        // [\\p{L}]+ : at least one letter
        // [ '\\-]? : optionally followed by one space, one apostrophe, or one hypen
        // [\\p{L}]+ : must be followed by at least one letter
        // ([ '\\-]?[\\p{L}]+)* : entire second statement happening zero or more times
        return lastName != null
            && lastName.length() >= 2
            && lastName.matches("^[\\p{L}]+([ '\\-]?[\\p{L}]+)*$");
    }


    public static boolean validateTitle(String title)
    {
        if (title == null || title.trim().isEmpty())
            return false;
    }
    public static boolean validateTitleLength(int titleLength)
    {
        return titleLength >= 0 && titleLength < 100;
    }
    public static boolean validateDescription(String description)
    {
        if (description == null || description.trim().isEmpty())
            return false;
    }
    public static boolean validateDescriptionLength(int descriptionLength)
    {
        return descriptionLength >= 0 && descriptionLength < 1000;
    }
    public static boolean validateImage(String fileName, long fileSize)
    {

    }
    public static boolean isValidDimensions(String dimensions){}
}