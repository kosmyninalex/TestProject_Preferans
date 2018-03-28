//Testing tricks_edited branch 1
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

    private ArrayList<PlayerTricks> playerTricksList = new ArrayList<PlayerTricks>();

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

        ArrayList<Player> playersList = new ArrayList<Player>();
        ArrayList<CardSet> playerCardsList1 = (ArrayList<CardSet>) playerCardsList.clone();
        playerCardsList1.remove(buyin);
        playerCardsList1.remove(winningBidderSet);

        playersList.add(winningBidder);

        int whistsCount = 0;
        int passCount = 0;
        for (PlayersBids playersBids: playersBidsList) {
            Player player = playersBids.getPlayer();
            if ((player != winningBidder) && (player != Lap.dealerGlobal)) {
                ArrayList<Bid> bids = playersBids.getBids();
                Bid finalBid = bids.get(bids.size() - 1);
                finalBidWithPlayer.put(player, finalBid);
                playersList.add(player);
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
            for (int i = 0; i < 10; i ++)
            {
                Cards card = winningBidderSet.getCardSet().get(i);
                PlayerTricks playerTricks = new PlayerTricks(winningBidder, card);
                playerTricksList.add(playerTricks);

                Cards card1 = PlayerTricks.pickAppropriateCard(playerCardsList1.get(0), trump, card.getSuit());
                Player player1 = playerCardsList1.get(0).getPlayer();
                PlayerTricks playerTricks1 = new PlayerTricks(player1, card1);
                playerTricksList.add(playerTricks1);

                Cards card2 = PlayerTricks.pickAppropriateCard(playerCardsList1.get(1), trump, card.getSuit());
                Player player2 = playerCardsList1.get(1).getPlayer();
                PlayerTricks playerTricks2 = new PlayerTricks(player2, card2);
                playerTricksList.add(playerTricks2);


                Logging.logEvent("Playing cards are: " + playerTricksList + " .Trump is " + trump);
                PlayerTricks winnerOfTrick = PlayerTricks.compareCards(playerTricksList, trump, card.getSuit()); // Wining Player with his card in this 1 of 10 tricks
                Logging.logEvent("Winning player is " + winnerOfTrick.getPlayer());

                playerTricksList.removeAll(playerTricksList);
            }

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
        arrayList.remove(card1);
        Cards card2 = arrayList.get(random.nextInt(11));
        arrayList.remove(card2);

        Logging.logEvent(winningBidder.toString() + " Player dropped 2 cards. It's: " + card1 + " and " + card2);
        Logging.logEvent(winningBidderSet.toString());

        trump = winningBid.getTrump();
//        Logging.logEvent (trump.toString());
        finalBidWithPlayer.put(winningBidder, winningBid);


        }




}
