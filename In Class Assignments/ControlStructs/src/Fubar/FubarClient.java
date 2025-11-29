package src.Fubar;

public class FubarClient {
    public static void main(String[] args) {
        Fubar f1 = new src.Fubar.Fubar();
        Fubar f2 = new Fubar(50);

        System.out.println("\n     Testing abs() Methods     ");
        // single parameter abs
        System.out.println("abs(-15.5): " + f1.abs(-15.5));

        // overloaded abs
        System.out.println("abs(-20.0, 5.0): " + f1.abs(-20.0, 5.0));
        System.out.println("abs(8.0, 12.0): " + f1.abs(8.0, 12.0));


        System.out.println("\n     Testing same() Methods     ");
        // same(String, String)
        System.out.println("same(apple, apple): " + f1.same("apple", "apple"));
        System.out.println("same(apple, orange): " + f1.same("apple", "orange"));

        // same(String) - checks if word is "bird"
        System.out.println("same(bird): " + f1.same("bird"));
        System.out.println("same(plane): " + f1.same("plane"));


        System.out.println("\n     Testing other Methods     ");
        // convertToDecimal
        System.out.println("convertToDecimal(00001111): " + f1.convertToDecimal("00001111")); // Should be 15
        System.out.println("convertToDecimal(10011101): " + f1.convertToDecimal("10011101")); // Should be 157

        // nextToLast
        System.out.println("nextToLast(Computer): " + f1.nextToLast("Computer"));

        // displayStuff
        System.out.print("displayStuff(3, Echo): ");
        f1.displayStuff(3, "Echo");
        System.out.println();

        // ageDiv
        System.out.println("f1 ageDiv() [42 % 5 == 0?]: " + f1.ageDiv());
        System.out.println("f2 ageDiv() [50 % 5 == 0?]: " + f2.ageDiv());

        // findIndex
        System.out.println("findIndex(Hello, 'o'): " + f1.findIndex("Hello", 'o'));
        System.out.println("findIndex(Hello, 'z'): " + f1.findIndex("Hello", 'z'));

        // Primes
        System.out.println("isItPrime(7): " + f1.isItPrime(7));
        System.out.println("isItPrime(12): " + f1.isItPrime(12));
        System.out.println("getPrimez(1, 20): " + f1.getPrimez(1, 20));

        // sumOfDigits
        System.out.println("sumOfDigits(345): " + f1.sumOfDigits(345));


        System.out.println("\n     Testing Interactive Methods     ");

        System.out.println("   GetName()   ");
        System.out.println("Result: " + f1.getName());

        System.out.println("\n   LetterGame()  ");
        f1.letterGame();
    }
}