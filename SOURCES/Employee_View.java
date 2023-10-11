import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class Employee_View 
{
	int bookfileNO, totalCustomer, empofileNo;
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	String user, employee_ID, employee_Pass, employee_Name;
	
	Color LIGHT = new Color (38,109,168);
  
	public Employee_View()
  {
    JFrame frame1 =new JFrame();
    frame1.setSize(1000,600);
	frame1.setLocationRelativeTo(null);
    frame1.setResizable(false);
    frame1.setTitle("Employee Dashboard");
    
	frame1.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}else{
						frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
    
    //Container
	Container contain = new Container();
    contain= frame1.getContentPane();
    contain.setLayout(null);
    
	
///////////Owner Label 
			JLabel ownerName = new JLabel("Arefin");
			ownerName.setBounds(955,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			contain.add(ownerName);
			
			
			
	///For frame logo;
    Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	frame1.setIconImage(fr_icon);
    
	
	
	
	
	
	
	
	String customerNo="";
		try{
			File otp_File = new File("TXT FILES\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				customerNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalCustomer= Integer.parseInt(customerNo);
			totalCustomer=totalCustomer-1;
						
		}catch(Exception f)		{System.out.println("User file problem in admin panel");}
	
	
	
	
	
	
	
	
	
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES\\Book_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			bookfileNO= Integer.parseInt(filenumber);
			bookfileNO=bookfileNO-1;
						
		}catch(Exception f)		{System.out.println("Book file no file probelem");}
	
	
	
	
	
//////////////////////////////////////////////////////////////Reading Employee File NO/////////////////////////////////////////////////////
		String empofilenumber="";
		try{
			File otp_File = new File("TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				empofilenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			empofileNo= Integer.parseInt(empofilenumber);
			empofileNo=empofileNo-1;
						
		}catch(Exception f)		{System.out.println("Employee file No Reading Problem in Employee Panel");}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
			System.out.println("Running user file problem in Employee Panel");
		}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Match the Employee got from running user file with the list of Employees
		for(int i=1; i<=empofileNo; i++)
		{
			String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					employee_ID=scanFile.next();
					employee_Pass=scanFile.next();
					employee_Name=scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(employee_ID.equals(user))
				{
					break;
				}
			}catch(Exception f)		{System.out.println("Employee File Problem in Username Panel");}
		}
//Got the all information about user|||||Now time to display them
		
		
		
	
	
	
    // For font;
    Font font =new Font("Arial", Font.BOLD,35);
    //for Total Customer;
    JLabel tb_label = new JLabel(""+totalCustomer);
    tb_label.setBounds(375,65,100,60);
    tb_label.setFont(font);
    contain.add(tb_label);
    
    //For Total Books Label;
    JLabel to_label = new JLabel(""+bookfileNO);
    to_label.setBounds(585,65,100,60);
    to_label.setFont(font);
    contain.add(to_label);
	
	// For font;
    Font fontE =new Font("Arial", Font.BOLD,16);
	//for Employee Name Label;
    JLabel employee_label = new JLabel(employee_Name);
    employee_label.setBounds(850,13,100,60);
    employee_label.setFont(fontE);
	employee_label.setForeground(Color.WHITE);
    contain.add(employee_label);
	
	
	////////////////////////////////////////Button//////////////////////////////
	//for Remove Stock Button;
	JButton remove_button=new JButton("Remove Stock");
	remove_button.setBounds(706,90,125,28);
	remove_button.setFocusPainted(false);
	remove_button.setForeground(LIGHT);
	remove_button.setBackground(Color.WHITE);
	remove_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    contain.add(remove_button);
	//for hover in Update Stock button;
	remove_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				remove_button.setForeground(Color.WHITE);
				remove_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				remove_button.setForeground(LIGHT);
				remove_button.setBackground(Color.WHITE);
			}
		});
	
	// For Update Stock;
	JButton update_button=new JButton("Update Stock");
	update_button.setBounds(847,90,125,28);
	update_button.setFocusPainted(false);
	update_button.setForeground(LIGHT);
	update_button.setBackground(Color.WHITE);
	update_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    contain.add(update_button);
	//for hover in Update Stock button;
	update_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				update_button.setForeground(Color.WHITE);
				update_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				update_button.setForeground(LIGHT);
				update_button.setBackground(Color.WHITE);
			}
		});
    
    //For Add Book button;
    JButton button = new JButton("Add Books");
    button.setBounds(706,130,265,28);
	button.setFocusPainted(false);
	button.setForeground(LIGHT);
	button.setBackground(Color.WHITE);
	button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    contain.add(button);
	
	//for hover in Add Book button;
	button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setForeground(Color.WHITE);
				button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setForeground(LIGHT);
				button.setBackground(Color.WHITE);
			}
		});
		
		
		////Log out Button;
		JButton log_button = new JButton();
		log_button.setBounds(12,12,88,30);
		log_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		log_button.setContentAreaFilled(false);
        log_button.setFocusPainted(false);
        log_button.setBorderPainted(false);
	 	contain.add(log_button);
		
		
	////profile Button;
		JButton profile_button = new JButton();
		profile_button.setBounds(939,18,38,35);
		profile_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		profile_button.setContentAreaFilled(false);
        profile_button.setFocusPainted(false);
        profile_button.setBorderPainted(false);
	 	contain.add(profile_button);
	
	
	
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////// Table related work ///////////////////////////////////////////////////////
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,180,966,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		contain.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,200,966,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		contain.add(label_Row);
		
		
		//Adding Book ID label;
		JLabel bookId_label =new JLabel("Book ID");
		bookId_label.setBounds(60,180,100,20);
		//label_row.setOpaque(true);
		//serial_No.setBackground(Color.BLACK);
		contain.add(bookId_label);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(158,180,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		contain.add(label_colum1);
		
		
		//Book Name label;
		JLabel bookName_label =new JLabel("Book Name");
		bookName_label.setBounds(238,180,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain.add(bookName_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(381,180,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		contain.add(label_colum2);
		
		
		//Category label;
		JLabel category_label =new JLabel("Category");
		category_label.setBounds(430,180,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain.add(category_label);//
		
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(530,180,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		contain.add(label_colum3);
		
		
		//Author Name label;
		JLabel authorName_label =new JLabel("Author Name");
		authorName_label.setBounds(570,175,120,30);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain.add(authorName_label);
		
		//Adding label for colum4;
		JLabel label_colum4=new JLabel();
		label_colum4.setBounds(827,180,1,20);
		label_colum4.setOpaque(true);
		label_colum4.setBackground(Color.BLACK);
		contain.add(label_colum4);
		
		
		// Book Price label;
		JLabel bookPrice_label =new JLabel("Book Price");
		bookPrice_label.setBounds(720,175,120,30);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain.add(bookPrice_label);
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(678,180,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		contain.add(label_colum5);
		
		
		//Book Stock label;
		JLabel bookStock_label =new JLabel("Stock");
		bookStock_label.setBounds(885,175,120,30);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain.add(bookStock_label);
		
		//Adding label for colum6;
		JLabel label_colum6=new JLabel();
		label_colum6.setBounds(975,180,1,20);
		label_colum6.setOpaque(true);
		label_colum6.setBackground(Color.BLACK);
		contain.add(label_colum6);
		
		
		
		
		
		
		
		//for table;
		String order_data[][] = new String [bookfileNO][6];
		
		for(int row=0; row<bookfileNO; row++)
		{
			for(int col=0; col<6; col++)
			{
					String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+(row+1)+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
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
						
						if(col==0){
							order_data[row][col]=book_Id;
						}
						else if(col==1){
							order_data[row][col]=book_name;
						}
						else if(col==2){
							order_data[row][col]=book_category;
						}
						else if(col==3){
							order_data[row][col]=book_author;
						}
						else if(col==4){
							order_data[row][col]=book_Price;
						}
						else if(col==5){
							order_data[row][col]=book_quantity;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("Employee file problem in Employee view");}
				
			}
		}
				
		
		
		
		
		String table_colume[] ={"Book ID","Book Name","Book Category","Author Name","Book Price","Book Stock" };
		JTable table_admin = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		table_admin.setBounds(10,200,966,270);
		table_admin.setRowHeight(20  );
		// table_admin.setFont(new Font ("Arial", Font.PLAIN, 11));
		// JScrollPane scrol = new JScrollPane(table_admin);
		// contain.add(scrol);		
		
		contain.add(table_admin);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_admin.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		
		
		TableColumnModel tcm =table_admin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 10 );
		tcm.getColumn(1).setPreferredWidth( 90 );
		tcm.getColumn(2).setPreferredWidth( 10 );
		tcm.getColumn(3).setPreferredWidth( 10 );
		tcm.getColumn(4).setPreferredWidth( 10 );
		tcm.getColumn(5).setPreferredWidth( 10 );
   
   
  
   
   
   
	///////////////////////////////////////////////////// Action Listener  ////////////////////////////////////
	//For Add Book Button;
    button.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent ae) {
                frame1.setVisible(false);
                new AddingBook();
        }});
		
	//For Update Stock;
	update_button.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent ae) {
                frame1.setVisible(false);
                new Update_stock();
        }});
		
		
	//For Remove Stock;
	remove_button.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent ae) {
            frame1.setVisible(false);
            new RemoveStock();
    }});
	

	//For Log Out;
	log_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {
                int result = JOptionPane.showConfirmDialog (null,"Do you want to Logout?", "Logout Confirmation",JOptionPane.YES_NO_OPTION);
					
				if (result == JOptionPane.YES_OPTION){
						
					frame1.setVisible(false);
					new Login_Panel();
					
				}
        }});
		
		
	//For Log Out;
	profile_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {
                frame1.setVisible(false);
                 new Employee_Account();
        }});
	
	//Container background image;
    ImageIcon bg_image = new ImageIcon("Images\\Employee.jpg");
    
    JLabel bg_label = new JLabel(bg_image);
    bg_label.setBounds(0,0,986,563);
    contain.add(bg_label);
	
	//Frame Visibility;
   frame1.setVisible(true);
  }
}