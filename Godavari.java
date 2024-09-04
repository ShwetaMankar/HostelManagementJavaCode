import java.sql.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class Godavari extends JFrame implements ActionListener
{
	  JTable table;
	  JButton btnAdd = new JButton("SAVE");
	 
	  JButton btnre = new JButton("REGISTRATION");
	
	  public Godavari()
	  {
		table= new JTable(); 
	    String[] col = {"Enrollmentno","named","classes","17dec2021","18dec2021","19dec2021","20dec2021","21dec2021"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		try
	    {  
		   Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
           Statement stmt = con.createStatement();
		   String q="select * from registration where hostelname='GODAVARI'";
   		   ResultSet rs=stmt.executeQuery(q);
		   while(rs.next())
		   {
				String Enrollmentno=String.valueOf(rs.getInt("Enrollmentno"));
				String named=rs.getString("named");
				String classes=rs.getString("classes");
				//String hostelname=rs.getString("hostelname");
				String tbData[]={Enrollmentno,named,classes};
				DefaultTableModel tbmodel =(DefaultTableModel)table.getModel();
				tbmodel.addRow(tbData);			
			}
		    con.close();
		}
		catch(Exception ex) {System.out.print("hiii");}
		  JScrollPane pane = new JScrollPane(table);
		 
		  pane.setBounds(200,200,1000,400);	
		  btnAdd.setBounds(400,700,100,50);
		  btnre.setBounds(900,700,150,50);
		  
		  btnAdd.setBackground(Color.gray);
		  btnAdd.setForeground(Color.orange);
		  
		  btnre.setBackground(Color.gray);
		  btnre.setForeground(Color.orange);
		 
		  add(pane);
		  add(btnre);
		  add(btnAdd);
		  
		  btnre.addActionListener(this);
		  btnAdd.addActionListener(this);
		  
		  JPanel gn = new JPanel();	// JPanel to add label of hostel name
		  gn.setBounds(6, 10, 1450, 100);	
		  gn.setBackground(Color.gray);

		  Label l = new Label(" Godavari ");		
		  l.setFont(new Font("Serif", Font.PLAIN, 68));
		  l.setForeground(Color.orange);
		
		  gn.add(l);	//label of hostel name added to JPanel
		  add(gn);	//JPanel added to JFrame
		
		  setTitle("Godavari hostel");
		  setLayout(null);
		  setSize(2000,2000);
		  setVisible(true);
	  }
	
	  public void actionPerformed(ActionEvent e) 
	  {   
   	      try 
		  {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
			Statement stmt = con.createStatement();
			PreparedStatement pst=null;
			DefaultTableModel tbmodel1 =(DefaultTableModel)table.getModel();
			String Enrollmentno,name,classes,sdes,edes,ades,bdes,cdes;//hostelname
			
			if(e.getSource()==btnAdd) 
	        {
		      for(int i=0; i<tbmodel1.getRowCount(); i++)
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
					  pst = con.prepareStatement("INSERT INTO godavari(Enrollmentno,name,classes,17dec2021,18dec2021,19dec2021,20dec2021,21dec2021)values(?,?,?,?,?,?,?,?)");
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
			  JOptionPane.showMessageDialog(this,"DATA SAVED SUCCESSFULLY ..");
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
	    Godavari art= new Godavari();
	  }
}