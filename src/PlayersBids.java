import java.util.ArrayList;

public class PlayersBids {
    private Player player;
    private ArrayList<Bid> bids = new ArrayList<Bid>();

    public PlayersBids(Player player)
    {
        this.player = player;
    }

    public void addBid (Bid bid)
    {
        bids.add(bid);
    }

    public Player getPlayer()
    {
        return player;
    }

    @Override
    public String toString ()
    {
        String res = "";
        for (Bid bid: bids)
        {
            res = res + " " + bid;
        }
        return player + " his bids are: " + bids;
    }



}
