package example.codeclan.com.blackjack;

/**
 * Created by user on 31/10/2017.
 */

public class Runner {

    public static void main(String[] args){
        Deck deck = new Deck();
        Player player = new Player("Homestar");
        Dealer dealer = new Dealer("Gregorio", deck);
        Game game = new Game(player, dealer, deck);
        game.gameStart();
    }

}
