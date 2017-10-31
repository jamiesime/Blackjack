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
            revealHands();
            compareHands();
        }
        startAgain();
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
            if (player.handTotal() < 21) {
                System.out.println("To twist, enter 1. To stick, enter anything else.");
            }
            else{
                System.out.println("You went bust! You lose!");
                startAgain();
            }
        }



    public void playerMove(){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if (input == 1){
            System.out.println("Dealing new card...");
            playerTwist();
        }
        if (input == 2){
            playerStick();
        }
    }

    public void playerStick(){
        System.out.println("You have chosen to stick. Dealer turn...");
    }

    public void playerTwist(){
        player.takeCard(dealer.deal());
        displayHand();
        playerMove();
    }

    public void dealerTurn(){
        int choice = dealer.decision();
        if (choice == 1) {
            System.out.println("The dealer is sticking.");
        }
        else if (choice == 2) {
            System.out.println("The dealer will twist!");
            dealerTwist();
        }
        else if (choice == 3){
            System.out.println("The dealer went bust! They lose! So, you win!");
            revealHands();
            startAgain();
        }
    }

    public void dealerTwist(){
        dealer.takeCard(dealer.deal());
        dealerTurn();
    }

    public void revealHands(){
        System.out.println("The dealer's hand:");
        for (Card card : dealer.getCards()){
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
        System.out.println("DEALER HAND VALUE: " + dealer.handTotal());
        System.out.println("YOUR HAND VALUE: " + player.handTotal());
    }

    public boolean compareHands(){
        if (player.handTotal() > dealer.handTotal()){
            System.out.println("You won!");
        }
        if (dealer.handTotal() > player.handTotal()){
            System.out.println("You lost...");
        }
        if (player.handTotal() == dealer.handTotal()){
            System.out.println("Draw! Which means the dealer wins. Accept the rules or leave.");

        }
        return gameOver = true;
    }

    public void startAgain(){
        System.out.println("What an exciting game of chance. Play again?");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if (input == 1){
            gameOver = false;
            resetGame();
        }
        if (input == 2){
            System.out.println("A bad choice. See you next time.");
            quit();
        }
        else {
            System.out.println("Invalid choice. I will assume that means you want to play again.");
            gameOver = false;
            resetGame();
        }

    }

    public void resetGame(){
        player.emptyHand();
        dealer.emptyHand();
        deck.emptyDeck();
        deck.generateDeck();
        deck.shuffle();
        gameStart();
    }

    public void quit(){
        System.exit(0);
    }



}
