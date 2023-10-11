import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.*;
import java.io.*;

public class Print_Operation implements Printable, ActionListener {
	
		int total_orderNo, orderfileIs;
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	String order, order_orderID, order_bookName, order_userPhone, order_userEmail, order_quantity, order_price, order_userName;
	static String address="";

	public Print_Operation(String a){
		address=a;
	}
public Print_Operation(){
	}


    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) { /* Have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());


		g.setFont(new Font("Seqoe UI", Font.PLAIN, 16));
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////ORDER Information///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Getting TOtal Order NO 
		String orderNo="";
		try{
			File orderFile = new File("TXT FILES\\OrderFileNo.txt");		
			Scanner scanFile = new Scanner(orderFile);//Scan File
						
			while(scanFile.hasNext()){
				orderNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			total_orderNo= Integer.parseInt(orderNo);
			total_orderNo=total_orderNo-1;
						
		}catch(Exception f)		{System.out.println("Problem Running file user in Confirm");}

//Getting Running Order 
		try{
			File running_user_File = new File("TXT FILES\\tempOrder.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				order=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running Order file problem in Confirm Panel");
		}

//Getting Running Order Information
		for(int i=1; i<=total_orderNo; i++)
		{
			String Order_File_NO="TXT FILES\\Order_Info\\Order-"+i+".txt";
						
			try{
				File order_File = new File(Order_File_NO);		
				Scanner scanFile = new Scanner(order_File);//Scan File
						
				while(scanFile.hasNext()){
					order_orderID=scanFile.next();
					order_bookName=scanFile.next();
					order_userPhone=scanFile.next();
					order_userEmail=scanFile.next();
					order_quantity=scanFile.next();
					order_price=scanFile.next();
					order_userName=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(order_orderID.equals(order))
				{
					orderfileIs=i;
					break;
				}
			}catch(Exception f)		{System.out.println("Order File Problem in Confirm Panel");}
		}
		
/////////////////////////////////////////////////////////////////Getting Book Information////////////////////////////////////////////////////////////////////////
//Gtting The Book ID
	String runtxt="";

	try{
			File running_user_File = new File("TXT FILES\\Running_Book.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running txt problem");
		}
		
//Getting Book Info

	String User_Information_File_Path="TXT FILES\\Book Information\\Book-"+runtxt+".txt";
						
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
			}catch(Exception f)		{System.out.println("Book Info file problem");}

		
		
////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Image imglogo = Toolkit.getDefaultToolkit().getImage("Images\\print_Image.jpg");
        
		g.drawImage(imglogo,110,50,null);
		
		
		Image img = Toolkit.getDefaultToolkit().getImage(book_path);
        
		g.drawImage(img,215,150,null);
		
		
		g.drawString("Order ID                  :  "+order_orderID, 100, 510);
        g.drawString("Name                      :  "+order_userName, 100, 535);
        g.drawString("Phone Number       :  "+order_userPhone, 100, 560);
        g.drawString("Email Address        :  "+order_userEmail, 100, 585);
		g.drawString("Book Name             :  "+order_bookName, 100, 610);
        g.drawString("Book Quantity         :  "+order_quantity, 100, 635);
        g.drawString("Order Amount         :  "+order_price, 100, 660);
        g.drawString("Deliver Address      :  "+address, 100, 685);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
				  JOptionPane.showMessageDialog(null, "Invoice Successfully printed","Print Confirmation",-1,new ImageIcon("Images\\Successful_Icon.png"));
             } catch (PrinterException ex) {
					System.out.println("Print problem in print confirm");
             }
         }
    }

}