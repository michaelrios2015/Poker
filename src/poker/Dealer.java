/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import java.util.Random;
/**
 *
 * @author mike
 */
public class Dealer {
    
    
    
    public void shuffleDeck(Card[] theDeck)
    {
        int[] random = new int[52];
        Card temp;
   
        Random generator = new Random(System.currentTimeMillis());
        
        for(int i = 0; i < 52 ; i++)
        { 
            int r = generator.nextInt(52);
            random[i] = r;
            //System.out.printf("r = %d\n", r);
        }
    
        for (int i = 0; i < 26; i++) //uses random array to shuffle cards
	{
                
                temp = theDeck[i]; //temp holds the card	
                theDeck[i] = theDeck[random[i]]; //a new card is assigned to place i
		theDeck[random[i]] = temp; //old card is reassigned to place random
        }
        
    }
    
        
    //not yet able to deal with all possibilities of flush, or ace as low in straight
    public double evaluateHand(Card[] theHand){
            
        int value = checkFirstCard(theHand), value2 = checkSecondCard(theHand);
           
        int  value3 = checkThirdCard(theHand), value4 = checkFourthCard(theHand); 
        
        if (value == 1){ //first card has no matches
            //System.out.println("first card no match");
                       
            if (value2 == 1){ //1st and 2nd card has no matches
                //System.out.println("second card no match");
                                        
                if (value3 == 1){//1St, 2nd and 3rd card has no matches
                //System.out.println("third card no match");
                           
                    if (value4 == 1){
                        //System.out.println("fourth card no match");
                        if (checkForStraight(theHand) && checkForFlush(theHand)){
                        //System.out.println(whatIsYourHand(100));
                            return (100+theHand[4].display_value()/(double)10);}//YOU HAVE A STRAIGHT FLUSH
                        else if (checkForStraight(theHand)){
                        //System.out.println(whatIsYourHand(60));
                            return (60+theHand[4].display_value()/(double)10);}//YOU HAVE A STRAIGHT
                        else if (checkForFlush(theHand)){
                        //System.out.println(whatIsYourHand(70));
                            return (70+theHand[4].display_value()/(double)10);}//YOU HAVE A FLUSH 
                        else {
                            //no pairs found in hand
                           //System.out.println(whatIsYourHand(20));
                            return (20 + theHand[4].display_value()/(double)10);}//YOU HAVE one high card
                                }
                    else{ // if (value4 == 2){//4TH AND 5TH CARD MATCH, 1 Pair
                    //System.out.println(whatIsYourHand(30));
                    return (30+ theHand[4].display_value()/(double)10);}}
                        
                else if (value3 == 2){//one pair found, cards 3 & 4
                    //System.out.println(whatIsYourHand(30));
                    return (30+theHand[3].display_value()/(double)10);}//3rd and 4th card match 
                else {//3rd, 4th and 5th card match
                    //System.out.println(whatIsYourHand(50));
                    return (50+theHand[4].display_value()/(double)10);}//Three of a kind
                }
            else if (value2 == 2){//2nd and 3rd card match, 1 pair
                //System.out.printf("value3 = %f\n", value3);
                        
                if (value4 == 2){//4th and 5th cards match, 2 pairs
                //System.out.println(whatIsYourHand(40));
                    return (40+theHand[4].display_value()/(double)10);//2 pairs
                }    
                else{//2 & 3 cards match
                    //System.out.println(whatIsYourHand(30));
                    return(30+theHand[2].display_value()/(double)10);//1 pair
                }
            }
                            
                
            else if (value2 == 3){//2nd, 3rd, & 4th cards match
                    //System.out.printf("value2 = %f\n", value2);
                    //System.out.println(whatIsYourHand(50));;
                    return(50+theHand[3].display_value()/(double)10);//3 of a kind
                }
            else{ //(value2 == 4){//2nd, 3rd, 4th, 5th cards match
                    //System.out.println(whatIsYourHand(90));
                    return(90+theHand[4].display_value()/(double)10);//4 of a kind
                }
        }
        
        else if (value == 2){//1st and 2nd cards match, 1 pair
            
            if (value3 == 1){//3rd card has no matches 
                //System.out.printf("value4 = %f\n", value4);
            
                if (value4 == 2){//4th and 5th card match, 2 pairs
                    //System.out.println(whatIsYourHand(40));
                    return (40+theHand[4].display_value()/(double)10);//2 pairs
                }
                else{ //no matches
                    //System.out.println(whatIsYourHand(30));
                    return(30+theHand[1].display_value()/(double)10);}//1 pair
            }
                
            else if (value3 == 2){//3rd and fourth card match, 2 pairs
                //System.out.println(whatIsYourHand(40));
                return (40+theHand[3].display_value()/(double)10);}//2 pairs
            else{//3rd, 4th, and 5th most match you has a full house
                //System.out.println(whatIsYourHand(80));
                return (80+theHand[4].display_value()/(double)10);}}
                        
        else if (value == 3){//1st. 2nd and 3rd card match
            
            if (value4 == 2) //System.out.printf("value = %f\n", value);
            //System.out.println(whatIsYourHand(80));
                return (80+theHand[2].display_value()/(double)10); //you has a full house
            else{
                //System.out.println(whatIsYourHand(50));
                return (50+theHand[2].display_value()/(double)10);//three of a kind
            } 
            }    
            
     
        else {
            //System.out.println(whatIsYourHand(90));
            return (90+theHand[3].display_value()/(double)10);}//you has 4 of a kind
           
}

public String whatIsYourHand(double value){

    if (value == 20.2) //JUST THE HIGH CARD  
        return("a Two");
    else if (value == 20.3)
        return("a Three");
    else if (value == 20.4)
        return("a Four");
    else if (value == 20.5)
        return("a Five");
    else if (value == 20.6)
        return("a Six");
    else if (value == 20.7)
        return("a Seven");
    else if (value == 20.8)
        return("a Eight");
    else if (value == 20.9)
        return("a Nine");
    else if (value == 21)
        return("a Ten");
    else if (value == 21.1)
        return("a Jack");
    else if (value == 21.2)
        return("a Queen");
    else if (value == 21.3)
        return("a King");
    else if (value == 21.4)
        return("an Ace ");
    else if (value == 30.2)//PAIRS 
         return("a pair of Twos");
    else if (value == 30.3)
        return("a pair of Threes");
    else if (value == 30.4)
        return("a pair of Fours");
    else if (value == 30.5)
        return("a pair of Fives");
    else if (value == 30.6)
        return("a pair of Sixes");
    else if (value == 30.7)
        return("a pair of Sevens");
    else if (value == 30.8)
        return("a pair of Eights");
    else if (value == 30.9)
        return("a pair of Nines");
    else if (value == 31)
        return("a pair of Tens");
    else if (value == 31.1)
        return("a pair of Jacks");
    else if (value == 31.2)
        return("a pair of Queens");
    else if (value == 31.3)
        return("a pair of Kings");
    else if (value == 31.4)
        return("a pair of Aces");
    else if (value == 40.3)//TWO PAIRS
       return("two pairs. Threes are the highest pair");
    else if (value == 40.4)
        return("two pairs. Fours are the highest pair");
    else if (value == 40.5)
        return("two pairs. Fives are the highest pair");
    else if (value == 40.6)
        return("two pairs. Sixes are the highest pair");
    else if (value == 40.7)
        return("two pairs. Sevens are the highest pair");
    else if (value == 40.8)
        return("two pairs. Eights are the highest pair");
    else if (value == 40.9)
        return("two pairs. Nines are the highest pair");
    else if (value == 41)
        return("two pairs. Tens are the highest pair");
    else if (value == 41.1)
        return("two pairs. Jacks are the highest pair");
    else if (value == 41.2)
        return("two pairs. Queens are the highest pair");
    else if (value == 41.3)
        return("two pairs. Kings are the highest pair");
    else if (value == 41.4)
        return("two pairs. Aces are the highest pair");
    else if (value == 50.2)// THREE OF A KIND
         return("Three of a kind: Twos");
    else if (value == 50.3)
        return("Three of a kind: Threes");
    else if (value == 50.4)
        return("Three of a kind: Fours");
    else if (value == 50.5)
        return("Three of a kind: Fives");
    else if (value == 50.6)
        return("Three of a kind: Sixes");
    else if (value == 50.7)
        return("Three of a kind: Sevens");
    else if (value == 50.8)
        return("Three of a kind: Eights");
    else if (value == 50.9)
        return("Three of a kind: Nines");
    else if (value == 51)
        return("Three of a kind: Tens");
    else if (value == 51.1)
        return("Three of a kind: Jacks");
    else if (value == 51.2)
        return("Three of a kind: Queens");
    else if (value == 51.3)
        return("Three of a kind: Kings");
    else if (value == 51.4)
        return("Three of a kind: Aces");
    else if (value == 60.6)//STRAIGHT
        return("a straight: Six is the highest card");
    else if (value == 60.7)
        return("a straight: Seven is the highest card");
    else if (value == 60.8)
        return("a straight: Eight is the highest card");
    else if (value == 60.9)
        return("a straight: Nine is the highest card");
    else if (value == 61)
        return("a straight: Ten is the highest card");
    else if (value == 61.1)
        return("a straight: A Jack is the highest card");
    else if (value == 61.2)
        return("a straight: A Queen is the highest card");
    else if (value == 61.3)
        return("a straight: A King is the highest card");
    else if (value == 61.4)
        return("a straight: An Ace is the highest card");
    else if (value == 70.7)//FLUSH
        return("a flush: Seven is the highest card");
    else if (value == 70.8)
        return("a flush: Eight is the highest card");
    else if (value == 70.9)
        return("a flush: Nine is the highest card");
    else if (value == 71)
        return("a flush: Ten is the highest card");
    else if (value == 71.1)
        return("a flush: A Jack is the highest card");
    else if (value == 71.2)
        return("a flush: A Queen is the highest card");
    else if (value == 71.3)
        return("a flush: A King is the highest card");
    else if (value == 71.4)
        return("a flush: An Ace is the highest card");
    else if (value == 80.2)//FULL HOUSE
        return("a full house with three Twos");
    else if (value == 80.3)
        return("a full house with three Threes");
    else if (value == 80.4)
        return("a full house with three Fours");
    else if (value == 80.5)
        return("a full house with three Fives");
    else if (value == 80.6)
        return("a full house with three Sixes");
    else if (value == 80.7)
        return("a full house with three Sevens");
    else if (value == 80.8)
        return("a full house with three Eights");
    else if (value == 80.9)
        return("a full house with three Nines");
    else if (value == 81)
        return("a full house with three Tens");
    else if (value == 81.1)
        return("a full house with three Jacks");
    else if (value == 81.2)
        return("a full house with three Queens");
    else if (value == 81.3)
        return("a full house with three Kings");
    else if (value == 81.4)
        return("a full house with three Aces");
    else if (value == 90.2)//FOUR OF A KIND
        return("Four of a kind: Twos");
    else if (value == 90.3)
        return("Four of a kind: Threes");
    else if (value == 90.4)
        return("Four of a kind: Fours");
    else if (value == 90.5)
        return("Four of a kind: Fives");
    else if (value == 90.6)
        return("Four of a kind: Sixes");
    else if (value == 90.7)
        return("Four of a kind: Sevens");
    else if (value == 90.8)
        return("Four of a kind: Eights");
    else if (value == 90.9)
        return("Four of a kind: Nines");
    else if (value == 91)
        return("Four of a kind: Tens");
    else if (value == 91.1)
        return("Four of a kind: Jacks");
    else if (value == 91.2)
        return("Four of a kind: Queens");
    else if (value == 91.3)
        return("Four of a kind: Kings");
    else if (value == 91.4)
        return("Four of a kind: Aces");    
    else if (value == 100.6)//STRAIGHT FLUSH
        return("a Straight Flush: Six is the highest card");
    else if (value == 100.7)
        return("a Straight Flush: Seven is the highest card");
    else if (value == 100.8)
        return("a Straight Flush: Eight is the highest card");
    else if (value == 100.9)
        return("a Straight Flush: Nine is the highest card");
    else if (value == 101)
        return("a Straight Flush: Ten is the highest card");
    else if (value == 101.1)
        return("a Straight Flush: A Jack is the highest card");
    else if (value == 101.2)
        return("a Straight Flush: A Queen is the highest card");
    else if (value == 101.3)
        return("a Straight Flush: A King is the highest card");
    else if (value == 101.4)
        return("a Straight Flush: An Ace is the highest card");
    else
        return("Error\n");
}

public String seeWhoWon(double value, double value2)
{

    if (value > value2)
        return "The dealer won!!";
    else if (value < value2)
        return "The Player won!!";
    else
        return "It's a Tie!!";
}

private int checkFirstCard(Card[] theHand){ 
    
   int value = 1;
   
      for (int i = 1; i < 5; i++){
             if (theHand[0].display_value() == theHand[i].display_value())
                    value++;}
    return value;
}

private int checkSecondCard(Card[] theHand){ 
    
   int value = 1;
   
      for (int i = 2; i < 5; i++){
                if (theHand[1].display_value() == theHand[i].display_value())
                    value++;}
      
    return value;
}

private int checkThirdCard(Card[] theHand){ 
    
   int value = 1;
   
      for (int i = 3; i < 5; i++){
                if (theHand[2].display_value() == theHand[i].display_value())
                    value++;}
      
    return value;
}

private int checkFourthCard(Card[] theHand){ 
    
   int value = 1;
   
      if (theHand[3].display_value() == theHand[4].display_value())
                    value++;
      
    return value;
}

private boolean checkForStraight(Card[] theHand){ 
    
    int value = 0;
    for (int i = 0; i < 4; i++){
             if ((theHand[i].display_value()+1) == theHand[i+1].display_value()){
                    value++;
                    //System.out.printf("value = %d\n", value);
             }
    }
    if (value == 4)
       return true;
    else
       return false; 
}

private boolean checkForFlush(Card[] theHand){ 
    
    int value = 0;
    for (int i = 0; i < 4; i++){
             if (new String(theHand[i].display_suit()).equals(theHand[i+1].display_suit())){
                    value++;
                    //System.out.printf("value = %d\n", value);
             }
    }
    if (value == 4)
       return true;
    else
       return false; 
}

}