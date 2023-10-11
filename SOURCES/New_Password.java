import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class New_Password{
	
	int fileNo;
	
	Color Dark_Blue = new Color(0, 88, 175);
	Color Light_Blue = new Color(74, 164, 255);
	Color Dark_CYAN = new Color (14,161,177);
	
	int fileIs;
	String user, otp;
	
	String user_username, user_password, user_balance, user_email, user_phone, user_gender, user_name;
	
	
	
	
	
	public New_Password()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Forgot Password -New Password");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Enter New Password
		//Title
		JLabel enterPass_Label = new JLabel("Enter New Password");
		enterPass_Label.setBounds(655,250,190,20);
		panel.add(enterPass_Label);
		
		//Text Field
		JTextField enterPass_Field = new JTextField();
		enterPass_Field.setBounds(650,270,140,30);
		new TextPrompt("Enter New Password", enterPass_Field);
		panel.add(enterPass_Field);

//Change Password Button
		Font ChangePass_Font = new Font ("Arial", Font.BOLD,15);//Font
		
		JButton ChangePass_Button = new JButton("Change Password");
		ChangePass_Button.setBounds(635,310,175,25);
		ChangePass_Button.setFont(ChangePass_Font);
		ChangePass_Button.setFocusPainted(false);
		ChangePass_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ChangePass_Button.setBackground(Dark_Blue);
		ChangePass_Button.setForeground(Color.WHITE);
		
	//Add hover in login button
		ChangePass_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ChangePass_Button.setBackground(Dark_CYAN);
				ChangePass_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ChangePass_Button.setBackground(Dark_Blue);
				ChangePass_Button.setForeground(Color.WHITE);
			}
		});
		panel.add(ChangePass_Button);
		
		

//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\New_Password.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//ActionListener for Change Password button
		ChangePass_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
///////////////////////////////////////

				String password=enterPass_Field.getText();
				if( (password.length()<6) || (password.length()>10) )
				{
					JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					
			//Getting username from file, whice password will be change
					try{
						File admin_file = new File("TXT FILES\\OTP.txt");		
						Scanner scanFile = new Scanner(admin_file);//Scan File
							
						while(scanFile.hasNext()){
							otp=scanFile.next();
							user=scanFile.next();
							break;
						}
						scanFile.close();
							
					}catch(Exception f){
						System.out.println("OTP File has problem in OTP Panel");
					}
						
			//Getting the usernames file
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
								
								
							if(user.equals(user_username))
							{
								fileIs=i;
								break;
							}
						}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
					}
	//////////////////////////////////////////////////Got the File
			//Re-Write the file with new password
					
					String user_password=enterPass_Field.getText();
					try{
							String User_Information_File_Path="TXT FILES/User Information/User--"+fileIs+".txt";
							Formatter formatter=new Formatter(User_Information_File_Path);
							
							formatter.format("%s\r\n", user_username);
							formatter.format("%s\r\n", user_password);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_gender);
							formatter.format("%s\r\n", user_balance);
							formatter.format("%s\r\n", user_name);
							
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}




					

					frame.setVisible(false);
					new Login_Panel();
				}
////////////////////////////////////
			} 
		});
		
		
		
//Set Visibility of frame
frame.setVisible(true);
	}
}