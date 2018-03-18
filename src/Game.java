import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    public static ArrayList<Player> players;
    public static Player dealer = null;

    public static void main(String[] args) {
        Logging.logEvent("Initializing four players");
        Player firstPlayer = new Player("Ilya");
        Player secondPlayer = new Player("Dobrynya");
        Player thirdPlayer = new Player("Alyosha");
        Player fourthPlayer = new Player("Gunslinger");

        Game.players = new ArrayList<Player>(Arrays.asList(firstPlayer, secondPlayer, thirdPlayer, fourthPlayer));

        Logging.logEvent("Players are: " + Game.players);

        Lap lap1 = new Lap(Game.players);

      /*  Lap lap2 = new Lap(Game.players);
        lap2.assignCards();
        Lap lap3 = new Lap(Game.players);
        lap3.assignCards();*/

    //    System.out.println ("Testing dealers assignment--------------");
     //   System.out.println (lap1.getDealer());
  /*      System.out.println (lap2.getDealer());
        System.out.println (lap3.getDealer());
*/

        for (int i = 0; i < Game.players.size(); i++) {
            System.out.println("Player " + Game.players.get(i).toString() + " place is " + Game.players.get(i).getPlace());
        }



        GameType gameType = new GameType();
}


    }

