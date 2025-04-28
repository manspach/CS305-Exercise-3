/*
 * This is the InputValidator class. Please complete this class with
 * appropiate JavaDoc comments, method and code comments, and the appropiate
 * methods to validate inputs from the user. 
 */

public class InputValidator 
{
    
    public static boolean validateNameField(String name)
    {
        // check if name is not empty
        return name != null && !name.isEmpty();
    }

}