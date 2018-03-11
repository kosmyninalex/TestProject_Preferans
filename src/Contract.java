import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Contract {
    private Bid winningBid;
    private Player winningBidder;
    private ArrayList<PlayersBids> playersBidsList;
    private int contractTurns;
    ArrayList<Player> biddingOrder;

    private void setContractTurns ()
    {
        // choosing a random iterations number of bidding between players.
        Random random = new Random();
        contractTurns = 1 + random.nextInt(3); //All values for "n" are chosen arbitrarily
    }

    // Method for picking a bid from "Bid" enum
    private Bid randomBid() {
        Bid[] bid = Bid.values();
        Random random = new Random();
        return bid[random.nextInt(bid.length)];
    }


    //Method for determining a bidding order of players
    public void biddingOrder ()
    {
        biddingOrder = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Player player = Game.players.get(j);

                if (player.getPlace().ordinal() == i)
                {
                    biddingOrder.add(player);
                }
            }
        }
    }


    //Method for clockwise selecting a next Bidder in this contract
 /*   public Player nextBidder ()
    {
        int nextBidderIndex;
        int previousBidderIndex;
        int dealerIndex = biddingOrder.indexOf(Lap.dealerGlobal);
        if (lastBidder == null)
        {
            previousBidderIndex = dealerIndex;
        }
        else
        {
            previousBidderIndex = biddingOrder.indexOf(lastBidder);
        }

        if (previousBidderIndex == 3) {
            nextBidderIndex = 0;
        }
        else
        {
            nextBidderIndex = ++previousBidderIndex;
        }

        if (nextBidderIndex == dealerIndex)
        {
            nextBidderIndex++;
        }
        return biddingOrder.get(nextBidderIndex);
    }*/

    public void bidding ()
    {

        setContractTurns();
        biddingOrder();

        biddingOrder.remove(Lap.dealerGlobal);

        for (Player player: biddingOrder) {
            playersBidsList.add(new PlayersBids(player));
        }


        for (int i=0; i < contractTurns; i++)
        {
            for (PlayersBids playersBids: playersBidsList)
            {
                Bid newBid = randomBid();

                while (newBid.ordinal() < winningBid.ordinal())
                {
                    newBid = randomBid();
                }

                    winningBid = newBid;
                    playersBids.addBid(newBid);
                    winningBidder = playersBids.getPlayer();


            }

            }

            // creation of bids set for each player for this contract

        }

    }




