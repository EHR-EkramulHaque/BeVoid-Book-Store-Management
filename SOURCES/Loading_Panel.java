import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
 
public class Loading_Panel {
    Color LIGHT_RED = new Color (255,102,102);
	Color Dark_BLUE = new Color (30,75,149);
	
	JFrame frame;
    JLabel image=new JLabel(new ImageIcon("Images\\vdw_dribbble.gif"));
    JProgressBar progressBar=new JProgressBar();
    
	
    public Loading_Panel()
    {
		makeSound();
        createGUI();
        addProgressBar();
        addImage();
        
        runningPBar();
		new Login_Panel();
    }
	
	public void makeSound(){
		File appare = new File("Audio\\appare.wav");
		

		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(appare));
			clip.start();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,350);
        frame.setLocationRelativeTo(null);
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Images\\Logo.png");    
		frame.setIconImage(frame_icon);
        frame.setVisible(true);
 
    }
    public void addImage(){
        image.setSize(600,350);
        frame.add(image);
    }
    
    public void addProgressBar(){
        progressBar.setBounds(0,345,615,5);
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(false);
        progressBar.setBackground(Dark_BLUE);
        progressBar.setForeground(LIGHT_RED);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0
 
        while( i<=100)
        {
            try{
                Thread.sleep(37);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                i++;
                if(i==100)
                    frame.setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
}