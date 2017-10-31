package example.codeclan.com.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 31/10/2017.
 */

public class TestPlayer {

    Player player;
    Card card;

    @Before
    public void setUp(){
        player = new Player("Alice");
    }

    @Test
    public void testAddCard(){
        player.getCards().add(new Card(Suit.HEARTS, Rank.JACK));
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void testClearHand(){
        player.getCards().add(new Card(Suit.HEARTS, Rank.JACK));
        player.emptyHand();
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void testHandTotal(){
        player.getCards().add(new Card(Suit.HEARTS, Rank.FIVE));
        player.getCards().add(new Card(Suit.HEARTS, Rank.EIGHT));
        assertEquals(13, player.handTotal());
    }

}
