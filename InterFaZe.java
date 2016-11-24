import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterFaZe {

	private JFrame frmPyatnashki;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterFaZe window = new InterFaZe();
					window.frmPyatnashki.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterFaZe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPyatnashki = new JFrame();
		frmPyatnashki.getContentPane().setForeground(SystemColor.windowBorder);
		frmPyatnashki.setTitle("Pyatnashki");
		frmPyatnashki.setBounds(100, 100, 313, 305);
		frmPyatnashki.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPyatnashki.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u041D\u0430\u0447\u0430\u0442\u044C \u0438\u0433\u0440\u0443");
		btnNewButton.setBounds(10, 69, 278, 54);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmPyatnashki.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0412\u044B\u0445\u043E\u0434 \u0438\u0437 \u0438\u0433\u0440\u044B");
		btnNewButton_1.setBounds(10, 199, 278, 54);
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmPyatnashki.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("\u0420\u0435\u0439\u0442\u0438\u043D\u0433\u0438");
		button.setBounds(10, 134, 278, 54);
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmPyatnashki.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("\u041F\u044F\u0442\u043D\u0430\u0448\u043A\u0438");
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(87, 11, 132, 47);
		frmPyatnashki.getContentPane().add(lblNewLabel);
		
	}
}
