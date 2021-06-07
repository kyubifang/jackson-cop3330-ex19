/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Jamar Jackson
 */

package base;

import java.util.Scanner;

/*
Exercise 19 - BMI Calculator

You’ll often need to see if one value is within a certain range and alter the flow of a program as a result.

Create a program to calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds. The program should prompt the user for weight and height.

Calculate the BMI by using the following formula:

bmi = (weight / (height × height)) * 703

If the BMI is between 18.5 and 25, display that the person is at a normal weight. If they are out of that range, tell them if they are underweight or overweight and tell them to consult their doctor.
Example Output

Your BMI is 19.5.
You are within the ideal weight range.

or

Your BMI is 32.5.
You are overweight. You should see your doctor.

Constraint

    Ensure your program takes only numeric data. Don’t let the user continue unless the data is valid.

Challenges

    Make the user interface accept height and weight in Imperial or metric units. You’ll need a slightly different formula for metric units.
    For Imperial measurements, prompt for feet and inches and convert feet to inches so the user doesn’t have to.
    Use a GUI interface with sliders for height and weight. Update the user interface on the fly. Use colors as well as text to indicate health.

 */
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        try {
            double lbs = myApp.weight();
            double tall = myApp.height();
            double calculate = myApp.checkBMI(lbs, tall);
            String BMI = myApp.healthyOrNot(calculate);
            String outputString = myApp.generateOutputString(BMI);
            myApp.printOutput(outputString);
        }catch (NumberFormatException exception) {
            System.out.println("Please enter only a numeric value.");
        }
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public double weight() {
        System.out.println("How much do you weigh, in pounds? ");
        return in.nextDouble();
    }

    public double height() {
        System.out.println("How tall are you, in inches? ");
        return in.nextDouble();
    }

    public double checkBMI(double lbs, double tall) {
        double a = tall * tall;
        double b = lbs / a;
        double c = b * 703;
        c = Math.round(c);
        System.out.println("Your BMI is " + c + ".");
        return c;
    }

    public String healthyOrNot(double calculate) {
        String weightClass;
        if(calculate < 18.5){
            weightClass = "underweight";
        }else if(calculate >= 18.5 && calculate <= 25){
            weightClass = "healthy";
        }else{
            weightClass = "overweight";
        }
        return weightClass;
    }

    public String generateOutputString(String BMI) {
        if(BMI.equals("Healthy")) {
            return "You are within the ideal weight range.";
        }else{
            return "You are " + BMI + ". You should see your doctor.";
        }
    }
}
