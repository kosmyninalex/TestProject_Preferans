import java.util.*;

public class Player {
    private String name;
    private static ArrayList <Place> seats = new ArrayList<>(Arrays.asList(Place.values()));

    private int pool = 0;
    private int mountain = 0;
    private int leftWhist = 0;
    private int centerWhist = 0;
    private int rightWhist = 0;

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

    public void updatePool (int poolPoints)
    {
        this.pool = this.pool + poolPoints;
    }

    public void updateMountain (int mountainPoints)
    {
        this.mountain = this.mountain + mountainPoints;
    }

    public void leftWhistUpdate(int leftWhistPoints)
    {
        this.leftWhist = this.leftWhist + leftWhistPoints;
    }

    public void rightWhistUpdate (int rightWhistPoints)
    {
        this.rightWhist = this.rightWhist + rightWhistPoints;
    }

    public void centerWhistUpdate (int centerWhistPoints)
    {
        this.centerWhist = this.centerWhist + centerWhistPoints;
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

