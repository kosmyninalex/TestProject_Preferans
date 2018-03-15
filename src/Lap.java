import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


// Class creates a new "subGame", e.g. : choosing a new dealer, creating a new cardset, assigning Cards.
public class Lap {
    private Bid bid;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Cards> bank = new ArrayList<Cards>();
    private HashSet<Cards> playerCardses = new HashSet<Cards>();
    private Contract contract;
    private PlayersBids playersBids;
    private Player dealer;

    public static Player dealerGlobal = null; //here stored dealer from last lap, so dealer for the next Lap will be chosen using clockwise method nextDealer

    private HashSet <Cards> set1 = new HashSet<>();
    private HashSet <Cards> set2 = new HashSet<>();
    private HashSet <Cards> set3 = new HashSet<>();
    private HashSet <Cards> set4 = new HashSet<>();

    public Lap(ArrayList<Player> players)
    {
        this.players = players;
        nextDealer();
    }
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


    public Player getDealer ()
    {
        return dealer;
    }


    private ArrayList <CardSet> playerCardsList = new ArrayList<CardSet>();


    //Method for assigning cards to players

    public void assignCards ()
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

    //method for choosing a new dealer for the game
    public void nextDealer ()
    {
        if (dealerGlobal == null) {
            Random random = new Random();
            int dealerNumber = random.nextInt(4);

            dealerGlobal = players.get(dealerNumber);
            dealer = dealerGlobal;
            System.out.println("Assigned dealer number is " + dealerNumber);
            System.out.println ("Dealer is " + dealer );
            System.out.println ("Dealer global is " + dealerGlobal );

        }

        else
        {
            int nextDealer;
            int previousDealer = dealerGlobal.getPlace().ordinal();
            if (previousDealer == 3)
            {
                nextDealer = 0;
            }
            else
            {
                nextDealer = ++previousDealer;
            }
            Place nextPlace = Place.values()[nextDealer];
            System.out.println (nextPlace);
            dealer = getPlayerByPlace(nextPlace);
            dealerGlobal = dealer;

        }

}

    private Player getPlayerByPlace (Place place)
    {
        for (Player player: players)
        {
            if (player.getPlace() == place)
            {
                return player;
            }
        }
        return null;
    }
}
