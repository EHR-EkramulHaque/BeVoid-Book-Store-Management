import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Confirm
{
	// int fileNo;
	int total_orderNo, orderfileIs;
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	String order, order_orderID, order_bookName, order_userPhone, order_userEmail, order_quantity, order_price, order_userName, address="";
	
	Color light = new Color(146,193,199);
	Color very_light_Blue = new Color(225,246,255);
	Color dark = new Color(0,159,148);
	public Confirm ()
	{
		//frame
	JFrame fr = new JFrame("Delivery Information");
    fr.setSize(1000,600);
	fr.setLocationRelativeTo(null);
	Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	fr.setIconImage(fr_icon);
	fr.setLayout(null);
	fr.setResizable(false);
	
	fr.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						
						
						fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
		
		
		///////////Owner Label 
		JLabel ownerName = new JLabel("Mahin");
		ownerName.setBounds(957,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		fr.add(ownerName);
	
//Tick_Mark label	
	    JLabel Tick_Mark_Label = new JLabel((new ImageIcon("Images\\Confirm_Page_Giphy.gif")));
		Tick_Mark_Label.setBounds(470,131,53,50);
        Tick_Mark_Label.setOpaque(true);		
		fr.add(Tick_Mark_Label);
///////////////////////////////////////////////////////////////////////////ORDER Information///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Getting TOtal Order NO 
		String orderNo="";
		try{
			File orderFile = new File("TXT FILES\\OrderFileNo.txt");		
			Scanner scanFile = new Scanner(orderFile);//Scan File
						
			while(scanFile.hasNext()){
				orderNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			total_orderNo= Integer.parseInt(orderNo);
			total_orderNo=total_orderNo-1;
						
		}catch(Exception f)		{System.out.println("Problem Running file user in Confirm");}

//Getting Running Order 
		try{
			File running_user_File = new File("TXT FILES\\tempOrder.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				order=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running Order file problem in Confirm Panel");
		}

//Getting Running Order Information
		for(int i=1; i<=total_orderNo; i++)
		{
			String Order_File_NO="TXT FILES\\Order_Info\\Order-"+i+".txt";
						
			try{
				File order_File = new File(Order_File_NO);		
				Scanner scanFile = new Scanner(order_File);//Scan File
						
				while(scanFile.hasNext()){
					order_orderID=scanFile.next();
					order_bookName=scanFile.next();
					order_userPhone=scanFile.next();
					order_userEmail=scanFile.next();
					order_quantity=scanFile.next();
					order_price=scanFile.next();
					order_userName=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(order_orderID.equals(order))
				{
					orderfileIs=i;
					break;
				}
			}catch(Exception f)		{System.out.println("Order File Problem in Confirm Panel");}
		}
		
/////////////////////////////////////////////////////////////////Getting Book Information////////////////////////////////////////////////////////////////////////
//Gtting The Book ID
	String runtxt="";

	try{
			File running_user_File = new File("TXT FILES\\Running_Book.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running txt problem");
		}
		
//Getting Book Info

	String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+runtxt+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					book_Id=scanFile.next();
					book_Price=scanFile.next();
					book_name=scanFile.next();
					book_category=scanFile.next();
					book_path=scanFile.next();
					book_author=scanFile.next()+" "+scanFile.next();
					book_quantity=scanFile.next();
					break;
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("Book Info file problem");}

//Getting Address 
		String addressFile="TXT FILES\\Adresses\\Adress-"+orderfileIs+".txt";
						
			try{
				File address_file = new File(addressFile);		
				Scanner scanFile = new Scanner(address_file);//Scan File
						
				while(scanFile.hasNext()){
					address=address+scanFile.next()+" ";
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("address file problem");}
		
		
		
		
		
		
		
		
		
		UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12));


//Order_id label	
	    JLabel Order_id_label = new JLabel(order_orderID);
		Order_id_label.setBounds(590,229,250,30);
		Order_id_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Order_id_label);
//Name label	
	    JLabel Name_label = new JLabel(order_userName);
		Name_label.setBounds(590,255,250,30);
		Name_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Name_label);
		
//Phone_Number label	
	    JLabel Phone_Number_label = new JLabel(order_userPhone);
		Phone_Number_label.setBounds(590,282,250,30);
		Phone_Number_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Phone_Number_label);
//Email_Address label	
	    JLabel Email_Address_label = new JLabel(order_userEmail);
		Email_Address_label.setBounds(590,309,250,30);
		Email_Address_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Email_Address_label);
//Book_Quantity label	
	    JLabel Book_Quantity_label = new JLabel(order_quantity);
		Book_Quantity_label.setBounds(590,338,250,30);
		Book_Quantity_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Book_Quantity_label);
//Order_Amount label	
	    JLabel Order_Amount_label = new JLabel(order_price);
		Order_Amount_label.setBounds(590,368,250,30);
		Order_Amount_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Order_Amount_label);
//Delivery_address label	
	    JLabel Delivery_address_label = new JLabel(address);
		Delivery_address_label.setBounds(590,395,250,30);
		Delivery_address_label.setFont(new Font ("Arial", Font.BOLD,14));
		fr.add(Delivery_address_label);
		
		
		
//bookname label	
	    JLabel bookname_label = new JLabel(book_name);
		bookname_label.setBounds(210,425,260,50);
		bookname_label.setFont(new Font ("Arial", Font.BOLD,25));
		fr.add(bookname_label);

//photo
		JLabel image_label = new JLabel(new ImageIcon(book_path));
		image_label.setBounds(210,157,179,265);
		fr.add(image_label);
		
//Back_To_Home button
		JButton Back_To_Home_Button = new JButton("Back To Home");
		Back_To_Home_Button.setBounds(462,442,137,30);
		Back_To_Home_Button.setFont(new Font ("Arial", Font.BOLD,14));
		Back_To_Home_Button.setFocusPainted(false);
		Back_To_Home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Back_To_Home_Button.setToolTipText("Back to Home");
		Back_To_Home_Button.setForeground(dark);
		Back_To_Home_Button.setBackground(Color.WHITE);
		fr.add(Back_To_Home_Button);
		
		
		Back_To_Home_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				Back_To_Home_Button.setBackground(very_light_Blue);
				Back_To_Home_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				Back_To_Home_Button.setForeground(dark);
				Back_To_Home_Button.setBackground(Color.WHITE);
			}
		});
		
//Print button
		JButton Print_Button = new JButton("Print");
		Print_Button.setBounds(618,442,137,30);
		Print_Button.setFont(new Font ("Arial", Font.BOLD,14));
		Print_Button.setFocusPainted(false);
		Print_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Print_Button.setToolTipText("Print Invoice");
		Print_Button.setForeground(dark);
		Print_Button.setBackground(Color.WHITE);
		fr.add(Print_Button);
		
		
		Print_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				Print_Button.setBackground(very_light_Blue);
				Print_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				Print_Button.setForeground(dark);
				Print_Button.setBackground(Color.WHITE);
			}
		});
	
//Frame Background	   
	    ImageIcon Username_Background = new ImageIcon("Images\\order-complete.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);
	





















/////////////////////////////////////////////////////////////////////////////Action Listeners
//Back to Home Button Action Listener
		Back_To_Home_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent u){
				fr.setVisible(false);
				new Home();
			}
		});




//Print Button Action Listener
		new Print_Operation(address);
		Print_Button.addActionListener(new Print_Operation());










fr.setVisible(true);
	}
}
