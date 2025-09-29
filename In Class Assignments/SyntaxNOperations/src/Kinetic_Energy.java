package src;

/**
 * Write a class in your BlueJ project called SyntaxNOperations that accepts an object’s mass (in kilograms) and velocity (in meters per second) as inputs and prints its momentum
 * Evan Wicke
 * 9/25/2025
 * Kinetic Energy Project modified version of Momentum Project
 */

import java.util.Scanner;

public class Kinetic_Energy
{
    public static void main(String[] args){
        Scanner Scan = new Scanner(System.in); //make scanner object
        
        // First we ask the user for the velocity of the object (in m/s) and for the mass of the object in kilograms.
        System.out.println("Input velocity of object");
        double velocity = Scan.nextDouble(); // store velocity in double
        System.out.println("Input mass of object");
        double mass = Scan.nextDouble(); // store mass in double
        
        double kineticEnergy = (.5)*(mass)*(Math.pow(velocity,2)); // solve for kinetic energy and store it.
       
        double momentum = ((int)(((velocity*mass)*1000.0)+0.5))/1000.0; // round to thousands place
        System.out.printf("The momentum is %.2f kg per m/s, and the kinetic energy is %.2f joules.", momentum, kineticEnergy); // print out momentum and kinetic energy
        
    }
}