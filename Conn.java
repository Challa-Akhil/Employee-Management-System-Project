
package employee.management.system;

import java.sql.*;
        
public class Conn {
    
    Connection c;
    Statement s;
    @SuppressWarnings("UseSpecificCatch")
    public Conn() {
        try{
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "1234");
            s = c.createStatement();
            
        } catch(Exception e){
            System.out.println(e);
                    
        }
    }
  
         public static void main(String[] args) {
        new Conn();
    }
}
