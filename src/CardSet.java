import java.util.HashSet;

/**
 * Created by Admin on 3/7/2018.
 */
public class CardSet {
    // тут храним сгенернные для раунда наборы карт игрока
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
