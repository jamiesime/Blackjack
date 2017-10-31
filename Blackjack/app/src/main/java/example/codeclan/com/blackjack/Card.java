package example.codeclan.com.blackjack;

/**
 * Created by user on 31/10/2017.
 */

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getRankasInt(){
       return this.getRank().getValue();
    }
}
