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
    
    public void jump(){
        jumpHeight = round(  Math.pow((fitnessLevel - Math.sqrt(weight)),2)       /  (2*currentPlanet.getGravity())         , 3); // (v^2 / 2g)
    }
    
    public Astronaut(String name, int weight, int fitnessLevel, Planet currentPlanet){
        this.name = name;
        this.weight = weight;
        this.fitnessLevel = fitnessLevel;
        this.currentPlanet = currentPlanet;
    }
    
    public double getJumpHeight(){
        return jumpHeight;
    }
    
    public void eat(){
        weight += (int)(Math.random()*12) +4;
    }
    public void rest(){
        fitnessLevel += 1;
        weight += 1;
    }
    public void exercise(int hours){
        fitnessLevel += (int)(Math.sqrt(hours));
        weight -= (int)(Math.sqrt(hours));
    }
    public void travel(Planet newPlanet){
        currentPlanet = newPlanet;
    }
    // make 2 other methods and a changePlanet method
    
    public String toString(){
        jump();
        return "Name: " + name + "\nFitness ( average = 10 ): " + fitnessLevel + "\nWeight: " + weight + " kilos \nCurrent Planet: \n"
         + currentPlanet + "\nJump Height: " + jumpHeight + " m";   
    }
    
    private double round(double value, int places){ // rounds double to a certain place value
        return (int)(value * Math.pow(10, places) + 0.5)/Math.pow(10,places);
    }
}
