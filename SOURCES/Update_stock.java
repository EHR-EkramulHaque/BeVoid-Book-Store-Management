import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Update_stock
{   

	int bookFileIs, fileNo;
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;

	
	Color LIGHT = new Color (255, 102, 102);
	public Update_stock()
	{
	JFrame up_stock =new JFrame();
    up_stock.setSize(1000,600);
	up_stock.setLocationRelativeTo(null);
    up_stock.setResizable(false);
    up_stock.setTitle("Update Book Stock");
	up_stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	up_stock.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						
						up_stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}else{
						up_stock.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
		
		
		
		
		
		String filenumber="";
			try{
				File otp_File = new File("TXT FILES\\Book_File_No.txt");		
				Scanner scanFile = new Scanner(otp_File);//Scan File
							
				while(scanFile.hasNext()){
					filenumber=scanFile.next();
					break;
				}
				scanFile.close();
							
				fileNo= Integer.parseInt(filenumber);
				fileNo=fileNo-1;
								
			}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Container up_stock_contain = new Container();
		up_stock_contain= up_stock.getContentPane();
		up_stock_contain.setLayout(null);
		
		
		
		
///////////Owner Label 
			JLabel ownerName = new JLabel("Arefin");
			ownerName.setBounds(955,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			up_stock_contain.add(ownerName);
			
			
			
		
		//for frame logo;
		Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		up_stock.setIconImage(fr_icon);
	
		//For Background gif Label;
		JLabel bg_gif_label = new JLabel(new ImageIcon("Images\\Update_Book_Quantity.gif"));
		bg_gif_label.setBounds(0,0,662,563);
		up_stock_contain.add(bg_gif_label);
		
		//Enter Book ID label;
		JLabel bookID_label = new JLabel("Enter Book ID");
		bookID_label.setBounds(700,203,100,25);
		up_stock_contain.add(bookID_label);
		//book id text field;
		JTextField bookID_text=new JTextField();
		bookID_text.setBounds(700,230,250,31);
		new TextPrompt("Enter Book ID",bookID_text);
		up_stock_contain.add(bookID_text);
		
		//Enter book quantity label;		
		JLabel bookQuantity_label = new JLabel("Enter Book Quantity");
		bookQuantity_label.setBounds(700,260,125,25);
		up_stock_contain.add(bookQuantity_label);
		
		//Update book quantity text field;;
		JTextField bookQn_text=new JTextField();
		bookQn_text.setBounds(700,285,250,31);
		new TextPrompt("Enter Book Quantity",bookQn_text);
		up_stock_contain.add(bookQn_text);
		
		//Update book qunatity button;
		JButton updateQ_button=new JButton("Update Quantity");
		updateQ_button.setBounds(825,330,125,25);
		updateQ_button.setFocusPainted(false);
		updateQ_button.setForeground(LIGHT);
		updateQ_button.setBackground(Color.WHITE);
		updateQ_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		up_stock_contain.add(updateQ_button);
		//for hover in Update book Quantity button;
		updateQ_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				updateQ_button.setForeground(Color.WHITE);
				updateQ_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				updateQ_button.setForeground(LIGHT);
				updateQ_button.setBackground(Color.WHITE);
			}
		});
		
		
		//Back button;
		JButton back_button=new JButton("Back");
		back_button.setBounds(700,330,100,25);
		back_button.setFocusPainted(false);
		back_button.setForeground(LIGHT);
		back_button.setBackground(Color.WHITE);
		back_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		up_stock_contain.add(back_button);
		//for hover in Back button;
		back_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back_button.setForeground(Color.WHITE);
				back_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				back_button.setForeground(LIGHT);
				back_button.setBackground(Color.WHITE);
			}
		});
		
			
			
//set Container Background;
		ImageIcon Username_Background = new ImageIcon("Images/update-stock.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		up_stock_contain.add(bg_label);
		
		
		
///////////////////////////////////Action Listeners
		back_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {
				up_stock.setVisible(false);
                new Employee_View();
        }});
		
		
		
		
		updateQ_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {
//////////////////////////////////////////////////////////////////////////////////////////////////////////
				String IDBOOK = bookID_text.getText();
				String addQn = bookQn_text.getText();
			
					
				
				int quantity_Warning=5;
				int Username_Exist_Warning=5;
				
				//Check Quantity ok or not
				for(int i=0; i<addQn.length(); i++)
				{
					if( (addQn.charAt(i)<48) || (addQn.charAt(i)>57) ){
						quantity_Warning=1;
						break;
					}
				}
				
				
				
				
				
				
				
				//Check Book ID Exist or not			
					String username_exist="";
					for(int i=1; i<=fileNo; i++)
					{
						String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+i+".txt";
						
						try{
							File user_file = new File(User_Information_File_Path);		
							Scanner scanFile = new Scanner(user_file);//Scan File
							
							while(scanFile.hasNext()){
								username_exist=scanFile.next();
								break;
							}
							scanFile.close();
							
							
							if((IDBOOK.equals(username_exist)))
							{
								bookFileIs=i;
								Username_Exist_Warning=1;
								break;
							}
						}catch(Exception f)		{System.out.println("Book File Problem in Update stock Panel");}
					}
				
				
				
				
				
				
				
				if(bookID_text.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Book ID can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(bookQn_text.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Book Quantity can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( quantity_Warning!=5 )
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Quantity","Invalid Quantity",JOptionPane.WARNING_MESSAGE);
				}
				else if( Username_Exist_Warning==5 )
				{
					JOptionPane.showMessageDialog(null, "Book ID do not exist","ID not exist",JOptionPane.WARNING_MESSAGE);
				}
				else{
					int qntt=Integer.parseInt(addQn);
					
					if(qntt<1){
						JOptionPane.showMessageDialog(null, "Minimum Quantity must be 1","Invalid Quantity",JOptionPane.WARNING_MESSAGE);						
					}
					else{
						String File_Path="TXT FILES\\Book Information\\Book-"+bookFileIs+".txt";
							
						try{
							File user_file = new File(File_Path);		
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
						
						int newquantity=Integer.parseInt(book_quantity);
						newquantity = newquantity+qntt;
						
						
						
						
						try{
							String Book_Information_File_Path="TXT FILES\\Book Information\\Book-"+bookFileIs+".txt";
							Formatter formatter=new Formatter(Book_Information_File_Path);
							
							formatter.format("%s\r\n", book_Id);
							formatter.format("%s\r\n", book_Price);
							formatter.format("%s\r\n", book_name);
							formatter.format("%s\r\n", book_category);
							formatter.format("%s\r\n", book_path);
							formatter.format("%s\r\n", book_author);
							formatter.format("%s\r\n", ""+newquantity);
							
							
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}
						
					JOptionPane.showMessageDialog(null, "Quantity Updated Successfully","Quantity Updated",1,new ImageIcon("Images\\Successful_Icon.png"));
					
					up_stock.setVisible(false);
					new Employee_View();
					}
				}
				
////////////////////////////////////////////////////////////////////////////////////////////////////////
        }});
		
		
		
		//Frame Visibility;
		up_stock.setVisible(true);
	}
}