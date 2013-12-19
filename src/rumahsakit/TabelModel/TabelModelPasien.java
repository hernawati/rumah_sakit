/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.TabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rumahsakit.Entity.Pasien;

/**
 *
 * @author asus
 */
public class TabelModelPasien extends AbstractTableModel{

    public List<Pasien> list = new ArrayList<Pasien>();

    public void setData(List<Pasien>listPasien){
        this.list = listPasien;
        fireTableDataChanged();
    }

    public Pasien getPasien(int i){
        return list.get(i);
    }


    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID Pasien";
            case 1:
                return "Nama Pasien";
            default:
                return null;
        }
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getIdPasien();
            case 1:
                return list.get(rowIndex).getNmPasien();
        }
        return null;
    }

}