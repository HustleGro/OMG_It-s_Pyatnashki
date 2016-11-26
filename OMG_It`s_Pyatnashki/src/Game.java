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
import javax.swing.*;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Game {
  
  private JFrame FrGame;
  
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
	  FrGame.setBounds(100, 100, 800, 500); //(�,�,������, ������)
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
    btnNewButton.setBounds(520, 141, 264, 55);
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Показать подсказку");
    btnNewButton_1.setBounds(520, 207, 264, 55);
    btnNewButton_1.setBackground(SystemColor.activeCaption);
    btnNewButton_1.setForeground(Color.DARK_GRAY);
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("Пауза");
    btnNewButton_2.setBounds(520, 273, 264, 55);
    btnNewButton_2.setBackground(SystemColor.activeCaption);
    btnNewButton_2.setForeground(Color.DARK_GRAY);
    btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_2);
    
    JButton btnNewButton_3 = new JButton("Сдаюсь");
    btnNewButton_3.setBounds(520, 339, 264, 55);
    btnNewButton_3.setBackground(SystemColor.activeCaption);
    btnNewButton_3.setForeground(Color.DARK_GRAY);
    btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_3);
    
    JButton btnNewButton_4 = new JButton("В главное меню");
    btnNewButton_4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		FrGame.dispose();
    		new InterFaZe();
    	}
    });
    btnNewButton_4.setBounds(520, 405, 264, 55);
    btnNewButton_4.setBackground(SystemColor.activeCaption);
    btnNewButton_4.setForeground(Color.DARK_GRAY);
    btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));//�����
    FrGame.getContentPane().add(btnNewButton_4);
   
    
    JLabel lblNewLabel = new JLabel("Игра началась...");
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Trajan Pro 3", Font.PLAIN, 23));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(126, 11, 254,72);
    FrGame.getContentPane().add(lblNewLabel); 
   
  }
}
