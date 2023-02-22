
import java.util.Scanner;

/**
* Calculates how long a food item should be microwaved.
*
* @author  Keiden B
* @version 1.0
* @since   2023-02-21
*/

public final class Microwave {
    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function
    */
    public static void main(String[] args) {
        final Scanner GET_IN = new Scanner(System.in);
        double time = 0;
        double modifier = 0.0;
        // correctFood used later to make sure nothing is outputted
        // if the user inputs an invalid food item.
        boolean correctFood = true;

        System.out.println("Hi! This is a guide for how long"
            + " a piece(s) of food should be microwaved.\n"
            + "What food are you microwaving? (Pizza, Sub, Soup)");
        // Put the .toUpperCase() modifier here so it doesn't need to
        // be retyped for every if statement later.
        final String FOOD_ITEM = GET_IN.nextLine().toUpperCase();
        System.out.println("And how much of that are you microwaving?");
        final String QUAN_STR = GET_IN.nextLine();

        try {
            final double QUAN_DOU = Double.parseDouble(QUAN_STR);

            // Makes sure the program only continues if the quantity of
            // food put in the microwave is between 4 and 0.
            if (QUAN_DOU > 4) {
                // Message that is sent if more than 4 pieces are
                // put into the microwave
                System.out.printf("The microwave is too small for %.0f"
                    + " pieces!\n", QUAN_DOU);
            } else if (QUAN_DOU > 0) {
                // Decides how much the time needs to be increased or
                // Decreased depending on the amount.
                modifier = (QUAN_DOU - 1) / 2 + 1;

                if ("PIZZA".equals(FOOD_ITEM)) {
                    time = 45;
                } else if ("SUB".equals(FOOD_ITEM)) {
                    time = 60;
                } else if ("SOUP".equals(FOOD_ITEM)) {
                    time = 105;
                } else {
                    System.out.println("Our scientists have not discovered"
                            + " the time it takes to cook that item.");
                    // To make sure the next if statement does not run
                    // if a food not on the list was inputted.
                    correctFood = false;
                }

                if (correctFood) {
                    final double TOTAL_TIME = modifier * time;
                    System.out.printf("You should microwave these for %.0fm,"
                        + " %.0fs.\n", TOTAL_TIME / 60, TOTAL_TIME % 60);
                }
            } else {
                // Message that is sent if less than 4 pieces
                // are put into the microwave.
                System.out.printf("You can't put %.0f pieces of"
                    + " food in a microwave.\n", QUAN_DOU);
            }
        } catch (NumberFormatException error) {
            System.out.println("That's not an amount of food. "
                + error.getMessage());
        }
        GET_IN.close();
    }
}
