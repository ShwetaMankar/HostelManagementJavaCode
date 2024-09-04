import java.sql.*; //It is used for database connection
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class database extends JPanel implements ActionListener 
{  
    //create a  Object of component
	JLabel Label = new JLabel("Login"); 
	
    JLabel userLabel = new JLabel("USERNAME"); 
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
	JCheckBox showPassword = new JCheckBox("Show Password");
    JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JLabel jpH1 = new JLabel(new ImageIcon("h.jpg"));	//JLabel to display img of logo
    database() //Create a constructor of class database
	{
        setLayout(null);
		setLocationAndSize();
		Addcomponent();
        addActionEvent();
        Label.setFont(new Font("Serfi", Font.BOLD, 50));
		Label.setForeground(Color.blue);
		
		loginButton.setBackground(Color.gray);
		resetButton.setBackground(Color.gray);
		loginButton.setForeground(Color.orange);
		resetButton.setForeground(Color.orange);
    }
    public void setLocationAndSize()
	{
		//setting the position and size of component on frame
		Label.setBounds(590, 50, 200, 60);
		userLabel.setBounds(500, 150, 100, 40);
        passwordLabel.setBounds(500,230, 100, 40);
        userTextField.setBounds(650, 160, 150, 40);
        passwordField.setBounds(650, 230, 150, 40);
        showPassword.setBounds(650, 300, 150, 40);
        loginButton.setBounds(500, 380, 110, 50);
        resetButton.setBounds(700, 380, 110, 50);
		jpH1.setBounds(410,500,500,190);
	}
	public void Addcomponent()
	{
		//Add component to Frame
		add(Label);
		add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
		add(showPassword);
        add(loginButton);
		add(resetButton);
		add(jpH1);
	}
    public void addActionEvent() 
	{   
	    showPassword.addActionListener(this);
        loginButton.addActionListener(this);
	    resetButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) 
	{
       //Coding Part of DATABASE connection
       try 
	   {
          Class.forName("com.mysql.jdbc.Driver");//Load the drivers.
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");//Establish a connection using the Connection class object 
          Statement stmt = con.createStatement();//Create a statement
          String sql="Select * from tbLogin where username='"+userTextField.getText()+"'and password='"+passwordField.getText().toString()+"'";// Retrieve by column name
          ResultSet rs=stmt.executeQuery(sql);//Execute the query
		  //Coding Part of LOGIN button
          if(e.getSource()==loginButton) 
		  {
			if(rs.next())// Extract data from result set
		    {
               JOptionPane.showMessageDialog(null, "Login Successfully..");
			   HostelPG hg = new HostelPG();//calling the constructor of next page
			  // JFrame.dispose();
			}
			else 
		    {
              JOptionPane.showMessageDialog(null, "Login Incorrect username and password..");
		    }con.close();//CLose the connections
          } 
		  //Coding Part of showPassword JCheckBox
		  if (e.getSource() == showPassword) 
		  {
            if (showPassword.isSelected()) 
			{
                passwordField.setEchoChar((char)0);//You can see in character form
            } 
			else 
			{
                passwordField.setEchoChar('*');//what you writing in passwordField you see in the form *
            }
          }
		  //Coding Part of RESET button
		  if (e.getSource() == resetButton) 
		  {
            userTextField.setText("");
            passwordField.setText("");
          }
        
        } catch(Exception ex) // Catch block to handle exceptions
		{
			 JOptionPane.showMessageDialog(null, "Plz go to Xampp and start your Mysql and apache server");
		}
		
    }
 }
 class Microproject1 extends JFrame
{   
    database p;
	Microproject1()   //Create a constructor of class Microproject
	{
		setLayout(null);
		p = new database();     //create JPanel object
		//p.setBackground(Color.gray);    //set JPanel properties
		
		p.setBounds(0,0,2500,1500);
		add(p);
	}
       //Main class
	public static void main(String args[])
	{
		Microproject1 m = new Microproject1();     //create main class object
         //set JFrame properties
		m.setVisible(true);     
		m.setSize(2000,2000);
		m.setTitle("Student Academic details Form");
	}
}