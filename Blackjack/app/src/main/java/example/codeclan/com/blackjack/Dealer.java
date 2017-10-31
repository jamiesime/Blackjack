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

    public int decision(boolean hasAce){
        int handTotal = 0;
        for (Card card : this.cards){
            handTotal += card.getRank().getValue();
        }
        if (hasAce) {
            aceModifier(handTotal);
        }
        if (handTotal > 21){
            return 3;
        }
        if (handTotal < 16){
            return 2;
        }
        else {
            return 1;
        }
    }

    public void aceModifier(int handTotal){
        if (handTotal > 11){
            handTotal -= 10;
        }
        if (handTotal <= 11){
            handTotal += 10;
        }
    }
}
