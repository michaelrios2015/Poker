/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

/**
 *
 * @author mike
 */
public class Hand {

    private Card[] hand = new Card[5];

    public Hand(int value1, int value2, int value3, int value4, int value5){
        hand[0] = new Card(value1);
        hand[1] = new Card(value2);
        hand[2] = new Card(value3);
        hand[3] = new Card(value4);
        hand[4] = new Card(value5);
    }
    
    public Hand(String suit1, String suit2, String suit3, String suit4, String suit5){
        hand[0] = new Card(suit1);
        hand[1] = new Card(suit2);
        hand[2] = new Card(suit3);
        hand[3] = new Card(suit4);
        hand[4] = new Card(suit5);
    }
    
    public Hand(int value1, int value2, int value3, int value4, int value5, String suit1, String suit2, String suit3, String suit4, String suit5){
        hand[0] = new Card(suit1, value1);
        hand[1] = new Card(suit2, value2);
        hand[2] = new Card(suit3, value3);
        hand[3] = new Card(suit4, value4);
        hand[4] = new Card(suit5, value5);
    
    }
    
    public Hand(){
    }
    
    public Hand(int index, Card[] theDeck){
                
        for (int i = 0; i <5; i++)
        {  
            hand[i] = theDeck[i+index];
            
        }
        
        sortHand(hand);
    }
    
    public void dealHand(int index, Card[] theDeck){
                
        for (int i = 0; i <5; i++)
        {  
            hand[i] = theDeck[i+index];
            
        }
        
        sortHand(hand);
    }   
        
    public void displayHand(){
          for (int i = 0; i < 5; i++)
        {
            System.out.printf("%s, %s, %d", hand[i].display_suit(), hand[i].display_name(), hand[i].display_value());
            System.out.println();
        }
    }
    
    public void sortHand(Card[] theHand){
            
    
    Card temp;
            
    for(int i=1; i <5; i++){
        if (theHand[0].display_value() > theHand[i].display_value()){
            temp = theHand[0];
            theHand[0] = theHand[i];
            theHand[i] = temp;
            }
        }
        
    for(int i=2; i <5; i++){
        if (theHand[1].display_value() > theHand[i].display_value()){
            temp = theHand[1];
            theHand[1] = theHand[i];
            theHand[i] = temp;
            }
        }
        
    for(int i=3; i <5; i++){
        if (theHand[2].display_value() > theHand[i].display_value()){
            temp = theHand[2];
            theHand[2] = theHand[i];
            theHand[i] = temp;
            }
        }
        
   if (theHand[3].display_value() > theHand[4].display_value()){
        temp = theHand[3];
        theHand[3] = theHand[4];
        theHand[4] = temp;
        }
   }
            
    
    public Card[] returnHand(){
        
        return hand; 
    }     
        
}
    
