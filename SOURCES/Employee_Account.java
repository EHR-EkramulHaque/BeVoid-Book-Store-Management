import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Employee_Account{
	
	String user, employee_ID, employee_Pass, employee_Name;
	int empofileNo;
	
	Color Dark_CYAN = new Color (14,161,177);
	
	public Employee_Account(){
		
		
		/////////////Frame creation...........................
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Employee Account");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		/////////////Frame Close Confirmation..............
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
		
			
			
	    //////////////Conteiner creation...............................
			Container panel = new Container();
			panel = frame.getContentPane();
			panel.setLayout(null);
			
			
///////////Owner Label 
		JLabel ownerName = new JLabel("Ekramul");
		ownerName.setBounds(948,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
//////////////////////////////////////////////////////////////Reading Employee File NO/////////////////////////////////////////////////////
		String empofilenumber="";
		try{
			File otp_File = new File("TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				empofilenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			empofileNo= Integer.parseInt(empofilenumber);
			empofileNo=empofileNo-1;
						
		}catch(Exception f)		{System.out.println("Employee file No Reading Problem in Employee Panel");}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
			System.out.println("Running user file problem in Employee Panel");
		}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Match the Employee got from running user file with the list of Employees
		for(int i=1; i<=empofileNo; i++)
		{
			String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					employee_ID=scanFile.next();
					employee_Pass=scanFile.next();
					employee_Name=scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(employee_ID.equals(user))
				{
					break;
				}
			}catch(Exception f)		{System.out.println("Employee File Problem in Username Panel");}
		}
//Got the all information about user|||||Now time to display them

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////
                                 // Jlable-1  //(Set for name)	
			Font font1 = new Font("Arial", Font.BOLD,25);
			JLabel lable1 = new JLabel (employee_Name);
			lable1.setBounds(150,420,150,30);
			lable1.setFont(font1);
			
			
		///////////////////////////////////////////////////////////////////////////
                                 // Jlable-2 //(Set user name)	
			Font font2 = new Font("Arial", Font.PLAIN,18);
			JLabel lable2 = new JLabel ("Employee ID :  "+employee_ID);
			lable2.setBounds(550,422,250,30);
			lable2.setFont(font2);
			
		//////////////////////////////Gif Label////////////////////////////////////
		
			/* JLabel gif_lable = new JLabel (new ImageIcon("Images\\Void Logo.gif"));
			gif_lable.setBounds(520,140,350,200);
			gif_lable.setOpaque(true);
			gif_lable.setBackground(Color.YELLOW);
			panel.add(gif_lable); */
        ///////////////////////////////////////////////////////////////////////////
                                 // Jlable-3  //(Set Password)	
			/* Font font3 = new Font("Arial", Font.PLAIN,18);
			JLabel lable3 = new JLabel ("Password :  "+employee_Pass);
			lable3.setBounds(550,305,300,30);
			lable3.setBackground(Color.YELLOW);
			lable3.setForeground(Color.BLACK);
			lable3.setFont(font3); 
			panel.add(lable3);*/
			
			///////////////////////////////////////////////////////////////////////////
                                
								  
			
			
			panel.add(lable1);
			panel.add(lable2);
			


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		   //Back Batton
		   JButton backbatton = new JButton();
		   backbatton.setBounds(10,530,40,27);
		   backbatton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   backbatton.setToolTipText("Back");
		   panel.add(backbatton);
		   backbatton.setContentAreaFilled(false);
           backbatton.setFocusPainted(false);
           backbatton.setBorderPainted(false);
		   
		   
		   
		   //Change Password Button
			JButton change_password = new JButton("Change Password");
			change_password.setBounds(70,530,150,25);
			change_password.setFont(new Font("Arial", Font.BOLD, 13));
			change_password.setCursor(new Cursor(Cursor.HAND_CURSOR));
			change_password.setBackground(Color.WHITE);
			change_password.setForeground(Dark_CYAN);
		   panel.add(change_password);
		   
		   
		   //Change Name Hover
			change_password.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					change_password.setBackground(Dark_CYAN);
					change_password.setForeground(Color.WHITE);
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					change_password.setBackground(Color.WHITE);
					change_password.setForeground(Dark_CYAN);
				}
			});
		   
		   
		    //Change Name Button
		   JButton changeName_Button = new JButton("Change Name");
		   changeName_Button.setBounds(230,530,150,25);
		   changeName_Button.setFont(new Font("Arial", Font.BOLD, 13));
		   changeName_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   changeName_Button.setBackground(Color.WHITE);
			changeName_Button.setForeground(Dark_CYAN);
		   panel.add(changeName_Button);
		   
		   
		   //Change Name Hover
			changeName_Button.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					changeName_Button.setBackground(Dark_CYAN);
					changeName_Button.setForeground(Color.WHITE);
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					changeName_Button.setBackground(Color.WHITE);
					changeName_Button.setForeground(Dark_CYAN);
				}
			});
		   
		   
		   
		   
//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Employee_Profile.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		   
/////////////////////////////////////Action Listeners////////////////////////////////////////////////
		  backbatton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new Employee_View();
				
			}});
			
			
		   change_password.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new Employee_Change_Password();
				
			}});
		   
		   changeName_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new Employee_Change_Name();
				
			}});
		   
		   
		   
		   frame.setVisible(true);

	}

}	
			
			
		
		

