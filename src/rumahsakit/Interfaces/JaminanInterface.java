/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit.Interfaces;

import java.sql.SQLException;
import java.util.List;
import rumahsakit.Entity.Jaminan;

/**
 *
 * @author asus
 */
public interface JaminanInterface {

    public void insertJaminan(String idJaminan, Jaminan j) throws SQLException;

    public void updateJaminan(Jaminan j, String idJaminan) throws SQLException;

    public void deleteJaminan(String idJaminan) throws SQLException;

    public List getAllJaminan() throws SQLException;

    public List getIdJaminan(String idJaminan) throws SQLException;

    public List getNmJaminan(String nmJaminan) throws SQLException;

    public String getMaxIdJaminan() throws SQLException;

    public String[] tampilNamaJaminan(int total)throws SQLException;

    public String getIdJaminanByNama(String nama)throws SQLException;
    
}
