/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.CustomTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ViewportLayout;
import javax.swing.plaf.basic.BasicTableUI;

/**
 *
 * @author asus
 */
public class CustomTableUI extends BasicTableUI{

    private static final Color EVEN_ROW_COLOR = new Color(241, 245, 250);
    private PropertyChangeListener fAncestorPropertyChangeListener =
            createAncestorPropertyChangeListener();

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        table.addPropertyChangeListener("ancestor", fAncestorPropertyChangeListener);
    }

    private PropertyChangeListener createAncestorPropertyChangeListener() {
        return new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // indicate that the parent of the JTable has changed.
                parentDidChange();
            }
        };
    }

    private void parentDidChange() {
        if (table.getParent() instanceof JViewport && table.getParent().getParent() instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
            scrollPane.getViewport().setLayout(new BugFixedViewportLayout());
        }
    }


    @Override
    public void paint(Graphics g, JComponent c) {
        int rowAtPoint = table.rowAtPoint(g.getClipBounds().getLocation());
        int topY = rowAtPoint < 0 ? g.getClipBounds().y : table.getCellRect(rowAtPoint, 0, true).y;
        int currentRow = rowAtPoint < 0 ? 0 : rowAtPoint;
        while (topY < g.getClipBounds().y + g.getClipBounds().height) {
            int bottomY = topY + table.getRowHeight();
            g.setColor(getRowColor(currentRow));
            g.fillRect(g.getClipBounds().x, topY, g.getClipBounds().width, bottomY);
            topY = bottomY;
            currentRow++;
        }

        super.paint(g, c);
    }

    private Color getRowColor(int row) {
        return row % 2 == 0 ? EVEN_ROW_COLOR : table.getBackground();
    }

    // Memodifikasi Viewport untuk JTable
    private class BugFixedViewportLayout extends ViewportLayout {

        @Override
        public void layoutContainer(Container parent) {
            JViewport vp = (JViewport) parent;
            Component view = vp.getView();

            if (view == null) {
                return;
            }

            Point viewPosition = vp.getViewPosition();
            Dimension viewPrefSize = view.getPreferredSize();
            Dimension vpSize = vp.getSize();
            Dimension viewSize = new Dimension(viewPrefSize);

            if ((viewPosition.x == 0) && (vpSize.width > viewPrefSize.width)) {
                viewSize.width = vpSize.width;
            }

            if ((viewPosition.y == 0) && (vpSize.height > viewPrefSize.height)) {
                viewSize.height = vpSize.height;
            }

            if (!viewSize.equals(viewPrefSize)) {
                vp.setViewSize(viewSize);
            }
        }
    }

}
