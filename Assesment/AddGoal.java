import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.*;
import org.hibernate.Transaction;

class AddGoal extends JFrame
{
	Container c;
	JTextField txtGno, txtGname, txtGamount;
	JLabel lblGno, lblGname ,lblGamount;
	JButton btnBack,btnSave;
	
	AddGoal()
	{
	c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        lblGno = new JLabel("Enter Goal Number");
        lblGno.setBounds(180,10,140,30);
        lblGno.setFont(new Font("Dialog",Font.BOLD, 16));
        c.add(lblGno);

	txtGno = new JTextField(20);
	txtGno.setBounds(70, 40, 300, 22);
    	txtGno.addKeyListener(new KeyAdapter() 
   	 {
        	public void keyTyped(KeyEvent e) 
        	{
            		char input = e.getKeyChar();
            		if((input < '0' || input > '9') && input != '\b') 
            		{
                		JOptionPane.showMessageDialog(new JDialog(), "Enter Number");
                		e.consume();
            		}		
        	}
    	});
    	c.add(txtGno);


	lblGname = new JLabel("Whats Your Goal");
    	lblGname.setBounds(172, 70, 140, 30);
        lblGname.setFont(new Font("Dialog", Font.BOLD, 16));
    	c.add(lblGname);

	txtGname = new JTextField(20);
   	txtGname.setBounds(70, 100, 300, 22);	
	txtGname.addKeyListener(new KeyAdapter()
    	{
        	public void keyTyped(KeyEvent e)
        	{
            		char input = e.getKeyChar();
           		 if(Character.isDigit(input))
            		{
                		JOptionPane.showMessageDialog(new JDialog(), "Enter Alphabet");
                		e.consume();
            		}
        	}
    	});
    	c.add(txtGname);


	lblGamount = new JLabel("Set goal amount");
        lblGamount.setBounds(150, 130, 200, 30);
        lblGamount.setFont(new Font("Dialog", Font.BOLD, 16));
        c.add(lblGamount);

	txtGamount = new JTextField(20);
	txtGamount.setBounds(70, 160, 300, 22);
    	txtGamount.addKeyListener(new KeyAdapter() 
   	 {
        	public void keyTyped(KeyEvent e) 
        	{
            		char input = e.getKeyChar();
            		if((input < '0') && input != '\b') 
            		{
                		JOptionPane.showMessageDialog(new JDialog(), "amount should be in integers");
                		e.consume();
            		}		
        	}
    	});
    	c.add(txtGamount);

		
	 btnSave = new JButton("Save");
	 btnSave.setBounds(160, 320, 120, 25);
    	 c.add(btnSave);

    	 btnBack = new JButton("Back");
    	 btnBack.setBounds(160, 360, 120, 25);
    	 c.add(btnBack);

	ActionListener a1 = (ae) ->
	{
		Configuration cfg = new Configuration();
        	cfg.configure("hibernate.cfg.xml");

		SessionFactory sfact = cfg.buildSessionFactory();
	        Session s = null;
	        Transaction t = null;	
		try
		{
		    s = sfact.openSession();
	            t = s.beginTransaction();
                    Saving s1 = new Saving();

		    int gno = Integer.parseInt(txtGno.getText());
	
		    String gname = txtGname.getText();
   		    
	            int gamount = Integer.parseInt(txtGamount.getText());
		    
                    if(gno < 0)
	       	    {
                    	JOptionPane.showMessageDialog(new JDialog(), "Enter Proper ID");
            	    }
                    else if(gamount < 0)
	       	    {
                    	JOptionPane.showMessageDialog(new JDialog(), "Enter Proper Amount");
            	    }
		    else if((gno > 0 ) &&(gamount > 0))
		   {
                	s1.setGno(gno);
	              	s1.setGname(gname);
	                s1.setGamount(gamount);
	               	s.save(s1);
	                t.commit();
			JOptionPane.showMessageDialog(new JDialog(),"Record inserted");
		    }
		    else
		    {
			JOptionPane.showMessageDialog(new JDialog(),"please insert the proper details");
		    }
		}
                catch(Exception e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Record already exists");
		}
		finally
		{
		s.close();
        	txtGno.setText("");
            	txtGname.setText("");
		txtGamount.setText("");
		txtGno.requestFocus();
		}
		
	};
	btnSave.addActionListener(a1);

	ActionListener a2 = (ae) -> 
        {
        	MainFrame m = new MainFrame();
        	dispose();
    	};
    	btnBack.addActionListener(a2);
	

	setTitle("Add Goal");
        setSize(500,500);	
        setLocationRelativeTo(c);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        
	}
	
}