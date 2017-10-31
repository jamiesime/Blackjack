package example.codeclan.com.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 31/10/2017.
 */

public class Game {

    Player player;
    Dealer dealer;
    Deck deck;
    ArrayList<Card> pile;
    boolean gameOver;

    public Game(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.pile = new ArrayList<>();
        this.gameOver = false;
    }

    public void gameStart(){
        while (!gameOver){

        }
    }
}
