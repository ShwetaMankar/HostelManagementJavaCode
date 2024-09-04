import java.sql.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class kaveri1 extends JFrame implements ActionListener
{	  //create object of table and button
	  JTable table;
	  JButton btnAdd = new JButton("SAVE");
	 
	  JButton btnre = new JButton("REGISTRATION");
	
	  public kaveri1()	//constructor
	  {
		table= new JTable(); 
	    String[] col = {"Enrollmentno","named","classes","17dec2021","18dec2021","19dec2021","20dec2021","21dec2021"}; //column names in database
		DefaultTableModel model = new DefaultTableModel(); //create DefaultTableModel (to store cell value objects)
		model.setColumnIdentifiers(col);	//set column to tablename
		table.setModel(model);	//set model to JTable
		
		try
	    {  
		   Class.forName("com.mysql.jdbc.Driver");	//register driver class 
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");	//create connection
           Statement stmt = con.createStatement();	//create statement object to execute sql statement 
		   String q="select * from registration where hostelname='KAVERI'";
   		   ResultSet rs=stmt.executeQuery(q);	//execute query (resultset contians the row that specifies the query i.e. contians result of executing query)
		   while(rs.next())
		   {
				String Enrollmentno=String.valueOf(rs.getInt("Enrollmentno")); //returns method valu n coverted to type int
				String named=rs.getString("named");
				String classes=rs.getString("classes");
				//String hostelname=rs.getString("hostelname");
				String tbData[]={Enrollmentno,named,classes};
				DefaultTableModel tbmodel =(DefaultTableModel)table.getModel();
				tbmodel.addRow(tbData);			
			}
		    con.close();	//close connection
		}
		catch(Exception ex) {System.out.print("hiii");}
		  JScrollPane pane = new JScrollPane(table);	//create object of JScrollpane
		 
		  pane.setBounds(200,200,1000,400);	
		  btnAdd.setBounds(400,700,100,50);
		  btnre.setBounds(900,700,150,50);
		  
		  btnAdd.setBackground(Color.gray);
		  btnAdd.setForeground(Color.orange);
		  
		  btnre.setBackground(Color.gray);
		  btnre.setForeground(Color.orange);
		 
		  add(pane);	//add JScrolslpane to frame
		  add(btnre);	//add button to frame
		  add(btnAdd);
		  //register actionListener to button
		  btnre.addActionListener(this);
		  btnAdd.addActionListener(this);
		  
		  JPanel kn = new JPanel();	// JPanel to add label of college name
		  kn.setBounds(6, 10, 1450, 100);	
		  kn.setBackground(Color.gray);

		  Label l = new Label(" KAVERI ");		
		  l.setFont(new Font("Serif", Font.PLAIN, 68));
		  l.setForeground(Color.orange);
		
		  kn.add(l);	//label of college name added to JPanel
		  add(kn);	//JPanel added to JFrame
		 
		  //frame properties
		  setTitle("Kaveri hostel");
		  setLayout(null);
		  setSize(2000,2000);
		  setVisible(true);
	  }
	
	  public void actionPerformed(ActionEvent e) 
	  {   
   	      try 
		  {
			Class.forName("com.mysql.jdbc.Driver");	//register driver class 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root",""); //create connection
			Statement stmt = con.createStatement();
			PreparedStatement pst=null;	//create object PeparedStatement
			DefaultTableModel tbmodel1 =(DefaultTableModel)table.getModel();
			String Enrollmentno,name,classes,sdes,edes,ades,bdes,cdes;//hostelname
			
			if(e.getSource()==btnAdd) 
	        {
		      for(int i=0; i<tbmodel1.getRowCount(); i++)	//add row into table
		      {
				  Enrollmentno=tbmodel1.getValueAt(i,0).toString();
				  name=tbmodel1.getValueAt(i,1).toString();
				  classes=tbmodel1.getValueAt(i,2).toString();
				 // hostelname=tbmodel1.getValueAt(i,3).toString();
				  sdes=tbmodel1.getValueAt(i,3).toString();
				  edes=tbmodel1.getValueAt(i,4).toString();
				  ades=tbmodel1.getValueAt(i,5).toString();
				  bdes=tbmodel1.getValueAt(i,6).toString();
				  cdes=tbmodel1.getValueAt(i,7).toString();
				  //sql query to be executed multiple times
				  pst = con.prepareStatement("INSERT INTO kaveri(Enrollmentno,name,classes,17dec2021,18dec2021,19dec2021,20dec2021,21dec2021)values(?,?,?,?,?,?,?,?)");
				  pst.setString(1,Enrollmentno);
				  pst.setString(2,name);
				  pst.setString(3,classes);
				  //pst.setString(4,hostelname);
				  pst.setString(4,sdes);
				  pst.setString(5,edes);
				  pst.setString(6,ades);
				  pst.setString(7,bdes);
				  pst.setString(8,cdes);
				  pst.executeUpdate();
				  
			  }
			  JOptionPane.showMessageDialog(this,"DATA SAVED SUCCESSFULLY .."); //for data inserted successfully
		     }
			 if(e.getSource == btnre)
			 {
				 registration res = new registration();
			 }
		    con.close();//close connection
		} 
		catch(Exception ex) 
		{
				System.out.print(ex);
		}
	  }
	   
	  public static void main(String arg[])
	  {
	    kaveri1 art= new kaveri1();
	  }
}