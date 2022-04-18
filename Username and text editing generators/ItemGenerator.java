/**
 * NCIRL.
 * Module = Software development
 * CA2.
 * Class for creating username from employee's name, 
 * and counting consonants in a paragraph.
 * author: Daniel Gonzalez.
 * student number: 21111383.
 */

// This file contains the following:

// Instanciable class ItenGenerator:
// QUESTION A: Generates a username from a given name
// QUESTION B: Counts the number of consonants in a given paragraph.

// Constuctor

// setter for name
// getter for name and username

// QUESTION A:
// The processing has been divided in four methods:
// firstCharacter(): calculates the first character of username
// calculateItem(): calculates the body of the username
// substituteSpace(): returns the length to substitute space characters.
// upperToLower(): calculates the last character of the username
// calculateUsername(): invokes all previous methods to generate the full
// username

// QUESTION B:
// Processing:
//  consonantsCount() returns int number of consonants in the given string.


public class ItemGenerator {

    // declare instanciable classes / data members:

    private String name;
    private String username;
    private char[] upper = { 'A', 'E', 'I', 'O', 'U' };
    private char[] lower = { 'a', 'e', 'i', 'o', 'u' };
    private char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v',
            'w', 'x', 'y', 'z' };

    private int numberOfConsonants;

    // Constructor.
    // Initialised with empty string to prevent runtime error
    public ItemGenerator() {

        name = "";
    }

    // Setter:
    public void setName(String aName) {
        name = aName;
    }

    // getter:
    public String getUsername() {
        return username;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public String getName() {
        return name;
    }

    // PART 1:

    // Processing:

    // Method to calculate the first character of
    // the username (second to last character of the name).

    public char firstCharacter() {

        int length = name.length();
        char firstChar = (char) name.charAt(length - 2);

        return firstChar;
    }

    // method to calculate the body of the username (except the last character)
    // If the character is upper will return the lower case version,
    // else will return the same character

    private char calculateItem(char letter) {

        // Indexing array upper:
        for (int i = 0; i < upper.length; i++) {
            char currentLetter = upper[i];

            // Substitute the position in upper
            // for the character in the same position in string lower
            if (currentLetter == letter) {
                letter = lower[i];
            }
        }
        return letter;
    }

    // Method to calculate the length of the given name to
    // substitute a space character.

    public int substituteSpace() {

        int length = name.length();
        return length;
    }

    // Method to calculate the last character of the username

    public int upperToLower() {
        int upperToLower = 0;

        // Indexing and traversing the given name:
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            // Indexing and traversing the array upper:
            for (int y = 0; y < upper.length; y++) {
                char upperTo = upper[y];

                // substitution of upper to lower:
                if (c == upperTo) {
                    upperToLower++;
                }

            }

        }

        return upperToLower;
    }

    // ------------------------------------- //

    // Method to calculate the full username:

    public String calculateUsername() {

        // declare buffer to traverse the given name:
        StringBuffer buffer = new StringBuffer();

        // Local variables:
        char usernameChar; // to append to buffer.
        char afterSpace = '-'; // to add after length when char is space.

        // First character of username::
        buffer.append(firstCharacter());

        // Body of the username:

        // traverse the given name:
        for (int i = 0; i < name.length(); i++) {

            char c = name.charAt(i);

            // if char is not empty space:
            if (c != ' ') {
                // invoke calculateItem:
                usernameChar = calculateItem(c);
                buffer.append(usernameChar);

                // If char is empty space:
            } else {
                buffer.append(substituteSpace());
                buffer.append(afterSpace);
            }

        }

        // final character of username:
        buffer.append(upperToLower());

        // Converting back to string:
        username = buffer.toString();

        return username;

    }

    // ------------------------------------- //
    // PART 2
    // ------------------------------------- //

    public int consonantsCount() {
        int numberOfConsonants = 0;

        // Indexing and traversing the given paragraph:
        for (int i = 0; i < name.length(); i++) {
            char c = Character.toLowerCase(name.charAt(i));

            // Indexing and traversing the array consonants:
            for (int y = 0; y < consonants.length; y++) {
                char currentConsonant = consonants[y];

                // updating count
                if (c == currentConsonant) {
                    numberOfConsonants++;
                }

            }

        }

        return numberOfConsonants;

    }
}