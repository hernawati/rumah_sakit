/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Service;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rumahsakit.Dao.PendaftaranDao;
import rumahsakit.Entity.Pendaftaran;
import rumahsakit.Interfaces.PendaftaranInterface;
import rumahsakit.KoneksiDatabase.KoneksiDB;

/**
 *
 * @author asus
 */
public class PendaftaranService {

    private PendaftaranInterface pi;
    private Connection connection;

    public PendaftaranService() {
        connection = KoneksiDB.getConnection();        
        pi = new PendaftaranDao(connection);
    }

    public void insertPendaftaranService(Pendaftaran p){
        try{
            connection.setAutoCommit(false);
            pi.insertPendaftaran(p);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(PendaftaranService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(PendaftaranService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public String generateNomorService(String tanggal){
        try{
            return pi.generateNomor(tanggal);
        }catch(SQLException se){
            Logger.getLogger(PendaftaranService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }



}
