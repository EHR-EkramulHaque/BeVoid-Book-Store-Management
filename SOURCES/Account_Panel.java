import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Account_Panel{
	
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	
//Colors
	Color LIGHT_RED = new Color (255,102,102);
	Color LIGHT_BLUE = new Color (157,188,224);
	Color Dark_CYAN = new Color (14,161,177);
	
	static int fileNo;
	
	
	
	public Account_Panel()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("My Account");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images/Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//Frame Close Confirmation
		frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
		
		
		
		
		//Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);
/////////////////////////////////////////////////////////
///////////Owner Label 
		JLabel ownerName = new JLabel("Turjo");
		ownerName.setBounds(955,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
//////////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES/User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			fileNo= Integer.parseInt(filenumber);
			fileNo=fileNo-1;
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Get the Running user from running user file
		try{
			File running_user_File = new File("TXT FILES/Running_User.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				user=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running user file problem in Account Panel");
		}
		
		
//Match the user got from running user file with the list of users
		for(int i=1; i<=fileNo; i++)
		{
			String User_Information_File_Path="TXT FILES/User Information/User--"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					user_username=scanFile.next();
					user_password=scanFile.next();
					user_email=scanFile.next();
					user_phone=scanFile.next();
					user_gender=scanFile.next();
					user_balance=scanFile.next();
					user_name=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(user_username.equals(user))
				{
					break;
				}
			}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
		}
//Got the all information about user|||||Now time to display them

/////////////////Upper Buttons
		Font upperButtonFont = new Font ("Arial", Font.BOLD,15);//Upper Buttons Font
//Home Button
		JButton home_Button=new JButton("HOME");  
		home_Button.setBounds(00,00,250,50);  
		home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		home_Button.setFont(upperButtonFont);
		home_Button.setBackground(Dark_CYAN);
		home_Button.setFocusPainted(false);
		home_Button.setForeground(Color.WHITE);
		panel.add(home_Button);

		//Home Button Hover
		home_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				home_Button.setBackground(LIGHT_RED);
				home_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				home_Button.setBackground(Dark_CYAN);
				home_Button.setForeground(Color.WHITE);
			}
		});

//Books Button
		JButton BOOK_Button=new JButton("BOOKS");  
		BOOK_Button.setBounds(250,00,250,50);
		BOOK_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BOOK_Button.setFont(upperButtonFont);
		BOOK_Button.setBackground(Dark_CYAN);
		BOOK_Button.setFocusPainted(false);
		BOOK_Button.setForeground(Color.WHITE);
		panel.add(BOOK_Button);

		//Balance Button Hover
		BOOK_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				BOOK_Button.setBackground(LIGHT_RED);
				BOOK_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				BOOK_Button.setBackground(Dark_CYAN);
				BOOK_Button.setForeground(Color.WHITE);
			}
		});
		
//Account Button
		JButton account_Button=new JButton("ACCOUNT");  
		account_Button.setBounds(500,00,250,50);  
		account_Button.setFont(upperButtonFont);
		account_Button.setFocusPainted(false);
		panel.add(account_Button);
		account_Button.setBackground(LIGHT_RED);
		account_Button.setForeground(Color.BLACK);

//Contact us Button
		JButton contactus_Button=new JButton("CONTACT US");  
		contactus_Button.setBounds(750,00,236,50);  
		contactus_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		contactus_Button.setFont(upperButtonFont);
		contactus_Button.setFocusPainted(false);
		contactus_Button.setBackground(Dark_CYAN);
		contactus_Button.setForeground(Color.WHITE);
		panel.add(contactus_Button);

		//Contact us Button Hover
		contactus_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				contactus_Button.setBackground(LIGHT_RED);
				contactus_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				contactus_Button.setBackground(Dark_CYAN);
				contactus_Button.setForeground(Color.WHITE);
			}
		});
		
		
		
		
		
		
		
///////////////////////////////////////////Information Labels
//Users Name Display
		JLabel nameLabel = new JLabel(user_name);
		nameLabel.setBounds(88,345,280,30);
		nameLabel.setFont(new Font ("Arial", Font.BOLD,30));
		panel.add(nameLabel);
		
//Email Label
		JLabel email_Label = new JLabel("Email           :  "+user_email);
		email_Label.setBounds(450,190,340,20);
		email_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(email_Label);

//Gender Label
		JLabel gender_Label = new JLabel("Gender        :  "+user_gender);
		gender_Label.setBounds(450,230,200,20);
		gender_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(gender_Label);
		

//Phone Number Label
		JLabel phone_Label = new JLabel("Phone          :  "+user_phone);
		phone_Label.setBounds(450,270,250,20);
		phone_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(phone_Label);
		
//Username Label
		JLabel username_label = new JLabel("Username    :  "+user_username);
		username_label.setBounds(450,310,200,20);
		username_label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(username_label);
				

//Balance Label
		JLabel balance_Label = new JLabel("Balance");
		balance_Label.setBounds(810,88,80,25);
		balance_Label.setFont(new Font ("Arial", Font.BOLD,16));
		balance_Label.setForeground(Color.BLACK);
		panel.add(balance_Label);

//Users Balance Display
		JLabel balanceLabel = new JLabel(user_balance);
		balanceLabel.setBounds(884,89,80,20);
		balanceLabel.setFont(new Font ("Arial", Font.BOLD,18));
		balanceLabel.setForeground(Color.BLACK);
		panel.add(balanceLabel);

//Change Password Button
		JButton changePassword_Button = new JButton("Change Password");
		changePassword_Button.setBounds(28,525,165,25);
		changePassword_Button.setFont(new Font ("Arial", Font.PLAIN,16));
		changePassword_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		changePassword_Button.setBackground(Color.WHITE);
		changePassword_Button.setForeground(Dark_CYAN);
		
		panel.add(changePassword_Button);

		changePassword_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				changePassword_Button.setBackground(Dark_CYAN);
				changePassword_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				changePassword_Button.setBackground(Color.WHITE);
				changePassword_Button.setForeground(Dark_CYAN);
			}
		});

//Add Balance Button
		JButton addBalance_Button = new JButton("Add Balance");
		addBalance_Button.setBounds(800,125,155,30);
		addBalance_Button.setFont(new Font ("Arial", Font.BOLD,15));
		addBalance_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addBalance_Button.setBackground(Color.WHITE);
		addBalance_Button.setForeground(Dark_CYAN);
		panel.add(addBalance_Button);
		
		//Set Add Balance Hover
		addBalance_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addBalance_Button.setBackground(Dark_CYAN);
				addBalance_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addBalance_Button.setBackground(Color.WHITE);
				addBalance_Button.setForeground(Dark_CYAN);
			}
		});

//View Cart Button
		JButton viewCart_Button = new JButton("View Cart");
		viewCart_Button.setBounds(805,165,145,30);
		viewCart_Button.setFont(new Font ("Arial", Font.BOLD,15));
		viewCart_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		viewCart_Button.setBackground(Color.WHITE);
		viewCart_Button.setForeground(Dark_CYAN);
		panel.add(viewCart_Button);
		
		//Set Add Balance Hover
		viewCart_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				viewCart_Button.setBackground(Dark_CYAN);
				viewCart_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				viewCart_Button.setBackground(Color.WHITE);
				viewCart_Button.setForeground(Dark_CYAN);
			}
		});


//ChangeName_Button
		JButton ChangeName_Button = new JButton("Change Name");
		ChangeName_Button.setBounds(198,525,165,25);
		ChangeName_Button.setFont(new Font ("Arial", Font.PLAIN,16));
		ChangeName_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ChangeName_Button.setBackground(Color.WHITE);
		ChangeName_Button.setForeground(Dark_CYAN);
		
		panel.add(ChangeName_Button);

		//Change Name Hover
		ChangeName_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ChangeName_Button.setBackground(Dark_CYAN);
				ChangeName_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ChangeName_Button.setBackground(Color.WHITE);
				ChangeName_Button.setForeground(Dark_CYAN);
			}
		});


//Logout Button
		JButton logout_Button = new JButton();
		logout_Button.setBounds(878,525,89,27);
		logout_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		logout_Button.setContentAreaFilled(false);
		logout_Button.setFocusPainted(false);
		logout_Button.setBorderPainted(false);
		panel.add(logout_Button);
		

//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Account_Background.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/////////////////////////////////////////////////Action Listeners///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Home Button action listener
		home_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Home();
			} 
		});
		
		
//Books Button action listener
		BOOK_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new AllBooks();
			} 
		});
		
		
//Contact us Button action listener
		contactus_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Contact_Us();
			} 
		});
		


		
		
		
		
		
		
		
		
		
		
		
		
		
//ActionListener for Logout Button
		logout_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				int result = JOptionPane.showConfirmDialog (null,"Do you want to Logout?", "Logout Confirmation",JOptionPane.YES_NO_OPTION);
					
				if (result == JOptionPane.YES_OPTION){
						
					frame.setVisible(false);
					new Login_Panel();
					
				}
			} 
		});
		
//ActionListener for Change Password Button
		changePassword_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Change_Password();
			} 
		});
		

//ActionListener for Add Balance
		addBalance_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Add_Balance();
			} 
		});

//ActionListener for View Cart
		viewCart_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new View_Cart();
			} 
		});
		
//ActionListener for Change Name Button
		ChangeName_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Change_Name();
			} 
		});
		
		
		
//Set Visibility
frame.setVisible(true);
	}
}