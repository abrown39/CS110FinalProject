/**
warGame is the class that has all the functionality 
that puts functionality of deck and card and 
creates the game
*/
public class warGame
{
   private deck Deck; // the deck before it seperates
   private deck yourCards; // ypur deck of cards
   private deck oppCards; //opp deck of cards
   private card yourTopCard, oppTopCard;// top card for your deck and opponents
   private card yourDownCard, oppDownCard;// face down cards for yours and opponents
   private card yourUpCard, oppUpCard;//face up card on field for yours and opponents
   private String winningMsg; // the winning message for the either the match or war
   private boolean warFlag; 

  
  public warGame()
  {
   
      Deck = new deck();         
      Deck.shuffle();
      
  }
   		
  public deck getHand()
   {
    return Deck;
    
   }
   
  public deck getYourHand()
   {
    return yourCards;
    
   }
  
  public deck getOppHand()
   {
    return oppCards;
    
   }
 
   public void deal()
   {
   
      yourCards = new deck();
      yourCards.clear();
   
  
      oppCards = new deck();
      oppCards.clear();
      
  
      for(int i = 0; i < 26; i++)
      {
         yourCards.add(Deck.getTopCard());
         oppCards.add(Deck.getTopCard());
      }
     }

 
    public void flip()
    {
           yourTopCard = yourCards.getTopCard();
           oppTopCard = oppCards.getTopCard();
     }

   public String getYourTopCard()
    {
     return yourTopCard.toName();     
    }
    
  
   public String getOppTopCard()
    {
     return oppTopCard.toName();
     
    }

 
   public String getYourUpCard()
   
   {
     return yourUpCard.toName();
     
    }
 
  public String getOppUpCard()
   {
    return oppUpCard.toName(); 
   }
  
  public int getYourCount()
   {
    return yourCards.size();
   }


   public int getOppCount()
   {
     return oppCards.size();  
   }

   public void winner()
   {
           if (yourTopCard.getRank() < (oppTopCard.getRank())) 
            {
               winningMsg = "Opp Won This One";
               oppCards.add(yourTopCard);
               oppCards.add(oppTopCard);

             }    
            else if (yourTopCard.getRank() > (oppTopCard.getRank()))          
            { 
               winningMsg   = "You Won This One";  
               yourCards.add(yourTopCard);
               yourCards.add(oppTopCard); 
                
            }
            else 
            { 
              winningMsg = "I Declare War!";
              warFlag = true;
            }
                
                     
   }
   
 
   public void cardWar()
   {
          
          yourDownCard = yourCards.getTopCard(); 
          oppDownCard = oppCards.getTopCard();
          yourUpCard = yourCards.getTopCard();
          oppUpCard = oppCards.getTopCard();
            
         if (yourUpCard.getRank() > (oppUpCard.getRank())) 
            {
              winningMsg = "You Won The War";
              yourCards.add(yourTopCard);
              yourCards.add(yourDownCard);
              yourCards.add(yourUpCard);
              yourCards.add(oppTopCard);
              yourCards.add(oppDownCard);
              yourCards.add(oppUpCard);
              warFlag = false;
              yourCards.shuffle();
              oppCards.shuffle();  
            }

          else if (yourUpCard.getRank() < (oppUpCard.getRank()) )         
          {
               winningMsg   = "Opp Won The War";
               oppCards.add(yourTopCard);
               oppCards.add(yourDownCard);
               oppCards.add(yourUpCard);
               oppCards.add(oppTopCard);
               oppCards.add(oppDownCard);
               oppCards.add(oppUpCard);
               warFlag = false;
               yourCards.shuffle();
               oppCards.shuffle();
          } 
          else
          {   
           winningMsg   = "I Declare War Again";
          }
                             
   }

  public boolean getWarFlag()
   {
      return warFlag;
   }

  public String getWinningMsg()
   {
    return winningMsg;
   } 
}   