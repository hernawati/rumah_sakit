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
import rumahsakit.Dao.SpesialisDAO;
import rumahsakit.Entity.Spesialis;
import rumahsakit.Interfaces.SpesialisInterface;
import rumahsakit.KoneksiDatabase.KoneksiDB;

/**
 *
 * @author asus
 */
public class SpesialisService {

    private SpesialisInterface si;
    private Connection connection;

    public SpesialisService() {
        connection = KoneksiDB.getConnection();
        si = new SpesialisDAO(connection);
    }

    public void serviceInsertSpesialis(String idSpesialis, Spesialis s){
        try{
            connection.setAutoCommit(false);
            si.insertSpesialis(idSpesialis, s);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public void serviceUpdateSpesialis(Spesialis s, String idSpesialis){
        try{
            connection.setAutoCommit(false);
            si.updateSpesialis(s, idSpesialis);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public void serviceDeleteSpesialis(String idSpesialis){
        try{
            connection.setAutoCommit(false);
            si.deleteSpesialis(idSpesialis);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public List serviceGetAllSpesialis(){
        try{
            return si.getAllSpesialis();
        }catch(SQLException t){
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public String[] serviceGetNamaSpesialis(int b){
        try{
            return si.getNamaSpesialis(b);
        }catch(SQLException t){
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public String serviceGetIDSpesialis(String b){
        try{
            return si.getIDSpesialis(b);
        }catch(SQLException t){
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public List serviceGetByIdSpesialis(String idSpesialis){
        try{
            return si.getByIDSpesialis(idSpesialis);
        }catch(SQLException t){
            Logger.getLogger(SpesialisService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

}
