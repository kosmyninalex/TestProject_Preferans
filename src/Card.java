public enum Card {

    SPADES_7(Suit.SPADES, Rank.SEVEN),
    CLUBS_7(Suit.CLUBS, Rank.SEVEN),
    DIAMONDS_7(Suit.DIAMONDS, Rank.SEVEN),
    HEARTS_7(Suit.HEARTS, Rank.SEVEN),

    SPADES_8(Suit.SPADES, Rank.EIGHT),
    CLUBS_8(Suit.CLUBS, Rank.EIGHT),
    DIAMONDS_8(Suit.DIAMONDS, Rank.EIGHT),
    HEARTS_8(Suit.HEARTS, Rank.EIGHT),

    SPADES_9(Suit.SPADES, Rank.NINE),
    CLUBS_9(Suit.CLUBS, Rank.NINE),
    DIAMONDS_9(Suit.DIAMONDS, Rank.NINE),
    HEARTS_9(Suit.HEARTS, Rank.NINE),

    SPADES_10(Suit.SPADES, Rank.TEN),
    CLUBS_10(Suit.CLUBS, Rank.TEN),
    DIAMONDS_10(Suit.DIAMONDS, Rank.TEN),
    HEARTS_10(Suit.HEARTS, Rank.TEN),

    SPADES_JACK(Suit.SPADES, Rank.JACK),
    CLUBS_JACK(Suit.CLUBS, Rank.JACK),
    DIAMONDS_JACK(Suit.DIAMONDS, Rank.JACK),
    HEARTS_JACK(Suit.HEARTS, Rank.JACK),

    SPADES_QUEEN(Suit.SPADES, Rank.QUEEN),
    CLUBS_QUEEN(Suit.CLUBS, Rank.QUEEN),
    DIAMONDS_QUEEN(Suit.DIAMONDS, Rank.QUEEN),
    HEARTS_QUEEN(Suit.HEARTS, Rank.QUEEN),

    SPADES_KING(Suit.SPADES, Rank.KING),
    CLUBS_KING(Suit.CLUBS, Rank.KING),
    DIAMONDS_KING(Suit.DIAMONDS, Rank.KING),
    HEARTS_KING(Suit.HEARTS, Rank.KING),

    SPADES_ACE(Suit.SPADES, Rank.ACE),
    CLUBS_ACE(Suit.CLUBS, Rank.ACE),
    DIAMONDS_ACE(Suit.DIAMONDS, Rank.ACE),
    HEARTS_ACE(Suit.HEARTS, Rank.ACE);

    private Suit suit;
    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

}