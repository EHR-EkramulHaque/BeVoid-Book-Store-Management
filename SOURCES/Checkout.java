import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;


public class Checkout
{
	
	int fileNo, orderFileNo, fileIs, addressFileNo;
	int book_Stock;
	String runtxt="";
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	String book_Id, book_Price, book_name, book_category, book_path, book_author, book_quantity;
	String purchase_Quantity, applied_Voucher;
	int quantity;
	
	Color very_light_Blue = new Color(225,246,255);
	Color dark = new Color(0,159,148);

public Checkout()
{
//frame
	JFrame fr = new JFrame("Checkout Summary");
    fr.setSize(1000,600);
	fr.setLocationRelativeTo(null);
	fr.setLayout(null);
	Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	fr.setIconImage(fr_icon);
	fr.setResizable(false);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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


////////////////////////Reading address file no to write address in new file////////////////////////////////////////////////////////
		String addressfile="";
		try{
			File running_user_File = new File("TXT FILES\\Address_NO.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
										
			while(scanFile.hasNext()){
				addressfile=scanFile.next();
				break;
			}
			scanFile.close();
							
			addressFileNo= Integer.parseInt(addressfile);
							
		}catch(Exception f)		{System.out.println("Running txt problem");}
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
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Gtting The Book ID
	

		try{
			File running_user_File = new File("TXT FILES\\Running_Book.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f)		{System.out.println("Running txt problem");}
		
//Getting Quantity and the Voucher Code
		
		try{
			File running_user_File = new File("TXT FILES\\Quantity___Voucher.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				purchase_Quantity=scanFile.next();
				applied_Voucher=scanFile.next();
				break;
			}
			scanFile.close();
			
			quantity= Integer.parseInt(purchase_Quantity);
			
		}catch(Exception f)		{System.out.println("Running txt problem");}
		
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
				
				book_Stock=Integer.parseInt(book_quantity);
				
			}catch(Exception f)		{System.out.println("Book Info file problem");}
			
			
///////Getting User Info	
		for(int i=1; i<=fileNo; i++)
		{
			String user_file_NO="TXT FILES/User Information/User--"+i+".txt";
						
			try{
				File user_file = new File(user_file_NO);		
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
//backbutton
		JButton d1 =new JButton(new ImageIcon());  
        d1.setBounds(22,520,42,30); 
		d1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		d1.setContentAreaFilled(false);
		d1.setFocusPainted(false);
		d1.setBorderPainted(false);  
        fr.add(d1);	
	
//Back Home Button
		JButton back_to_home =new JButton(new ImageIcon());  
        back_to_home.setBounds(18,15,40,30); 
		back_to_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_to_home.setContentAreaFilled(false);
		back_to_home.setFocusPainted(false);
		back_to_home.setBorderPainted(false);
        fr.add(back_to_home);	
	
		double bookPrice=Double.parseDouble(book_Price);
//bookname label	
	    JLabel bookname_label = new JLabel(book_name);//Book Name
		bookname_label.setBounds(130,420,260,50);
		bookname_label.setFont(new Font ("Arial", Font.BOLD,35));
		fr.add(bookname_label);
		
//by label		
		JLabel author_label = new JLabel("by");
		author_label.setBounds(144,472,20,30);
		author_label.setFont(new Font ("Arial", Font.PLAIN,12));
		fr.add(author_label);
		
		JLabel author2_label = new JLabel(book_author);//Author Name
		author2_label.setBounds(160,470,150,30);
		author2_label.setFont(new Font ("Arial", Font.BOLD,16));
		fr.add(author2_label);
		
//Book_Price
	    JLabel Book_Price_label = new JLabel(book_Price);//Book Price//
		Book_Price_label.setBounds(855,209,100,30);
		Book_Price_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Book_Price_label);
				
//Order_Quantity
	    JLabel Order_Quantity_label = new JLabel(purchase_Quantity);//Order_Quantity//
		Order_Quantity_label.setBounds(855,247,100,30);
		Order_Quantity_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Order_Quantity_label);
		
//Subtotal
		double subtotal=bookPrice*quantity;
		
	    JLabel Subtotal_label = new JLabel(""+subtotal);//Subtotal_label//
		Subtotal_label.setBounds(855,283,100,30);
		Subtotal_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Subtotal_label);
		
//Discount		
		double discount;
		
		if(applied_Voucher.equals("BEVOID10")){
			discount=subtotal*0.10;
		}else{
			discount=0.0;
		}
		
		
		JLabel Discount_label = new JLabel(""+discount);//Discount
		Discount_label.setBounds(855,320,100,30);
		Discount_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Discount_label);
		
//Shipping		
		double totalWithDiscount=subtotal-discount;
		double shippingFee=50.00;
		
		JLabel Shipping_label = new JLabel(""+shippingFee);//Shipping
		Shipping_label.setBounds(855,357,100,30);
		Shipping_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Shipping_label);

//Total
		double total=totalWithDiscount+shippingFee;
		
	    JLabel Total_label = new JLabel(""+total);//total
		Total_label.setBounds(855,393,100,30);
		Total_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Total_label);
//photo
		JLabel image_label = new JLabel(new ImageIcon(book_path));
		image_label.setBounds(144,146,179,265);
		fr.add(image_label);
		
		UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12));
		
//Checkout button
		JButton buy_Button = new JButton("Checkout");
		buy_Button.setBounds(705,468,150,30);
		buy_Button.setFont(new Font ("Arial", Font.BOLD,14));
		buy_Button.setFocusPainted(false);
		buy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buy_Button.setToolTipText("Confirm Order");
		buy_Button.setForeground(dark);
		buy_Button.setBackground(Color.WHITE);
		fr.add(buy_Button);
		
		
		buy_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buy_Button.setBackground(very_light_Blue);
				buy_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buy_Button.setForeground(dark);
				buy_Button.setBackground(Color.WHITE);
			}
		});
//Address
		JTextArea address_field = new JTextArea();
		address_field.setBounds(650,101,260,90);
		address_field.setLineWrap(true);
		address_field.setWrapStyleWord(true);
		address_field.setFont(new Font("Arial",Font.PLAIN, 16));
		new TextPrompt("Enter Your Address Here",address_field);
		fr.add(address_field);
		
		
		
		
		
		ImageIcon Username_Background = new ImageIcon("Images\\checkout---Copy.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);
		
		
		
		
		
		
		
		
////////////////////////////////////////////////////////////////Action Listeners///////////////////////////////////////////////////
//Back Button Listener
		d1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Details_Panel();
				
			}
		});
		
//Back to Home Listener
		back_to_home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Home();
				
			}
		});

//Checkout Button Listener
		buy_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
///////////////////////////////////////////////////////////////////////////////////////
				String address=address_field.getText();
				String randomnumber;
				
				double userBalance=Double.parseDouble(user_balance);
				
				//Generate Order No
				Calendar c = Calendar.getInstance();
				SimpleDateFormat ft= new SimpleDateFormat("dd/MM/yyyy");
				String AMPM, date = ft.format(new Date());
				int meridiem= c.get(Calendar.AM_PM);
						
				if(meridiem==1)		{AMPM="PM";}
				else		{AMPM="AM";}
						
				String Time_Date= date+"_"+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+AMPM;
				
				randomnumber=generateOtp(2);
				String orderNUMBER="VOID"+randomnumber+Time_Date;
				////////////////
				
				if( address_field.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Address can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else if(total>userBalance){
					JOptionPane.showMessageDialog(null, "Do not have sufficient balance to order", "Insufficient Balance", JOptionPane.WARNING_MESSAGE);
				}
				else{
					
					int orderConfirmation = JOptionPane.showConfirmDialog (null,"Do you want Confirm the order?", "Order Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (orderConfirmation == JOptionPane.YES_OPTION){
						
////////////////////////Getting order file NO to create new order file////////////////////////////////////
						String orderfile="";
						try{
							File running_user_File = new File("TXT FILES\\OrderFileNo.txt");		
							Scanner scanFile = new Scanner(running_user_File);//Scan File
										
							while(scanFile.hasNext()){
								orderfile=scanFile.next();
								break;
							}
							scanFile.close();
							
							orderFileNo= Integer.parseInt(orderfile);
							
						}catch(Exception f){
							System.out.println("Running txt problem");
						}
///////////////Writting Order Info in file/////////////////////////////////////////////////////////////
						
						try{
							String USER_FILE="TXT FILES\\Order_Info\\Order-"+orderFileNo+".txt";
							Formatter formatter=new Formatter(USER_FILE);
							
							orderFileNo++;
							
							
							
							formatter.format("%s\r\n", orderNUMBER);
							formatter.format("%s\r\n", book_name);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", ""+purchase_Quantity);
							formatter.format("%s\r\n", ""+total);
							formatter.format("%s\r\n", user_name);
							
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
					
/////////////////////Updating Order file NO file/////////////////////////////////////////////////
						try{
							String USER_File="TXT FILES\\OrderFileNo.txt";
							Formatter formatter=new Formatter(USER_File);
							
							formatter.format("%s\r\n", orderFileNo);
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
///////////////////Deducting balance from user file//////////////////////////////////////////////////////
						userBalance-=total;
						user_balance=Double.toString(userBalance);
						
						try{
							String user_FILE="TXT FILES/User Information/User--"+fileIs+".txt";
							Formatter formatter=new Formatter(user_FILE);
							
							formatter.format("%s\r\n", user_username);
							formatter.format("%s\r\n", user_password);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_gender);
							formatter.format("%s\r\n", user_balance);
							formatter.format("%s\r\n", user_name);
							
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
						
						
						JOptionPane.showMessageDialog(null, "Order Successfully Placed","Order Confirmation",-1,new ImageIcon("Images\\Successful_Icon.png"));
/////////////////////Updating Order ID in tempfile/////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT FILES\\tempOrder.txt");
							
							formatter.format("%s\r\n", orderNUMBER);
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
////////////////////////Writting Address for each order////////////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT FILES\\Adresses\\Adress-"+addressFileNo+".txt");
							addressFileNo++;
							
							formatter.format("%s\r\n", address_field.getText());
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
						
////////////////////////Writting address file number for next file////////////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT FILES\\Address_NO.txt");
							
							formatter.format("%s\r\n", addressFileNo);
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
/////////////////////////////Update Book Stock///////////////////////////////////////////////
						book_Stock-=quantity;
						book_quantity=Integer.toString(book_Stock);



						try{
							String user_FILE="TXT FILES\\Book Information\\Book-"+runtxt+".txt";
							Formatter formatter=new Formatter(user_FILE);
							
							formatter.format("%s\r\n", book_Id);
							formatter.format("%s\r\n", book_Price);
							formatter.format("%s\r\n", book_name);
							formatter.format("%s\r\n", book_category);
							formatter.format("%s\r\n", book_path);
							formatter.format("%s\r\n", book_author);
							formatter.format("%s\r\n", book_quantity);
							
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
						
						
						
						
						
						
						
						
						fr.setVisible(false);
						new Confirm();
/////////////////////////////////////////////////////////////////////////////////////////////////////////
					}
					else{
						//Do Nothing
					}
					
				}
				
				
			}
		});
		
		
fr.setVisible(true);
EventQueue.invokeLater( () -> address_field.requestFocusInWindow() );
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