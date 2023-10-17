import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;    


class CovidCases extends JFrame
{
	JLabel l1,l2,l3,l4,d;
	public CovidCases()
	{
		setSize(500,500);
		
		l1=new JLabel("Worldwide Status");
		l1.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		l1.setBounds(120, 20, 600, 90);
		  
		
		LocalDate today = LocalDate.now();
		
		d=new JLabel(today.toString());
		d.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		d.setBounds(180, 80, 600, 90);
		d.setForeground(Color.decode("#800020"));
		
		l2=new JLabel("Cases:");
		l2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		l2.setBounds(100, 200, 800, 90);
		
		l3=new JLabel("Deaths:");
		l3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		l3.setBounds(100, 250, 800, 90);
		
		l4=new JLabel("Recoveries:");
		l4.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		l4.setBounds(100, 300, 800, 90);
		
		
		add(l1);
		add(d);
		add(l2);
		add(l3);
		add(l4);
		
	}
		
}

