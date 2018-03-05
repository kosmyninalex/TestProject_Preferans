public class Game
{
    public static void main (String [] args)
    {
        Player firstPlayer = new Player("Ilya");
        Player secondPlayer = new Player("Dobrynya");
        Player thirdPlayer = new Player("Alyosha");
        Player fourthPlayer = new Player("Captain America");



        GameType.createGame(args[0], args[1]); // Creating new game according to arguments




    }
}