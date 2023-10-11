import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

class Cart_Confirm{

	Color light = new Color(146,193,199);
	Color very_light_Blue = new Color(225,246,255);
	Color dark = new Color(0,159,148);
	
	
	String order_orderID, order_userPhone, order_userEmail, order_quantity, order_price, order_userName, address="";
	
	String book_Id, book_name, book_Price, carted_quantity;
	
	
	int total_orderNo, orderfileIs, cartFileNo;
	String order;
	
	public Cart_Confirm()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Delivery Informations");
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
		
		/* UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12)); */
		
		
///////////Owner Label 
		JLabel ownerName = new JLabel("Ekramul");
		ownerName.setBounds(948,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
///////////////////////////////////////////////////////
//Getting TOtal Order NO 
		String orderNo="";
		try{
			File orderFile = new File("TXT_CART\\Cart_Order_File_NO.txt");		
			Scanner scanFile = new Scanner(orderFile);//Scan File
						
			while(scanFile.hasNext()){
				orderNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			total_orderNo= Integer.parseInt(orderNo);
						
		}catch(Exception f)		{System.out.println("Problem Running file user in Confirm");}
		
//Getting Running Order 
		try{
			File running_user_File = new File("TXT_CART\\Temp_Cart_OrderID.txt");		
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
		for(int i=1; i<total_orderNo; i++)
		{
			String Order_File_NO="TXT_CART\\Orders\\Ordered_Book\\Cart_Order--"+i+".txt";
						
			try{
				File order_File = new File(Order_File_NO);		
				Scanner scanFile = new Scanner(order_File);//Scan File
						
				while(scanFile.hasNext()){
					order_orderID=scanFile.next();
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


//Getting Address 
		String addressFile="TXT_CART\\Orders\\Address\\Address--"+orderfileIs+".txt";
						
			try{
				File address_file = new File(addressFile);		
				Scanner scanFile = new Scanner(address_file);//Scan File
						
				while(scanFile.hasNext()){
					address=address+scanFile.next()+" ";
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("address file problem");}
		
///////////////////////////////////////////////////////////////////////////////////////
//Order_id label	
	    JLabel Order_id_label = new JLabel(order_orderID);
		Order_id_label.setBounds(590,229,250,30);
		Order_id_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Order_id_label);
//Name label	
	    JLabel Name_label = new JLabel(order_userName);
		Name_label.setBounds(590,255,250,30);
		Name_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Name_label);
		
//Phone_Number label	
	    JLabel Phone_Number_label = new JLabel(order_userPhone);
		Phone_Number_label.setBounds(590,282,250,30);
		Phone_Number_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Phone_Number_label);
//Email_Address label	
	    JLabel Email_Address_label = new JLabel(order_userEmail);
		Email_Address_label.setBounds(590,309,250,30);
		Email_Address_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Email_Address_label);
//Book_Quantity label	
	    JLabel Book_Quantity_label = new JLabel(order_quantity);
		Book_Quantity_label.setBounds(590,338,250,30);
		Book_Quantity_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Book_Quantity_label);
//Order_Amount label	
	    JLabel Order_Amount_label = new JLabel(order_price);
		Order_Amount_label.setBounds(590,368,250,30);
		Order_Amount_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Order_Amount_label);
//Delivery_address label	
	    JLabel Delivery_address_label = new JLabel(address);
		Delivery_address_label.setBounds(590,395,250,30);
		Delivery_address_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Delivery_address_label);




//////////////////////////////////////////////////////// Table related work ///////////////////////////////////////////////////////
		
		
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(190,240,220,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		panel.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(190,259,220,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		panel.add(label_Row);
		
		//Book Name label;
		JLabel bookName_label =new JLabel("Book Name");
		bookName_label.setBounds(227,240,100,20);
		panel.add(bookName_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(409,240,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		panel.add(label_colum2);
		
		
		//Book Price label;
		JLabel price_Label =new JLabel("Price");
		price_Label.setBounds(356,240,100,20);
		panel.add(price_Label);//
		
		//Adding label for colum2;
		JLabel column2_Line=new JLabel();
		column2_Line.setBounds(331,240,1,20);
		column2_Line.setOpaque(true);
		column2_Line.setBackground(Color.BLACK);
		panel.add(column2_Line);
		
		
///////////////////////////////////////////////////////////////
		//Getting amount of carted book 
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
		
		
		
		
		////////////////for table;
		String order_data[][] = new String [cartFileNo][2];
		
		for(int row=0; row<cartFileNo; row++)
		{
			for(int col=0; col<=3; col++)
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
						else{}
										
						
					}catch(Exception f)		{System.out.println("Reading Carted Files problem in cart view");}
				
			}
		}
				
		
		
		
		String table_colume[] ={"Book Name", "Book Price"};
		JTable cart_table = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		cart_table.setBounds(190,260,220,110);
		cart_table.setRowHeight(20);		
		
		panel.add(cart_table);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		cart_table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		cart_table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );

		
		TableColumnModel tcm =cart_table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 80 );
		tcm.getColumn(1).setPreferredWidth( 10 );
////////////////////////////////////////////////////Table Releted Task Done///////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
//Back_To_Home button
		JButton Back_To_Home_Button = new JButton("Back To Home");
		Back_To_Home_Button.setBounds(462,442,137,30);
		Back_To_Home_Button.setFont(new Font ("Arial", Font.BOLD,14));
		Back_To_Home_Button.setFocusPainted(false);
		Back_To_Home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Back_To_Home_Button.setToolTipText("Back to Home");
		Back_To_Home_Button.setForeground(dark);
		Back_To_Home_Button.setBackground(Color.WHITE);
		panel.add(Back_To_Home_Button);
		
		
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
		panel.add(Print_Button);
		
		
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
		
		
//Tick_Mark label	
	    JLabel Tick_Mark_Label = new JLabel((new ImageIcon("Images\\Confirm_Page_Giphy.gif")));
		Tick_Mark_Label.setBounds(470,131,53,50);
        Tick_Mark_Label.setOpaque(true);		
		panel.add(Tick_Mark_Label);
		
//Frame Background	   
	    ImageIcon Username_Background = new ImageIcon("Images\\Cart Image\\Cart_Confirm.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);



//Storing book quantity and names
				String books[] = new String[cartFileNo];
				String bookquantity[] = new String[cartFileNo];
				
				for(int i=0; i<cartFileNo; i++)
				{
					String User_Information_File_Path="TXT_CART\\Temp_Cart\\Cart--"+(i+1)+".txt";
						
				
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
							
						books[i] = book_name;
						bookquantity[i] = carted_quantity;
							
					}catch(Exception f)		{System.out.println("Reading Carted Files problem in cart confirm");}
					
				}
		
				// Making file with ordered Books and there quantity
				try{
					String USER_FILE="TXT_CART\\Orders\\BOOK_NAME\\Book_For_Order--"+(total_orderNo-1)+".txt";
					Formatter formatter=new Formatter(USER_FILE);
							
							
					int i=0;
					while(i<cartFileNo){
						formatter.format("%s\r\n", books[i]+"_("+bookquantity[i] + ")");
						
						i++;
					}		
							
							
							
					formatter.close();	
				}catch(Exception f)		{System.out.println(f);}







//////////////////////////////////////////////////////////Action Listeners//////////////////////////////////////////////////////////////////
		
//Back to Home Button Action Listener/////////////////////////////////////////////////
		Back_To_Home_Button.addActionListener(new ActionListener(){//////////////////
			public void actionPerformed(ActionEvent u){/////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
			
				
			//Deleting old carted file 
				File folder = new File("TXT_CART\\Temp_Cart");
				File fList[] = folder.listFiles();

				for (File f : fList) {
					if (f.getName().endsWith(".txt")) {
						f.delete(); 
					}
				}
			
			//Restoring running cart file no
				try{
					String USER_FILE="TXT_CART\\Running_Cart_File.txt";
					Formatter formatter=new Formatter(USER_FILE);	
					
					formatter.format("%s", "1");		
							
					formatter.close();	
				}catch(Exception f)		{System.out.println(f);}
				
				frame.setVisible(false);
				new Home();
				
///////////////////////////////////////////////////////////////////////////////
		}});//////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////


//Print Button Action Listener
		new CartPrint(address);
		Print_Button.addActionListener(new CartPrint());
		
		
//Set Visibility 
frame.setVisible(true);
	}
}