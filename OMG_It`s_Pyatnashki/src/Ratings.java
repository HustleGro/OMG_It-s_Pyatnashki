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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.util.Scanner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Ratings extends JFrame {
	private static User[] users;
	private static String fileName = "tabble.txt";
	
  
  JFrame contentPane;//**************
  private JTable table_1;
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
	loadUsersFromFile(); 
    initialize();
  }
 
 public Ratings(User user){
	 loadUsersFromFile();
	 Add(user);
 }

 public void AddToRating(User user){
	 int pos= -1;
	 for (int i=0;i<users.length;i++){
		 if (users[i].getBestGame()>user.getTime()){
			 pos=i;
			 break;
		 }
	 }
	 
	 if (pos!= -1){
		// if (pos = (users.length - 1)){
			// users[pos]=user;}
		 
		 for (int i=users.length-1;i>pos;i--){
			 users[i]=users[i-1];
		 }
		 users[pos]=user;
	 }
 }
 
 public void sort(){
	 User tmp;
	 for ( int i=0;i<users.length;i++){
		 for( int j=1;j<users.length-i;j++){
			 if (users[j].getBestGame()<users[j-1].getBestGame()){
				tmp=users[j];
				users[j]=users[j-1];
				users[j-1]=tmp;
			 }
		 }
	 }
 }
 
 public void Add(User user) {
	 for (int i=0;i<users.length;i++){
		 if (users[i].getName().equals(user.getName())){
			 users[i].incStat(user.getTime());
			 saveChangesToFile();
			 return;
			 }
		 } 
	 addToUsersArray(user);

     saveChangesToFile();
 }
 
 
 
 private void addToUsersArray(User user){
	 if (users.length>12){
		 AddToRating(user);
	 }else{
	     User[] newUsersArray = new User[users.length + 1];
	     for(int i = 0; i <= users.length - 1; i++)
	     {
	    	 newUsersArray[i] = users[i];
	     }
	     newUsersArray[users.length] = user;
	
	     users = newUsersArray;
	 }
 }
 
 
 private void loadUsersFromFile() {
     try {
         FileInputStream fis = new FileInputStream(fileName);
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

         String strLine;
         List<User> userList = new ArrayList<User>();
         //Read File Line By Line
         while ((strLine = bufferedReader.readLine()) != null){
             String[] fields = strLine.split(";");

             userList.add(new User(fields[0], 
            		 Double.parseDouble(fields[1]), 
            		 Double.parseDouble(fields[2]), 
            		 Double.parseDouble(fields[3])));
         }

         users = new User[userList.size()];
         users = userList.toArray(users);

         bufferedReader.close();
         sort();
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 
 private void saveChangesToFile(){
     PrintStream printStream = null;
     try {
         printStream = new PrintStream(fileName);

         for(User userItem : users) {
             printStream.println(userItem);
         }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } finally {
         printStream.flush();
         printStream.close();
     }
 }
  
  private void initialize() {	  
    contentPane = new JFrame();
//  contentPane.getContentPane().setForeground(SystemColor.windowBorder);
    contentPane.setTitle("Ratings");
    contentPane.setBounds(100, 100, 563, 356); //(РЎвЂ¦,РЎС“,РЎв‚¬Р С‘РЎР‚Р С‘Р Р…Р В°, Р Р†РЎвЂ№РЎРѓР С•РЎвЂљР В°)
    contentPane.setVisible(true);
    contentPane.setResizable(false);
    contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton btnNewButton = new JButton("выход в меню");
    btnNewButton.setBounds(122, 262, 300, 54);
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		contentPane.setVisible(false);
    		new InterFaZe();
    	}
    });
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
    
    JLabel lblNewLabel = new JLabel("Рейтинг");
    lblNewLabel.setBounds(212, 11, 132, 47);
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    

    contentPane.getContentPane().setLayout(null);
    contentPane.getContentPane().add(lblNewLabel);
    contentPane.getContentPane().add(btnNewButton);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 57, 537, 194);
    contentPane.getContentPane().add(scrollPane);
    
    DefaultTableModel model = new DefaultTableModel(new Object[][] {
	},
	new String[] {
		"\u0418\u043C\u044F", "\u041B\u0443\u0447\u0448\u0435\u0435 \u0432\u0440\u0435\u043C\u044F", "\u0412\u0440\u0435\u043C\u044F \u043F\u043E\u0441\u043B\u0435\u0434\u043D\u0435\u0439 \u0438\u0433\u0440\u044B", "\u041E\u0431\u0449\u0435\u0435 \u0432\u0440\u0435\u043C\u044F \u0432 \u0438\u0433\u0440\u0435"
	}
);
    table = new JTable();
    table.setModel(model);
    	
    for(int i=0; i<users.length; i++){
    model.insertRow(i,new Object[]{users[i].getName(),
    		users[i].getBestGame(),
    		users[i].getTime(),
    		users[i].getFullTime()
    		}); 
    }
    scrollPane.setViewportView(table);
    
    
    
  }
}
