import java.util.ArrayList;
import java.util.Random;

public class PlayerTricks {
    private Cards card;
    private Player player;

    public PlayerTricks (Player player, Cards card)
    {
        this.player = player;
        this.card = card;

    }

    public Player getPlayer()
    {
        return player;
    }

    public String toString ()
    {
        return player + " " + card;
    }


    public static PlayerTricks compareCards (ArrayList<PlayerTricks> playerTricksList)
    {
        PlayerTricks max = playerTricksList.get(0);

        for (PlayerTricks playerTricks: playerTricksList)
        {
            if (playerTricks.card.ordinal() > max.card.ordinal())
            {
                max = playerTricks;
            }
        }
        return max;
    }

    public static Cards pickAppropriateCard (CardSet cardSet, Suit trump, Suit suit) // method for picking card for tricks round. Finds card with appropriate suit or finds trump, if not successul, returns random card.
    {
        ArrayList<Cards> cardsList = (ArrayList<Cards>) cardSet.getCardSet().clone();
        Cards resultCard = null;

        Random random = new Random();

        while (resultCard == null)
        {
            Cards newCard = cardsList.get(random.nextInt(cardsList.size()));
            if ((newCard.getSuit() == trump) || (newCard.getSuit() == suit))
            {
                resultCard = newCard;
            }
            else
            {
                if (cardsList.size() > 1) {
                    cardsList.remove(newCard);
                }
                else
                {
                    resultCard = newCard;
                }
            }

        }
        return resultCard;
    }

}
