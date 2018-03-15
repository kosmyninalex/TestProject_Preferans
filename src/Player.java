import java.util.*;

public class Player {
    private String name;
    private static ArrayList <Place> seats = new ArrayList<>(Arrays.asList(Place.values()));

    private int pool;
    private int mountain;
    private int leftWhist;
    private int centerWhist;
    private int rightWhist;

 //   private boolean isDealer = false;
    private Place place;
//creation of a new Player with given name and a random place returned by takingSeats() method
    public Player (String name)
    {
        this.name = name;
        place = takingSeats();
    }

    public String getName ()
    {
        return this.name;
    }

    public Place getPlace()
    {
        return place;
    }

    public void setPlace(Place place)
    {
        this.place = place;
    }



    public String toString ()
    {
        return name;
    }

    private Place takingSeats()
    {
        Random random = new Random();
        Place takenPlace = null;

        while (takenPlace == null) {
            int n = random.nextInt(seats.size());
            takenPlace = seats.get(n);
            seats.remove(n);
        }
        return takenPlace;
        }
    }

