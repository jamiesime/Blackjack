package example.codeclan.com.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;

/**
 * Created by user on 31/10/2017.
 */

public class TestDealer {

    Dealer dealer;
    Deck deck;
    Card card;

    @Before
    public void setUp(){
        deck = new Deck();
        dealer = new Dealer("Dealer", deck);
    }

    @Test
    public void testShuffle(){
        Card firstCard = deck.getCards().get(0);
        deck.shuffle();
        assertFalse(deck.getCards().get(0) == firstCard);
    }


}
