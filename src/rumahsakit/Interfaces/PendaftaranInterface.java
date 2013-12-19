/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Interfaces;

import java.sql.SQLException;
import rumahsakit.Entity.Pendaftaran;

/**
 *
 * @author asus
 */
public interface PendaftaranInterface {
    public void insertPendaftaran(Pendaftaran p)throws SQLException;
    public String generateNomor(String tanggal)throws SQLException;
}
