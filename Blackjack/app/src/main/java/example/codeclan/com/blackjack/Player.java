package example.codeclan.com.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 31/10/2017.
 */

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void takeCard(Card card){
        cards.add(card);
    }




}
