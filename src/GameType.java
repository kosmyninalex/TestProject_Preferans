public class GameType {
    private static int maxPoints = 0;
    private static int maxRounds = 0;

    public static void createGame (String type, String number)
    {
        switch (type)
        {
            case "pool": maxPoints = Integer.parseInt(number);
                break;
            case "rounds": maxRounds = Integer.parseInt(number);
                break;
        }
    }


}
