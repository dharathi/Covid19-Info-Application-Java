import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Page1 extends WindowAdapter
{
	JFrame f;
	JButton b1;
	JLabel l;
	JPanel p;
	int type;
	
	Page1()
	{
		f=new JFrame();
		f.setSize(680,680);
		
		
		b1=new JButton("Log in");
		
		b1.setBounds(300, 300, 90, 50);
		
		l=new JLabel();
		
		l.setText("COVID-19 INFORMATION APPLICATION");
		l.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		
		l.setBounds(50, 80, 600, 90);
		
		b1.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent evt) { 
		        new Login();
		        f.dispose();
		    }  
		}); 
		
		
		f.add(l);
		f.add(b1);
		
		f.setTitle("JAVA CIA 3 1st Page");
		f.setLayout(null);
		f.setVisible(true);
		
		f.getContentPane().setBackground(Color.decode("#a0c4ba"));
		f.addWindowListener(this); 
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 

	}
	
	public void windowClosing(WindowEvent e) 
	{  
	    int a=JOptionPane.showConfirmDialog(f,"Are you sure you want to quit?");  
	    if(a==JOptionPane.YES_OPTION)
		{  
	    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		}
	}



	public static void main(String[] args) 
	{
		new Page1();
		
	}

}
