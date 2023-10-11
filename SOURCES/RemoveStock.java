import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class RemoveStock extends JFrame
{
	int fileNo, fileIs;
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	
	Color LIGHT = new Color (255, 179, 128);
	public RemoveStock()
	{
		JFrame remove_frame =new JFrame("Remove Book Stock");
		remove_frame.setSize(1000,600);
		remove_frame.setLocationRelativeTo(null);
		remove_frame.setResizable(false);
		remove_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		remove_frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						remove_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
					}else{
						remove_frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
    
    //Container
	Container contain = new Container();
    contain= remove_frame.getContentPane();
	contain.setBackground(Color.WHITE);
    contain.setLayout(null);

   ///////////Owner Label 
			JLabel ownerName = new JLabel("Arefin");
			ownerName.setBounds(955,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			contain.add(ownerName);
	
	
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
								
			}catch(Exception f)		{System.out.println("Running Book file No Reading Problem in Remove stock Panel");}
	
	
	
	
	
	
	
	///For frame logo;
    Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
	remove_frame.setIconImage(fr_icon);
		
		
		
		
		
	//////////////////////////////// Book ID Label ///////////////////////////
	JLabel bookId_label = new JLabel("Book ID");
	bookId_label.setBounds(680,210,60,25);
	contain.add(bookId_label);
		
		
	///////////////////////////// Book ID Text Field //////////////////////////
	JTextField bookId_text = new JTextField();
	bookId_text.setBounds(560,237,300,30);
	new TextPrompt("Enter Book ID", bookId_text);
	contain.add(bookId_text);
		
		
	/////////////////////////////////////////// Button //////////////////////////////
	//remove stock button;
		JButton removeStock_button=new JButton("Remove Stock");
		removeStock_button.setBounds(735,280,125,25);
		removeStock_button.setFocusPainted(false);
		removeStock_button.setForeground(LIGHT);
		removeStock_button.setBackground(Color.WHITE);
		removeStock_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain.add(removeStock_button);
		//for hover in Update book Quantity button;
		removeStock_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				removeStock_button.setForeground(Color.WHITE);
				removeStock_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				removeStock_button.setForeground(LIGHT);
				removeStock_button.setBackground(Color.WHITE);
			}
		});
		
		
		//Back button;
		JButton back_button=new JButton("Back");
		back_button.setBounds(560,280,125,25);
		back_button.setFocusPainted(false);
		back_button.setForeground(LIGHT);
		back_button.setBackground(Color.WHITE);
		back_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain.add(back_button);
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
		
		
//For gif Label;
		JLabel bg_gif_label = new JLabel(new ImageIcon("Images\\Remove_Stock_Gif.gif"));
		// JLabel bg_gif_label = new JLabel();
		bg_gif_label.setBounds(0,50,500,450);
		contain.add(bg_gif_label);
		
//For Background gif Label;
		JLabel bg_label = new JLabel(new ImageIcon("Images\\Remove_Stock.jpg"));
		bg_label.setBounds(0,0,986,563);
		contain.add(bg_label);
////////////////////////////////////// Action Listener ////////////////////////////////////////	
//for  Back Button;	
	back_button.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent ae) {
			remove_frame.setVisible(false);
			new Employee_View();
	}});









//For Remove Stock Button;
		removeStock_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {
				
				String id = bookId_text.getText();
				int book_exist=0;
				
				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+i+".txt";
							
					try{
						File user_file = new File(User_Information_File_Path);		
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
								
								
						if((id.equals(book_Id)))
						{
							book_exist=1;
							fileIs=i;
							break;
						}
					}catch(Exception f)		{System.out.println("Book File Problem in Remove stock Panel");}
				}
				
				
				
				if(bookId_text.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Book ID can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(book_exist!=1)
				{
					JOptionPane.showMessageDialog(null, "Book Doesn't exist","Book Not Found",JOptionPane.WARNING_MESSAGE);
				}
				else{
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Remove "+book_name+"'s Stock?", "Remove Stock Confirmation",JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION){
						
					try{
						String Book_Information_File_Path="TXT FILES\\Book Information\\Book-"+fileIs+".txt";
						Formatter formatter=new Formatter(Book_Information_File_Path);
							
						formatter.format("%s\r\n", book_Id);
						formatter.format("%s\r\n", book_Price);
						formatter.format("%s\r\n", book_name);
						formatter.format("%s\r\n", book_category);
						formatter.format("%s\r\n", book_path);
						formatter.format("%s\r\n", book_author);
						formatter.format("%s\r\n", "0");
							
							
							
						formatter.close();	
					}catch(Exception f)		{System.out.println(f);}
						
					JOptionPane.showMessageDialog(null, "Quantity Stock Successfully Removed","Quantity Updated",1,new ImageIcon("Images\\Successful_Icon.png"));
					
					remove_frame.setVisible(false);
					new Employee_View();
						
					}
				}
		}});
		
		

		
	
	
remove_frame.setVisible(true);	
	}
}