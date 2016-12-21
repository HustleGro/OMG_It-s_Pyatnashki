import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
public class Win /*extends JFrame*/ {
	private double time;
  
  private JFrame WinWin;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Win window = new Win(0);
          window.WinWin.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
  public Win(double time) {  
    initialize(time);
    this.time=time;
  }
  
  private void initialize(double time) {
    WinWin = new JFrame();
//  contentPane.getContentPane().setForeground(SystemColor.windowBorder);
    WinWin.setTitle("WIN");
    WinWin.setBounds(100, 100,520, 366); //(х,у,ширина, высота)
    WinWin.setVisible(true);
    WinWin.setResizable(false);
    WinWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton btnNewButton = new JButton("Вернуться в главное меню");
    btnNewButton.setBounds(25, 285, 220, 40);
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		WinWin.dispose();
    		new InterFaZe();
    	}
    });
    
    WinWin.getContentPane().setLayout(null);
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));//шрифт
    btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
       WinWin.getContentPane().add(btnNewButton);
    
    JTextField textField = new JTextField("Неизвестный Герой", 20);
	   textField.setBounds(178, 172, 163, 47);
	textField.setCaretColor(Color.RED);//курсор
	textField.setHorizontalAlignment(JTextField.CENTER);
	textField.setBackground(SystemColor.activeCaption);
	textField.setForeground(Color.BLACK);
	 textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
	WinWin.getContentPane().add(textField);

       
    JLabel lblNewLabel_5 = new JLabel("Результат сохранён!");
   	lblNewLabel_5.setBounds(324, 260, 132, 14);
   	WinWin.getContentPane().add(lblNewLabel_5);
   	lblNewLabel_5.setVisible(false);
 
          JButton btnNewButton_1 = new JButton("Сохранить результат");
          btnNewButton_1.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		new Ratings(new User(textField.getText(), time, time, time));
          		lblNewLabel_5.setVisible(true);
          	}
          });
          btnNewButton_1.setBounds(260, 285, 220, 40);
    btnNewButton_1.setBackground(SystemColor.activeCaption);
    btnNewButton_1.setForeground(Color.DARK_GRAY);
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));//шрифт
    btnNewButton_1.setHorizontalAlignment(SwingConstants.CENTER);
       WinWin.getContentPane().add(btnNewButton_1);
    
    JLabel lblNewLabel = new JLabel("ПОБЕДА!");
    lblNewLabel.setBounds(198, 11, 132, 47);
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    WinWin.getContentPane().add(lblNewLabel); 
    
    JLabel lblNewLabel_1 = new JLabel("Ваше время:"+  (time/1000)+" сек!");
    lblNewLabel_1.setBounds(154, 61, 201, 47);
    lblNewLabel_1.setBackground(SystemColor.menu);
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    WinWin.getContentPane().add(lblNewLabel_1); 

	
	JLabel lblNewLabel_2 = new JLabel("Если желаете сохранить свой результат\r\n");
	lblNewLabel_2.setBounds(146, 102, 244, 14);
	WinWin.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("среди рекордсменов, введите никнейм\r\n");
	lblNewLabel_3.setBounds(154, 119, 236, 14);
	WinWin.getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel(" и сохраните результат");
	lblNewLabel_4.setBounds(198, 136, 143, 14);
	WinWin.getContentPane().add(lblNewLabel_4);
	
	
	  }
	}
