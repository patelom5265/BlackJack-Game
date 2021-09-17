/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author $Shivang Shingala, you miss 100% of the shots you don't take
 */
public class Blackjack{
public static void main(String[] args) {
        ArrayList<Game1> gameBegins = new ArrayList<>();
        ArrayList<Integer> bets = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        int NumberOfPlayers = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("************** WELCOME TO THE GAME OF BLAKCJACK. LET'S PLAY! *************");
        
        //the beginning of the gameBegins
        while (true) { 
            System.out.println("How many players are playing today?");
            try {
                NumberOfPlayers = Integer.parseInt(input.nextLine());
                if(NumberOfPlayers < 1){
                    System.out.println("You need atleast 1 player to start the game.");}
                if(NumberOfPlayers > 5){
                    System.out.println("Sorry, The maximum capacity of the game is 5.");}
                else {
                    break;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Number of players cannot be anything else other than a number");
            }
        }
        // to create gameBegins objects and players
        for (int i = 0; i < NumberOfPlayers; i++) { 
            gameBegins.add(new Game1());
            bets.add(null);
            System.out.println("Enter your name. If you want to be assigned a default name, leave it blank");
            String playerChosenName = input.nextLine();
            if ("".equals(playerChosenName)) {
                playerChosenName = "Player " + (i + 1);
            }
            
            gameBegins.get(i).setBalance(50);
            gameBegins.get(i).setHand_value(0);
            gameBegins.get(i).setWinner(false);
            players.add(new Player(""));
            players.get(i).setName(playerChosenName);
            
            // line above adds players to player array
            System.out.println(playerChosenName + " added.\n");
        }

        // handles the turn system
        while (true) { 
            System.out.println("---------- TYPE 'LEAVE' TO END GAME, PRESS ENTER TO CONTINUE -------");
            String endGame = input.nextLine();
            if (endGame.toLowerCase().matches("leave")) {
                break;
            // runs the methods that handle the gameBegins
            } else { 
                // betting phase
                bets(gameBegins, bets, players); 
                // turn phase
                turns(gameBegins, players); 
                // payout phase
                payout(gameBegins, bets); 
            }
        }
        System.out.println("Thank you for playing! Have a great day!");
    }

    public static void bets(ArrayList<Game1> object, ArrayList<Integer> bets, ArrayList<Player> players) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        do {
            try {
                int balance = object.get(i).getBalance();
                 // to prevent the user from playing if their balance is 0
                if (balance == 0) {
                    i++;
                } else {
                    System.out.println("Enter a bet " + players.get(i).getName() + ":");
                    System.out.println("Your balance is: $" + object.get(i).getBalance());
                    int bet = Integer.parseInt(input.nextLine());
                    if (balance - bet < 0 || bet < 0) { // checks if user bet more than balance or a negative bet
                        System.out.println("Sorre, You cant bet more than the amount you have");
                    } else {
                        bets.set(i, bet); // adds bet to player index
                        System.out.println("Your new balance is: " + (object.get(i).getBalance() - bet) + "\n");
                        i++;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Your bet must be a number");
            }
        } while (i < object.size());
    }

    public static void payout(ArrayList<Game1> game, ArrayList<Integer> bets) {
        for (int i = 0; i < game.size(); i++) {
            // resets the users hand
            game.get(i).setHand_value(0);
            // checks if the user won
            if (game.get(i).getWinner()) { 
                int pay = game.get(i).getBalance() + bets.get(i);
                // pays the user  
                game.get(i).setBalance(pay);   
            } else {
                int pay = game.get(i).getBalance() - bets.get(i);
                game.get(i).setBalance(pay);
            }
        }

    }

    public static void turns(ArrayList<Game1> game, ArrayList<Player> players) {
        // creates a dealer
        Game1 dealer = new Game1(); 
        System.out.print("Dealer's first card: ");
        dealer.drawCard();

        Scanner input = new Scanner(System.in);
        int i = 0;
        do {
            if (game.get(i).getHand_value() == 0) {
                game.get(i).drawCard();
                game.get(i).drawCard();
                // draws 2 cards for user
            }
            System.out.println("\n" + players.get(i).getName()
                    + ": Your hand value is " + game.get(i).getHand_value());
            System.out.println("Dealer hand is " + dealer.getHand_value()); // prints dealer hand value
            if (game.get(i).getHand_value() < 21) { // checks if the user has 'BUSTED'
                System.out.println("\n[1. Hit\t2. Stand]");
                String userInput = input.nextLine();
                try {
                    if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 2) {
                        System.out.println("Enter either 1 or 2");
                    } else if (Integer.parseInt(userInput) == 1) {

                        game.get(i).drawCard();

                    } else {
                        i++; // if they stand, proceed to next player
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number\n");
                }
            } else if (game.get(i).getHand_value() == 21) { // checks if user got blackjack
                game.get(i).setWinner(true);
                System.out.println("YOU GOT BLACKJACK!");
                i++;
            } else { // player loses
                game.get(i).setWinner(false);
                System.out.println("Sorry, you busted!");
                i++; // proceeds to the next players turn
            }
        } while (i < game.size());

        do { // while dealer hand is less than 16
            System.out.print("Dealer: ");
            dealer.drawCard();
            // *** add code to add a card to dealer hand
            // *** display dealer hand

        } while (dealer.getHand_value() < 16);
        System.out.println("\nDealers hand: " + dealer.getHand_value() + "\n");
        i = 0;
        while (i < game.size()) { // handles code to pick winners
            int dealerHand = dealer.getHand_value();
            int playerHand = game.get(i).getHand_value();
            if (playerHand <= 21) {
                if (dealerHand > 21 && playerHand <= 21) {
                    System.out.println(players.get(i).getName() + " won!");
                    game.get(i).setWinner(true);

                } else if (playerHand > dealerHand && dealerHand <= 21) {
                    System.out.println(players.get(i).getName() + " won!");
                    game.get(i).setWinner(true);

                } else {
                    System.out.println("Sorry " + players.get(i).getName() + ", you lost.\n");
                    game.get(i).setWinner(false);
                }
            }
            else{
                System.out.println("Sorry " + players.get(i).getName() + ", you lost.\n");
                game.get(i).setWinner(false);
            }

            i++;

        }
        dealer.resetHand();

    }


}

