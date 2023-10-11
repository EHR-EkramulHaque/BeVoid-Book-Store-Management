import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Employee_Change_Name{
	
	Color Dark_Blue = new Color(16, 161, 192);
	Color Dark_CYAN = new Color (14,161,177);
	
	String user, employee_ID, employee_pass, employee_name, name;
	
	int fileIs, fileNo;
	
	public Employee_Change_Name()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Employee Change Name");
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
		JLabel ownerName = new JLabel("Tonmoy");
		ownerName.setBounds(947,551,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
//////////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
		String filenumber="";
		try{
			File employeeFile = new File("TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(employeeFile);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			fileNo= Integer.parseInt(filenumber);
			fileNo=fileNo-1;
						
		}catch(Exception f)		{System.out.println("Running Employee file No Reading Problem in Employee change name Panel");}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//First Name Text field
		//Title
		JLabel enterfirstName_Label = new JLabel("Enter New Name");
		enterfirstName_Label.setBounds(700,220,190,20);
		panel.add(enterfirstName_Label);
	
		//Field
		JTextField nameField = new JTextField();
		nameField.setBounds(700,240,170,30);
		new TextPrompt("Enter Your Name", nameField);
		panel.add(nameField);
		


//Change Name Button
		JButton changeName_Button = new JButton("Change Name");
		changeName_Button.setBounds(720,280,130,30);
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
		Back_Button.setToolTipText("Back");
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
				new Employee_Account();
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
					String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+i+".txt";
								
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
								
						while(scanFile.hasNext()){
							employee_ID=scanFile.next();
							employee_pass=scanFile.next();
							employee_name=scanFile.next();
							break;
						}
						scanFile.close();
									
									
						if(employee_ID.equals(user))
						{
							fileIs=i;
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
				}
//Got the all information about Employee|||||Now time to Modify them
				
				
				
				
				
				
				
				
				if( nameField.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Name can not be Empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					
					
					name=nameField.getText();
					int name_Warning=5;
				
					//Check name ok or not
					for(int i=0; i<name.length(); i++)
					{
						if( name.charAt(i)==' ' ){
							name_Warning=1;
							break;
						}
					}
					
					
					if( name_Warning!=5 )
					{
						JOptionPane.showMessageDialog(null,"Name Contain single word only","Password Warning",JOptionPane.WARNING_MESSAGE);
					}
					else{
						try{
							String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+fileIs+".txt";
							Formatter formatter=new Formatter(User_Information_File_Path);
										
							formatter.format("%s\r\n", employee_ID);
							formatter.format("%s\r\n", employee_pass);
							formatter.format("%s\r\n", name);
										
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
									
									
						JOptionPane.showMessageDialog(null, "Name Successfully changed to "+ name,"Successfully Name Changed",-1,new ImageIcon("Images\\Successful_Icon.png"));
						
						frame.setVisible(false);
						new Employee_Account();
						
					}
					
				}
				
			} 
		});


//set Visibility
frame.setVisible(true);
	}
}