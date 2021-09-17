/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Om
 */
public class BlackjackTest
{

   public BlackjackTest ()
   {
   }

   @BeforeAll
   public static void setUpClass ()
   {
   }

   @AfterAll
   public static void tearDownClass ()
   {
   }

   @BeforeEach
   public void setUp ()
   {
   }

   @AfterEach
   public void tearDown ()
   {
   }

   /**
    * Test of main method, of class Blackjack.
    */
   @Test
   public void testMain ()
   {
      System.out.println("main");
      String[] args = null;
      Blackjack.main(args);
      // TODO review the generated test code and remove the default call to fail.
      //fail("The test case is a prototype.");
   }

   /**
    * Test of bets method, of class Blackjack.
    */
   @Test
   public void testBets ()
   {
      System.out.println("bets");
      ArrayList<Game1> object = null;
      ArrayList<Integer> bets = null;
      ArrayList<Player> players = null;
      Blackjack.bets(object, bets, players);
      // TODO review the generated test code and remove the default call to fail.
      //fail("The test case is a prototype.");
   }

   /**
    * Test of payout method, of class Blackjack.
    */
   @Test
   public void testPayout ()
   {
      System.out.println("payout");
      ArrayList<Game1> game = null;
      ArrayList<Integer> bets = null;
      Blackjack.payout(game, bets);
      // TODO review the generated test code and remove the default call to fail.
      //fail("The test case is a prototype.");
   }

   /**
    * Test of turns method, of class Blackjack.
    */
   @Test
   public void testTurns ()
   {
      System.out.println("turns");
      ArrayList<Game1> game = null;
      ArrayList<Player> players = null;
      Blackjack.turns(game, players);
      // TODO review the generated test code and remove the default call to fail.
      //fail("The test case is a prototype.");
   }

}
