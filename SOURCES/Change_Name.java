import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Change_Name{
	
	int fileNo;
	
	Color Dark_Blue = new Color(16, 161, 192);
	Color Dark_CYAN = new Color (14,161,177);
	
	int fileIs;
	
	String user, user_username, user_password, user_balance, user_email, user_phone, user_gender, user_name;
	
	
	
	
	
	public Change_Name()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Change Name");
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
//First Name Text field
		//Title
		JLabel enterfirstName_Label = new JLabel("Enter First Name");
		enterfirstName_Label.setBounds(700,220,190,20);
		panel.add(enterfirstName_Label);
	
		//Field
		JTextField firstname_Field = new JTextField();
		firstname_Field.setBounds(700,240,170,30);
		new TextPrompt("First Name", firstname_Field);
		panel.add(firstname_Field);
		
//Last Name Text field
		//Title
		JLabel enterLastName_Label = new JLabel("Enter Last Name");
		enterLastName_Label.setBounds(700,275,190,20);
		panel.add(enterLastName_Label);
	
		//Field
		JTextField lastname_Field = new JTextField();
		lastname_Field.setBounds(700,295,170,30);
		new TextPrompt("Last Name", lastname_Field);
		panel.add(lastname_Field);



//Change Name Button
		JButton changeName_Button = new JButton("Change Name");
		changeName_Button.setBounds(720,340,130,30);
		changeName_Button.setFont(new Font("Arial", Font.BOLD, 13));
		changeName_Button.setBackground(Dark_Blue);
		changeName_Button.setFocusPainted(false);
		changeName_Button.setForeground(Color.WHITE);
		changeName_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(changeName_Button);
		
		//Add Hover
		changeName_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				changeName_Button.setBackground(Dark_CYAN);
				changeName_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				changeName_Button.setBackground(Dark_Blue);
				changeName_Button.setForeground(Color.WHITE);
			}
		});
		
		
//Back Button
		JButton Back_Button = new JButton();
		Back_Button.setBounds(15,520,50,30);
		Back_Button.setFont(new Font("Arial", Font.BOLD, 13));
		Back_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Back_Button.setContentAreaFilled(false);
		Back_Button.setFocusPainted(false);
		Back_Button.setBorderPainted(false);
		panel.add(Back_Button);		
		
//Set Background Image
		ImageIcon Username_Background = new ImageIcon("Images\\Change_Name.jpg");
		
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//////////////////////////////////////////Action Listeners

		Back_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Account_Panel();
			}
		});





		changeName_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
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
					System.out.println("Running user file problem in change name panel");
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
//Got the all information about user|||||Now time to Modify them
				
				
				if( firstname_Field.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "First Name can not be Empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( lastname_Field.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Last Name can not be Empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					user_name=firstname_Field.getText()+" "+lastname_Field.getText();
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
								
								
					JOptionPane.showMessageDialog(null, "Name Successfully changed to "+ user_name,"Successfully Name Changed",-1,new ImageIcon("Images\\Successful_Icon.png"));
					frame.setVisible(false);
					new Account_Panel();
				}
				
			} 
		});


//set Visibility
frame.setVisible(true);
	}
}