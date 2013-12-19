/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.GradientPanel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/**
 *
 * @author asus
 */
public class UniqGradienPanel extends JPanel{

    public UniqGradienPanel() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GradientPaint paint = new GradientPaint(0, 0, new Color(255, 255, 255, 100), getWidth(), getHeight(), new Color(255, 255, 255, 0));
        GeneralPath path = new GeneralPath();
        path.moveTo(0, 0);
        path.lineTo(0, getHeight());
        path.curveTo(0, getHeight(), getWidth() / 5, getHeight() / 5, getWidth(), 0);
        path.closePath();

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(paint);
        g2.fill(path);
        g2.dispose();
    }


}
