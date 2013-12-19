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
import rumahsakit.Dao.DokterDAO;
import rumahsakit.Entity.Dokter;
import rumahsakit.Interfaces.DokterInterface;
import rumahsakit.KoneksiDatabase.KoneksiDB;

/**
 *
 * @author asus
 */
public class DokterService {

    private Connection connection;
    private DokterInterface di;

    public DokterService() {
        this.connection = KoneksiDB.getConnection();
        this.di = new DokterDAO(connection);
    }

    public void serviceInsertDokter(Dokter d){
        try{
            connection.setAutoCommit(false);
            di.insertDokter(d);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceUpdateDokter(Dokter d, String idDokter){
        try{
            connection.setAutoCommit(false);
            di.updateDokter(d, idDokter);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceDeleteDokter(String idDokter){
        try{
            connection.setAutoCommit(false);
            di.deleteDokter(idDokter);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public List serviceGetAllDokter(){
        try{
            return di.getAllDokter();
        }catch(SQLException se){
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetByIdDoker(String idDokter){
        try{
            return di.getByIdDokter(idDokter);
        }catch(SQLException se){
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetByIdSpesialis(String idSpesialis){
        try{
            return di.getByIdSpesialis(idSpesialis);
        }catch(SQLException se){
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String[] serviceNamaDokter(String spesialis, int total){
        try{
            return di.NamaDokter(spesialis, total);
        }catch(SQLException se){
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String serviceTampilIdDokterByNama(String nama){
        try{
            return di.tampilIdByNama(nama);
        }catch(SQLException se){
            Logger.getLogger(DokterService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }



}
