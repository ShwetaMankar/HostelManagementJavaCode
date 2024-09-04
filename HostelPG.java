import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class HostelPG extends JFrame implements ActionListener 
{
	Button bh1 = new Button("Kaveri");	//Button to go to pg for attendance of Kaveri hostel
	Button bh2 = new Button("Godavari");	//Button to go to pg for attendance of Godavri hostel
	Button bh3 = new Button("Registration");
	HostelPG()
	{
		JPanel clgName = new JPanel();	// JPanel to add label of college name
		clgName.setBounds(6, 10, 1450, 100);	
		clgName.setBackground(Color.gray);

		
		Label gpt = new Label(" Government Residence Women Polytecnic Tasgaon ");		
		gpt.setFont(new Font("Serif", Font.PLAIN, 68));
		gpt.setForeground(Color.orange);
		
		
		clgName.add(gpt);	//label of college name added to JPanel
		add(clgName);	//JPanel added to JFrame
		
		JLabel jpH1 = new JLabel(new ImageIcon("1.jpeg"));	//JLabel to display img of hostel 1
		jpH1.setBackground(Color.black);
		jpH1.setBounds(90, 150, 600, 500);
		add(jpH1);
		
		JLabel jpH2 = new JLabel(new ImageIcon("2.jpeg"));	//JLabel to display img of hostel 2
		jpH2.setBackground(Color.black);
		jpH2.setBounds(740, 150, 600, 500);
		add(jpH2);
		
		
		bh1.setBounds(300,750,150,60);
		bh1.setBackground(Color.gray);
		bh1.setForeground(Color.orange);
		bh1.setFont(new Font("Serif", Font.PLAIN, 30));
		add(bh1);
		
		
		bh2.setBounds(910,750,150,60);
		bh2.setBackground(Color.gray);
		bh2.setForeground(Color.orange);
		bh2.setFont(new Font("Serif", Font.PLAIN, 30));
		add(bh2);
		
		bh3.setBounds(650,750,150,60);
		bh3.setBackground(Color.gray);
		bh3.setForeground(Color.orange);
		bh3.setFont(new Font("Serif", Font.PLAIN, 30));
		add(bh3);
		
		 bh1.addActionListener(this);
		 bh2.addActionListener(this);
		 bh3.addActionListener(this);
		
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // to make screen fully visible
		setVisible(true);
	
	}
	  public void actionPerformed(ActionEvent e) 
	  {    
			if(e.getSource()==bh1) 
	        {
		      kaveri1 ka=new kaveri1();
		    }
			if(e.getSource()==bh2) 
	        {
		      Godavari go=new Godavari();
		    }
			if(e.getSource()==bh3) 
	        {
		      registration reg=new registration();
		    }
	   }
	
	public static void main(String s[])
	{
		new HostelPG();
	}
}