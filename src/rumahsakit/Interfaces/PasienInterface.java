/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Interfaces;

import java.sql.SQLException;
import java.util.List;
import rumahsakit.Entity.Pasien;

/**
 *
 * @author asus
 */
public interface PasienInterface {
    public void insertPasien(Pasien p)throws SQLException;
    public void updatePasien(Pasien p, String idPasien)throws SQLException;
    public void deletePasien(String idPasien)throws SQLException;
    public List getAllPasien()throws SQLException;
    public List getByIdPasien(String idPasien)throws SQLException;
    public String namaByIdPasien(String idPasien)throws SQLException;
    public String generateIdPasien()throws SQLException;
}
