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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ratings extends JFrame {
  
  JFrame contentPane;//**************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ratings frame = new Ratings();
					frame.contentPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 public Ratings() {  
    initialize();
  }
  
  private void initialize() {
    contentPane = new JFrame();
//  contentPane.getContentPane().setForeground(SystemColor.windowBorder);
    contentPane.setTitle("Ratings");
    contentPane.setBounds(100, 100, 500, 500); //(х,у,ширина, высота)
    contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.getContentPane().setLayout(null);
    
    JButton btnNewButton = new JButton("Вернуться в главное меню");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		contentPane.setVisible(false);
    		InterFaZe intr = new InterFaZe();
    		intr.frmPyatnashki.setVisible(true);
    	}
    });
    btnNewButton.setBounds(100, 396, 300, 54);
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));//шрифт
    contentPane.getContentPane().add(btnNewButton);
    
    JLabel lblNewLabel = new JLabel("Рейтинг");
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(170, 20, 132, 47);
    contentPane.getContentPane().add(lblNewLabel); 
	}

}
