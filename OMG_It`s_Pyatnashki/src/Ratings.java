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
	//addToUsersArray(new User("Adolf",41200,41200,41200));
    initialize();
  }
 
 public Ratings(User user){
	 loadUsersFromFile();
	 Add(user);
 }

 public void AddToRating(User user){
	 int pos= -1;
	 for (int i=0;i<users.length;i++){
		 if (users[i].getName()==user.getName()){
			 users[i].incStat(user.getTime());
			 saveChangesToFile();
			 break;
		 }
		 if (users[i].getBestGame()>user.getTime()){
			 pos=i;
		 }
	 }
	 
	 if (pos!=-1){
		 for (int i=users.length-1;i>0;i--){
			 users[i]=users[i-1];
		 }
		 users[pos]=user;
	 }
 }
 
 public void Add(User user) {
	 addToUsersArray(user);

     saveChangesToFile();
 }
 
 
 
 private void addToUsersArray(User user){
	 if (users.length>13){
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

         for(User tourItem : users) {
             printStream.println(tourItem);
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
    contentPane.setBounds(100, 100, 563, 356); //(С…,Сѓ,С€РёСЂРёРЅР°, РІС‹СЃРѕС‚Р°)
    contentPane.setVisible(true);
    contentPane.setResizable(false);
    contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton btnNewButton = new JButton("Р’РµСЂРЅСѓС‚СЊСЃСЏ РІ РіР»Р°РІРЅРѕРµ РјРµРЅСЋ");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		contentPane.setVisible(false);
    		new InterFaZe();
    	}
    });
    btnNewButton.setBackground(SystemColor.activeCaption);
    btnNewButton.setForeground(Color.DARK_GRAY);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
    
    JLabel lblNewLabel = new JLabel("Р РµР№С‚РёРЅРі");
    lblNewLabel.setBackground(SystemColor.menu);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    JScrollPane scrollPane = new JScrollPane();
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table_1= new JTable(model);
    table_1.setModel(new DefaultTableModel(
    	new Object[][] {
    	},
    	new String[] {
    		"\u0418\u043C\u044F", "\u041B\u0443\u0447\u0448. \u0432\u0440\u0435\u043C\u044F", "\u043F\u043E\u0441\u043B. \u0432\u0440\u0435\u043C\u044F", "\u043E\u0431\u0449. \u0432\u0440\u0435\u043C\u044F"
    	}
    ));
    //int countColumn=table_1.getModel().getColumnCount();
    for(int i=0; i<users.length; i++){
    /*Object [] tab = new Object[countColumn];
    	tab[0]= users[i].getName();
    	tab[1]= users[i].getBestGame();
    	tab[2]= users[i].getTime();
    	tab[3]= users[i].getFullTime();*/
    model.insertRow(i,new Object[]{users[i].getName(),
    		users[i].getBestGame(),
    		users[i].getTime(),
    		users[i].getFullTime()}); 	
    	//((DefaultTableModel)table_1.getModel() 
    }
    scrollPane.setViewportView(table_1);
    GroupLayout groupLayout = new GroupLayout(contentPane.getContentPane());
    groupLayout.setHorizontalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGap(212)
    			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGap(10)
    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGap(122)
    			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
    );
    groupLayout.setVerticalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGap(11)
    			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
    			.addGap(1)
    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
    			.addGap(11)
    			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
    );
    contentPane.getContentPane().setLayout(groupLayout);
    
    
    
  }
}
