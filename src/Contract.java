import java.util.Random;

/**
 * Created by Admin on 3/9/2018.
 */
public class Contract {
    private Bid bid;
    private 

    public void setContractTurns ()
    {
        // choosing a random iterations number of bidding between players.
        Random random = new Random();
        int n = 1 + random.nextInt(3); //All values for "n" are chosen arbitrarily
        System.out.println ("random numer " + n);
    }

}
