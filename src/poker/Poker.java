/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author mike
 */
public class Poker {


 
 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Deck deck1 = new Deck();
        Dealer theDealer = new Dealer();
        Hand dealersHand = new Hand();
        Hand playersHand = new Hand();
        Scanner reader = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int cont = 2;
        
        
        //char play = 'y';
        //System.out.printf("%c\n", play);
        
        
        //System.out.print("Would you like to play again?? (y/n)\n");
        //play = reader.next().charAt(0);

        //System.out.printf("%c\n", play);
        
        //Used for testing
        //Hand testHand = new Hand(6,6,6,6,10, "Spade","Ace","Ace","Ace","Ace");
        //Hand testHand = new Hand("Ace","Ace","Spade","Ace","Ace");
        
        //System.out.println("The dealers hand is: ");        
        //testHand.displayHand();
        //System.out.println();
        //System.out.printf("test Value = %f\n", theDealer.evaluateHand(testHand.returnHand()));
        //System.out.println(theDealer.whatIsYourHand(theDealer.evaluateHand(testHand.returnHand())));
                 
        deck1.createDeck();//intializes the deck
       
        //Used for testing
        //System.out.println("UNSHUFFLED: ");
        //deck1.displayDeck();
        
        while (cont != 1){
            theDealer.shuffleDeck(deck1.returnDeck());//shuffles the deck
        
            //Used for testing
            //System.out.println("SHUFFLED: ");
            //deck1.displayDeck();
        
            dealersHand.dealHand(0, deck1.returnDeck());//dealers hand
        
            playersHand.dealHand(5, deck1.returnDeck());// players hand
            System.out.println("Your hand is: ");        
            playersHand.displayHand();
            System.out.println();
        
            System.out.print("You have ");
            System.out.println(theDealer.whatIsYourHand(theDealer.evaluateHand(playersHand.returnHand())));
            
            //have player change cards??
            
            System.out.print("The dealer has ");
            System.out.println(theDealer.whatIsYourHand(theDealer.evaluateHand(dealersHand.returnHand())));
            //System.out.printf("Players Value = %f\n", theDealer.evaluateHand(playersHand.returnHand()));
            System.out.println();
            System.out.println(theDealer.seeWhoWon(theDealer.evaluateHand(dealersHand.returnHand()), theDealer.evaluateHand(playersHand.returnHand())));
            System.out.println();
            
            System.out.println("The dealers hand was: ");        
            dealersHand.displayHand();
            System.out.println();
        
            //System.out.printf("Dealers Value = %f\n", theDealer.evaluateHand(dealersHand.returnHand()));
        
            
        
            
            System.out.print("Would you like to play again?? press 1 to stop\n");
            cont = in.nextInt();
            //play = reader.next().charAt(0);
                    
        }   
    }

 
}
    
            
    
    /**
     * @param args the command line arguments
     */
     //}
    
    
    /**
     * @param args the command line arguments
     */
    