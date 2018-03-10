import java.util.*;

public class Game {

    public ArrayList<Player> players;

    public static void main(String[] args) {
        Player firstPlayer = new Player("Ilya");
        Player secondPlayer = new Player("Dobrynya");
        Player thirdPlayer = new Player("Alyosha");
        Player fourthPlayer = new Player("Captain America");
        Game game = new Game();

        game.players = new ArrayList<Player>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer, fourthPlayer));


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

        Lap lap = new Lap();
        lap.assignCards(game.players);



        Bid bid2 = Bid.EIGHT_CLUB;
        Bid bid1 = Bid.EIGHT_NO_TRUMP;
        if (bid1.ordinal() > bid2.ordinal()) {
            System.out.println(bid1 + " > " + bid2);

        }

        for (int i = 0; i < game.players.size(); i++) {
            System.out.println("Player " + game.players.get(i).toString() + " place is " + game.players.get(i).getPlace());



        }


}}