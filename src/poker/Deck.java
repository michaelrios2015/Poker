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
public class Deck {
   
    private  Card[] cards = new Card[52]; 
    
    public void createDeck(){
    
        for(int i=0; i < 9; i++)
        {
            cards[i] = new Card("Spade", i+2); 
        }   
        
        for(int i=9; i < 13; i++)
        {
            cards[i] = new Card("Spade", i+2); 
        }
        for(int i=13; i < 22; i++)
        {
            cards[i] = new Card("Heart", i-11); 
        }   
     
        for(int i=22; i < 26; i++)
        {
            cards[i] = new Card("Heart", i-11); 
        }
        for(int i=26; i < 35; i++)
        {
            cards[i] = new Card("Diamond", i-24); 
        }   
     
        for(int i=35; i < 39; i++)
        {
            cards[i] = new Card("Diamond", i-24); 
        }
        for(int i=39; i < 48; i++)
        {
            cards[i] = new Card("Club", i-37); 
        }   
     
        for(int i=48; i < 52; i++)
        {
            cards[i] = new Card("Club", i-37); 
        }
        for(int i = 0; i < 4; i++)
        {
            cards[i*13].setName("two");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+1].setName("three");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+2].setName("four");
        }
         for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+3].setName("five");
        }  
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+4].setName("six");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+5].setName("seven");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+6].setName("eight");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+7].setName("nine");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+8].setName("ten");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+9].setName("Jack");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+10].setName("Queen");
        }
        for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+11].setName("King");
        }
         for(int i = 0; i < 4; i++)
        {
            cards[(i*13)+12].setName("Ace");
        }
    }    
    
 
    public void displayDeck(){
          for (int i = 0; i < 52; i++)
        {
            System.out.printf("%s, %s, %d", cards[i].display_suit(), cards[i].display_name(), cards[i].display_value());
            System.out.println();
        }
        
    }  
    
    public Card[] returnDeck(){
        
        return cards; 
    }
    
}

