import java.awt.event.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class MoreBooks1{
	
		public MoreBooks1()
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
			fr.setTitle("All Books (Page-2)");
			
			
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
			ImageIcon icon1 = new ImageIcon("Book_Images\\Prottaborton.jpg");           
			ImageIcon icon2 = new ImageIcon("Book_Images\\Remedy.jpg");           
			ImageIcon icon3 = new ImageIcon("Book_Images\\Attojiboni.jpg");          
			
			
			
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
			
			Cursor lebl2 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font silver = new Font ("Arial", Font.BOLD,16);
			JLabel lable2 = new JLabel("Prottaborton");
			lable2.setBounds(121,430,130,20);
			lable2.setFont(silver);
			lable2.setCursor(lebl2);
			
			//////////////////////.....Jlabel-3( 1 no Book price)........./////////////////////
			
			Cursor lebl3 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font pric = new Font ("Arial", Font.BOLD,16);
			JLabel lable3 = new JLabel("TK. 690.0");           
			lable3.setBounds(130,456,90,20);                      
			lable3.setCursor(lebl3);
			lable3.setFont(pric);
			
	
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //2 no Book//
			
			
			//////////////////////.....Jlabel-4(2 no Book Image)........./////////////////////
			
			JLabel lable4 = new JLabel(icon2);
			lable4.setBounds(395,140,200,280);
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
			lable5.setBounds(457,430,120,20);
			lable5.setCursor(lebl5);
			lable5.setFont(data);
			
			
			//////////////////////.....Jlabel-6(2 no book price)........./////////////////////
			
			Cursor lebl6 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font pr = new Font ("Arial", Font.BOLD,16);
			JLabel lable6 = new JLabel("TK. 475.0");
			lable6.setBounds(455,456,100,20);
			lable6.setCursor(lebl6);
			lable6.setFont(pr);
			
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //3 no Book
			
			
			//////////////////////.....Jlabel-7...(3 No Book)........./////////////////////
			
			
			JLabel lable7 = new JLabel( icon3);
			lable7.setBounds(720,140,190,281);
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
			lable8.setBounds(780,430,120,20);                      
			lable8.setCursor(lebl8);
			lable8.setFont(hoor);
			
			
			//////////////////////.....Jlabel-9(3 no Book Price)........./////////////////////
			
			Cursor lebl9 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font pri = new Font ("Arial", Font.BOLD,16);
			JLabel lable9 = new JLabel("TK. 625.0");           
			lable9.setBounds(785,456,90,20);                      
			lable9.setCursor(lebl9);
			lable9.setFont(pri);
			
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			
			c.add(lable1);
			c.add(lable2);
			c.add(lable3);
			c.add(lable4);
			c.add(lable5);
			c.add(lable6);
			c.add(lable7);
			c.add(lable8);
			c.add(lable9);

		
		
		
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
		
		
		
		/////////////////////////////////////////View 2//////////////////////////////////////////////////////
		
		//////View(2 No)Batton.....................
		
		   Cursor view2carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view2batton = new JButton("View Details");
		   view2batton.setBounds(442,488,100,30);//
		   view2batton.setFont(viewfont);
		   view2batton.setCursor(view2carsor);
		   view2batton.setFocusPainted(false);
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
		
		//////View3 Batton...................
		
		   Cursor view3carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view3batton = new JButton("View Details");
		   view3batton.setBounds(771,485,100,30);//
		   view3batton.setFont(viewfont);
		   view3batton.setCursor(view3carsor);
		   view3batton.setFocusPainted(false);
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
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		///////////////More Batton
		
		   Cursor morecarsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton morebatton = new JButton("More...");
		   morebatton.setBounds(442,530,100,20);//
		   morebatton.setFont(viewfont);
		   morebatton.setCursor(morecarsor);
		   morebatton.setFocusPainted(false);
		   morebatton.setBackground(Color.WHITE);
		   morebatton.setForeground(LIGHT_BLUE);
		   c.add(morebatton);
			
		////More Batton Hover
		    morebatton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				morebatton.setBackground(LIGHT_BLUE);
				morebatton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				morebatton.setBackground(Color.WHITE);
				morebatton.setForeground(LIGHT_BLUE);
			}
		});
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		///////////////Back Batton
		
		   Cursor backcarsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton backbatton = new JButton();
		   backbatton.setBounds(16,525,45,27);//
		   backbatton.setFont(viewfont);
		   backbatton.setCursor(backcarsor);
		   backbatton.setFocusPainted(false);
		   backbatton.setBackground(Color.WHITE);
		   backbatton.setForeground(LIGHT_BLUE);
		   backbatton.setToolTipText("Back");
		   c.add(backbatton);
		   backbatton.setContentAreaFilled(false);
           backbatton.setFocusPainted(false);
           backbatton.setBorderPainted(false);

		////back Batton Hover
		    backbatton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				backbatton.setBackground(LIGHT_BLUE);
				backbatton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				backbatton.setBackground(Color.WHITE);
				backbatton.setForeground(LIGHT_BLUE);
			}
		});
		
		
		
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
		ImageIcon Newpass_Background = new ImageIcon("Images\\All-Books.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);		
		
		
		
		

///////////////////////////////////////(Action listener )///////////////////////////////////////////////////////
		
		morebatton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new MoreBooks2();
				
			}
		});
		
		
		
		cart_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new View_Cart();
				
			}
		});
		
		backbatton.addActionListener(new ActionListener(){
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

		
		   fr.setVisible(true);
		
		}
		
}