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
import rumahsakit.Entity.Dokter;
import rumahsakit.Interfaces.DokterInterface;

/**
 *
 * @author asus
 */
public class DokterDAO implements DokterInterface{

    private Connection connection;
    private final String insertDokter = "INSERT INTO dokter (id_dokter, nm_dokter, id_spesialis) VALUES (?,?,?)";
    private final String updateDokter = "UPDATE dokter SET nm_dokter=?, id_spesialis=? WHERE id_dokter=?";
    private final String deleteDokter = "DELETE FROM dokter WHERE id_dokter=?";    
    private final String getAllDokter =
            "SELECT d.id_dokter, d.nm_dokter, s.nm_spesialis "
            + "FROM dokter d, spesialis s "
            + "WHERE d.id_spesialis=s.id_spesialis "
            + "ORDER BY d.id_dokter ASC";
    private final String getByIdDokter =
            "SELECT d.id_dokter, d.nm_dokter, s.nm_spesialis "
            + "FROM dokter d, spesialis s "
            + "WHERE d.id_spesialis=s.id_spesialis "
            + "AND d.id_dokter=?";
    private final String ambilNamaDokter = "SELECT * FROM dokter WHERE id_spesialis=?";
    private final String tampilIdByNama = "SELECT id_dokter FROM dokter WHERE nm_dokter=?";

    public DokterDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertDokter(Dokter d) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertDokter);
            ps.setString(1, d.getIdDokter());
            ps.setString(2, d.getNmDokter());
            ps.setString(3, d.getIdSpesialis());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data dokter berhasil ditambah!");
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Insert Dokter Gagal!",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateDokter(Dokter d, String idDokter) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(updateDokter);
            ps.setString(1, d.getNmDokter());
            ps.setString(2, d.getIdSpesialis());
            ps.setString(3, idDokter);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data dokter berhasil diubah!");
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Update Dokter Gagal!",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteDokter(String idDokter) throws SQLException {
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(deleteDokter);
            ps.setString(1, idDokter);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data dokter berhasil dihapus!");
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Delete Dokter Gagal!",JOptionPane.ERROR_MESSAGE);
        }
    }

    public List getAllDokter() throws SQLException {
        try{
            List list = new ArrayList();
            Statement s = (Statement) connection.createStatement();
            ResultSet rs = s.executeQuery(getAllDokter);
            while(rs.next()){
                Dokter d = new Dokter();
                d.setIdDokter(rs.getString("id_dokter"));
                d.setNmDokter(rs.getString("nm_dokter"));
                d.setIdSpesialis(rs.getString("nm_spesialis"));
                list.add(d);
            }
            rs.close();
            s.close();
            return list;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Get All dokter gagal!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List getByIdDokter(String idDokter) throws SQLException {
        try{
            List list = new ArrayList();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getByIdDokter);
            ps.setString(1, idDokter);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dokter d = new Dokter();
                d.setIdDokter(rs.getString("id_dokter"));
                d.setNmDokter(rs.getString("nm_dokter"));
                d.setIdSpesialis(rs.getString("nm_spesialis"));
                list.add(d);
            }
            rs.close();
            ps.close();
            return list;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Get Dokter By Id Gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List getByIdSpesialis(String idSpesialis)throws SQLException{
        try{
            List list = new ArrayList();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(ambilNamaDokter);
            ps.setString(1, idSpesialis);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dokter d = new Dokter();
                d.setIdDokter(rs.getString("id_dokter"));
                d.setNmDokter(rs.getString("nm_dokter"));
                list.add(d);
            }
            rs.close();
            ps.close();
            return list;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Get Dokter By Id Spesialis Gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] NamaDokter(String spesialis, int total) throws SQLException {
        try{
            String[]nama = new String[total];
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(ambilNamaDokter);
            ps.setString(1, spesialis);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nama[rs.getRow()-1] = rs.getString("nm_dokter");
            }
            rs.close();
            ps.close();
            return nama;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"String[] Nama Dokter Gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String tampilIdByNama(String nama) throws SQLException {
        try{
            String id = null;
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(tampilIdByNama);
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getString("id_dokter");
            }
            rs.close();
            ps.close();
            return id;
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, se.getMessage(),"Tampil ID By Nama Dokter Gagal!",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
