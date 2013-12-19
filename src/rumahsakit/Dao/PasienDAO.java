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
import rumahsakit.Entity.Pasien;
import rumahsakit.Interfaces.PasienInterface;

/**
 *
 * @author asus
 */
public class PasienDAO implements PasienInterface{

    private Connection connection;
    private final String insertPasien = "INSERT INTO pasien (id_pasien, nm_pasien) values (?,?)";
    private final String updatePasien = "UPDATE pasien SET nm_pasien=? WHERE id_pasien=?";
    private final String deletePasien = "DELETE FROM pasien WHERE id_pasien=?";
    private final String getAllPasien = "SELECT * FROM pasien ORDER BY id_pasien ASC";
    private final String getByIdPasien = "SELECT * FROM pasien WHERE id_pasien = ?";
    private final String generateIdPasien = "SELECT MAX(id_pasien)+1 FROM pasien";

    public PasienDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertPasien(Pasien p) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertPasien);
            ps.setString(1, p.getIdPasien());
            ps.setString(2, p.getNmPasien());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Insert Pasien Berhasil!");
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error DAO - Insert Pasien Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePasien(Pasien p, String idPasien) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(updatePasien);
            ps.setString(1, p.getNmPasien());
            ps.setString(2, idPasien);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Update Pasien Berhasil!");
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error DAO - Update Pasien Gagal!",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePasien(String idPasien) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(deletePasien);
            ps.setString(1, idPasien);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Delete Pasien Berhasil!");
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error - Delete Pasien Gagal!",JOptionPane.ERROR_MESSAGE);
        }
    }

    public List getAllPasien() throws SQLException {
        try{
            List list = new ArrayList();
            Statement st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(getAllPasien);
            while(rs.next()){
                Pasien pasien = new Pasien();
                pasien.setIdPasien(rs.getString("id_pasien"));
                pasien.setNmPasien(rs.getString("nm_pasien"));
                list.add(pasien);
            }
            //rs.close();
            st.close();
            return list;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error DAO - Get All Pasien Gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List getByIdPasien(String idPasien) throws SQLException {
        try{
            List list = new ArrayList();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getByIdPasien);
            ps.setString(1, idPasien);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pasien pasien = new Pasien();
                pasien.setIdPasien(rs.getString("id_pasien"));
                pasien.setNmPasien(rs.getString("nm_pasien"));
                list.add(pasien);
            }
            return list;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error DA0 - Get By Id Pasien gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String namaByIdPasien(String idPasien) throws SQLException {
        try{
            String nama = null;
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getByIdPasien);
            ps.setString(1, idPasien);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nama = rs.getString("nm_pasien");
            }
            return nama;
        }catch(Throwable t){
            JOptionPane.showMessageDialog(null, t.getMessage(),"Error DAO - Nama By Id Pasien gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String generateIdPasien() throws SQLException {
        try{
            String hasil, generate = null;
            Statement st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(generateIdPasien);
            if(rs.next()){
                hasil = rs.getString(1);
                if(hasil == null){
                    generate = "000001";
                }else if(hasil.length() == 1){
                    generate = "00000" + hasil;
                }else if(hasil.length() == 2){
                    generate = "0000" + hasil;
                }else if(hasil.length() == 3){
                    generate = "000"+hasil;
                }else if(hasil.length() == 4){
                    generate = "00"+hasil;
                }else if(hasil.length() == 5){
                    generate = "0" + hasil;
                }else{
                    generate = hasil;
                }
            }
            return generate;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Error DAO - Generate ID Pasien",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
