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
import rumahsakit.Dao.PasienDAO;
import rumahsakit.Entity.Pasien;
import rumahsakit.Interfaces.PasienInterface;
import rumahsakit.KoneksiDatabase.KoneksiDB;

/**
 *
 * @author asus
 */
public class PasienService {
    private PasienInterface pi;
    private Connection connection;

    public PasienService() {
        connection = KoneksiDB.getConnection();
        pi = new PasienDAO(connection);
    }

    public void serviceInsertPasien(Pasien p){
        try{
            connection.setAutoCommit(false);
            pi.insertPasien(p);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public void serviceUpdatePasien(Pasien p, String idPasien){
        try{
            connection.setAutoCommit(false);
            pi.updatePasien(p, idPasien);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceDeletePasien(String idPasien){
        try{
            connection.setAutoCommit(false);
            pi.deletePasien(idPasien);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public List serviceGetAllPasien(){
        try{
            return pi.getAllPasien();
        }catch(SQLException se){
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetByIdPasien(String idPasien){
        try{
            return pi.getByIdPasien(idPasien);
        }catch(SQLException se){
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String serviceNamaByIdPasien(String idPasien){
        try{
            return pi.namaByIdPasien(idPasien);
        }catch(SQLException se){
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String serviceGenerateIdPasien(){
        try{
            return pi.generateIdPasien();
        }catch(SQLException se){
            Logger.getLogger(PasienService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

}
