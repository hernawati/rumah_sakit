/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.TabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rumahsakit.Entity.Dokter;

/**
 *
 * @author asus
 */
public class TabelModelDokter extends AbstractTableModel{

    public List<Dokter> list = new ArrayList<Dokter>();

    public void setData(List<Dokter>listJaminan){
        this.list = listJaminan;
        fireTableDataChanged();
    }

    public Dokter getDokter(int i){
        return list.get(i);
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID Dokter";
            case 1:
                return "Nama Dokter";
            case 2:
                return "Spesialis";
        }
        return null;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getIdDokter();
            case 1:
                return list.get(rowIndex).getNmDokter();
            case 2:
                return list.get(rowIndex).getIdSpesialis();
            default:
                return null;
        }
    }

}
