import java.awt.event.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class MoreBooks2{
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	
		public MoreBooks2()
		{
			
	     	///////Front size......................................
		    Font upperButtonFont = new Font ("Arial", Font.BOLD,15);
			
			
			////////colour......................
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
			fr.setTitle("All Books (Page-3)");
			
			
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
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			/////////Conteiner creation...............................
			
			Container c = fr.getContentPane();
			c.setLayout(null);
			
			
			///////////Owner Label 
			JLabel ownerName = new JLabel("Tonmoy");
			ownerName.setBounds(948,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			c.add(ownerName);
			
			//////////////////////////........Image............//////////////////////////////////
			
			ImageIcon icon1 = new ImageIcon("Book_Images\\Deyal.jpg");           
			           
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //1 no Book//
			
			//////////////////////.....Jlabel-1..(Book No-1 image)........./////////////////////
			
			
			JLabel lable1 = new JLabel(icon1);
			lable1.setBounds(75,140,193,280);
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
			
			Font silver = new Font ("Arial", Font.BOLD,16);
			JLabel lable2 = new JLabel("Deyal");
			lable2.setBounds(142,430,130,20);
			lable2.setFont(silver);
			
			//////////////////////.....Jlabel-3( 1 no Book price)........./////////////////////
			
			Font pric = new Font ("Arial", Font.BOLD,16);
			JLabel lable3 = new JLabel("TK. 730.0");           
			lable3.setBounds(130,456,90,20);                      
			lable3.setFont(pric);
			
	
			
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
											//FERA//

						
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
			
			
//////////////////////.....Fera Image Label........./////////////////////
			JLabel lable4 = new JLabel(new ImageIcon(book_path));
			lable4.setBounds(395,140,200,280);
			lable4.setOpaque(true);
			lable4.setBackground(OFF_WHITE);
		    // lable4.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			
			//Image Hover
		    lable4.addMouseListener(new java.awt.event.MouseAdapter(){
				public void mouseEntered(java.awt.event.MouseEvent evt){
					lable4.setBackground(LIGHT_RED);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				lable4.setBackground(OFF_WHITE);
			}});
		   
//////////////////////.....Fera Text Labels........./////////////////////
			
			Font data = new Font ("Arial", Font.BOLD,16);
			JLabel lable5 = new JLabel(book_name);
			lable5.setBounds(473,430,120,20);
			lable5.setFont(data);
			
			Font pr = new Font ("Arial", Font.BOLD,16);
			JLabel lable6 = new JLabel("TK. "+book_Price);
			lable6.setBounds(455,456,100,20);
			lable6.setFont(pr);
			
			
//////////////////////.....Fera View Button........./////////////////////		
		   JButton view_Fera_Button = new JButton("View Details");
		    view_Fera_Button.setBounds(442,485,100,30);//
		    view_Fera_Button.setFont(new Font ("Arial", Font.BOLD,10));
		    view_Fera_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    view_Fera_Button.setFocusPainted(false);
		    view_Fera_Button.setBackground(Color.WHITE);
		    view_Fera_Button.setForeground(LIGHT_BLUE);
		   
		   

			////View2 Button Hover
			view_Fera_Button.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt){
					view_Fera_Button.setBackground(LIGHT_BLUE);
					view_Fera_Button.setForeground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt){
				view_Fera_Button.setBackground(Color.WHITE);
				view_Fera_Button.setForeground(LIGHT_BLUE);
			}});
			
//////////////////////.....Fera View Button Listener........./////////////////////
			view_Fera_Button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
					formatter.format("%s\r\n", "8");
					formatter.close();  
					
				}catch(Exception f)    {System.out.println("Problem in runnung file view-2 Fera");}
				
				fr.setVisible(false);
				new Details_Panel();
			}});
			
			
			if(book_Id!=null){
				c.add(lable4);
				c.add(lable5);
				c.add(lable6);
				c.add(view_Fera_Button);
			}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
			
			
			
			c.add(lable1);
			c.add(lable2);
			c.add(lable3);
			
			
		
		
		
/////////////////////////////////////////////////////////////View details batton////////////////////////////////
		
		///////Front size......................................
		        Font viewfont = new Font ("Arial", Font.BOLD,10);
		
		//////View 1 Batton................
		
		   Cursor view1carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view1batton = new JButton("View Details");
		   view1batton.setBounds(115,485,100,30);//
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
		
		
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		////////////////Back to Home Button
		   JButton back_to_home = new JButton();
		   back_to_home.setBounds(7,80,34,30);//
		   back_to_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   back_to_home.setFocusPainted(false);
		   back_to_home.setToolTipText("Home");
		   c.add(back_to_home);
		   back_to_home.setContentAreaFilled(false);
           back_to_home.setFocusPainted(false);
           back_to_home.setBorderPainted(false);
		
		////////////////Back to Book Button
		   JButton back_to_book = new JButton();
		   back_to_book.setBounds(65,80,37,30);//
		   back_to_book.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   back_to_book.setFocusPainted(false);
		   back_to_book.setToolTipText("All Books");
		   c.add(back_to_book);
		   back_to_book.setContentAreaFilled(false);
           back_to_book.setFocusPainted(false);
           back_to_book.setBorderPainted(false);
		
		///////////////Back Batton
		
		   Cursor backcarsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton backbatton = new JButton();
		   backbatton.setBounds(16,525,45,27);//
		   backbatton.setCursor(backcarsor);
		   backbatton.setFocusPainted(false);
		   backbatton.setToolTipText("Back");
		   c.add(backbatton);
		   backbatton.setContentAreaFilled(false);
           backbatton.setFocusPainted(false);
           backbatton.setBorderPainted(false);

		
		
		
		
		//Cart Button
		JButton cart_Button = new JButton();
		cart_Button.setBounds(920,20,40,40);//
		cart_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cart_Button.setToolTipText("My Cart");
		cart_Button.setContentAreaFilled(false);
        cart_Button.setFocusPainted(false);
        cart_Button.setBorderPainted(false);
		c.add(cart_Button);
		
		
		
		
		
//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("Images\\MoreBooks2.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);		
		
//////////////////////////////////////////////////////(Action listener for all button)//////////////////////////////////////////////////////////
				
		backbatton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new MoreBooks1();
				
			}
		});
		
		cart_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new View_Cart();
				
			}
		});
		
	//Back to Home button Listener 
		back_to_home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Home();
				
			}
		});
		
	//Back to Book button Listener 
		back_to_book.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new AllBooks();
				
			}
		});
		
		
		
		
////////////////////////////////////////////////Action listener for view details button/////////////////////////////////////////////////
		
		/////////////////view 1..................................
		
		view1batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
					
					
					formatter.format("%s\r\n", "5");
					formatter.close();  
            
				}catch(Exception f)    {System.out.println("Problem in runnung file view-1");}
				
				fr.setVisible(false);
				new Details_Panel();
			}
		});
		
		
		
		
		
		   fr.setVisible(true);
		
		}
		
}