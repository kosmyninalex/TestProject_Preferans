import java.util.ArrayList;

public class PlayersBids {
    private Player player;
    private ArrayList<Bid> bids = new ArrayList<Bid>();
    private boolean isPass = false;
    private boolean isMisere = false;

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

    public ArrayList<Bid> getBids ()
    {
        return bids;
    }

    public boolean getPassStatus()
    {
        return isPass;
    }

    public boolean getMisereStatus()
    {
        return isMisere;
    }

    public void setPass()
    {
        isPass = true;
    }

    public void setMisere()
    {
       isMisere = true;
    }

    public void removeBid(Bid bid)
    {
        bids.remove(bid);
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
