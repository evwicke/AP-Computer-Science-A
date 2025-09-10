
public class Project5 {
    public static void main(String[] args) {
        int totalCents = 165;
        int[] coinWorth = {25, 10, 5, 1};
        String[] coinName = {"Quarter", "Dime", "Nickel", "Penny"};
        int coinAmtBuffer;

        for(int i = 0; i<=3; i++){
            coinAmtBuffer = 0;

            coinAmtBuffer = totalCents / coinWorth[i];
            System.out.println(coinAmtBuffer + " " + coinName[i] +
                    ((coinAmtBuffer >1 || coinAmtBuffer==0) ? "s" : ""));

            totalCents = totalCents % coinWorth[i];
        }
    }
}