import java.util.ArrayList;
import java.util.HashSet;

public class CardSet {
    // here stored cards corresponding to players in each lap
    private Player player;
    private ArrayList<Cards> cardsSet = new ArrayList<>();

    public CardSet(Player player) {
        this.player = player;
    }

    public ArrayList<Cards> getCardSet(Player player) {
        return cardsSet;
    }

    public void setCardsSet(ArrayList <Cards> cardsSet) {
        this.cardsSet = cardsSet;
    }

    public void addCardToSet(Cards card)
    {
        cardsSet.add(card);
    }

    public Player getPlayer ()
    {
        return player;
    }
    public ArrayList<Cards> getCardSet ()
    {
        return cardsSet;
    }

    @Override
    public String toString ()
    {
        return "Player: " + player.getName() + ". Card set: " + cardsSet;
    }

}
