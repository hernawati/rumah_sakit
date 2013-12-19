/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.KoneksiDatabase;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class KoneksiDB {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/simple_crud","root","");
            }catch(Throwable t){
                JOptionPane.showMessageDialog(null, t.getMessage(),"Error - Koneksi Database",JOptionPane.ERROR_MESSAGE);
            }
        }
        return connection;
    }
}
