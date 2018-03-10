import java.util.Random;

/**
 * Created by Admin on 3/9/2018.
 */
public class Contract {
    private Bid bid;
    private Player player;

    public void setContractTurns ()
    {
        // choosing a random iterations number of bidding between players.
        Random random = new Random();
        int n = 1 + random.nextInt(3); //All values for "n" are chosen arbitrarily
        System.out.println ("random numer " + n);
    }

    // Method for picking a bid from "Bid" enum
    private Bid randomBid() {
        Bid[] bid = Bid.values();
        Random random = new Random();
        return bid[random.nextInt(bid.length)];
    }

    private void Bidding ()
    {

    }



}
