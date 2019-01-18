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
public class Card {
     
    private String cardSuit;
    private String cardName;
    private int cardValue; 
    
    public Card(String suit, String name, int value){
        cardSuit = suit;
        cardName = name;
        cardValue = value;
    }
    
    public Card(String suit, int value){
        cardSuit = suit;
        cardValue = value;
    }
    
    public Card(int value){
        cardValue = value;
    }
    
    public Card(String suit){
        cardSuit = suit;
    }
    
    public void setName(String name){
        
        cardName = name;
    }
    
    public String display_suit(){
     
        return cardSuit;
    }
    
    public String display_name(){
     
        return cardName;
    }
    
    public int display_value(){
     
        return cardValue;
    }
}
