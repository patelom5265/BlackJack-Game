/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 * @author $Shivang Shingala, you miss 100% of the shots you don't take
 */

import java.util.ArrayList;

public class Game1 {

        private int hand_value;
        private int rounds_won;
        private int balance;
        private boolean winner;
        
        public Game1(){

        }
        

	public int getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getHand_value() {
		return this.hand_value;
	}

	/**
	 * 
	 * @param hand_value
	 */
	public void setHand_value(int hand_value) {
		this.hand_value = hand_value;
	}

	public int getRounds_won() {
		return this.rounds_won;
	}

	/**
	 * 
	 * @param rounds_won
	 */
	public void setRounds_won(int rounds_won) {
		this.rounds_won = rounds_won;
	}
        
        public void setWinner(boolean winner){
            this.winner = winner;
        }
        
        public boolean getWinner(){
            return this.winner;
        }
        
        public void resetHand(){
            
            this.hand_value = 0;
            
        }
        
        public void addToHand(int add){
            
            hand_value += add;
            
        }
        
        public void drawCard(){
            
            int rand = (int)(Math.random() * (13) + 1);
            Card draw = Card.JACK;
            int toReturn = 0;
            for(Card b: Card.values()){
                if(rand == b.getCardValue()){
                    toReturn = b.getCardValue();
                }
            }
            
            addToHand(toReturn);
            
        }



}
