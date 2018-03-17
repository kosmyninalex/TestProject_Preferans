import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Contract {
    private Bid winningBid = Bid.SIX_SPADE;
    private Player winningBidder;
    private ArrayList<PlayersBids> playersBidsList = new ArrayList<PlayersBids>();
    private int contractTurns;
    ArrayList<Player> biddingOrder;
    private boolean isMiserGame = false;

    private void setContractTurns ()
    {
        // choosing a random iterations number of bidding between players.
        Random random = new Random();
        contractTurns = 1 + random.nextInt(3); //All values for "n" are chosen arbitrarily
    }

    // Method for picking a bid from "Bid" enum
    private Bid randomBid(int randValue) {
        Bid[] bid = Bid.values();
        Random random = new Random();
        if ((randValue == 17) || (isMiserGame == true)) //checking if its miser
        {
            isMiserGame = true;
            return bid[random.nextInt(bid.length - randValue) + randValue];
        }
        else
        {
            System.out.println (bid.length);
            System.out.println (Bid.TEN_NO_BUYIN.ordinal());
          //  System.out.println (bid.)
            return bid[random.nextInt(bid.length - randValue) + randValue -3];
        }

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

     for (Player player: biddingOrder) {
         playersBidsList.add(new PlayersBids(player));
     }

     Bid newBid1 = randomBid(winningBid.ordinal());
     Bid newBid2 = randomBid(newBid1.ordinal());
     Bid newBid3 = randomBid(newBid2.ordinal());

     playersBidsList.get(0).addBid(newBid1);
     playersBidsList.get(1).addBid(newBid2);
     playersBidsList.get(2).addBid(newBid3);

     System.out.println (newBid1);
     System.out.println (newBid2);
     System.out.println (newBid3);


     if ((newBid1 == Bid.PASS) && (newBid2 == Bid.PASS) && (newBid2 == Bid.PASS))
     {
         Logging.logEvent("passes start");
      //   PlayType.play(pass);
     }
     else
         if ((newBid1 == Bid.MISER) || (newBid2 == Bid.MISER) || (newBid3 == Bid.MISER))
         {
             Logging.logEvent("miser start");
        //     PlayType.play(miser);
         }
         else
         {
             Logging.logEvent("trick start");
          //   PlayType.play(tricks);
         }


 }


// This is old bidding method
   /* public void bidding ()
    {
        setContractTurns();
        System.out.println ("Number of contract turns is " + contractTurns);
        biddingOrder();

        biddingOrder.remove(Lap.dealerGlobal);

        System.out.println ("Bidding order is " + biddingOrder);
        System.out.println (biddingOrder.size());

        for (Player player: biddingOrder) {
            playersBidsList.add(new PlayersBids(player));
        }

        for (int i=0; i < contractTurns; i++)
        {Bid newBid = randomBid(0);

            Iterator<PlayersBids> iterator = playersBidsList.iterator();
            while (iterator.hasNext())
            {
                PlayersBids playersBids = iterator.next();

                switch (newBid)
                {
                    case MISER:
                        if (playersBids.getBids().size() == 0)
                        playersBids.setMisereStatus();
                        break;
                    case PASS:
                        playersBids.setPassStatus();
                        break;
                    default:
                        break;
                }

//                System.out.println (newBid);

                if (winningBid == null)
                {
                    winningBid = newBid;
                }
                else {
                    while (newBid.ordinal() <= winningBid.ordinal()) {
                        newBid = randomBid(winningBid.ordinal());
                    }
                }
                if (newBid == Bid.PASS)
                {
                    playersBids.addBid(newBid);
                    iterator.remove();
                }
                else {
                    winningBid = newBid;
                    winningBidder = playersBids.getPlayer();
//                if (winningBid == Bid.MISER)
                    playersBids.addBid(newBid);


                }
            }
            System.out.println (playersBidsList);


        }

            // creation of bids set for each player for this contract

        }*/

}




