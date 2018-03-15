import java.util.HashSet;

public class CardSet {
    // here stored cards corresponding to players in each lap
    private Player player;
    private HashSet<Cards> cardsSet = new HashSet<Cards>();

    public CardSet (Player player)
    {
        this.player = player;
    }

    public HashSet<Cards> getCardSet (Player player)
    {
        return cardsSet;
    }

    public void setCardsSet (HashSet<Cards> cardsSet)
    {
        this.cardsSet = cardsSet;
    }

    @Override
    public String toString ()
    {
        return "Player: " + player.getName() + ". Card set for lap: " + cardsSet;
    }

}
