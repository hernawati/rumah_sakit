/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Entity;

/**
 *
 * @author asus
 */
public class Pendaftaran {
    private String noReg;
    private String idPasien;
    private String idDokter;
    private String idJaminan;

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getIdJaminan() {
        return idJaminan;
    }

    public void setIdJaminan(String idJaminan) {
        this.idJaminan = idJaminan;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNoReg() {
        return noReg;
    }

    public void setNoReg(String noReg) {
        this.noReg = noReg;
    }
    
}
