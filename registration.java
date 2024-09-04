import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class registration extends JFrame implements ActionListener
{
	    //create object of TextField
		JTextField textEnrollment=new JTextField ();
        JTextField textName=new JTextField ();
        JTextField textRoll =new JTextField ();
        JTextField textMo=new JTextField ();
		JTextField textEmail =new JTextField ();
        JTextField textDOB=new JTextField ();
		JTextField textClass =new JTextField ();
        JTextField textparentm=new JTextField ();
        JTextArea textAddress=new JTextArea();
		JTextField textadd =new JTextField ();
		JTextField texthostel =new JTextField ();
	    JComboBox jc=new JComboBox();
        JComboBox jc1=new JComboBox();		
       
	   
	   //Create JButton Object
		JButton btnAdd = new JButton("Add");
		JButton btnClear =new JButton("Clear");
	    JButton btnDelete = new JButton("Delete");
	    JButton btnUpdate = new JButton("Update");
		JButton Search = new JButton("Search");
		
		//img
		JLabel j = new JLabel(new ImageIcon("reg.png"));	//JLabel to display img */
		
	    registration()   //Create a constructor of class Microproject
	    {
         JLabel l1 = new JLabel("REGISTRATION",JLabel.CENTER);  //create JLabel Object
		 Font f1 = new Font("Times New Roman",Font.BOLD,40);   //create font object & set style and size
		 l1.setFont(f1);  
		 l1.setForeground(new Color(153,0,0));
		
		
		//jpH2.setBackground(Color.black);
		j.setBounds(800,175,500,500);
		add(j);
		
		 //create JLabel object
		 JLabel l2 = new JLabel("Enrollment No");     
		 JLabel l3 = new JLabel("Name of Student");
		 JLabel l4 = new JLabel("Roll No");
		 JLabel l5 = new JLabel("Mobile No");
		 JLabel l6 = new JLabel("Email ID");
		 JLabel l7 = new JLabel("Date of Birth");
		 JLabel l8 = new JLabel("Class");
		 JLabel l9 = new JLabel("Parent phone no");
		 JLabel l10 = new JLabel("Address");
		 JLabel l11 = new JLabel("Hostel Name");
		
		 //set setBounds for JLabel
		 l1.setBounds(40,30,700,100);
		 l2.setBounds(40,150,200,40);
		 l3.setBounds(40,200,200,40);
		 l4.setBounds(40,260,200,40);
		 l5.setBounds(40,320,150,40);
		 l6.setBounds(40,375,100,40);
		 l7.setBounds(40,435,150,40);
		 l8.setBounds(40,490,100,40);
		 l9.setBounds(40,540,200,40);
		 l10.setBounds(40,590,200,40);
		 l11.setBounds(40,650,200,40);
		
		 //Add Jlabel to frame
		 add(l1);  add(l2);  add(l3);  add(l4);  add(l5);  add(l6); 
		 add(l7);  add(l8);  add(l9);   add(l10); add(l11);
		
		 //set setBounds for TextField 
		 textEnrollment.setBounds(240,155,200,30);
	     textName.setBounds(240,205,200,30);
	     textRoll.setBounds(240,265,200,30);
	     textMo.setBounds(240,325,200,30);
		 textEmail.setBounds(240,380,200,30);
	     textDOB.setBounds(240,440,200,30);
		 textClass.setBounds(240,490,200,30);
	     textparentm.setBounds(240,550,200,30);
		 textadd.setBounds(240,600,200,30);
		 texthostel.setBounds(240,650,200,30);
		 //add TextField to frame
		 add(textEnrollment);  add(textName);  add(textRoll);  add(textMo);  add(textEmail); 
		 add(textDOB);   add(textparentm);  add(textadd);
		 //For JComboBox
		 jc.setBounds(240,490,200,30);
		 jc.addItem("COFY");
		 jc.addItem("COSY");
		 jc.addItem("COTY");
		 add(jc);
		 jc1.setBounds(240,650,200,30);
		 jc1.addItem("KAVERI");
		 jc1.addItem("GODAVARI");
		 add(jc1);
		 //set setBounds for JButton
		 btnAdd.setBounds(600,175,150,33);
		 btnClear.setBounds(600,295,150,33);
	     btnUpdate.setBounds(600,400,150,33);
	     btnDelete.setBounds(600,510,150,33);
		 Search.setBounds(600,625,150,33);
		 
		 //create font object & set style and size
		 Font f2 = new Font("Times New Roman",Font.PLAIN,20); 
		 btnAdd.setFont(f2); 
		 btnClear.setFont(f2);
	     btnUpdate.setFont(f2);
	     btnDelete.setFont(f2);
		 Search.setFont(f2);
		 
		 //setFonts to Labels
		 l2.setFont(f2);
		 l3.setFont(f2);
		 l4.setFont(f2);
		 l5.setFont(f2);
		 l6.setFont(f2);
		 l7.setFont(f2);
		 l8.setFont(f2);
		 l9.setFont(f2);
		 l10.setFont(f2);
		 l11.setFont(f2);
		 
		 //set backgroundcolor
		  btnAdd.setBackground(Color.gray);
		 btnClear.setBackground(Color.gray);
	     btnUpdate.setBackground(Color.gray);
	     btnDelete.setBackground(Color.gray);
		 Search.setBackground(Color.gray);
		 
		 //set foregroundcolor
		 btnAdd.setForeground(Color.orange);
		 btnClear.setForeground(Color.orange);
	     btnUpdate.setForeground(Color.orange);
	     btnDelete.setForeground(Color.orange);
		 Search.setForeground(Color.orange);
		 
		 
		 // add JButton to frame
		 add(btnAdd);  add(btnDelete);   add(btnUpdate);  add(btnClear); add(Search);
		
		 btnAdd.addActionListener(this);
		 btnClear.addActionListener(this);
		 Search.addActionListener(this);
		 btnDelete.addActionListener(this);
		 btnUpdate.addActionListener(this);
		 
		 //To set frame properties
		 setTitle("registration");
		 setLayout(null);
		 setSize(900,900);
		 setVisible(true);
	    }
	    public void actionPerformed(ActionEvent e) 
	    {    
       
		   String enroll = textEnrollment.getText();
           String Name = textName.getText();
           String rollno = textRoll.getText();
           String Mobile = textMo.getText();		
		   String email = textEmail.getText();
           String dob = textDOB.getText();
		   String classt=jc.getSelectedItem().toString();
           String pmobileno = textparentm.getText();
           String address = textadd.getText();
		   String hosn=jc1.getSelectedItem().toString();
       
	       try 
	      {
		     Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
             //for insert data into table
             Statement stmt = con.createStatement();
			 PreparedStatement pst;
             if(e.getSource()==btnAdd) 
			 {
				 // Inserting data using SQL query
				String sql="INSERT INTO registration(Enrollmentno,named,rolls,mobiles,emails,dateofbir,classes,pamobiles,addresss,hostelname)value('"+enroll+"','"+Name+"','"+rollno+"','"+Mobile+"','"+email+"','"+dob+"','"+classt+"','"+pmobileno+"','"+address+"','"+hosn+"')";
             
				stmt.executeUpdate(sql); //here insert query apply
                JOptionPane.showMessageDialog(null, "DATA SAVED SUCCESSFULLY ..");
			 }
			 if (e.getSource() == btnClear) 
		     {
                 textEnrollment.setText("");
                 textName.setText("");
				 textRoll.setText("");
                 textMo.setText("");
				 textEmail.setText("");
                 textDOB.setText("");
				 textparentm.setText("");
                 textadd.setText("");
             }
			 if (e.getSource() == Search) 
		     {
                 pst = con.prepareStatement("select Enrollmentno,named,rolls,mobiles,emails,dateofbir,classes,pamobiles,addresss,hostelname from registration where Enrollmentno=? ");
                 int Enrollmentno = Integer.parseInt(textEnrollment.getText());
			     pst.setInt(1, Enrollmentno);
			     
			     ResultSet rs1 = pst.executeQuery();
			      if(rs1.next()==false)
				  {
				                JOptionPane.showMessageDialog(null, "Sorry Record Not Found");
                                
                                textName.setText("");
								textRoll.setText("");
                                textMo.setText("");
								textEmail.setText("");
                                textDOB.setText("");
								textClass.setText("");
                                textparentm.setText("");
								textadd.setText("");
								texthostel.setText("");
                                textEnrollment.requestFocus();
			     }
                else
                {
			            textName.setText(rs1.getString("named"));
                        textRoll.setText(rs1.getString("rolls"));
						textMo.setText(rs1.getString("mobiles"));
                        textEmail.setText(rs1.getString("emails"));
						textDOB.setText(rs1.getString("dateofbir"));
   						jc.setSelectedItem(rs1.getString("classes").toString());
						textparentm.setText(rs1.getString("pamobiles"));
                        textadd.setText(rs1.getString("addresss"));
						jc1.setSelectedItem(rs1.getString("hostelname").toString());
		        }
			  }	
              if (e.getSource() == btnDelete) 
		      {
				 pst = con.prepareStatement("DELETE FROM registration where Enrollmentno="+textEnrollment.getText());
                 
			     pst.executeUpdate();
                 JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY ..");
				                textEnrollment.setText("");
				                textName.setText("");
								textRoll.setText("");
                                textMo.setText("");
								textEmail.setText("");
                                textDOB.setText("");
								textClass.setText("");
                                textparentm.setText("");
								textadd.setText("");
								texthostel.setText("");
                                textEnrollment.requestFocus();
              }
			  if (e.getSource() == btnUpdate) 
		      {
				String sql="UPDATE registration set named='"+textName.getText()+"',rolls='"+textRoll.getText()+"',mobiles='"+textMo.getText()+"',emails='"+textEmail.getText()+"',dateofbir='"+textDOB.getText()+"',classes='"+jc.getSelectedItem().toString()+"',pamobiles='"+textparentm.getText()+"',addresss='"+textadd.getText()+"',hostelname='"+jc1.getSelectedItem().toString()+"' where Enrollmentno= "+textEnrollment.getText();
				stmt.executeUpdate(sql); //here insert query apply
                JOptionPane.showMessageDialog(this, "UPDATED SUCCESSFULLY ..");
              }
 		     //close connection
	         con.close();
         } catch(Exception ex) {System.out.print(ex);}
		}
	public static void main(String args[])
	{
		new registration();
	}
}