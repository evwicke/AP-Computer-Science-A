package ControlStructs.src.Doggie;

public class DoggieClient {
    public static void main(String[] args) {
        Doggie dog1 = new Doggie("Max", "Golden Retriever", "Golden", 65.5);
        Doggie dog2 = new Doggie();
        Doggie dog3 = new Doggie("Luna", "Husky", "Gray", 45.0);

        // setters
        dog2.setName("Bella");
        dog2.setBreed("Labrador");
        dog2.setColor("Black");
        dog2.setWeight(55.0);

        // toString
        System.out.println("Dog 1: " + dog1);
        System.out.println("Dog 2: " + dog2);
        System.out.println("Dog 3: " + dog3);

        // getters
        System.out.println("Name: " + dog1.getName());
        System.out.println("Breed: " + dog1.getBreed());
        System.out.println("Color: " + dog1.getColor());
        System.out.println("Weight: " + dog1.getWeight());

        // other methods
        System.out.println("\nrun() method:");
        System.out.println("Before run - Weight: " + dog1.getWeight());
        dog1.run();
        System.out.println("After run - Weight: " + dog1.getWeight());

        System.out.println("\neat() method:");
        System.out.println("Before eating - Weight: " + dog1.getWeight());
        dog1.eat();
        System.out.println("After eating - Weight: " + dog1.getWeight());

        System.out.println("\nrunAway() method:");
        System.out.println("Before running away - Name: " + dog1.getName());
        dog1.runAway();
        System.out.println("After running away - Name: " + dog1.getName());

        System.out.println("\nmutate() method:");
        System.out.println("Before mutation - Breed: " + dog1.getBreed());
        dog1.mutate("Husky");
        System.out.println("After mutation - Breed: " + dog1.getBreed());

        System.out.println("\npaintDog() method:");
        System.out.println("Before painting - Color: " + dog1.getColor());
        dog1.paintDog("Rainbow");
        System.out.println("After painting - Color: " + dog1.getColor());

        System.out.println("\nsuperSizedMeal() method:");
        System.out.println("Before super sized meal - Weight: " + dog1.getWeight());
        dog1.superSizedMeal();
        System.out.println("After super sized meal - Weight: " + dog1.getWeight());

    }
}
