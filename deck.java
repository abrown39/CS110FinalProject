import java.util.*;
import java.util.ArrayList;
import java.util.List;
/**
 builds a deck out of cards from "card"
 gives methods for functionality of the deck
*/
public class deck
{
   //creates an array list out of the card
   private ArrayList<card> deck;
  
   //constructor
   public deck()
   {
     //makes a newDeck with new cards in different order
     newDeck();
   }
      
   /**
   no return type - method that creates a new deck by
   proceeding through the suits or a specific rank until
   all of the ranks are finished. From Ace - King, 1 - 13
   */
   public void newDeck()
   {
      deck = new ArrayList<card>();
         
      for (int r = card.ACE; r<=card.KING;r++)
      {
         for (int s = card.SPADES; s<=card.CLUBS;s++)
         {
            deck.add(new card(r,s));
         }
      }
   }
   
   /**
   adds some card to the deck
   no return type
   */  
   public void add(card someCard)
   {
      deck.add(someCard);
   }

   /**
   gets the card at the top
   @param return the removed top card
   */
   public card getTopCard()
   {
      return deck.remove(0);
   }   
   
   /**
   creates the toString for deck
   @param toString of deck
   has to get access from deck first before
   making a further move, hence deck.toString
   */
   public String toString()
   {
      return deck.toString();
   }
   
   /**
   gets the size of the deck
   @param size of deck as a integer
   */
   public int size()
   {
      return deck.size();
   }
   /**
   clear the deck
   no return type
   */  
   public void clear()
   {
      deck.clear();
   }   
   /**
   see's if the deck is empty or not
   @param boolean true or false
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   /**
   shuffle's deck by using Random 
   no return type
   */
   public void shuffle()
   {
      int randNum; // random number to be used
      card temp; // temporary use of the card
      Random r = new Random(); // r used as random object
      //shuffles for the amount of the size of the deck
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }  
    
}