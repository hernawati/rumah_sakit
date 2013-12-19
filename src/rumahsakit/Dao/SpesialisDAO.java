/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rumahsakit.Entity.Spesialis;
import rumahsakit.Interfaces.SpesialisInterface;

/**
 *
 * @author asus
 */
public class SpesialisDAO implements SpesialisInterface{

    private Connection connection;
    private final String insertSpesialis = "INSERT INTO spesialis (id_spesialis, nm_spesialis) VALUES (?,?)";
    private final String updateSpesialis = "UPDATE spesialis SET nm_spesialis=? WHERE id_spesialis=?";
    private final String deleteSpesialis = "DELETE FROM spesialis WHERE id_spesialis=?";

    private final String getAllSpesialis = "SELECT * FROM spesialis";
    private final String getNamapesialis = "SELECT nm_spesialis FROM spesialis";
    private final String getIDSpesialis = "SELECT id_spesialis FROM spesialis WHERE nm_spesialis=?";
    private final String getByIdSpesialis = "SELECT * FROM spesialis WHERE id_spesialis=?";    

    public SpesialisDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertSpesialis(String idSpesialis, Spesialis s) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertSpesialis);
            ps.setString(1, idSpesialis);
            ps.setString(2, s.getNmSpesialis());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, ""+s.getNmSpesialis()+" berhasil ditambahkan!");
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error - Insert Spesialis",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateSpesialis(Spesialis s, String idSpesialis) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(updateSpesialis);
            ps.setString(1, s.getNmSpesialis());
            ps.setString(2, idSpesialis);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, ""+idSpesialis+" berhasil diubah!");
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error - Update Spesialis",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteSpesialis(String idSpesialis) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(deleteSpesialis);
            ps.setString(1, idSpesialis);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, ""+idSpesialis+" berhasil dihapus!");
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error - Delete Spesialis",JOptionPane.ERROR_MESSAGE);
        }
    }

    public List getAllSpesialis() throws SQLException {
        try{
            List list = new ArrayList();
            Statement st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(getAllSpesialis);
            Spesialis sp = null;
            while(rs.next()){                
                sp = new Spesialis();
                sp.setIdSpesialis(rs.getString("id_spesialis"));
                sp.setNmSpesialis(rs.getString("nm_spesialis"));
                list.add(sp);
            }
            st.close();
            rs.close();
            return list;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(), "Error - Get All Spesialis", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[]getNamaSpesialis(int b) throws SQLException {
        try{            
            String[] data = new String[b];            
            Statement st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(getNamapesialis);
            Spesialis sp = new Spesialis();
            while(rs.next()){
                sp.setNmSpesialis (rs.getString("nm_spesialis"));
                String pop = sp.getNmSpesialis();
                data[rs.getRow()-1] = pop;
            }
            st.close();
            rs.close();
            return data;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(), "Error - Get Nama Spesialis", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String getIDSpesialis(String b) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getIDSpesialis);
            ps.setString(1, b);
            ResultSet rs = ps.executeQuery();
            Spesialis sp = new Spesialis();
            String pop = null;
            while(rs.next()){
                sp.setIdSpesialis (rs.getString("id_spesialis"));
                pop = sp.getIdSpesialis();
            }
            ps.close();
            rs.close();
            return pop;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(), "Error - Get ID Spesialis", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List getByIDSpesialis(String idSpesialis) throws SQLException {
        try{
            List list = new ArrayList();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getByIdSpesialis);
            ps.setString(1, idSpesialis);
            ResultSet rs = ps.executeQuery();
            Spesialis sp = null;
            while(rs.next()){
                sp = new Spesialis();
                sp.setIdSpesialis(rs.getString("id_spesialis"));
                sp.setNmSpesialis(rs.getString("nm_spesialis"));
                list.add(sp);
            }
            ps.close();
            rs.close();
            return list;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(), "Error - Get By ID Spesialis", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}