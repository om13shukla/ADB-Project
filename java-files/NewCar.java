/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convsql.project2;






import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class NewCar extends JFrame implements ActionListener   
{
	JLabel  carid,carmodel,caryear,cartype,cartypeD;
	JTextField txtid,txtmodel,txtyear,txttype;
	
	JButton add,reset,cancle;
	
	String s1,s2,s3,s4=null,s5,s6;
        
	public NewCar() 
	{
		setVisible(true);
		setSize(700,700);
		setTitle("Add  a new Car");
		setLayout(null);
		setLocationRelativeTo(null);
		
			
		
                
		//carid = new JLabel("Car Id");
		carmodel = new JLabel("Mode of Car");
		caryear = new JLabel("Year of Car");
		cartype = new JLabel("Type of Car");
		cartypeD = new JLabel("Valid car types are: suv, compact, medium, truck, large, van ");
		//add(carid);
                add(carmodel); add(caryear); add(cartype);
		
		carmodel.setBounds(10, 50, 120, 20);
        caryear.setBounds(10, 80, 120, 20);
		cartype.setBounds(10, 110, 120, 20);
		cartypeD.setBounds(310, 110, 120, 300);
                
        //txtid = new JTextField();        
		txtmodel = new JTextField();
		txtyear = new JTextField();
		txttype = new JTextField();
		
		//add(txtid);
                add(txtmodel); add(txtyear); add(txttype);
		
		txtmodel.setBounds(160, 50, 140, 20);
                txtyear.setBounds(160, 80, 140, 20);
		txttype.setBounds(160, 110, 140, 20);
		
                
                
		add = new JButton("ADD");
		reset = new JButton("RESET");
		cancle = new JButton("CANCLE");
		add(add); add(reset); add(cancle);		
		
                add.setBounds(100, 260, 70, 20);
		reset.setBounds(200, 260, 80, 20);
		cancle.setBounds(310, 260, 100, 20);
                
		
		add.addActionListener(this);
		reset.addActionListener(this);
		cancle.addActionListener(this);
		
	  
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		String msg="Item Added Successfully";
		String msg2="Please fill all fileds";
                if(e.getSource() == reset)
                    {
			txtmodel.setText(null);
			txttype.setText(null);
			txtyear.setText(null);
			//txtid.setText(null);
					
                    }
                if(e.getSource() == cancle)
                        {
			
			setVisible(false);
            		}
                
		if(e.getSource() == add)
		{
                       
		
			
			if(txtyear.getText().isEmpty()|| txtmodel.getText().isEmpty()||txttype.getText().isEmpty())
                        {
				
				JOptionPane.showMessageDialog(this, msg2);
			}
                        
                        else{
				
				try
				{
					 
						s1 = txtmodel.getText();
						s2 = txtyear.getText();
						s3 = txttype.getText();
						
					
					
					Connection con= ConnectionProvider.getConn();
					PreparedStatement ps = con.prepareStatement("insert into car values(?,?,?,?)");
					ps.setString(1, s4);
					ps.setString(2, s1);
					ps.setString(3, s2);
                                        ps.setString(4, s3);
                                        ps.execute();
					
					//con.close();
					JOptionPane.showMessageDialog(this, msg);
                                        setVisible(false);
					
					
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			}
		}
                
                else
                {
                    JOptionPane.showMessageDialog(this, msg2);
		
			
		}
		
	
	
			
		
	}
	
	public static void main(String[] args) throws Exception 
	{

		NewCar nc122=new NewCar();
	}
	

}

