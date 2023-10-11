import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Details_Panel
{
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	Color light = new Color(146,193,199);
	Color dark = new Color(0,159,148);
    int valueInt=1;
	
	
	int cartFileNo, similarBookFileIs;
	boolean similarBookExist;
	

public Details_Panel()
{
			
//frame
	JFrame fr = new JFrame("Book Details");
    fr.setSize(1000,600);
	fr.setLocationRelativeTo(null);
	fr.setLayout(null);
	Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	fr.setIconImage(fr_icon);
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
	
	
	
//Voucher Code textfield		
		JTextField voucher_field = new JTextField();
		voucher_field.setBounds(400,345,120,25);
		new TextPrompt("Enter Voucher Code",voucher_field);
		fr.add(voucher_field);
		
		
/* //Voucher Code textfield
		JLabel textfield_label = new JLabel("Apply Voucher Code");
		textfield_label.setBounds(400,325,260,50);
		textfield_label.setFont(new Font ("Arial", Font.BOLD,10));
		fr.add(textfield_label); */
	
//bookname label	
	    JLabel bookname_label = new JLabel(book_name);
		bookname_label.setBounds(400,110,260,50);
		bookname_label.setFont(new Font ("Arial", Font.BOLD,35));
		fr.add(bookname_label);
		
//author name label		
		JLabel author_label = new JLabel("Author Name :");
		author_label.setBounds(400,175,100,30);
		author_label.setFont(new Font ("Arial", Font.PLAIN,15));
		fr.add(author_label);
		
		JLabel author2_label = new JLabel(book_author);
		author2_label.setBounds(502,175,150,30);
		author2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(author2_label);
//category label		
		JLabel Category_label = new JLabel("Category :");
		Category_label.setBounds(400,200,70,30);
		Category_label.setFont(new Font ("Arial", Font.PLAIN,15));
		fr.add(Category_label);
		
		JLabel category2_label = new JLabel(book_category);
		category2_label.setBounds(475,200,150,30);
		category2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(category2_label);
//id label		
		JLabel ID_label = new JLabel("Book ID :");
		ID_label.setBounds(400,225,75,30);
		ID_label.setFont(new Font ("Arial", Font.PLAIN,15));
		fr.add(ID_label);
		
		JLabel ID2_label = new JLabel(book_Id);
		ID2_label.setBounds(470,225,10,30);
		ID2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(ID2_label);
		
//Price
        JLabel tk_label = new JLabel("TK.");
		tk_label.setBounds(406,253,30,30);
		tk_label.setFont(new Font ("Arial", Font.BOLD,12));
		fr.add(tk_label);

	    JLabel tk2_label = new JLabel(book_Price);
		tk2_label.setBounds(430,251,100,30);
		tk2_label.setFont(new Font ("Arial", Font.BOLD,21));		
		fr.add(tk2_label);
		
//In Stock label
		int stock= Integer.parseInt(book_quantity);
		if(stock<10){
			JLabel stock_label = new JLabel("In Stock :");
			stock_label.setBounds(400,280,100,30);
			stock_label.setForeground(Color.RED);
			stock_label.setFont(new Font ("Arial", Font.PLAIN,15));
			fr.add(stock_label);
			
			JLabel available_label = new JLabel(book_quantity);
			available_label.setBounds(470,280,130,30);
			available_label.setForeground(Color.RED);
			available_label.setFont(new Font ("Arial", Font.BOLD,15));
			fr.add(available_label);
		}else{
			JLabel stock_label = new JLabel("In Stock :");
			stock_label.setBounds(400,280,100,30);
			stock_label.setFont(new Font ("Arial", Font.PLAIN,15));
			fr.add(stock_label);
			
			JLabel available_label = new JLabel("Available");
			available_label.setBounds(470,280,130,30);
			available_label.setFont(new Font ("Arial", Font.BOLD,15));
			fr.add(available_label);
		}
		
		
//increment or decrement quantity
         JButton incBtn = new JButton();	
		 incBtn.setBounds(458,315,15,15);
		 incBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 incBtn.setFocusPainted(false);
         incBtn.setContentAreaFilled(false);		  
		 incBtn.setBorderPainted(false);
         incBtn.setOpaque(false);
         		 	 
         JButton decBtn = new JButton();
		 decBtn.setBounds(400,315,15,15);
		 decBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 decBtn.setContentAreaFilled(false);		  
		 decBtn.setBorderPainted(false);
		 decBtn.setFocusPainted(false); 
		 decBtn.setOpaque(false);
		
		 
		 
//////////////////////// QUANTITY////////////////////////////////
         JLabel showLbl = new JLabel("01");
         showLbl.setBounds(430,315,15,15);
				 
         fr.add(showLbl);
		 fr.add(incBtn);
		 fr.add(decBtn);
		 
		 
            incBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valueInt = Integer.parseInt(showLbl.getText());
                valueInt++;
                if (valueInt >= 10) {
                    showLbl.setText(String.valueOf(valueInt));
                } else {
                    showLbl.setText("0" + String.valueOf(valueInt));
                }
            }
        });

        decBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valueInt = Integer.parseInt(showLbl.getText());
                if (valueInt > 1) {
                    valueInt--;
                }
                if (valueInt >= 10) {
                    showLbl.setText(String.valueOf(valueInt));
                } else {
                    showLbl.setText("0" + String.valueOf(valueInt));
                }
            }
        });
		
//photo
		JLabel image_label = new JLabel(new ImageIcon(book_path));
		image_label.setBounds(150,150,179,265);
		fr.add(image_label);

		/* UIManager.put("ToolTip.background", null);
		UIManager.put("ToolTip.foreground", Color.BLACK);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 12)); */
//Back to Home Button
		JButton back_to_Home_Button = new JButton();
		back_to_Home_Button.setBounds(22,24,41,34);
		back_to_Home_Button.setToolTipText("Back to Home");
		back_to_Home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		back_to_Home_Button.setContentAreaFilled(false);
        back_to_Home_Button.setFocusPainted(false);
        back_to_Home_Button.setBorderPainted(false);
		
		fr.add(back_to_Home_Button);
		
		
//Back Button
		JButton back_to_book_Button = new JButton();
		back_to_book_Button.setBounds(100,24,41,34);
		back_to_book_Button.setToolTipText("Back to Book");
		back_to_book_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		back_to_book_Button.setContentAreaFilled(false);
        back_to_book_Button.setFocusPainted(false);
        back_to_book_Button.setBorderPainted(false);
		
		fr.add(back_to_book_Button);
		
//Place Order button
		JButton buy_Button = new JButton("PLACE ORDER");
		buy_Button.setBounds(400,380,150,30);
		buy_Button.setFont(new Font ("Arial", Font.BOLD,14));
		buy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buy_Button.setForeground(dark);
		buy_Button.setFocusPainted(false);
		buy_Button.setBackground(Color.WHITE);
		fr.add(buy_Button);
		
		
		buy_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buy_Button.setBackground(dark);
				buy_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buy_Button.setForeground(dark);
				buy_Button.setBackground(Color.WHITE);
			}
		});
		
		
//Add to Cart button
		JButton add_to_Cart_Button = new JButton("Add to Cart");
		add_to_Cart_Button.setBounds(560,380,150,30);
		add_to_Cart_Button.setFont(new Font ("Arial", Font.BOLD,14));
		add_to_Cart_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add_to_Cart_Button.setForeground(dark);
		add_to_Cart_Button.setFocusPainted(false);
		add_to_Cart_Button.setBackground(Color.WHITE);
		fr.add(add_to_Cart_Button);
		
		
		add_to_Cart_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				add_to_Cart_Button.setBackground(dark);
				add_to_Cart_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				add_to_Cart_Button.setForeground(dark);
				add_to_Cart_Button.setBackground(Color.WHITE);
			}
		});
		
		//Cart Button
		
		JButton cart_Button = new JButton();
		cart_Button.setBounds(932,20,40,40);//
		cart_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cart_Button.setToolTipText("Go to My Cart");
		cart_Button.setContentAreaFilled(false);
        cart_Button.setFocusPainted(false);
        cart_Button.setBorderPainted(false);
		fr.add(cart_Button);
		
		
		
//Set Background
		ImageIcon Username_Background = new ImageIcon("Images\\place-order.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);
		
		
		
////////////////////////////////////////////////////////Action Listeners//////////////////////////////////////////////////
		back_to_Home_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Home();
				
			}
		});
		
		
		
		cart_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new View_Cart();
				
			}
		});
		
		back_to_book_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new AllBooks();
				
			}
		});
		
		
		
		
		

		buy_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
/////////////////////////////////////////////////////////////////////Details Panel Backend///////////////////////////////////////////////////////////////////////////
				int purchaseQuantity=Integer.parseInt( showLbl.getText() );
				
				if(stock==0)
				{
					JOptionPane.showMessageDialog(null, book_name+" is Stock out. You can check our others books", "STOCK OUT",JOptionPane.WARNING_MESSAGE);
				}
				else if(purchaseQuantity>stock)
				{
					JOptionPane.showMessageDialog(null, "Only "+stock+" Pieces of "+book_name+" is in Stock", "Stock Limited",JOptionPane.WARNING_MESSAGE);
				}
				else if(	 voucher_field.getText().isEmpty()  )
				{
					
					try{
						Formatter formatter=new Formatter("TXT FILES\\Quantity___Voucher.txt");
						
						
						formatter.format("%s\r\n", showLbl.getText());
						formatter.format("%s", "null");
						formatter.close();  
							
					}catch(Exception f)    {System.out.println("Problem in Quantity file");}
					
					fr.setVisible(false);
					new Checkout();
				}
				
				else
				{
					if(  voucher_field.getText().equals("BEVOID10")  )
					{
						
						try{
						Formatter formatter=new Formatter("TXT FILES\\Quantity___Voucher.txt");
							
							
						formatter.format("%s\r\n", showLbl.getText());
						formatter.format("%s", "BEVOID10");
						formatter.close();  
							
						}catch(Exception f)    {System.out.println("Problem in Quantity file");}
						
						fr.setVisible(false);
						new Checkout();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sorry, This voucher is not valid. Please check for any typing errors", "Voucher Not Found",JOptionPane.WARNING_MESSAGE);
					}
				}
				
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		
		
		
//Add to Cart/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		add_to_Cart_Button.addActionListener(new ActionListener(){///////////////////////////////////////////////////////
			public void actionPerformed(ActionEvent e){/////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				int cartQuantity=Integer.parseInt( showLbl.getText() );
				
				
				if(stock==0)
				{
					JOptionPane.showMessageDialog(null, book_name+" is Stock out. You can check our others books", "STOCK OUT",JOptionPane.WARNING_MESSAGE);
				}
				else if(cartQuantity>stock)
				{
					JOptionPane.showMessageDialog(null, "Only "+stock+" Pieces of "+book_name+" is in Stock", "Stock Limited",JOptionPane.WARNING_MESSAGE);
				}
				else
				{//If book in stock
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//Reading Next Cart File No 
					String cartfile="";
					try{
						File user_file = new File("TXT_CART\\Running_Cart_File.txt");		
						Scanner scanFile = new Scanner(user_file);//Scan File
								
						while(scanFile.hasNext()){
							cartfile=scanFile.next();
							break;
						}
						scanFile.close();
						
						cartFileNo = Integer.parseInt(cartfile);
					
					}catch(Exception f)		{System.out.println("Reading Running_Cart_File problem");}
					
					
					//Checking is cart is full or have space
					if(cartFileNo<=5)
					{
						
						//Checking if there are any same book in cart
						for(int i=1; i<cartFileNo; i++){
							
							String CartedBookID="";
							try{
								File user_file = new File("TXT_CART\\Temp_Cart\\Cart--"+i+".txt");		
								Scanner scanFile = new Scanner(user_file);//Scan File
										
								while(scanFile.hasNext()){
									CartedBookID=scanFile.next();
									break;
								}
								scanFile.close();
								
								if((book_Id.equals(CartedBookID)))
								{
									similarBookExist=true;
									similarBookFileIs=i;
									break;
								}
							
							}catch(Exception f)		{System.out.println("Reading Carted FIles problem");}
						}
						
						if(similarBookExist)
						{
						//Writting cart info in the same file the book previously added
							try{
								Formatter formatter=new Formatter("TXT_CART\\Temp_Cart\\Cart--"+similarBookFileIs+".txt");
									
								formatter.format("%s\r\n", book_Id);
								formatter.format("%s\r\n", book_name);
								formatter.format("%s\r\n", book_Price);
								formatter.format("%s",	   cartQuantity);
								
								formatter.close();  
							}catch(Exception f)    {System.out.println("Problem in writting cart file for same book");}
							
							JOptionPane.showMessageDialog(null, "Book "+book_name+" Succesfully added to cart.","Added to Cart",-1,new ImageIcon("Images\\Successful_Icon.png"));
							
						}
						else{
							
					//Writting File when there is no same book in cart
							try{
								Formatter formatter=new Formatter("TXT_CART\\Temp_Cart\\Cart--"+cartfile+".txt");
									
								formatter.format("%s\r\n", book_Id);
								formatter.format("%s\r\n", book_name);
								formatter.format("%s\r\n", book_Price);
								formatter.format("%s",	   cartQuantity);
								
								formatter.close();  
							}catch(Exception f)    {System.out.println("Problem in writting cart file");}
						
					//Updating Running_Cart_File NO by increasing 1
							try{
								Formatter formatter=new Formatter("TXT_CART\\Running_Cart_File.txt");
									
								formatter.format("%s\r\n", ""+(cartFileNo+1));
								
								formatter.close();  
							}catch(Exception f)    {System.out.println("Problem in Updating Running_Cart_File");}
							
							JOptionPane.showMessageDialog(null, "Book "+book_name+" Succesfully added to cart.","Added to Cart",-1,new ImageIcon("Images\\Successful_Icon.png"));
							//Different Book writting in cart done
						}
					
					
					
					}
					else{
						JOptionPane.showMessageDialog(null, "Your Cart is Full", "Cart is Full",JOptionPane.WARNING_MESSAGE);
					}
					
					
				}//End of else block
				
				
				
				
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		}});////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
fr.setVisible(true);
EventQueue.invokeLater( () -> voucher_field.requestFocusInWindow() );
}
}