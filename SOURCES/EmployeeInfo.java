import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class EmployeeInfo
{
	
	String employee_ID, employee_Pass, employee_name;
	int employeefileNO;
	Color LIGHT = new Color (93,162,209);
	
	public EmployeeInfo()
	{
	 //Main Frame;
		JFrame frame_view = new JFrame();
		frame_view.setTitle("Employee Information");
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
		JLabel customer_info = new JLabel("Employee Information");
		customer_info.setBounds(390,20,300,60);
		customer_info.setFont(font);
		contain_view.add(customer_info);
		
		//for Back Button form admin view.
		JButton back_button = new JButton();
		back_button.setBounds(12,526,45,27);
		//back_button.setFocusPainted(false);
		back_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back_button.setContentAreaFilled(false);
        back_button.setFocusPainted(false);
        back_button.setBorderPainted(false);
		back_button.setToolTipText("Back");
		contain_view.add(back_button);
		
		
		
		
		
		
		
					String employeeFileNo="";
					
					try{
						File book_file = new File("TXT FILES\\Employye_File_NO.txt");		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							employeeFileNo=scanFile.next();
							break;
						}
						
						employeefileNO = Integer.parseInt(employeeFileNo);			
						employeefileNO -=1;		
						
					}catch(Exception f)		{System.out.println("Employee file problem in admin view");}
					
					
		
		
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
		serial_No.setBounds(134,90,100,20);
		contain_view.add(serial_No);
		
		//Adding label for colum1;
		JLabel label_colum1=new JLabel();
		label_colum1.setBounds(306,90,1,20);
		label_colum1.setOpaque(true);
		label_colum1.setBackground(Color.BLACK);
		contain_view.add(label_colum1);
		
		
		//Adding Employee Name label;
		JLabel employeeName_label =new JLabel("Employee Name");
		employeeName_label.setBounds(444,90,100,20);
		contain_view.add(employeeName_label);//
		
		//Adding label for colum2;
		JLabel label_colum2=new JLabel();
		label_colum2.setBounds(678,90,1,20);
		label_colum2.setOpaque(true);
		label_colum2.setBackground(Color.BLACK);
		contain_view.add(label_colum2);
		
		
		//Adding Employee ID label;
		JLabel employeeID_label =new JLabel("Employee ID");
		employeeID_label.setBounds(790,90,100,20);
		contain_view.add(employeeID_label);//
		
		//Adding label for colum3;
		JLabel label_colum3=new JLabel();
		label_colum3.setBounds(975,90,1,20);
		label_colum3.setOpaque(true);
		label_colum3.setBackground(Color.BLACK);
		contain_view.add(label_colum3);
		
		
		
		//for table;
		String order_data[][] = new String [employeefileNO][3];
		
		for(int row=0; row<employeefileNO; row++)
		{
			for(int col=0; col<4; col++)
			{
					String User_Information_File_Path="TXT FILES\\Employee Information\\Employee-"+(row+1)+".txt";
					
					
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							employee_ID=scanFile.next();
							employee_Pass=scanFile.next();
							employee_name=scanFile.next();
							break;
						}
						scanFile.close();
						
						if(col==0){
							order_data[row][col]=""+(row+1);
						}
						else if(col==1){
							order_data[row][col]=employee_name;
						}
						else if(col==2){
							order_data[row][col]=employee_ID;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("Employee file problem in Employee view");}
				
			}
		}
				
		
		
		
		
		String table_colume[] ={"Serial","Employee Name","Employee ID "};
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
		
		
		TableColumnModel tcm =table_admin.getColumnModel();
		tcm.getColumn(0).setPreferredWidth( 10 );
		tcm.getColumn(1).setPreferredWidth( 90 );
		tcm.getColumn(2).setPreferredWidth( 10 );
		
		
	
		
	
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