import java.util.ArrayList;
import java.util.Random;

public class Tricks {
    private ArrayList<PlayersBids> playersBidsList = new ArrayList<PlayersBids>();
    private Bid winningBid = null;
    private Player winningBidder = null;

    public void tricksBidding (ArrayList<PlayersBids> playersBidsList, Bid winningBid, Player winningBidder)
    {
        playersBidsList = playersBidsList;
        this.winningBidder = winningBidder;
        this.winningBid = winningBid;

        for (PlayersBids playersBids: playersBidsList)
        {
            if (playersBids.getPlayer() != winningBidder)
            {
                playersBids.addBid(randomBidTricks(false));
            }
            else
            {
                playersBids.addBid(randomBidTricks(true));
            }
        }

        Logging.logEvent("Tricks decisions (PASS means that player not whistsing, WHIST - whisting, new Winning bid or duplicated winning BID - for the winner)" + playersBidsList);
        tricksPlay();

    }

    public Bid randomBidTricks (boolean isWinning)
    {
        Random random = new Random();
        Bid[] bids = Bid.values();
        if (isWinning)
        {
            Bid newBid = bids[random.nextInt(26)];
            if (newBid.ordinal() > winningBid.ordinal()) {
                return newBid;
            }
            else
            {
                return winningBid;
            }

        }
            Bid newBid = bids[random.nextInt(1) + 26];
            return newBid;
    }

    public void tricksPlay()
    {


    }
}
