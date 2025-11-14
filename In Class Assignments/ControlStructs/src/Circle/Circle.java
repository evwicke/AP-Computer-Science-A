package src.Circle;


/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Circle{
    
    private double radius;
    private String name;
    
    public void setRadius(double r){
        radius = r;
    }
    
    private double rounding(double value, int places){
        return ((int)((value * Math.pow(10, places))+0.5)) / Math.pow(10, places);
    }
    
    //every class has a toString() method that is inherited by its parent, cosmic superclass.
    
    public String toString(){
        return " Name: " + name + "\n" + " Radius: " + radius + "\n" + 
                " Diameter: " + findDiameter() + "\n" +
                " Circumference: " + rounding(findCircumference(),4) + "\n" + 
                " Area: " + rounding(findArea(), 2);
        
        
    }
    
}
