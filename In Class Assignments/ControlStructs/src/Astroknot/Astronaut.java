package src.Astroknot;


/**
 * Write a description of class Astronaut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Astronaut{
    private String name;
    private int weight;
    private int fitnessLevel;
    private Planet currentPlanet;
    private double jumpHeight;
    
    public Astronaut(String name, int weight, int fitnessLevel, Planet currentPlanet){
        this.name = name;
        this.weight = weight;
        this.fitnessLevel = fitnessLevel;
        this.currentPlanet = currentPlanet;
        jumpHeight = (0.1 * Math.pow(fitnessLevel,2))  /  (2*currentPlanet.getGravity()); // (v^2 / 2g)
    }
    
    public double getJumpHeight(){
        return jumpHeight;
    }
    
    // make 2 other methods and a changePlanet method
    
    public String toString(){
        return "Name: " + name + "\nFitness ( average = 10 ): " + fitnessLevel + "\nWeight: " + weight + " kilos \nCurrent Planet: \n"
         + currentPlanet + "\nJump Height: " + jumpHeight + " cm";   
    }
}
