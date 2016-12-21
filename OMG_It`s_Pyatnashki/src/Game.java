import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.util.Random;
import java.awt.TextArea;

public class Game extends JFrame{
  
  private JFrame FrGame;
  private int[][] fishki = new int[4][4];
  private JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));
  private static Random ramdomizer = new Random();
  private double lastTime;
  private double firstTime;
  private double AllTime;
  private static double timeGame;
  private  javax.swing.Timer time;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Game window = new Game();
          window.FrGame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
        
      }
    });
  }
  
  public Game() {  
    initialize();
  }
  
  

  
  private void initialize() {
	  FrGame = new JFrame();
//  contentPane.getContentPane().setForeground(SystemColor.windowBorder);
	  FrGame.setTitle("Game");
	  FrGame.setBounds(100, 100, 688, 501); //(�,�,������, ������)
	  FrGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  FrGame.setResizable(false);
	  FrGame.setVisible(true);
	  FrGame.getContentPane().setLayout(null);
	  
	  
    
    JButton btnNewButton = new JButton("Начать заново");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		FrGame.dispose();
    		new Game();
    	}
    });
    btnNewButton.setBounds(407, 141, 264, 55);
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Показать подсказку");
    btnNewButton_1.setEnabled(false);
    btnNewButton_1.setBounds(407, 207, 264, 55);
    btnNewButton_1.setBackground(SystemColor.activeCaption);
    btnNewButton_1.setForeground(Color.DARK_GRAY);
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("Пауза");
    btnNewButton_2.setBounds(407, 273, 264, 55);
    btnNewButton_2.setBackground(SystemColor.activeCaption);
    btnNewButton_2.setForeground(Color.DARK_GRAY);
    btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    
    btnNewButton_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		lastTime = System.currentTimeMillis();
    		AllTime = lastTime-firstTime;
    		repaintField(false);
    		time.stop();
    		btnNewButton_2.setVisible(false);
    		
    		JButton btnNewButton_3 = new JButton("Продолжить");
    		btnNewButton_3.setBounds(407, 273, 264, 55);
    	    btnNewButton_3.setBackground(SystemColor.activeCaption);
    	    btnNewButton_3.setForeground(Color.DARK_GRAY);
    	    btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    	    btnNewButton_3.addActionListener(new ActionListener() {
    	    	public void actionPerformed(ActionEvent e) {
    	    		repaintField(true);
    	    		time.start();
    	    		btnNewButton_2.setVisible(true);
    	    		firstTime = System.currentTimeMillis();
    	    	}
    	    });
    	    FrGame.getContentPane().add(btnNewButton_3);
    		
    	}
    });
    FrGame.getContentPane().add(btnNewButton_2);
    
    
    
    
    JButton btnNewButton_3 = new JButton("Сдаюсь");
    btnNewButton_3.setEnabled(false);
    btnNewButton_3.setBounds(407, 339, 264, 55);
    btnNewButton_3.setBackground(SystemColor.activeCaption);
    btnNewButton_3.setForeground(Color.DARK_GRAY);
    btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_3);
    
    JButton btnNewButton_4 = new JButton("В главное меню");
    btnNewButton_4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		timeGame=0;
    		FrGame.dispose();
    		new InterFaZe();
    	}
    });
    btnNewButton_4.setBounds(407, 405, 264, 55);
    btnNewButton_4.setBackground(SystemColor.activeCaption);
    btnNewButton_4.setForeground(Color.DARK_GRAY);
    btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_4);
   
    
    JLabel lblNewLabel = new JLabel("Игра началась...");
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Trajan Pro 3", Font.PLAIN, 23));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(79, 11, 254,55);
    FrGame.getContentPane().add(lblNewLabel); 
    
    //JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));
    panel.setForeground(Color.LIGHT_GRAY);
    panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), Color.LIGHT_GRAY, SystemColor.activeCaptionBorder, SystemColor.control));
    panel.setBounds(10, 73, 387, 387);
    
    Container container = FrGame.getContentPane();
    
    JLabel lblNewLabel_1 = new JLabel(""); 
    lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
    lblNewLabel_1.setBounds(513, 34, 116, 26); 
    time = new javax.swing.Timer( 500,
    		new ActionListener(){
            public void actionPerformed(ActionEvent e) {            	
            	lblNewLabel_1.setText(Double.toString(timeGame));
                timeGame+=0.5;               
            }
        });
    FrGame.getContentPane().add(lblNewLabel_1);
    time.start();
    
    panel.setDoubleBuffered(true);
    container.add(panel);    
    FrGame.getContentPane().add(panel);
    panel.setDoubleBuffered(true);
    
    generate();
    repaintField(true);
    

    firstTime = System.currentTimeMillis();
    

    
   
  }
  
  
  
  
  public void generate() {
      int[] invariants = new int[16];
      
      

      do {
          for (int i = 0; i < 4; i++) {
              for (int j = 0; j < 4; j++) {
                  fishki[i][j] = 0;
                  invariants[i * 4 + j] = 0;
              }
          }

          for (int i = 1; i < 16; i++) {
              int k, l;
              do {
                  k = ramdomizer.nextInt(4);
                  l = ramdomizer.nextInt(4);
              }
              while (fishki[k][l] != 0);
              fishki[k][l] = i;
              invariants[k * 4 + l] = i;
          }
      }
      while (!canBeSolved(invariants));
      repaintField(true);
  }

  private boolean canBeSolved(int[] invariants) {
      int sum = 0;
      for (int i = 0; i < 16; i++) {
          if (invariants[i] == 0) {
              sum += Math.ceil(i / 4);
              continue;
          }

          for (int j = i + 1; j < 16; j++) {
              if (invariants[j] < invariants[i])
                  sum ++;
          }
      }
      System.out.println(sum % 2 == 0);
      return sum % 2 == 0;
  }
  

  public void repaintField(boolean setable) {
	  panel.removeAll();

      for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
              JButton button = new JButton(Integer.toString(fishki[i][j]));
              button.setFocusable(false);
              panel.add(button);
              button.setFont(new Font("Verdana", Font.BOLD, 20));
              button.setVisible(true);
              if (fishki[i][j] == 0) {
                  button.setVisible(false);
              } else{
                  button.addActionListener(new ClickListener());
                  if (setable == false){
                	  button.setEnabled(false);
                	  
                  }
          }
      }

  	}
  }
  private class ClickListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          JButton button = (JButton) e.getSource();
          button.setVisible(false);
          String name = button.getText();
          change(Integer.parseInt(name));
      }
  }
  
  public boolean checkWin() {
      boolean status = true;

      for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
              if (i == 3 && j > 2)
                  break;
              if (fishki[i][j] != i * 4 + j + 1) {
            	  status = false;
              }
          }
      }
      //System.out.println("processing "+status);
      return status;
  }
  
  public void change(int num) {
      int i = 0;
      int j = 0;
      for (int k = 0; k < 4; k++) {
          for (int l = 0; l < 4; l++) {
              if (fishki[k][l] == num) {
                  i = k;
                  j = l;
              }
          }
      }
      if (i > 0) {
          if (fishki[i - 1][j] == 0) {
        	  fishki[i - 1][j] = num;
        	  fishki[i][j] = 0;
          }
      }
      if (i < 3) {
          if (fishki[i + 1][j] == 0) {
        	  fishki[i + 1][j] = num;
        	  fishki[i][j] = 0;
          }
      }
      if (j > 0) {
          if (fishki[i][j - 1] == 0) {
        	  fishki[i][j - 1] = num;
              fishki[i][j] = 0;
          }
      }
      if (j < 3) {
          if (fishki[i][j + 1] == 0) {
        	  fishki[i][j + 1] = num;
        	  fishki[i][j] = 0;
          }
      }
      
      //if((fishki[0][0] == 1) && (fishki[3][2]) == 15){
    	  
    	  checkWin();
    	  if (checkWin()){
    		  lastTime = System.currentTimeMillis();
    		  repaintField(false);
      		AllTime = lastTime-firstTime;
    		  time.stop();
    		  new Win(AllTime);
    		  
    	  }else{
    		  repaintField(true);
    	  }
     // }
    	  
  }
 
}	



  
