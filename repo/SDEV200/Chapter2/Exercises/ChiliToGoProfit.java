// Filename ChiliToGo.java
// Written by Tam Nguyen Cu
// Written on August 27 2024
package Chapter2.Exercises;

import java.util.Scanner;

public class ChiliToGoProfit {

    /* This class allow the user to enter the number of each type of meal ordered 
then calculate total profit for each type of meal as well as the grand total profit*/
    public static void main(String[] args) {
        final double ADULT_MEAL_PRICE = 7.00;
        final double CHILDREN_MEAL_PRICE = 4.00;
        final double ADULT_MEAL_COST = 4.35;
        final double CHILDREN_MEAL_COST = 3.10;

        Scanner InputValue = new Scanner(System.in);
        int AdultMeals;
        int ChildrenMeals;

        // Prompt
        System.out.println("Enter the number for each type of meal that you have sold.");

        // Get the number of each type of meal
        System.out.println("For the Adult Meal:");
        AdultMeals = InputValue.nextInt();

        System.out.println("For the Child Meal:");
        ChildrenMeals = InputValue.nextInt();

        // Calculate total profit for each type of meal as well as the grand total profit
        double TotalAdultMeals = ADULT_MEAL_PRICE * AdultMeals;
        double TotalChildrenMeals = CHILDREN_MEAL_PRICE * ChildrenMeals;

        double AdultMealsProfit = TotalAdultMeals - (ADULT_MEAL_COST * AdultMeals);
        double ChildrenMealsProfit = TotalChildrenMeals - (CHILDREN_MEAL_COST * ChildrenMeals);
        double TotalProfit = AdultMealsProfit + ChildrenMealsProfit;

        // Print result
        System.out.println("Profit Report.");
        System.out.println(AdultMeals + " Adult Meals: $" + String.format("%.2f", AdultMealsProfit));
        System.out.println(ChildrenMeals + " Child Meals: $" + String.format("%.2f", ChildrenMealsProfit));
        System.out.println("Total Profit: $" + String.format("%.2f", TotalProfit));

    }
}
