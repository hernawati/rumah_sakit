/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import rumahsakit.Entity.Pendaftaran;
import rumahsakit.Interfaces.PendaftaranInterface;

/**
 *
 * @author asus
 */
public class PendaftaranDao implements PendaftaranInterface {

    private Connection connection;
    private final String insertPendaftaran = "INSERT INTO "
            + "pendaftaran(nomor,id_pasien,id_dokter,id_jaminan) values (?,?,?,?)";
    private final String generateNomor = "SELECT MAX(SUBSTR(nomor,9,13))+1 "
            + "FROM pendaftaran WHERE nomor LIKE ?"; /*<--- tanpa tanda kutip*/
    private final String cariByNomor = "SELECT * FROM pendaftaran WHERE nomor = ?";
    //private final String cariMaxNomor = "SELECT MAX(nomor)+1 FROM pendaftaran WHERE nomor LIKE ?"; /*<--- tanpa tanda kutip*/

    public PendaftaranDao(Connection connection) {
        this.connection = connection;
    }

    public void insertPendaftaran(Pendaftaran p) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertPendaftaran);
            ps.setString(1, p.getNoReg());
            ps.setString(2, p.getIdPasien());
            ps.setString(3, p.getIdDokter());
            ps.setString(4, p.getIdJaminan());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Pendaftaran berhasil disimpan!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage(), "Error DAO - Insert Pendaftaran", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String generateNomor(String tanggal) throws SQLException {
        try {
            String hasil,generate = null;
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(generateNomor);
            ps.setString(1, tanggal+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hasil = rs.getString(1);
                if(hasil == null){
                    generate = tanggal+"00001";                    
                }else{
                    if(hasil.length() == 1){
                        generate = tanggal + "0000"+ hasil;
                    }else if(hasil.length() == 2){
                        generate = tanggal + "000"+ hasil;
                    }else if(hasil.length() == 3){
                        generate = tanggal + "00"+ hasil;
                    }else if(hasil.length() == 4){
                        generate = tanggal + "0"+ hasil;
                    }else{
                        generate = tanggal + hasil;
                    }
                }
            }
            rs.close();
            ps.close();
            return generate;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage(), "Error DAO - Generate Max Nomor Pendaftaran", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
