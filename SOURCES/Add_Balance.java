import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Add_Balance{
	
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
//Colors
	Color LIGHT_BLUE = new Color (16,161,192);
	Color Purple = new Color (86,90,136);

	
	
	int fileNo, UsedfileIs;
	int fileIs;
	
	
	
	public Add_Balance()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Recharge Account");
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
//Enter Voucher Code
		JLabel voucher_Label = new JLabel("Enter GiftCard Code");
		voucher_Label.setBounds(700,210,170,20);
		voucher_Label.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(voucher_Label);

	//Text Field
		JTextField voucher_Field = new JTextField();
		voucher_Field.setBounds(700,230,170,30);
		new TextPrompt("GiftCard Code", voucher_Field);
		panel.add(voucher_Field);

//Recharge Button
		JButton recharge_Button = new JButton("Recharge");
		recharge_Button.setBounds(710,270,150,30);
		recharge_Button.setFont(new Font("Arial", Font.BOLD, 14));
		recharge_Button.setBackground(LIGHT_BLUE);
		recharge_Button.setFocusPainted(false);
		recharge_Button.setForeground(Color.WHITE);
		recharge_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(recharge_Button);

		recharge_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				recharge_Button.setBackground(Purple);
				recharge_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				recharge_Button.setBackground(LIGHT_BLUE);
				recharge_Button.setForeground(Color.WHITE);
			}
		});
		
		
		
//Back to Account Button
		JButton backToAccount_Button = new JButton();
		backToAccount_Button.setBounds(21,517,50,30);
		backToAccount_Button.setFont(new Font("Arial", Font.BOLD, 14));
		backToAccount_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backToAccount_Button.setContentAreaFilled(false);
		backToAccount_Button.setFocusPainted(false);
		backToAccount_Button.setBorderPainted(false);
		panel.add(backToAccount_Button);

//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Add_Balance.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
///////////////////////////Action Listeners
		backToAccount_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Account_Panel();
			} 
		});











//ActionListener for Add Balance
//////////////////////////////////////////////////////////////////////////////////////////////////////////
recharge_Button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){///////
////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
//////////////////////////////////////////////////////////////Reading Used Code File NO/////////////////////////////////////////////////////
		String usedfilenumber="";
		try{
			File otp_File = new File("TXT FILES\\Used_Code_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				usedfilenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			UsedfileIs= Integer.parseInt(usedfilenumber);
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
		
		
		
		
		
		
		
		
		
		
		
		
		
		String Entered_Voucher = voucher_Field.getText();
		boolean voucher_Found=false, voucher_used=false;
		
//////////////////////////////////////////////////////////////Getting Running User/////////////////////////////////////////////////////
		try{
			File otp_File = new File("TXT FILES\\Running_User.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File		
			while(scanFile.hasNext()){
				user=scanFile.next();
				break;
			}scanFile.close();		
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Add Balance Panel");}
		
/////////////////////////////////////////////////////Checking Voucher exist or not////////////////////////////////////////////////////
		String voucher_Existing="";
		for(int i=1; i<=30; i++)
		{
			String User_Information_File_Path="TXT FILES\\Gift_Card\\Gift_Card--"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
				
				while(scanFile.hasNext()){
					voucher_Existing=scanFile.next();
					break;
				}
				scanFile.close();
				
							
				if((Entered_Voucher.equals(voucher_Existing)))
				{
					voucher_Found=true;
					break;
				}
			}catch(Exception f)		{System.out.println("Gift card code problem");}
		}
		
/////////////////////////////////////////////////////Checking Voucher used or not////////////////////////////////////////////////////
		String used_Voucher="";
		for(int i=1; i<UsedfileIs; i++)
		{
			String User_Information_File_Path="TXT FILES\\Used_Code\\Used_Code--"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
				
				while(scanFile.hasNext()){
					used_Voucher=scanFile.next();
					break;
				}
				scanFile.close();
				
							
				if((Entered_Voucher.equals(used_Voucher)))
				{
					voucher_used=true;
					break;
				}
			}catch(Exception f)		{System.out.println("Used code file problem");}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(voucher_Field.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Voucher Field can not be Empty","Empty WARNING",JOptionPane.WARNING_MESSAGE);
		}
		else if(voucher_Found==true && voucher_used==false)
		{
/////////////////////////////////////////////////////Getting Running User Info////////////////////////////////////////////////////
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
			

/////////////////////////////////////////////////////Writting Update Balance in user File////////////////////////////////////////////////////
			double user_Balance = Double.parseDouble(user_balance);
			
			double update_Balance = user_Balance+500;
			
			try{
				String User_Information_File_Path="TXT FILES/User Information/User--"+fileIs+".txt";
				Formatter formatter=new Formatter(User_Information_File_Path);
						
				formatter.format("%s\r\n", user_username);
				formatter.format("%s\r\n", user_password);
				formatter.format("%s\r\n", user_email);
				formatter.format("%s\r\n", user_phone);
				formatter.format("%s\r\n", user_gender);
				formatter.format("%s\r\n", ""+update_Balance);
				formatter.format("%s\r\n", user_name);
						
						
						
				formatter.close();	
			}catch(Exception f)		{System.out.println(f);}
			
/////////////////////////////////////////////////////Updating used code file no////////////////////////////////////////////////////
		
		try{
			String User_Information_File_Path="TXT FILES\\Used_Code_File_No.txt";
			Formatter formatter=new Formatter(User_Information_File_Path);
					
			formatter.format("%s", ""+(UsedfileIs+1) );
						
			formatter.close();	
		}catch(Exception f)		{System.out.println(f);}
		
/////////////////////////////////////////////////////Creating Used Codes File////////////////////////////////////////////////////
		
		try{
			String User_Information_File_Path="TXT FILES\\Used_Code\\Used_Code--"+UsedfileIs+".txt";
			Formatter formatter=new Formatter(User_Information_File_Path);
					
			formatter.format("%s", ""+Entered_Voucher );
						
			formatter.close();	
		}catch(Exception f)		{System.out.println(f);}
		
		
		JOptionPane.showMessageDialog(null, "Account Successfully Refill by Tk.500","Successfully Account Refilled",-1,new ImageIcon("Images\\Successful_Icon.png"));
		
		frame.setVisible(false);
		new Account_Panel();
///////////////////////////////////////////////////////////////
		}//Else block end
		else{
			JOptionPane.showMessageDialog(null, "Voucher not exist or already been used. Try another one","Gift Card WARNING",JOptionPane.WARNING_MESSAGE);
		}
		
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////
}});//////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////







//Set Visibility 
frame.setVisible(true);
	}
}