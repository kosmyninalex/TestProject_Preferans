import java.util.Comparator;

public enum Rank {

    SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    public static Comparator<Rank> comparator() {
        return new Comparator<Rank>() {
            @Override public int compare(Rank rank1, Rank rank2) {
                return rank1.compareTo(rank2);
            }
        };
    }
}