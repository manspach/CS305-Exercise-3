/*
 * This is the InputValidator class. Please complete this class with
 * appropriate JavaDoc comments, method and code comments, and the appropriate
 * methods to validate inputs from the user.
 */

 import java.util.HashSet;

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

     public static boolean validateUsernameField(String username, HashSet usernameData)
    {
        
        return username != null
            && !username.isEmpty()
            && username.length() >= 1
            && username.length() <= 20
            && username.matches("[\\p{L}\\p{M}\\p{N}._]+")
            && (usernameData == null || !usernameData.contains(username));
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