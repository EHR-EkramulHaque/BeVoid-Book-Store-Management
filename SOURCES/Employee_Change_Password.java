import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Employee_Change_Password extends JFrame{
	
	int fileNo, fileIs;
	
	String employee, employee_id, employee_pass, employee_name;
	
	Color BLUE = new Color (68,138,255);
	
	
	public Employee_Change_Password(){
		
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Employee Change Password");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//Frame Close Confirmation
		frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						
						
						frame.setDefaultCloseOperation(Employee_Change_Password.EXIT_ON_CLOSE);
					
					}else{
						frame.setDefaultCloseOperation(Employee_Change_Password.DO_NOTHING_ON_CLOSE);
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
		JLabel ownerName = new JLabel("Ekramul");
		ownerName.setBounds(948,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
//////////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES\\Employye_File_NO.txt");		
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
//Right Gif
		JLabel rightGif = new JLabel(new ImageIcon("Images\\Rigth.gif"));
		rightGif.setBounds(550,20,436,200);
		rightGif.setOpaque(true);
		rightGif.setBackground(Color.RED);
		panel.add(rightGif);


//Enter Current Password
		JLabel current_Password_Label = new JLabel("Enter Current Password");
		current_Password_Label.setBounds(700,230,170,20);
		current_Password_Label.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(current_Password_Label);

	//Text Field
		JTextField currentPassword_Field = new JTextField();
		currentPassword_Field.setBounds(700,250,170,30);
		new TextPrompt("Current Password", currentPassword_Field);
		panel.add(currentPassword_Field);


//Enter New Password
		JLabel new_Password_Label = new JLabel("Enter New Password");
		new_Password_Label.setBounds(700,290,170,20);
		new_Password_Label.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(new_Password_Label);

	//Text Field
		JTextField newPassword_Field = new JTextField();
		newPassword_Field.setBounds(700,310,170,30);
		new TextPrompt("New Password", newPassword_Field);
		panel.add(newPassword_Field);


//Change Password Button
		JButton changePass_Button = new JButton("Change Password");
		changePass_Button.setBounds(710,350,150,30);
		changePass_Button.setFont(new Font("Arial", Font.BOLD, 13));
		changePass_Button.setBackground(Color.WHITE);
		changePass_Button.setFocusPainted(false);
		changePass_Button.setForeground(BLUE);
		changePass_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(changePass_Button);
		
		
		//Add Hover
		changePass_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				changePass_Button.setBackground(BLUE);
				changePass_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				changePass_Button.setBackground(Color.WHITE);
				changePass_Button.setForeground(BLUE);
			}
		});

//Back to Account Button
		JButton back_Button = new JButton();
		back_Button.setBounds(10,521,54,33);
		back_Button.setFont(new Font("Arial", Font.BOLD, 14));
		back_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_Button.setToolTipText("Back");
		back_Button.setContentAreaFilled(false);
		back_Button.setFocusPainted(false);
		back_Button.setBorderPainted(false);
		panel.add(back_Button);



//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Employee_Change_Password.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		



////////////////////////////////////////Aciton Listeners///////////////////////////////////////////////////////
		//Back Button Listener
		back_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Employee_Account();
			} 
		});
		

//////////Change Pass Listener////////////////////////////////////
changePass_Button.addActionListener(new ActionListener(){////////
public void actionPerformed(ActionEvent a){/////////////////////
///////////////////////////////////////////////////////////////

		String currentPass = currentPassword_Field.getText();
		String newPass = newPassword_Field.getText();
		
		
		//Get the Running Employee from running user file
				try{
					File running_user_File = new File("TXT FILES\\Running_User.txt");		
					Scanner scanFile = new Scanner(running_user_File);//Scan File
								
					while(scanFile.hasNext()){
						employee=scanFile.next();
						break;
					}
					scanFile.close();
								
				}catch(Exception f){
					System.out.println("Running user file problem in Account Panel");
				}
		
		
		
		//Match the employee got from running user file with the list of Employees
				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+i+".txt";
								
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
								
						while(scanFile.hasNext()){
							employee_id=scanFile.next();
							employee_pass=scanFile.next();
							employee_name=scanFile.next();
							break;
						}
						scanFile.close();
									
									
						if(employee_id.equals(employee))
						{
							fileIs=i;
							break;
						}
					}catch(Exception f)		{System.out.println("Employee File Problem in employee change pass Panel");}
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
			else if(currentPass.equals(employee_pass)){
				if( (newPass.length()<6) || (newPass.length()>10) )
				{
					JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}else{
					try{
						String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+fileIs+".txt";
						Formatter formatter=new Formatter(User_Information_File_Path);
						
						formatter.format("%s\r\n", employee_id);
						formatter.format("%s\r\n", newPass);
						formatter.format("%s\r\n", employee_name);
					
						formatter.close();	
					}catch(Exception f)		{System.out.println(f);}
					
					JOptionPane.showMessageDialog(null, "Successfully Password Changed","Password Changed",-1,new ImageIcon("Images\\Successful_Icon.png"));
					
					frame.setVisible(false);
					new Employee_Account();
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "Incorrect Current Password","Password Didn't Matched",JOptionPane.WARNING_MESSAGE);
			}


		
///////////////////////////////////////////////////////////////
}});//////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
		
//set Visibility
frame.setVisible(true);
	}
}