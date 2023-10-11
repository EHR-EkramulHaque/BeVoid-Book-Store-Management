import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class Multiple_order_Info
{
	int totalorder;
	String order_ID, order_userPhone, order_userEmail, order_quantity, order_amount, order_userName;
	
	String Book_name="";
	
	public Multiple_order_Info()
	{
	 //Main Frame;
		JFrame frame = new JFrame();
		frame.setTitle("Multiple Books Order");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
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
						
						

						
						
						
		//Container Frame;
		Container panel = new Container();
		panel = frame.getContentPane();
		panel.setLayout(null);
		
///////////Owner Label 
		JLabel ownerName = new JLabel("Ekramul");
		ownerName.setBounds(948,553,40,10);
		ownerName.setFont(new Font("Arial", Font.BOLD, 9));
		panel.add(ownerName);
//////////////////////////////////////////////
//for Customers  Info JLabel;
		JLabel Multiple_Order_Label = new JLabel("Multiple Books Order Info");
		Multiple_Order_Label.setBounds(350,20,320,60);
		Multiple_Order_Label.setFont(new Font ("Arial",Font.BOLD,25));
		panel.add(Multiple_Order_Label);






////////////////////////////////Tabel related work//////////////////////////////////////////////////
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,90,966,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		panel.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,110,966,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		panel.add(label_Row);
		
		//Adding Serial No label;
		JLabel serial_No =new JLabel("Serial");
		serial_No.setBounds(50,90,100,20);
		//label_row.setOpaque(true);
		//serial_No.setBackground(Color.BLACK);
		panel.add(serial_No);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(121,90,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		panel.add(label_colum1);
		
		//Adding Order ID label;
		JLabel orderId_label =new JLabel("Order ID");
		orderId_label.setBounds(185,90,100,20);
		//label_row.setOpaque(true);
		//orderId_label.setBackground(Color.BLACK);
		panel.add(orderId_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(308,90,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		panel.add(label_colum2);
		
		//Adding Customer Name label;
		JLabel customerName_label =new JLabel("Books Name and Quantity");
		customerName_label.setBounds(455,90,150,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		panel.add(customerName_label);//
		
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(745,90,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		panel.add(label_colum3);
		
		//Adding Book Name label;
		JLabel bookName_label =new JLabel("Customer");
		bookName_label.setBounds(780,90,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		panel.add(bookName_label);//
		
		//Adding label for colum4;
		JLabel label_colum4=new JLabel();
		label_colum4.setBounds(862,90,1,20);
		label_colum4.setOpaque(true);
		label_colum4.setBackground(Color.BLACK);
		panel.add(label_colum4);
		
		//Adding Order amount label;
		JLabel orderAmount_label =new JLabel("Order Amount");
		orderAmount_label.setBounds(877,90,100,20);
		//label_row.setOpaque(true);
		//customerName_label.setBackground(Color.BLACK);
		panel.add(orderAmount_label);
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(975,90,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		panel.add(label_colum5);
		
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
					
			totalorder= Integer.parseInt(orderNo);
			totalorder=totalorder-1;
						
		}catch(Exception f)		{System.out.println("Problem Running file user in Multiple");}
		
		
		//for table;
		String order_data[][] = new String [totalorder][5];
		int temp=totalorder;
		
		for(int row=0; row<totalorder; row++)
		{
			for(int col=0; col<6; col++)
			{
				
					String User_Information_File_Path="TXT_CART\\Orders\\Ordered_Book\\Cart_Order--"+temp+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							order_ID=scanFile.next();
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
							
							order_data[row][col]="";
							String bookName_Path="TXT_CART\\Orders\\BOOK_NAME\\Book_For_Order--"+temp+".txt";
					
							try{
								File orders_Book_File = new File(bookName_Path);		
								Scanner scanOrderdBookFile = new Scanner(orders_Book_File);//Scan File
											
								while(scanOrderdBookFile.hasNext()){
									order_data[row][col]= order_data[row][col]+scanOrderdBookFile.next()+ " || ";
								}
								scanOrderdBookFile.close();
							}catch(Exception f)		{System.out.println("order file problem in Muptiple view");}
							
							order_data[row][col]="|| "+order_data[row][col];
						}
						else if(col==3){
							order_data[row][col]=order_userName;
						}
						else if(col==4){
							order_data[row][col]=order_amount;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("order file problem in admin view");}
				
				
			}
			temp--;
		}
				
		
		
		
		
		String table_colume[] ={"Serial","Order ID","Books Name","User Name","Order Amount"};
		JTable table_admin = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		table_admin.setBounds(10,110,966,270);
		table_admin.setRowHeight(20  );
		// table_admin.setFont(new Font ("Arial", Font.PLAIN, 11));
		// JScrollPane scrol = new JScrollPane(table_admin);
		// panel.add(scrol);		
		
		panel.add(table_admin);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_admin.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		TableColumnModel tcm =table_admin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 5 );
		tcm.getColumn(1).setPreferredWidth( 90 );
		tcm.getColumn(2).setPreferredWidth( 340 );
		tcm.getColumn(3).setPreferredWidth( 20 );
		tcm.getColumn(4).setPreferredWidth( 2 );
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





//Back to Admin view Button
		JButton back_button = new JButton();
		back_button.setBounds(12,526,45,27);
		back_button.setFocusPainted(false);
		back_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_button.setContentAreaFilled(false);
		back_button.setFocusPainted(false);
        back_button.setBorderPainted(false);
		back_button.setToolTipText("Back");
		panel.add(back_button);






//Add Background Image for Admin_View;
		ImageIcon bg_adminView = new ImageIcon("Images\\Customer-Info-and-Employee-Info.jpg");
		
		JLabel bg_Image =new JLabel(bg_adminView);
		bg_Image.setBounds(0,0,986,563);
		panel.add(bg_Image);
		
		
		
////////////////////////////////////////////////////Action Listeners//////////////////////////////////////////////////////////

// Back button 
		back_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Admin_View();
			}});
			
//set visibility
frame.setVisible(true);
	}
}