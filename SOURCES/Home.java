import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
//import java.awt.datatransfer.*;
//real
class Home extends JFrame
{
	
		JFrame fr;
		JLabel l1;  
		JRadioButton r1, r2, r3;
		Thread th;
	    Color LIGHT_RED = new Color (255,102,102);
	    Color LIGHT_BLUE = new Color (51,153,255);
	    Color Dark_CYAN = new Color (14,161,177);
		Color OFF_WHITE = new Color (238,238,238);
		
	public Home(){ 
	
	fr = new JFrame("Home");
    fr.setSize(1000,600);
	fr.setLocationRelativeTo(null);
	fr.setLayout(null);
	Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	fr.setIconImage(frame_icon);
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
//button
	
	
	Font bFont = new Font ("Arial", Font.BOLD,15);//Font
	JButton b=new JButton("HOME");  
    b.setBounds(00,00,250,50);
    b.setFocusPainted(false);	
    b.setBackground(LIGHT_RED);
	b.setForeground(Color.BLACK);
    b.setFont(bFont);
    b.setCursor(new Cursor(Cursor.HAND_CURSOR));	
    fr.add(b);        
    fr.setLayout(null);  
 
	Font b2Font = new Font ("Arial", Font.BOLD,15);//Font
	JButton b2=new JButton("BOOKS");  
    b2.setBounds(250,00,250,50);
    b2.setFocusPainted(false);	
    b2.setBackground(Dark_CYAN);
	b2.setForeground(Color.WHITE);
	b2.setFont(b2Font);
	b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    fr.add(b2);        
    fr.setLayout(null);  
    //fr.setVisible(true);
	
	JButton b3=new JButton("ACCOUNT");  
    b3.setBounds(500,00,250,50);
    b3.setFocusPainted(false);	
    b3.setBackground(Dark_CYAN);
	b3.setForeground(Color.WHITE);
	b3.setFont(b2Font);
	b3.setCursor(new Cursor(Cursor.HAND_CURSOR));	
    fr.add(b3);        
    fr.setLayout(null);  
    //fr.setVisible(true);
	
	JButton b4=new JButton("CONTACT US");  
    b4.setBounds(750,00,250,50);
	b4.setFocusPainted(false);
    b4.setBackground(Dark_CYAN);
	b4.setForeground(Color.WHITE);
	b4.setFont(b2Font);
	b4.setCursor(new Cursor(Cursor.HAND_CURSOR));	
    fr.add(b4);        
    fr.setLayout(null);  
   // fr.setVisible(true);
   
   
//discount button
    JButton b5=new JButton();  
    b5.setBounds(00,200, 986,100);
    b5.setFocusPainted(false);	
	b5.setToolTipText("Discount Coupon");
	b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
    fr.add(b5);	
    fr.setLayout(null); 
    b5.setContentAreaFilled(false);
    b5.setFocusPainted(false);
	b5.setBorderPainted(false);	
	
	
	
	b2.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
			b2.setBackground(LIGHT_RED);
			b2.setForeground(Color.BLACK);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
			b2.setBackground(Dark_CYAN);
			b2.setForeground(Color.WHITE);
		}
	});
	
	b3.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        b3.setBackground(LIGHT_RED);
	    b3.setForeground(Color.BLACK);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        b3.setBackground(Dark_CYAN);
		b3.setForeground(Color.WHITE);
    }
    });
	
	b4.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        b4.setBackground(LIGHT_RED);
		b4.setForeground(Color.BLACK);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
       b4.setBackground(Dark_CYAN);
	   b4.setForeground(Color.WHITE);
		}
    }
	);
    
			//label
			
			l1 = new JLabel(new ImageIcon());	
			l1.setBounds(00,50, 986,150);  
			fr.add(l1);
			
			JLabel l2 = new JLabel(new ImageIcon("Images\\discount.jpg"));
			l2.setBounds(00,200, 986,100);  
			fr.add(l2);
			
			
			
			r1 = new JRadioButton();
			r1.setContentAreaFilled(false);			
			r1.setBounds(415,150,20,20);
			r1.setSelected(true);
			fr.add(r1);
			
			
			
			r2 = new JRadioButton();
			r2.setBounds(465,150,20,20);
			r2.setContentAreaFilled(false);
			r2.setSelected(true);		
			fr.add(r2);
			
			r3 = new JRadioButton();
			r3.setBounds(515,150,20,20);
            r3.setContentAreaFilled(false);			
			r3.setSelected(true);	
			fr.add(r3);
////////////////////////////////////////////////BOOKS////////////////////////////////////////////////////////////////////////////////////
		
		ImageIcon icon1 = new ImageIcon("Book_Images\\Home_Screen_Book\\Novice.jpg");           
		ImageIcon icon2 = new ImageIcon("Book_Images\\Home_Screen_Book\\Remedy.jpg");           
		ImageIcon icon3 = new ImageIcon("Book_Images\\Home_Screen_Book\\Attojiboni.jpg");
		
		////////////////////////////////book 1(Image sutup)//////////////////////////////////////////////////////////
		
			JLabel lable1 = new JLabel(icon1);
			lable1.setBounds(85,300,147,209);
			lable1.setOpaque(true);
		    // lable1.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			fr.add(lable1);
			
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
			JLabel lable2 = new JLabel("Novice");
			lable2.setBounds(137,509,130,20);
			lable2.setFont(silver);
			lable2.setCursor(lebl2);
			fr.add(lable2);
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////book2///////////////////
		    JLabel lable3 = new JLabel(icon2);
			lable3.setBounds(408,300,147,209);
			lable3.setOpaque(true);
		    // lable3.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			fr.add(lable3);
			
			//Image Hover
		    lable3.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseEntered(java.awt.event.MouseEvent evt) {
				lable3.setBackground(LIGHT_RED);
			}

			   public void mouseExited(java.awt.event.MouseEvent evt) {
				lable3.setBackground(OFF_WHITE);
				
			}
			
		   });
		   
		   //////////////////////.....Jlabel-5(2 no book name)........./////////////////////
			
			Cursor lebl4 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font data = new Font ("Arial", Font.BOLD,16);
			JLabel lable4 = new JLabel("Remedy");
			lable4.setBounds(452,509,120,20);
			lable4.setCursor(lebl4);
			lable4.setFont(data);
			fr.add(lable4);
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			                                                               //3 no Book
			
			
			//////////////////////.....Jlabel-7...(3 No Book)........./////////////////////
			
			
			JLabel lable5 = new JLabel( icon3);
			lable5.setBounds(749,300,147,209);
			lable5.setOpaque(true);
		    // lable5.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		    fr.add(lable5);

		    //Image Hover
		    lable5.addMouseListener(new java.awt.event.MouseAdapter() {
			   public void mouseEntered(java.awt.event.MouseEvent evt) {
				lable5.setBackground(LIGHT_RED);
			}

			   public void mouseExited(java.awt.event.MouseEvent evt) {
				lable5.setBackground(OFF_WHITE);
				
			}
			
		   });
		   
		   
		   //////////////////////.....Jlabel-8(3 no Book Nmae)........./////////////////////
			
			Cursor lebl6 = new Cursor(Cursor.TEXT_CURSOR);/////Text cursor.......
			Font hoor = new Font ("Arial", Font.BOLD,16);
			JLabel lable6 = new JLabel("Attojiboni");           
			lable6.setBounds(790,509,120,20);                      
			lable6.setCursor(lebl6);
			lable6.setFont(hoor);
			fr.add(lable6);
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			
			
			//Button
			///////Front size......................................
		        Font viewfont = new Font ("Arial", Font.BOLD,10);
		
		//////View 1 Batton................
		
		   Cursor view1carsor = new Cursor(Cursor.HAND_CURSOR);
		   JButton view1batton = new JButton("View Details");
		   view1batton.setBounds(110,530,100,25);//
		   view1batton.setFont(viewfont);
		   view1batton.setCursor(view1carsor);
		   view1batton.setFocusPainted(false);
		   view1batton.setBackground(Color.WHITE);////////////////////////Dark_CYAN
		   view1batton.setForeground(LIGHT_BLUE);
		   fr.add(view1batton);

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
		   view2batton.setBounds(435,530,100,25);//
		   view2batton.setFont(viewfont);
		   view2batton.setFocusPainted(false);
		   view2batton.setCursor(view2carsor);
		   view2batton.setBackground(Color.WHITE);
		   view2batton.setForeground(LIGHT_BLUE);
		   fr.add(view2batton);

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
		   view3batton.setBounds(775,530,100,25);//
		   view3batton.setFont(viewfont);
		   view3batton.setFocusPainted(false);
		   view3batton.setCursor(view3carsor);
		   view3batton.setBackground(Color.WHITE);
		   view3batton.setForeground(LIGHT_BLUE);
		   fr.add(view3batton);

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
		
		
	
			
			
			
////////////////////////////////////////////////////////////////////Action Listeners////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////Upper Button Action LIstener/////////////////////////////////////////////////
		
//Books
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent w){
				fr.setVisible(false);
				new AllBooks();
			}
		});


//Account
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent w){
				fr.setVisible(false);
				new Account_Panel();
			}
		});
		
//Contact Us
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent w){
				fr.setVisible(false);
				new Contact_Us();
			}
		});


//Action Listener for Discount Banner
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent w){
				fr.setVisible(false);
				new Discount_Panel();
			}
		});
		
////////////////////////////////////////////////Action listener for view details buttons/////////////////////////////////////////////////
    
    /////////////////view 1..................................
    
		view1batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
			  
			  
					formatter.format("%s\r\n", "7");
					formatter.close();  
				
				}catch(Exception f)    {System.out.println("Problem in runnung file view-1");}
				
				fr.setVisible(false);
				new Details_Panel();
			}
		});
    
    
    ///////////////////////////////View-2 ..................................
    
		view2batton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
			public void actionPerformed(ActionEvent e){
				try{
			  Formatter formatter=new Formatter("TXT FILES\\Running_Book.txt");
			  
			  
			  formatter.format("%s\r\n", "3");
			  formatter.close();  
				
			}catch(Exception f)    {System.out.println("Problem in runnung file view-3");}
			
			fr.setVisible(false);
			new Details_Panel();
		  }
		});
			
		
		th = new Thread(rr);
		th.start();
		fr.setVisible(true);
}
//////////////////////////////////////////////////////slide show/////////////////////////////////////////////////////	
		Runnable rr = ()->{
			try{
				while(true){
					th.sleep(0000); ///////////////////////////////for 3 second....
					l1.setIcon(new ImageIcon("Images\\user1.jpg"));
					r1.setSelected(true);
					r2.setSelected(false);
					r3.setSelected(false);
										
					th.sleep(1500);
					l1.setIcon(new ImageIcon("Images\\user2.jpg"));
					r1.setSelected(false);
					r2.setSelected(true);
					r3.setSelected(false);
					
					th.sleep(3000);
					l1.setIcon(new ImageIcon("Images\\user3.jpg"));
					r1.setSelected(false);
					r2.setSelected(false);
					r3.setSelected(true);
					th.sleep(1500);
				}
				
			}catch(Exception e)		{System.out.println("Slide Problem");}
		};
					
				
}