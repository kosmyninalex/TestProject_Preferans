public class Player {
    private String name;

    private int pool;
    private int mountain;
    private int leftWhist;
    private int centerWhist;
    private int rightWhist;

    private boolean isDealer = false;

    public Player (String name)
    {
        this.name = name;
    }

    public String getName ()
    {
        return this.name;
    }

    public void setDealer()
    {
        isDealer = true;
    }


}
