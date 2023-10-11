import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class Login_Panel{
	String admin_username, admin_password;
	String user_username, user_password;
	String employee_username, employee_password;
	
	String user,pass;
	boolean user_access,admin_access,employee_access;


	static int position=600;

	static int invalidCount=0;
	int fileNo;
	int employee_fileNo;
	
//Colors
	Color LIGHT_RED = new Color (255,102,102);
	Color LIGHT_BLUE = new Color (51,153,255);
	Color Dark_CYAN = new Color (14,161,177);
	
	
	
	public Login_Panel()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Log In");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//Frame Close Confirmation
		frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						File folder = new File("E:\\CODES\\JAVA\\JAVA Codes\\JAVA Final Project\\SOURCES");
						File fList[] = folder.listFiles();

						for (File f : fList) {
							if (f.getName().endsWith(".class")) {
								f.delete(); 
							}
						}
						
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
///////////////////////////////////////////////////////	

///////////Owner Label 
		JLabel ownerName = new JLabel("Ekramul");
		ownerName.setBounds(948,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);



//////////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			fileNo= Integer.parseInt(filenumber);
			fileNo=fileNo-1;
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
		
		
		
		
//Getting employee file NO
		String empofileNO="";
		try{
			File otp_File = new File("TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				empofileNO=scanFile.next();
				break;
			}
			scanFile.close();
			
			employee_fileNo=Integer.parseInt(empofileNO);
			employee_fileNo-=1;
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//ToolTipText Design
		/* UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12)); */
//Font for user and pass field
		Font PassUser_font = new Font("Times New Roman", Font.PLAIN,14);
		
		
//Username textfield
		JTextField user_field = new JTextField();
		user_field.setBounds(670,260,125,30);
		user_field.setFont(PassUser_font);
		user_field.setOpaque(false);
		user_field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("Username", user_field);
		panel.add(user_field);
		
//Password Field
		JPasswordField pass_field = new JPasswordField();
		pass_field.setBounds(670,334,105,30);
		pass_field.setEchoChar('*');
		pass_field.setOpaque(false);
		pass_field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pass_field.setFont(PassUser_font);
		new TextPrompt("Password", pass_field);
		panel.add(pass_field);
		
		
		
//Hide Icon 
		JButton hide = new JButton(new ImageIcon("Images\\hide.png"));
		hide.setBounds(775,338,22,20);
		hide.setVisible(true);
		hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		hide.setContentAreaFilled(false);
		hide.setFocusPainted(false);
		hide.setBorderPainted(false);
		
		panel.add(hide);

//Unhide Icon 
		JButton unhide = new JButton(new ImageIcon("Images\\unhide.png"));
		unhide.setBounds(775,338,22,20);
		unhide.setVisible(false);
		unhide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		unhide.setContentAreaFilled(false);
		unhide.setFocusPainted(false);
		unhide.setBorderPainted(false);
		
		panel.add(unhide);

		hide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				pass_field.setEchoChar((char) 0);
				hide.setVisible(false);
				unhide.setVisible(true);
				pass_field.requestFocusInWindow();
				
			} 
		});


		unhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				pass_field.setEchoChar('*');//display password
				unhide.setVisible(false);
				hide.setVisible(true);
				pass_field.requestFocusInWindow();
			} 
		});


		
		
		
		
		
		
		
		
		
		
//Login Button
		Font loginFont = new Font ("Arial", Font.BOLD,15);
		JButton login_button = new JButton("Log In");
		login_button.setBounds(672,400,85,25);
		login_button.setFont(loginFont);
		login_button.setFocusPainted(false);
		login_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// login_button.setToolTipText("Login");
		login_button.setBackground(LIGHT_RED);
		login_button.setForeground(Color.WHITE);
		//Make Transparent Button
		/* login_button.setContentAreaFilled(false);
		login_button.setFocusPainted(false);
		login_button.setBorderPainted(false); */
		
	
		
		//Fun
		login_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
									
				//Admin Panel Login Confirmation	
				user=user_field.getText();
				pass=new String(pass_field.getPassword());


				//Get Admin Information
				try{
					File admin_file = new File("TXT FILES\\Admin_Info.txt");		
					Scanner scanFile = new Scanner(admin_file);//Scan File
						
					while(scanFile.hasNext()){
						admin_username=scanFile.next();
						admin_password=scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("Admin File Problem in Login Panel");
				}

				if((user.equals(admin_username)) && (pass.equals(admin_password)))
				{
					admin_access=true;
				}
				else{
					admin_access=false;
				}






				//Get User Information

				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="TXT FILES/User Information/User--"+i+".txt";
						
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
						
						while(scanFile.hasNext()){
							user_username=scanFile.next();
							user_password=scanFile.next();
							break;
						}
						scanFile.close();
							
							
						if((user.equals(user_username)) && (pass.equals(user_password)))
						{
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Login Panel");}
				}
					
				if((user.equals(user_username)) && (pass.equals(user_password)))
				{
					user_access=true;
				}
				else{
					user_access=false;
				}






				//Get Employee Information

				for(int i=1; i<=employee_fileNo; i++)
				{
					String Employee_Information_File_Path="TXT FILES/Employee Information/Employee-"+i+".txt";
						
					try{
						File employee_file = new File(Employee_Information_File_Path);		
						Scanner scanFile = new Scanner(employee_file);//Scan File
						
						while(scanFile.hasNext()){
							employee_username=scanFile.next();
							employee_password=scanFile.next();
							break;
						}
						scanFile.close();
							
							
						if((user.equals(employee_username)) && (pass.equals(employee_password)))
						{
							break;
						}
					}catch(Exception f)		{System.out.println("Employee File Problem in Login Panel");}
				}
					
				if((user.equals(employee_username)) && (pass.equals(employee_password)))
				{
					employee_access=true;
				}
				else{
					employee_access=false;
				}



				if(admin_access==false && user_access==false && employee_access==false){
					//position=600; //672 perfect position


					
					login_button.setBounds(position,400,85,25);
					if(position == 600){position=750;}
					else if(position==750){position=600;}

				}else{

					login_button.setBounds(672,400,85,25);
					
					login_button.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseEntered(java.awt.event.MouseEvent evt) {
							login_button.setBackground(Dark_CYAN);
							login_button.setForeground(Color.WHITE);
						}
			
						public void mouseExited(java.awt.event.MouseEvent evt) {
							login_button.setBackground(LIGHT_RED);
							login_button.setForeground(Color.WHITE);
						}
					});
			
				}


				
		}});
		


		panel.add(login_button);

//Create Account Button
		Font sign_font = new Font("Times New Roman", Font.PLAIN,16);
		
		JButton create_button = new JButton("Create an account");
		create_button.setBounds(645,460,150,17);
		create_button.setToolTipText("Create New Account");
		create_button.setForeground(LIGHT_RED);
		create_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		create_button.setFont(sign_font);
		//Make Transparent Button
		create_button.setContentAreaFilled(false);
		create_button.setFocusPainted(false);
		create_button.setBorderPainted(false);
		
	//Add hover in Creat Account button
		create_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				create_button.setForeground(Dark_CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				create_button.setForeground(LIGHT_RED);
			}
		});
		
		panel.add(create_button);
		
//Forgate Password Button
		Font forgetFont = new Font("Times New Roman", Font.PLAIN,12);
		
		JButton forget_button = new JButton("Forgot Password ?");
		forget_button.setBounds(685,368,125,15);
		forget_button.setToolTipText("Enter to change password");
		forget_button.setForeground(LIGHT_RED);
		forget_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		forget_button.setFont(forgetFont);
		//Make Transparent Button
		forget_button.setContentAreaFilled(false);
		forget_button.setFocusPainted(false);
		forget_button.setBorderPainted(false);
		
	//Add hover in Forgate Password button
		forget_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				forget_button.setForeground(Dark_CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				forget_button.setForeground(LIGHT_RED);
			}
		});
		
		panel.add(forget_button);
		
//Set Background Image
		ImageIcon bg_image = new ImageIcon("Images\\Background_Login_Panel.jpg");
		
		JLabel bg_label = new JLabel(bg_image);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		




















//ActionListener for Create Account Button
		create_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Signup_Panel();
			} 
		});
		
//ActionListener for Forgot Password Button
		forget_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				try{
				new Username();
				}catch(Exception fd)
				{System.out.println("Login Panel user gui call problem");}
			} 
		});
		
		
		
		
		
		
//ActionListener for Login Button
		login_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
//Admin Panel Login Confirmation	
				user=user_field.getText();
				pass=new String(pass_field.getPassword());
				
				
		//Get Admin Information
				try{
					File admin_file = new File("TXT FILES\\Admin_Info.txt");		
					Scanner scanFile = new Scanner(admin_file);//Scan File
						
					while(scanFile.hasNext()){
						admin_username=scanFile.next();
						admin_password=scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("Admin File Problem in Login Panel");
				}
				
				if((user.equals(admin_username)) && (pass.equals(admin_password)))
				{
					admin_access=true;
				}
				else{
					admin_access=false;
				}
				
				
				
				
				
				
		//Get User Information
				
				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="TXT FILES/User Information/User--"+i+".txt";
						
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
						
						while(scanFile.hasNext()){
							user_username=scanFile.next();
							user_password=scanFile.next();
							break;
						}
						scanFile.close();
							
							
						if((user.equals(user_username)) && (pass.equals(user_password)))
						{
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Login Panel");}
				}
					
				if((user.equals(user_username)) && (pass.equals(user_password)))
				{
					user_access=true;
				}
				else{
					user_access=false;
				}
				
				
				
				
				
				
		//Get Employee Information
				
				for(int i=1; i<=employee_fileNo; i++)
				{
					String Employee_Information_File_Path="TXT FILES/Employee Information/Employee-"+i+".txt";
						
					try{
						File employee_file = new File(Employee_Information_File_Path);		
						Scanner scanFile = new Scanner(employee_file);//Scan File
						
						while(scanFile.hasNext()){
							employee_username=scanFile.next();
							employee_password=scanFile.next();
							break;
						}
						scanFile.close();
							
							
						if((user.equals(employee_username)) && (pass.equals(employee_password)))
						{
							break;
						}
					}catch(Exception f)		{System.out.println("Employee File Problem in Login Panel");}
				}
					
				if((user.equals(employee_username)) && (pass.equals(employee_password)))
				{
					employee_access=true;
				}
				else{
					employee_access=false;
				}
				
				
				
				
				
		//Get Login
				if(admin_access)
				{
					
					//Writting the username to running user file
					try{
						Formatter formatter=new Formatter("TXT FILES\\Running_User.txt");
						
						formatter.format("%s", admin_username);
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					
					//writting done
					frame.setVisible(false);
					new Admin_View();
					
				}
				else if(user_access){
					
					//Writting the username to running user file
					try{
						Formatter formatter=new Formatter("TXT FILES\\Running_User.txt");
						
						formatter.format("%s", user_username);
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					
					//writting done
					frame.setVisible(false);
					new Home();
				}
				else if(employee_access){
					
					//Writting the username to running user file
					try{
						Formatter formatter=new Formatter("TXT FILES\\Running_User.txt");
						
						formatter.format("%s", employee_username);
						formatter.close();
						
						
					}catch(Exception f)		{System.out.println(f);}
					
					//writting done
					
					frame.setVisible(false);
					new Employee_View();
					
				}
				else{
					invalidCount++;
					
					if(invalidCount>5){
						JOptionPane.showMessageDialog(null,"You Have Entered wrong Information more than 5 times. Get Out from my Store","WARNING",JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					JOptionPane.showMessageDialog(null, "Enter Valid Username or Password","Login Confirmation",JOptionPane.WARNING_MESSAGE);
				}
				
///////////////////	
			}
		});

//Set Frame as Visible
frame.setVisible(true);

	}
}