package example.codeclan.com.blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 31/10/2017.
 */

public class Deck {

    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        generateDeck();
    }

    public void generateDeck(){
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card removeFirstCard(){
        return cards.remove(0);
    }
}
