import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class View_Cart{	

	Color LIGHT = new Color (157,188,224);
	Color Light = new Color (89,158,206);
	
	String book_Id, book_name, book_Price, carted_quantity;
	
	int cartFileNo;
	
	int totalQuantity=0;
	double totalPrice=0.0;
	
	public View_Cart()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("My Cart");
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
		
		
//////////////////////////////////////////////////////// Table related work ///////////////////////////////////////////////////////
		
		
		
		
		//Label for Gif
		JLabel gif_Label=new JLabel(new ImageIcon("Images\\Cart Image\\Cart.gif"));
		gif_Label.setBounds(9,90,600,270);
		panel.add(gif_Label);
		
		
		
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,380,550,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		panel.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,399,550,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		panel.add(label_Row);
		
		
		//Adding Book ID label;
		JLabel bookId_label =new JLabel("Book ID");
		bookId_label.setBounds(50,380,100,20);
		panel.add(bookId_label);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(128,380,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		panel.add(label_colum1);
		
		
		//Book Name label;
		JLabel bookName_label =new JLabel("Book Name");
		bookName_label.setBounds(195,380,100,20);
		panel.add(bookName_label);//
		
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(322,380,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		panel.add(label_colum2);
		
		// Book Price label;
		JLabel bookPrice_label =new JLabel("Book Price");
		bookPrice_label.setBounds(352,380,120,20);
		panel.add(bookPrice_label);
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(441,380,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		panel.add(label_colum5);
		
		
		//Category label;
		JLabel quantity_Label =new JLabel("Quantity");
		quantity_Label.setBounds(477,380,100,20);
		panel.add(quantity_Label);//
		
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(559,380,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		panel.add(label_colum3);
		
		//Voucher Text Field 
		JTextField voucher_field = new JTextField();
		voucher_field.setBounds(680,417,218,37);
		voucher_field.setFont(new Font("Arial", Font.PLAIN, 18));
		new TextPrompt("Enter Voucher Code", voucher_field);
		panel.add(voucher_field);
		
		//voucher_label
		JLabel voucher_label=new JLabel("Apply Voucher Code");
		voucher_label.setBounds(680,380,218,37);
        voucher_label.setFont(new Font("Arial", Font.PLAIN, 14));		
		panel.add(voucher_label);
		
		
		
		//Place Order Button
		JButton place_Button = new JButton("Place Order");
		place_Button.setBounds(729,490,120,30);
		place_Button.setFont(new Font("Arial", Font.BOLD, 14));
		place_Button.setBackground(Color.WHITE);
		place_Button.setForeground(Light);
		place_Button.setFocusPainted(false);
		place_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(place_Button);
		
		place_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				place_Button.setForeground(Color.WHITE);
				place_Button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				place_Button.setForeground(Light);
				place_Button.setBackground(Color.WHITE);
			}
		});
		
		
		
		
		//clear_cart_Button
		JButton clear_cart_Button = new JButton("Clear Cart");
		clear_cart_Button.setBounds(10,520,119,20);
		clear_cart_Button.setFont(new Font("Arial", Font.BOLD, 13));
		clear_cart_Button.setBackground(Color.WHITE);
		clear_cart_Button.setForeground(Light);
		clear_cart_Button.setFocusPainted(false);
		clear_cart_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(clear_cart_Button);
		
		clear_cart_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				clear_cart_Button.setForeground(Color.WHITE);
				clear_cart_Button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clear_cart_Button.setForeground(Light);
				clear_cart_Button.setBackground(Color.WHITE);
			}
		});
		
		//Back Button 
		JButton Back_Button = new JButton();
		Back_Button.setBounds(29,22,48,40);
		Back_Button.setFont(new Font("Arial", Font.BOLD, 14));
		Back_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Back_Button.setToolTipText("Back To All Books");
		Back_Button.setContentAreaFilled(false);
        Back_Button.setFocusPainted(false);
        Back_Button.setBorderPainted(false);
		panel.add(Back_Button);
		
///////////////////////////////////////////////////////////////
		
		
		//for table;
		String order_data[][] = new String [cartFileNo][4];
		
		
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
							order_data[row][col]=book_Id;
						}
						else if(col==1){
							order_data[row][col]=book_name;
						}
						else if(col==2){
							order_data[row][col]=book_Price;
						}
						else if(col==3){
							order_data[row][col]=carted_quantity;
							
							int QUANTITY = Integer.parseInt(carted_quantity);
							totalQuantity= totalQuantity+QUANTITY;
							
						}
						else{}
							

							
						
					}catch(Exception f)		{System.out.println("Reading Carted Files problem in cart view");}
				
			}
			
			double price = Double.parseDouble(book_Price);
			int quantity = Integer.parseInt(carted_quantity);
			double PRICE = price*quantity;
			totalPrice = totalPrice+PRICE;
		}
				
		
		
		
		String table_colume[] ={"Book ID","Book Name","Book Price", "Book Quantity" };
		JTable cart_table = new JTable(order_data,table_colume)
		
		
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		
		
		cart_table.setBounds(10,400,550,110);
		cart_table.setRowHeight(20);		
		panel.add(cart_table);
		
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		cart_table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		cart_table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		cart_table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		cart_table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		
		
		TableColumnModel tcm =cart_table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 10 );
		tcm.getColumn(1).setPreferredWidth( 90 );
		tcm.getColumn(2).setPreferredWidth( 10 );
		tcm.getColumn(3).setPreferredWidth( 10 );
////////////////////////////////////////////////////Table Releted Task Done///////////////////////////////////////////////////////////////////////////////////
		
		
		
		//Total Books label;
		JLabel Loading_Panel_Label =new JLabel(""+totalQuantity);
		Loading_Panel_Label.setBounds(830,277 ,120,30);
		Loading_Panel_Label.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(Loading_Panel_Label);
		
		
		//Book Price label;
		JLabel Total_price_Label =new JLabel(""+totalPrice);
		Total_price_Label.setBounds(830,335,120,30);
		Total_price_Label.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(Total_price_Label);
		
		
//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\Cart Image\\View_Cart_Background.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
//////////////////////////////////////////////Action Listeners//////////////////////////////////////////////////////////////////		
//For Back
		Back_Button.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {
				frame.setVisible(false);
				new AllBooks();
		}});



//Clear Cart 
		clear_cart_Button.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {
				
				int clear = JOptionPane.showConfirmDialog (null,"Do You Want To Clear Your Cart?", "Clear Cart",JOptionPane.YES_NO_OPTION);
					
				if (clear == JOptionPane.YES_OPTION){
					
				//Deleting old carted file 
					File cartfolder = new File("TXT_CART\\Temp_Cart");
					File fList[] = cartfolder.listFiles();

					for (File ff : fList) {
						if (ff.getName().endsWith(".txt")) {
							ff.delete(); 
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
					new AllBooks();
				}
		}});

		
//For Place Order//////////////////////////////////////////////////////////////////////////
		place_Button.addActionListener(new ActionListener() {/////////////////////////////
			public void actionPerformed(ActionEvent ae) {////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
				
				if(cartFileNo<1)
				{
					JOptionPane.showMessageDialog(null, "Your Cart is Empty. Please add any Books", "Empty Cart",JOptionPane.WARNING_MESSAGE);
				}
				else{
					if(	 voucher_field.getText().isEmpty()  )
					{
						
						try{
							Formatter formatter=new Formatter("TXT_CART\\Voucher.txt");
							
							
							formatter.format("%s\r\n", ""+totalPrice);
							formatter.format("%s", "null");
							formatter.close();  
								
						}catch(Exception f)    {System.out.println("Problem in voucher file1 in view cart");}
						
						frame.setVisible(false);
						new Cart_Checkout();
					}
					
					
					else
					{
						if(  voucher_field.getText().equals("BEVOID10")  )
						{
							
							try{
							Formatter formatter=new Formatter("TXT_CART\\Voucher.txt");
								
							
							formatter.format("%s\r\n", ""+totalPrice);
							formatter.format("%s", "BEVOID10");
							formatter.close();  
								
							}catch(Exception f)    {System.out.println("Problem in voucher file2 in view cart");}
							
							frame.setVisible(false);
							new Cart_Checkout();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sorry, This voucher is not valid. Please check for any typing errors", "Voucher Not Found",JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}

//////////////////////////////////////////////////////////////////////////////////////
		}});/////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
//Set Visibility
frame.setVisible(true);
EventQueue.invokeLater( () -> voucher_field.requestFocusInWindow() );
	}
}