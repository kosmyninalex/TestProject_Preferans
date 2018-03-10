import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Admin on 3/9/2018.
 */
public class Contract {
    private Bid bid;
    private ArrayList<PlayersBids> playersBids;

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

    public void biddingOrder (ArrayList<Player> players)
    {
        ArrayList<Player> biddingOrder = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Player player = players.get(j);

                if (player.getPlace().ordinal() == i)
                {
                    biddingOrder.add(player);
                }
            }
        }
        System.out.println ("Bidding order " + biddingOrder);
    }



}
