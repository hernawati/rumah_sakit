/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.TabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rumahsakit.Entity.Spesialis;

/**
 *
 * @author asus
 */
public class TabelModelSpesialis extends AbstractTableModel{

    public List<Spesialis> list = new ArrayList<Spesialis>();

    public void setData(List<Spesialis>listSpesialis){
        this.list = listSpesialis;
        fireTableDataChanged();
    }

    public Spesialis getSpesialis(int i){
        return list.get(i);
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Kode Spesialis";
            case 1:
                return "Nama Spesialis";
        }
        return null;
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
                return list.get(rowIndex).getIdSpesialis();
            case 1:
                return list.get(rowIndex).getNmSpesialis();
        }
        return null;
    }

}
