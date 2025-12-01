package ControlStructs.src.Doggie;

public class Doggie {
    private String name;
    private String breed;
    private String color;
    private double weight;

    public Doggie() {
        this.name = "Spot";
        this.breed = "Mutt";
        this.color = "Brown";
        this.weight = 20.0;
    }

    public Doggie(String name, String breed, String color, double weight) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void run() {
        weight = Math.max(5.0, weight - 0.5);
    }

    public void eat() {
        weight += 0.5;
    }

    public void runAway() {
        name = "Stray";
    }

    public void mutate(String breed) {
        this.breed = breed;
    }

    public void paintDog(String newColor) {
        color = newColor;
    }

    public void superSizedMeal() {
        weight *= 1.5;
    }

    public String toString() {
        return "Name: " + name + ", Breed: " + breed + ", Color: " + color + ", Weight: " + weight;
    }
}
