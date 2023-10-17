import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login extends WindowAdapter
{
	JFrame f;
	JButton b,res;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField ps;
	
	private final String url="jdbc:postgresql://localhost/covid";
	private final String user="postgres";
	private final String password="dharathi";
	
	Login()
	{
		f=new JFrame();
		f.setSize(600,600);
		b=new JButton("Log in");
		res=new JButton("Reset");
		
		l1=new JLabel("Enter the phone no:");
		l1.setBounds(200, 100, 300, 50);
		
		t1=new JTextField("");
		t1.setBounds(200, 150, 150, 30);
		
		l2=new JLabel("Enter the password:");
		l2.setBounds(200, 200, 300, 50);
		
		ps=new JPasswordField("");
		ps.setBounds(200, 250, 150, 30);
		
		b.setBounds(225, 350, 80, 50);
		res.setBounds(225, 450, 80, 50);
		
		b.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent evt) 
		    { 
		        try {
					connect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }  
		});
		
		res.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent evt) { 
		        t1.setText("");
		        ps.setText("");
		    }  
		});
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(ps);
		f.add(b);
		f.add(res);
		
		f.setTitle("Login page");
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
	
	public void connect() throws IOException
	{
		try(Connection connection=DriverManager.getConnection(url, user, password);)
		{
			if(connection!=null)
				System.out.println("Connected!");
			else
				System.out.println("Failed connection");
			
			Statement s=connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM users");
			
			String id=t1.getText();
			@SuppressWarnings("deprecation")
			String pas=ps.getText();
			
			
			int flag=0;
			
			while(rs.next())
			{
				if((rs.getString("phno").equals(id))&&(rs.getString("passwd").equals(pas)))
					flag=flag+1;break;
			}
			
			if(flag!=0)
			{
				new Selection();
				f.dispose();
			}
			
			else
			{
				new op1();
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}





