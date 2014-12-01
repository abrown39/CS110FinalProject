/* Anthony Brown
   CS 110
   HW #5 Question #3
   *greatly modified for Final Project*
*/

public class card
{ 
 //constants for the suits
 public final static int SPADES = 0, HEARTS = 1, DIAMONDS = 2,CLUBS = 3;
 //constants for the ranks
 public final static int ACE = 1,JACK = 11,QUEEN = 12,KING = 13;
 private int suit;
 private int rank;
/**
   Constructor for card
   this."" to keep from shadowing
*/	      	
   card(int rank, int suit)
    {
      this.rank = rank;
      this.suit = suit;
   }
	
   /**
    Gives the cards suit
    @return suit as interger
   */
   public int getSuit() 
   {
      return suit;
    }
    
   /**
    Gives the cards rank
    @return rank as interger
   */   public int getRank() 
   {
      return rank;
   }
  
   /**
    returns the suit description as a String
    @return suit as string
   */
   public String getSuitString() 
   {
     switch (suit) 
     {
         case 0:   
            return "s";
         case 1:   
            return "h";
         case 2:  
            return "d";
         case 3:    
            return "c";
         default:       
            return "Invalid"; // if not 0-3 then invalid
      }
   }
   /**
    Returns the ranks description as a String
    @return rank as a String
   */
   public String getRankString() 
   {
      switch (rank) 
      {
         case 1:   
            return "ace";
         case 2:   
            return "2";
         case 3:   
            return "3";
         case 4:   
            return "4";
         case 5:   
            return "5";
         case 6:   
            return "6";
         case 7:   
            return "7";
         case 8:   
            return "8";
         case 9:   
            return "9";
         case 10:  
            return "10";
         case 11:  
            return "jack";
         case 12:  
            return "queen";
         case 13:  
            return "king";
        default:
        	return "Invalid";//if not 1-13 then invalid statement
      }
   }
         
   /**
    Return card's description for toString
    @return String of card
   */

   public String toString() 
   {
      return getRankString() + " of " + getSuitString();
   }
   
  /**
   Returns the boolean of equals
   @return otherCard if it is equal or not equal to first object
  */  
       
  public boolean equals(card otherCard ) 
   {
      if (this.rank == otherCard.rank)
         return true;
      else
         return false;
   }
  
  /**
   * Returns card's desciption for toName
   * @return String for the fileName accessor
   */

   public String toName() 
   {
      return "cardPics/" + getRankString()+ getSuitString()+".jpg";
   }
   
 }