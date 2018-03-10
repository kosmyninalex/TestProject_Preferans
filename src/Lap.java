import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Lap {
    private Bid bid;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Cards> bank = new ArrayList<Cards>();
    private HashSet<Cards> playerCardses = new HashSet<Cards>();
    private Contract contract;
    private PlayersBids playersBids;
    static Player dealer;

    private HashSet <Cards> set1 = new HashSet<>();
    private HashSet <Cards> set2 = new HashSet<>();
    private HashSet <Cards> set3 = new HashSet<>();
    private HashSet <Cards> set4 = new HashSet<>();

    // Method for picking a random card from a Cards enum
    private Cards randomCard() {
        Cards[] cardses = Cards.values();
        Random random = new Random();
        return cardses[random.nextInt(cardses.length)];
    }

    // Creating random card Set of 32 cards from Cards enum
    private void createCardsSet ()
    {
        while (playerCardses.size() < 32)
        {
            playerCardses.add(randomCard());
        }
      //  System.out.println (playerCardses.toString());
    }

    private void setDealer ()
    {
        Random random = new Random();
        int playerNumber = random.nextInt(3);




    }


    private ArrayList <CardSet> playerCardsList = new ArrayList<CardSet>();


    //Method for assigning cards to players

    public void assignCards (ArrayList<Player> players)
    {
        createCardsSet();
        for (Player player: players)
        {
            CardSet cardSet = new CardSet(player);
            playerCardsList.add(cardSet);
        }

        Iterator<Cards> iterator = playerCardses.iterator();

        // Giving two cards to each player on each turn. Putting two cards to buy-in after second turn
        for (int i = 0; i < 5; i++)
        {
            set1.add(iterator.next());
            set1.add(iterator.next());

            set2.add(iterator.next());
            set2.add(iterator.next());

            set3.add(iterator.next());
            set3.add(iterator.next());

            if (i == 1)
            {
                set4.add(iterator.next());
                set4.add(iterator.next());
            }
        }

        playerCardsList.get(0).setCardsSet(set1);
        playerCardsList.get(1).setCardsSet(set2);
        playerCardsList.get(2).setCardsSet(set3);
        playerCardsList.get(3).setCardsSet(set4);

        for (CardSet cardSet: playerCardsList)
        {
            System.out.println (cardSet);
        }

    }
}
