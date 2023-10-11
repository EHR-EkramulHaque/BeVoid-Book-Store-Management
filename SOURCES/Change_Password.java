import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Change_Password{
	
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	
//Colors
	Color LIGHT_ORANGE = new Color (255,182,0);
	Color DARK_ORANGE = new Color (255,138,2);
	
	
	int fileNo;
	int fileIs;
	
	
	
	public Change_Password()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Change Password");
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
/////////////////////////////////////////////////////////
///////////Owner Label 
		JLabel ownerName = new JLabel("Turjo");
		ownerName.setBounds(955,553,40,10);
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
//Enter Current Password
		JLabel current_Password_Label = new JLabel("Enter Current Password");
		current_Password_Label.setBounds(700,180,170,20);
		current_Password_Label.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(current_Password_Label);

	//Text Field
		JTextField currentPassword_Field = new JTextField();
		currentPassword_Field.setBounds(700,200,170,30);
		new TextPrompt("Current Password", currentPassword_Field);
		panel.add(currentPassword_Field);


//Enter New Password
		JLabel new_Password_Label = new JLabel("Enter New Password");
		new_Password_Label.setBounds(700,240,170,20);
		new_Password_Label.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(new_Password_Label);

	//Text Field
		JTextField newPassword_Field = new JTextField();
		newPassword_Field.setBounds(700,260,170,30);
		new TextPrompt("New Password", newPassword_Field);
		panel.add(newPassword_Field);


//Change Password Button
		JButton changePass_Button = new JButton("Change Password");
		changePass_Button.setBounds(710,300,150,30);
		changePass_Button.setFont(new Font("Arial", Font.BOLD, 13));
		changePass_Button.setBackground(LIGHT_ORANGE);
		changePass_Button.setForeground(Color.BLACK);
		changePass_Button.setFocusPainted(false);
		changePass_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(changePass_Button);
		
		
		//Add Hover
		changePass_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				changePass_Button.setBackground(DARK_ORANGE);
				changePass_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				changePass_Button.setBackground(LIGHT_ORANGE);
				changePass_Button.setForeground(Color.BLACK);
			}
		});


//Back to Account Button
		JButton backToAccount_Button = new JButton();
		backToAccount_Button.setBounds(9,524,50,30);
		backToAccount_Button.setFont(new Font("Arial", Font.BOLD, 14));
		backToAccount_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backToAccount_Button.setContentAreaFilled(false);
		backToAccount_Button.setFocusPainted(false);
		backToAccount_Button.setBorderPainted(false);
		panel.add(backToAccount_Button);


//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Change_Password.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		




		
		
		
		
		
		
//////////////////Action Listeners


		backToAccount_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Account_Panel();
			} 
		});
		
		
		

		changePass_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
				
				String currentPass = currentPassword_Field.getText();
				String newPass = newPassword_Field.getText();
//Get the Running user from running user file
				try{
					File running_user_File = new File("TXT FILES\\Running_User.txt");		
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
							fileIs=i;
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
				}
//Got the all information about user|||||Now time to modify them
				
				if(currentPassword_Field.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Password Field can not be Empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(newPassword_Field.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Password Field can not be Empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(currentPass.equals(user_password)){
					if( (newPass.length()<6) || (newPass.length()>10) )
					{
						JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
					}else{
						try{
							String User_Information_File_Path="TXT FILES/User Information/User--"+fileIs+".txt";
							Formatter formatter=new Formatter(User_Information_File_Path);
							
							formatter.format("%s\r\n", user_username);
							formatter.format("%s\r\n", newPass);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_gender);
							formatter.format("%s\r\n", user_balance);
							formatter.format("%s\r\n", user_name);
						
						
						
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
						
						JOptionPane.showMessageDialog(null, "Successfully Password Changed","Password Changed",-1,new ImageIcon("Images\\Successful_Icon.png"));
						frame.setVisible(false);
						new Account_Panel();
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Incorrect Current Password","Password didn't matched",JOptionPane.WARNING_MESSAGE);
				}
				
				
///////////////////////////////////////////////
			} 
		});








//set visibility
frame.setVisible(true);
	}
}