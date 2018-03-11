import java.util.ArrayList;

public class PlayersBids {
    private Player player;
    private ArrayList<Bid> bids;

    public PlayersBids(Player player)
    {
        this.player = player;
    }

    public void addBid (Bid bid)
    {
        bids.add(bid);
    }



}
