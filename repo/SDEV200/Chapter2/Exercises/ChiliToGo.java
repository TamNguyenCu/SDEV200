// Filename ChiliToGo.java
// Written by Tam Nguyen Cu
// Written on August 27 2024
package Chapter2.Exercises;

import java.util.Scanner;

public class ChiliToGo {
/* This class allow the user to enter the number of each type of meal ordered 
then calculate total money collected for adults’ meals, children’s meals and all meals*/
    public static void main(String[] args) {
        final double ADULT_MEAL_PRICE = 7.00;
        final double CHILDREN_MEAL_PRICE = 4.00;

        Scanner InputValue = new Scanner(System.in);
        int AdultMeals;
        int ChildrenMeals;

        // Prompt
        System.out.println("""
                           Welcome to the Huntington Boys and Girls Club fundraising.
                           Please enter the number for each type of meal that you want to order.""");

        // Get the number of each type of meal
        System.out.println("For the Adult Meal:");
        AdultMeals = InputValue.nextInt();

        System.out.println("For the Child Meal:");
        ChildrenMeals = InputValue.nextInt();

        // Calculate total money collected for adults’ meals, children’s meals and all meals
        double TotalAdultMeals = ADULT_MEAL_PRICE * AdultMeals;
        double TotalChildrenMeals = CHILDREN_MEAL_PRICE * ChildrenMeals;
        double Total = TotalAdultMeals + TotalChildrenMeals;

        // Print result
        System.out.println("Thank you for your order.");
        System.out.println("You Ordered:");
        System.out.println(AdultMeals + " Adult Meals: $" + TotalAdultMeals);
        System.out.println(ChildrenMeals + " Child Meals: $" + TotalChildrenMeals);
        System.out.println("Total Cost: $" + Total);

    }
}
