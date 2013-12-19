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
import rumahsakit.Entity.Jaminan;
import rumahsakit.Interfaces.JaminanInterface;

/**
 *
 * @author asus
 */
public class JaminanDAO implements JaminanInterface {

    private Connection connection;
    private final String insertJaminan = "INSERT INTO jaminan (id_jaminan, nm_jaminan) VALUES (?,?)";
    private final String updateJaminan = "UPDATE jaminan SET nm_jaminan=? WHERE id_jaminan=?";
    private final String deleteJaminan = "DELETE FROM jaminan WHERE id_jaminan=?";
    private final String getAllJaminan = "SELECT * FROM jaminan";
    private final String getIdJaminan = "SELECT * FROM jaminan WHERE id_jaminan LIKE ?";
    private final String getNmJaminan = "SELECT * FROM jaminan WHERE nm_jaminan LIKE ?";
    private final String getMaxIdJaminan = "SELECT MAX(SUBSTR(id_jaminan,3,5))+1 FROM jaminan";
    private final String getIdJaminanByNama = "SELECT id_jaminan FROM jaminan WHERE nm_jaminan = ?";

    public JaminanDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertJaminan(String idJaminan, Jaminan j) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertJaminan);
            ps.setString(1, idJaminan);
            ps.setString(2, j.getNmJaminan());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,
                    "Data Jaminan '" + j.getNmJaminan() + "' telah ditambahkan!",
                    "Insert Jaminan - Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Insert Jaminan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateJaminan(Jaminan j, String idJaminan) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(updateJaminan);
            ps.setString(1, j.getNmJaminan());
            ps.setString(2, idJaminan);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Jaminan '" + idJaminan + "' telah diubah!",
                    "Update Jaminan - Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Update Jaminan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteJaminan(String idJaminan) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(deleteJaminan);
            ps.setString(1, "" + idJaminan);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,
                    "Data Jaminan '" + idJaminan + "' telah dihapus!",
                    "Delete Jaminan - Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Delete Jaminan", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List getAllJaminan() throws SQLException {
        try {
            Statement s = null;
            List list = new ArrayList();
            s = (Statement) connection.createStatement();
            ResultSet rs = s.executeQuery(getAllJaminan);
            while (rs.next()) {
                Jaminan j = new Jaminan();
                j.setIdJaminan(rs.getString("id_jaminan"));
                j.setNmJaminan(rs.getString("nm_jaminan"));
                list.add(j);
            }
            s.close();
            return list;
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Read All Jaminan", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List getIdJaminan(String idJaminan) throws SQLException {
        try {
            PreparedStatement ps = null;
            List list = new ArrayList();
            ps = (PreparedStatement) connection.prepareStatement(getIdJaminan);
            ps.setString(1, idJaminan + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jaminan j = new Jaminan();
                j.setIdJaminan(rs.getString("id_jaminan"));
                j.setNmJaminan(rs.getString("nm_jaminan"));
                list.add(j);
            }
            ps.close();
            rs.close();
            return list;
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Read By Id Jaminan", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List getNmJaminan(String nmJaminan) throws SQLException {
        try {
            PreparedStatement ps = null;
            List list = new ArrayList();
            ps = (PreparedStatement) connection.prepareStatement(getNmJaminan);
            ps.setString(1, nmJaminan + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jaminan j = new Jaminan();
                j.setIdJaminan(rs.getString("id_jaminan"));
                j.setNmJaminan(rs.getString("nm_jaminan"));
                list.add(j);
            }
            ps.close();
            return list;
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Read By Nama Jaminan", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String getMaxIdJaminan() throws SQLException {
        try {
            String max = null, hasil = null;
            PreparedStatement ps = null;
            ps = (PreparedStatement) connection.prepareStatement(getMaxIdJaminan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                max = rs.getString(1);
                if (max.length() == 1) {
                    hasil = "00" + max;
                } else if (max.length() == 2) {
                    hasil = "0" + max;
                } else {
                    hasil = max;
                }
            }
            return hasil;
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(),
                    "Error DAO - Get Max Id Jaminan", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] tampilNamaJaminan(int total) throws SQLException {
        try{
            String[]nama = new String[total];
            Statement st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(getAllJaminan);
            while(rs.next()){
                nama[rs.getRow()-1] = rs.getString("nm_jaminan");
            }
            rs.close();
            st.close();
            return nama;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),
                    "Error DAO - Read Nama Jaminan", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String getIdJaminanByNama(String nama) throws SQLException {
        try{
            String id = null;
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getIdJaminanByNama);
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getString("id_jaminan");
            }
            rs.close();
            ps.close();
            return id;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),
                    "Error DAO - Get ID By Nama Jaminan ", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
