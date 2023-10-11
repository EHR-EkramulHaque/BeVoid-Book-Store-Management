import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class AddingBook
{
	Color Light =new Color(38, 109, 168);
	
	String book_id="8", book_price, book_name, book_category, book_path, book_author, book_quantity;
	
	public AddingBook()
	{
		JFrame frame=new JFrame();
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Add New Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		//container
		Container ab_Con = new Container();
		ab_Con = frame.getContentPane();
		ab_Con.setLayout(null);
		
		
///////////Owner Label 
			JLabel ownerName = new JLabel("Arefin");
			ownerName.setBounds(955,553,40,10);
			ownerName.setFont(new Font("Arial", Font.BOLD, 9));
			ab_Con.add(ownerName);
			
			
		
		//Adding Icon;
		Image fr_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(fr_icon);
		
		//set font;
		Font font =new Font("Arial", Font.BOLD,16);
		//book name label;
		JLabel bn_label =new JLabel("Book Name");
		bn_label.setBounds(290,77,120,40);
		bn_label.setFont(font);
		ab_Con.add(bn_label);
		// text field for Book Name;
		JTextField bn_text=new JTextField();
		bn_text.setBounds(290,109,422,31);
		new TextPrompt("Enter Book Name",bn_text);
		ab_Con.add(bn_text);
		
		//Author name Label;
		JLabel an_label =new JLabel("Author Name");
		an_label.setBounds(290,135,120,40);
		an_label.setFont(font);
		ab_Con.add(an_label);
		// text field for Author Name;
		JTextField an_text=new JTextField();
		an_text.setBounds(290,170,422,31);
		new TextPrompt("Enter Author Name",an_text);
		ab_Con.add(an_text);
		
		//Category label;
		JLabel cat_label =new JLabel("Category");
		cat_label.setBounds(290,195,120,40);
		cat_label.setFont(font);
		ab_Con.add(cat_label);
		
		
		//for radio button;
		ButtonGroup button_group=new ButtonGroup(); 
		
		JRadioButton islamic_button=new JRadioButton("Islamic Books");
		islamic_button.setBounds(295,225,110,30);
		islamic_button.setSelected(true);
		islamic_button.setFocusPainted(false);
		islamic_button.setContentAreaFilled(false);
		islamic_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ab_Con.add(islamic_button);
		
		JRadioButton others_button=new JRadioButton("Other Books");
		others_button.setBounds(500,225,110,30);
		others_button.setSelected(false);
		others_button.setFocusPainted(false);
		others_button.setContentAreaFilled(false);
		others_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ab_Con.add(others_button);
		
		button_group.add(islamic_button);
		button_group.add(others_button);
		
		
		
		
		//Book Price label;
		JLabel bp_label =new JLabel("Book Price");
		bp_label.setBounds(290,248,120,40);
		bp_label.setFont(font);
		ab_Con.add(bp_label);
		//text field for Book Price;
		JTextField bp_text=new JTextField();
		bp_text.setBounds(290,279,422,31);
		new TextPrompt("Enter Book Price",bp_text);
		ab_Con.add(bp_text);
		
		//Image Path label;
		JLabel imp_label =new JLabel("Image Path");
		imp_label.setBounds(290,310,120,40);
		imp_label.setFont(font);
		ab_Con.add(imp_label);
		//text field for Image Path;
		JTextField imp_text=new JTextField();
		imp_text.setBounds(290,344,422,31);
		new TextPrompt("Enter Book Image Path",imp_text);
		ab_Con.add(imp_text);
		
		//Book quantity label;
		JLabel bq_label =new JLabel("Book Quantity");
		bq_label.setBounds(290,372,120,40);
		bq_label.setFont(font);
		ab_Con.add(bq_label);
		//text field for Book Quantity;
		JTextField bq_text=new JTextField();
		bq_text.setBounds(290,408,422,31);
		new TextPrompt("Enter Book Quantity",bq_text);
		ab_Con.add(bq_text);
		
		
		//AddBook Button;
		JButton adbook_button=new JButton("Add Book");
		adbook_button.setBounds(450,458,100,30);
		adbook_button.setFocusPainted(false);
		adbook_button.setForeground(Light);
		adbook_button.setBackground(Color.WHITE);
		adbook_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ab_Con.add(adbook_button);
		
		//for hover in Add-Book button;
		adbook_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				adbook_button.setForeground(Color.WHITE);
				adbook_button.setBackground(Light);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				adbook_button.setForeground(Light);
				adbook_button.setBackground(Color.WHITE);
			}
		});
		
		
		//Go Back Button;
		JButton goback_button=new JButton();
		goback_button.setBounds(16,525,42,26);
		goback_button.setFocusPainted(false);
		goback_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goback_button.setContentAreaFilled(false);
        goback_button.setFocusPainted(false);
        goback_button.setBorderPainted(false);
		goback_button.setToolTipText("Back");
		ab_Con.add(goback_button);
		
		
		//Background image;
		ImageIcon bg_Image = new ImageIcon("Images\\Addbook1.jpg");
		
		JLabel bg_Label = new JLabel(bg_Image);
		bg_Label.setBounds(0,0,986,563);
		ab_Con.add(bg_Label);
		
///////////////////////////////////Action Listeners////////////////////////////////////

//for go back to previcous page;
		goback_button.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent ae) {
					 frame.setVisible(false);
					 new Employee_View();
				}});
				
				
		
		
		
		
		
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////		
adbook_button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {///////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(islamic_button.isSelected())		{book_category="Islamic";}
			else								{book_category="Others";}
		  //book_id       ="8";
			book_price    = bp_text.getText();
			book_name     = bn_text.getText();
		  //book_category = "Others";
			book_path     = imp_text.getText();
			book_author   = an_text.getText();
			book_quantity = bq_text.getText();
			
	//Checking the Book Price
			int price_Warning=5, author_warning=0, quantity_warning=5, name_warning=5, dotwarning=0, path_warning=5;
			
			
			//Checking Book name valid or not
			for(int i=0; i<book_name.length(); i++)
			{
				if( book_name.charAt(i)==32 ){
					name_warning=1;
					break;
				}
			}
			
			
			//Checking Book author name valid or not
			for(int i=0; i<book_author.length(); i++)
			{
				if( book_author.charAt(i)==32 ){
					author_warning++;
				}
			}
			
			
			//Checking Book price valid or not
			for(int i=0; i<book_price.length(); i++)
			{
				if((book_price.charAt(i)!=46)){
					
					if( (book_price.charAt(i)<48) || (book_price.charAt(i)>57) ){
						price_Warning=1;
						break;
					}
				}
				if((book_price.charAt(i)==46)){
					dotwarning++;
				}
			}
			
			
			//Checking Book path valid or not
			for(int i=0; i<book_path.length(); i++)
			{
				if( book_path.charAt(i)==32 ){
					path_warning=1;
					break;
				}
			}
			
			//Checking Book quantity valid or not
			for(int i=0; i<book_quantity.length(); i++)
			{
				if( (book_quantity.charAt(i)<48) || (book_quantity.charAt(i)>57) ){
					quantity_warning=1;
					break;
				}
			}
				
			
			
		//Giving WARNING
			if( (bn_text.getText().isEmpty()) || (an_text.getText().isEmpty()) || (bp_text.getText().isEmpty()) || (imp_text.getText().isEmpty()) || (bq_text.getText().isEmpty()) )
			{
				if( bn_text.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Book Name can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( an_text.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Author Name can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( bp_text.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Book Price can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( imp_text.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Book Image Path can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Book Quantity can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else if(name_warning!=5)
			{
				JOptionPane.showMessageDialog(null, "Book Name must be single word","WARNING",JOptionPane.WARNING_MESSAGE);
			}
			else if(author_warning>1 || author_warning<1)
			{
				JOptionPane.showMessageDialog(null, "Author Name must be two Word","WARNING",JOptionPane.WARNING_MESSAGE);
			}
			else if(price_Warning!=5 || dotwarning>1)
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Book Price","WARNING",JOptionPane.WARNING_MESSAGE);
			}
			else if(path_warning!=5)
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Book Image Path","WARNING",JOptionPane.WARNING_MESSAGE);
			}
			else if(quantity_warning!=5)
			{
				JOptionPane.showMessageDialog(null, "Enter Valid Book Quantity","WARNING",JOptionPane.WARNING_MESSAGE);
			}
			else{
				
				double price = Double.parseDouble(book_price);
				int bquantity = Integer.parseInt(book_quantity);
				
				if(price<1)
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Book Price","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else if(bquantity<1)
				{
					JOptionPane.showMessageDialog(null, "Enter Valid Book Quantity","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else{
					try{
						Formatter formatter=new Formatter("TXT FILES\\Book Information\\Book-8.txt");
						
						formatter.format("%s\r\n", book_id);
						formatter.format("%s\r\n", ""+price);
						formatter.format("%s\r\n", book_name);
						formatter.format("%s\r\n", book_category);
						formatter.format("%s\r\n", book_path);
						formatter.format("%s\r\n", book_author);
						formatter.format("%s", book_quantity);
						
						
						formatter.close();	
					}catch(Exception f)		{System.out.println("Book 8 no file problem in adding book");}
					
					
					try{
						Formatter formatter2=new Formatter("TXT FILES\\Book_File_No.txt");
						
						formatter2.format("%s", "9");
						
						formatter2.close();	
					}catch(Exception f)		{System.out.println("Book fileNo problem in adding book");}
					
					JOptionPane.showMessageDialog(null, "Book Success Added in Shop","Successfully Book Added",-1,new ImageIcon("Images\\Successful_Icon.png"));
					
					frame.setVisible(false);
					new Employee_View();
				}
				
			}//Else block end
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////
}});////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
//Frame visibility
frame.setVisible(true);	
	}
}