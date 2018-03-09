public enum Bid {
    SIX_SPADE(6, Suit.SPADES),
    SIX_CLUB(6, Suit.CLUBS),
    SIX_DIAMOND(6, Suit.DIAMONDS),
    SIX_HEART(6, Suit.HEARTS),
    SIX_NO_TRUMP(6, null),

    SEVEN_SPADE(7, Suit.SPADES),
    SEVEN_CLUB(7, Suit.CLUBS),
    SEVEN_DIAMOND(7, Suit.DIAMONDS),
    SEVEN_HEART(7, Suit.HEARTS),
    SEVEN_NO_TRUMP(7, null),

    EIGHT_SPADE(8, Suit.SPADES),
    EIGHT_CLUB(8, Suit.CLUBS),
    EIGHT_DIAMOND(8, Suit.DIAMONDS),
    EIGHT_HEART(8, Suit.HEARTS),
    EIGHT_NO_TRUMP(8, null),

    NINE_SPADE(9, Suit.SPADES),
    NINE_CLUB(9, Suit.CLUBS),
    NINE_DIAMOND(9, Suit.DIAMONDS),
    NINE_HEART(9, Suit.HEARTS),
    NINE_NO_TRUMP(9, null),

    TEN_SPADE(10, Suit.SPADES),
    TEN_CLUB(10, Suit.CLUBS),
    TEN_DIAMOND(10, Suit.DIAMONDS),
    TEN_HEART(10, Suit.HEARTS),
    TEN_NO_TRUMP(10, null),

    MISER(0, null),
    PASS(null, null),
    WHIST(null, null);

    private Bid (Integer tricksNumber, Suit trumpSuit) {
        this.tricksNumber = tricksNumber;
        this.trump = trumpSuit;
    }

    private Suit trump;
    private final Integer tricksNumber;

    public Integer getTricksNumber() {
        return tricksNumber;
    }

    public Suit getTrump() {
        return trump;
    }

    public boolean isPlaying() {
        return tricksNumber != null;
    }
/*
    class MyEnumComparator implements Comparator<Bid>
    {

        @Override
        public int compare(Bid o1, Bid o2) {
            int result;
            result = Integer.compare(o1.ordinal(), o2.ordinal());
            return result;
        }
    }*/



}