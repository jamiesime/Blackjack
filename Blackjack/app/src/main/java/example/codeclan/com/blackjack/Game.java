package example.codeclan.com.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Welcome to Blackjack. The game will now begin.");
        while (!gameOver){
            startRound();
            displayHand();
            playerMove();
            dealerTurn();
        }
    }

    public void startRound(){
        System.out.println("Dealing...");
        for (int i = 0; i < 2; i++) {
            player.takeCard(dealer.deal());
            dealer.takeCard(dealer.deal());
        }
    }

    public void displayHand(){
        System.out.println("Your current hand: ");
        for (Card card : player.getCards()){
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
        System.out.println("To stick, enter 1. To twist, enter 2.");
        }



    public void playerMove(){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if (input == 1){
            playerStick();
        }
        if (input == 2){
            playerTwist();
        }
        else {
            System.out.println("Invalid choice.");
            System.out.println("To stick, enter 1. To twist, enter 2.");
        }
    }

    public void playerStick(){
        System.out.println("You have chosen to stick. Dealer turn...");
    }

    public void playerTwist(){
        player.takeCard(dealer.deal());
        displayHand();
    }

    public void dealerTurn(){
        int choice = dealer.decision();
        if (choice == 1) {
            System.out.println("The dealer is sticking.");
        }
        else if (choice == 2) {
            System.out.println("The dealer will twist!");
        }
    }


}
