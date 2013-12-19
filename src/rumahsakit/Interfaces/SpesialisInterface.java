/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Interfaces;

import java.sql.SQLException;
import java.util.List;
import rumahsakit.Entity.Spesialis;

/**
 *
 * @author asus
 */
public interface SpesialisInterface {
    public void insertSpesialis(String idSpesialis, Spesialis s)throws SQLException;
    public void updateSpesialis(Spesialis s, String idSpesialis)throws SQLException;
    public void deleteSpesialis(String idSpesialis)throws SQLException;

    public List getAllSpesialis()throws SQLException;
    public List getByIDSpesialis(String idSpesialis)throws SQLException;

    public String[] getNamaSpesialis(int b) throws SQLException;
    public String getIDSpesialis(String b) throws SQLException;        
}
