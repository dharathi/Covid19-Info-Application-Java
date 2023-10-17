import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Symptoms extends WindowAdapter
{
	JFrame f;
	JLabel heading,l1,l2,l3;
	TextField t1,t2,t3;
	
	String data[]=new String[3];
	String st1="",st2="",st3="";
	
	private final String url="jdbc:postgresql://localhost/covid";
	private final String user="postgres";
	private final String password="dharathi";
	
	Symptoms()
	{
		f=new JFrame();
		f.setSize(1000,1000);
		
		heading=new JLabel("SYMPTOMS");
		heading.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		
		heading.setBounds(400, 3, 600, 90);
		
		l1=new JLabel("Most common symptoms:");
		l2=new JLabel("Less common symptoms:");
		l3=new JLabel("Serious symptoms:");
		
		l1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		l2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		l3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		
		l1.setBounds(50, 50, 500, 50);
		l2.setBounds(50, 250, 500, 50);
		l3.setBounds(50, 450, 500, 50);

		f.add(heading);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		
		f.setTitle("Symptoms Page");
		f.setLayout(null);
		
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
	
	public void connect() throws IOException
	{
		try(Connection connection=DriverManager.getConnection(url, user, password);)
		{
			if(connection!=null)
				System.out.println("Connected!");
			else
				System.out.println("Failed connection");
			
			Statement s1=connection.createStatement();
			ResultSet rs1 = s1.executeQuery("SELECT * FROM symptoms1");
			
			Statement s2=connection.createStatement();
			ResultSet rs2 = s2.executeQuery("SELECT * FROM symptoms2");
			
			Statement s3=connection.createStatement();
			ResultSet rs3 = s3.executeQuery("SELECT * FROM symptoms3");
			
			while(rs1.next())
			{
				st1=st1+rs1.getString("mcs")+" ";
				
			}
			
			while(rs2.next())
			{
				st2=st2+rs2.getString("lcs")+" ";
				
			}
			
			while(rs3.next())
			{
				st3=st3+rs3.getString("ss")+" ";
				
			}
			
			t1=new TextField(st1);
			t1.setBounds(50, 120, 500, 50);
			t1.setBackground(Color.decode("#bf7f8f"));
			t1.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
			f.add(t1);
			f.setVisible(true);
			
			t2=new TextField(st2);
			t2.setBounds(50, 320, 900, 50);
			t2.setBackground(Color.decode("#bf7f8f"));
			t2.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
			f.add(t2);
			f.setVisible(true);
			
			t3=new TextField(st3);
			t3.setBounds(50, 520, 700, 50);
			t3.setBackground(Color.decode("#bf7f8f"));
			t3.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
			f.add(t3);
			f.setVisible(true);
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] agrs)
	{
		new Symptoms();
	}

}
