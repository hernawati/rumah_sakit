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
import rumahsakit.Dao.JaminanDAO;
import rumahsakit.Entity.Jaminan;
import rumahsakit.Interfaces.JaminanInterface;
import rumahsakit.KoneksiDatabase.KoneksiDB;

/**
 *
 * @author asus
 */
public class JaminanService {

    private JaminanInterface ji;
    private Connection connection;

    public JaminanService(){
        this.connection = KoneksiDB.getConnection();
        ji = new JaminanDAO(connection);
    }

    public void serviceInsertJaminan(String idJaminan, Jaminan j){
        try{
            connection.setAutoCommit(false);
            ji.insertJaminan(idJaminan, j);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public void serviceUpdateJaminan(Jaminan j, String idJaminan){
        try{
            connection.setAutoCommit(false);
            ji.updateJaminan(j,idJaminan);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public void serviceDeleteJaminan(String idJaminan){
        try{
            connection.setAutoCommit(false);
            ji.deleteJaminan(idJaminan);
            connection.setAutoCommit(true);
        }catch(SQLException t){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException th){
                Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, th);
            }
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public List serviceGetAllJaminan(){
        try{              
            return ji.getAllJaminan();
        }catch(SQLException t){
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public List serviceGetIdJaminan(String idJaminan){
        try{
            return ji.getIdJaminan(idJaminan);
        }catch(SQLException t){
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public List serviceGetNmJaminan(String nmJaminan){
        try{
            return ji.getNmJaminan(nmJaminan);
        }catch(SQLException t){
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public String serviceGetMaxIdJaminan(){
        try{
            return  ji.getMaxIdJaminan();
        }catch(SQLException t){
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public String[] serviceTampilNamaJaminan(int total){
        try{
            return ji.tampilNamaJaminan(total);
        }catch(SQLException se){
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String getIdJaminanByNama(String nama){
        try{
            return ji.getIdJaminanByNama(nama);
        }catch(SQLException se){
            Logger.getLogger(JaminanService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

}
