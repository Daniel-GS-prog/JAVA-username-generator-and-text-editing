
/**
 * NCIRL.
 * Module = Software development
 * CA2.
 * Application to use the instanciable class ItemGEnerator.
 * author: Daniel Gonzalez.
 * student number: 21111383.
 */

/**
 This file contains the following:
   Main method to generate an array of employees and their
       corresponding username by instantiating the class ItemGenerator. 
   
   Local variables for String arrays populating

   output:
   Each name and the corresonding username.
*/
import java.util.Arrays;
import java.util.Scanner;

public class ItemGeneratorApp {

    public static void main(String[] args) {

        // Declare local variables:
        Scanner input = new Scanner(System.in);
        String[] employees;
        String[] usernames;
        int numberOfEmployees;
        String[] paragraphs;
        int[] consonantsPresent;
        int numberOfParagraphs;

        ItemGeneratorMenu m = new ItemGeneratorMenu();

        ItemGenerator generator = new ItemGenerator();

        // Processing:

        m.displayMenu();

        while (true) {

            int choice = 0;

            System.out.println("Choice: ");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Choice must be an integer between 1 & 2");
                System.out.println("Good bye.");
                break;
            }

            // Valid choice input:
            if (choice >= 1 && choice <= 2) {

                // ----------------------------- //
                // PART 1
                // ----------------------------- //

                // Choice 1 = generate username:
                if (choice == 1) {

                    // Prompt user to give a numbre of employeees to generate usernames for:
                    System.out.println("For how many employees would you like to generate usernames: ");
                    numberOfEmployees = input.nextInt();
                    input.nextLine();

                    // Arrays initialized;
                    employees = new String[numberOfEmployees];
                    usernames = new String[numberOfEmployees];

                    // populate employee array with user input:
                    for (int i = 0; i < employees.length; i++) {
                        int currentEmployee = i + 1;

                        // prompt user for a name:
                        System.out.println("Enter the name for employee number: " + currentEmployee);
                        String name = input.nextLine();
                        employees[i] = name;

                    }
                    // populate the usernames array with values in employees array:
                    for (int i = 0; i < employees.length; i++) {
                        generator.setName(employees[i]);
                        usernames[i] = generator.calculateUsername();
                    }
                    System.out.println("");

                    // Output:
                    // Prints each employee name and the corresponding username:
                    for (int i = 0; i < employees.length; i++) {
                        System.out.println("Name: " + employees[i] + " || " + "Username: " + usernames[i]);
                    }

                    m.displayMenu();


                // ----------------------------- //
                // PART 2
                // ----------------------------- //

                } else if (choice == 2) {
                    // Prompt user for a number of paragraphs:
                    System.out.println("How many paragraphs would you like to enter: ");
                    numberOfParagraphs = input.nextInt();
                    input.nextLine();

                    // Array initialized;
                    paragraphs = new String[numberOfParagraphs];
                    consonantsPresent = new int[numberOfParagraphs];

                    // populate array array with user input:
                    for (int i = 0; i < paragraphs.length; i++) {
                        int currentParagraph = i + 1;

                        // prompt user for a paragraph:
                        System.out.println("Enter the paragraph " + currentParagraph);
                        String parrag = input.nextLine();
                        paragraphs[i] = parrag;
                    }

                    for (int i = 0; i < paragraphs.length; i++) {
                        generator.setName(paragraphs[i]);
                        consonantsPresent[i] = generator.consonantsCount();
                    }
                    System.out.println("");

                    // Output:
                    // Prints the index of each paragraph and the corresponding number of
                    // consonants:
                    for (int i = 0; i < paragraphs.length; i++) {
                        int currentParagraph = i + 1;
                        System.out.println("Paragraph " + currentParagraph + ", contains " + consonantsPresent[i]
                                + " consonants.");
                    }

                    // Prints the array of consonants: 
                    System.out.print(Arrays.toString(consonantsPresent));
                    
                    

                    m.displayMenu();

                }
            }
        }
    }
}