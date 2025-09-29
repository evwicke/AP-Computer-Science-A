package src;


public class Project5 {
    public static void main(String[] args) {
        int totalCents = 99;
        int[] coinWorth = {25, 10, 5, 1};
        String[] coinName = {"Quarter", "Dime", "Nickel", "Penny"};
        int coinAmtBuffer;

        System.out.println("Your amount of change is: " + totalCents + " cents" + "\n" +
                "This is equivalent to:");

        for(int i = 0; i<=3; i++){
            coinAmtBuffer = 0; //resetting the buffer
            coinAmtBuffer = totalCents / coinWorth[i]; //calculating the amount of coins needed
            System.out.print((coinAmtBuffer>0) ?
                    (coinAmtBuffer + " " + coinName[i] +
                            ((coinAmtBuffer >1 || coinAmtBuffer==0) ? "s" + "\n": ""))
                    : "\b");
            //logic to see what to print out

            totalCents = totalCents % coinWorth[i]; //taking away the coins from the total
        }
    }
}