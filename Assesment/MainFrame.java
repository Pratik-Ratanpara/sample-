import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MainFrame extends JFrame
{
	Container c;
	JButton btnAdd,btnView,btnTrans,btnDelete;
	MainFrame()
	{
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.red);

		btnAdd = new JButton("SET GOAL");
		btnAdd.setBounds(50, 50, 140, 30);
        	c.add(btnAdd);

		btnView = new JButton(" VIEW Goal");	
		btnView.setBounds(250, 50, 140, 30);
       		c.add(btnView);

		btnTrans = new JButton("ADD SAVING");
       		btnTrans.setBounds(50, 120, 140, 30);
		c.add(btnTrans);

		btnDelete = new JButton(" DELETE GOAL");
		btnDelete.setBounds(250, 120, 140, 30);
		c.add(btnDelete);

		ActionListener a1 = (ae) -> 
        	{
            		AddGoal a = new AddGoal();
            		dispose();

	        };
        	btnAdd.addActionListener(a1);

		ActionListener a2 = (ae) -> 
        	{
            		ViewFrame v = new ViewFrame();
            		dispose();

	        };
        	btnView.addActionListener(a2);

		ActionListener a3 = (ae) -> 
        	{
           		TransFrame t = new TransFrame();
            		dispose();

	        };
			btnTrans.addActionListener(a3);
		

		setTitle("Set Goal API Services");
                setSize(450,420);
                setLocationRelativeTo(c);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);

	}
}
