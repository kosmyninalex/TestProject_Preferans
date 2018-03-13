import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    public static ArrayList<Player> players;
    public static Player dealer = null;
   // public static FileWriter

    public static void main(String[] args) {
        Logging.logEvent("Initializing four players");
        Player firstPlayer = new Player("Ilya");
        Player secondPlayer = new Player("Dobrynya");
        Player thirdPlayer = new Player("Alyosha");
        Player fourthPlayer = new Player("Gunslinger");

        Game game = new Game();

        Game.players = new ArrayList<Player>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer, fourthPlayer));

        Logging.logEvent("Players are: " + Game.players);


//        GameType.createGame(args[0], args[1]); // Creating new game according to arguments


        // следующий набор методов будет включен в розыгрыш (раздача, торговля, тип игры, запись очков)
/*        CardSet cardSet = new CardSet();
        cardSet.createCardsSet();
        cardSet.assignCards();
        System.out.println ("-------------");
        System.out.println (cardSet.set1);
        System.out.println (cardSet.set2);
        System.out.println (cardSet.set3);
        System.out.println (cardSet.set4);*/

        Lap lap1 = new Lap(Game.players);
       // lap1.assignCards();
        Lap lap2 = new Lap(Game.players);
       // lap2.assignCards();
        Lap lap3 = new Lap(Game.players);
      //  lap3.assignCards();

        System.out.println ("Testing dealers assignment--------------");
        System.out.println (lap1.getDealer());
        System.out.println (lap2.getDealer());
        System.out.println (lap3.getDealer());



        Bid bid2 = Bid.EIGHT_CLUB;
        Bid bid1 = Bid.EIGHT_NO_TRUMP;
        if (bid1.ordinal() > bid2.ordinal()) {
            System.out.println(bid1 + " > " + bid2);

        }

        for (int i = 0; i < Game.players.size(); i++) {
            System.out.println("Player " + Game.players.get(i).toString() + " place is " + Game.players.get(i).getPlace());
        }

        Contract contract = new Contract();
        contract.biddingOrder();

        contract.bidding();

        GameType gameType = new GameType();



}


    }

