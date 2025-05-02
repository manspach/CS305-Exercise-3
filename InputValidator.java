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
            && name.matches("^[\\p{L}\\p{M}]+( [\\p{L}\\p{M}]+)?$");
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
            && lastName.matches("^[\\p{L}\\p{M}]+([ '\\-]?[\\p{L}\\p{M}]+)*$");
    }


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
        return email != null
            && !email.isEmpty()
            && email.matches("^[^\\s@]+@[^\\s@]+(\\.[^\\s@]+)+$");
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
     * @param title is the description validated
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

}