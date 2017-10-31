package example.codeclan.com.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 31/10/2017.
 */

public class TestGame {

    Dealer dealer;
    Player player;
    Game game;
    Deck deck;
    Card card;

    @Before
    public void setUp() {
        deck = new Deck();
        dealer = new Dealer("Gregario", deck);
        player = new Player("City Steve");
        game = new Game(player, dealer, deck);
    }



    @Test
    public void TestDealerHasAce(){
        dealer.cards.add(new Card(Suit.CLUBS, Rank.ACE));
        dealer.cards.add(new Card(Suit.CLUBS, Rank.ACE));
        dealer.cards.add(new Card(Suit.CLUBS, Rank.THREE));
        assertEquals(true, game.checkForAce(dealer));
    }

    @Test
    public void TestDealerMakesDecision(){
        dealer.cards.add(new Card(Suit.CLUBS, Rank.ACE));
        dealer.cards.add(new Card(Suit.CLUBS, Rank.ACE));
        dealer.cards.add(new Card(Suit.CLUBS, Rank.THREE));
        int choice = dealer.decision(true);
        assertEquals(2, choice);
    }

}
