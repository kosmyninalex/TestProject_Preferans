import java.util.ArrayList;
// Not used------------------
// Not ready. Class for creation a game according to input arguments:
public class GameType {
    private static int maxPoints = 0;
    private static int maxRounds = 0;

    private ArrayList <Lap> laps = new ArrayList<>();
// creating game with final condition: maximum points or maximum rounds (Laps)
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

    public static void setMaxPoints (int maxPoints)
    {
        GameType.maxPoints = maxPoints;
    }

    public static void setMaxRounds (int maxRounds)
    {
        GameType.maxRounds = maxRounds;
    }





}
