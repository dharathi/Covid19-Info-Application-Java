import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Selection extends WindowAdapter
{
	JFrame f=new JFrame();
	JLabel l1,l2;
	static String data[]=new String[3];
	public Selection()
	{
		
		f.setSize(500,500);
		
		l1=new JLabel("WELCOME");
		l1.setBounds(150, 30, 300, 50);
		l2=new JLabel("What do you want to know?");
		l2.setBounds(140, 100, 300, 50);
		
		String option[]= {"Select","No. of COVID-19 cases today","Symptoms of COVID-19","Trend Graphs"};
		JComboBox cb=new JComboBox(option);
        cb.setEditable(true);
        cb.setBounds(100, 200,290,20);
		
		
		l1.setFont(new Font("Helvetica Neue", Font.PLAIN, 40));
		l2.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		
		cb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		String c;
        		c=(String)(cb.getSelectedItem());
                if(c.equals("No. of COVID-19 cases today"))
                {
                	try {
						data=getinfo();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		CovidCases f=new CovidCases();
            		JLabel cases=new JLabel(data[0]);
            		JLabel deaths=new JLabel(data[1]);
            		JLabel recoveries=new JLabel(data[2]);
            		cases.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            		cases.setBounds(230, 200, 800, 90);
            		cases.setForeground(Color.decode("#2e4884"));
            		f.add(cases);
            		
            		deaths.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            		deaths.setBounds(230, 250, 800, 90);
            		deaths.setForeground(Color.decode("#2e4884"));
            		f.add(deaths);
            		
            		recoveries.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            		recoveries.setBounds(230, 300, 800, 90);
            		recoveries.setForeground(Color.decode("#2e4884"));
            		f.add(recoveries);
            		
            		f.setTitle("Covid-19 Cases Today Page");
            		f.setLayout(null);
            		f.setVisible(true);
            		
            		f.getContentPane().setBackground(Color.decode("#a0c4ba"));
            		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	new CovidCases();
                	
                }
                
                else if(c.equals("Trend Graphs"))
                {
                	new Trend();
                }
                
                else if(c.equals("Symptoms of COVID-19"))
                {
                	new Symptoms();
                	Symptoms sqlConnect = new Symptoms();
                	try {
						sqlConnect.connect();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
        	}
        });
		
		f.add(l1);
		f.add(l2);
		
		f.add(cb);
		
		f.setTitle("Welcome page");
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
	
	static String[] getinfo() throws IOException
	{
		String values[]=new String[3];
		Document d=Jsoup.connect("https://www.worldometers.info/coronavirus/?utm_campaign=homeAdvegas1?").timeout(6000).get();
		Elements ele=d.select("div#maincounter-wrap");
		String sentence=ele.text();
		int i1=sentence.indexOf(':')+1;
		int i2=sentence.indexOf('D');
		values[0]=sentence.substring(i1, i2);
		i2=i2+7;
		values[1]=sentence.substring(i2, sentence.indexOf('R'));
		values[2]=sentence.substring(sentence.indexOf('R')+10);
		return(values);

	}
	
	public static void main(String args[])
	{
		new Selection();
	}
}
