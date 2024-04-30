
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements  ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);  
    
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone,tfemail,tfdesignation,tfaadhar ;
    JDateChooser dcdob;
    JComboBox cbeducation ;
    JLabel lblempid;
    JButton add, back;
    
     AddEmployee(){
          getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
           JLabel heading = new JLabel ("Add Employee Details");
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25 ));
         heading.setBounds(320,30, 500, 50);
         add( heading);
         
         JLabel lblname = new JLabel ("Name");
       lblname .setBounds(50,150, 150, 30);
       lblname.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lblname );
        
         tfname = new JTextField();
      tfname.setBounds(200, 150, 150, 30);
       add(tfname);
       
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setFont(new Font("Serif", Font.PLAIN, 20));
        lblfname.setBounds(400, 150, 150, 30);
        add(lblfname);
        
         tffname = new JTextField();
       tffname.setBounds(600, 150, 150, 30);
       add(tffname);
       
         JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        labeldob.setBounds(50, 200, 150, 30);
        add(labeldob);
        
          dcdob = new JDateChooser();
         dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
          JLabel labelsalary = new JLabel("Salary");
           labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("Serif", Font.PLAIN, 20));
        add(labelsalary);
        
         tfsalary = new JTextField();
       tfsalary.setBounds(600, 200, 150, 30);
       add(tfsalary);
       
          JLabel labeladdress = new JLabel("Address");
          labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("Serif", Font.PLAIN, 20));
        add(labeladdress);
        
         tfaddress = new JTextField();
       tfaddress.setBounds(200, 250, 150, 30);
       add(tfaddress);
       
        JLabel labelphone = new JLabel("Phone");
        labelphone.setFont(new Font("Serif", Font.PLAIN, 20));
        labelphone.setBounds(400, 250, 150, 30);
        add(labelphone);
        
         tfphone = new JTextField();
       tfphone.setBounds(600, 250, 150, 30);
       add(tfphone);
       
     JLabel labelemail = new JLabel("Email");
     labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelemail);
        
         tfemail = new JTextField();
        tfemail.setFont(new Font("Arial", Font.BOLD, 14 ));
       tfemail.setBounds(200, 300, 150, 30);
       add(tfemail);
       
        JLabel labeleducation = new JLabel("Highest Education");
           labeleducation .setBounds(400, 300, 150, 30);
        labeleducation .setFont(new Font("Serif", Font.PLAIN, 20));
        add(labeleducation );
        
        String courses[] = {"BTech", "Bcom", "BA", "BCA", "MBA"};
         cbeducation = new JComboBox(courses);
            cbeducation.setBackground(Color.WHITE);
         cbeducation.setBounds(600, 300, 150, 30);
       add(cbeducation );
       
         JLabel lbldesignation = new JLabel("Designation");
           lbldesignation.setBounds(50, 350, 150, 30);
        lbldesignation.setFont(new Font("Serif", Font.PLAIN, 20));
        add(lbldesignation);
        
         tfdesignation = new JTextField();
       tfdesignation.setBounds(200, 350, 150, 30);
       add(tfdesignation);
       
        JLabel labelaadhar = new JLabel("Aadhar number");
        labelaadhar.setBounds(400, 350, 150, 30);
       labelaadhar.setFont(new Font("Serif", Font.PLAIN, 20));
        add(labelaadhar);
        
         tfaadhar = new JTextField();
       tfaadhar.setBounds(600, 350, 150, 30);
       add(tfaadhar);
       
        JLabel labelempid = new JLabel("Employee Id");
         labelempid.setFont(new Font("Serif", Font.PLAIN, 20));
         labelempid.setBounds(50, 400, 150, 30);
         add(labelempid);
        
          lblempid = new JLabel( " "+ number);
          lblempid.setBounds(200, 400, 150, 30);
          lblempid.setFont(new Font("Serif", Font.PLAIN, 20));
          add(lblempid);
       
         add = new JButton("Add Details");
         add.setBounds(250, 550, 150,40);
         add.addActionListener(this);
         add .setBackground(Color.BLACK);
         add.setForeground(Color.WHITE);
         add(add );
              
         back = new JButton("BACK");
         back.setBounds(450, 550, 150,40);
          back.addActionListener(this);
        back .setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
          add(back );
       
      
       
         
          setSize(900, 700);
        setLocation(300, 50); 
        setVisible(true);
     }
    

      public void actionPerformed(ActionEvent ae){
          if (ae.getSource() == add){
               String name = tfname.getText();
               String fname = tffname.getText();
               String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
               String salary = tfsalary.getText();
               String address = tfaddress.getText();
               String phone = tfphone.getText();
               String email = tfemail.getText();
               String education = (String) cbeducation.getSelectedItem();
              String designation = tfdesignation.getText();
              String aadhar = tfaadhar.getText();
              String empid = lblempid.getText();
              
              try{
                  Conn conn = new Conn();
                  String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                  conn.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Details added successfully");
                 
                setVisible(false);
                new Home();
              } catch (Exception e){
                  e.printStackTrace();
              }
              }else {
            setVisible(false);
            new Home();
          }
      }
     
    public static void main(String[] args) {
        new  AddEmployee();
    }
}
