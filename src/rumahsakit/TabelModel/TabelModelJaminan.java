/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.TabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rumahsakit.Entity.Jaminan;

/**
 *
 * @author asus
 */
public class TabelModelJaminan extends AbstractTableModel{

    public List<Jaminan> list = new ArrayList<Jaminan>();

    public void setData(List<Jaminan>listJaminan){
        this.list = listJaminan;
        fireTableDataChanged();
    }

    public Jaminan getJaminan(int i){
        return list.get(i);
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
                return list.get(rowIndex).getIdJaminan();
            case 1:
                return list.get(rowIndex).getNmJaminan();
            default:
                return null;
        }
    }   

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Kode Jaminan";
            case 1:
                return "Nama Jaminan";
        }
        return null;
    }
    
}
