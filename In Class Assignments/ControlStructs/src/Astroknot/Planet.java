package src.Astroknot;


/**
 * Write a description of class Planet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Planet{
    private String name;
    private double diameter;
    private double mass;
    private double gravity;
    
    public Planet(String name,double diameter,double mass){
        this.name = name;
        this.diameter = diameter;
        this.mass = mass;
        gravity = (4 * 6.67 * Math.pow(10, -17) * mass)/(Math.pow(diameter,2));
    }
    
    public double getGravity(){
        return gravity;
    }
    
    public void gravityField(){
        gravity*=2;
    }
    
    public String toString(){
        return "  " + name + "\n  Mass: " + mass + " kilograms\n  Gravity: " + gravity;
    }
}
