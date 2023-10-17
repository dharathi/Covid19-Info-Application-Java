import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.IIOException;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class Trend extends WindowAdapter implements ActionListener
{
	static JFrame f;
	static JLabel l;
	JPanel p;
	JLabel g1,g2;
	JRadioButton lin,log;
	
	public Trend()
	{
		JFrame f=new JFrame();
		p = new JPanel();
		l=new JLabel("Trend Graph");
		l.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		l.setBounds(540, 450, 800, 90);
		f.setSize(900,900);
		
		lin=new JRadioButton("Linear");
        log=new JRadioButton("Logarithmic");
        lin.setBounds(530, 570, 90, 50);
        log.setBounds(630, 570, 120, 50);
        
        lin.setBackground(Color.decode("#a0c4ba"));
        log.setBackground(Color.decode("#a0c4ba"));
        
        lin.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lin.addActionListener(this);
        log.addActionListener(this);
        log.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        
		
		ButtonGroup group = new ButtonGroup();
		group.add(lin);
		group.add(log);
		
		p.add(l);
		
		p.setBackground(Color.decode("#a0c4ba"));
		
		f.add(lin);
		f.add(log);
		f.add(l);
		f.add(p);
		
		f.setTitle("Trend Graphs Page");
		
		f.setExtendedState( f.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
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
	
	void setimage1() throws IOException
	{
		String IMG_PATH="D:\\covidgraph1.jpg";
		BufferedImage img = ImageIO.read(new File(IMG_PATH));
		ImageIcon icon = new ImageIcon(img);
		g1=new JLabel(icon);
		p.add(g1);
		lin.setSelected(true);
		
	}
	
	void setimage2() throws IOException
	{
		String IMG_PATH="D:\\covidgraph2.jpg";
		BufferedImage img = ImageIO.read(new File(IMG_PATH));
		ImageIcon icon = new ImageIcon(img);
		g2=new JLabel(icon);
		p.add(g2);
		log.setSelected(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
    {
		Trend o=new Trend();
        if(lin.isSelected())
			try {
				o.setimage1();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(log.isSelected())
			try {
				o.setimage2();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    } 
	
}