/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Interfaces;

import java.sql.SQLException;
import java.util.List;
import rumahsakit.Entity.Dokter;

/**
 *
 * @author asus
 */
public interface DokterInterface {

    public void insertDokter(Dokter d)throws SQLException;
    public void updateDokter(Dokter d, String idDokter)throws SQLException;
    public void deleteDokter(String idDokter)throws SQLException;
    public List getAllDokter()throws SQLException;
    public List getByIdDokter(String idDokter)throws SQLException;
    public List getByIdSpesialis(String idSpesialis)throws SQLException;
    public String[] NamaDokter(String spesialis, int total)throws SQLException;
    public String tampilIdByNama(String nama)throws SQLException;

}
