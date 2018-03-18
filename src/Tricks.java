import com.oracle.tools.packager.Log;

import java.util.*;

public class Tricks {
    private ArrayList<PlayersBids> playersBidsList = new ArrayList<PlayersBids>();
    private Bid winningBid = null;
    private Player winningBidder = null;
    private ArrayList<CardSet> playerCardsList = new ArrayList<CardSet>();
    private CardSet winningBidderSet = null;
    private CardSet buyin = null;
    private HashMap<Player, Bid> finalBidWithPlayer = new HashMap<Player, Bid>();
    private Suit trump = null;

    public void tricksBidding() {
        for (PlayersBids playersBids : playersBidsList) {
            if (playersBids.getPlayer() != winningBidder) {
                playersBids.addBid(randomBidTricks(false));
            } else {
                playersBids.addBid(randomBidTricks(true));
            }
        }

        Logging.logEvent("Tricks decisions calculated (PASS means that player not whistsing, WHIST - whisting, new Winning bid or duplicated winning BID - for the winner)");
        Logging.logEvent(playersBidsList.toString());

    }

    public Bid randomBidTricks(boolean isWinning) {
        Random random = new Random();
        Bid[] bids = Bid.values();
        if (isWinning) {
            Bid newBid = bids[random.nextInt(26)];
            if (newBid.ordinal() > winningBid.ordinal()) {
                return newBid;
            } else {
                return winningBid;
            }

        }
        Bid newBid = bids[random.nextInt(1) + 26];
        return newBid;
    }

    public void tricksPlay(ArrayList<PlayersBids> playersBidsList, Bid winningBid, Player winningBidder, ArrayList<CardSet> playerCardsList)
    {
        this.playersBidsList = playersBidsList;
        this.winningBidder = winningBidder;
        this.winningBid = winningBid;
        this.playerCardsList = playerCardsList;

        tricksBidding();
        droppingTwoCards();

        int whistsCount = 0;
        int passCount = 0;
        for (PlayersBids playersBids: playersBidsList) {
            Player player = playersBids.getPlayer();
            if ((player != winningBidder) && (player != Lap.dealerGlobal)) {
                ArrayList<Bid> bids = playersBids.getBids();
                Bid finalBid = bids.get(bids.size() - 1);
                finalBidWithPlayer.put(player, finalBid);
                if (finalBid == Bid.WHIST)
                {
                    whistsCount++;
                }
                if (finalBid == Bid.PASS)
                {
                    passCount++;
                }
            }
        }


        if (whistsCount == 2)
        {

        }



    }


    public void droppingTwoCards()
    {
        for (CardSet cardSet: playerCardsList)
        {
            if (cardSet.getPlayer() == winningBidder)
            {
                winningBidderSet = cardSet;
            }
            if (cardSet.getPlayer() == Lap.dealerGlobal)
            {
                buyin = cardSet;
            }
        }
        ArrayList <Cards> arrayList = winningBidderSet.getCardSet();
        arrayList.addAll(buyin.getCardSet());

        Logging.logEvent("Buy in opened. Its cards are: " + buyin.getCardSet());
        Random random = new Random();

        Cards card1 = arrayList.get(random.nextInt(12));
        Cards card2 = arrayList.get(random.nextInt(11));
        arrayList.remove(card2);
        arrayList.remove(card1);
        Logging.logEvent(winningBidder.toString() + " Player dropped 2 cards. It's: " + card1 + " and " + card2);
        Logging.logEvent(winningBidderSet.toString());

        trump = winningBid.getTrump();
        Logging.logEvent(trump.toString());


        }




}
