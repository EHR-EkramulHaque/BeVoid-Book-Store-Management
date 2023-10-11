import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class CustomerInfo
{
	int fileNo;
	String user_username, user_password, user_balance, user_email, user_phone, user_gender, user_name;
	
	Color LIGHT = new Color (93,162,209);
	public CustomerInfo()
	{
	 //Main Frame;
		JFrame frame_view = new JFrame();
		frame_view.setTitle("Customer Information");
		frame_view.setSize(1000,600);
		frame_view.setLocationRelativeTo(null);
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame_view.setIconImage(frame_icon);
		frame_view.setResizable(false);
		frame_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
			
		//Font
		Font font = new Font ("Arial",Font.BOLD,25);
		//for Customers  Info JLabel;
		JLabel customer_info = new JLabel("Customer Information");
		customer_info.setBounds(390,20,300,60);
		customer_info.setFont(font);
		contain_view.add(customer_info);
		
		//for Back Button form admin view.
		JButton back_button = new JButton();
		back_button.setBounds(12,526,45,27);
		back_button.setFocusPainted(false);
		back_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_button.setContentAreaFilled(false);
		back_button.setFocusPainted(false);
		back_button.setToolTipText("Back");
        back_button.setBorderPainted(false);
		contain_view.add(back_button);
		
	
	
					String userFileNo="";
					
					try{
						File book_file = new File("TXT FILES\\User_File_No.txt");		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							userFileNo=scanFile.next();
							break;
						}
						
						fileNo = Integer.parseInt(userFileNo);			
						fileNo -=1;		
						
					}catch(Exception f)		{System.out.println("User file No problem in admin view");}
	
	
	
		
		
		
		// Tabel related code;
		
		//Adding label for row1;
		JLabel label_row=new JLabel();
		label_row.setBounds(10,90,966,1);
		label_row.setOpaque(true);
		label_row.setBackground(Color.BLACK);
		contain_view.add(label_row);
		
		//Adding label for row2;
		JLabel label_Row=new JLabel();
		label_Row.setBounds(10,110,966,1);
		label_Row.setOpaque(true);
		label_Row.setBackground(Color.BLACK);
		contain_view.add(label_Row);
		
		
		//Adding Serial No label;
		JLabel serial_No =new JLabel("Serial No");
		serial_No.setBounds(70,90,100,20);
		contain_view.add(serial_No);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(183,90,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		contain_view.add(label_colum1);
		
		
		//Adding Customer Name label;
		JLabel employeeName_label =new JLabel("Customer Name");
		employeeName_label.setBounds(225,90,100,20);
		contain_view.add(employeeName_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(357,90,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		contain_view.add(label_colum2);
		
		
		//Adding Customer Gender label;
		JLabel customerGender_label =new JLabel("Customer Gender");
		customerGender_label.setBounds(389,90,120,20);
		contain_view.add(customerGender_label);
	
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(531,90,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		contain_view.add(label_colum3);
		
		
		//Adding Customer Gender label;
		JLabel employeeID_label =new JLabel("Customer Phone");
		employeeID_label.setBounds(565,90,100,20);
		contain_view.add(employeeID_label);
		
		//Adding label for colum4;
		JLabel label_colum4=new JLabel();
		label_colum4.setBounds(706,90,1,20);
		label_colum4.setOpaque(true);
		label_colum4.setBackground(Color.BLACK);
		contain_view.add(label_colum4);
		
		
		//Adding Customer Email label;
		JLabel employeePass_label =new JLabel("Customer Email");
		employeePass_label.setBounds(795,85,120,30);
		contain_view.add(employeePass_label);
		
		//Adding label for colum5;
		JLabel label_colum5=new JLabel();
		label_colum5.setBounds(975,90,1,20);
		label_colum5.setOpaque(true);
		label_colum5.setBackground(Color.BLACK);
		contain_view.add(label_colum5);
		
		
		//for table;
		String order_data[][] = new String [fileNo][5];
		
		for(int row=0; row<fileNo; row++)
		{
			for(int col=0; col<5; col++)
			{
					String User_Information_File_Path="TXT FILES\\User Information\\User--"+(row+1)+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							user_username=scanFile.next();
							user_password=scanFile.next();
							user_email=scanFile.next();
							user_phone=scanFile.next();
							user_gender=scanFile.next();
							user_balance=scanFile.next();
							user_name=scanFile.next()+" "+scanFile.next();
							break;
						}
						scanFile.close();
						
						if(col==0){
							order_data[row][col]=""+(row+1);
						}
						else if(col==1){
							order_data[row][col]=user_name;
						}
						else if(col==2){
							order_data[row][col]=user_gender;
						}
						else if(col==3){
							order_data[row][col]=user_phone;
						}
						else if(col==4){
							order_data[row][col]=user_email;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("Employee file problem in Employee view");}
				
			}
		}
					
		
		String table_colume[] ={"Serial","Customer Name","Customer Gender","Customer Phone", "Customer Email"};
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
		// contain_view.add(scrol);		
		
		contain_view.add(table_admin);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_admin.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table_admin.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		
		TableColumnModel tcm =table_admin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 5 );
		tcm.getColumn(1).setPreferredWidth( 10 );
		tcm.getColumn(2).setPreferredWidth( 5 );
		tcm.getColumn(3).setPreferredWidth( 10 );
		tcm.getColumn(4).setPreferredWidth( 110 );
		
	
		//Add Background Image for Admin_View;
		ImageIcon bg_adminView = new ImageIcon("Images\\Customer-Info-and-Employee-Info.jpg");
		
		JLabel bg_Image =new JLabel(bg_adminView);
		bg_Image.setBounds(0,0,986,563);
		contain_view.add(bg_Image);
		
		// For Add-Employee button Action;
		back_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame_view.setVisible(false);
				new Admin_View();
			}});
		
		frame_view.setVisible(true);
	}
}