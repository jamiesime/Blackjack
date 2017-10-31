package example.codeclan.com.blackjack;

/**
 * Created by user on 31/10/2017.
 */

public class Dealer extends Player {

    Deck deck;

    public Dealer(String name, Deck deck) {
        super(name);
        this.deck = deck;
        shuffle();
    }

    public Card deal(){
        return this.deck.removeFirstCard();
    }

    public void shuffle(){
        this.deck.shuffle();
    }
}
