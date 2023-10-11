import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class Admin_View
{
	int totalCustomer, totalEmployee, totalorder, totalBook=0, multitotalorder;
	int bookfileNO;
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	
	String order_ID, order_bookname, order_userPhone, order_userEmail, order_quantity, order_amount, order_userName;
	
	Color LIGHT = new Color (93,162,209);
	public Admin_View()
	{
	 //Main Frame;
		JFrame frame_view = new JFrame();
		frame_view.setTitle("Admin Dashboard");
		frame_view.setSize(1000,600);
		frame_view.setLocationRelativeTo(null);
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame_view.setIconImage(frame_icon);
		frame_view.setResizable(false);
		//Frame Close Confirmation
		frame_view.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						
						
						frame_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}else{
						frame_view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
						
						

						
						
						
		//Container Frame;
		Container contain_view = new Container();
		contain_view = frame_view.getContentPane();
		contain_view.setLayout(null);
	


///////////Owner Label 
			JLabel ownerName = new JLabel("Arefin");
			ownerName.setBounds(955,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			contain_view.add(ownerName);
//////////////////////////////////////////////
//Getting Customer Amount
		String filenumber="";
		try{
			File otp_File = new File("TXT FILES\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalCustomer= Integer.parseInt(filenumber);
			totalCustomer=totalCustomer-1;
						
		}catch(Exception f)		{System.out.println("User file problem in admin panel");}
		
//Getting Employee Amount
		String employeeFileNo="";
		try{
			File otp_File = new File("TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				employeeFileNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalEmployee= Integer.parseInt(employeeFileNo);
			totalEmployee=totalEmployee-1;
						
		}catch(Exception f)		{System.out.println("Employee file problem in admin panel");}


//Getting Order Amount
		String orderFileNo="";
		try{
			File otp_File = new File("TXT FILES\\OrderFileNo.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				orderFileNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalorder= Integer.parseInt(orderFileNo);
			totalorder=totalorder-1;
						
		}catch(Exception f)		{System.out.println("Order file problem in admin panel");}
		
///////////////////////////////////////////////////////////////////////////////////////////////
		String totalbookFileNo="";
		try{
			File otp_File = new File("TXT FILES\\Book_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				totalbookFileNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			bookfileNO= Integer.parseInt(totalbookFileNo);
			bookfileNO=bookfileNO-1;
						
		}catch(Exception f)		{System.out.println("Book file no file probelem");}
//Getting Total BOOKS
		int bookQuantity=0;
		
		for(int i=1; i<=bookfileNO; i++)
		{
			String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+i+".txt";
							
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
				
				bookQuantity = Integer.parseInt(book_quantity);
				
				totalBook = totalBook+bookQuantity;
								
				
			}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
		}




//Getting Multiple order Amount
		String multiOrderNO="";
		try{
			File otp_File = new File("TXT_CART\\Cart_Order_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				multiOrderNO=scanFile.next();
				break;
			}
			scanFile.close();
					
			multitotalorder= Integer.parseInt(multiOrderNO);
			multitotalorder-=1;
						
		}catch(Exception f)		{System.out.println("Multi Order file problem in admin panel");}

///////////////////////////////////////////////////////////////////////

 //for multiple order info Button from admin view
 
		JButton multiple_order_info = new JButton("Multiple Order Info");
		multiple_order_info.setBounds(30,150,142,25);
		multiple_order_info.setFocusPainted(false);
		multiple_order_info.setForeground(LIGHT);
		multiple_order_info.setBackground(Color.WHITE);
		multiple_order_info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(multiple_order_info);
		
		//Add hover in Employee Info button
		multiple_order_info.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				multiple_order_info.setForeground(Color.WHITE);
				multiple_order_info.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				multiple_order_info.setForeground(LIGHT);
				multiple_order_info.setBackground(Color.WHITE);
			}
		});
















		//Font;
		Font font = new Font("Arial",Font.BOLD,35);
		//for Total Customer JLabel;
		JLabel total_customer = new JLabel(""+totalCustomer);
		total_customer.setBounds(165,70,90,60);
		total_customer.setFont(font);
		contain_view.add(total_customer);
		
		//for Total Employee JLabel;
		JLabel total_employee = new JLabel(""+totalEmployee);
		total_employee.setBounds(376,70,90,60);
		total_employee.setFont(font);
		contain_view.add(total_employee);
		
		//for Total book JLabel;
		JLabel total_book = new JLabel(""+totalBook);
		total_book.setBounds(586,70,90,60);
		total_book.setFont(font);
		contain_view.add(total_book);
		
		//for Total order JLabel;
		JLabel total_order = new JLabel(""+(totalorder+multitotalorder) );
		total_order.setBounds(793,70,90,60);
		total_order.setFont(font);
		contain_view.add(total_order);
		
		//for Add Employee Button form admin view.
		JButton add_Employee = new JButton("Add Employee");
		add_Employee.setBounds(844,150,115,25);
		add_Employee.setFocusPainted(false);
		add_Employee.setForeground(LIGHT);
		add_Employee.setBackground(Color.WHITE);
		add_Employee.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(add_Employee);
		
		//Add hover in Add Employee button
		add_Employee.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				add_Employee.setForeground(Color.WHITE);
				add_Employee.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				add_Employee.setForeground(LIGHT);
				add_Employee.setBackground(Color.WHITE);
			}
		});
		
		//for Employee Info Button form admin view.
		JButton employee_info = new JButton("Employee Info");
		employee_info.setBounds(705,150,115,25);
		employee_info.setFocusPainted(false);
		employee_info.setForeground(LIGHT);
		employee_info.setBackground(Color.WHITE);
		employee_info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(employee_info);
		
		//Add hover in Employee Info button
		employee_info.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				employee_info.setForeground(Color.WHITE);
				employee_info.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				employee_info.setForeground(LIGHT);
				employee_info.setBackground(Color.WHITE);
			}
		});
		
		//for Customer Info Button form admin view.
		JButton customer_info = new JButton("Customer Info");
		customer_info.setBounds(180,150,115,25);
		customer_info.setFocusPainted(false);
		customer_info.setForeground(LIGHT);
		customer_info.setBackground(Color.WHITE);
		customer_info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(customer_info);
		
		//Add hover in Customer Info button
		customer_info.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				customer_info.setForeground(Color.WHITE);
				customer_info.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				customer_info.setForeground(LIGHT);
				customer_info.setBackground(Color.WHITE);
			}
		});
		
		//Logout Button
		JButton logout_Button = new JButton();
		logout_Button.setBounds(8,10,92,27);
		logout_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		logout_Button.setContentAreaFilled(false);
		logout_Button.setFocusPainted(false);
		logout_Button.setBorderPainted(false);
		
		contain_view.add(logout_Button);
		
		
		
		
		
		
		// Tabel related work;
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,230,966,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		contain_view.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,250,966,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		contain_view.add(label_Row);
		
		//Adding Serial No label;
		JLabel serial_No =new JLabel("Serial No");
		serial_No.setBounds(55,230,100,20);
		//label_row.setOpaque(true);
		//serial_No.setBackground(Color.BLACK);
		contain_view.add(serial_No);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(158,230,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		contain_view.add(label_colum1);
		
		//Adding Order ID label;
		JLabel orderId_label =new JLabel("Order ID");
		orderId_label.setBounds(250,230,100,20);
		//label_row.setOpaque(true);
		//orderId_label.setBackground(Color.BLACK);
		contain_view.add(orderId_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(381,230,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		contain_view.add(label_colum2);
		
		//Adding Customer Name label;
		JLabel customerName_label =new JLabel("Customer Name");
		customerName_label.setBounds(410,230,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain_view.add(customerName_label);//
		
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(530,230,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		contain_view.add(label_colum3);
		
		//Adding Book Name label;
		JLabel bookName_label =new JLabel("Book Name");
		bookName_label.setBounds(570,230,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain_view.add(bookName_label);//
		
		//Adding label for colum4;
		JLabel label_colum4=new JLabel();
		label_colum4.setBounds(678,230,1,20);
		label_colum4.setOpaque(true);
		label_colum4.setBackground(Color.BLACK);
		contain_view.add(label_colum4);
		
		//Adding Order amount label;
		JLabel orderAmount_label =new JLabel("Order Amount");
		orderAmount_label.setBounds(715,230,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain_view.add(orderAmount_label);
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(827,230,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		contain_view.add(label_colum5);
		
		//Adding Order Quantity label;
		JLabel orderQuantity_label =new JLabel("Order Quantity");
		orderQuantity_label.setBounds(855,230,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		contain_view.add(orderQuantity_label);
		
		//Adding label for colum6;
		JLabel label_colum6=new JLabel();
		label_colum6.setBounds(975,230,1,20);
		label_colum6.setOpaque(true);
		label_colum6.setBackground(Color.BLACK);
		contain_view.add(label_colum6);
		
		//for table;
		String order_data[][] = new String [totalorder][6];
		int temp=totalorder;
		
		for(int row=0; row<totalorder; row++)
		{
			for(int col=0; col<6; col++)
			{
				/* for(int i=1; i<=totalorder; i++)
				{ */
					String User_Information_File_Path="TXT FILES\\Order_Info\\Order-"+temp+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							order_ID=scanFile.next();
							order_bookname=scanFile.next();
							order_userPhone=scanFile.next();
							order_userEmail=scanFile.next();
							order_quantity=scanFile.next();
							order_amount=scanFile.next();
							order_userName=scanFile.next()+" "+scanFile.next();
							break;
						}
						scanFile.close();
						
						if(col==0){
							order_data[row][col]=""+(row+1);
						}
						else if(col==1){
							order_data[row][col]=order_ID;
						}
						else if(col==2){
							order_data[row][col]=order_userName;
						}
						else if(col==3){
							order_data[row][col]=order_bookname;
						}
						else if(col==4){
							order_data[row][col]=order_amount;
						}
						else if(col==5){
							order_data[row][col]=order_quantity;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("order file problem in admin view");}
				/* } */
				
			}
			temp--;
		}
				
		
		
		
		
		String table_colume[] ={"Serial","Order No","Customer Name ","Book Name","Book Price","Order Quantity"};
		JTable table_admin = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		table_admin.setBounds(10,250,966,300);
		table_admin.setRowHeight(20  );
		// table_admin.setFont(new Font ("Arial", Font.PLAIN, 11));
		// JScrollPane scrol = new JScrollPane(table_admin);
		// contain_view.add(scrol);		
		
		contain_view.add(table_admin);
		
		
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
		
	
		//Add Background Image for Admin_View;
		ImageIcon bg_adminView = new ImageIcon("Images\\Admin_Panel_Background.jpg");
		
		JLabel bg_Image =new JLabel(bg_adminView);
		bg_Image.setBounds(0,0,986,563);
		contain_view.add(bg_Image);



///////////////////////////////////////////////////////Action Listeners/////////////////////////////////////////////////////////////////////
		// For Add-Employee button Action;
		add_Employee.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame_view.setVisible(false);
				new Add_Employee();
			}});
			
		//For Employee-Info button Action;
		employee_info.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame_view.setVisible(false);
				new EmployeeInfo();
			}});
		
		//For Customer-Info button Action;
		customer_info.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame_view.setVisible(false);
				new CustomerInfo();
			}});
			
			
		logout_Button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog (null,"Do you want to Logout?", "Logout Confirmation",JOptionPane.YES_NO_OPTION);
					
				if (result == JOptionPane.YES_OPTION){
						
					frame_view.setVisible(false);
					new Login_Panel();
					
				}
				
			}});
			
			
		multiple_order_info.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame_view.setVisible(false);
				new Multiple_order_Info();
			}});
		
		frame_view.setVisible(true);
	}
	public static void main(String[]args)
	{
		new Admin_View();
	}
}