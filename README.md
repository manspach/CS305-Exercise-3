Team Members: 
Collin , Maddie, Harry, Junior 

Class Description:
The InputValidator class is a comprehensive Java utility designed to validate common input fields typically used in user-facing forms (e.g., signup, profile forms, or submission forms). Each method performs rigorous checks to ensure the input meets specific formatting, content, and contextual requirements. These include: 
- Name & Last Name: Checks for non-null input, proper length, and character constraints (Unicode letters, diacritics, spacing, hyphens, apostrophes). 
- Email: Ensures standard format with one @ symbol and at least one domain suffix. 
- Username: Validates character types, length constraints, and optionally enforces uniqueness. 
- Password: Requires ≥8 characters, a mix of upper/lowercase letters, digits, and only certain special characters (!, -, *, .). 
- Phone Number: Accepts 10-digit numbers with optional spaces or dashes, or an empty string. 
- Date of Birth: Requires format yyyy-MM-dd and confirms user is ≥18 years old. 
- Postal Code: Accepts exactly 5-digit U.S. codes or empty values for non-U.S. addresses. 
- Title, Description, Image, Dimensions, Currency, Medium, and Creation Date: Each field has purpose-specific constraints based on type, length, allowed formats, and expected business rules.

How to Use:
To validate any field, simply call the corresponding static method from InputValidator.

Refletion: While working on this project we had a lot more problems than we expected. Most of the problems came from issues with machinery, git merging conflicts, and .... While working through the project 

