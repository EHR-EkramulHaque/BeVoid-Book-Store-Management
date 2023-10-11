//Mail Classes
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


//Others Classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Username{
	int fileNo;
	String otp;
	
	
	Color Aqua = new Color (46, 255, 255);
	Color Vivid_Blue = new Color (46, 151, 255);
	
//User Info
	String user_username, user_password, user_email, user_phone, user_name, user_gender;
	
	public Username()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Forgot Password");
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
		/* UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12)); */

		
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
//Enter Your Username
		//Title
		JLabel username_Label = new JLabel("Enter Your Username");
		username_Label.setBounds(650,220,150,20);
		username_Label.setFont(new Font ("Arial", Font.PLAIN,15));
		panel.add(username_Label);
		
		//Text Field
		JTextField username_Field = new JTextField();
		username_Field.setBounds(650,240,170,30);
		new TextPrompt("Username", username_Field);
		panel.add(username_Field);

//Get OTP Button
		Font GetOTP_Font = new Font ("Arial", Font.BOLD,15);
		
		JButton getOTP_Button = new JButton("Get OTP");
		getOTP_Button.setBounds(685,280,100,25);
		getOTP_Button.setFont(GetOTP_Font);
		getOTP_Button.setFocusPainted(false);
		getOTP_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getOTP_Button.setBackground(Aqua);
		getOTP_Button.setForeground(Color.BLACK);
		
	//Add hover in login button
		getOTP_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				getOTP_Button.setBackground(Vivid_Blue);
				getOTP_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				getOTP_Button.setBackground(Aqua);
				getOTP_Button.setForeground(Color.BLACK);
			}
		});
		panel.add(getOTP_Button);


//Back Button 
		JButton back_Button = new JButton();
		back_Button.setBounds(12,524,48,30);
		back_Button.setFocusPainted(false);
		back_Button.setToolTipText("Back");
		back_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		back_Button.setContentAreaFilled(false);
        back_Button.setFocusPainted(false);
        back_Button.setBorderPainted(false);
		   
		panel.add(back_Button);

//Set Background Image
		ImageIcon Username_Background = new ImageIcon("Images\\Username_Background.jpg");
		
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);








////////////////////////////////////////////////////////////////////////////////////////////////////////////
//back Button Listener
		back_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new Login_Panel();
				
			}
		});


//ActionListener for Get OTP Button
		getOTP_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent w){

/////////////////////////////////////////////////////////////////////
				//Get User Information
				
				String user=username_Field.getText();
				
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
							break;
						}
						scanFile.close();
							
							
						if(user.equals(user_username))
						{
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
				}
					
					
					
				if(user.equals(user_username))
				{
			//Writing OTP in File
					try{
						Formatter formatter=new Formatter("TXT FILES\\OTP.txt");
						
						otp=generateOtp(4);//Getting OTP
						
						formatter.format("%s\r\n", otp);
						formatter.format("%s\r\n", user_username);
						formatter.close();	
						
					}catch(Exception f)		{System.out.println(f);}
					
			//Sending email in user Account
					try{
						Mail mail = new Mail();
						mail.setupServerProperties();
						mail.draftEmail(user_email,"BeVoid Bookshop OTP", "Your One Time Password is "+otp);
						mail.sendEmail();						
					}catch(Exception tata){
						System.out.println("mail send problem");
					}
			
			
			

					JOptionPane.showMessageDialog(null, "An OTP has been send to "+user_email,"OTP send to email account",-1,new ImageIcon("Images\\Successful_Icon.png"));
					
					frame.setVisible(false);
					new OTP();
				 
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Enter a valid Username","Username NOT Found",JOptionPane.WARNING_MESSAGE);
				}
				
				
				
				
				
				
//////////////////
			}
		});
		

//Set Frame as Visible
frame.setVisible(true);
	}
	
	
	private String generateOtp(int otpLength){
		SplittableRandom split = new SplittableRandom();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<otpLength; i++){
			sb.append(split.nextInt(0,10));
		}
		return sb.toString();
	}
}