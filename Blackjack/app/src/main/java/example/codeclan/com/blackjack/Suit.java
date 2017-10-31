package example.codeclan.com.blackjack;

/**
 * Created by user on 31/10/2017.
 */

public enum Suit {

    SPADES("Spades"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
