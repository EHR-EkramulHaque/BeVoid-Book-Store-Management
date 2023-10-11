import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;
import java.text.*;

public class Cart_Checkout{	
	
	
	
	Color very_light_Blue = new Color(225,246,255);
	Color dark = new Color(0,159,148);
	Color LIGHT_BLUE = new Color(225,246,255);
	
	
	int fileNo, fileIs, orderFileNo, addressFileNo, bookfileIs, bookfileNo;
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	String book_ID, book_PRICE, book_NAME, book_CATEGORY, book_PATH, book_AUTHOR, book_QUANTITY;
	
	String book_Id, book_name, book_Price, carted_quantity;
	String applied_Voucher;
	
	
	int cartFileNo;
	double subtotal;
	int totalQuantity;
	
	public Cart_Checkout()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Checkout Summary");
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
		panel.setLayout(null);																									//////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////Owner Label 
		JLabel ownerName = new JLabel("Ekramul");
		ownerName.setBounds(948,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
		
		/* UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12)); */
		
		
//backbutton
		JButton back_Button =new JButton(new ImageIcon());  
        back_Button.setBounds(22,520,42,30); 
		back_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_Button.setToolTipText("Back to Cart");
		back_Button.setContentAreaFilled(false);
		back_Button.setFocusPainted(false);
		back_Button.setBorderPainted(false);  
        panel.add(back_Button);	
	
//Back Home Button
		JButton back_to_home =new JButton(new ImageIcon());  
        back_to_home.setBounds(18,15,40,30); 
		back_to_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_to_home.setToolTipText("Back to Home");
		back_to_home.setContentAreaFilled(false);
		back_to_home.setFocusPainted(false);
		back_to_home.setBorderPainted(false);
        panel.add(back_to_home);	
		
		
		
//Checkout button
		JButton checkout_Button = new JButton("Checkout");
		checkout_Button.setBounds(705,468,150,30);
		checkout_Button.setFont(new Font ("Arial", Font.BOLD,14));
		checkout_Button.setFocusPainted(false);
		checkout_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkout_Button.setToolTipText("Confirm Order");
		checkout_Button.setForeground(dark);
		checkout_Button.setBackground(Color.WHITE);
		panel.add(checkout_Button);
		
		
		checkout_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				checkout_Button.setBackground(very_light_Blue);
				checkout_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				checkout_Button.setForeground(dark);
				checkout_Button.setBackground(Color.WHITE);
			}
		});
		
//Address
		JTextArea address_field = new JTextArea();
		address_field.setBounds(650,101,260,90);
		address_field.setLineWrap(true);
		address_field.setWrapStyleWord(true);
		address_field.setFont(new Font("Arial",Font.PLAIN, 16));
		new TextPrompt("Enter Your Address Here",address_field);
		panel.add(address_field);
		
		
		
		




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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//Getting running cart file
		String cartfile="";
		try{
			File user_file = new File("TXT_CART\\Running_Cart_File.txt");		
			Scanner scanFile = new Scanner(user_file);//Scan File
						
			while(scanFile.hasNext()){
				cartfile=scanFile.next();
				break;
			}
			scanFile.close();
			
			int FileNo = Integer.parseInt(cartfile);
			
			cartFileNo = FileNo-1;
			
		}catch(Exception f)		{System.out.println("Reading Running_Cart_File problem in view cart");}
		
		
////////////////////////Reading address file no to write address in new file////////////////////////////////////////////////////////
		String addressfile="";
		try{
			File running_user_File = new File("TXT_CART\\Cart_Address_No.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
										
			while(scanFile.hasNext()){
				addressfile=scanFile.next();
				break;
			}
			scanFile.close();
							
			addressFileNo= Integer.parseInt(addressfile);
							
		}catch(Exception f)		{System.out.println("Running txt problem");}
		
////////////////////////////////////////////////////////////Table Releted work/////////////////////////////////////////////////////////////////////////////////////
		String FILENO="";
		try{
			File running_user_File = new File("TXT FILES\\Book_File_No.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
								
			while(scanFile.hasNext()){
						
						
				FILENO=scanFile.next();
				break;
			}
			scanFile.close();
			
			bookfileNo=Integer.parseInt(FILENO);
			
		}catch(Exception f)		{System.out.println("Running user file in cart checkout problem");}
////////////////////////////////////////////////////////////Table Releted work/////////////////////////////////////////////////////////////////////////////////////
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,210,482,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		panel.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,229,482,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		panel.add(label_Row);
		
		
		//Book Name label;
		JLabel bookName_label =new JLabel("Book Name");
		bookName_label.setBounds(75,210,100,20);
		panel.add(bookName_label);//
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(220,210,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		panel.add(label_colum1);
		
		// Book Price label;
		JLabel bookPrice_label =new JLabel("Book Price");
		bookPrice_label.setBounds(255,210,120,20);
		panel.add(bookPrice_label);
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(356,210,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		panel.add(label_colum2);
		
		//Category label;
		JLabel quantity_Label =new JLabel("Quantity");
		quantity_Label.setBounds(400,210,100,20);
		panel.add(quantity_Label);//
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(491,210,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		panel.add(label_colum5);
		
		
///////////////////////////////////////////////////////////////
		
		
		
		//for table;
		String order_data[][] = new String [cartFileNo][3];
		
		for(int row=0; row<cartFileNo; row++)
		{
			for(int col=0; col<=2; col++)
			{
					String User_Information_File_Path="TXT_CART\\Temp_Cart\\Cart--"+(row+1)+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
						
						while(scanFile.hasNext()){
							book_Id=scanFile.next();
							book_name=scanFile.next();
							book_Price=scanFile.next();
							carted_quantity=scanFile.next();
							break;
						}
						scanFile.close();
						
						if(col==0){
							order_data[row][col]=book_name;
						}
						else if(col==1){
							order_data[row][col]=book_Price;
						}
						else if(col==2){
							order_data[row][col]=carted_quantity;
							
							int QUANTITY = Integer.parseInt(carted_quantity);
							totalQuantity= totalQuantity+QUANTITY;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("Reading Carted Files problem in cart view");}
				
			}
		}
				
		
		
		
		String table_colume[] ={"Book Name","Book Price","Quantity"};
		JTable cart_table = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		cart_table.setBounds(10,230,482,100);
		cart_table.setRowHeight(20);
		cart_table.setBackground(LIGHT_BLUE);		
		
		panel.add(cart_table);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		cart_table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		cart_table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		cart_table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		
		
		TableColumnModel tcm =cart_table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 90 );
		tcm.getColumn(1).setPreferredWidth( 10 );
		tcm.getColumn(2).setPreferredWidth( 10 );
////////////////////////////////////////////////////Table Releted Task Done///////////////////////////////////////////////////////////////////////////////////

		//Getting Applied Voucher Code
		String tempSubtotal="";
		try{
			File running_user_File = new File("TXT_CART\\Voucher.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				
				
				tempSubtotal=scanFile.next();
				applied_Voucher=scanFile.next();
				break;
			}
			scanFile.close();
			
			subtotal = Double.parseDouble(tempSubtotal);
						
		}catch(Exception f)		{System.out.println("Running txt problem");}





		//Order_Quantity
	    JLabel Order_Quantity_label = new JLabel(""+totalQuantity);//Order_Quantity//
		Order_Quantity_label.setBounds(855,247,100,30);
		Order_Quantity_label.setFont(new Font ("Arial", Font.BOLD,15));
		panel.add(Order_Quantity_label);
		
		
		//Subtotal
		
	    JLabel Subtotal_label = new JLabel(""+subtotal);//Subtotal_label
		Subtotal_label.setBounds(855,283,100,30);
		Subtotal_label.setFont(new Font ("Arial", Font.BOLD,15));
		panel.add(Subtotal_label);
		
		
		
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
		panel.add(Discount_label);
		
//Shipping		
		double shippingFee=50.00;
		
		JLabel Shipping_label = new JLabel(""+shippingFee);//Shipping
		Shipping_label.setBounds(855,357,100,30);
		Shipping_label.setFont(new Font ("Arial", Font.BOLD,15));
		panel.add(Shipping_label);

//Total
		double totalWithDiscount=subtotal-discount;
		double total=totalWithDiscount+shippingFee;
		
	    JLabel Total_label = new JLabel(""+total);//total
		Total_label.setBounds(855,393,100,30);
		Total_label.setFont(new Font ("Arial", Font.BOLD,15));
		panel.add(Total_label);		
		
		
///////////////////////////////////
//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Cart Image\\Cart_Checkout.jpg");
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);	
		
		
		
		
		
		
		
		
		
		
////////////////////////////////////////////////////Action Listeners///////////////////////////////////////////////////////////////////
		back_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new View_Cart();
				
			}
		});
		
		
		back_to_home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new Home();
				
			}
		});
		
//Checkout Button Listener//////////////////////////////////////////////////////////////////////////////
		checkout_Button.addActionListener(new ActionListener(){////////////////////////////////////////
			public void actionPerformed(ActionEvent e){///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
//Getting Running User
				try{
					File running_user_File = new File("TXT FILES\\Running_User.txt");		
					Scanner scanFile = new Scanner(running_user_File);//Scan File
								
					while(scanFile.hasNext()){
						
						
						user=scanFile.next();
						break;
					}
					scanFile.close();
											
				}catch(Exception f)		{System.out.println("Running user file in cart checkout problem");}
				
				
				
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
		////////////////////////////////////////////////////////////////////////////////////////////////
				double userBalance=Double.parseDouble(user_balance);
				
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
							File running_user_File = new File("TXT_CART\\Cart_Order_File_NO.txt");		
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
						
						//Generate Order No
						Calendar c = Calendar.getInstance();
						SimpleDateFormat ft= new SimpleDateFormat("dd/MM/yyyy");
						String AMPM, date = ft.format(new Date());
						int meridiem= c.get(Calendar.AM_PM);
								
						if(meridiem==1)		{AMPM="PM";}
						else		{AMPM="AM";}
								
						String Time_Date= date+"_"+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+AMPM;
						
						String randomnumber=generateOtp(2);
						String orderNUMBER="VOIDC"+randomnumber+Time_Date;
						////////////////
				
						try{
							String USER_FILE="TXT_CART\\Orders\\Ordered_Book\\Cart_Order--"+orderFileNo+".txt";
							Formatter formatter=new Formatter(USER_FILE);
							
							
							
							
							formatter.format("%s\r\n", orderNUMBER);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", ""+totalQuantity);
							formatter.format("%s\r\n", ""+total);
							formatter.format("%s\r\n", user_name);
							
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
					
/////////////////////Updating Order file NO file/////////////////////////////////////////////////
						try{
							String USER_File="TXT_CART\\Cart_Order_File_NO.txt";
							Formatter formatter=new Formatter(USER_File);
							
							formatter.format("%s\r\n", (orderFileNo+1));
							
							
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
						
						
/////////////////////Updating Order ID in tempfile/////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT_CART\\Temp_Cart_OrderID.txt");
							
							formatter.format("%s\r\n", orderNUMBER);
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
////////////////////////Writting Address for each order////////////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT_CART\\Orders\\Address\\Address--"+addressFileNo+".txt");
							
							formatter.format("%s\r\n", address_field.getText());
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
						
////////////////////////Writting address file number for next file////////////////////////////////////////////////////////
						try{
							Formatter formatter=new Formatter("TXT_CART\\Cart_Address_No.txt");
							
							formatter.format("%s\r\n", (addressFileNo+1));
							
							
							formatter.close();
						}catch(Exception f)		{System.out.println(f);}
						
/////////////////////////////Update Book Stock///////////////////////////////////////////////
						
		
						for(int row=0; row<cartFileNo; row++)
						{
							String bookName = order_data[row][0];
							
							for(int i=1; i<bookfileNo; i++){
								//Getting Book Info

								String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+i+".txt";
													
										try{
											File user_file = new File(User_Information_File_Path);		
											Scanner scanFile = new Scanner(user_file);//Scan File
													
											while(scanFile.hasNext()){
												book_ID=scanFile.next();
												book_PRICE=scanFile.next();
												book_NAME=scanFile.next();
												book_CATEGORY=scanFile.next();
												book_PATH=scanFile.next();
												book_AUTHOR=scanFile.next()+" "+scanFile.next();//, , , , , , ;
												book_QUANTITY=scanFile.next();
												break;
											}
											scanFile.close();
											
											if( bookName.equals(book_NAME) ){
							///////////////Got the Book 
												int book_Stock = Integer.parseInt(book_QUANTITY);
												int quantity = Integer.parseInt(order_data[row][2]);
												book_Stock-=quantity;
												book_QUANTITY=Integer.toString(book_Stock);
												
												
												
												
												try{
													String user_FILE="TXT FILES\\Book Information\\Book-"+i+".txt";
													Formatter formatter=new Formatter(user_FILE);
													
													formatter.format("%s\r\n", book_ID);
													formatter.format("%s\r\n", book_PRICE);
													formatter.format("%s\r\n", book_NAME);
													formatter.format("%s\r\n", book_CATEGORY);
													formatter.format("%s\r\n", book_PATH);
													formatter.format("%s\r\n", book_AUTHOR);
													formatter.format("%s\r\n", book_QUANTITY);
													
													
													
													formatter.close();	
												}catch(Exception f)		{System.out.println(f);}
												
												
												
												
												
											}
											
										}catch(Exception f)		{System.out.println("Book Info file problem");}
							}
						}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
						
						
						
						
						
						
						
						JOptionPane.showMessageDialog(null, "Order Successfully Placed","Order Placed",-1,new ImageIcon("Images\\Successful_Icon.png"));
						frame.setVisible(false);
						new Cart_Confirm();
/////////////////////////////////////////////////////////////////////////////////////////////////////////
					}
					else{
						//Do Nothing
					}
					
				}//Else Block END
		
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////		
		}});/////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
//Set Visibility
frame.setVisible(true);
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