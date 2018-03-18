import com.oracle.tools.packager.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Contract {
    private  Bid winningBid = Bid.SIX_SPADE;
    private  Player winningBidder;
    private  ArrayList<PlayersBids> playersBidsList = new ArrayList<PlayersBids>();
    private  int contractTurns;
    private  ArrayList<Player> biddingOrder;
    private  boolean isMiserGame = false;
    private  boolean isTricksGame = false;

    private void setContractTurns ()
    {
        // choosing a random iterations number of bidding between players.
        Random random = new Random();
        contractTurns = 1 + random.nextInt(3); // value for "n" is chosen arbitrarily
    }

    // Method for picking a bid from "Bid" enum
    private Bid randomBid() {
        Bid[] bid = Bid.values();
        int randValue = winningBid.ordinal();
        Bid newBid = null;

     //   randValue++; //getting next value
        Random random = new Random();
      if ((((randValue == 15) || (isMiserGame == true))) && (isTricksGame == false))
      {
          isMiserGame = true;
          newBid = bid[random.nextInt(4) + 27];
          if ((newBid.ordinal() > winningBid.ordinal()) && (newBid != Bid.PASS) )
          {
              winningBid = newBid;
              return newBid;
          }
          else
              {
                  return Bid.PASS;
              }
      }
      else
      {
          newBid = bid[random.nextInt(28)];
          if ((newBid == Bid.WHIST) && (isTricksGame == false))
          {
              return Bid.PASS;
          }

          if (newBid == Bid.MISER)
          {
              return Bid.PASS;
          }

          if ((newBid.ordinal() > winningBid.ordinal()) && (newBid != Bid.PASS) )
          {
              if (newBid != Bid.WHIST)
              winningBid = newBid;
              return newBid;
          }
          else
          {
              return Bid.PASS;
          }
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
 private void createBidsLists ()
 {
     ArrayList<Player> biddingOrder1 = (ArrayList<Player>) biddingOrder.clone();
     biddingOrder1.remove(Lap.dealerGlobal);

     for (Player player: biddingOrder1) {
         playersBidsList.add(new PlayersBids(player));
     }
 }



 public void bidding ()
 {
     setContractTurns();
     biddingOrder();
     createBidsLists();

     Logging.logEvent("Bidding order is " + biddingOrder);
     isMiserGame = false;

     winningBid = Bid.SIX_SPADE;
     System.out.println ("New contract");


     Bid newBid1 = randomBid();
     playersBidsList.get(0).addBid(newBid1);
   //  Logging.logEvent(newBid1.toString());
     Bid newBid2 = randomBid();
     playersBidsList.get(1).addBid(newBid2);
   //  Logging.logEvent(newBid2.toString());
     Bid newBid3 = randomBid();
     playersBidsList.get(2).addBid(newBid3);
    // Logging.logEvent(newBid3.toString());





     Logging.logEvent(playersBidsList.toString());

     Logging.logEvent("---------------List of first bids------");
     Logging.logEvent(newBid1 + " " + newBid2 + " " + newBid3);
  //   Logging.logEvent("Winning bid is " + winningBid);


     if ((newBid1 == Bid.PASS) && (newBid2 == Bid.PASS) && (newBid3 == Bid.PASS))
     {
         for (PlayersBids playersBids: playersBidsList)
         {
         //    playersBids.setPass();
         }
         Logging.logEvent("passes start");
      //   PlayType.play(pass);
     }
     else
         if ((newBid1 == Bid.MISER) || (newBid2 == Bid.MISER) || (newBid3 == Bid.MISER))
         {
             for (PlayersBids playersBids: playersBidsList)
             {
           //      playersBids.setMisere();
             }
             Logging.logEvent("miser start");
        //     PlayType.play(miser);
         }
         else
         {
             Logging.logEvent("trick start");
             tricksBidding(newBid1, newBid2, newBid3);
             Tricks tricks = new Tricks();
             tricks.tricksBidding(playersBidsList, winningBid, winningBidder);
          //   PlayType.play(tricks);
         }
 }

 public void tricksBidding (Bid bid1, Bid bid2, Bid bid3)
    {
        isTricksGame = true;
        Bid newBid1 = bid1;
        Bid newBid2 = bid2;
        Bid newBid3 = bid3;
        int passesCount = 0;

        if (newBid1 == Bid.PASS)
        {
            passesCount++;
            playersBidsList.get(0).setPass();
        }
        if (newBid2 == Bid.PASS)
        {
            passesCount++;
            playersBidsList.get(1).setPass();
        }
        if (newBid3 == Bid.PASS)
        {
            passesCount++;
            playersBidsList.get(2).setPass();
        }
        int passesCount1 = passesCount;

        while (passesCount1 < 2) {
            passesCount1 = passesCount;

            if (playersBidsList.get(0).getPassStatus() == false) {
                newBid1 = randomBid();
                Logging.logEvent(newBid1.toString());
                if ((newBid1 == Bid.PASS) || (newBid1 == Bid.WHIST)) {
                    passesCount1++;}
                    if (newBid1 == Bid.WHIST) {
                        playersBidsList.get(0).addBid(Bid.PASS);
                    //    playersBidsList.get(0).addBid(newBid1);
                    } else {
                        playersBidsList.get(0).addBid(newBid1);
                    }

            }

            if (playersBidsList.get(1).getPassStatus() == false) {
                newBid2 = randomBid();
                Logging.logEvent(newBid2.toString());
                if ((newBid2 == Bid.PASS) || (newBid2 == Bid.WHIST)) {
                    passesCount1++;
                }
                    if (newBid2 == Bid.WHIST) {
                        playersBidsList.get(1).addBid(Bid.PASS);
                     //   playersBidsList.get(1).addBid(newBid2);
                    } else {
                        playersBidsList.get(1).addBid(newBid2);
                    }

            }

            if (playersBidsList.get(2).getPassStatus() == false) {
                newBid3 = randomBid();
                Logging.logEvent(newBid3.toString());
                if ((newBid3 == Bid.PASS) || (newBid3 == Bid.WHIST)) {
                    passesCount1++;}
                    if (newBid3 == Bid.WHIST) {
                        playersBidsList.get(2).addBid(Bid.PASS);
                    //    playersBidsList.get(2).addBid(newBid3);
                    } else {
                        playersBidsList.get(2).addBid(newBid3);
                    }

            }
        }


            /// need to remove bids for wiiing player with passes
        getWinningBidder();

            Logging.logEvent("Bids results are: " + playersBidsList.toString());
        Logging.logEvent("Winning bidder is " + winningBidder);
        Logging.logEvent("Winnig bid is " + winningBid);

    }


public Player getWinningBidder ()
{
    for (PlayersBids playersBids: playersBidsList)
    {
        if (playersBids.getBids().contains(winningBid))
        {
            winningBidder = playersBids.getPlayer();

            if (playersBids.getBids().contains(Bid.PASS))
            {
                playersBids.getBids().remove(Bid.PASS);
            }
            return playersBids.getPlayer();
        }
    }
    return null;
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




