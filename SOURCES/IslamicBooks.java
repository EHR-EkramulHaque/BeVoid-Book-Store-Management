import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class IslamicBooks{
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	
		public IslamicBooks()
		{
			
		    ///////Front size.......................................
		    Font upperButtonFont = new Font ("Arial", Font.BOLD,15);
			
			
			////////////colour create
			
			Color LIGHT_RED = new Color (255,102,102);
	        Color LIGHT_BLUE = new Color (51,153,255);
	        Color Dark_CYAN = new Color (14,161,177);
	        Color DARK_ORANGE = new Color (255,140,0);
	        Color OFF_WHITE = new Color (214,222,225);
	        Color GRAY = new Color (93,93,93);
			
			
			
			////////////////////////////////////frame create//////////////////////////////////////////////////
			
			JFrame fr = new JFrame();
			fr.setSize(1000,600);
		    fr.setLocationRelativeTo(null);
			fr.setTitle("Islamic Books");
			
			
		    //Frame Close Confirmation
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
			
			
			
			///////////////////////////////////Logo set.......................
			Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
			fr.setIconImage(frame_icon);
			
		    fr.setResizable(false);
			
			/////////Conteiner creation...............................
			
			Container c = fr.getContentPane();
			c.setLayout(null);
			
			///////////Owner Label 
			JLabel ownerName = new JLabel("Tonmoy");
			ownerName.setBounds(948,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			c.add(ownerName);
			
			
			//////////////////////////........Image............//////////////////////////////////
			
			
			ImageIcon icon1 = new ImageIcon("Book_Images\\Prottaborton.jpg");             
			ImageIcon icon2 = new ImageIcon("Book_Images\\Remedy.jpg");           
			ImageIcon icon3 = new ImageIcon("Book_Images\\Attojiboni.jpg");       
			// ImageIcon icon4 = new ImageIcon("Book_Images\\Fera.jpg");   
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //1 no Book
			
			//////////////////////.....Jlabel-1..(Book No-1 image)........./////////////////////
			
			
			JLabel lable1 = new JLabel(icon1);
			lable1.setBounds(35,153,191,281);
			lable1.setOpaque(true);
			lable1.setBackground(OFF_WHITE);
		    // lable1.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			
			 //Image Hover
		    lable1.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseEntered(java.awt.event.MouseEvent evt) {
				lable1.setBackground(LIGHT_RED);
			}

			   public void mouseExited(java.awt.event.MouseEvent evt) {
				lable1.setBackground(OFF_WHITE);
				
			}
		 	
		    });
			
			//////////////////////.....Jlabel-2( 1 No Book name)........./////////////////////
			
			Cursor lebl2 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font silver = new Font ("Arial", Font.BOLD,16);
			JLabel lable2 = new JLabel("Prottaborton");
			lable2.setBounds(87,445,130,20);
			lable2.setFont(silver);
			lable2.setCursor(lebl2);
			
			//////////////////////.....Jlabel-3( 1 no Book price)........./////////////////////
			
			Cursor lebl3 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font pric = new Font ("Arial", Font.BOLD,16);
			JLabel lable3 = new JLabel("TK. 690.0");
			lable3.setBounds(96,470,90,20);
			lable3.setCursor(lebl3);
			lable3.setFont(pric);
			
	
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //2 no Book
			
			
			//////////////////////.....Jlabel-4(2 no Book Image)........./////////////////////
			
			JLabel lable4 = new JLabel(icon2);
			lable4.setBounds(273,155,200,280);
			lable4.setOpaque(true);
			lable4.setBackground(OFF_WHITE);
		    // lable4.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			
			//Image Hover
		    lable4.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseEntered(java.awt.event.MouseEvent evt) {
				lable4.setBackground(LIGHT_RED);
			}

			   public void mouseExited(java.awt.event.MouseEvent evt) {
				lable4.setBackground(OFF_WHITE);
				
			}
			
		   });
		   
		   //////////////////////.....Jlabel-5(2 no book name)........./////////////////////
			
			Cursor lebl5 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font data = new Font ("Arial", Font.BOLD,16);
			JLabel lable5 = new JLabel("Remedy");
			lable5.setBounds(343,445,120,20);
			lable5.setCursor(lebl5);
			lable5.setFont(data);
			
			
			//////////////////////.....Jlabel-6(2 no book price)........./////////////////////
			
			Cursor lebl6 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font pr = new Font ("Arial", Font.BOLD,16);
			JLabel lable6 = new JLabel("TK. 475.0");
			lable6.setBounds(338,470,100,20);
			lable6.setCursor(lebl6);
			lable6.setFont(pr);
			
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //3 no Book
			
			
			//////////////////////.....Jlabel-7...(3 No Book)........./////////////////////
			
			//Label 1
			
			JLabel lable7 = new JLabel( icon3);
			lable7.setBounds(531,154,194,281);
			lable7.setOpaque(true);
			lable7.setBackground(OFF_WHITE);
		    // lable7.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		  
		    c.add(lable7);

		    //Image Hover
		    lable7.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseEntered(java.awt.event.MouseEvent evt) {
				lable7.setBackground(LIGHT_RED);
			}

			   public void mouseExited(java.awt.event.MouseEvent evt) {
				lable7.setBackground(OFF_WHITE);
				
			}
			
		   });
		   
		   
		   //////////////////////.....Jlabel-8(3 no Book Nmae)........./////////////////////
			
			Cursor lebl8 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font hoor = new Font ("Arial", Font.BOLD,16);
			JLabel lable8 = new JLabel("Attojiboni");           
			lable8.setBounds(590,445,120,20);                      
			lable8.setCursor(lebl8);
			lable8.setFont(hoor);
			
			
			//////////////////////.....Jlabel-9(3 no Book Price)........./////////////////////
			
			Cursor lebl9 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font pri = new Font ("Arial", Font.BOLD,16);
			JLabel lable9 = new JLabel("TK. 625.0");           
			lable9.setBounds(591,470,90,20);                      
			lable9.setCursor(lebl9);
			lable9.setFont(pri);
			
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //4 no Book
			
			
			try{
				File user_file = new File("TXT FILES\\Book Information\\Book-8.txt");		
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
			}catch(Exception f)		{System.out.println("Book Info file problem in More 2");}
			 
			//////////////////////.....Jlabel-10( 4 No Book)........./////////////////////
			
			JLabel lable10 = new JLabel(new ImageIcon(book_path));
			lable10.setBounds(770,154,198,281);
			lable10.setOpaque(true);
			lable10.setBackground(OFF_WHITE);
		    // lable10.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			
			 //Image Hover
		    lable10.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseEntered(java.awt.event.MouseEvent evt) {
				lable10.setBackground(LIGHT_RED);
			}

			   public void mouseExited(java.awt.event.MouseEvent evt) {
				lable10.setBackground(OFF_WHITE);
				
			}
			
		    }); 
			
			
			//////////////////////.....Jlabel-11(4 no book name)........./////////////////////
			
			Cursor lebl11 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font go = new Font ("Arial", Font.BOLD,16);
			JLabel lable11 = new JLabel(book_name);           
			lable11.setBounds(855,445,150,20);                      
			lable11.setCursor(lebl11);
			lable11.setFont(go);
			
			
			
			//////////////////////.....Jlabel-12( 4 no book price)........./////////////////////
			
			Cursor lebl12 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font ok = new Font ("Arial", Font.BOLD,16);
			JLabel lable12 = new JLabel("TK. "+book_Price);           
			lable12.setBounds(840,470,120,20);                      
			lable12.setCursor(lebl12);
			lable12.setFont(ok);
			
			
			
			/////////////////////////////////////////View 4//////////////////////////////////////////////////////
		
		//////View4 Batton....................
		
		   Cursor view4carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view4batton = new JButton("View Details");
		   view4batton.setBounds(826,500,100,30);//
		   view4batton.setFont(new Font ("Arial", Font.BOLD,10));
		   view4batton.setFocusPainted(false);
		   view4batton.setCursor(view4carsor);
		   view4batton.setBackground(Color.WHITE);
		   view4batton.setForeground(LIGHT_BLUE);
		   

		////View3 Batton Hover
		    view4batton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				view4batton.setBackground(LIGHT_BLUE);
				view4batton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				view4batton.setBackground(Color.WHITE);
				view4batton.setForeground(LIGHT_BLUE);
			}
		});
		
		
		
			if(book_Id!=null){
				c.add(view4batton);
				c.add(lable10);
				c.add(lable11);
				c.add(lable12);
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			Cursor leb14 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font fon = new Font ("Arial", Font.BOLD,22);
			JLabel lable14 = new JLabel("Category");
			lable14.setBounds(448,49,100,50);
			lable14.setCursor(leb14);
			lable14.setFont(fon);
			
			
			
			c.add(lable1);
			c.add(lable2);
			c.add(lable3);
			c.add(lable4);
			c.add(lable5);
			c.add(lable6);
			c.add(lable7);
			c.add(lable8);
			c.add(lable9);
			c.add(lable14);
			
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			////////////////////////////////////////(HOme Batton)-(Book)-(Account)-(Contact) Batton///////////////////////////////////////////////
		
	
		
		//Home Button
		JButton home_Button=new JButton("HOME");  
		home_Button.setBounds(00,00,250,50);  
		home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		home_Button.setFont(upperButtonFont);
		home_Button.setBackground(Dark_CYAN);
		home_Button.setForeground(Color.WHITE);
		home_Button.setFocusPainted(false);
		c.add(home_Button);

		//Home Button Hover
		home_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				home_Button.setBackground(LIGHT_RED);
				home_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				home_Button.setBackground(Dark_CYAN);
				home_Button.setForeground(Color.WHITE);
			}
		});

        //Books Button
		JButton books_Button=new JButton("BOOKS");  
		books_Button.setBounds(250,00,250,50);
		books_Button.setFont(upperButtonFont);
		books_Button.setFocusPainted(false);
		books_Button.setBackground(LIGHT_RED);
		books_Button.setForeground(Color.BLACK);
		c.add(books_Button);

		
        //Account Button
		JButton account_Button=new JButton("ACCOUNT");  
		account_Button.setBounds(500,00,250,50);  
		account_Button.setFont(upperButtonFont);
		account_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		account_Button.setFocusPainted(false);
		c.add(account_Button);
		account_Button.setBackground(Dark_CYAN);
		account_Button.setForeground(Color.WHITE);
		
		//Account Button Hover
		account_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				account_Button.setBackground(LIGHT_RED);
				account_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				account_Button.setBackground(Dark_CYAN);
				account_Button.setForeground(Color.WHITE);
			}
		});

        //Contact us Button
		JButton contactus_Button=new JButton("CONTACT US");  
		contactus_Button.setBounds(750,00,236,50);  
		contactus_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		contactus_Button.setFont(upperButtonFont);
		contactus_Button.setFocusPainted(false);
		contactus_Button.setBackground(Dark_CYAN);
		contactus_Button.setForeground(Color.WHITE);
		c.add(contactus_Button);

		//Contact us Button Hover
		contactus_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				contactus_Button.setBackground(LIGHT_RED);
				contactus_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				contactus_Button.setBackground(Dark_CYAN);
				contactus_Button.setForeground(Color.WHITE);
			}
		});
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		///////////////////////////////////////////////////////////(ALL Books, Islamic book, Others Book)////////////////////////////////////////// 
		
		//////////////////////////////////////Book's Batton/////////////////////////////////
		
		///////Other's BOOk batton..........
		   Cursor islam = new Cursor(Cursor.HAND_CURSOR);
		   JButton otherbatton = new JButton("Other Books");
		   otherbatton.setBounds(658,100,328,30);
		   otherbatton.setFont(upperButtonFont);
		   otherbatton.setBackground(LIGHT_RED);
		   otherbatton.setForeground(Color.BLACK);
		   otherbatton.setCursor(islam);
		   otherbatton.setFocusPainted(false);
		   otherbatton.setBackground(Dark_CYAN);
		   otherbatton.setForeground(Color.WHITE);
		   c.add(otherbatton);
		   
		   //Other Book batton Hover
		    otherbatton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				otherbatton.setBackground(LIGHT_RED);
				otherbatton.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				otherbatton.setBackground(Dark_CYAN);
				otherbatton.setForeground(Color.WHITE);
			}
		});
		   
		   
		   
		//////Islamic Book batton.............
		
		   
		   JButton islamicbookbatton = new JButton("Islamic Books");
		   islamicbookbatton.setBounds(329,100,329,30);
		   islamicbookbatton.setFont(upperButtonFont);
		   islamicbookbatton.setFocusPainted(false);
		   islamicbookbatton.setBackground(LIGHT_RED);
		   islamicbookbatton.setForeground(Color.BLACK);
		   c.add(islamicbookbatton);

		
		   
		   
		   
		//////All book Batton................
		
		   Cursor all = new Cursor(Cursor.HAND_CURSOR);
		   JButton allbookbatton = new JButton("All Books");
		   allbookbatton.setBounds(0,100,329,30);//
		   allbookbatton.setFont(upperButtonFont);
		   allbookbatton.setFocusPainted(false);
		   allbookbatton.setCursor(all);
		   allbookbatton.setBackground(Dark_CYAN);
		   allbookbatton.setForeground(Color.WHITE);
		   c.add(allbookbatton);

		//All book Batton Hover
		    allbookbatton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				allbookbatton.setBackground(LIGHT_RED);
				allbookbatton.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				allbookbatton.setBackground(Dark_CYAN);
				allbookbatton.setForeground(Color.WHITE);
			}
		});
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////View details batton////////////////////////////////
		
		///////Front size......................................
		        Font viewfont = new Font ("Arial", Font.BOLD,10);
		
		//////View 1 Batton................
		
		   Cursor view1carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view1batton = new JButton("View Details");
		   view1batton.setBounds(79,500,100,30);//
		   view1batton.setFont(viewfont);
		   view1batton.setCursor(view1carsor);
		   view1batton.setFocusPainted(false);
		   view1batton.setBackground(Color.WHITE);////////////////////////Dark_CYAN
		   view1batton.setForeground(LIGHT_BLUE);
		   c.add(view1batton);

		////View1 Batton Hover
		    view1batton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				view1batton.setBackground(LIGHT_BLUE);
				view1batton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				view1batton.setBackground(Color.WHITE);
				view1batton.setForeground(LIGHT_BLUE);
			}
		});
		
		
		
		/////////////////////////////////////////View 2//////////////////////////////////////////////////////
		
		//////View(2 No)Batton.....................
		
		   Cursor view2carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view2batton = new JButton("View Details");
		   view2batton.setBounds(323,500,100,30);//
		   view2batton.setFont(viewfont);
		   view2batton.setFocusPainted(false);
		   view2batton.setCursor(view2carsor);
		   view2batton.setBackground(Color.WHITE);
		   view2batton.setForeground(LIGHT_BLUE);
		   c.add(view2batton);

		////View2 Batton Hover
		    view2batton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				view2batton.setBackground(LIGHT_BLUE);
				view2batton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				view2batton.setBackground(Color.WHITE);
				view2batton.setForeground(LIGHT_BLUE);
			}
		});
		
		
		
		
	
		/////////////////////////////////////////View 3//////////////////////////////////////////////////////
		
		//////View3 Batton......................
		
		   Cursor view3carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view3batton = new JButton("View Details");
		   view3batton.setBounds(578,500,100,30);//
		   view3batton.setFont(viewfont);
		   view3batton.setFocusPainted(false);
		   view3batton.setCursor(view3carsor);
		   view3batton.setBackground(Color.WHITE);
		   view3batton.setForeground(LIGHT_BLUE);
		   c.add(view3batton);

		////View3 Batton Hover
		    view3batton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				view3batton.setBackground(LIGHT_BLUE);////////////////////////////change()hoiyece
				view3batton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				view3batton.setBackground(Color.WHITE); ////////////////////////////change()hoiyece
				view3batton.setForeground(LIGHT_BLUE);
			}
		});
		
		
		
		
		//Cart Button 
		//Cart Button 
		JButton cart_Button = new JButton();
		cart_Button.setBounds(927,55,40,40);//
		cart_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cart_Button.setToolTipText("My Cart");
		cart_Button.setContentAreaFilled(false);
        cart_Button.setFocusPainted(false);
        cart_Button.setBorderPainted(false);
		c.add(cart_Button);
		
		
//Set Background
		ImageIcon Username_Background = new ImageIcon("Images\\Books.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);
		
		//////////////////////////////////////////////////////(Action listener for all button)//////////////////////////////////////////////////////////
		
		//////////////////////////////Action listener..............................
		
		home_Button.addActionListener(new ActionListener(){
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
		
		 account_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Account_Panel();
				
			}
		}); 
		
		
		 contactus_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Contact_Us();
				
			}
		}); 
		
		
		allbookbatton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new AllBooks();
				
			}
		});
		
		
		otherbatton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new OtherBooks();
				
			}
		});
		
        ////////////////////////////////////////////////Action listener for view details button/////////////////////////////////////////////////
		
		/////////////////view 1..................................
		
		view1batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
					
					
					formatter.format("%s\r\n", "4");
					formatter.close();  
            
				}catch(Exception f)    {System.out.println("Problem in runnung file view-1");}
				
				fr.setVisible(false);
				new Details_Panel();
			}
		});
		
		
		///////////////////////////////View-2 ..................................
		
		view2batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
					
					
					formatter.format("%s\r\n", "2");
					formatter.close();  
            
				}catch(Exception f)    {System.out.println("Problem in runnung file view-2");}
				
				fr.setVisible(false);
				new Details_Panel();
			}
		});
		
		
		///////////////////////////////View-3 ..................................
		
		view3batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
					
					
					formatter.format("%s\r\n", "3");
					formatter.close();  
            
				}catch(Exception f)    {System.out.println("Problem in runnung file view-3");}
				
				fr.setVisible(false);
				new Details_Panel();
			}
		});
		
		
		
		///////////////////////////////View-4 ..................................
		
		view4batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
					
					
					formatter.format("%s\r\n", "8");
					formatter.close();  
            
				}catch(Exception f)    {System.out.println("Problem in runnung file view-4 Fera");}
				
				fr.setVisible(false);
				new Details_Panel();
			}
		});
		
		
		
		
		
		   fr.setVisible(true);
		
		}
		
}
		
		
		
		