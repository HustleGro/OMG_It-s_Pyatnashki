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
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.Box;

public class Ratings extends JFrame {
	private static User[] users = new User[13];
	private static String fileName = "tabble.txt";
	
  
  JFrame contentPane;//**************
  private JTable table;
  
  
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

 public void AddToRating(String name, int time, String date){
	 //write(fileName, User[] users);
	 
	 
 }
 
 /*private static void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}*/
 
/* public static User[] read(String fileName) throws FileNotFoundException {
	 File file = new File(fileName);
	    //Этот спец. объект для построения строки
	    StringBuilder sb = new StringBuilder();
	 
	    exists(fileName);
	 
	    try {
	        //Объект для чтения файла в буфер
	    	 BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            //В цикле построчно считываем файл
	            User s;
	            while ((s = in.readLine()) != null) {  //Считывание типа юзер не работает. проблема.
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            //Также не забываем закрыть файл
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	 
	    //Возвращаем полученный текст с файла
	    return sb;
	}*/
 
 
 /*public static void write(String fileName, User[] users) {
	    //Определяем файл
	    File file = new File(fileName);	 
	    try {
	        //проверяем, что если файл не существует то создаем его
	        if(!file.exists()){
	            file.createNewFile();
	        }	 
	        //PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //Записываем текст у файл
	            out.print(users);
	        } finally {
	            //После чего мы должны закрыть файл
	            //Иначе файл не запишется
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}*/
  
  private void initialize() {	  
    contentPane = new JFrame();
//  contentPane.getContentPane().setForeground(SystemColor.windowBorder);
    contentPane.setTitle("Ratings");
    contentPane.setBounds(100, 100, 563, 356); //(х,у,ширина, высота)
    contentPane.setVisible(true);
    contentPane.setResizable(false);
    contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.getContentPane().setLayout(null);
    
    JButton btnNewButton = new JButton("Вернуться в главное меню");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		contentPane.setVisible(false);
    		new InterFaZe();
    	}
    });
    btnNewButton.setBounds(122, 262, 300, 54);
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));//шрифт
    contentPane.getContentPane().add(btnNewButton);
    
    JLabel lblNewLabel = new JLabel("Рейтинг");
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(212, 11, 132, 47);
    contentPane.getContentPane().add(lblNewLabel); 
    
    table = new JTable();
    users[0].setUser("Адольф", 75, "28.05.1945");
    table.setModel(new DefaultTableModel(
    	new Object[][] {
    		{users[0].getName(), users[0].getBestGame(), users[0].getFullTime(), users[0].getDate()},
    		{users[1].getName(), users[1].getBestGame(), users[1].getFullTime(), users[1].getDate()},
    		{users[2].getName(), users[2].getBestGame(), users[2].getFullTime(), users[2].getDate()},
    		{users[3].getName(), users[3].getBestGame(), users[3].getFullTime(), users[3].getDate()},
    		{users[4].getName(), users[4].getBestGame(), users[4].getFullTime(), users[4].getDate()},
    		{users[5].getName(), users[5].getBestGame(), users[5].getFullTime(), users[5].getDate()},
    		{users[6].getName(), users[6].getBestGame(), users[6].getFullTime(), users[6].getDate()},
    		{users[7].getName(), users[7].getBestGame(), users[7].getFullTime(), users[7].getDate()},
    		{users[8].getName(), users[8].getBestGame(), users[8].getFullTime(), users[8].getDate()},
    		{users[9].getName(), users[9].getBestGame(), users[9].getFullTime(), users[9].getDate()},
    		{users[10].getName(), users[10].getBestGame(), users[10].getFullTime(), users[10].getDate()},
    		{users[11].getName(), users[11].getBestGame(), users[11].getFullTime(), users[11].getDate()},
    	},
    	new String[] {
    		"NikName", "\u041B\u0443\u0447\u0448\u0435\u0435 \u0432\u0440\u0435\u043C\u044F", "\u041E\u0431\u0449\u0435\u0435 \u0432\u0440\u0435\u043C\u044F \u0432 \u0438\u0433\u0440\u0435", "\u041F\u043E\u0441\u043B\u0435\u0434\u043D\u044F\u044F \u0438\u0433\u0440\u0430 (\u0434\u0430\u0442\u0430)"
    	}
    ) {
    	Class[] columnTypes = new Class[] {
    		String.class, Integer.class, Integer.class, String.class
    	};
    	public Class getColumnClass(int columnIndex) {
    		return columnTypes[columnIndex];
    	}
    });
    table.getColumnModel().getColumn(1).setPreferredWidth(84);
    table.getColumnModel().getColumn(2).setPreferredWidth(118);
    table.getColumnModel().getColumn(3).setPreferredWidth(126);
    table.setBounds(10, 55, 537, 192);
    contentPane.getContentPane().add(table);
	}
}
