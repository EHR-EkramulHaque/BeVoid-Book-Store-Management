import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.*;
import java.io.*;

public class CartPrint implements Printable, ActionListener {
	
	int total_orderNo, orderfileIs;
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	String order, order_orderID, order_bookName, order_userPhone, order_userEmail, order_quantity, order_price, order_userName;
	
	static String address="";
	
	

	public CartPrint(String a){
		address=a;
	}
public CartPrint(){}


    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

        if (page > 0) { /* Have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());


		g.setFont(new Font("Seqoe UI", Font.PLAIN, 16));
        /* Now we perform our rendering */
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////ORDER Information///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
					
			total_orderNo= Integer.parseInt(orderNo);
			total_orderNo=total_orderNo-1;
						
		}catch(Exception f)		{System.out.println("Problem Running file user in cart print");}

//Getting Running Order 
		try{
			File running_user_File = new File("TXT_CART\\Temp_Cart_OrderID.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				order=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running Order file problem in cart print");
		}

//Getting Running Order Information
		for(int i=1; i<=total_orderNo; i++)
		{
			String Order_File_NO="TXT_CART\\Orders\\Ordered_Book\\Cart_Order--"+i+".txt";
						
			try{
				File order_File = new File(Order_File_NO);		
				Scanner scanFile = new Scanner(order_File);//Scan File
						
				while(scanFile.hasNext()){
					order_orderID=scanFile.next();
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
			}catch(Exception f)		{System.out.println("Order File Problem in print Panel");}
		}
		
/////////////////////////////////////////////////////////////////Getting Book Information////////////////////////////////////////////////////////////////////////


//Getting Books Name 
						
			String book_Name="";
			String bookName_Path="TXT_CART\\Orders\\BOOK_NAME\\Book_For_Order--"+orderfileIs+".txt";
					
			try{
				File orders_Book_File = new File(bookName_Path);		
				Scanner scanOrderdBookFile = new Scanner(orders_Book_File);//Scan File
							
				while(scanOrderdBookFile.hasNext()){
					book_Name= book_Name+scanOrderdBookFile.next()+ " || ";
				}
				scanOrderdBookFile.close();
			}catch(Exception f)		{System.out.println("Book File problem in Print");}
		
		
		
		
		
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Image img = Toolkit.getDefaultToolkit().getImage("Images\\print_Image.jpg");
        
		g.drawImage(img,110,80,null);
		
		
		g.drawString("Books Name           :  "+"||"+book_Name, 100, 260);
		g.drawString("Order ID                  :  "+order_orderID, 100, 285);
        g.drawString("Name                      :  "+order_userName, 100, 310);
        g.drawString("Phone Number       :  "+order_userPhone, 100, 335);
        g.drawString("Email Address        :  "+order_userEmail, 100, 360);
        g.drawString("Book Quantity         :  "+order_quantity, 100, 385);
        g.drawString("Order Amount         :  "+order_price, 100, 410);
        g.drawString("Delivery Address    :  "+address, 100, 435);

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
              System.out.println("Cart Print problem");
             }
         }
    }
}