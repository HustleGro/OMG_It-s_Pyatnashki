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
	  FrGame.setBounds(100, 100, 800, 500); //(х,у,ширина, высота)
	  FrGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  FrGame.getContentPane().setLayout(null);
    
    JButton btnNewButton = new JButton("Начать заново");
    btnNewButton.setBounds(500, 80, 200, 30);
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));//шрифт
    FrGame.getContentPane().add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Показать подсказку");
    btnNewButton_1.setBounds(500, 120, 200, 30);
    btnNewButton_1.setBackground(SystemColor.activeCaption);
    btnNewButton_1.setForeground(Color.DARK_GRAY);
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));//шрифт
    FrGame.getContentPane().add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("Пауза");
    btnNewButton_2.setBounds(500, 160, 200, 30);
    btnNewButton_2.setBackground(SystemColor.activeCaption);
    btnNewButton_2.setForeground(Color.DARK_GRAY);
    btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));//шрифт
    FrGame.getContentPane().add(btnNewButton_2);
    
    JButton btnNewButton_3 = new JButton("Сдаюсь");
    btnNewButton_3.setBounds(500, 200, 200, 30);
    btnNewButton_3.setBackground(SystemColor.activeCaption);
    btnNewButton_3.setForeground(Color.DARK_GRAY);
    btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));//шрифт
    FrGame.getContentPane().add(btnNewButton_3);
    
    JButton btnNewButton_4 = new JButton("В главное меню");
    btnNewButton_4.setBounds(500, 240, 200, 30);
    btnNewButton_4.setBackground(SystemColor.activeCaption);
    btnNewButton_4.setForeground(Color.DARK_GRAY);
    btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));//шрифт
    FrGame.getContentPane().add(btnNewButton_4);
   
    
    JLabel lblNewLabel = new JLabel("Игра началась");
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(100, 20, 200,30);
    FrGame.getContentPane().add(lblNewLabel); 
   
  }
}
