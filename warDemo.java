import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class warDemo extends JFrame
{
   private warGame game;
   private final int WINDOW_WIDTH = 1000;
   private final int WINDOW_HEIGHT = 627;
   private String strCard1, strCard2;
   private ImageIcon back, face1, face2;
   private JLabel your, opp, yourUp, yourDown, oppUp, oppDown, yourPlay, oppPlay;
   private JLabel pile1Msg, pile2Msg, winningMsg, info;
   private int count1, count2;
   private JButton play, deal;
   private boolean reset;
      
   public warDemo(String f)
   {
    super(f);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	 //setContentPane(new JLabel(new ImageIcon("temp.PNG")));
	 //setLayout(new FlowLayout());

    info = new JLabel("War - The Card Game");
    info.setVisible(true);
    info.setFont(new Font("Times New Roman", Font.PLAIN, 40));

    game = new warGame();
   
    deal = new JButton("Start War");
    deal.addActionListener(new Deal());
    deal.setPreferredSize(new Dimension(500,120));
    
    pile1Msg = new JLabel(" ");
	 pile2Msg = new JLabel(" ");
	 pile1Msg.setVisible(false);
	 pile2Msg.setVisible(false);       
	  
	 winningMsg = new JLabel(" ");
	 winningMsg.setVisible(false);
	 winningMsg.setFont(new Font("Times New Roman", Font.PLAIN, 25));
   
    play = new JButton("Next Card");
    play.addActionListener(new Play());
    play.setPreferredSize(new Dimension(100,60));
    play.setVisible(false);
      
    JPanel bottomPanel = new JPanel();    
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
        
    westPanel.setPreferredSize(new Dimension(200, 200));
    eastPanel.setPreferredSize(new Dimension(200, 200));
    northPanel.setPreferredSize(new Dimension(200, 250));
    centerPanel.setPreferredSize(new Dimension(200, 250));
    
    bottomPanel.add(play);
    bottomPanel.add(deal);

    back = new ImageIcon("cardPics/back.jpg");
    your = new JLabel(back);
    opp = new JLabel(back);
    yourUp = new JLabel(back);
    yourPlay = new JLabel(back);
    oppPlay = new JLabel(back);
    oppUp = new JLabel(back);
    yourDown = new JLabel(back);
    oppDown = new JLabel(back);
     
    
    westPanel.add(your);
    westPanel.add(pile1Msg);
    eastPanel.add(opp);
    eastPanel.add(pile2Msg);
    northPanel.add(yourUp);
    centerPanel.add(yourPlay);
    centerPanel.add(oppPlay); 
    northPanel.add(yourDown);
    northPanel.add(oppDown);
    northPanel.add(oppUp);
    bottomPanel.add(winningMsg);
    centerPanel.add(info);
    
    
    
    add(bottomPanel, BorderLayout.SOUTH);
    add(eastPanel, BorderLayout.EAST);
    add(westPanel, BorderLayout.WEST);    
    add(northPanel, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
   
    
   
    your.setVisible(false); 
    opp.setVisible(false);
    yourPlay.setVisible(false);
    oppPlay.setVisible(false); 
    yourUp.setVisible(false);
    oppUp.setVisible(false);
    yourDown.setVisible(false); 
    oppDown.setVisible(false);
       
    setVisible(true);
    }
  
    class Play implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {  
        reset = false;
      
     
        yourDown.setVisible(false); 
        oppDown.setVisible(false);
       
        game.flip();  
        
        strCard1= game.getYourTopCard();
        face1 = new ImageIcon(strCard1);       
        yourPlay.setIcon(face1);
        
        strCard2 = game.getOppTopCard();
        face2 = new ImageIcon(strCard2);       
        oppPlay.setIcon(face2);
        
        yourPlay.setVisible(true);
        oppPlay.setVisible(true);
        
        game.winner();
        winningMsg.setText(game.getWinningMsg());
        winningMsg.setVisible(true);
        
       count1 = game.getYourCount();
       count2 = game.getOppCount();
        
       
       if(count1 < 1 )
       { 
         info.setText("Opponent Wins!");
         info.setVisible(true);
         winningMsg.setVisible(false); 
         your.setVisible(false); 
         opp.setVisible(false);
         yourPlay.setVisible(false);
         oppPlay.setVisible(false); 
         yourUp.setVisible(false);
         oppUp.setVisible(false);
         yourDown.setVisible(false); 
         oppDown.setVisible(false);
         reset = true;
         play.setVisible(false);
         deal.setVisible(true);
       }
            
       else if(count2 < 1 )
       { 
         info.setText("You Win Game Over");
         info.setVisible(true);
         winningMsg.setVisible(false); 
         your.setVisible(false); 
         opp.setVisible(false);

         yourPlay.setVisible(false);
         oppPlay.setVisible(false); 
         yourUp.setVisible(false);
         oppUp.setVisible(false);
         yourDown.setVisible(false); 
         oppDown.setVisible(false);
         reset = true;
         play.setVisible(false);
         deal.setVisible(true);
         }         
       else
         info.setVisible(false);
   
       pile1Msg.setText("Your Card Count: " + count1);
       pile2Msg.setText("Opponent Card Count: " + count2);
       if (count1 > 0 || count2 > 0)           
        if(game.getWarFlag())
          {
             game.cardWar();          
             strCard1= game.getYourUpCard();
             face1 = new ImageIcon(strCard1);       
             yourUp.setIcon(face1);
             strCard2 = game.getOppUpCard();
             face2 = new ImageIcon(strCard2);       
             oppUp.setIcon(face2);
             yourUp.setVisible(true);
             oppUp.setVisible(true);
             yourDown.setVisible(true); 
             oppDown.setVisible(true);
           }
        else
         {  
          yourDown.setVisible(false); 
          oppDown.setVisible(false);
          yourUp.setVisible(false);
          oppUp.setVisible(false);       
          }
       else if(count2 < count1)    
         {info.setText("You Win Game Over");
          info.setVisible(true);}
       else 
          {info.setText("Opponent Game Over");
          info.setVisible(true);}
       
        pile1Msg.setText("Your Card Count: " + count1);
        pile2Msg.setText("Opp Card Count: " + count2);
        winningMsg.setText(game.getWinningMsg());
        winningMsg.setVisible(true);       
        }       
        
     }  
     
     
    class Deal implements ActionListener
   {
    public void actionPerformed(ActionEvent f)
     { 
      if(reset)
      { winningMsg.setVisible(false);
        game = new warGame();
        game.deal();}
      else
       game.deal();
       
       count1 = game.getYourCount();
       count2 = game.getOppCount();
       pile1Msg.setText("Your Card Count: " + count1);
       pile2Msg.setText("Opp Card Count: " + count2);
       pile1Msg.setVisible(true);
       pile2Msg.setVisible(true);       
       your.setVisible(true);
       opp.setVisible(true);
       
       deal.setVisible(false);
       play.setVisible(true);
       info.setVisible(false);
       }
    }               
  
   public static void main(String [] args)
   {  
      new warDemo("War Card Game");
   } 
       
}
